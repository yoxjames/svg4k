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
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet

/**
 * The fetchpriority attribute provides a hint to the browser about the relative priority to use when fetching an
 * external resource. This works the same way as the fetchpriority attribute for the HTML <img> and <script> elements.
 */
@Deprecated("Experimental technology not supported by all major browsers")
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Fetchpriority
)
public var fetchpriority: FetchPriority
    get() = noGet()
    set(value) {
        ac["fetchpriority"] = value
    }

@Deprecated("Experimental technology not supported by all major browsers")
public enum class FetchPriority(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Fetches the external resource at a high priority relative to other external resources.
     */
    High("high"),

    /**
     * Fetches the external resource at a high priority relative to other external resources.
     */
    Low("low"),

    /**
     * Doesn't set a preference for the fetch priority. It is used if no value or an invalid value is set.
     * This is the default.
     */
    Auto("auto"),
}
