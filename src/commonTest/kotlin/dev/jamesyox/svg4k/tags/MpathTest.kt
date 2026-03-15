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

import dev.jamesyox.svg4k.attr.attrs.Dur
import dev.jamesyox.svg4k.attr.attrs.RepeatCount
import dev.jamesyox.svg4k.attr.attrs.Rotate
import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.cx
import dev.jamesyox.svg4k.attr.attrs.cy
import dev.jamesyox.svg4k.attr.attrs.d
import dev.jamesyox.svg4k.attr.attrs.dur
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.href
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.repeatCount
import dev.jamesyox.svg4k.attr.attrs.rotate
import dev.jamesyox.svg4k.attr.attrs.stroke
import dev.jamesyox.svg4k.attr.attrs.strokeWidth
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.pct
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.util.C
import dev.jamesyox.svg4k.util.L
import dev.jamesyox.svg4k.util.M
import dev.jamesyox.svg4k.util.Z
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds

class MpathTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="100%"
                height="100%"
                viewBox="0 0 500 300">
                <rect
                    x="1"
                    y="1"
                    width="498"
                    height="298"
                    fill="none"
                    stroke="blue"
                    stroke-width="2" />
                <path
                    id="path1"
                    d="M 100 250 C 100 50 400 50 400 250"
                    fill="none"
                    stroke="blue"
                    stroke-width="7.06" />
                <circle
                    cx="100"
                    cy="250"
                    r="17.64"
                    fill="blue" />
                <circle
                    cx="250"
                    cy="100"
                    r="17.64"
                    fill="blue" />
                <circle
                    cx="400"
                    cy="250"
                    r="17.64"
                    fill="blue" />
                <path
                    d="M -25 -12.5 L 25 -12.5 L 0 -87.5 Z"
                    fill="yellow"
                    stroke="red"
                    stroke-width="7.06">
                    <animateMotion
                        dur="6s"
                        repeatCount="indefinite"
                        rotate="auto">
                        <mpath
                            href="#path1" />
                    </animateMotion>
                </path>
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 100.pct
                height = 100.pct
                viewBox = ViewBox(0, 0, 500, 300)
                rect {
                    x = 1.none
                    y = 1.none
                    width = 498.none
                    height = 298.none
                    fill = "none"
                    stroke = "blue"
                    strokeWidth = 2.none
                }
                path {
                    id = "path1"
                    d {
                        M(100, 250)
                        C(100, 50, 400, 50, 400, 250)
                    }
                    fill = "none"
                    stroke = "blue"
                    strokeWidth = 7.06.none
                }
                circle {
                    cx = 100.none
                    cy = 250.none
                    r = 17.64.none
                    fill = "blue"
                }
                circle {
                    cx = 250.none
                    cy = 100.none
                    r = 17.64.none
                    fill = "blue"
                }
                circle {
                    cx = 400.none
                    cy = 250.none
                    r = 17.64.none
                    fill = "blue"
                }
                path {
                    d {
                        M(-25, -12.5)
                        L(25, -12.5)
                        L(0, -87.5)
                        Z
                    }
                    fill = "yellow"
                    stroke = "red"
                    strokeWidth = 7.06.none
                    animateMotion {
                        dur = Dur.ClockValue(6.seconds)
                        repeatCount = RepeatCount.Indefinite
                        rotate = Rotate.Auto
                        mpath {
                            href = "#path1"
                        }
                    }
                }
            }
        }

        assertEquals(expected, actual)
    }
}