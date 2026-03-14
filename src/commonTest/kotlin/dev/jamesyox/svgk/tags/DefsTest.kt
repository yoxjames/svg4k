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
import dev.jamesyox.svgk.attr.attrs.fill
import dev.jamesyox.svgk.attr.attrs.gradientTransform
import dev.jamesyox.svgk.attr.attrs.href
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.offset
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.stopColor
import dev.jamesyox.svgk.attr.attrs.url
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.x
import dev.jamesyox.svgk.attr.attrs.y
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.attr.types.obj.pct
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.util.rotate
import kotlin.test.Test
import kotlin.test.assertEquals

class DefsTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 10 10">
                <defs>
                    <circle
                        id="myCircle"
                        cx="0"
                        cy="0"
                        r="5" />
                    <linearGradient
                        id="myGradient"
                        gradientTransform="rotate(90)">
                        <stop
                            offset="20%"
                            stop-color="gold" />
                        <stop
                            offset="90%"
                            stop-color="red" />
                    </linearGradient>
                </defs>
                <use
                    x="5"
                    y="5"
                    href="#myCircle"
                    fill="url('#myGradient')" />
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 10, 10)
                defs {
                    circle {
                        id = "myCircle"
                        cx = 0.none
                        cy = 0.none
                        r = 5.none
                    }
                    linearGradient {
                        id = "myGradient"
                        gradientTransform {
                            rotate(90)
                        }
                        stop {
                            offset = 20.pct
                            stopColor = "gold"
                        }
                        stop {
                            offset = 90.pct
                            stopColor = "red"
                        }
                    }
                }
                use {
                    x = 5.none
                    y = 5.none
                    href = "#myCircle"
                    fill = url("'#myGradient'").svgString
                }
            }
        }
        assertEquals(expected, actual)
    }
}