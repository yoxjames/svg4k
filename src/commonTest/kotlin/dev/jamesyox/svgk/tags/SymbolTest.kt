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
import dev.jamesyox.svgk.attr.attrs.cx
import dev.jamesyox.svgk.attr.attrs.cy
import dev.jamesyox.svgk.attr.attrs.d
import dev.jamesyox.svgk.attr.attrs.fill
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.href
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.opacity
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.stroke
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.attrs.x
import dev.jamesyox.svgk.attr.attrs.y
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.util.M
import dev.jamesyox.svgk.util.h
import dev.jamesyox.svgk.util.v
import kotlin.test.Test
import kotlin.test.assertEquals

class SymbolTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 80 20">
                <symbol
                    id="myDot"
                    width="10"
                    height="10"
                    viewBox="0 0 2 2">
                    <circle
                        cx="1"
                        cy="1"
                        r="1" />
                </symbol>
                <path
                    d="M 0 10 h 80 M 10 0 v 20 M 25 0 v 20 M 40 0 v 20 M 55 0 v 20 M 70 0 v 20"
                    fill="none"
                    stroke="pink" />
                <use
                    href="#myDot"
                    x="5"
                    y="5"
                    opacity="${1.0f}" />
                <use
                    href="#myDot"
                    x="20"
                    y="5"
                    opacity="0.8" />
                <use
                    href="#myDot"
                    x="35"
                    y="5"
                    opacity="0.6" />
                <use
                    href="#myDot"
                    x="50"
                    y="5"
                    opacity="0.4" />
                <use
                    href="#myDot"
                    x="65"
                    y="5"
                    opacity="0.2" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 80, 20)
                symbol {
                    id = "myDot"
                    width = 10.none
                    height = 10.none
                    viewBox = ViewBox(0, 0, 2, 2)
                    circle {
                        cx = 1.none
                        cy = 1.none
                        r = 1.none
                    }
                }
                path {
                    d {
                        M(0, 10)
                        h(80)
                        M(10, 0)
                        v(20)
                        M(25, 0)
                        v(20)
                        M(40, 0)
                        v(20)
                        M(55, 0)
                        v(20)
                        M(70, 0)
                        v(20)
                    }
                    fill = "none"
                    stroke = "pink"
                }
                use {
                    href = "#myDot"
                    x = 5.none
                    y = 5.none
                    opacity = 1.0f
                }
                use {
                    href = "#myDot"
                    x = 20.none
                    y = 5.none
                    opacity = 0.8f
                }
                use {
                    href = "#myDot"
                    x = 35.none
                    y = 5.none
                    opacity = 0.6f
                }
                use {
                    href = "#myDot"
                    x = 50.none
                    y = 5.none
                    opacity = 0.4f
                }
                use {
                    href = "#myDot"
                    x = 65.none
                    y = 5.none
                    opacity = 0.2f
                }
            }
        }

        assertEquals(expected, actual)
    }
}