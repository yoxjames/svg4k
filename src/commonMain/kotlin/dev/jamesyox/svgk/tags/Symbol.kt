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
import dev.jamesyox.svgk.tags.categories.category.StructuralElement
import dev.jamesyox.svgk.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svgk.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svgk.tags.categories.container.ElementContainer
import dev.jamesyox.svgk.tags.categories.container.GradientElementContainer
import dev.jamesyox.svgk.tags.categories.container.ShapeElementContainer
import dev.jamesyox.svgk.tags.categories.container.StructuralElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Symbol :
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
    AttributeContainer.ClipPath,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.PointerEvents,
    AttributeContainer.PreserveAspectRatio,
    AttributeContainer.ViewBox,
    AttributeContainer.Height,
    AttributeContainer.Width,
    AttributeContainer.RefX,
    AttributeContainer.RefY,
    AttributeContainer.X,
    AttributeContainer.Y {
    override val tagName: String = "symbol"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Switch)
public fun <T> symbol(content: context(AttributeConsumer, @SvgTagDSL Symbol) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Symbol, content = content)
}
