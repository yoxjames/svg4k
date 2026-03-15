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
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.attr.types.obj.Length
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.Circle
import dev.jamesyox.svg4k.tags.RadialGradient

/**
 * For [Circle], `r` defines the radius of the circle and therefore its size. With a value lower or equal to
 * zero the circle won't be drawn at all.
 */
context(
    ac: AttributeConsumer,
    _: Circle
)
public var r: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["r"] = value
    }

/**
 * For [RadialGradient], `r` defines the radius of the end circle for the radial gradient.
 *
 * The gradient will be drawn such that the 100% gradient stop is mapped to the perimeter of this end
 * circle. A value of lower or equal to zero will cause the area to be painted as a single color using the
 * color and opacity of the last gradient [dev.jamesyox.svg4k.tags.Stop].
 */
context(
    ac: AttributeConsumer,
    _: RadialGradient
)
public var r: Length
    get() = noGet()
    set(value) {
        ac["r"] = value
    }
