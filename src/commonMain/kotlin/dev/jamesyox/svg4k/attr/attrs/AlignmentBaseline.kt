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
 * The `alignment-baseline` attribute specifies how an object is aligned with respect to its parent.
 * This property specifies which baseline of this element is to be aligned with the corresponding
 * baseline of the parent. For example, this allows alphabetic baselines in Roman text to stay
 * aligned across font size changes. It defaults to the baseline with the same name as the computed
 * value of the alignment-baseline property.
 */
@Deprecated("May not work in all browsers")
context(
    ac: AttributeConsumer,
    _: AttributeContainer.AlignmentBaseline,
)
public var alignmentBaseline: AlignmentBaseline
    get() = noGet()
    set(value) {
        ac["alignment-baseline"] = value.svgString
    }

@Deprecated("May not work in all browsers")
public enum class AlignmentBaseline(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * The value is the dominant-baseline of the script to which the character belongs - i.e.,
     * use the dominant-baseline of the parent.
     */
    @Deprecated("Deprecated web standard")
    Auto("auto"),

    /**
     * Uses the dominant-baseline choice of the parent. Matches the box's corresponding baseline to that of its parent.
     */
    Baseline("baseline"),

    /**
     * The alignment-point of the object being aligned is aligned with the "before-edge" baseline of
     * the parent text content element.
     */
    @Deprecated("Deprecated web standard")
    BeforeEdge("before-edge"),

    /**
     * Matches the bottom of the box to the top of the parent's content area.
     */
    TextBottom("text-bottom"),

    /**
     * The alignment-point of the object being aligned is aligned with the "text-before-edge" baseline of the parent
     * text content element.
     */
    TextBeforeEdge("text-before-edge"),

    /**
     * The alignment-point of the object being aligned is aligned with the "text-before-edge" baseline of the parent
     * text content element.
     */
    Middle("middle"),

    /**
     * Matches the box's central baseline to the central baseline of its parent.
     */
    Central("central"),

    /**
     * The alignment-point of the object being aligned is aligned with the "after-edge" baseline of
     * the parent text content element.
     */
    @Deprecated("Deprecated web standard")
    AfterEdge("after-edge"),

    /**
     * The alignment-point of the object being aligned is aligned with the "text-after-edge" baseline of the parent text
     * content element.
     */
    TextAfterEdge("text-after-edge"),

    /**
     * Matches the box's ideographic character face under-side baseline to that of its parent.
     */
    Ideographic("ideographic"),

    /**
     * Matches the box's alphabetic baseline to that of its parent.
     */
    Alphabetic("alphabetic"),

    /**
     * The alignment-point of the object being aligned is aligned with the "hanging" baseline of the parent text content
     * element.
     */
    Hanging("hanging"),

    /**
     * Matches the box's mathematical baseline to that of its parent.
     */
    Mathematical("mathematical"),

    /**
     * Aligns the top of the aligned subtree with the top of the line box.
     */
    Top("top"),

    /**
     * Aligns the center of the aligned subtree with the center of the line box.
     */
    Center("center"),

    /**
     * Aligns the bottom of the aligned subtree with the bottom of the line box.
     */
    Bottom("bottom"),
}
