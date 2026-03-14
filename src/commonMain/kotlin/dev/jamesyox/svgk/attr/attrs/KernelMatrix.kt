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
 * The kernelMatrix attribute defines the list of numbers that make up the kernel matrix for the
 * `<feConvolveMatrix>` element.
 *
 * Values are separated by space characters and/or a comma. The number of entries in the list must equal to
 * `<orderX>` by `<orderY>` as defined in the `order` attribute.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.KernelMatrix
)
public var kernelMatrix: List<Number>
    get() = noGet()
    set(value) {
        ac["kernelMatrix"] = value.svgString(separator = " ")
    }
