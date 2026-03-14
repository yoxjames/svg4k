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
import dev.jamesyox.svgk.meta.noGet

/**
 *
 * Specifies the element's ID. The ID must be unique within the node tree, must not be an empty string, and must not
 * contain any whitespace characters.
 *
 * Note: You should avoid the use of id values that would be parsed as an SVG view specification
 * (e.g., `MyDrawing.svg#svgView(viewBox(0,200,1000,1000))`) or a basic media fragment when used as a URL target fragment.
 *
 * It must be valid in XML documents. A stand-alone SVG document uses XML 1.0 syntax, which specifies that valid IDs
 * only include designated characters (letters, digits, and a few punctuation marks), and do not start with a digit,
 * a full stop (.) character, or a hyphen-minus (-) character.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Id
)
public var id: String
    get() = noGet()
    set(value) {
        ac["id"] = value
    }
