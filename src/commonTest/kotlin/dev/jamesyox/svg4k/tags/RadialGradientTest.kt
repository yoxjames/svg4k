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
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.offset
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.stopColor
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.pct
import dev.jamesyox.svg4k.attr.types.obj.url
import dev.jamesyox.svg4k.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class RadialGradientTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 10 10">
                <defs>
                    <radialGradient
                        id="myGradient">
                        <stop
                            offset="10%"
                            stop-color="gold" />
                        <stop
                            offset="95%"
                            stop-color="red" />
                    </radialGradient>
                </defs>
                <circle
                    cx="5"
                    cy="5"
                    r="4"
                    fill="url(#myGradient)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                val myGradient = SvgId("myGradient")
                viewBox = ViewBox(0, 0, 10, 10)
                defs {
                    radialGradient {
                        id = myGradient
                        stop {
                            offset = 10.pct
                            stopColor = SvgColor.Gold
                        }
                        stop {
                            offset = 95.pct
                            stopColor = SvgColor.Red
                        }
                    }
                }
                circle {
                    cx = 5.none
                    cy = 5.none
                    r = 4.none
                    fill(myGradient)
                }
            }
        }

        assertEquals(expected, actual)
    }
}