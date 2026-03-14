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
import dev.jamesyox.svgk.attr.svgString
import dev.jamesyox.svgk.meta.noGet

/**
 * The `keySplines` attribute defines a set of Bézier curve control points associated with the keyTimes list,
 * defining a cubic Bézier function that controls interval pacing.
 *
 * This attribute is ignored unless the calcMode attribute is set to spline.
 *
 * If there are any errors in the keySplines specification (bad values, too many or too few values), the
 * animation will not occur.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.KeySplines
)
public var keySplines: List<ControlPoint>
    get() = noGet()
    set(value) {
        ac["keySplines"] = value.svgString(";")
    }

/**
 *
 * Each control point description is a set of four values: x1 y1 x2 y2, describing the Bézier control points
 * for one time segment. The keyTimes values that define the associated segment are the Bézier "anchor points",
 * and the keySplines values are the control points. Thus, there must be one fewer sets of control points than
 * there are keyTimes.
 *
 * The values of `x1` `y1` `x2` `y2` must all be in the range 0 to 1.
 */
public class ControlPoint(
    x1: Number,
    y1: Number,
    x2: Number,
    y2: Number,
) : SvgAttributeType {
    override val svgString: String = "$x1 $y1 $x2 $y2"
}
