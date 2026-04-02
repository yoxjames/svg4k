## 0.1.0-alpha.3
* Removed `BasicShape` from `clipPath` attribute. This really feels like mixing the CSS and SVG spec to me and I want
  this library to be purely SVG. From what I can tell the SVG 1.1 spec only really supports FuncIRI notation.
* Added a `SvgColor` type and replaced the string typing on numerous attributes that use color.
* Added a `SvgPaint` type and used that on some attributes.
* Added a `SvgId` type to be used with `id` attributes and added lots of convenience methods to take care of id
  resources and url to ID resources. 
## 0.1.0-alpha.2 
* `get()` methods on svg attributes can no longer by called in Kotlin.
  * Previously they could throw. This should make it so that cannot happen if someone does this by mistake.
* Made `Url(...)`'s constructor public and added a convenience `url(...)` function to call the constructor as this
  matches SVG's url call quite well.
* Added convenience method to `repeatDur` so `repeatDur` can be called with a `Duration` (ex `repeatDur(10.seconds)`)
* Added convenience method to `dur` so `dur` can be called with a `Duration` (ex `dur(10.seconds)`)
* `DelayedTagConsumer` will now throw if you attempt to set elements after starting a child element.
  * This mirrors the behavior of `kotlinx-html` but I'll be honest that I don't like it.
  * Prior to this change attributes would simply disappear if they were after a child element.
  * This affects `svgString { ... }` and any `Appendable` SVG builder.
  * This does not affect DOM based builders