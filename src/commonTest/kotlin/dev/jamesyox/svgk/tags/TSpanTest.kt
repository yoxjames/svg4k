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

import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.`class`
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.x
import dev.jamesyox.svgk.attr.attrs.y
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class TSpanTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 240 40">
                <style>
                    text {
                      font: italic 12px serif;
                    }
                    tspan {
                      font: bold 10px sans-serif;
                      fill: red;
                    }
                </style>
                <text
                    x="10"
                    y="30"
                    class="small">
                    You are
                    <tspan>not</tspan>
                    a banana!
                </text>
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 240, 40)
                style {
                    +"""
                    text {
                      font: italic 12px serif;
                    }
                    tspan {
                      font: bold 10px sans-serif;
                      fill: red;
                    }
                    """.trimIndent()
                }
                text {
                    x = listOf(10.none)
                    y = listOf(30.none)
                    `class` = "small"
                    +"""
                    You are
                    <tspan>not</tspan>
                    a banana!
                    """.trimIndent()
                }
            }
        }

        assertEquals(expected, actual)
    }
}