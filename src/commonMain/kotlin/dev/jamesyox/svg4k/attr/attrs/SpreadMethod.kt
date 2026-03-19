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
 * The `spreadMethod` attribute determines how a shape is filled beyond the defined edges of a gradient.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.SpreadMethod
)
public var spreadMethod: SpreadMethod
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["spreadMethod"] = value
    }

public enum class SpreadMethod(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the final color of the gradient fills the shape beyond the gradient's edges.
     */
    Pad("pad"),

    /**
     * This value indicates that the gradient repeats in reverse beyond its edges.
     */
    Reflect("reflect"),

    /**
     * This value specifies that the gradient repeats in the original order beyond its edges.
     */
    Repeat("repeat"),
}
