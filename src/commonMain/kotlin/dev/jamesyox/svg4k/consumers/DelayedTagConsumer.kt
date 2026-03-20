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

package dev.jamesyox.svg4k.consumers

import dev.jamesyox.svg4k.SvgTag
import dev.jamesyox.svg4k.TagConsumer
import dev.jamesyox.svg4k.attr.AttributeConsumer

/*
 * A lot of this was based heavily on the approach used in kotlinx-html for tag consumption.
 * https://github.com/Kotlin/kotlinx.html
 */
internal class DelayedTagConsumer<T>(
    private val child: TagConsumer<T>,
) : TagConsumer<T>, AttributeConsumer {
    private var delayed: SvgTag? = null

    override fun onTagStart(tag: SvgTag) {
        process()
        delayed = tag
    }

    override fun onTagContent(content: String) {
        process()
        child.onTagContent(content)
    }

    override fun onTagEnd(tag: SvgTag) {
        process()
        child.onTagEnd(tag)
    }

    override fun output(): T = child.output()

    override val attributeConsumer: AttributeConsumer get() = this
    private val childAttributeConsumer = child.attributeConsumer

    private fun process() {
        delayed?.let { tag ->
            delayed = null
            child.onTagStart(tag)
        }
    }

    override fun set(key: String, value: String) {
        // I really hope there's a way to fix this some day. Kotlinx-Html has the same issue.
        if (delayed == null) {
            throw IllegalStateException("Attributes must be set before starting a child element!")
        }
        childAttributeConsumer[key] = value
    }

    override fun get(key: String): String? = childAttributeConsumer[key]

    override val attributesMap: Map<String, String> get() = childAttributeConsumer.attributesMap
}

public fun <T> TagConsumer<T>.delayed(): TagConsumer<T> = DelayedTagConsumer(this)
