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

// TODO: I am not 100% sure which elements this can be applied to. Made an educated guess.

/**
 * The SVG `text-overflow` attribute specifies how text content block elements render when text overflows line boxes.
 * This can happen, for example, when the white-space attribute or CSS white-space property has the value nowrap.
 * The property does not apply to pre-formatted text or text situated on a path.
 *
 * In SVG, [textOverflow] has an effect if there is a validly specified wrapping area, regardless of the computed
 * value of the overflow property on the text content block element. The effect is purely visual: clipped text is
 * not removed from the DOM, and any ellipsis, if presented, does not itself become part of the DOM. For all the
 * DOM methods, it is as if text-overflow was not applied, and as if the wrapping area did not constrain the text.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.TextOverflow
)
public var textOverflow: TextOverflow
    get() = noGet()
    set(value) {
        ac["text-overflow"] = value
    }

public enum class TextOverflow(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Any text that overflows the wrapping area is clipped. Characters may be partially rendered.
     * This is the default value.
     */
    Clip("clip"),

    /**
     * If the text to be rendered overflows the wrapping area, the text is clipped and an ellipsis is rendered
     * such that it fits within the given area.
     */
    Ellipses("ellipses"),
}
