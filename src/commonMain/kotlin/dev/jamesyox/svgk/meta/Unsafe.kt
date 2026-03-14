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

package dev.jamesyox.svgk.meta

import dev.jamesyox.svgk.SvgTagDSL
import dev.jamesyox.svgk.attr.AllAttributeContainer
import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.attr.svgString
import dev.jamesyox.svgk.tags.categories.container.AnyContentContainer
import kotlin.time.Duration

public object Unsafe : AnyContentContainer, AllAttributeContainer {
    context(ac: AttributeConsumer)
    public operator fun set(
        key: String,
        value: SvgAttributeType,
    ) {
        ac[key] = value
    }

    context(ac: AttributeConsumer)
    public operator fun set(
        key: String,
        value: Number,
    ) {
        ac[key] = value.svgString
    }

    context(ac: AttributeConsumer)
    public operator fun set(
        key: String,
        value: Duration,
    ) {
        ac[key] = value.svgString
    }

    context(ac: AttributeConsumer)
    public operator fun set(
        key: String,
        value: Boolean,
    ) {
        ac[key] = value.svgString
    }

    context(ac: AttributeConsumer)
    public operator fun set(
        key: String,
        value: String,
    ) {
        ac[key] = value
    }
}

context(ac: AttributeConsumer, _: Unsafe)
public val attr: AttributeConsumer get() = ac

context(ac: AttributeConsumer)
public fun unsafe(block: context(@SvgTagDSL Unsafe, AttributeConsumer) () -> Unit): Unit = context(Unsafe, ac, block)

context(ac: AttributeConsumer)
public fun unsafeCascading(block: context(Unsafe, AttributeConsumer) () -> Unit): Unit = context(Unsafe, ac, block)
