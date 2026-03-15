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

/**
 * The filterUnits attribute defines the coordinate system for the attributes `x`, `y`, `width` and `height`.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FilterUnits
)
public var filterUnits: FillRule
    get() = noGet()
    set(value) {
        ac["filterUnits"] = value
    }

public enum class FilterUnits(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * `x`, `y`, `width` and `height` represent values in the current coordinate system that results from taking the
     * current user coordinate system in place at the time when the `<filter>` element is referenced (i.e., the user
     * coordinate system for the element referencing the `<filter>` element via a filter attribute).
     */
    UserSpaceOnUse("userSpaceOnUse"),

    /**
     * In that case, `x`, `y`, `width` and `height` represent fractions or percentages of the bounding box on the
     * referencing element.
     */
    ObjectBoundingBox("objectBoundingBox"),
}
