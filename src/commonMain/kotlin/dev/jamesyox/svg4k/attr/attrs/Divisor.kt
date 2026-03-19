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
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `divisor` attribute specifies the value by which the resulting number of applying the [kernelMatrix]
 * of a [dev.jamesyox.svg4k.tags.FeConvolveMatrix] element to the input image color value is divided to yield the
 * destination color value.
 *
 * A divisor that is the sum of all the matrix values tends to have an evening effect on the overall color
 * intensity of the result.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Divisor,
)
public var divisor: Number
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["divisor"] = value.svgString
    }
