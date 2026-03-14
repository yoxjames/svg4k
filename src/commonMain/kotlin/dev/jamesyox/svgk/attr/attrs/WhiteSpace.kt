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

// TODO: Not 100% sure what elements this applies to. Educated guess taken.

/**
 * The `white-space` SVG attribute specifies how white space within text should be handled. This includes whether and
 * how white space inside the element is collapsed and whether lines may wrap at unforced soft wrap opportunities.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.WhiteSpace
)
public var whiteSpace: WhiteSpace
    get() = noGet()
    set(value) {
        ac["white-space"] = value
    }

public enum class WhiteSpace(
    override val svgString: String,
) : SvgAttributeType {
    Normal("normal"),
    Pre("pre"),
    Nowrap("nowrap"),
    PreWrap("pre-wrap"),
    BreakSpace("break-space"),
    PreLine("pre-line"),
}
