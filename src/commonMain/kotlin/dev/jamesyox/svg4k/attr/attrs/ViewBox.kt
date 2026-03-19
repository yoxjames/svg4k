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
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `viewBox` attribute defines the position and dimension, in user space, of an SVG viewport.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.ViewBox
)
public var viewBox: ViewBox
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["viewBox"] = value
    }

/**
 * A [ViewBox] is a rectangle in user space mapped to the bounds of the viewport of an SVG element
 * (not the browser viewport). When an SVG contains a [viewBox] attribute (often in combination with a
 * [preserveAspectRatio] attribute), a transform stretches or resizes the SVG viewport to fit a particular
 * container element.
 *
 * @param minX: The smallest X coordinates that the view box may have (the origin X coordinate of the view box)
 * @param minY: The smallest Y coordinates that the view box may have (the origin Y coordinate of the view box)
 * @height: The height of the view box (size)
 * @width: The width of the view box (size).
 */
public class ViewBox(
    minX: Number,
    minY: Number,
    width: Number,
    height: Number,
) : SvgAttributeType {
    override val svgString: String = "$minX $minY $width $height"
}
