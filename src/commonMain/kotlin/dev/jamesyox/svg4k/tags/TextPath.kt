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
import dev.jamesyox.svg4k.tags.categories.category.TextContentChildElement
import dev.jamesyox.svg4k.tags.categories.category.TextContentElement
import dev.jamesyox.svg4k.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4k.tags.categories.container.ElementContainer
import dev.jamesyox.svg4k.tags.categories.container.TextContentContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object TextPath :
    SvgTag,
    TextContentElement,
    TextContentChildElement,
    TextContentContainer,
    DescriptiveElementContainer,
    ElementContainer.A,
    ElementContainer.Animate,
    ElementContainer.Set,
    ElementContainer.Tspan,
    AttributeContainer.AlignmentBaseline,
    AttributeContainer.BaselineShift,
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
    AttributeContainer.Method,
    AttributeContainer.Opacity,
    AttributeContainer.PaintOrder,
    AttributeContainer.PointerEvents,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.Side,
    AttributeContainer.Spacing,
    AttributeContainer.StartOffset,
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
    AttributeContainer.TextLength,
    AttributeContainer.UnicodeBidi,
    AttributeContainer.VectorEffect,
    AttributeContainer.Visibility,
    AttributeContainer.WhiteSpace,
    AttributeContainer.WordSpacing {
    override val tagName: String = "textPath"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.TextPath)
public fun <T> textPath(content: context(AttributeConsumer, @SvgTagDSL TextPath) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = TextPath, content = content)
}
