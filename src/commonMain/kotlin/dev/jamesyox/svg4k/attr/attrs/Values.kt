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
import dev.jamesyox.svg4k.tags.FeColorMatrix
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

// TODO: Weakly typed

/**
 * `values` is a list of values defining the sequence of values over the course of the animation.
 * If this attribute is specified, any [from], [to], and [by] attribute values set on the element are ignored.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Values
)
public var values: List<String>
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["values"] = value.svgString(";")
    }

// TODO: Weakly typed

/**
 * A list of numbers, which is interpreted differently depending on the value of the [type] attribute:
 *
 * * For `type="matrix"`, values is a list of 20 matrix values (a00 a01 a02 a03 a04 a10 a11 … a34), separated by
 * whitespace and/or a comma.
 * * For `type="saturate"`, values is a single real number value (0 to 1).
 * * For `type="hueRotate"`, values is a single one real number value (degrees).
 * * For `type="luminanceToAlpha"`, values is not applicable.
 */
context(
    ac: AttributeConsumer,
    _: FeColorMatrix
)
public var values: List<Number>
    get() = noGet()
    set(value) {
        ac["values"] = value.svgString(" ")
    }
