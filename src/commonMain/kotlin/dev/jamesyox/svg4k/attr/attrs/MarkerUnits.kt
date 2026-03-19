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
 * The `markerUnits` attribute defines the coordinate system for the [markerWidth] and [markerHeight] attributes and
 * the contents of the [dev.jamesyox.svg4k.tags.Marker].
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.MarkerUnits
)
public var markerUnits: MarkerUnits
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["markerUnits"] = value
    }

public enum class MarkerUnits(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * This value specifies that the [markerWidth] and [markerHeight] attributes and the contents of the
     * [dev.jamesyox.svg4k.tags.Marker] element represent values in the current user coordinate system in place for the
     * graphic object referencing the marker (i.e., the user coordinate system for the element referencing the
     * [dev.jamesyox.svg4k.tags.Marker] element via a [markerStart], [markerMid], or [markerEnd] property).
     */
    UserSpaceOnUse("userSpaceOnUse"),

    /**
     * This value specifies that the [markerWidth] and [markerHeight] attributes and the contents of the
     * [dev.jamesyox.svg4k.tags.Marker] element represent values in a coordinate system which has a single unit equal
     * the size in user units of the current stroke width (see the stroke-width attribute) in place for the graphic
     * object referencing the marker.
     */
    StrokeWidth("strokeWidth"),
}
