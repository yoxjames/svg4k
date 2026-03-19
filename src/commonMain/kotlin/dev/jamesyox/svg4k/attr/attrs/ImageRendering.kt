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
 * The `image-rendering` attribute provides a hint to the browser about how to make speed vs. quality tradeoffs as it
 * performs image processing.
 *
 * The resampling is always done in a true color (e.g., 24-bit) color space even if the original data and/or the target
 * device is indexed color.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.ImageRendering
)
public var imageRendering: FillRule
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["filter"] = value
    }

public enum class ImageRendering(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Indicates that the user agent shall make appropriate tradeoffs to balance speed and quality, but quality
     * shall be given more importance than speed.
     */
    Auto("auto"),

    /**
     * Indicates that the user agent shall make appropriate tradeoffs to balance speed and quality,
     * but quality shall be given more importance than speed.
     */
    OptimizeSpeed("optimizeSpeed"),

    /**
     * Indicates that the user agent shall emphasize quality over rendering speed.
     */
    OptimizeQuality("optimizeQuality"),
}
