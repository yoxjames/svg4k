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
import dev.jamesyox.svg4k.attr.WrappedDurationSvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError
import kotlin.time.Duration

/**
 * The `repeatDur` attribute specifies the total duration for repeating an animation.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.RepeatDur
)
public var repeatDur: RepeatDur
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["repeatDur"] = value
    }

/**
 * The `repeatDur` attribute specifies the total duration for repeating an animation.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.RepeatDur
)
public fun repeatDur(value: Duration) {
    repeatDur = RepeatDur.Value(value)
}

public sealed interface RepeatDur : SvgAttributeType {
    /**
     * This value indicates that the animation will be repeated indefinitely (i.e., until the document ends).
     */
    public data object Indefinite : RepeatDur, ConstantSvgAttributeType("indefinite")

    /**
     * This value specifies the duration in presentation time to repeat the animation.
     */
    public class Value(
        public val value: Duration,
    ) : WrappedDurationSvgAttributeType(value),
        RepeatDur
}
