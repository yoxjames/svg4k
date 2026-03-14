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

import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.stroke
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.x1
import dev.jamesyox.svgk.attr.attrs.x2
import dev.jamesyox.svgk.attr.attrs.y1
import dev.jamesyox.svgk.attr.attrs.y2
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class LineTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 100 100">
                <line
                    x1="0"
                    y1="80"
                    x2="100"
                    y2="20"
                    stroke="black" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 100, 100)
                line {
                    x1 = 0.none
                    y1 = 80.none
                    x2 = 100.none
                    y2 = 20.none
                    stroke = "black"
                }
            }
        }

        assertEquals(expected, actual)
    }
}