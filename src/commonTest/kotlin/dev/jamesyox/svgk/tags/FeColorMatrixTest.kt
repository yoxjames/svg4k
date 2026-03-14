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

import dev.jamesyox.svgk.attr.attrs.AlignmentValue
import dev.jamesyox.svgk.attr.attrs.FeColorMatrixType
import dev.jamesyox.svgk.attr.attrs.In
import dev.jamesyox.svgk.attr.attrs.PreserveAspectRatio
import dev.jamesyox.svgk.attr.attrs.ScaleValue
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.cx
import dev.jamesyox.svgk.attr.attrs.cy
import dev.jamesyox.svgk.attr.attrs.fill
import dev.jamesyox.svgk.attr.attrs.fillOpacity
import dev.jamesyox.svgk.attr.attrs.filter
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.href
import dev.jamesyox.svgk.attr.attrs.id
import dev.jamesyox.svgk.attr.attrs.`in`
import dev.jamesyox.svgk.attr.attrs.preserveAspectRatio
import dev.jamesyox.svgk.attr.attrs.r
import dev.jamesyox.svgk.attr.attrs.transform
import dev.jamesyox.svgk.attr.attrs.type
import dev.jamesyox.svgk.attr.attrs.url
import dev.jamesyox.svgk.attr.attrs.values
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.attrs.x
import dev.jamesyox.svgk.attr.attrs.y
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.attr.types.obj.pct
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.meta.attr
import dev.jamesyox.svgk.meta.unsafe
import dev.jamesyox.svgk.tags.categories.container.unaryPlus
import dev.jamesyox.svgk.util.translate
import kotlin.test.Test
import kotlin.test.assertEquals

class FeColorMatrixTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="100%"
                height="100%"
                viewBox="0 0 150 500"
                preserveAspectRatio="xMidYMid meet"
                xmlns:xlink="http://www.w3.org/1999/xlink">
                <defs>
                    <g
                        id="circles">
                        <circle
                            cx="30"
                            cy="30"
                            r="20"
                            fill="blue"
                            fill-opacity="0.5" />
                        <circle
                            cx="20"
                            cy="50"
                            r="20"
                            fill="green"
                            fill-opacity="0.5" />
                        <circle
                            cx="40"
                            cy="50"
                            r="20"
                            fill="red"
                            fill-opacity="0.5" />
                    </g>
                </defs>
                <use
                    href="#circles" />
                <text
                    x="70"
                    y="50">
                    Reference
                </text>
                <filter
                    id="colorMeTheSame">
                    <feColorMatrix
                        in="SourceGraphic"
                        type="matrix"
                        values="1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 0" />
                </filter>
                <use
                    href="#circles"
                    transform="translate(0 70)"
                    filter="url(#colorMeTheSame)" />
                <text
                    x="70"
                    y="120">
                    Identity matrix
                </text>
                <filter
                    id="colorMeGreen">
                    <feColorMatrix
                        in="SourceGraphic"
                        type="matrix"
                        values="0 0 0 0 0 1 1 1 1 0 0 0 0 0 0 0 0 0 1 0" />
                </filter>
                <use
                    href="#circles"
                    transform="translate(0 140)"
                    filter="url(#colorMeGreen)" />
                <text
                    x="70"
                    y="190">
                    rgbToGreen
                </text>
                <filter
                    id="colorMeSaturate">
                    <feColorMatrix
                        in="SourceGraphic"
                        type="saturate"
                        values="0.2" />
                </filter>
                <use
                    href="#circles"
                    transform="translate(0 210)"
                    filter="url(#colorMeSaturate)" />
                <text
                    x="70"
                    y="260">
                    saturate
                </text>
                <filter
                    id="colorMeHueRotate">
                    <feColorMatrix
                        in="SourceGraphic"
                        type="hueRotate"
                        values="180" />
                </filter>
                <use
                    href="#circles"
                    transform="translate(0 280)"
                    filter="url(#colorMeHueRotate)" />
                <text
                    x="70"
                    y="330">
                    hueRotate
                </text>
                <filter
                    id="colorMeLTA">
                    <feColorMatrix
                        in="SourceGraphic"
                        type="luminanceToAlpha" />
                </filter>
                <use
                    href="#circles"
                    transform="translate(0 350)"
                    filter="url(#colorMeLTA)" />
                <text
                    x="70"
                    y="400">
                    luminanceToAlpha
                </text>
            </svg>""".trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 100.pct
                height = 100.pct
                viewBox = ViewBox(0, 0, 150, 500)
                preserveAspectRatio = PreserveAspectRatio(AlignmentValue.XMidYMid, ScaleValue.Meet)
                unsafe {
                    attr["xmlns:xlink"] = "http://www.w3.org/1999/xlink"
                }
                defs {
                    g {
                        id = "circles"
                        circle {
                            cx = 30.none
                            cy = 30.none
                            r = 20.none
                            fill = "blue"
                            fillOpacity(0.5f)
                        }
                        circle {
                            cx = 20.none
                            cy = 50.none
                            r = 20.none
                            fill = "green"
                            fillOpacity(0.5f)
                        }
                        circle {
                            cx = 40.none
                            cy = 50.none
                            r = 20.none
                            fill = "red"
                            fillOpacity(0.5f)
                        }
                    }
                }
                use {
                    href = "#circles"
                }
                text {
                    x = listOf(70.none)
                    y = listOf(50.none)
                    +"Reference"
                }
                filter {
                    id = "colorMeTheSame"
                    feColorMatrix {
                        `in` = In.SourceGraphic
                        type = FeColorMatrixType.Matrix
                        values = listOf(1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0)
                    }
                }
                use {
                    href = "#circles"
                    transform {
                        translate(0, 70)
                    }
                    filter = url("#colorMeTheSame").svgString
                }
                text {
                    x = listOf(70.none)
                    y = listOf(120.none)
                    +"Identity matrix"
                }
                filter {
                    id = "colorMeGreen"
                    feColorMatrix {
                        `in` = In.SourceGraphic
                        type = FeColorMatrixType.Matrix
                        values = listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
                    }
                }
                use {
                    href = "#circles"
                    transform {
                        translate(0, 140)
                    }
                    filter = url("#colorMeGreen").svgString
                }
                text {
                    x = listOf(70.none)
                    y = listOf(190.none)
                    +"rgbToGreen"
                }
                filter {
                    id = "colorMeSaturate"
                    feColorMatrix {
                        `in` = In.SourceGraphic
                        type = FeColorMatrixType.Saturate
                        values = listOf(0.2)
                    }
                }
                use {
                    href = "#circles"
                    transform {
                        translate(0, 210)
                    }
                    filter = url("#colorMeSaturate").svgString
                }
                text {
                    x = listOf(70.none)
                    y = listOf(260.none)
                    +"saturate"
                }
                filter {
                    id = "colorMeHueRotate"
                    feColorMatrix {
                        `in` = In.SourceGraphic
                        type = FeColorMatrixType.HueRotate
                        values = listOf(180)
                    }
                }
                use {
                    href = "#circles"
                    transform {
                        translate(0, 280)
                    }
                    filter = url("#colorMeHueRotate").svgString
                }
                text {
                    x = listOf(70.none)
                    y = listOf(330.none)
                    +"hueRotate"
                }
                filter {
                    id = "colorMeLTA"
                    feColorMatrix {
                        `in` = In.SourceGraphic
                        type = FeColorMatrixType.LuminanceToAlpha
                    }
                }
                use {
                    href = "#circles"
                    transform {
                        translate(0, 350)
                    }
                    filter = url("#colorMeLTA").svgString
                }
                text {
                    x = listOf(70.none)
                    y = listOf(400.none)
                    +"luminanceToAlpha"
                }
            }
        }
        assertEquals(expected, actual)
    }
}