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
import dev.jamesyox.svg4k.tags.categories.category.BasicShapeElement
import dev.jamesyox.svg4k.tags.categories.category.GraphicsElement
import dev.jamesyox.svg4k.tags.categories.category.ShapeElement
import dev.jamesyox.svg4k.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4k.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4k.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Line :
    SvgTag,
    BasicShapeElement,
    GraphicsElement,
    ShapeElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    AttributeContainer.ClipPath,
    AttributeContainer.MarkerEnd,
    AttributeContainer.MarkerMid,
    AttributeContainer.MarkerStart,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.PaintOrder,
    AttributeContainer.PathLength,
    AttributeContainer.PointerEvents,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.ShapeRendering,
    AttributeContainer.Stroke,
    AttributeContainer.StrokeDasharray,
    AttributeContainer.StrokeDashoffset,
    AttributeContainer.StrokeLinecap,
    AttributeContainer.StrokeOpacity,
    AttributeContainer.StrokeWidth,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Transform,
    AttributeContainer.VectorEffect,
    AttributeContainer.Visibility {
    override val tagName: String = "line"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Line)
public fun <T> line(content: context(AttributeConsumer, @SvgTagDSL Line) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Line, content = content)
}
