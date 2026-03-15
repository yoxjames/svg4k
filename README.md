# svg4k
This library is an implementation of the current [second edition of the SVG 1.1 spec](https://www.w3.org/TR/SVG11/) 
as a Kotlin DSL (or type safe builder). This library strives for maximal type safety and the avoidance of string typing 
as much as possible. This library makes use of the currently experimental multiple 
[context parameters](https://kotlinlang.org/docs/context-parameters.html) feature in Kotlin. The library's design 
(and some of the implementation) is based on [kotlinx-html](https://github.com/Kotlin/kotlinx.html). 
Like kotlinx-html, this library is fully multiplatform and can generate DOM elements on the js and wasmJs targets.

## Current State
This library is essentially a work in progress that I have decided to do in the public view. That means that in the
current state, this library is not up to my standards for "open source." I encourage you to try it out if you found this
page but be aware that there may be bugs. See the section below on the `unsafe` API for says to get around any bugs you
face. I encourage feedback and plan to continue developing this into a high quality open source library.

## Getting Started

<< Insert Gradle Instructions Here>>

You are now free to use this in a toy project, however you _must_ enable context parameters. This library is based around
that feature.

```kotlin
// build.gradle.kts
kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
}
// ....
implementation("dev.jamesyox:svg4k:0.1.0-SNAPSHOT")
```

### Stream
If you are familiar with the `kotlinx-html` then the syntax should feel pretty familiar:
```kotlin
val svgStr = svgString(isPrettyPrint = true) {
    svg {
        width = 120.none
        height = 120.none
        viewBox = ViewBox(0, 0, 120, 120)
        polygon {
            points = listOf(
                Point(60, 30),
                Point(90, 90),
                Point(30, 90)
            )
            animateTransform {
                attributeName = "transform"
                attributeType = AttributeType.XML
                type = AnimateTransformType.Rotate
                from = "0 60 70"
                to = "360 60 70"
                dur = Dur.ClockValue(10.seconds)
                repeatCount = RepeatCount.Indefinite
            }
        }
    }
}
println(svgString)
```
Would output
```
<svg
    xmlns="http://www.w3.org/2000/svg"
    viewBox="0 0 100 100">
    <a
        href="/docs/Web/SVG/Reference/Element/circle">
        <circle
            cx="50"
            cy="40"
            r="35" />
    </a>
    <a
        href="/docs/Web/SVG/Reference/Element/text">
        <text
            x="50"
            y="90"
            text-anchor="middle">
            &lt;circle&gt;
        </text>
    </a>
</svg>
```

I eventually plan to add more docs but a good overview of the syntax can be found in the tests I have written so far.

<< Insert link to test directory >>

Also like `kotlinx-html` this builder can be used on any `Appendable`. This is done with the `appendSVG { ... }` 
extension fun.

On JVM this could be used to create a file like:
```kotlin
FileWriter("image.svg").use { it.appendSVG { svg { /* ... */ } } }
```

### DOM
Like `kotlinx-html` this project can be used on Js and WasmJS to generate DOM elements instead of just text. For
example:

```kotlin
// Available only in JS and WasmJS source sets
val rect: SVGElement // Allowed since this uses the `callsInPlace` Contract. You can use this to add listeners, etc.
val domElement: SVGElement = createSvg {
    svg {
        rect = rect {
            // ...
        }
    }
}

domElement.onclick = { /* ... */ } // This is a DOM element so you can use browser DOM methods
rect.onclick = { /* ... */ } // Same here.
```

## Using with kotlinx-html
As of today (though I hope to get a PR into kotlinx-html that will make this better), there's not a great way to interop
with `kotlinx-html`. Ideally I want to do something like this:
```kotlin
html { // kotlinx-html
    body { // kotlin-html
        svg { // svg4k >>> THIS DOES NOT CURRENTLY WORK
            // ... // svg4k
        }
    }
}
```
With context parameters this should be possible. On most targets it pretty much is. You could easily write an extension
like this:

```kotlin
private fun HTMLTag.svg4k(
    block: context(AttributeConsumer, @SvgTagDSL Svg) () -> Unit
) {
    unsafe {
        raw(svgString { dev.jamesyox.svg4k.tags.svg { block() } })
    }
}
```

This function bridges `kotlinx-html` to `svg4k` by basically tapping into the unsafe raw text api 
from `kotlinx-html`. This works for many use cases but if you attempt this same approach on a `TagConsumer<T>` that uses
the DOM, this will not work. Appending text will not generate dom elements. For that you'll need something much more
ugly like this:

```kotlin
fun <T> TagConsumer<HTMLElement>.svgMagick(
  block: context(dev.jamesyox.svg4k.TagConsumer<SVGElement>, RootContainer) () -> T
): T {
  val tagConsumer = JsDomTagConsumer(document)
  val output = block(tagConsumer, RootContainer)
  val svgDom = tagConsumer.output()
  val hackDiv = div { } // We simply need to create a DOM element to access the parent (wasteful)
  val currentNode = hackDiv.parentNode
  currentNode?.removeChild(hackDiv)

  currentNode?.let {
    svgDom.forEach { child -> it.appendChild(child) }
  }
  return output
}
```
This is not super ideal, and I am planning to open a PR for `kotlinx-html` to open up better interop pathways, but I 
don't know if that'll get merged or when. I'll update here once I have the PR open. For now above is my best suggestion
even if it's not super ideal.

## Unsafe DSL
This library may have bugs. A lot of those bugs may be around typing and scoping. Lets say for some reason `cx` was
now allowed on `Circle` elements. You could force the issue like this:

```kotlin
circle {
    unsafe { // Any attribute is allowed here
        cx = 5.none
    }
}
```

You can also create invalid svg element hierarchies. Like normally you cant have a `circle` inside of a `circle` but 
with the `Unsafe` API you can do anything you want, no matter how unwise! Generally this is intended to work around bugs
by providing a version of the API with some type checking off.

```kotlin
circle {
    unsafe {
        circle { /* ... */ }
    }
}
```

Would yield the invalid `<circle><circle></circle></circle>` result.

### Manual Attributes
`unsafe { ... }` also allows you to add arbitrary references. For instance:
```kotlin
val expected = """
    <svg
        xmlns="http://www.w3.org/2000/svg">
        <circle
            not-real="madeup" />
    </svg>
""".trimIndent()
val actual = svgString(isPrettyPrint = true) {
    svg {
        circle {
            unsafe {
                attr["not-real"] = "madeup"
            }
        }
    }
}
assertEquals(expected, actual)
```
In this case we used `attr` which is available inside the `unsafe` scope to add an attribute called `not-real` and set
it to `madeup`. You can use this to set attributes that exist to arbitrary values as well.

### Custom Elements
You can also use `unsafe { ... }` to construct arbitrary elements via `customElement(...)`:
```kotlin
val expected = """
    <svg
        xmlns="http://www.w3.org/2000/svg">
        <fake
            fr="5">
            <circle />
        </fake>
    </svg>
""".trimIndent()
val actual = svgString(isPrettyPrint = true) {
    svg {
        unsafe {
            // Create element <fake>
            customElement("fake") {
                // Any attribute can be used in custom elements
                fr = 5.none
                // Any elements can be added to custom elements
                circle {

                }
            }
        }
    }
}
```

### Cascading Unsafe
Unsafe is meant to work around issues you may find in the library or perhaps to do things I had not considered. However,
it does have some limitations. One big one is that `unsafe { ... }` only makes things unsafe inside the lambda provided.

For instance, you cannot do something like:

```kotlin
circle {
    unsafe {
        // unsafe applies at this level!
        rect { // This compiles but is not a valid SVG!
            // unsafe does not apply at this level!
            fr = 5.none // `fr` does not apply to rect so this wont compile!
        }
    }
}
```
This won't be allowed even with unsafe because `unsafe { ... }` is marked with the `SvgTagDsl` marker which is marked
with `DskMarker`.

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-dsl-marker/

If you want to truly turn off safety you'll need the `unsafeCascading { ... }` function which starts an unsafe scope
with no DSL marker letting you go wild:

```kotlin
circle {
    unsafeCascading {
        // unsafeCascading applies at this level!
        rect { // This compiles but is not a valid SVG!
            // unsafe still applies at this level too!
            fr = 5.none // This compiles but is not a valid SVG!
        }
    }
}
```

## Contributing
Contributions are welcome. If you find a bug and want to fix it, feel free to do so and open a PR. Additionally, if you
are looking for places to contribute, simply search for TODO and you'll see every area I have identified as lacking and
want to address prior to release. There's a lot of work still to be done!

## Citations
* A lot of this project was inspired by `kotlinx-html` by JetBrains, the overall design was reused but reimagined using multiple context parameters. A lot of the tag consumption logic was based on the tag consumption in kotlinx-html
  
  https://github.com/Kotlin/kotlinx.html
* The documentation and visibility of each element/attribution on specific parents was largely based on Mozilla's SVG documentation. I highly recommend this as a resource to anyone wanting to learn more about SVG. A lot of my test cases come from examples in this document.
  
  https://developer.mozilla.org/en-US/docs/Web/SVG
* Last but not least is the actual SVG 1.1 spec which is the actual protocol this library models.
  
  https://www.w3.org/TR/SVG11/