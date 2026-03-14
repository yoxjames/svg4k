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
import dev.jamesyox.svgk.attr.attrs.cx
import dev.jamesyox.svgk.attr.attrs.cy
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class DescTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 10 10">
                <circle
                    cx="5"
                    cy="5"
                    r="4">
                    <desc>
                        I'm a circle and that description is here to demonstrate how I can be described.
                    </desc>
                </circle>
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 10, 10)
                circle {
                    cx = 5.none
                    cy = 5.none
                    r = 4.none
                    desc {
                        +("I'm a circle and that description is here to demonstrate how I can be described.")
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }
}