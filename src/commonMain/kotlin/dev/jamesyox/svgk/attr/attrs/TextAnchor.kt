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

/**
 * The `text-anchor` attribute is used to align (start-, middle- or end-alignment) a string of pre-formatted text
 * or auto-wrapped text where the wrapping area is determined from the inline-size property relative to a given point.
 *
 * This attribute is not applicable to other types of auto-wrapped text. For those cases you should use
 * `text-align` (CSS). For multi-line text, the alignment takes place for each line.
 *
 * The [textAnchor] attribute is applied to each individual text chunk within a given [dev.jamesyox.svgk.tags.Text]
 * element. Each text chunk has an initial current text position, which represents the point in the user coordinate
 * system resulting from (depending on context) application of the x and y attributes on the
 * [dev.jamesyox.svgk.tags.Text] element, any [x] or [y] attribute values on a [dev.jamesyox.svgk.tags.Tspan]
 * element assigned explicitly to the first rendered character in a text chunk, or determination of the initial
 * current text position for a [dev.jamesyox.svgk.tags.textPath] element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.TextAnchor
)
public var textAnchor: TextAnchor
    get() = noGet()
    set(value) {
        ac["text-anchor"] = value
    }

public enum class TextAnchor(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * The rendered characters are aligned such that the start of the text string is at the initial current text
     * position. For an element with a [direction] property value of [LeftToRight]
     * (typical for most European languages), the left side of the text is rendered at the initial text position.
     * For an element with a direction property * value of [RightToLeft] (typical for Arabic and Hebrew),
     * the right side of the text is rendered at the initial text position. For an element with a vertical primary
     * text direction (often typical for Asian text), the top side of the text is rendered at the initial text position.
     */
    Start("start"),

    /**
     * The rendered characters are aligned such that the middle of the text string is at the current text position.
     * (For text on a path, conceptually the text string is first laid out in a straight line. The midpoint between
     * the start of the text string and the end of the text string is determined. Then, the text string is mapped onto
     * the path with this midpoint placed at the current text position.)
     */
    Middle("middle"),

    /**
     * The rendered characters are shifted such that the end of the resulting rendered text (final current text
     * position before applying the [textAnchor] property) is at the initial current text position. For an element
     * with a [direction] property value of [LeftToRight] (typical for most European languages), the right side
     * of the text is rendered at the initial text position. For an element with a direction property value of
     * [RightToLeft] (typical for Arabic and Hebrew), the left side of the text is rendered at the initial text
     * position. For an element with a vertical primary text direction (often typical for Asian text),
     * the bottom of the text is rendered at the initial text position.
     */
    End("end"),
}
