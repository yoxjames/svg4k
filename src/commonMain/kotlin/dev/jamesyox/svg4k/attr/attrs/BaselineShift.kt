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
import dev.jamesyox.svg4k.attr.ConstantSvgAttributeType
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.WrappedSvgAttributeType
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `baseline-shift` attribute allows repositioning of the dominant-baseline relative to the [dominantBaseline] of the
 * parent text content element. The shifted object might be a sub or superscript.
 */
@Deprecated("Not available in all browsers. Currently not available in Firefox (as of Jan 10 2026)")
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Azimuth
)
public var baselineShift: BaselineShift
    get() = noGet()
    set(value) {
        ac["baseline-shift"] = value.svgString
    }

/**
 * Convenience method for `baselineShift = BaselineShift.Value(lengthOrPercentage)`
 * @see [baselineShift]
 */
@Deprecated("Not available in all browsers. Currently not available in Firefox (as of Jan 10 2026)")
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Azimuth
)
public fun baselineShift(lengthOrPercentage: LengthOrPercentage) {
    baselineShift = BaselineShift.Value(lengthOrPercentage)
}

public sealed interface BaselineShift : SvgAttributeType {
    /**
     * The dominant-baseline is shifted to the default position for subscripts.
     */
    public data object Sub : BaselineShift, ConstantSvgAttributeType("sub")

    /**
     * The dominant-baseline is shifted to the default position for superscripts.
     */
    public data object Super : BaselineShift, ConstantSvgAttributeType("super")

    /**
     * A length value raises (positive value) or lowers (negative value) the dominant-baseline of the parent text
     * content element by the specified length.
     *
     * A percentage value raises (positive value) or lowers (negative value) the dominant-baseline of the parent text
     * content element by the specified percentage of the line-height.
     */
    public class Value(
        public val value: LengthOrPercentage,
    ) : WrappedSvgAttributeType(value),
        BaselineShift
}
