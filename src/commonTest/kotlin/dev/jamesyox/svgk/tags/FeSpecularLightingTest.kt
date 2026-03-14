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

import dev.jamesyox.svgk.attr.attrs.CompositeOperator
import dev.jamesyox.svgk.attr.attrs.In
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.cx
import dev.jamesyox.svgk.attr.attrs.cy
import dev.jamesyox.svgk.attr.attrs.filter
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.`in`
import dev.jamesyox.svgk.attr.attrs.in2
import dev.jamesyox.svgk.attr.attrs.k1
import dev.jamesyox.svgk.attr.attrs.k2
import dev.jamesyox.svgk.attr.attrs.k3
import dev.jamesyox.svgk.attr.attrs.k4
import dev.jamesyox.svgk.attr.attrs.lightingColor
import dev.jamesyox.svgk.attr.attrs.operator
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.result
import dev.jamesyox.svgk.attr.attrs.specularExponent
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.attrs.x
import dev.jamesyox.svgk.attr.attrs.y
import dev.jamesyox.svgk.attr.attrs.z
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class FeSpecularLightingTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                height="200"
                width="200"
                viewBox="0 0 220 220">
                <filter
                    id="filter">
                    <feSpecularLighting
                        result="specOut"
                        specularExponent="20"
                        lighting-color="#bbbbbb">
                        <fePointLight
                            x="50"
                            y="75"
                            z="200" />
                    </feSpecularLighting>
                    <feComposite
                        in="SourceGraphic"
                        in2="specOut"
                        operator="arithmetic"
                        k1="0"
                        k2="1"
                        k3="1"
                        k4="0" />
                </filter>
                <circle
                    cx="110"
                    cy="110"
                    r="100"
                    filter="url(#filter)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                height = 200.none
                width = 200.none
                viewBox = ViewBox(0, 0, 220, 220)
                filter {
                    id = "filter"
                    feSpecularLighting {
                        result = "specOut"
                        specularExponent = 20
                        lightingColor = "#bbbbbb"
                        fePointLight {
                            x = 50
                            y = 75
                            z = 200
                        }
                    }
                    feComposite {
                        `in` = In.SourceGraphic
                        in2 = In.Primitive("specOut")
                        operator = CompositeOperator.Arithmetic
                        k1 = 0
                        k2 = 1
                        k3 = 1
                        k4 = 0
                    }
                }
                circle {
                    cx = 110.none
                    cy = 110.none
                    r = 100.none
                    filter = "url(#filter)"
                }
            }
        }

        assertEquals(expected, actual)
    }
}