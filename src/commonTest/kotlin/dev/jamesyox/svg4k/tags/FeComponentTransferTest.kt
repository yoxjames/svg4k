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

import dev.jamesyox.svg4k.attr.attrs.FeFuncType
import dev.jamesyox.svg4k.attr.attrs.FontWeight
import dev.jamesyox.svg4k.attr.attrs.GradientUnits
import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.amplitude
import dev.jamesyox.svg4k.attr.attrs.exponent
import dev.jamesyox.svg4k.attr.attrs.filter
import dev.jamesyox.svg4k.attr.attrs.fontWeight
import dev.jamesyox.svg4k.attr.attrs.gradientUnits
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.intercept
import dev.jamesyox.svg4k.attr.attrs.offset
import dev.jamesyox.svg4k.attr.attrs.slope
import dev.jamesyox.svg4k.attr.attrs.stopColor
import dev.jamesyox.svg4k.attr.attrs.tableValues
import dev.jamesyox.svg4k.attr.attrs.type
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.x1
import dev.jamesyox.svg4k.attr.attrs.x2
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.attrs.y1
import dev.jamesyox.svg4k.attr.attrs.y2
import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import dev.jamesyox.svg4k.attr.types.obj.SvgId
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.pct
import dev.jamesyox.svg4k.attr.types.obj.url
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class FeComponentTransferTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 600 300">
                <defs>
                    <linearGradient
                        id="rainbow"
                        gradientUnits="userSpaceOnUse"
                        x1="0"
                        y1="0"
                        x2="100%"
                        y2="0">
                        <stop
                            offset="0"
                            stop-color="red" />
                        <stop
                            offset="0.2"
                            stop-color="yellow" />
                        <stop
                            offset="0.4"
                            stop-color="lime" />
                        <stop
                            offset="0.6"
                            stop-color="cyan" />
                        <stop
                            offset="0.8"
                            stop-color="blue" />
                        <stop
                            offset="1"
                            stop-color="purple" />
                    </linearGradient>
                    <filter
                        id="identity"
                        x="0"
                        y="0"
                        width="100%"
                        height="100%">
                        <feComponentTransfer>
                            <feFuncR
                                type="identity" />
                            <feFuncG
                                type="identity" />
                            <feFuncB
                                type="identity" />
                            <feFuncA
                                type="identity" />
                        </feComponentTransfer>
                    </filter>
                    <filter
                        id="table"
                        x="0"
                        y="0"
                        width="100%"
                        height="100%">
                        <feComponentTransfer>
                            <feFuncR
                                type="table"
                                tableValues="0 0 1 1" />
                            <feFuncG
                                type="table"
                                tableValues="1 1 0 0" />
                            <feFuncB
                                type="table"
                                tableValues="0 1 1 0" />
                        </feComponentTransfer>
                    </filter>
                    <filter
                        id="discrete"
                        x="0"
                        y="0"
                        width="100%"
                        height="100%">
                        <feComponentTransfer>
                            <feFuncR
                                type="discrete"
                                tableValues="0 0 1 1" />
                            <feFuncG
                                type="discrete"
                                tableValues="1 1 0 0" />
                            <feFuncB
                                type="discrete"
                                tableValues="0 1 1 0" />
                        </feComponentTransfer>
                    </filter>
                    <filter
                        id="linear"
                        x="0"
                        y="0"
                        width="100%"
                        height="100%">
                        <feComponentTransfer>
                            <feFuncR
                                type="linear"
                                slope="0.5"
                                intercept="0" />
                            <feFuncG
                                type="linear"
                                slope="0.5"
                                intercept="0.25" />
                            <feFuncB
                                type="linear"
                                slope="0.5"
                                intercept="0.5" />
                        </feComponentTransfer>
                    </filter>
                    <filter
                        id="gamma"
                        x="0"
                        y="0"
                        width="100%"
                        height="100%">
                        <feComponentTransfer>
                            <feFuncR
                                type="gamma"
                                amplitude="4"
                                exponent="7"
                                offset="0" />
                            <feFuncG
                                type="gamma"
                                amplitude="4"
                                exponent="4"
                                offset="0" />
                            <feFuncB
                                type="gamma"
                                amplitude="4"
                                exponent="1"
                                offset="0" />
                        </feComponentTransfer>
                    </filter>
                </defs>
                <g
                    font-weight="bold">
                    <text
                        x="0"
                        y="20">
                        Default
                    </text>
                    <rect
                        x="0"
                        y="30"
                        width="100%"
                        height="20" />
                    <text
                        x="0"
                        y="70">
                        Identity
                    </text>
                    <rect
                        x="0"
                        y="80"
                        width="100%"
                        height="20"
                        filter="url(#identity)" />
                    <text
                        x="0"
                        y="120">
                        Table lookup
                    </text>
                    <rect
                        x="0"
                        y="130"
                        width="100%"
                        height="20"
                        filter="url(#table)" />
                    <text
                        x="0"
                        y="170">
                        Discrete table lookup
                    </text>
                    <rect
                        x="0"
                        y="180"
                        width="100%"
                        height="20"
                        filter="url(#discrete)" />
                    <text
                        x="0"
                        y="220">
                        Linear function
                    </text>
                    <rect
                        x="0"
                        y="230"
                        width="100%"
                        height="20"
                        filter="url(#linear)" />
                    <text
                        x="0"
                        y="270">
                        Gamma function
                    </text>
                    <rect
                        x="0"
                        y="280"
                        width="100%"
                        height="20"
                        filter="url(#gamma)" />
                </g>
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                val rainbow = SvgId("rainbow")
                val identity = SvgId("identity")
                val table = SvgId("table")
                val discrete = SvgId("discrete")
                val linear = SvgId("linear")
                val gamma = SvgId("gamma")
                viewBox = ViewBox(0, 0, 600, 300)
                defs {
                    linearGradient {
                        id = rainbow
                        gradientUnits = GradientUnits.UserSpaceOnUse
                        x1 = 0.none
                        y1 = 0.none
                        x2 = 100.pct
                        y2 = 0.none
                        stop {
                            offset(0)
                            stopColor = SvgColor.Red
                        }
                        stop {
                            offset(0.2f)
                            stopColor = SvgColor.Yellow
                        }
                        stop {
                            offset(0.4f)
                            stopColor = SvgColor.Lime
                        }
                        stop {
                            offset(0.6f)
                            stopColor = SvgColor.Cyan
                        }
                        stop {
                            offset(0.8f)
                            stopColor = SvgColor.Blue
                        }
                        stop {
                            offset(1)
                            stopColor = SvgColor.Purple
                        }
                    }
                    filter {
                        id = identity
                        x = 0.none
                        y = 0.none
                        width = 100.pct
                        height = 100.pct
                        feComponentTransfer {
                            feFuncR {
                                type = FeFuncType.Identity
                            }
                            feFuncG {
                                type = FeFuncType.Identity
                            }
                            feFuncB {
                                type = FeFuncType.Identity
                            }
                            feFuncA {
                                type = FeFuncType.Identity
                            }
                        }
                    }
                    filter {
                        id = table
                        x = 0.none
                        y = 0.none
                        width = 100.pct
                        height = 100.pct
                        feComponentTransfer {
                            feFuncR {
                                type = FeFuncType.Table
                                tableValues = listOf(0, 0, 1, 1)
                            }
                            feFuncG {
                                type = FeFuncType.Table
                                tableValues = listOf(1, 1, 0, 0)
                            }
                            feFuncB {
                                type = FeFuncType.Table
                                tableValues = listOf(0, 1, 1, 0)
                            }
                        }
                    }
                    filter {
                        id = discrete
                        x = 0.none
                        y = 0.none
                        width = 100.pct
                        height = 100.pct
                        feComponentTransfer {
                            feFuncR {
                                type = FeFuncType.Discrete
                                tableValues = listOf(0, 0, 1, 1)
                            }
                            feFuncG {
                                type = FeFuncType.Discrete
                                tableValues = listOf(1, 1, 0, 0)
                            }
                            feFuncB {
                                type = FeFuncType.Discrete
                                tableValues = listOf(0, 1, 1, 0)
                            }
                        }
                    }
                    filter {
                        id = linear
                        x = 0.none
                        y = 0.none
                        width = 100.pct
                        height = 100.pct
                        feComponentTransfer {
                            feFuncR {
                                type = FeFuncType.Linear
                                slope = 0.5
                                intercept = 0
                            }
                            feFuncG {
                                type = FeFuncType.Linear
                                slope = 0.5
                                intercept = 0.25
                            }
                            feFuncB {
                                type = FeFuncType.Linear
                                slope = 0.5
                                intercept = 0.5
                            }
                        }
                    }
                    filter {
                        id = gamma
                        x = 0.none
                        y = 0.none
                        width = 100.pct
                        height = 100.pct
                        feComponentTransfer {
                            feFuncR {
                                type = FeFuncType.Gamma
                                amplitude = 4
                                exponent = 7
                                offset(0)
                            }
                            feFuncG {
                                type = FeFuncType.Gamma
                                amplitude = 4
                                exponent = 4
                                offset(0)
                            }
                            feFuncB {
                                type = FeFuncType.Gamma
                                amplitude = 4
                                exponent = 1
                                offset(0)
                            }
                        }
                    }
                }
                g {
                    fontWeight = FontWeight.Bold
                    text {
                        x = listOf(0.none)
                        y = listOf(20.none)
                        +"Default"
                    }
                    rect {
                        x = 0.none
                        y = 30.none
                        width = 100.pct
                        height = 20.none
                    }
                    text {
                        x = listOf(0.none)
                        y = listOf(70.none)
                        +"Identity"
                    }
                    rect {
                        x = 0.none
                        y = 80.none
                        width = 100.pct
                        height = 20.none
                        filter(identity)
                    }
                    text {
                        x = listOf(0.none)
                        y = listOf(120.none)
                        +"Table lookup"
                    }
                    rect {
                        x = 0.none
                        y = 130.none
                        width = 100.pct
                        height = 20.none
                        filter(table)
                    }
                    text {
                        x = listOf(0.none)
                        y = listOf(170.none)
                        +"Discrete table lookup"
                    }
                    rect {
                        x = 0.none
                        y = 180.none
                        width = 100.pct
                        height = 20.none
                        filter(discrete)
                    }
                    text {
                        x = listOf(0.none)
                        y = listOf(220.none)
                        +"Linear function"
                    }
                    rect {
                        x = 0.none
                        y = 230.none
                        width = 100.pct
                        height = 20.none
                        filter(linear)
                    }
                    text {
                        x = listOf(0.none)
                        y = listOf(270.none)
                        +"Gamma function"
                    }
                    rect {
                        x = 0.none
                        y = 280.none
                        width = 100.pct
                        height = 20.none
                        filter(gamma)
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }
}