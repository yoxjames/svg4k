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
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.points
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.stroke
import dev.jamesyox.svgk.attr.attrs.strokeWidth
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.types.obj.Point
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.attr.types.obj.pct
import dev.jamesyox.svgk.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class PatternTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 230 100">
                <defs>
                    <pattern
                        id="star"
                        viewBox="0 0 10 10"
                        width="10%"
                        height="10%">
                        <polygon
                            points="0,0 2,5 0,10 5,8 10,10 8,5 10,0 5,2" />
                    </pattern>
                </defs>
                <circle
                    cx="50"
                    cy="50"
                    r="50"
                    fill="url(#star)" />
                <circle
                    cx="180"
                    cy="50"
                    r="40"
                    fill="none"
                    stroke-width="20"
                    stroke="url(#star)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 230, 100)
                defs {
                    pattern {
                        id = "star"
                        viewBox = ViewBox(0, 0, 10, 10)
                        width = 10.pct
                        height = 10.pct
                        polygon {
                            points = listOf(
                                Point(0, 0),
                                Point(2, 5),
                                Point(0, 10),
                                Point(5, 8),
                                Point(10, 10),
                                Point(8, 5),
                                Point(10, 0),
                                Point(5, 2)
                            )
                        }
                    }
                }
                circle {
                    cx = 50.none
                    cy = 50.none
                    r = 50.none
                    fill = "url(#star)"
                }
                circle {
                    cx = 180.none
                    cy = 50.none
                    r = 40.none
                    fill = "none"
                    strokeWidth = 20.none
                    stroke = "url(#star)"
                }
            }
        }

        assertEquals(expected, actual)
    }
}