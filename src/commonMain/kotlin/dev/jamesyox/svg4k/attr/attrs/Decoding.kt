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
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The decoding attribute, valid on <image> elements, provides a hint to the browser as to whether it should perform
 * image decoding along with rendering other content in a single presentation step that looks more "correct" (sync), or
 * render and present the other content first and then decode the image and present it later (async). In practice, async
 * means that the next paint does not wait for the image to decode.
 *
 * It is often difficult to perceive any noticeable effect when using decoding on static <image> elements. They'll
 * likely be initially rendered as empty images while the image files are fetched (either from the network or from the
 * cache) and then handled independently anyway, so the "syncing" of content updates is less apparent.
 * However, the blocking of rendering while decoding happens, while often quite small, can be measured — even if it
 * is difficult to observe with the human eye.
 *
 * Using different decoding types can result in more noticeable differences when dynamically inserting <image> elements
 * into the DOM via JavaScript — see
 * [SVGImageElement.decoding](https://developer.mozilla.org/en-US/docs/Web/API/SVGImageElement/decoding) for more
 * details.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Decoding
)
public var decoding: Decoding
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["decoding"] = value
    }

public enum class Decoding(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Decode the image synchronously for atomic presentation with other content.
     */
    Sync("sync"),

    /**
     * Decode the image synchronously for atomic presentation with other content.
     */
    Async("async"),

    /**
     * No preference for the decoding mode; the browser decides what is best for the user. This is the default value,
     * but different browsers have different defaults:
     *
     * Chromium defaults to "sync".
     * Firefox defaults to "async".
     * Safari defaults to "sync" except in a small number of circumstances.
     */
    Auto("auto"),
}
