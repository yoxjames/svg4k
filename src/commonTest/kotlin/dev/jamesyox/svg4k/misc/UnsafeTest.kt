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

package dev.jamesyox.svg4k.misc

import dev.jamesyox.svg4k.attr.attrs.fr
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.meta.attr
import dev.jamesyox.svg4k.meta.unsafe
import dev.jamesyox.svg4k.meta.unsafeCascading
import dev.jamesyox.svg4k.tags.circle
import dev.jamesyox.svg4k.tags.meta.customElement
import dev.jamesyox.svg4k.tags.rect
import dev.jamesyox.svg4k.tags.svg
import kotlin.test.Test
import kotlin.test.assertEquals

class UnsafeTest {
    @Test
    fun testInvalidCircleInCircle() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg">
                <circle>
                    <circle />
                </circle>
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                circle {
                    unsafe {
                        circle {
                        }
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }

    @Test
    fun testInvalidUnsafeCascade() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg">
                <circle>
                    <rect
                        fr="5" />
                </circle>
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                circle {
                    unsafeCascading {
                        rect { // This compiles but is not a valid SVG!
                            fr = 5.none
                        }
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }

    @Test
    fun testManualAttrEntry() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg">
                <circle
                    not-real="madeup" />
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                circle {
                    unsafe {
                        attr["not-real"] = "madeup"
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }

    @Test
    fun testManualElement() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg">
                <fake
                    fr="5">
                    <circle />
                </fake>
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                unsafe {
                    customElement("fake") {
                        fr = 5.none
                        circle {

                        }
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }
}