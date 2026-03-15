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

/**
 * For [Line], [y2] defines the y coordinate of the ending point of the line.
 */
context(
    ac: AttributeConsumer,
    _: Line
)
public var y2: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["y2"] = value
    }

/**
 * For [LinearGradient], [y2] defines the y coordinate of the ending point of the _gradient vector_ used to map the
 * gradient stop values. The exact behavior of this attribute is influenced by the [gradientUnits] attributes
 */
context(
    ac: AttributeConsumer,
    _: LinearGradient
)
public var y2: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["y2"] = value
    }

/**
 * Unsafe version of [y2]. Functionality depends on what [dev.jamesyox.svg4k.SvgTag] is the parent.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Y2
)
public var y2: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["y2"] = value
    }
