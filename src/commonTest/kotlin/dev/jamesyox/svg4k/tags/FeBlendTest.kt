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
import dev.jamesyox.svg4k.attr.attrs.Mode
import dev.jamesyox.svg4k.attr.attrs.filter
import dev.jamesyox.svg4k.attr.attrs.floodColor
import dev.jamesyox.svg4k.attr.attrs.floodOpacity
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.href
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.`in`
import dev.jamesyox.svg4k.attr.attrs.in2
import dev.jamesyox.svg4k.attr.attrs.mode
import dev.jamesyox.svg4k.attr.attrs.result
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.pct
import dev.jamesyox.svg4k.attr.types.obj.url
import dev.jamesyox.svg4k.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class FeBlendTest {
    @Test
    fun mozillaTest() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="200"
                height="200">
                <defs>
                    <filter
                        id="spotlight">
                        <feFlood
                            result="floodFill"
                            x="0"
                            y="0"
                            width="100%"
                            height="100%"
                            flood-color="green"
                            flood-opacity="${1.0f}" />
                        <feBlend
                            in="SourceGraphic"
                            in2="floodFill"
                            mode="multiply" />
                    </filter>
                </defs>
                <image
                    href="mdn_logo_only_color.png"
                    x="10%"
                    y="10%"
                    width="80%"
                    height="80%"
                    filter="url(#spotlight)" />
            </svg>
        """.trimIndent()
        val filterId = "spotlight"
        val floodResult = "floodFill"
        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 200.none
                height = 200.none
                defs {
                    filter {
                        id = filterId
                        feFlood {
                            result = floodResult
                            x = 0.none
                            y = 0.none
                            width = 100.pct
                            height = 100.pct
                            floodColor = "green"
                            floodOpacity = 1f
                        }
                        feBlend {
                            `in` = In.SourceGraphic
                            in2 = In.Primitive(floodResult)
                            mode = Mode.Multiply
                        }
                    }
                }
                image {
                    href = "mdn_logo_only_color.png"
                    x = 10.pct
                    y = 10.pct
                    width = 80.pct
                    height = 80.pct
                    filter = url("#$filterId").svgString
                }
            }
        }
        assertEquals(expected, actual)
    }
}