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

package dev.jamesyox.svg4k

import dev.jamesyox.svg4k.attr.AttributeConsumer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public interface TagConsumer<out T> {
    public fun onTagStart(tag: SvgTag)

    public fun onTagContent(content: String)

    public fun onTagEnd(tag: SvgTag)

    public fun output(): T

    public val attributeConsumer: AttributeConsumer
}

context(tagConsumer: TagConsumer<T>)
internal inline fun <T, ST : SvgTag> consumeTag(
    tag: ST,
    content: context(AttributeConsumer, ST) () -> Unit,
): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    // Grab out the attributes. Ignore tags for now
    tagConsumer.onTagStart(tag)
    content(tagConsumer.attributeConsumer, tag)
    tagConsumer.onTagEnd(tag)
    return tagConsumer.output()
}
