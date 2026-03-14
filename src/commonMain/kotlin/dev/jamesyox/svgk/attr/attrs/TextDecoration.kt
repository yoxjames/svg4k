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

// TODO: Weakly typed

/**
 * The `text-decoration` attribute defines whether text is decorated with an underline, overline and/or strike-through.
 * It is a shorthand for the text-decoration-line and text-decoration-style properties.
 *
 * The fill and stroke of the text decoration are given by the fill and stroke of the text at the point where the text
 * decoration is declared.
 *
 * The paint order of the text decoration, i.e., the fill and stroke, is determined by the value of the [paintOrder]
 * attribute at the point where the text decoration is declared.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.TextDecoration
)
public var textDecoration: String
    get() = noGet()
    set(value) {
        ac["text-decoration"] = value
    }
