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

package dev.jamesyox.svgk.attr.attrs

import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.AttributeContainer
import dev.jamesyox.svgk.attr.ConstantSvgAttributeType
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.WrappedSvgAttributeType
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.attr.types.obj.Length
import dev.jamesyox.svgk.meta.noGet

/**
 * The `letter-spacing` attribute controls spacing between text characters.
 *
 * If the attribute value is a unitless number (like 128), the browser processes it as a `<length>` in the current user
 * coordinate system.
 *
 * If the attribute value has a unit identifier, such as .25em or 1%, then the browser converts the `<length>` into
 * its corresponding value in the current user coordinate system.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.LetterSpacing
)
public var letterSpacing: LetterSpacing
    get() = noGet()
    set(value) {
        ac["letter-spacing"] = value
    }

public sealed interface LetterSpacing : SvgAttributeType {
    public data object Normal : LetterSpacing, ConstantSvgAttributeType("normal")

    public class Value(
        public val value: Length,
    ) : WrappedSvgAttributeType(value),
        LetterSpacing
}
