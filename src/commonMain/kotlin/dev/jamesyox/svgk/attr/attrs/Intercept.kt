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
import dev.jamesyox.svgk.attr.svgString
import dev.jamesyox.svgk.meta.noGet

/**
 * The `intercept` attribute defines the intercept of the linear function of color component transfers when the type
 * attribute is set to `linear`.
 *
 * The linear function is defined as `slope * color + intercept`, where color is the color value, the intercept
 * provides a base value for the result, and the slope is a scaling factor.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Intercept
)
public var intercept: Number
    get() = noGet()
    set(value) {
        ac["intercept"] = value.svgString
    }
