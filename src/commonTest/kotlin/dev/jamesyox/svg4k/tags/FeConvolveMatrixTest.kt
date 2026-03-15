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
import dev.jamesyox.svg4k.attr.attrs.filter
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.href
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.kernelMatrix
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class FeConvolveMatrixTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="200"
                height="200"
                viewBox="0 0 200 200">
                <defs>
                    <filter
                        id="emboss">
                        <feConvolveMatrix
                            kernelMatrix="3 0 0 0 0 0 0 0 -3" />
                    </filter>
                </defs>
                <image
                    href="mdn.svg"
                    x="0"
                    y="0"
                    height="200"
                    width="200"
                    filter="url(#emboss)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 200.none
                height = 200.none
                viewBox = ViewBox(0, 0, 200, 200)
                defs {
                    filter {
                        id = "emboss"
                        feConvolveMatrix {
                            kernelMatrix = listOf(3, 0, 0, 0, 0, 0, 0, 0, -3)
                        }
                    }
                }
                image {
                    href = "mdn.svg"
                    x = 0.none
                    y = 0.none
                    height = 200.none
                    width= 200.none
                    filter = "url(#emboss)"
                }
            }
        }
        assertEquals(expected, actual)
    }
}