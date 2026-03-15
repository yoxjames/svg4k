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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `stop-opacity` attribute defines the opacity of a given color gradient stop.
 *
 * The opacity value used for the gradient calculation is the product of the value of [stopOpacity] and the
 * opacity of the value of the stop-color attribute. For [stopColor] values that don't include explicit opacity
 * information, the opacity is treated as 1.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.StopOpacity
)
public var stopOpacity: Float
    get() = noGet()
    set(value) {
        ac["stop-opacity"] = value.svgString
    }
