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
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `by` attribute specifies a relative offset value for an attribute that will be modified during an animation.
 *
 * The starting value for the attribute is either indicated by specifying it as value for the attribute given in the
 * [attributeName] or the [from] attribute.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.By,
)
public var by: String // TODO: Weakly typed
    get() = noGet()
    set(value) {
        ac["by"] = value
    }
