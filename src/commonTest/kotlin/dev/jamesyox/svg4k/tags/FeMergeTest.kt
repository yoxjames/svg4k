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

import dev.jamesyox.svg4k.attr.attrs.In
import dev.jamesyox.svg4k.attr.attrs.dx
import dev.jamesyox.svg4k.attr.attrs.dy
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.filter
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.`in`
import dev.jamesyox.svg4k.attr.attrs.result
import dev.jamesyox.svg4k.attr.attrs.stdDeviation
import dev.jamesyox.svg4k.attr.attrs.stroke
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class FeMergeTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="200"
                height="200">
                <filter
                    id="feOffset"
                    x="-40"
                    y="-20"
                    width="100"
                    height="200">
                    <feOffset
                        in="SourceGraphic"
                        dx="60"
                        dy="60" />
                    <feGaussianBlur
                        stdDeviation="5"
                        result="blur2" />
                    <feMerge>
                        <feMergeNode
                            in="blur2" />
                        <feMergeNode
                            in="SourceGraphic" />
                    </feMerge>
                </filter>
                <rect
                    x="40"
                    y="40"
                    width="100"
                    height="100"
                    stroke="black"
                    fill="green"
                    filter="url(#feOffset)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 200.none
                height = 200.none
                filter {
                    id = "feOffset"
                    x = (-40).none
                    y = (-20).none
                    width = 100.none
                    height = 200.none
                    feOffset {
                        `in` = In.SourceGraphic
                        dx = 60
                        dy = 60
                    }
                    feGaussianBlur {
                        stdDeviation = NumberOptionalNumber(5, null)
                        result = "blur2"
                    }
                    feMerge {
                        feMergeNode {
                            `in` = In.Primitive("blur2")
                        }
                        feMergeNode {
                            `in` = In.SourceGraphic
                        }
                    }
                }
                rect {
                    x = 40.none
                    y = 40.none
                    width = 100.none
                    height = 100.none
                    stroke = "black"
                    fill = "green"
                    filter = "url(#feOffset)"
                }
            }
        }
        assertEquals(expected, actual)
    }
}