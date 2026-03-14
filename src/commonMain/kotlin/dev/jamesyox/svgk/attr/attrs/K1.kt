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
 * The `k1` attribute defines one of the values to be used within the arithmetic operation of the `<feComposite>`
 * filter primitive.
 *
 * The pixel composition is computed using the following formula:
 * ```
 * result = k1 * i1 * i2 + k2 * i1 + k3 * i2 + k4;
 * ```
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.K1
)
public var k1: Number
    get() = noGet()
    set(value) {
        ac["k1"] = value.svgString
    }
