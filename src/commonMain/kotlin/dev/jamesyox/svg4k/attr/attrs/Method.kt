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
import dev.jamesyox.svg4k.meta.noGet

/**
 * The method attribute indicates the method by which text should be rendered along the path of a
 * [dev.jamesyox.svg4k.tags.Text] element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Method
)
public var method: Method
    get() = noGet()
    set(value) {
        ac["method"] = value.svgString
    }

public enum class Method(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the characters should be rendered so that they are not stretched or warped.
     * The characters are rotated, scaled and stretched when they are rendered. As a result, for fonts with
     * connected characters (e.g., cursive fonts), the connections may not align properly when text is rendered
     * along the path.
     */
    Align("align"),

    /**
     * This value indicates that the character outlines will be converted into paths, and then stretched and
     * possibly warped. With this approach, connected characters, such as in cursive fonts,
     * will maintain their connections.
     */
    Stretch("stretch"),
}
