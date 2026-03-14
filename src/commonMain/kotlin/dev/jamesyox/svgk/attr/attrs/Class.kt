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
 * Assigns a `class` name or set of class names to an element. You may assign the same class name or names to any number
 * of elements, however, multiple class names must be separated by whitespace characters.
 *
 * An element's class name serves two key roles:
 *
 * As a style sheet selector, for when an author assigns style information to a set of elements.
 * For general use by the browser.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Class,
)
public var `class`: String
    get() = noGet()
    set(value) {
        ac["class"] = value
    }
