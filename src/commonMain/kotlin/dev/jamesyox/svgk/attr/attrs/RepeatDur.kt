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
import dev.jamesyox.svgk.attr.WrappedDurationSvgAttributeType
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.meta.noGet
import kotlin.time.Duration

/**
 * The `repeatDur` attribute specifies the total duration for repeating an animation.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.RepeatDur
)
public var repeatDur: RepeatDur
    get() = noGet()
    set(value) {
        ac["repeatDur"] = value
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
