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
import org.w3c.dom.svg.SVGElement

public class SvgElementAttributeConsumer(
    private val svgElement: SVGElement,
) : AttributeConsumer {
    override fun set(
        key: String,
        value: String,
    ) {
        svgElement.setAttribute(key, value)
    }

    override fun get(key: String): String? = svgElement.getAttribute(key)

    override val attributesMap: Map<String, String> get() {
        return (0 until svgElement.attributes.length step 1)
            .mapNotNull {
                svgElement.attributes.item(it)?.let { attr -> Pair(attr.name, attr.value) }
            }.toMap()
    }
}

public fun <T> SVGElement.attrs(block: AttributeConsumer.() -> T): T = SvgElementAttributeConsumer(this).let(block)
