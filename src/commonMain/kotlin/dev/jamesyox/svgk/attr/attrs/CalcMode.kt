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
 * The `calcMode` attribute specifies the interpolation mode for the animation.
 *
 * The default mode is [CalcMode.Linear], however if the attribute does not support linear interpolation (e.g., for strings),
 * the calcMode attribute is ignored and discrete interpolation is used.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.CalcMode
)
public var calcMode: CalcMode
    get() = noGet()
    set(value) {
        ac["calcMode"] = value.svgString
    }

public enum class CalcMode(
    override val svgString: String,
) : SvgAttributeType {
    Discrete("discrete"),
    Linear("linear"),
    Paced("paced"),
    Spline("spline"),
}
