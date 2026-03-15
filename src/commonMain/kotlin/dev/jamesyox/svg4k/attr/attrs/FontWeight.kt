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
import dev.jamesyox.svg4k.attr.ConstantSvgAttributeType
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.WrappedNumberSvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet

/**
 * The font-weight attribute refers to the boldness or lightness of the glyphs used to render the text,
 * relative to other fonts in the same font family.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FontWeight
)
public var fontWeight: FontWeight
    get() = noGet()
    set(value) {
        ac["font-weight"] = value
    }

public interface FontWeight : SvgAttributeType {
    /**
     * Normal font weight. Same as 400.
     */
    public data object Normal : FontWeight, ConstantSvgAttributeType("normal")

    /**
     * Bold font weight. Same as 700.
     */
    public data object Bold : FontWeight, ConstantSvgAttributeType("bold")

    /**
     * One relative font weight heavier than the parent element. Note that only four font weights are considered for
     * relative weight calculation; see the Meaning of relative weights section below.
     *
     * See [Mozilla's Docs](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference/Properties/font-weight#values)
     * */
    public data object Bolder : FontWeight, ConstantSvgAttributeType("bolder")

    /**
     * One relative font weight lighter than the parent element. Note that only four font weights are considered for
     * relative weight calculation; see the Meaning of relative weights section below.
     *
     * See [Mozilla's Docs](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference/Properties/font-weight#values)
     */
    public data object Lighter : FontWeight, ConstantSvgAttributeType("lighter")

    /**
     * A <number> value between 1 and 1000, both values included. Higher numbers represent weights that are bolder than
     * (or as bold as) lower numbers. This allows fine-grain control for variable fonts. For non-variable fonts,
     * if the exact specified weight is unavailable, a fallback weight algorithm is used — numeric values that are
     * divisible by 100 correspond to common weight names, as described in the Common weight name mapping section below.
     */
    public class Numeric(
        public val value: Number,
    ) : WrappedNumberSvgAttributeType(value),
        FontWeight
}
