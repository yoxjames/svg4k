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
import dev.jamesyox.svgk.meta.noGet

/**
 * Specifies the color space for imaging operations performed via filter effects.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.ColorInterpolationFilters,
)
public var colorInterpolationFilters: ColorInterpolationFilters
    get() = noGet()
    set(value) {
        ac["color-interpolation-filters"] = value.svgString
    }

public enum class ColorInterpolationFilters(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Indicates that the user agent can choose either the sRGB or linearRGB spaces for color interpolation. This option
     * indicates that the author doesn't require that color interpolation occur in a particular color space.
     */
    Auto("auto"),

    /**
     * Indicates that color interpolation should occur in the sRGB color space.
     */
    SRGB("sRGB"),

    /**
     * Indicates that color interpolation should occur in the linearized RGB color space as described in the [sRGB
     * specification](https://webstore.iec.ch/en/publication/6169).
     */
    LinearRGB("linearRGB"),
}
