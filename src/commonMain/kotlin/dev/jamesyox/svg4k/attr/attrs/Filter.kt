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
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.Url
import dev.jamesyox.svg4k.attr.types.obj.asUrl
import dev.jamesyox.svg4k.attr.types.obj.url
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `filter` attribute specifies the filter effects defined by the [dev.jamesyox.svg4k.tags.Filter] element that
 * shall be applied to its element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Filter
)
public var filter: String
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["filter"] = value
    }

/**
 * The `filter` attribute specifies the filter effects defined by the [dev.jamesyox.svg4k.tags.Filter] element that
 * shall be applied to its element.
 *
 * This is a convenience method to set a filter to a [Url]
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Filter
)
public fun filter(url: Url) {
    filter = url.svgString
}

/**
 * The `filter` attribute specifies the filter effects defined by the [dev.jamesyox.svg4k.tags.Filter] element that
 * shall be applied to its element.
 *
 * This is a convenience method to set a filter to a [Url] referencing a [SvgId]. For example: `url(#myId)`
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Filter
)
public fun filter(id: SvgId) {
    filter(id.asUrl())
}

// TODO: Missing Docs
context(_: AttributeContainer.Filter)
public val None: String get() = "none"