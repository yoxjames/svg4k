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
 * The slope attribute defines the values for linear filters, such as brightness.
 *
 * The slope attribute is supported by children of the [dev.jamesyox.svg4k.tags.FeComponentTransfer] filter primitive,
 * including the feFunc-RGBA transfer functions. When the type of a transfer function is linear, the slope defines
 * the slope of the linear function.
 *
 * You can use this attribute with the following SVG component transfer function elements when [type] = [Linear] is set:
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Slope
)
public var slope: Number
    get() = noGet()
    set(value) {
        ac["slope"] = value.svgString
    }
