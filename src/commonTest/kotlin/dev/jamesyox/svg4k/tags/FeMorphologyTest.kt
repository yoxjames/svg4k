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

import dev.jamesyox.svg4k.attr.attrs.MorphOperator
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.operator
import dev.jamesyox.svg4k.attr.attrs.radius
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.em
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class FeMorphologyTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="300"
                height="180">
                <filter
                    id="erode">
                    <feMorphology
                        operator="erode"
                        radius="1" />
                </filter>
                <filter
                    id="dilate">
                    <feMorphology
                        operator="dilate"
                        radius="2" />
                </filter>
                <text
                    y="1em">
                    Normal text
                </text>
                <text
                    id="thin"
                    y="2em">
                    Thinned text
                </text>
                <text
                    id="thick"
                    y="3em">
                    Fattened text
                </text>
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                val erode = SvgId("erode")
                val dilate = SvgId("dilate")
                val thin = SvgId("thin")
                val thick = SvgId("thick")
                width = 300.none
                height = 180.none
                filter {
                    id = erode
                    feMorphology {
                        operator = MorphOperator.Erode
                        radius = NumberOptionalNumber(1, null)
                    }
                }
                filter {
                    id = dilate
                    feMorphology {
                        operator = MorphOperator.Dilate
                        radius = NumberOptionalNumber(2, null)
                    }
                }
                text {
                    y = listOf(1.em)
                    +"Normal text"
                }

                text {
                    id = thin
                    y = listOf(2.em)
                    +"Thinned text"
                }
                text {
                    id = thick
                    y = listOf(3.em)
                    +"Fattened text"
                }
            }
        }

        assertEquals(expected, actual)
    }
}