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
 * The `xChannelSelector` attribute indicates which color channel from [in2] to use to
 * displace the pixels in [in] along the x-axis.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.XChannelSelector
)
public var xChannelSelector: XChannelSelector
    get() = noGet()
    set(value) {
        ac["xChannelSelector"] = value
    }

public enum class XChannelSelector(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This keyword specifies that the red color channel of the input image defined in [in2] will be used to
     * displace the pixels of the input image defined in [in] along the x-axis.
     */
    R("R"),

    /**
     * This keyword specifies that the green color channel of the input image defined in [in2] will be used to
     * displace the pixels of the input image defined in [in] along the x-axis.
     */
    G("G"),

    /**
     * This keyword specifies that the blue color channel of the input image defined in [in2] will be used to
     * displace the pixels of the input image defined in [in] along the x-axis.
     */
    B("B"),

    /**
     * This keyword specifies that the alpha channel of the input image defined in [in2] will be used to
     * displace the pixels of the input image defined in [in] along the x-axis.
     */
    A("A"),
}
