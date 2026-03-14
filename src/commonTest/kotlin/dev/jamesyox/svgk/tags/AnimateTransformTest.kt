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

import dev.jamesyox.svgk.attr.attrs.AnimateTransformType
import dev.jamesyox.svgk.attr.attrs.AttributeType
import dev.jamesyox.svgk.attr.attrs.Dur
import dev.jamesyox.svgk.attr.attrs.RepeatCount
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.attributeName
import dev.jamesyox.svgk.attr.attrs.attributeType
import dev.jamesyox.svgk.attr.attrs.dur
import dev.jamesyox.svgk.attr.attrs.from
import dev.jamesyox.svgk.attr.attrs.height
import dev.jamesyox.svgk.attr.attrs.points
import dev.jamesyox.svgk.attr.attrs.repeatCount
import dev.jamesyox.svgk.attr.attrs.to
import dev.jamesyox.svgk.attr.attrs.type
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.attr.attrs.width
import dev.jamesyox.svgk.attr.types.obj.Point
import dev.jamesyox.svgk.attr.types.obj.none
import dev.jamesyox.svgk.consumers.svgString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds

class AnimateTransformTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="120"
                height="120"
                viewBox="0 0 120 120">
                <polygon
                    points="60,30 90,90 30,90">
                    <animateTransform
                        attributeName="transform"
                        attributeType="XML"
                        type="rotate"
                        from="0 60 70"
                        to="360 60 70"
                        dur="10s"
                        repeatCount="indefinite" />
                </polygon>
            </svg>
        """.trimIndent()
        val actual = svgString(isPrettyPrint = true) {
            svg {
                width = 120.none
                height = 120.none
                viewBox = ViewBox(0, 0, 120, 120)
                polygon {
                    points = listOf(
                        Point(60, 30),
                        Point(90, 90),
                        Point(30, 90)
                    )
                    animateTransform {
                        attributeName="transform"
                        attributeType = AttributeType.XML
                        type = AnimateTransformType.Rotate
                        from = "0 60 70"
                        to = "360 60 70"
                        dur = Dur.ClockValue(10.seconds)
                        repeatCount = RepeatCount.Indefinite
                    }
                }
            }
        }
        assertEquals(expected, actual)
    }
}