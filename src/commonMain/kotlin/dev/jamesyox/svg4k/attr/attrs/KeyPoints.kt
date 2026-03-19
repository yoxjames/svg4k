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
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `keyPoints` attribute indicates the simple duration of an animation.
 *
 * This value defines a semicolon-separated list of floating point values between 0 and 1 and indicates how far
 * along the motion path the object shall move at the moment in time specified by corresponding keyTimes value.
 * The distance is calculated along the path specified by the path attribute. Each progress value in the list
 * corresponds to a value in the keyTimes attribute list.
 *
 * If a list of key points is specified, there must be exactly as many values in the keyPoints list as in the keyTimes
 * list.
 *
 * If there's a semicolon at the end of the value, optionally followed by white space, both the semicolon and the
 * trailing white space are ignored.
 *
 * If there are any errors in the value specification (i.e., bad values, too many or too few values),
 * then that's an error.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.KeyPoints
)
public var keyPoints: List<Number>
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["keyPoints"] = value.svgString(";")
    }
