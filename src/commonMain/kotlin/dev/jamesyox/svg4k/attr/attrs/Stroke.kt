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
import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.SvgPaint
import dev.jamesyox.svg4k.attr.types.obj.Url
import dev.jamesyox.svg4k.attr.types.obj.asUrl
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `stroke` attribute is a presentation attribute defining the color (or any SVG paint servers
 * like gradients or patterns) used to paint the outline of the shape.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Stroke
)
public var stroke: SvgPaint
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["stroke"] = value
    }

/**
 * The `stroke` attribute is a presentation attribute defining the color (or any SVG paint servers
 * like gradients or patterns) used to paint the outline of the shape.
 *
 * This is a convenience function equivalent to
 *
 * ```kotlin
 * stroke = SvgPaint.Color(color)
 * ```
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Stroke
)
public fun stroke(color: SvgColor) {
    stroke = SvgPaint.Color(color)
}

/**
 * The `stroke` attribute is a presentation attribute defining the color (or any SVG paint servers
 * like gradients or patterns) used to paint the outline of the shape.
 *
 * This is a convenience function equivalent to
 *
 * ```kotlin
 * stroke = SvgPaint.Url(url)
 * ```
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Stroke
)
public fun stroke(url: Url) {
    stroke = SvgPaint.Url(url)
}

/**
 * The `stroke` attribute is a presentation attribute defining the color (or any SVG paint servers
 * like gradients or patterns) used to paint the outline of the shape.
 *
 * This is a convenience to set [stroke] to a [Url] pointed at a [dev.jamesyox.svg4k.attr.types.obj.SvgId]
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Stroke
)
public fun stroke(id: SvgId) {
    stroke(id.asUrl())
}
