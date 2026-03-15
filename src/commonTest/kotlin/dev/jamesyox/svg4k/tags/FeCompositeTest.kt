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
import dev.jamesyox.svg4k.attr.attrs.cx
import dev.jamesyox.svg4k.attr.attrs.cy
import dev.jamesyox.svg4k.attr.attrs.fill
import dev.jamesyox.svg4k.attr.attrs.filter
import dev.jamesyox.svg4k.attr.attrs.href
import dev.jamesyox.svg4k.attr.attrs.id
import dev.jamesyox.svg4k.attr.attrs.in2
import dev.jamesyox.svg4k.attr.attrs.k1
import dev.jamesyox.svg4k.attr.attrs.k2
import dev.jamesyox.svg4k.attr.attrs.k3
import dev.jamesyox.svg4k.attr.attrs.k4
import dev.jamesyox.svg4k.attr.attrs.operator
import dev.jamesyox.svg4k.attr.attrs.r
import dev.jamesyox.svg4k.attr.attrs.transform
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.attrs.x
import dev.jamesyox.svg4k.attr.attrs.y
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.attr.types.obj.px
import dev.jamesyox.svg4k.consumers.svgString
import dev.jamesyox.svg4k.tags.categories.container.unaryPlus
import dev.jamesyox.svg4k.util.translate
import kotlin.test.Test
import kotlin.test.assertEquals

class FeCompositeTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg">
                <defs>
                    <filter
                        id="imageOver">
                        <feImage
                            href="mdn_logo_only_color.png"
                            x="10px"
                            y="10px"
                            width="160px" />
                        <feComposite
                            in2="SourceGraphic"
                            operator="over" />
                    </filter>
                    <filter
                        id="imageIn">
                        <feImage
                            href="mdn_logo_only_color.png"
                            x="10px"
                            y="10px"
                            width="160px" />
                        <feComposite
                            in2="SourceGraphic"
                            operator="in" />
                    </filter>
                    <filter
                        id="imageOut">
                        <feImage
                            href="mdn_logo_only_color.png"
                            x="10px"
                            y="10px"
                            width="160px" />
                        <feComposite
                            in2="SourceGraphic"
                            operator="out" />
                    </filter>
                    <filter
                        id="imageAtop">
                        <feImage
                            href="mdn_logo_only_color.png"
                            x="10px"
                            y="10px"
                            width="160px" />
                        <feComposite
                            in2="SourceGraphic"
                            operator="atop" />
                    </filter>
                    <filter
                        id="imageXor">
                        <feImage
                            href="mdn_logo_only_color.png"
                            x="10px"
                            y="10px"
                            width="160px" />
                        <feComposite
                            in2="SourceGraphic"
                            operator="xor" />
                    </filter>
                    <filter
                        id="imageArithmetic">
                        <feImage
                            href="mdn_logo_only_color.png"
                            x="10px"
                            y="10px"
                            width="160px" />
                        <feComposite
                            in2="SourceGraphic"
                            operator="arithmetic"
                            k1="0.1"
                            k2="0.2"
                            k3="0.3"
                            k4="0.4" />
                    </filter>
                    <filter
                        id="imageLighter">
                        <feImage
                            href="mdn_logo_only_color.png"
                            x="10px"
                            y="10px"
                            width="160px" />
                        <feComposite
                            in2="SourceGraphic"
                            operator="lighter" />
                    </filter>
                </defs>
                <g
                    transform="translate(0 25)">
                    <circle
                        cx="90px"
                        cy="80px"
                        r="70px"
                        fill="#cc0000"
                        filter="url(#imageOver)" />
                    <text
                        x="80"
                        y="-5">
                        over
                    </text>
                </g>
                <g
                    transform="translate(200 25)">
                    <circle
                        cx="90px"
                        cy="80px"
                        r="70px"
                        fill="#cc0000"
                        filter="url(#imageIn)" />
                    <text
                        x="80"
                        y="-5">
                        in
                    </text>
                </g>
                <g
                    transform="translate(400 25)">
                    <circle
                        cx="90px"
                        cy="80px"
                        r="70px"
                        fill="#cc0000"
                        filter="url(#imageOut)" />
                    <text
                        x="80"
                        y="-5">
                        out
                    </text>
                </g>
                <g
                    transform="translate(600 25)">
                    <circle
                        cx="90px"
                        cy="80px"
                        r="70px"
                        fill="#cc0000"
                        filter="url(#imageAtop)" />
                    <text
                        x="80"
                        y="-5">
                        atop
                    </text>
                </g>
                <g
                    transform="translate(0 240)">
                    <circle
                        cx="90px"
                        cy="80px"
                        r="70px"
                        fill="#cc0000"
                        filter="url(#imageXor)" />
                    <text
                        x="80"
                        y="-5">
                        xor
                    </text>
                </g>
                <g
                    transform="translate(200 240)">
                    <circle
                        cx="90px"
                        cy="80px"
                        r="70px"
                        fill="#cc0000"
                        filter="url(#imageArithmetic)" />
                    <text
                        x="70"
                        y="-5">
                        arithmetic
                    </text>
                </g>
                <g
                    transform="translate(400 240)">
                    <circle
                        cx="90px"
                        cy="80px"
                        r="70px"
                        fill="#cc0000"
                        filter="url(#imageLighter)" />
                    <text
                        x="80"
                        y="-5">
                        lighter
                    </text>
                </g>
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                defs {
                    filter {
                        id = "imageOver"
                        feImage {
                            href="mdn_logo_only_color.png"
                            x = 10.px
                            y = 10.px
                            width = 160.px
                        }
                        feComposite {
                            in2 = In.SourceGraphic
                            operator = CompositeOperator.Over
                        }
                    }
                    filter {
                        id = "imageIn"
                        feImage {
                            href="mdn_logo_only_color.png"
                            x = 10.px
                            y = 10.px
                            width = 160.px
                        }
                        feComposite {
                            in2 = In.SourceGraphic
                            operator = CompositeOperator.In
                        }
                    }
                    filter {
                        id = "imageOut"
                        feImage {
                            href="mdn_logo_only_color.png"
                            x = 10.px
                            y = 10.px
                            width = 160.px
                        }
                        feComposite {
                            in2 = In.SourceGraphic
                            operator = CompositeOperator.Out
                        }
                    }
                    filter {
                        id = "imageAtop"
                        feImage {
                            href="mdn_logo_only_color.png"
                            x = 10.px
                            y = 10.px
                            width = 160.px
                        }
                        feComposite {
                            in2 = In.SourceGraphic
                            operator = CompositeOperator.Atop
                        }
                    }
                    filter {
                        id = "imageXor"
                        feImage {
                            href="mdn_logo_only_color.png"
                            x = 10.px
                            y = 10.px
                            width = 160.px
                        }
                        feComposite {
                            in2 = In.SourceGraphic
                            operator = CompositeOperator.Xor
                        }
                    }
                    filter {
                        id = "imageArithmetic"
                        feImage {
                            href="mdn_logo_only_color.png"
                            x = 10.px
                            y = 10.px
                            width = 160.px
                        }
                        feComposite {
                            in2 = In.SourceGraphic
                            operator = CompositeOperator.Arithmetic
                            k1 = 0.1
                            k2 = 0.2
                            k3 = 0.3
                            k4 = 0.4
                        }
                    }
                    filter {
                        id = "imageLighter"
                        feImage {
                            href="mdn_logo_only_color.png"
                            x = 10.px
                            y = 10.px
                            width = 160.px
                        }
                        feComposite {
                            in2 = In.SourceGraphic
                            operator = CompositeOperator.Lighter
                        }
                    }
                }
                g {
                    transform {
                        translate(0, 25)
                    }
                    circle {
                        cx = 90.px
                        cy = 80.px
                        r = 70.px
                        fill = "#cc0000"
                        filter = "url(#imageOver)"
                    }
                    text {
                        x = listOf(80.none)
                        y = listOf((-5).none)
                        +"over"
                    }
                }
                g {
                    transform {
                        translate(200, 25)
                    }
                    circle {
                        cx = 90.px
                        cy = 80.px
                        r = 70.px
                        fill = "#cc0000"
                        filter = "url(#imageIn)"
                    }
                    text {
                        x = listOf(80.none)
                        y = listOf((-5).none)
                        +"in"
                    }
                }
                g {
                    transform {
                        translate(400, 25)
                    }
                    circle {
                        cx = 90.px
                        cy = 80.px
                        r = 70.px
                        fill = "#cc0000"
                        filter = "url(#imageOut)"
                    }
                    text {
                        x = listOf(80.none)
                        y = listOf((-5).none)
                        +"out"
                    }
                }
                g {
                    transform {
                        translate(600, 25)
                    }
                    circle {
                        cx = 90.px
                        cy = 80.px
                        r = 70.px
                        fill = "#cc0000"
                        filter = "url(#imageAtop)"
                    }
                    text {
                        x = listOf(80.none)
                        y = listOf((-5).none)
                        +"atop"
                    }
                }
                g {
                    transform {
                        translate(0, 240)
                    }
                    circle {
                        cx = 90.px
                        cy = 80.px
                        r = 70.px
                        fill = "#cc0000"
                        filter = "url(#imageXor)"
                    }
                    text {
                        x = listOf(80.none)
                        y = listOf((-5).none)
                        +"xor"
                    }
                }
                g {
                    transform {
                        translate(200, 240)
                    }
                    circle {
                        cx = 90.px
                        cy = 80.px
                        r = 70.px
                        fill = "#cc0000"
                        filter = "url(#imageArithmetic)"
                    }
                    text {
                        x = listOf(70.none)
                        y = listOf((-5).none)
                        +"arithmetic"
                    }
                }
                g {
                    transform {
                        translate(400, 240)
                    }
                    circle {
                        cx = 90.px
                        cy = 80.px
                        r = 70.px
                        fill = "#cc0000"
                        filter = "url(#imageLighter)"
                    }
                    text {
                        x = listOf(80.none)
                        y = listOf((-5).none)
                        +"lighter"
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }
}