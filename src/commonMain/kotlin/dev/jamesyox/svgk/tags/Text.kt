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
import dev.jamesyox.svgk.tags.categories.category.GraphicsElement
import dev.jamesyox.svgk.tags.categories.category.TextContentElement
import dev.jamesyox.svgk.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svgk.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svgk.tags.categories.container.ElementContainer
import dev.jamesyox.svgk.tags.categories.container.TextContentChildElementContainer
import dev.jamesyox.svgk.tags.categories.container.TextContentContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Text :
    SvgTag,
    GraphicsElement,
    TextContentElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    TextContentChildElementContainer,
    TextContentContainer,
    ElementContainer.A,
    AttributeContainer.AlignmentBaseline,
    AttributeContainer.ClipPath,
    AttributeContainer.Direction,
    AttributeContainer.DominantBaseline,
    AttributeContainer.Fill.Presentational,
    AttributeContainer.FillOpacity,
    AttributeContainer.FillRule,
    AttributeContainer.FontFamily,
    AttributeContainer.FontSize,
    AttributeContainer.FontSizeAdjust,
    AttributeContainer.FontStyle,
    AttributeContainer.FontVariant,
    AttributeContainer.FontWeight,
    AttributeContainer.LengthAdjust,
    AttributeContainer.LetterSpacing,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.PaintOrder,
    AttributeContainer.PointerEvents,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.Stroke,
    AttributeContainer.StrokeDasharray,
    AttributeContainer.StrokeDashoffset,
    AttributeContainer.StrokeLinecap,
    AttributeContainer.StrokeLinejoin,
    AttributeContainer.StrokeMiterlimit,
    AttributeContainer.StrokeOpacity,
    AttributeContainer.StrokeWidth,
    AttributeContainer.SystemLanguage,
    AttributeContainer.TextAnchor,
    AttributeContainer.TextDecoration,
    AttributeContainer.TextOverflow,
    AttributeContainer.TextRendering,
    AttributeContainer.TextLength,
    AttributeContainer.Transform,
    AttributeContainer.UnicodeBidi,
    AttributeContainer.VectorEffect,
    AttributeContainer.Visibility,
    AttributeContainer.WhiteSpace,
    AttributeContainer.WordSpacing,
    AttributeContainer.WritingMode {
    override val tagName: String = "text"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Text)
public fun <T> text(content: context(AttributeConsumer, @SvgTagDSL Text) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Text, content = content)
}
