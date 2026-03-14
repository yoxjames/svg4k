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
 * The diffuseConstant attribute represents the kd value in the
 * [Phong lighting model](https://en.wikipedia.org/wiki/Phong_reflection_model). In SVG, this can be any non-negative
 * number.
 *
 * It's used to determine the final RGB value of a given pixel. The brighter the lighting-color, the smaller this
 * number should be.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.DiffuseConstant
)
public var diffuseConstant: Number
    get() = noGet()
    set(value) {
        ac["diffuseConstant"] = value.svgString
    }
