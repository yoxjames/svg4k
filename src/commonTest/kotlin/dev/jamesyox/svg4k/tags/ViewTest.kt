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
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class ViewTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 300 100"
                width="300"
                height="100">
                <view
                    id="one"
                    viewBox="0 0 100 100" />
                <circle
                    cx="50"
                    cy="50"
                    r="40"
                    fill="red" />
                <view
                    id="two"
                    viewBox="100 0 100 100" />
                <circle
                    cx="150"
                    cy="50"
                    r="40"
                    fill="green" />
                <view
                    id="three"
                    viewBox="200 0 100 100" />
                <circle
                    cx="250"
                    cy="50"
                    r="40"
                    fill="blue" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, 0, 300, 100)
                width = 300.none
                height = 100.none
                view {
                    id = "one"
                    viewBox = ViewBox(0, 0, 100, 100)
                }
                circle {
                    cx = 50.none
                    cy = 50.none
                    r = 40.none
                    fill = "red"
                }
                view {
                    id = "two"
                    viewBox = ViewBox(100, 0, 100, 100)
                }
                circle {
                    cx = 150.none
                    cy = 50.none
                    r = 40.none
                    fill = "green"
                }
                view {
                    id = "three"
                    viewBox = ViewBox(200, 0, 100, 100)
                }
                circle {
                    cx = 250.none
                    cy = 50.none
                    r = 40.none
                    fill = "blue"
                }
            }
        }

        assertEquals(expected, actual)
    }
}