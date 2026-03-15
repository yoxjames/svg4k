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
import dev.jamesyox.svg4k.attr.types.obj.Length
import dev.jamesyox.svg4k.meta.noGet

/**
 * The word-spacing attribute specifies spacing behavior between words.
 *
 * If a [Length] is provided without a unit identifier (e.g., an unqualified number such as [Length.None]), the browser
 * processes the [Length] as a width value in the current user coordinate system.
 *
 * If a [Length] is provided with one of the unit identifiers (e.g., .25em or 1%), then the browser converts the
 * [Length] into a corresponding value in the current user coordinate system.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.WordSpacing
)
public var wordSpacing: Length
    get() = noGet()
    set(value) {
        ac["word-spacing"] = value
    }
