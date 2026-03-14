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
import dev.jamesyox.svgk.attr.AllAttributeContainer
import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.consumeTag
import dev.jamesyox.svgk.tags.categories.category.GraphicsElement
import dev.jamesyox.svgk.tags.categories.category.GraphicsReferencingElement
import dev.jamesyox.svgk.tags.categories.category.StructuralElement
import dev.jamesyox.svgk.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svgk.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svgk.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Use :
    SvgTag,
    GraphicsElement,
    GraphicsReferencingElement,
    StructuralElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    AllAttributeContainer {
    override val tagName: String = "use"
}

@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Use)
public fun <T> use(content: context(AttributeConsumer, @SvgTagDSL Use) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Use, content = content)
}