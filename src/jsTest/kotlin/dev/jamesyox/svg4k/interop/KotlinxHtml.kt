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

package dev.jamesyox.svg4k.interop

/*
import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.createSvg
import kotlinx.browser.document
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.dom.dom
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinxHtml {
    // WIP and not merged into kotlinx-html. Using this for local testing of a PR
    @Test
    fun test() {
        try {
            document
        } catch(_: Throwable) {
            return
        }

        val wrapper = document.body!!.append.div {
            div {
                dom {
                    createSvg {
                        viewBox = ViewBox(0, 0, 10, 10)
                    }
                }
            }
        }

        assertEquals(
            expected = """<div><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10 10"></svg></div>""",
            actual = wrapper.innerHTML
        )
    }
}
*/