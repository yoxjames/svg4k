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
import dev.jamesyox.svg4k.attr.AllAttributeContainer
import dev.jamesyox.svg4k.attr.AttributeConsumer
import dev.jamesyox.svg4k.consumeTag
import dev.jamesyox.svg4k.tags.categories.category.ContainerElement
import dev.jamesyox.svg4k.tags.categories.category.StructuralElement
import dev.jamesyox.svg4k.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4k.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4k.tags.categories.container.ElementContainer
import dev.jamesyox.svg4k.tags.categories.container.GradientElementContainer
import dev.jamesyox.svg4k.tags.categories.container.ShapeElementContainer
import dev.jamesyox.svg4k.tags.categories.container.StructuralElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public typealias Group = G

public data object G :
    SvgTag,
    ContainerElement,
    StructuralElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    ShapeElementContainer,
    StructuralElementContainer,
    GradientElementContainer,
    ElementContainer.A,
    ElementContainer.ClipPath,
    ElementContainer.Filter,
    ElementContainer.ForeignObject,
    ElementContainer.Image,
    ElementContainer.Marker,
    ElementContainer.Mask,
    ElementContainer.Pattern,
    ElementContainer.Script,
    ElementContainer.Style,
    ElementContainer.Switch,
    ElementContainer.Text,
    ElementContainer.View,
    AllAttributeContainer {
    override val tagName: String = "g"
}

@IgnorableReturnValue
context(tagConsumer: TagConsumer<T>, _: ElementContainer.G)
public fun <T> g(content: context (AttributeConsumer, @SvgTagDSL G) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = G, content = content)
}
