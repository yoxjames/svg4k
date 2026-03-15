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
 * The font-size-adjust attribute allows authors to specify an aspect value for an element that will preserve the
 * x-height of the first choice font in a substitute font.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FontSizeAdjust
)
public var fontSizeAdjust: Number
    get() = noGet()
    set(value) {
        ac["font-size-adjust"] = value.svgString
    }
