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
import dev.jamesyox.svgk.attr.ConstantSvgAttributeType
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.WrappedListSvgAttributeType
import dev.jamesyox.svgk.meta.noGet

/**
 * The `paint-order` attribute specifies the order that the fill, stroke, and markers of a given shape or text element
 * are painted.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PaintOrder
)
public var paintOrder: PaintOrder
    get() = noGet()
    set(value) {
        ac["paint-order"] = value.svgString
    }

public sealed interface PaintOrder : SvgAttributeType {
    /**
     & This value indicates that the `fill` will be painted first, then the `stroke`, and finally the `marker`s.
     */
    public data object Normal : PaintOrder, ConstantSvgAttributeType("normal")

    /**
     * The order of these three keywords indicates the order in which the painting happens, from left to right.
     * If any of the three painting components is omitted, they will be painted in their default order after
     * the specified components. For example, using stroke is equivalent to `stroke` fill markers.
     */
    public class Specified(
        public val value: List<Painting>,
    ) : WrappedListSvgAttributeType(list = value, separator = " "),
        PaintOrder {
        public enum class Painting(
            override val svgString: String,
        ) : SvgAttributeType {
            Fill("fill"),
            Stroke("stroke"),
            Markers("markers"),
        }
    }
}
