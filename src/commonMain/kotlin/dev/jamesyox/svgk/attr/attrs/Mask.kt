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
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.attr.types.obj.Url
import dev.jamesyox.svgk.meta.noGet

/**
 * The `mask` attribute is a presentation attribute mainly used to bind a given [dev.jamesyox.svgk.tags.Mask]
 * element with the element the attribute belongs to.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Mask
)
public var mask: Url
    get() = noGet()
    set(value) {
        ac["mask"] = value
    }
