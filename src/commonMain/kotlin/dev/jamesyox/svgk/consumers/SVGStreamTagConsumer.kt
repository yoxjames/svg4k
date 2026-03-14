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
import dev.jamesyox.svgk.attr.InMemoryAttributeConsumer
import dev.jamesyox.svgk.meta.RootContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/*
 * A lot of this was based heavily on the approach used in kotlinx-html for tag consumption.
 * https://github.com/Kotlin/kotlinx.html
 */
public class SVGStreamTagConsumer<T : Appendable>(
    private val appendable: T,
    private val isPrettyPrint: Boolean,
): TagConsumer<T> {
    private var level = 0
    private var isTagOpen: Boolean = false
    private var lastTag: Pair<Int, SvgTag>? = null

    override val attributeConsumer: InMemoryAttributeConsumer = InMemoryAttributeConsumer()

    override fun onTagStart(tag: SvgTag): Unit = with(appendable) {
        if (isTagOpen) {
            append(">")
            if (isPrettyPrint) appendLn()
        }
        lastTag = level to tag
        val hasAttributes = attributeConsumer.attributesMap.isNotEmpty()
            appendIndented(level = level, text = "<${tag.tagName}")
            if (isPrettyPrint && hasAttributes) {
                appendLn()
            } else if (!isPrettyPrint && hasAttributes) {
                append(" ")
            }
            if (hasAttributes) {
                attributeConsumer.attributesMap
                    .toList()
                    .joinToString(
                        // Go in one level since we want to indent attributes. No need to mutate the level though
                        separator = if (isPrettyPrint) "\n${indented(level + 1)}" else " ",
                        prefix = if (isPrettyPrint) indented(level + 1) else "",
                        transform = { "${it.first}=\"${it.second}\"" }
                    ).also { append(it) }
            }
        isTagOpen = true
        attributeConsumer.clear()
        level++
    }

    private fun Appendable.appendLn() {
        append("\n")
    }

    private fun Appendable.appendIndented(level: Int, text: String) {
        append("${indented(level)}$text")
    }

    private fun indented(count: Int) = if (isPrettyPrint) "    ".repeat(count) else ""

    override fun onTagContent(content: String): Unit = with(appendable) {
        if (isTagOpen) {
            append(">")
            if (isPrettyPrint) appendLn()
            isTagOpen = false
        }
        if (isPrettyPrint) {
            content
                .lines()
                .joinToString(separator = "\n") { "${indented(level)}$it" }
                .also { append(it) }
        } else {
            append(content)
        }
        if (isPrettyPrint) appendLn()
    }

    override fun onTagEnd(tag: SvgTag) {
        level--
        with(appendable) {
            when (lastTag == level to tag && isTagOpen) {
                true -> append(" />")
                false -> appendIndented(
                    level = level,
                    text = "</${tag.tagName}>"
                )
            }
            if (isPrettyPrint && level > 0) appendLn()
        }
        isTagOpen = false
    }

    override fun output(): T = appendable
}

public inline fun <T : Appendable> T.appendSVG(
    isPrettyPrint: Boolean = false,
    block: context(TagConsumer<T>, RootContainer) () -> Unit
): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return context(RootContainer) {
        SVGStreamTagConsumer(
            isPrettyPrint = isPrettyPrint,
            appendable = this
        ).delayed()
            .apply { block() }
            .output()
    }
}

/**
 * Create SVG to be returned as a [String]
 */
public inline fun svgString(
    isPrettyPrint: Boolean = false,
    block: context(TagConsumer<StringBuilder>, RootContainer) () -> Unit
): String {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return StringBuilder().appendSVG(isPrettyPrint = isPrettyPrint, block = block).toString()
}
