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
 * The `stroke-linejoin` attribute is a presentation attribute defining the shape to be used at the corners of
 * paths when they are stroked.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.StrokeLinejoin
)
public var strokeLinejoin: StrokeLinejoin
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["stroke-linejoin"] = value
    }

public enum class StrokeLinejoin(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * The [Arcs] value indicates that an arcs corner is to be used to join path segments.
     * The arcs shape is formed by extending the outer edges of the stroke at the join point with arcs that have
     * the same curvature as the outer edges at the join point.
     */
    Arcs("arcs"),

    /**
     * The [Bevel] value indicates that a bevelled corner is to be used to join path segments.
     */
    Bevel("bevel"),

    /**
     * The [Miter] value indicates that a sharp corner is to be used to join path segments. The corner is formed by
     * extending the outer edges of the stroke at the tangents of the path segments until they intersect.
     */
    Miter("miter"),

    /**
     * The [MiterClip] value indicates that a sharp corner is to be used to join path segments. The corner is
     * formed by extending the outer edges of the stroke at the tangents of the path segments until they intersect.
     *
     * If the [strokeMiterlimit] is exceeded, the miter is clipped at a distance equal to half the [strokeMiterlimit]
     * value multiplied by the stroke width from the intersection of the path segments. This provides a better
     * rendering than miter on very sharp join or in case of an animation.
     */
    MiterClip("miter-clip"),

    /**
     * The round value indicates that a round corner is to be used to join path segments.
     */
    Round("round"),
}
