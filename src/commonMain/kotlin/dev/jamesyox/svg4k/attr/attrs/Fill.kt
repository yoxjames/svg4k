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
import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.SvgPaint
import dev.jamesyox.svg4k.attr.types.obj.Url
import dev.jamesyox.svg4k.attr.types.obj.asUrl
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Presentational,
)
public var fill: SvgPaint
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["fill"] = value
    }

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 *
 * ```kotlin
 * stroke = SvgPaint.Color(color)
 * ```
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Presentational,
)
public fun fill(color: SvgColor) {
    fill = SvgPaint.Color(color)
}

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 *
 * ```kotlin
 * stroke = SvgPaint.Color(url)
 * ```
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Presentational,
)
public fun fill(url: Url) {
    fill = SvgPaint.Url(url)
}


/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 *
 * Convenience method to set [fill] to a [SvgUrl] representing an id. For example: `id = url(#myId)`
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Presentational,
)
public fun fill(id: SvgId) {
    fill(id.asUrl())
}

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element.
 *
 * Used for unsafe so takes string as there's two types used for [fill]: [SvgPaint] and [FinalState]
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Unsafe
)
public var fill: String
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["fill"] = value
    }

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 *
 * ```kotlin
 * stroke = SvgPaint.Color(color)
 * ```
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Unsafe,
)
public fun fill(color: SvgColor) {
    fill = SvgPaint.Color(color).svgString
}

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 *
 * ```kotlin
 * stroke = SvgPaint.Color(url)
 * ```
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Unsafe,
)
public fun fill(url: Url) {
    fill = SvgPaint.Url(url).svgString
}

/**
 * Defines the color (or any SVG paint servers like gradients or patterns) used to paint the element
 *
 * Convenience method to set [fill] to a [Url] representing an id. For example: `id = url(#myId)`
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Unsafe,
)
public fun fill(id: SvgId) {
    fill(id.asUrl())
}

/**
 * Final state of the animation
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fill.Animation,
)
public var fill: FinalState
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["fill"] = value
    }

public enum class FinalState(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Keep the state of the last animation frame
     */
    Freeze("freeze"),

    /**
     * Keep the state of the first animation frame
     */
    Remove("remove"),
}
