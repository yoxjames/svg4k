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
import dev.jamesyox.svgk.attr.ConstantSvgAttributeType
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.meta.noGet

/**
 * The filter attribute specifies the filter effects defined by the <filter> element that shall be applied to its
 * element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.In
)
public var `in`: In
    get() = noGet()
    set(value) {
        ac["in"] = value
    }

public sealed interface In : SvgAttributeType {
    /**
     * This keyword represents the graphics elements that were the original input into the `<filter>` element.
     */
    public data object SourceGraphic : In, ConstantSvgAttributeType("SourceGraphic")

    /**
     * This keyword represents the graphics elements that were the original input into the `<filter>` element.
     * SourceAlpha has all of the same rules as [SourceGraphic] except that only the alpha channel is used.
     */
    public data object SourceAlpha : In, ConstantSvgAttributeType("SourceAlpha")

    /**
     * This keyword represents an image snapshot of the SVG document under the filter region at the time that the
     * `<filter>` element was invoked.
     */
    public data object BackgroundImage : In, ConstantSvgAttributeType("BackgroundImage")

    /**
     * Same as [BackgroundImage] except only the alpha channel is used.
     */
    public data object BackgroundAlpha : In, ConstantSvgAttributeType("BackgroundAlpha")

    /**
     * This keyword represents the value of the `fill` property on the target element for the filter effect.
     * In many cases, the FillPaint is opaque everywhere, but that might not be the case if a shape is painted
     * with a gradient or pattern which itself includes transparent or semi-transparent parts.
     */
    public data object FillPaint : In, ConstantSvgAttributeType("FillPaint")

    /**
     * This keyword represents the value of the `stroke` property on the target element for the filter effect.
     * In many cases, the StrokePaint is opaque everywhere, but that might not be the case if a shape is painted with
     * a gradient or pattern which itself includes transparent or semi-transparent parts.
     */
    public data object StrokePaint : In, ConstantSvgAttributeType("StrokePaint")

    /**
     * This value is an assigned name for the filter primitive in the form of a `<custom-ident>`. If supplied, then
     * graphics that result from processing this filter primitive can be referenced by an in attribute on a subsequent
     * filter primitive within the same filter element. If no value is provided, the output will only be available
     * for re-use as the implicit input into the next filter primitive if that filter primitive provides no value for
     * its in attribute.
     */
    public class Primitive(
        public val value: String,
    ) : ConstantSvgAttributeType(value),
        In
}
