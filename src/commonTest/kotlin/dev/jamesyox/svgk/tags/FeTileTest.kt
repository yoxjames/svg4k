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
import dev.jamesyox.svgk.attr.attrs.filter
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.href
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.`in`
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.attrs.x
import dev.jamesyox.svgk.attr.attrs.y
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.attr.types.obj.pct
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class FeTileTest {
    @Test
    fun mozillaTest() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="200"
                height="200">
                <title>
                    Tiling an MDN logo with the Mozilla mascot's head that is on the logo
                </title>
                <defs>
                    <filter
                        id="tile"
                        x="0"
                        y="0"
                        width="100%"
                        height="100%">
                        <feTile
                            in="SourceGraphic"
                            x="50"
                            y="50"
                            width="100"
                            height="100" />
                        <feTile />
                    </filter>
                </defs>
                <image
                    href="mdn_logo_only_color.png"
                    x="10%"
                    y="10%"
                    width="80%"
                    height="80%"
                    filter="url(#tile)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 200.none
                height = 200.none
                title {
                    +"Tiling an MDN logo with the Mozilla mascot's head that is on the logo"
                }
                defs {
                    filter {
                        id = "tile"
                        x = 0.none
                        y = 0.none
                        width = 100.pct
                        height = 100.pct
                        feTile {
                            `in` = In.SourceGraphic
                            x = 50.none
                            y = 50.none
                            width = 100.none
                            height = 100.none
                        }
                        feTile {  }
                    }
                }
                image {
                    href = "mdn_logo_only_color.png"
                    x = 10.pct
                    y = 10.pct
                    width = 80.pct
                    height = 80.pct
                    filter = "url(#tile)"
                }
            }
        }
        assertEquals(expected, actual)
    }
}