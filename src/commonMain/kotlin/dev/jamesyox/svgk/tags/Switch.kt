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

package dev.jamesyox.svgk.tags

import dev.jamesyox.svgk.SvgTag
import dev.jamesyox.svgk.SvgTagDSL
import dev.jamesyox.svgk.TagConsumer
import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.AttributeContainer
import dev.jamesyox.svgk.consumeTag
import dev.jamesyox.svgk.tags.categories.category.ContainerElement
import dev.jamesyox.svgk.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svgk.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svgk.tags.categories.container.ElementContainer
import dev.jamesyox.svgk.tags.categories.container.ShapeElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Switch :
    SvgTag,
    ContainerElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    ShapeElementContainer,
    ElementContainer.A,
    ElementContainer.ForeignObject,
    ElementContainer.G,
    ElementContainer.Image,
    ElementContainer.Svg,
    ElementContainer.Switch,
    ElementContainer.Text,
    ElementContainer.Use,
    AttributeContainer.Opacity,
    AttributeContainer.PointerEvents,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Transform {
    override val tagName: String = "switch"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Switch)
public fun <T> switch(content: context(AttributeConsumer, @SvgTagDSL Switch) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Switch, content = content)
}
