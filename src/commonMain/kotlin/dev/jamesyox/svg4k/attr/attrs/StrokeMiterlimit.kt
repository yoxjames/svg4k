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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.meta.noGet

/**
 * *The `stroke-miterlimit` attribute is a presentation attribute defining a limit on the ratio of the miter length to
 * the [strokeWidth] used to draw a miter join. When the limit is exceeded,
 * the join is converted from a miter to a bevel.
 *
 * When two line segments meet at a sharp angle and miter joins have been specified for [strokeLinejoin],
 * it is possible for the miter to extend far beyond the thickness of the line stroking the path. The [strokeMiterlimit]
 * ratio is used to define when the limit is exceeded, if so the join is converted from a miter to a bevel.
 *
 * The ratio of miter length (distance between the outer tip and the inner corner of the miter)
 * to stroke-width is directly related to the angle (theta) between the segments in user space by the formula:
 *
 * `stroke-miterlimit=miterLengthstroke-width=1sin(θ2)`
 *
 * For example, a miter limit of 1.414 converts miters to bevels for theta less than 90 degrees,
 * a limit of 4.0 converts them for theta less than approximately 29 degrees, and a limit of 10.0 converts
 * them for theta less than approximately 11.5 degrees.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.StrokeMiterlimit
)
public var strokeMiterlimit: Number
    get() = noGet()
    set(value) {
        ac["stroke-miterlimit"] = value.svgString
    }
