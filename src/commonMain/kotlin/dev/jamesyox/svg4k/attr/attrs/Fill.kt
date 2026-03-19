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
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

// TODO: Poor typing

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Presentational,
)
public var fill: String
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["fill"] = value
    }

/**
 * Defines the unsafe version of fill which simply takes a string so any value can be allowed.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Unsafe
)
public var fill: String
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["fill"] = value
    }

/**
 * Final state of the animation
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Animation,
)
public var fill: FinalState
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["fill"] = value
    }

public enum class FinalState(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Keep the state of the last animation frame
     */
    Freeze("freeze"),

    /**
     * Keep the state of the first animation frame
     */
    Remove("remove"),
}
