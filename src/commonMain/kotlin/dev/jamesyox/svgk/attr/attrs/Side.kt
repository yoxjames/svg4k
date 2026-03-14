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
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.meta.noGet

/**
 * The `side` attribute determines the side of a path the text is placed on (relative to the path direction).
 */
@Deprecated("Not supported in most browsers")
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Side
)
public var side: Side
    get() = noGet()
    set(value) {
        ac["slide"] = value
    }

@Deprecated("Not supported in most browsers")
public enum class Side(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value places the text on the left side of the path (relative to the path direction).
     */
    Left("left"),

    /**
     * This value places the text on the right side of the path (relative to the path direction).
     * This effectively reverses the path direction.
     */
    Right("right"),
}
