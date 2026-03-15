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
import dev.jamesyox.svg4k.tags.categories.category.FilterPrimitiveElement
import dev.jamesyox.svg4k.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4k.tags.categories.container.ElementContainer
import dev.jamesyox.svg4k.tags.categories.container.LightSourceElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object FeSpecularLighting :
    SvgTag,
    FilterPrimitiveElement,
    DescriptiveElementContainer,
    LightSourceElementContainer,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.Height,
    AttributeContainer.In,
    AttributeContainer.KernelUnitLength,
    AttributeContainer.LightingColor,
    AttributeContainer.Result,
    AttributeContainer.SpecularConstant,
    AttributeContainer.SpecularExponent,
    AttributeContainer.SurfaceScale,
    AttributeContainer.Width,
    AttributeContainer.X {
    override val tagName: String = "feSpecularLighting"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeSpecularLighting)
public fun <T> feSpecularLighting(content: context(AttributeConsumer, @SvgTagDSL FeSpecularLighting) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeSpecularLighting, content = content)
}
