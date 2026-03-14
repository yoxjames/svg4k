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

// TODO: Weakly typed but unsure there's really a better way.

/**
 * The `to` attribute indicates the final value of the attribute that will be modified during the animation.
 *
 * The value of the attribute will change between the [from] attribute value and this value.
 *
 * For [dev.jamesyox.svgk.tags.Animate], [dev.jamesyox.svgk.tags.AnimateMotion], and
 * [dev.jamesyox.svgk.tags.AnimateTransform], [to] specifies the ending value of the animation.
 *
 * For the [dev.jamesyox.svgk.tags.Set] element, [to] specifies the value for the attribute during the duration of
 * the element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.To
)
public var to: String
    get() = noGet()
    set(value) {
        ac["to"] = value
    }
