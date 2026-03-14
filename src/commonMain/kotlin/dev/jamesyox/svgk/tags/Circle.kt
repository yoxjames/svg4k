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

import dev.jamesyox.svgk.SvgTagDSL
import dev.jamesyox.svgk.TagConsumer
import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.AttributeContainer
import dev.jamesyox.svgk.consumeTag
import dev.jamesyox.svgk.tags.categories.category.GraphicsElement
import dev.jamesyox.svgk.tags.categories.category.ShapeElement
import dev.jamesyox.svgk.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svgk.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svgk.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Circle :
    ShapeElement,
    GraphicsElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    AttributeContainer.ClipPath,
    AttributeContainer.Cx,
    AttributeContainer.Cy,
    AttributeContainer.Fill.Presentational,
    AttributeContainer.FillOpacity,
    AttributeContainer.MarkerEnd,
    AttributeContainer.MarkerMid,
    AttributeContainer.MarkerStart,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.PaintOrder,
    AttributeContainer.PathLength,
    AttributeContainer.PointerEvents,
    AttributeContainer.R,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.ShapeRendering,
    AttributeContainer.Stroke,
    AttributeContainer.StrokeDasharray,
    AttributeContainer.StrokeDashoffset,
    AttributeContainer.StrokeOpacity,
    AttributeContainer.StrokeWidth,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Transform,
    AttributeContainer.VectorEffect,
    AttributeContainer.Visibility {
    override val tagName: String = "circle"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Circle)
public fun <T> circle(content: context(AttributeConsumer, @SvgTagDSL Circle) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Circle, content = content)
}
