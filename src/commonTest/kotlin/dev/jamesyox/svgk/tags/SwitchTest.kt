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

import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.requiredExtensions
import dev.jamesyox.svgk.attr.attrs.systemLanguage
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.tags.categories.container.unaryPlus
import kotlin.test.Test
import kotlin.test.assertEquals

class SwitchTest {
    @Test
    fun mozillaExample() {
        val expected = """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 -20 100 50">
                <switch>
                    <text
                        systemLanguage="de,nl">
                        Hallo!
                    </text>
                    <text
                        systemLanguage="en-us">
                        Howdy!
                    </text>
                    <text
                        systemLanguage="en-gb">
                        Wotcha!
                    </text>
                    <text
                        requiredExtensions="http://example.org/lang/ext/emoji">
                        ☺
                    </text>
                </switch>
            </svg>
        """.trimIndent()

        val actual = svgString(isPrettyPrint = true) {
            svg {
                viewBox = ViewBox(0, -20, 100, 50)
                switch {
                    text {
                        systemLanguage = listOf("de","nl")
                        +"Hallo!"
                    }
                    text {
                        systemLanguage = listOf("en-us")
                        +"Howdy!"
                    }
                    text {
                        systemLanguage = listOf("en-gb")
                        +"Wotcha!"
                    }
                    text {
                        requiredExtensions = listOf("http://example.org/lang/ext/emoji")
                        +"☺"
                    }
                }
            }
        }

        assertEquals(expected, actual)
    }
}