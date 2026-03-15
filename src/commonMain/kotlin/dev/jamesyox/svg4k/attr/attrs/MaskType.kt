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
 * The `mask-type` attribute indicates which mask mode, alpha or luminance, to use for the contents of the
 * [dev.jamesyox.svg4k.tags.Mask] element when masking.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.MaskType
)
public var maskType: MaskType
    get() = noGet()
    set(value) {
        ac["mask-type"] = value
    }

public enum class MaskType(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the [dev.jamesyox.svg4k.tags.Mask] element's alpha values should be used; the pixels
     * of the masked object match the opaqueness of the mask areas, without regard to the luminance of the colors of
     * the mask.
     */
    Alpha("alpha"),

    /**
     * This value indicates that the [dev.jamesyox.svg4k.tags.Mask] element's luminance values should be used; the
     * opaqueness of the masked object depends on the opacity and lightness of the mask.
     * The opacity of a luminance mask is determined by the `R`, `G`, `B`, and `A` channels of the mask, using the
     * equation `((0.2125 * R) + (0.7154 * G) + (0.0721 * B)) * A`.
     */
    Luminance("luminance"),
}
