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

import dev.jamesyox.svg4k.attr.attrs.TextAnchor
import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.cx
import dev.jamesyox.svg4k.attr.attrs.cy
import dev.jamesyox.svg4k.attr.attrs.href
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.textAnchor
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class ATest {
    @Test
    fun mozillaTest() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 100 100">
                <a
                    href="/docs/Web/SVG/Reference/Element/circle">
                    <circle
                        cx="50"
                        cy="40"
                        r="35" />
                </a>
                <a
                    href="/docs/Web/SVG/Reference/Element/text">
                    <text
                        x="50"
                        y="90"
                        text-anchor="middle">
                        &lt;circle&gt;
                    </text>
                </a>
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 100, 100)
                a {
                    href = "/docs/Web/SVG/Reference/Element/circle"
                    circle {
                        cx = 50.none
                        cy = 40.none
                        r = 35.none
                    }
                }
                a {
                    href = "/docs/Web/SVG/Reference/Element/text"
                    text {
                        x = listOf(50.none)
                        y = listOf(90.none)
                        textAnchor = TextAnchor.Middle
                        +"&lt;circle&gt;"
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }
}