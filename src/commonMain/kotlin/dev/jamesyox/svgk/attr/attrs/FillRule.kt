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
 * The fill-rule attribute is a presentation attribute defining the algorithm to use to determine the inside part of a
 * shape.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FillRule
)
public var fillRule: FillRule
    get() = noGet()
    set(value) {
        ac["fill-rule"] = value
    }

public enum class FillRule(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * The value nonzero determines the "insideness" of a point in the shape by drawing a ray from that point to
     * infinity in any direction, and then examining the places where a segment of the shape crosses the ray.
     * Starting with a count of zero, add one each time a path segment crosses the ray from left to right and subtract
     * one each time a path segment crosses the ray from right to left. After counting the crossings, if the result is
     * zero then the point is outside the path. Otherwise, it is inside.
     */
    Nonzero("nonzero"),

    /**
     * The value evenodd determines the "insideness" of a point in the shape by drawing a ray from that point to
     * infinity in any direction and counting the number of path segments from the given shape that the ray crosses.
     * If this number is odd, the point is inside; if even, the point is outside.
     */
    Evenodd("evenodd"),
}
