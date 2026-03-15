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

package dev.jamesyox.svg4k.attr.attrs

import dev.jamesyox.svg4k.attr.AttributeConsumer
import dev.jamesyox.svg4k.attr.AttributeContainer
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `writing-mode` attribute specifies whether the initial inline-progression-direction for a
 * [dev.jamesyox.svg4k.tags.Text] element shall be left-to-right, right-to-left, or top-to-bottom.
 * The writing-mode attribute applies only to [dev.jamesyox.svg4k.tags.Text] elements; the attribute is ignored
 * for [dev.jamesyox.svg4k.tags.Tspan] and [dev.jamesyox.svg4k.tags.TextPath] sub-elements.
 * (Note that the inline-progression-direction can change within a <text> element due to the Unicode bidirectional
 * algorithm and properties direction and unicode-bidi.)
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.WritingMode
)
public var whiteSpace: WhiteSpace
    get() = noGet()
    set(value) {
        ac["writing-mode"] = value
    }

public enum class WritingMode(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value defines a top-to-bottom block flow direction. Both the writing mode and the typographic mode are
     * horizontal.
     */
    HorizontalTb("horizontal-tb"),

    /**
     * This value defines a right-to-left block flow direction. Both the writing mode and the typographic mode are
     * vertical.
     */
    VerticalRl("vertical-rl"),

    /**
     * This value defines a left-to-right block flow direction. Both the writing mode and the typographic mode are
     * vertical.
     */
    VerticalLr("vertical-lr"),
}
