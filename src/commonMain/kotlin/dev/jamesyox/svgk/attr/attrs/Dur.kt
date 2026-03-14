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
 * The dur attribute indicates the simple duration of an animation.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Dur
)
public var dur: Dur
    get() = noGet()
    set(value) {
        ac["dur"] = value
    }

public sealed interface Dur : SvgAttributeType {
    /**
     * The length of the duration
     */
    public class ClockValue(
        duration: Duration,
    ) : WrappedDurationSvgAttributeType(duration),
        Dur

    /**
     * This value specifies the simple duration as the intrinsic media duration. This is only valid for elements that
     * define media. (For animation elements the attribute will be ignored if media is specified.)
     */
    public data object Media : Dur, ConstantSvgAttributeType("media")

    /**
     * This value specifies the simple duration as indefinite.
     */
    public data object Indefinite : Dur, ConstantSvgAttributeType("indefinite")
}
