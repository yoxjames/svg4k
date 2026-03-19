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
import dev.jamesyox.svg4k.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The order attribute indicates the size of the matrix to be used by a [dev.jamesyox.svg4k.tags.FeConvolveMatrix]
 * element.
 *
 * This value indicates the number of cells in each dimension for the kernel matrix. The values provided must be
 * [Int] greater than zero. Values that are not integers will be truncated, i.e., rounded to the closest integer value
 * towards zero. The first number, indicates the number of columns in the matrix. The second number,
 * indicates the number of rows in the matrix. If no second number is not provided, it defaults to the first number.
 *
 * It is recommended that only small values (e.g., 3) be used; higher values may result in very high CPU overhead
 * and usually do not produce results that justify the impact on performance.
 * */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Order
)
public var order: NumberOptionalNumber
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["order"] = value.svgString
    }
