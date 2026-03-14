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

package dev.jamesyox.svgk.attr.attrs

import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.AttributeContainer
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.meta.noGet

/**
 * The `primitiveUnits` attribute specifies the coordinate system for the various length values within the filter
 * primitives and for the attributes that define the filter primitive subregion.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PrimitiveUnits
)
public var primitiveUnits: PrimitiveUnits
    get() = noGet()
    set(value) {
        ac["primitiveUnits"] = value.svgString
    }

public enum class PrimitiveUnits(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that any length values within the filter definitions represent values in the current user
     * coordinate system in place at the time when the [dev.jamesyox.svgk.tags.Filter] element is referenced
     * (i.e., the user coordinate system for the element referencing the [dev.jamesyox.svgk.tags.Filter] element
     * via a filter attribute).
     */
    UserSpaceOnUse("userSpaceOnUse"),

    /**
     * This value indicates that any length values within the filter definitions represent fractions or percentages
     * of the bounding box on the referencing element.
     */
    ObjectBoundingBox("objectBoundingBox"),
}
