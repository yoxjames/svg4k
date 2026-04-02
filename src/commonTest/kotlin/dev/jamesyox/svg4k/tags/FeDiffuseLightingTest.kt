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

import dev.jamesyox.svg4k.attr.attrs.CompositeOperator
import dev.jamesyox.svg4k.attr.attrs.In
import dev.jamesyox.svg4k.attr.attrs.TextAnchor
import dev.jamesyox.svg4k.attr.attrs.azimuth
import dev.jamesyox.svg4k.attr.attrs.cx
import dev.jamesyox.svg4k.attr.attrs.cy
import dev.jamesyox.svg4k.attr.attrs.elevation
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.filter
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.`in`
import dev.jamesyox.svg4k.attr.attrs.in2
import dev.jamesyox.svg4k.attr.attrs.k1
import dev.jamesyox.svg4k.attr.attrs.k2
import dev.jamesyox.svg4k.attr.attrs.k3
import dev.jamesyox.svg4k.attr.attrs.k4
import dev.jamesyox.svg4k.attr.attrs.lightingColor
import dev.jamesyox.svg4k.attr.attrs.limitingConeAngle
import dev.jamesyox.svg4k.attr.attrs.operator
import dev.jamesyox.svg4k.attr.attrs.pointsAtX
import dev.jamesyox.svg4k.attr.attrs.pointsAtY
import dev.jamesyox.svg4k.attr.attrs.pointsAtZ
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.result
import dev.jamesyox.svg4k.attr.attrs.textAnchor
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.attrs.z
import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.url
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class FeDiffuseLightingTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="440"
                height="140">
                <text
                    text-anchor="middle"
                    x="60"
                    y="22">
                    No Light
                </text>
                <circle
                    cx="60"
                    cy="80"
                    r="50"
                    fill="green" />
                <text
                    text-anchor="middle"
                    x="170"
                    y="22">
                    fePointLight
                </text>
                <filter
                    id="lightMe1">
                    <feDiffuseLighting
                        in="SourceGraphic"
                        result="light"
                        lighting-color="white">
                        <fePointLight
                            x="150"
                            y="60"
                            z="20" />
                    </feDiffuseLighting>
                    <feComposite
                        in="SourceGraphic"
                        in2="light"
                        operator="arithmetic"
                        k1="1"
                        k2="0"
                        k3="0"
                        k4="0" />
                </filter>
                <circle
                    cx="170"
                    cy="80"
                    r="50"
                    fill="green"
                    filter="url(#lightMe1)" />
                <text
                    text-anchor="middle"
                    x="280"
                    y="22">
                    feDistantLight
                </text>
                <filter
                    id="lightMe2">
                    <feDiffuseLighting
                        in="SourceGraphic"
                        result="light"
                        lighting-color="white">
                        <feDistantLight
                            azimuth="240"
                            elevation="20" />
                    </feDiffuseLighting>
                    <feComposite
                        in="SourceGraphic"
                        in2="light"
                        operator="arithmetic"
                        k1="1"
                        k2="0"
                        k3="0"
                        k4="0" />
                </filter>
                <circle
                    cx="280"
                    cy="80"
                    r="50"
                    fill="green"
                    filter="url(#lightMe2)" />
                <text
                    text-anchor="middle"
                    x="390"
                    y="22">
                    feSpotlight
                </text>
                <filter
                    id="lightMe3">
                    <feDiffuseLighting
                        in="SourceGraphic"
                        result="light"
                        lighting-color="white">
                        <feSpotLight
                            x="360"
                            y="5"
                            z="30"
                            limitingConeAngle="20"
                            pointsAtX="390"
                            pointsAtY="80"
                            pointsAtZ="0" />
                    </feDiffuseLighting>
                    <feComposite
                        in="SourceGraphic"
                        in2="light"
                        operator="arithmetic"
                        k1="1"
                        k2="0"
                        k3="0"
                        k4="0" />
                </filter>
                <circle
                    cx="390"
                    cy="80"
                    r="50"
                    fill="green"
                    filter="url(#lightMe3)" />
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 440.none
                height = 140.none
                text {
                    textAnchor = TextAnchor.Middle
                    x = listOf(60.none)
                    y = listOf(22.none)
                    +"No Light"
                }
                circle {
                    cx = 60.none
                    cy = 80.none
                    r = 50.none
                    fill(SvgColor.Green)
                }
                text {
                    textAnchor = TextAnchor.Middle
                    x = listOf(170.none)
                    y = listOf(22.none)
                    +"fePointLight"
                }
                val lightMe1 = SvgId("lightMe1")
                filter {
                    id = lightMe1
                    feDiffuseLighting {
                        `in` = In.SourceGraphic
                        result = "light"
                        lightingColor = SvgColor.White
                        fePointLight {
                            x = 150
                            y = 60
                            z = 20
                        }
                    }
                    feComposite {
                        `in` = In.SourceGraphic
                        in2 = In.Primitive("light")
                        operator = CompositeOperator.Arithmetic
                        k1 = 1
                        k2 = 0
                        k3 = 0
                        k4 = 0
                    }
                }
                circle {
                    cx = 170.none
                    cy = 80.none
                    r = 50.none
                    fill(SvgColor.Green)
                    filter(lightMe1)
                }
                text {
                    textAnchor = TextAnchor.Middle
                    x = listOf(280.none)
                    y = listOf(22.none)
                    +"feDistantLight"
                }
                val lightMe2 = SvgId("lightMe2")
                filter {
                    id = lightMe2
                    feDiffuseLighting {
                        `in` = In.SourceGraphic
                        result = "light"
                        lightingColor = SvgColor.White
                        feDistantLight {
                            azimuth = 240
                            elevation = 20
                        }
                    }
                    feComposite {
                        `in` = In.SourceGraphic
                        in2 = In.Primitive("light")
                        operator = CompositeOperator.Arithmetic
                        k1 = 1
                        k2 = 0
                        k3 = 0
                        k4 = 0
                    }
                }
                circle {
                    cx = 280.none
                    cy = 80.none
                    r = 50.none
                    fill(SvgColor.Green)
                    filter(lightMe2)
                }
                text {
                    textAnchor = TextAnchor.Middle
                    x = listOf(390.none)
                    y = listOf(22.none)
                    +"feSpotlight"
                }
                val lightMe3 = SvgId("lightMe3")
                filter {
                    id = lightMe3
                    feDiffuseLighting {
                        `in` = In.SourceGraphic
                        result = "light"
                        lightingColor = SvgColor.White
                        feSpotLight {
                            x = 360
                            y = 5
                            z = 30
                            limitingConeAngle = 20
                            pointsAtX = 390
                            pointsAtY = 80
                            pointsAtZ = 0
                        }
                    }
                    feComposite {
                        `in` = In.SourceGraphic
                        in2 = In.Primitive("light")
                        operator = CompositeOperator.Arithmetic
                        k1 = 1
                        k2 = 0
                        k3 = 0
                        k4 = 0
                    }
                }
                circle {
                    cx = 390.none
                    cy = 80.none
                    r = 50.none
                    fill(SvgColor.Green)
                    filter(lightMe3)
                }
            }
        }

        assertEquals(expected, actual)
    }
}