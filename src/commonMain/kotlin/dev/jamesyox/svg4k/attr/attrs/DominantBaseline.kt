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
 * The dominant-baseline attribute specifies the dominant baseline, which is the baseline used to align the box's text
 * and inline-level contents. It also indicates the default alignment baseline of any boxes participating in baseline
 * alignment in the box's alignment context.
 *
 * It is used to determine or re-determine a scaled-baseline-table. A scaled-baseline-table is a compound value with
 * three components:
 *  1. a baseline-identifier for the dominant-baseline,
 *  2. a baseline-table, and
 *  3. a baseline-table font-size.
 *
 * Some values of the property re-determine all three values. Others only re-establish the baseline-table font-size.
 * When the initial value, auto, would give an undesired result, this property can be used to explicitly set the desired
 * scaled-baseline-table.
 *
 * If there is no baseline table in the nominal font, or if the baseline table lacks an entry for the desired baseline,
 * then the browser may use heuristics to determine the position of the desired baseline.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.DominantBaseline
)
public var dominantBaseline: DominantBaseline
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["dominant-baseline"] = value
    }

// TODO: Possibly incorrect docs?
public enum class DominantBaseline(
    override val svgString: String,
) : SvgAttributeType {
    /**
     *
     * If this property occurs on a <text> element, then the computed value depends on the value of the writing-mode
     * attribute.
     *
     * If the writing-mode is horizontal, then the value of the dominant-baseline component is alphabetic. Otherwise,
     * if the writing-mode is vertical, then the value of the dominant-baseline component is central.
     *
     * If this property occurs on a <tspan> or <textPath> element, then the dominant-baseline and the baseline-table
     * components remain the same as those of the parent text content element.
     *
     * If the computed baseline-shift value actually shifts the baseline, then the baseline-table font-size component
     * is set to the value of the font-size attribute on the element on which the dominant-baseline attribute occurs,
     * otherwise the baseline-table font-size remains the same as that of the element.
     *
     * If there is no parent text content element, the scaled-baseline-table value is constructed as above for <text>
     * elements.
     */
    Auto("auto"),

    /**
     * The dominant-baseline and the baseline-table components are set by determining the predominant script of the
     * character data content. The writing-mode, whether horizontal or vertical, is used to select the appropriate set
     * of baseline-tables and the dominant baseline is used to select the baseline-table that corresponds to that
     * baseline. The baseline-table font-size component is set to the value of the font-size attribute on the element
     * on which the dominant-baseline attribute occurs.
     */
    @Deprecated("Deprecated web standard")
    UseScript("use-script"),

    /**
     * The dominant-baseline, the baseline-table, and the baseline-table font-size remain the same as that of the parent
     * text content element.
     */
    @Deprecated("Deprecated web standard")
    NoChange("no-change"),

    /**
     * The dominant-baseline and the baseline-table remain the same, but the baseline-table font-size is changed to the
     * value of the font-size attribute on this element. This re-scales the baseline-table for the current font-size.
     */
    @Deprecated("Deprecated web standard")
    ResetSize("reset-size"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be ideographic, the derived baseline-table is
     * constructed using the ideographic baseline-table in the font, and the baseline-table font-size is changed to
     * the value of the font-size attribute on this element.
     */
    Ideographic("ideographic"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be alphabetic, the derived baseline-table is
     * constructed using the alphabetic baseline-table in the font, and the baseline-table font-size is changed to
     * the value of the font-size attribute on this element.
     */
    Alphabetic("alphabetic"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be hanging, the derived baseline-table is constructed
     * using the hanging baseline-table in the font, and the baseline-table font-size is changed to the value of the
     * font-size attribute on this element.
     */
    Hanging("hanging"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be mathematical, the derived baseline-table is
     * constructed using the mathematical baseline-table in the font, and the baseline-table font-size is changed to
     * the value of the font-size attribute on this element.
     */
    Mathematical("mathematical"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be central. The derived baseline-table is constructed
     * from the defined baselines in a baseline-table in the font. That font baseline-table is chosen using the
     * following priority order of baseline-table names: ideographic, alphabetic, hanging, mathematical.
     * The baseline-table font-size is changed to the value of the font-size attribute on this element.
     */
    Central("central"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be middle. The derived baseline-table is constructed
     * from the defined baselines in a baseline-table in the font. That font baseline-table is chosen using the
     * following priority order of baseline-table names: alphabetic, ideographic, hanging, mathematical.
     * The baseline-table font-size is changed to the value of the font-size attribute on this element.
     */
    Middle("middle"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be text-after-edge. The derived baseline-table is
     * constructed from the defined baselines in a baseline-table in the font. The choice of which font baseline-table
     * to use from the baseline-tables in the font is browser dependent. The baseline-table font-size is changed to the
     * value of the font-size attribute on this element.
     */
    TextAfterEdge("text-after-edge"),

    /**
     * The baseline-identifier for the dominant-baseline is set to be text-before-edge. The derived baseline-table is
     * constructed from the defined baselines in a baseline-table in the font. The choice of which baseline-table to
     * use from the baseline-tables in the font is browser dependent. The baseline-table font-size is changed to the
     * value of the font-size attribute on this element.
     */
    TextBeforeEdge("text-before-edge"),
}
