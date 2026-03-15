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

// TODO: Add citation for kotlinx-html

package dev.jamesyox.svg4k.consumers

import dev.jamesyox.svg4k.SvgTag
import dev.jamesyox.svg4k.TagConsumer
import dev.jamesyox.svg4k.attr.AttributeConsumer

/*
 * A lot of this was based heavily on the approach used in kotlinx-html for tag consumption.
 * https://github.com/Kotlin/kotlinx.html
 */
internal class FinalizeTagConsumer<F, T>(
    private val delegate: TagConsumer<F>,
    private val block: (F, Boolean) -> T
) : TagConsumer<T> {
    private var level = 0

    override fun onTagStart(tag: SvgTag) {
        level++
        delegate.onTagStart(tag)
    }

    override fun onTagEnd(tag: SvgTag) {
        level--
        delegate.onTagEnd(tag)
    }

    override fun onTagContent(content: String) = delegate.onTagContent(content)

    override fun output(): T {
        return block(delegate.output(), level > 0)
    }

    override val attributeConsumer: AttributeConsumer get() = delegate.attributeConsumer
}

public fun <T> TagConsumer<T>.onFinalize(block: (T, Boolean) -> Unit): TagConsumer<T> {
    return FinalizeTagConsumer(this) { to, partial -> block(to, partial); to }
}