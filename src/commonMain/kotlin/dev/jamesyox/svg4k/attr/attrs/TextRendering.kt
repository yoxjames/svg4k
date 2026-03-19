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

// TODO: I am not 100% sure which elements this can be applied to. Made an educated guess.

/**
 * The `text-rendering` attribute provides hints to the renderer about what tradeoffs to make when rendering text.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.TextRendering
)
public var textRendering: TextRendering
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["text-rendering"] = value
    }

public enum class TextRendering(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the user agent shall make appropriate tradeoffs to balance speed, legibility
     * and geometric precision, but with legibility given more importance than speed and geometric precision.
     */
    Auto("auto"),

    /**
     * This value indicates that the user agent shall emphasize rendering speed over legibility and geometric
     * precision. This option will sometimes cause some user agents to turn off text anti-aliasing.
     */
    OptimizeSpeed("optimizeSpeed"),

    /**
     * This value indicates that the user agent shall emphasize legibility over rendering speed and geometric
     * precision. The user agent will often choose whether to apply anti-aliasing techniques, built-in font hinting
     * or both to produce the most legible text.
     */
    OptimizeLegibility("optimizeLegibility"),

    /**
     * This value indicates that the user agent shall emphasize geometric precision over legibility and rendering speed.
     * This option will usually cause the user agent to suspend the use of hinting so that glyph outlines are drawn
     * with comparable geometric precision to the rendering of path data.
     */
    GeometricPrecision("geometricPrecision"),
}
