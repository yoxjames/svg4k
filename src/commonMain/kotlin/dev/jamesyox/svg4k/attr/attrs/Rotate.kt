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
import dev.jamesyox.svg4k.attr.WrappedNumberSvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `rotate` attribute specifies how the animated element rotates as it travels along a path specified
 * in an [dev.jamesyox.svg4k.tags.AnimateMotion] element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Rotate
)
public var rotate: Rotate
    get() = noGet()
    set(value) {
        ac["rotate"] = value
    }

public sealed interface Rotate : SvgAttributeType {
    /**
     * The [Auto] and [AutoReverse] values allow the animated element's rotation to change dynamically
     * as it travels along the path. If the value of rotate is auto, the element turns to align its
     * right-hand side in the current direction of motion
     */
    public data object Auto : Rotate, ConstantSvgAttributeType("auto")

    /**
     * The [Auto] and [AutoReverse] values allow the animated element's rotation to change dynamically
     * as it travels along the path. If the value is auto-reverse, it turns its left-hand side in the current
     * direction of motion.
     */
    public data object AutoReverse : Rotate, ConstantSvgAttributeType("rotate-reverse")

    /**
     * Setting rotate's value to a number specifies a constant rotation, in degrees, that does not change with the
     * animation. The default value of 0 keeps the animated element in its original orientation.
     */
    public class Value(
        public val value: Number,
    ) : WrappedNumberSvgAttributeType(value),
        Rotate
}
