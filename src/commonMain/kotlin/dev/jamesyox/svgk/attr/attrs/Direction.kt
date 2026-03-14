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
 * The direction attribute specifies the inline-base direction of a <text> or <tspan> element.
 * It defines the start and end points of a line of text as used by the text-anchor and inline-size properties.
 * It also may affect the direction in which characters are positioned if the unicode-bidi property's value is
 * either embed or bidi-override.

 * It applies only to glyphs oriented perpendicular to the inline-base direction, which includes the usual case of
 * horizontally-oriented Latin or Arabic text and the case of narrow-cell Latin or Arabic characters rotated 90 degrees
 * clockwise relative to a top-to-bottom inline-base direction.

 * In many cases, the bidirectional Unicode algorithm produces the desired result automatically, so this attribute
 * doesn't need to be specified in those cases. For other cases, such as when using right-to-left languages,
 * it may be sufficient to add the direction attribute to the outermost <svg> element, and allow that direction to
 * inherit to all text elements:
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Direction
)
public var direction: Direction
    get() = noGet()
    set(value) {
        ac["direction"] = value
    }

public enum class Direction(
    override val svgString: String,
) : SvgAttributeType {
    LTR("ltr"),
    RTL("rtl"),
}

public val LeftToRight: Direction = Direction.LTR
public val RightToLeft: Direction = Direction.RTL
