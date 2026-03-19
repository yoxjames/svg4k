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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.FeDropShadow
import dev.jamesyox.svg4k.tags.FeOffset
import dev.jamesyox.svg4k.tags.Text
import dev.jamesyox.svg4k.tags.Tspan
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * For `<feDropShadow>`, dx defines the x offset of the dropped shadow. The unit used to resolve the value of the
 * attribute is set by the primitiveUnits attribute of the <filter> element.
 */
context(
    ac: AttributeConsumer,
    _: FeDropShadow
)
public var dx: Number
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["dx"] = value.svgString
    }

/**
 * For `<feOffset>`, dx defines the x offset of the filter input graphic. The unit used to resolve the value of the
 * attribute is set by the primitiveUnits attribute of the <filter> element.
 */
context(
    ac: AttributeConsumer,
    _: FeOffset
)
public var dx: Number
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["dx"] = value.svgString
    }

/**
 * For `<text>`, if it contains a single value, dx defines a shift along the x-axis for all glyphs.
 *
 * If there are multiple values, dx defines a shift along the x-axis for each individual glyph relative to the preceding
 * glyph. If there are less values than glyphs, the remaining glyphs use a value of 0. If there are more values than
 * glyphs, extra values are ignored.
 */
context(
    ac: AttributeConsumer,
    _: Text
)
public var dx: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["dx"] = value.svgString
    }

/**
 * For `<tspan>`, if it contains a single value, dx defines a shift along the x-axis for all alternate glyph.
 *
 * If there are multiple values, dx defines a shift along the x-axis for each individual glyph relative to the preceding
 * glyph. If there are less values than glyphs, the remaining glyphs use a value of 0. If there are more values than
 * glyphs, extra values are ignored.
 */
context(
    ac: AttributeConsumer,
    _: Tspan
)
public var dx: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["dx"] = value.svgString
    }
