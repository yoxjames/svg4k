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
 * The `vector-effect` property specifies the vector effect to use when drawing an object.
 * Vector effects are applied before any of the other compositing operations, i.e., filters, masks and clips.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.VectorEffect
)
public var vectorEffect: VectorEffect
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["vector-effect"] = value
    }

public enum class VectorEffect(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value specifies that no vector effect shall be applied, i.e., the default rendering behavior is used
     * which is to first fill the geometry of a shape with a specified paint, then stroke the outline with a
     * specified paint.
     */
    None("none"),

    /**
     * This value modifies the way an object is stroked. Normally stroking involves calculating stroke outline of
     * the shape's path in current user coordinate system and filling that outline with the stroke paint
     * (color or gradient). The resulting visual effect of this value is that the stroke width is not dependent on
     * the transformations of the element (including non-uniform scaling and shear transformations) and zoom level.
     */
    NonScalingStroke("non-scaling-stroke"),

    @Deprecated("No implementation and considered at risk")
    NonScalingSize("non-scaling-size"),

    @Deprecated("No implementation and considered at risk")
    NonRotation("non-rotation"),

    @Deprecated("No implementation and considered at risk")
    FixedPosition("fixed-position"),
}
