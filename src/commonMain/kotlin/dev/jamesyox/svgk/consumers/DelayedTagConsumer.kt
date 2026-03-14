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

package dev.jamesyox.svgk.consumers

import dev.jamesyox.svgk.SvgTag
import dev.jamesyox.svgk.TagConsumer
import dev.jamesyox.svgk.attr.AttributeConsumer


/*
 * A lot of this was based heavily on the approach used in kotlinx-html for tag consumption.
 * https://github.com/Kotlin/kotlinx.html
 */
internal class DelayedTagConsumer<T>(
    private val child: TagConsumer<T>,
) : TagConsumer<T> {
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

    override val attributeConsumer: AttributeConsumer get() = child.attributeConsumer

    private fun process() {
        delayed?.let { tag ->
            delayed = null
            child.onTagStart(tag)
        }
    }
}

public fun <T> TagConsumer<T>.delayed(): TagConsumer<T> = DelayedTagConsumer(this)
