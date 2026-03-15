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
 * The `shape-rendering` attribute provides hints to the renderer about what tradeoffs to make when rendering
 * shapes like paths, circles, or rectangles.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.ShapeRendering
)
public var shapeRendering: ShapeRendering
    get() = noGet()
    set(value) {
        ac["shape-rendering"] = value
    }

public enum class ShapeRendering(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the user agent shall make appropriate tradeoffs to balance speed, crisp edges and
     * geometric precision, but with geometric precision given more importance than speed and crisp edges.
     */
    Auto("auto"),

    /**
     * This value indicates that the user agent shall emphasize rendering speed over geometric precision
     * and crisp edges. This option will sometimes cause the user agent to turn off shape anti-aliasing.
     */
    OptimizeSpeed("optimizeSpeed"),

    /**
     * This value indicates that the user agent shall attempt to emphasize the contrast between clean edges of
     * artwork over rendering speed and geometric precision. To achieve crisp edges, the user agent might turn off
     * anti-aliasing for all lines and curves or possibly just for straight lines which are close to vertical or
     * horizontal. Also, the user agent might adjust line positions and line widths to align edges with device pixels.
     */
    CrispEdges("crispEdges"),

    /**
     * Indicates that the user agent shall emphasize geometric precision over speed and crisp edges.
     */
    GeometricPrecision("geometricPrecision"),
}
