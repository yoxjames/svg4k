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
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `stdDeviation` attribute defines the standard deviation for the blur operation.
 *
 * If two numbers are provided, the first number represents a standard deviation value along the
 * x-axis. The second value represents a standard deviation along the y-axis. If one number
 * is provided, then that value is used for both X and Y.
 *
 * A negative value is forbidden. A value of zero disables the effect of the given filter primitive
 * (i.e., the result is the filter input image). If [stdDeviation] is 0 in only one of X or Y,
 * then the effect is that the blur is only applied in the direction that has a non-zero value.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.StdDeviation
)
public var stdDeviation: NumberOptionalNumber
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["stdDeviation"] = value
    }
