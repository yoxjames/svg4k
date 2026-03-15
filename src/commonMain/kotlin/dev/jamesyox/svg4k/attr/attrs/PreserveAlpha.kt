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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `preserveAlpha` attribute indicates how a [dev.jamesyox.svg4k.tags.FeConvolveMatrix] element handles
 * alpha transparency.
 *
 * When true:
 * This value indicates that the convolution is applied only to the color channels.
 * In this case, the filter temporarily removes alpha premultiplication from the color component values,
 * applies the kernel, and then reapplies alpha premultiplication as a final step.
 *
 * When false:
 * This value indicates that the convolution is applied to all channels, including the alpha channel.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PreserveAlpha
)
public var preserveAlpha: Boolean
    get() = noGet()
    set(value) {
        ac["preserveAlpha"] = value.svgString
    }
