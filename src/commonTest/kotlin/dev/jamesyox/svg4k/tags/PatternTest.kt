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
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.points
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.stroke
import dev.jamesyox.svg4k.attr.attrs.strokeWidth
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.types.obj.Point
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.SvgPaint
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.pct
import dev.jamesyox.svg4k.attr.types.obj.url
import dev.jamesyox.svg4k.consumers.svgString
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
                val star = SvgId("star")
                viewBox = ViewBox(0, 0, 230, 100)
                defs {
                    pattern {
                        id = star
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
                    fill(star)
                }
                circle {
                    cx = 180.none
                    cy = 50.none
                    r = 40.none
                    fill = SvgPaint.None
                    strokeWidth = 20.none
                    stroke(star)
                }
            }
        }

        assertEquals(expected, actual)
    }
}