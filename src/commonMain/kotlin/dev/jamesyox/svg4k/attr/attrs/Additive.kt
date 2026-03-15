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
 * The additive attribute controls whether or not an animation is additive.
 *
 * It is frequently useful to define animation as an offset or delta to an attribute's value, rather
 * than as absolute values.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Additive
)
public var additive: Additive
    get() = noGet()
    set(value) {
        ac["additive"] = value.svgString
    }

public enum class Additive(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * Specifies that the animation will override the underlying value of the attribute and other lower
     * priority animations. This is the default, however the behavior is also affected by the
     * animation value attributes by and to, as described in [SMIL Animation: How from, to and by
     * attributes affect additive behavior](https://www.w3.org/TR/smil-animation/#FromToByAndAdditive).
     */
    Replace("replace"),

    /**
     * Specifies that the animation will add to the underlying value of the attribute and other lower
     * priority animations.
     */
    Sum("sum"),
}
