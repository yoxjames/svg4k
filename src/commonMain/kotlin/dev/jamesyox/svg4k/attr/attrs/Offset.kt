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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.attr.types.obj.Pct
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * This attribute defines where the gradient stop is placed along the gradient vector.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Offset,
)
public var offset: Pct
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["offset"] = value
    }

/**
 * This attribute defines where the gradient stop is placed along the gradient vector.
 * @param value: A [Number] between `0.0 - 1.0`
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Offset,
)
public fun offset(value: Number) {
    ac["offset"] = value.svgString
}

