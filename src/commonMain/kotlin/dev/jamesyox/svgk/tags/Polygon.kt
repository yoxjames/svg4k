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
import dev.jamesyox.svgk.tags.categories.category.BasicShapeElement
import dev.jamesyox.svgk.tags.categories.category.GraphicsElement
import dev.jamesyox.svgk.tags.categories.category.ShapeElement
import dev.jamesyox.svgk.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svgk.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svgk.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Polygon :
    SvgTag,
    BasicShapeElement,
    GraphicsElement,
    ShapeElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    AttributeContainer.ClipPath,
    AttributeContainer.Fill.Presentational,
    AttributeContainer.FillOpacity,
    AttributeContainer.FillRule,
    AttributeContainer.MarkerEnd,
    AttributeContainer.MarkerMid,
    AttributeContainer.MarkerStart,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.PaintOrder,
    AttributeContainer.PathLength,
    AttributeContainer.PointerEvents,
    AttributeContainer.Points,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.ShapeRendering,
    AttributeContainer.Stroke,
    AttributeContainer.StrokeDasharray,
    AttributeContainer.StrokeDashoffset,
    AttributeContainer.StrokeLinejoin,
    AttributeContainer.StrokeMiterlimit,
    AttributeContainer.StrokeOpacity,
    AttributeContainer.StrokeWidth,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Transform,
    AttributeContainer.VectorEffect,
    AttributeContainer.Visibility {
    override val tagName: String = "polygon"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Polygon)
public fun <T> polygon(content: context(AttributeConsumer, @SvgTagDSL Polygon) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Polygon, content = content)
}
