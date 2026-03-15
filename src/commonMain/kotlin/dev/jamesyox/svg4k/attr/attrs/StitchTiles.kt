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
 * The `stitchTiles` attribute defines how the Perlin Noise tiles behave at the border.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.StitchTiles
)
public var stitchTiles: StitchTiles
    get() = noGet()
    set(value) {
        ac["stitchTiles"] = value
    }

public enum class StitchTiles(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that no attempt is made to achieve smooth transitions at the border of tiles which
     * contain a turbulence function. Sometimes the result will show clear discontinuities at the tile borders.
     */
    NoStitch("noStitch"),

    /**
     * This value indicates that the user agent will automatically adjust the x and y values of the base frequency
     * such that the [dev.jamesyox.svg4k.tags.FeTurbulence] node's width and height (i.e., the width and height
     * of the current subregion) contain an integral number of the tile width and height for the first octave.
     */
    Stitch("stitch"),
}
