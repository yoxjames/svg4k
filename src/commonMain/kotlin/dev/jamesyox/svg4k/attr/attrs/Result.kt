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
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `result` attribute defines the assigned name for this filter primitive. If supplied, then graphics that
 * result from processing this filter primitive can be referenced by an in attribute on a subsequent filter
 * primitive within the same [dev.jamesyox.svg4k.tags.Filter] element. If no value is provided, the output will only
 * be available for re-use as the implicit input into the next filter primitive if that filter primitive provides
 * no value for its in attribute.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Result
)
public var result: String
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["result"] = value
    }
