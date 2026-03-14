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
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.meta.noGet
import dev.jamesyox.svgk.tags.FeImage

/**
 * The crossorigin attribute, valid on the [dev.jamesyox.svgk.tags.Image], [FeImage], and
 * [dev.jamesyox.svgk.tags.Script] elements, provides support for configuration of Cross-Origin Resource Sharing (CORS)
 * requests for the element's fetched data.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Crossorigin
)
public var crossorigin: Crossorigin
    get() = noGet()
    set(value) {
        ac["crossorigin"] = value
    }

/**
 * The crossorigin attribute, valid on the [dev.jamesyox.svgk.tags.Image], [FeImage], and
 * [dev.jamesyox.svgk.tags.Script] elements, provides support for configuration of Cross-Origin Resource Sharing (CORS)
 * requests for the element's fetched data.
 */
@Deprecated("Not widely supported")
context(
    ac: AttributeConsumer,
    _: FeImage
)
public var crossorigin: Crossorigin
    get() = noGet()
    set(value) {
        ac["crossorigin"] = value
    }

public enum class Crossorigin(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Client CORS requests for this element will have the credentials flag set to 'same-origin'.
     */
    Anonymous("anonymous"),

    /**
     * Client CORS requests for this element will have the credentials flag set to 'include'.
     */
    UseCredentials("use-credentials"),
}
