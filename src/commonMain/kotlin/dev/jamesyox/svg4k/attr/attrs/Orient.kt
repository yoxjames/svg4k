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
import dev.jamesyox.svg4k.attr.types.obj.AngleValue
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `orient` attribute indicates how a marker is rotated when it is placed at its position on the shape.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Orient
)
public var orient: Orient
    get() = noGet()
    set(value) {
        ac["orient"] = value.svgString
    }

public sealed interface Orient : SvgAttributeType {
    /**
     * This value indicates that the marker is oriented such that its positive x-axis is pointing in a direction
     * relative to the path at the position the marker is placed.
     */
    public data object Auto : Orient, ConstantSvgAttributeType("auto")

    /**
     * If placed by [markerStart], the marker is oriented `180°` different from the orientation that would be used
     * if [Auto] were specified. For all other markers, this means the same as auto.
     */
    public data object AutoStartReverse : Orient, ConstantSvgAttributeType("auto-start-reverse")

    /**
     * This value indicates that the marker is oriented such that the specified angle is that measured between
     * the shape's positive x-axis and the marker's positive x-axis.
     */
    public class Angle(
        public val value: AngleValue,
    ) : WrappedSvgAttributeType(value),
        Orient
}
