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
import dev.jamesyox.svg4k.tags.Symbol
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * For [Marker], `refX` defines the x coordinate of the marker's reference point, which is to be placed exactly
 * at the marker's position on the shape.
 *
 * For [Symbol], `refY` defines the `y` coordinate of the symbol, which is defined by the cumulative effect of the
 * `y` attribute and any transformations on the [Symbol] and its host [dev.jamesyox.svg4k.tags.Use] element.
 *
 * Unlike other positioning attributes, `refY` is interpreted as being in the coordinate system of the symbol
 * contents, after application of the viewBox and preserveAspectRatio attributes. If the attribute is not specified,
 * no vertical adjustment is made, and the top side of the symbol's rectangular viewport region (regardless of the
 * viewBox coordinate) is positioned at the y coordinate.
 */
context(
    ac: AttributeConsumer,
    _: Marker
)
public var refY: RefY
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["refY"] = value
    }

public sealed interface RefY : SvgAttributeType {
    /**
     * The reference point of the marker is placed at the top edge of the shape.
     */
    public data object Top : RefY, ConstantSvgAttributeType("top")

    /**
     * The reference point of the marker is placed at the vertical center of the shape.
     */
    public data object Center : RefY, ConstantSvgAttributeType("center")

    /**
     * The reference point of the marker is placed at the bottom edge of the shape.
     */
    public data object Bottom : RefY, ConstantSvgAttributeType("bottom")

    /**
     * Lengths are interpreted as being in the coordinate system of the marker contents, after application of the
     * [viewBox] and [preserveAspectRatio] attributes.
     *
     * Percentage values are interpreted as being a percentage of the [viewBox] height.
     */
    public class Value(
        public val value: LengthOrPercentage,
    ) : WrappedSvgAttributeType(value),
        RefY
}

/**
 * Unsafe version of RefY. Functionality depends on what [dev.jamesyox.svg4k.SvgTag] is the parent.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.RefY
)
public var refY: RefY
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["refX"] = value
    }
