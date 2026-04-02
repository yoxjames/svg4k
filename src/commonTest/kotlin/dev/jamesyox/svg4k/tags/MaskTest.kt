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

import dev.jamesyox.svg4k.attr.attrs.MaskType
import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.cx
import dev.jamesyox.svg4k.attr.attrs.cy
import dev.jamesyox.svg4k.attr.attrs.d
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.mask
import dev.jamesyox.svg4k.attr.attrs.maskType
import dev.jamesyox.svg4k.attr.attrs.points
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.Point
import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.Url
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.util.A
import dev.jamesyox.svg4k.util.M
import dev.jamesyox.svg4k.util.Q
import dev.jamesyox.svg4k.util.Z
import kotlin.test.Test
import kotlin.test.assertEquals

class MaskTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="-10 -10 120 120">
                <rect
                    x="-10"
                    y="-10"
                    width="120"
                    height="120"
                    fill="blue" />
                <mask
                    id="myMask"
                    mask-type="luminance">
                    <rect
                        x="0"
                        y="0"
                        width="100"
                        height="100"
                        fill="white" />
                    <path
                        d="M 10 35 A 20 20 0 0 1 50 35 A 20 20 0 0 1 90 35 Q 90 65 50 95 Q 10 65 10 35 Z"
                        fill="black" />
                </mask>
                <polygon
                    points="-10,110 110,110 110,-10"
                    fill="orange" />
                <circle
                    cx="50"
                    cy="50"
                    r="50"
                    fill="purple"
                    mask="url(#myMask)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            val myMask = SvgId("myMask")
            svg {
                viewBox = ViewBox(-10, -10, 120, 120)
                rect {
                    x = (-10).none
                    y = (-10).none
                    width = 120.none
                    height = 120.none
                    fill(SvgColor.Blue)
                }
                mask {
                    id = myMask
                    maskType = MaskType.Luminance
                    rect {
                        x = 0.none
                        y = 0.none
                        width = 100.none
                        height = 100.none
                        fill(SvgColor.White)
                    }
                    path {
                        d {
                            M(10, 35)
                            A(rx = 20, ry = 20, angle = 0, largeArcFlag = false, sweepFlag = true, x = 50, y = 35)
                            A(rx = 20, ry = 20, angle = 0, largeArcFlag = false, sweepFlag = true, x = 90, y = 35)
                            Q(x1 = 90, x2 = 65, x = 50, y = 95)
                            Q(x1 = 10, x2 = 65, x = 10, y = 35)
                            Z
                        }
                        fill(SvgColor.Black)
                    }
                }
                polygon {
                    points = listOf(
                        Point(-10, 110),
                        Point(110, 110),
                        Point(110, -10)
                    )
                    fill(SvgColor.Orange)
                }
                circle {
                    cx = 50.none
                    cy = 50.none
                    r = 50.none
                    fill(SvgColor.Purple)
                    mask(myMask)
                }
            }
        }

        assertEquals(expected, actual)
    }
}