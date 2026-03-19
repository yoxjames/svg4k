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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.attr.types.obj.Length
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.FePointLight
import dev.jamesyox.svg4k.tags.FeSpotLight
import dev.jamesyox.svg4k.tags.Filter
import dev.jamesyox.svg4k.tags.ForeignObject
import dev.jamesyox.svg4k.tags.Image
import dev.jamesyox.svg4k.tags.Mask
import dev.jamesyox.svg4k.tags.Pattern
import dev.jamesyox.svg4k.tags.Rect
import dev.jamesyox.svg4k.tags.Svg
import dev.jamesyox.svg4k.tags.Text
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * `y` defines the minimum y coordinate for the rendering area of the primitive.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Y
)
public var y: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [FePointLight], [y] defines the y location for the light source in the coordinate system defined by the
 * [primitiveUnits] attribute on the [Filter] element.
 */
context(
    ac: AttributeConsumer,
    _: FePointLight
)
public var y: Number
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value.svgString
    }

/**
 * For [FeSpotLight], [y] defines the y location for the light source in the coordinate system defined by the
 * [primitiveUnits] attribute on the [dev.jamesyox.svg4k.tags.Filter] element.
 */
context(
    ac: AttributeConsumer,
    _: FeSpotLight
)
public var y: Number
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value.svgString
    }

/**
 * For [Filter], [y] defines the y coordinate of the upper left corner for the rendering area of the filter.
 */
context(
    ac: AttributeConsumer,
    _: Filter
)
public var y: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [ForeignObject], [y] defines the y coordinate of the upper left corner of its viewport.
 */
context(
    ac: AttributeConsumer,
    _: ForeignObject
)
public var y: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [Image], [y] defines the y coordinate of the upper left corner of the image.
 */
context(
    ac: AttributeConsumer,
    _: Image
)
public var y: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [Mask], [y] defines the y coordinate of the upper left corner of its area of effect. The exact effect of
 * this attribute is influenced by the [maskUnits] attribute.
 */
context(
    ac: AttributeConsumer,
    _: Mask
)
public var y: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [Pattern], [y] defines the y coordinate of the upper left corner of the tile pattern.
 * The exact effect of this attribute is influenced by the [patternUnits] and [patternTransform] attributes.
 */
context(
    ac: AttributeConsumer,
    _: Pattern
)
public var y: Length
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [Rect], [y] defines the x coordinate of the upper left corner of the shape.
 */
context(
    ac: AttributeConsumer,
    _: Rect
)
public var y: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [Svg], [y] defines the x coordinate of the upper left corner of its viewport.
 */
context(
    ac: AttributeConsumer,
    _: Svg
)
public var y: LengthOrPercentage
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value
    }

/**
 * For [Text], if it contains a single value, [y] defines the y coordinate where the _content text position_ must be
 * placed. The content text position is usually a point on the baseline of the first line of text.
 * The exact content text position is influenced by other properties, such as [textAnchor] or [direction].
 *
 * If it contains multiple values, [y] defines the y coordinate of each individual glyph from the text.
 * If there are fewer values than glyphs, the remaining glyphs are placed in line with the last positioned glyph.
 * If there are more values than glyphs, the extra values are ignored.
 */
context(
    ac: AttributeConsumer,
    _: Text
)
public var y: List<LengthOrPercentage>
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["y"] = value.svgString(",")
    }
