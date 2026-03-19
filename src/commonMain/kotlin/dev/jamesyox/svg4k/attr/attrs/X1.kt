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
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.Line
import dev.jamesyox.svg4k.tags.LinearGradient
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * For [Line], [x1] defines the x coordinate of the starting point of the line.
 */
context(
    ac: AttributeConsumer,
    _: Line
)
public var x1: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["x1"] = value
    }

/**
 * For [LinearGradient], [x1] defines the x coordinate of the starting point of the _gradient vector_ used to map the
 * gradient stop values. The exact behavior of this attribute is influenced by the [gradientUnits] attributes
 */
context(
    ac: AttributeConsumer,
    _: LinearGradient
)
public var x1: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["x1"] = value
    }

/**
 * Unsafe version of [x1]. Functionality depends on what [dev.jamesyox.svg4k.SvgTag] is the parent.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.X1
)
public var x1: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["x1"] = value
    }
