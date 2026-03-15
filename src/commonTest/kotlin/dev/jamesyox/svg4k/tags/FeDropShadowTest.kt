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

import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.cx
import dev.jamesyox.svg4k.attr.attrs.cy
import dev.jamesyox.svg4k.attr.attrs.dx
import dev.jamesyox.svg4k.attr.attrs.dy
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.filter
import dev.jamesyox.svg4k.attr.attrs.floodColor
import dev.jamesyox.svg4k.attr.attrs.floodOpacity
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.stdDeviation
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.pct
import dev.jamesyox.svg4k.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class FeDropShadowTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 30 10">
                <defs>
                    <filter
                        id="shadow">
                        <feDropShadow
                            dx="0.2"
                            dy="0.4"
                            stdDeviation="0.2" />
                    </filter>
                    <filter
                        id="shadow2">
                        <feDropShadow
                            dx="0"
                            dy="0"
                            stdDeviation="0.5"
                            flood-color="cyan" />
                    </filter>
                    <filter
                        id="shadow3">
                        <feDropShadow
                            dx="-0.8"
                            dy="-0.8"
                            stdDeviation="0"
                            flood-color="pink"
                            flood-opacity="0.5" />
                    </filter>
                </defs>
                <circle
                    cx="5"
                    cy="50%"
                    r="4"
                    fill="pink"
                    filter="url(#shadow)" />
                <circle
                    cx="15"
                    cy="50%"
                    r="4"
                    fill="pink"
                    filter="url(#shadow2)" />
                <circle
                    cx="25"
                    cy="50%"
                    r="4"
                    fill="pink"
                    filter="url(#shadow3)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 30, 10)
                defs {
                    filter {
                        id = "shadow"
                        feDropShadow {
                            dx = 0.2
                            dy = 0.4
                            stdDeviation = NumberOptionalNumber(0.2, null)
                        }
                    }
                    filter {
                        id = "shadow2"
                        feDropShadow {
                            dx = 0
                            dy = 0
                            stdDeviation = NumberOptionalNumber(0.5, null)
                            floodColor = "cyan"
                        }
                    }
                    filter {
                        id = "shadow3"
                        feDropShadow {
                            dx = -0.8
                            dy = -0.8
                            stdDeviation = NumberOptionalNumber(0, null)
                            floodColor = "pink"
                            floodOpacity = 0.5
                        }
                    }
                }
                circle {
                    cx = 5.none
                    cy = 50.pct
                    r = 4.none
                    fill = "pink"
                    filter = "url(#shadow)"
                }
                circle {
                    cx = 15.none
                    cy = 50.pct
                    r = 4.none
                    fill = "pink"
                    filter = "url(#shadow2)"
                }
                circle {
                    cx = 25.none
                    cy = 50.pct
                    r = 4.none
                    fill = "pink"
                    filter = "url(#shadow3)"
                }
            }
        }

        assertEquals(expected, actual)
    }
}