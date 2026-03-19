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
 * The `gradientUnits` attribute defines the coordinate system used for attributes specified on the gradient elements.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.GradientUnits
)
public var gradientUnits: GradientUnits
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["gradientUnits"] = value
    }

public enum class GradientUnits(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * For `linearGradient`:
     * This value indicates that the attributes represent values in the coordinate system that results from taking
     * the current user coordinate system in place at the time when the gradient element is referenced (i.e., the user
     * coordinate system for the element referencing the gradient element via a fill or stroke property) and then
     * applying the transform specified by attribute gradientTransform. Percentages represent values relative to the
     * current SVG viewport.
     *
     * For `radialGradient`:
     * `cx`, `cy`, `r`, `fx`, `fy`, and `fr` represent values in the coordinate system that results from taking the
     * current user coordinate system in place at the time when the gradient element is referenced (i.e., the user
     * coordinate system for the element referencing the gradient element via a `fill` or `stroke` property) and then
     * applying the transform specified by attribute `gradientTransform`.
     */
    UserSpaceOnUse("userSpaceOnUse"),

    /**
     * For `linearGradient`:
     * This value indicates that the user coordinate system for the attributes is established using the bounding box of
     * the element to which the gradient is applied and then applying the transform specified by attribute
     * `gradientTransform`.
     *
     * Percentages represent values relative to the bounding box for the object.

     * For `radialGradient`:
     * The user coordinate system for attributes `cx`, `cy`, `r`, `fx`, `fy`, and `fr` is established using the
     * bounding box of the element to which the gradient is applied (see Object bounding box units) and then applying
     * the transform specified by attribute `gradientTransform`. With this value and `gradientTransform` being the
     * identity matrix, the rings of the radial gradient are circular with respect to the object bounding box space
     * (i.e., the abstract coordinate system where (0,0) is at the top/left of the object bounding box and (1,1) is
     * at the bottom/right of the object bounding box). When the object's bounding box is not square, the rings
     * that are conceptually circular within object bounding box space will render as elliptical due to application
     * of the non-uniform scaling transformation from bounding box space to user space.
     */
    ObjectBoundingBox("objectBoundingBox"),
}
