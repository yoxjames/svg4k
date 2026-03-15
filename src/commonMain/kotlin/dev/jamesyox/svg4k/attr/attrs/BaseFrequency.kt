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

/**
 * The `baseFrequency` attribute represents the base frequency parameter for the noise function of the [dev.jamesyox.svg4k.tags.FeTurbulence]
 * filter primitive.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.BaseFrequency
)
public var baseFrequency: NumberOptionalNumber
    get() = noGet()
    set(value) {
        ac["baseFrequency"] = value.svgString
    }

/**
 * Convenience method to set baseFrequency to a single number.
 *
 * @see [baseFrequency]
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.BaseFrequency
)
public fun baseFrequency(number: Number) {
    baseFrequency = NumberOptionalNumber(number, null)
}

/**
 * Convenience method to set baseFrequency to two numbers.
 *
 * @see [baseFrequency]
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.BaseFrequency
)
public fun baseFrequency(
    number: Number,
    otherNumber: Number,
) {
    baseFrequency = NumberOptionalNumber(number, otherNumber)
}
