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

/**
 * The `keyTimes` attribute represents a list of time values used to control the pacing of the animation.
 *
 * Each time in the list corresponds to a value in the values attribute list, and defines when the value is used in the
 * animation. Each time value in the `keyTimes` list is specified as a floating point value between 0 and 1 (inclusive),
 * representing a proportional offset into the duration of the animation element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.KeyTimes
)
public var keyTimes: List<Number>
    get() = noGet()
    set(value) {
        ac["keyTimes"] = value.svgString(";")
    }
