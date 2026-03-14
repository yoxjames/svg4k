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

import dev.jamesyox.svgk.attr.attrs.Dur
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.attributeName
import dev.jamesyox.svgk.attr.attrs.begin
import dev.jamesyox.svgk.attr.attrs.dur
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.to
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds

class SetTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 10 10">
                <style>
                    rect {
                      cursor: pointer;
                    }
                    .round {
                      rx: 5px;
                      fill: green;
                    }
                </style>
                <rect
                    id="me"
                    width="10"
                    height="10">
                    <set
                        attributeName="class"
                        to="round"
                        begin="me.click"
                        dur="2s" />
                </rect>
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 10, 10)
                style {
                    +"""
                        rect {
                          cursor: pointer;
                        }
                        .round {
                          rx: 5px;
                          fill: green;
                        }
                    """.trimIndent()
                }
                rect {
                    id = "me"
                    width = 10.none
                    height = 10.none
                    set {
                        attributeName = "class"
                        to = "round"
                        begin = "me.click"
                        dur = Dur.ClockValue(2.seconds)
                    }
                }
            }
        }

        assertEquals(expected, actual)
    }
}