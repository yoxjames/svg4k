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

package dev.jamesyox.svgk.interop

import dev.jamesyox.svgk.SvgTagDSL
import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.attrs.ViewBox
import dev.jamesyox.svgk.attr.attrs.viewBox
import dev.jamesyox.svgk.consumers.svgString
import dev.jamesyox.svgk.tags.Svg
import dev.jamesyox.svgk.tags.svg
import kotlinx.html.HTMLTag
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.html
import kotlinx.html.stream.appendHTML
import kotlinx.html.unsafe
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinxHtml {
    private fun HTMLTag.svgk(
        block: context(AttributeConsumer, @SvgTagDSL Svg) () -> Unit
    ) {
        unsafe {
            raw(svgString { svg { block() } })
        }
    }

    @Test
    fun basicHappyPathTest() {
        // TODO: kotlinx-html has an extra line at the end?
        val expected = """
            <html>
              <body>
                <div><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10 10" /></div>
              </body>
            </html>
            
        """.trimIndent()

        val actual = StringBuilder().appendHTML(prettyPrint = true).html {
            body {
                div {
                    svgk {
                        viewBox = ViewBox(0, 0, 10, 10)
                    }
                }
            }
        }.toString()
        assertEquals(expected, actual)
    }
}
