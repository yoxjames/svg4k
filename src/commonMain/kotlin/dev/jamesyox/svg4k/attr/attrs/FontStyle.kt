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

/**
 * The font-style attribute specifies whether the text is to be rendered using a normal, italic, or oblique face.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FontStyle
)
public var fontStyle: FontStyle
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["font-style"] = value
    }

public enum class FontStyle(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Selects a font that is classified as normal within a font-family.
     */
    Normal("normal"),

    /**
     * Selects a font that is classified as italic. If no italic version of the face is available, one classified as
     * oblique is used instead. If neither is available, the style is artificially simulated.
     */
    Italic("italic"),

    /**
     * Selects a font that is classified as oblique. If no oblique version of the face is available, one classified as
     * italic is used instead. If neither is available, the style is artificially simulated.
     */
    Oblique("oblique"),
}
