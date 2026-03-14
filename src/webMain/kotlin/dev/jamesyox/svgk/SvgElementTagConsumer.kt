/*
 * Copyright 2026 James Yox
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package dev.jamesyox.svgk

import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.consumers.onFinalize
import dev.jamesyox.svgk.meta.RootContainer
import dev.jamesyox.svgk.tags.Svg
import dev.jamesyox.svgk.tags.categories.container.AllElementContainer
import dev.jamesyox.svgk.tags.meta.UnsafeContainer
import dev.jamesyox.svgk.tags.svg
import kotlinx.browser.document
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.get
import org.w3c.dom.svg.SVGElement
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/*
 * A lot of this was based heavily on the approach used in kotlinx-html for tag consumption.
 * https://github.com/Kotlin/kotlinx.html
 */
internal class SvgElementTagConsumer(
    private val document: Document,
) : TagConsumer<SVGElement>,
    AttributeConsumer {
    private val domStack = arrayListOf<SVGElement>()
    private var rootElement: SVGElement? = null

    override val attributeConsumer: AttributeConsumer get() = SvgElementAttributeConsumer(domStack.last())

    private var last: SVGElement? = null

    override fun set(key: String, value: String) {
        attributeConsumer[key] = value
    }

    override fun get(key: String): String? = attributeConsumer[key]

    override val attributesMap: Map<String, String> get() {
        return (0 until (last?.attributes?.length ?: 0) step 1)
            .mapNotNull {
                last?.attributes?.item(it)?.let { attr -> Pair(attr.name, attr.value) }
            }.toMap()
    }

    override fun onTagStart(tag: SvgTag) {
        val element: SVGElement =
            document.createElementNS(
                namespace = "http://www.w3.org/2000/svg",
                qualifiedName = tag.tagName,
            ) as SVGElement

        if (domStack.isNotEmpty()) {
            domStack.last().appendChild(element)
        } else {
            rootElement = element
        }
        domStack.add(element)
    }

    override fun onTagContent(content: String) {
        domStack.last().textContent = content
    }

    override fun onTagEnd(tag: SvgTag) {
        if (domStack.isEmpty() || domStack.last().tagName.lowercase() != tag.tagName.lowercase()) {
            throw IllegalStateException("We haven't entered tag ${tag.tagName} but trying to leave")
        }
        last = domStack.removeAt(domStack.lastIndex)
    }

    override fun output(): SVGElement {
        return last!!
    }
}

@IgnorableReturnValue
public fun Node.appendSvg(
    block: context(TagConsumer<SVGElement>, Svg, AttributeConsumer) () -> Unit
): SVGElement {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return createSvg(block).also { appendChild(it) }
}

@IgnorableReturnValue
public fun Node.replaceSvg(block: context(TagConsumer<SVGElement>, Svg, AttributeConsumer) () -> Unit): SVGElement {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    for (_ in 0 until childNodes.length) {
        // Yes you read this right. Remove child zero. The DOM is mutable so 0 is the new element.
        // You have to love the wonderful mutable world of web!
        childNodes[0]?.let { removeChild(it) }
    }
    return createSvg(block).also { appendChild(it) }
}

public fun createSvg(block: context(TagConsumer<SVGElement>, Svg, AttributeConsumer) () -> Unit): SVGElement {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return context(RootContainer) { SvgElementTagConsumer(document).apply { svg { block() } } }.output()
}

public fun createSvgFragment(
    block: context(TagConsumer<SVGElement>, AllElementContainer) () -> Unit
): List<SVGElement> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val list = mutableListOf<SVGElement>()
    val tagConsumer = SvgElementTagConsumer(document)
    context(UnsafeContainer) {
        tagConsumer.onFinalize { element, isPartial ->
            if (!isPartial) {
                list.add(element)
            }
        }.apply { block() }
        return list
    }
}

