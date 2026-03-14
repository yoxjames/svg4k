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

import dev.jamesyox.svgk.attr.attrs.FeTurbulenceType
import dev.jamesyox.svgk.attr.attrs.In
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.XChannelSelector
import dev.jamesyox.svgk.attr.attrs.YChannelSelector
import dev.jamesyox.svgk.attr.attrs.baseFrequency
import dev.jamesyox.svgk.attr.attrs.cx
import dev.jamesyox.svgk.attr.attrs.cy
import dev.jamesyox.svgk.attr.attrs.filter
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.`in`
import dev.jamesyox.svgk.attr.attrs.in2
import dev.jamesyox.svgk.attr.attrs.numOctaves
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.result
import dev.jamesyox.svgk.attr.attrs.scale
import dev.jamesyox.svgk.attr.attrs.type
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.attrs.xChannelSelector
import dev.jamesyox.svgk.attr.attrs.yChannelSelector
import dev.jamesyox.svgk.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals

class FeDisplacementMapTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="200"
                height="200"
                viewBox="0 0 220 220">
                <filter
                    id="displacementFilter">
                    <feTurbulence
                        type="turbulence"
                        baseFrequency="0.05"
                        numOctaves="2"
                        result="turbulence" />
                    <feDisplacementMap
                        in2="turbulence"
                        in="SourceGraphic"
                        scale="50"
                        xChannelSelector="R"
                        yChannelSelector="G" />
                </filter>
                <circle
                    cx="100"
                    cy="100"
                    r="100"
                    filter="url(#displacementFilter)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 200.none
                height = 200.none
                viewBox = ViewBox(0, 0, 220, 220)
                filter {
                    id = "displacementFilter"
                    feTurbulence {
                        type = FeTurbulenceType.Turbulence
                        baseFrequency = NumberOptionalNumber(0.05, null)
                        numOctaves = 2
                        result = "turbulence"
                    }
                    feDisplacementMap {
                        in2 = In.Primitive("turbulence")
                        `in` = In.SourceGraphic
                        scale = 50
                        xChannelSelector = XChannelSelector.R
                        yChannelSelector = YChannelSelector.G
                    }
                }
                circle {
                    cx = 100.none
                    cy = 100.none
                    r = 100.none
                    filter = "url(#displacementFilter)"
                }
            }
        }

        assertEquals(expected, actual)
    }
}