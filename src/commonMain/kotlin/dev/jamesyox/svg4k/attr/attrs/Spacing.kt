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
 * The `spacing` attribute indicates how the user agent should determine the spacing between typographic characters
 * that are to be rendered along a path.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Spacing
)
public var spacing: Spacing
    get() = noGet()
    set(value) {
        ac["spacing"] = value
    }

public enum class Spacing(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the user agent should use text-on-a-path layout algorithms to adjust the
     * spacing between typographic characters in order to achieve visually appealing results.
     */
    Auto("auto"),

    /**
     * This value indicates that the typographic characters should be rendered exactly according to the spacing
     * rules as specified by the layout rules for text-on-a-path.
     */
    Exact("exact"),
}
