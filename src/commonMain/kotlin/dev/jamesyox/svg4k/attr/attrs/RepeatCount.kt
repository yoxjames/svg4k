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
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `repeatCount` attribute indicates the number of times an animation will take place.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.RepeatCount
)
public var repeatCount: RepeatCount
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["repeatCount"] = value
    }

public sealed interface RepeatCount : SvgAttributeType {
    /**
     * This value indicates that the animation will be repeated indefinitely (i.e., until the document ends).
     */
    public data object Indefinite : RepeatCount, ConstantSvgAttributeType("indefinite")

    /**
     * This value specifies the number of iterations. It can include partial iterations expressed as fraction values.
     * A fractional value describes a portion of the simple duration. Values must be greater than 0.
     */
    public class Value(
        public val value: Number,
    ) : WrappedNumberSvgAttributeType(value),
        RepeatCount
}
