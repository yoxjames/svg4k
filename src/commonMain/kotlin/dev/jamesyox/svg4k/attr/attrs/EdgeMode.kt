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
import dev.jamesyox.svg4k.meta.noGet

/**
 * The edgeMode attribute determines how to extend the input image as necessary with color values so that the matrix
 * operations can be applied when the kernel is positioned at or near the edge of the input image.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.EdgeMode
)
public var edgeMode: EdgeMode
    get() = noGet()
    set(value) {
        ac["edgeMode"] = value.svgString
    }

public enum class EdgeMode(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the input image is extended along each of its borders as necessary by duplicating the
     * color values at the given edge of the input image.
     */
    Duplicate("duplicate"),

    /**
     * This value indicates that the input image is extended by taking the color values from the opposite edge of the
     * image.
     */
    Wrap("wrap"),

    /**
     * This value indicates that the input image is extended with pixel values of zero for R, G, B and A.
     */
    None("none"),
}
