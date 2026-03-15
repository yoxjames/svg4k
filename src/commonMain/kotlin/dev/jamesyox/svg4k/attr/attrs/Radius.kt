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
import dev.jamesyox.svg4k.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svg4k.meta.noGet

/**
 * The radius attribute represents the radius (or radii) for the operation on a given
 * [dev.jamesyox.svg4k.tags.FeMorphology] filter primitive.
 *
 * If two numbers are provided, the first number represents the x-radius and the second one the y-radius.
 * If one number is provided, then that value is used for both x and y. The values are in the coordinate
 * system established by the primitiveUnits attribute on the [dev.jamesyox.svg4k.tags.Filter] element.
 *
 * A negative or zero value disables the effect of the given filter primitive (i.e., the result is the filter
 * input image).
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Radius
)
public var radius: NumberOptionalNumber
    get() = noGet()
    set(value) {
        ac["radius"] = value
    }
