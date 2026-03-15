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
import dev.jamesyox.svg4k.attr.attrs.clipPath
import dev.jamesyox.svg4k.attr.attrs.cx
import dev.jamesyox.svg4k.attr.attrs.cy
import dev.jamesyox.svg4k.attr.attrs.d
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.href
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.url
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.util.A
import dev.jamesyox.svg4k.util.M
import dev.jamesyox.svg4k.util.Q
import dev.jamesyox.svg4k.util.Z
import kotlin.test.Test
import kotlin.test.assertEquals

class ClipPathTest {
    @Test
    fun mozillaExample() {
        val clipId = "myClip"
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 100 100">
                <clipPath
                    id="myClip">
                    <circle
                        cx="40"
                        cy="35"
                        r="35" />
                </clipPath>
                <path
                    id="heart"
                    d="M 10 30 A 20 20 0 0 1 50 30 A 20 20 0 0 1 90 30 Q 90 60 50 90 Q 10 60 10 30 Z" />
                <use
                    clip-path="url(#myClip)"
                    href="#heart"
                    fill="red" />
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 100, 100)
                clipPath {
                    id = clipId
                    circle {
                        cx = 40.none
                        cy = 35.none
                        r = 35.none
                    }
                }
                path {
                    id = "heart"
                    d {
                        M(10, 30)
                        A(rx = 20, ry = 20, angle = 0, largeArcFlag = false, sweepFlag = true, x = 50, y = 30)
                        A(rx = 20, ry = 20, angle = 0, largeArcFlag = false, sweepFlag = true, x = 90, y = 30)
                        Q(x1 = 90, x2 = 60, x = 50, y = 90)
                        Q(x1 = 10, x2 = 60, x = 10, y = 30)
                        Z
                    }
                }
                use {
                    clipPath = url("#$clipId")
                    href = "#heart"
                    // TODO: An unfortunate compromise
                    fill = "red"
                }
            }
        }
        assertEquals(expected, actual)
    }
}