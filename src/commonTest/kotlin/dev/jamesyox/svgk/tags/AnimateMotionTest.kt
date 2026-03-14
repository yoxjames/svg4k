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
import dev.jamesyox.svgk.attr.attrs.RepeatCount
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.d
import dev.jamesyox.svgk.attr.attrs.dur
import dev.jamesyox.svgk.attr.attrs.fill
import dev.jamesyox.svgk.attr.attrs.path
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.repeatCount
import dev.jamesyox.svgk.attr.attrs.stroke
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.util.C
import dev.jamesyox.svgk.util.M
import dev.jamesyox.svgk.util.Z
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
                    fill = "none"
                    stroke = "lightgrey"
                    d {
                        M(20, 50)
                        C(20, -50, 180, 150, 180, 50)
                        C(180, -50, 20, 150, 20, 50)
                        Z
                    }
                }
                circle {
                    r = 5.none
                    fill = "red"
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