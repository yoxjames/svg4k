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

import dev.jamesyox.svgk.attr.attrs.In
import dev.jamesyox.svgk.attr.attrs.cx
import dev.jamesyox.svgk.attr.attrs.cy
import dev.jamesyox.svgk.attr.attrs.fill
import dev.jamesyox.svgk.attr.attrs.filter
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.`in`
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.stdDeviation
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class FeGaussianBlurTest {
    @Test
    fun mozillaTest() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="230"
                height="120">
                <filter
                    id="blurMe">
                    <feGaussianBlur
                        in="SourceGraphic"
                        stdDeviation="5" />
                </filter>
                <circle
                    cx="60"
                    cy="60"
                    r="50"
                    fill="green" />
                <circle
                    cx="170"
                    cy="60"
                    r="50"
                    fill="green"
                    filter="url(#blurMe)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 230.none
                height = 120.none
                filter {
                    id = "blurMe"
                    feGaussianBlur {
                        `in` = In.SourceGraphic
                        stdDeviation = NumberOptionalNumber(5, null)
                    }
                }
                circle {
                    cx = 60.none
                    cy = 60.none
                    r = 50.none
                    fill = "green"
                }
                circle {
                    cx = 170.none
                    cy = 60.none
                    r = 50.none
                    fill = "green"
                    filter = "url(#blurMe)"
                }
            }
        }

        assertEquals(expected, actual)
    }
}