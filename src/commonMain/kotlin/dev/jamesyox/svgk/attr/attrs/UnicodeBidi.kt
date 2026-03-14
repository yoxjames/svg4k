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

package dev.jamesyox.svgk.attr.attrs

import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.AttributeContainer
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.meta.noGet

/**
 * The `unicode-bidi` attribute specifies how the accumulation of the background image is managed
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.UnicodeBidi
)
public var unicodeBidi: UnicodeBidi
    get() = noGet()
    set(value) {
        ac["unicode-bidi"] = value
    }

public enum class UnicodeBidi(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * The element does not offer an additional level of embedding with respect to the bidirectional algorithm.
     * For inline elements, implicit reordering works across element boundaries.
     */
    Normal("normal"),

    /**
     * If the element is inline, this value opens an additional level of embedding with respect to the bidirectional
     * algorithm. The direction of this embedding level is given by the [direction] property.
     */
    Embed("embed"),

    /**
     * This keyword indicates that the element's container directionality should be calculated without considering
     * the content of this element. The element is therefore isolated from its siblings. When applying its
     * bidirectional-resolution algorithm, its container element treats it as one or several `U+FFFC Object Replacement
     * Character`, i.e., like an image.
     */
    Isolate("isolate"),

    /**
     * For inline elements this creates an override. For block container elements this creates an override for
     * inline-level descendants not within another block container element. This means that inside the element,
     * reordering is strictly in sequence according to the [direction] property; the implicit part of the bidirectional
     * algorithm is ignored.
     */
    BidiOverride("bidi-override"),

    /**
     * This keyword applies the isolation behavior of the isolate keyword to the surrounding content and the
     * override behavior of the `bidi-override` keyword to the inner content.
     */
    IsolateOverride("isolate-override"),

    /**
     * This keyword makes the elements directionality calculated without considering its parent bidirectional state
     * or the value of the [direction] property. The directionality is calculated using the P2 and P3 rules of the
     * Unicode Bidirectional Algorithm. This value allows the display of data that is already formatted using a tool
     * following the Unicode Bidirectional Algorithm.
     */
    Plaintext("plaintext"),
}
