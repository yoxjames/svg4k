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

import dev.jamesyox.svgk.attr.attrs.Orient
import dev.jamesyox.svgk.attr.attrs.RefX
import dev.jamesyox.svgk.attr.attrs.RefY
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.d
import dev.jamesyox.svgk.attr.attrs.fill
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.markerEnd
import dev.jamesyox.svgk.attr.attrs.markerHeight
import dev.jamesyox.svgk.attr.attrs.markerMid
import dev.jamesyox.svgk.attr.attrs.markerStart
import dev.jamesyox.svgk.attr.attrs.markerWidth
import dev.jamesyox.svgk.attr.attrs.orient
import dev.jamesyox.svgk.attr.attrs.refX
import dev.jamesyox.svgk.attr.attrs.refY
import dev.jamesyox.svgk.attr.attrs.stroke
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.x1
import dev.jamesyox.svgk.attr.attrs.x2
import dev.jamesyox.svgk.attr.attrs.y1
import dev.jamesyox.svgk.attr.attrs.y2
import dev.jamesyox.svgk.attr.types.obj.Url
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.util.C
import dev.jamesyox.svgk.util.L
import dev.jamesyox.svgk.util.M
import dev.jamesyox.svgk.util.Z
import kotlin.test.Test
import kotlin.test.assertEquals

class MarkerTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 300 100">
                <defs>
                    <marker
                        id="arrow"
                        viewBox="0 0 10 10"
                        refX="5"
                        refY="5"
                        markerWidth="6"
                        markerHeight="6"
                        orient="auto-start-reverse">
                        <path
                            d="M 0 0 L 10 5 L 0 10 Z" />
                    </marker>
                </defs>
                <line
                    x1="10"
                    y1="10"
                    x2="90"
                    y2="90"
                    stroke="black"
                    marker-end="url(#arrow)" />
                <path
                    d="M 110 10 C 120 20 130 20 140 10 C 150 0 160 0 170 10 C 180 20 190 20 200 10"
                    stroke="black"
                    fill="none"
                    marker-start="url(#arrow)"
                    marker-mid="url(#arrow)"
                    marker-end="url(#arrow)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 300, 100)
                defs {
                    marker {
                        id = "arrow"
                        viewBox = ViewBox(0, 0, 10, 10)
                        refX = RefX.Value(5.none)
                        refY = RefY.Value(5.none)
                        markerWidth = 6.none
                        markerHeight = 6.none
                        orient = Orient.AutoStartReverse
                        path {
                            d {
                                M(0, 0)
                                L(10, 5)
                                L(0, 10)
                                Z
                            }
                        }
                    }
                }
                line {
                    x1 = 10.none
                    y1 = 10.none
                    x2 = 90.none
                    y2 = 90.none
                    stroke = "black"
                    markerEnd = Url("#arrow")
                }
                path {
                    d {
                        M(110, 10)
                        C(120, 20, 130, 20, 140, 10)
                        C(150, 0, 160, 0, 170, 10)
                        C(180, 20, 190, 20, 200, 10)
                    }
                    stroke = "black"
                    fill = "none"
                    markerStart = Url("#arrow")
                    markerMid = Url("#arrow")
                    markerEnd = Url("#arrow")
                }
            }
        }

        assertEquals(expected, actual)
    }
}