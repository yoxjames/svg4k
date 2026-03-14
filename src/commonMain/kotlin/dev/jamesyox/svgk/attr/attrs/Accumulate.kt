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
 * The accumulate attribute controls whether or not an animation is cumulative.
 *
 * It is frequently useful for repeated animations to build upon the previous results,
 * accumulating with each iteration. This attribute said to the animation if the value
 * is added to the previous animated attribute's value on each iteration.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Accumulate
)
public var accumulate: Accumulate
    get() = noGet()
    set(value) {
        ac["accumulate"] = value
    }

public enum class Accumulate(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Specifies that each repeat iteration after the first builds upon the last value of the
     * previous iteration.
     */
    Sum("sum"),

    /**
     * Specifies that repeat iterations are not cumulative.
     */
    None("none"),
}
