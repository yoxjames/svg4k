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
 * The `patternUnits` attribute indicates which coordinate system to use for the geometry properties of the
 * [dev.jamesyox.svg4k.tags.Pattern] element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PatternUnits
)
public var patternUnits: PatternUnits
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["patternUnits"] = value
    }

public enum class PatternUnits(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that all coordinates for the geometry properties refer to the user coordinate system as
     * defined when the pattern was applied.
     */
    UserSpaceOnUse("userSpaceOnUse"),

    /**
     * This value indicates that all coordinates for the geometry properties represent fractions or percentages
     * of the bounding box of the element to which the pattern is applied. A bounding box could be considered the
     * same as if the content of the [dev.jamesyox.svg4k.tags.Pattern] were bound to a `0 0 1 1` viewBox.
     */
    ObjectBoundingBox("objectBoundingBox"),
}
