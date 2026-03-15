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
import dev.jamesyox.svg4k.attr.ConstantSvgAttributeType
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.WrappedSvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.Marker

/**
 * For [Marker], `refX` defines the x coordinate of the marker's reference point, which is to be placed exactly
 * at the marker's position on the shape.
 *
 * For [dev.jamesyox.svg4k.tags.Symbol], `refX` defines the `x` coordinate of the symbol, which is defined by the
 * cumulative effect of the x attribute and any transformations on the [dev.jamesyox.svg4k.tags.Symbol] and its
 * host [dev.jamesyox.svg4k.tags.Use] element.
 *
 * Unlike other positioning attributes, `refX` is interpreted as being in the coordinate system of the symbol
 * contents, after application of the viewBox and preserveAspectRatio attributes. If the attribute is not
 * specified, no horizontal adjustment is made, and the left side of the symbol's rectangular viewport region
 * (regardless of the viewBox coordinate) is positioned at the x coordinate.
 */
context(
    ac: AttributeConsumer,
    _: Marker
)
public var refX: RefX
    get() = noGet()
    set(value) {
        ac["refX"] = value
    }

public sealed interface RefX : SvgAttributeType {
    /**
     * The reference point of the marker is placed at the left edge of the shape.
     */
    public data object Left : RefX, ConstantSvgAttributeType("left")

    /**
     * The reference point of the marker is placed at the horizontal center of the shape.
     */
    public data object Center : RefX, ConstantSvgAttributeType("center")

    /**
     * The reference point of the marker is placed at the right edge of the shape.
     */
    public data object Right : RefX, ConstantSvgAttributeType("right")

    /**
     * Lengths are interpreted as being in the coordinate system of the marker contents, after application of the
     * [viewBox] and [preserveAspectRatio] attributes.
     *
     * Percentage values are interpreted as being a percentage of the [viewBox] height.
     */
    public class Value(
        public val value: LengthOrPercentage,
    ) : WrappedSvgAttributeType(value),
        RefX
}

/**
 * Unsafe version of RefX. Functionality depends on what [dev.jamesyox.svg4k.SvgTag] is the parent.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.RefX
)
public var refX: RefX
    get() = noGet()
    set(value) {
        ac["refX"] = value
    }
