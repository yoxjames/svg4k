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
 * The attributeName attribute indicates the name of the CSS property or attribute of the target element that is going
 * to be changed during an animation.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.AttributeName
)
public var attributeName: String
    get() = noGet()
    set(value) {
        ac["attributeName"] = value
    }
