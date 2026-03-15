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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.meta.noGet

/**
 * Defines the coordinate system in use for the content of the element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PatternContentUnits
)
public var patternContentUnits: Number
    get() = noGet()
    set(value) {
        ac["patternContentUnits"] = value.svgString
    }

public enum class PatternContentUnits(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that all coordinates inside the [dev.jamesyox.svg4k.tags.Pattern] element refer to the
     * user coordinate system as defined when the pattern tile was created.
     */
    UserSpaceOnUse("userSpaceOnUse"),

    /**
     * This value indicates that all coordinates inside the [dev.jamesyox.svg4k.tags.Pattern] element are relative to
     * the bounding box of the element the pattern is applied to. A bounding box could be considered the same as if
     * the content of the [dev.jamesyox.svg4k.tags.Pattern] were bound to a `0 0 1 1` viewBox for a pattern tile of '
     * width and height of 100%.
     */
    ObjectBoundingBox("objectBoundingBox"),
}
