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
import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.d
import dev.jamesyox.svg4k.attr.attrs.dur
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.path
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.repeatCount
import dev.jamesyox.svg4k.attr.attrs.stroke
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import dev.jamesyox.svg4k.attr.types.obj.SvgPaint
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.util.C
import dev.jamesyox.svg4k.util.M
import dev.jamesyox.svg4k.util.Z
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds

class AnimateMotionTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 200 100">
                <path
                    fill="none"
                    stroke="lightgrey"
                    d="M 20 50 C 20 -50 180 150 180 50 C 180 -50 20 150 20 50 Z" />
                <circle
                    r="5"
                    fill="red">
                    <animateMotion
                        dur="10s"
                        repeatCount="indefinite"
                        path="M 20 50 C 20 -50 180 150 180 50 C 180 -50 20 150 20 50 Z" />
                </circle>
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 200, 100)
                path {
                    fill = SvgPaint.None
                    stroke(SvgColor.LightGrey)
                    d {
                        M(20, 50)
                        C(20, -50, 180, 150, 180, 50)
                        C(180, -50, 20, 150, 20, 50)
                        Z
                    }
                }
                circle {
                    r = 5.none
                    fill(SvgColor.Red)
                    animateMotion {
                        dur = Dur.ClockValue(10.seconds)
                        repeatCount = RepeatCount.Indefinite
                        path {
                            M(20, 50)
                            C(20, -50, 180, 150, 180, 50)
                            C(180, -50, 20, 150, 20, 50)
                            Z
                        }
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }
}