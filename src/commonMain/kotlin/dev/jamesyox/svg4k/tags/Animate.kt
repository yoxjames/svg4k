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

package dev.jamesyox.svg4k.tags

import dev.jamesyox.svg4k.SvgTag
import dev.jamesyox.svg4k.SvgTagDSL
import dev.jamesyox.svg4k.TagConsumer
import dev.jamesyox.svg4k.attr.AttributeConsumer
import dev.jamesyox.svg4k.attr.AttributeContainer
import dev.jamesyox.svg4k.consumeTag
import dev.jamesyox.svg4k.tags.categories.category.AnimationElement
import dev.jamesyox.svg4k.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4k.tags.categories.container.DescriptiveElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Animate :
    SvgTag,
    AnimationElement,
    DescriptiveElementContainer,
    AttributeContainer.Accumulate,
    AttributeContainer.Additive,
    AttributeContainer.AttributeName,
    AttributeContainer.AttributeType,
    AttributeContainer.Begin,
    AttributeContainer.By,
    AttributeContainer.CalcMode,
    AttributeContainer.Dur,
    AttributeContainer.End,
    AttributeContainer.Fill.Animation,
    AttributeContainer.From,
    AttributeContainer.Href,
    AttributeContainer.KeyPoints,
    AttributeContainer.KeySplines,
    AttributeContainer.KeyTimes,
    AttributeContainer.Max,
    AttributeContainer.Min,
    AttributeContainer.RepeatCount,
    AttributeContainer.RepeatDur,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.Restart,
    AttributeContainer.SystemLanguage,
    AttributeContainer.To,
    AttributeContainer.Values {
    override val tagName: String = "animate"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: AnimationElementContainer)
public fun <T> animate(content: context(AttributeConsumer, @SvgTagDSL Animate) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Animate, content = content)
}
