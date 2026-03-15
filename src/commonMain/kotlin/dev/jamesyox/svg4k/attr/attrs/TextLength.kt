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

/**
 * The `textLength` attribute, available on SVG [dev.jamesyox.svg4k.tags.Text] and [dev.jamesyox.svg4k.tags.Tspan]
 * elements, lets you specify the width of the space into which the text will draw. The user agent will ensure that
 * the text does not extend farther than that distance, using the method or methods specified by the [lengthAdjust]
 * attribute. By default, only the spacing between characters is adjusted, but the glyph size can also be adjusted
 * if you change [lengthAdjust].
 *
 * By using [textLength], you can ensure that your SVG text displays at the same width regardless of conditions
 * including web fonts failing to load (or not having loaded yet).
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.TextLength
)
public var textLength: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["textLength"] = value
    }
