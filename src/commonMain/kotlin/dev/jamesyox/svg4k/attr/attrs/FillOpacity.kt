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
import dev.jamesyox.svg4k.attr.types.obj.Pct
import dev.jamesyox.svg4k.attr.types.obj.PercentageOrNumber
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The fill-opacity attribute is a presentation attribute defining the opacity of the paint server
 * (color, gradient, pattern, etc.) applied to a shape.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FillOpacity,
)
public var fillOpacity: PercentageOrNumber
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["fill-opacity"] = value.svgString
    }

/**
 * The fill-opacity attribute is a presentation attribute defining the opacity of the paint server
 * (color, gradient, pattern, etc.) applied to a shape.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FillOpacity,
)
public fun fillOpacity(value: Number) {
    fillOpacity = PercentageOrNumber.Number(value)
}

/**
 * The fill-opacity attribute is a presentation attribute defining the opacity of the paint server
 * (color, gradient, pattern, etc.) applied to a shape.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FillOpacity,
)
public fun fillOpacity(value: Pct) {
    fillOpacity = PercentageOrNumber.Percentage(value)
}
