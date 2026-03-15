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

package dev.jamesyox.svg4k

import dev.jamesyox.svg4k.attr.attrs.ViewBox
import dev.jamesyox.svg4k.attr.attrs.height
import dev.jamesyox.svg4k.attr.attrs.viewBox
import dev.jamesyox.svg4k.attr.attrs.width
import dev.jamesyox.svg4k.attr.types.obj.none
import dev.jamesyox.svg4k.tags.rect
import dev.jamesyox.svg4k.tags.svg
import kotlinx.browser.document
import org.w3c.dom.svg.SVGElement
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DomWriterTest {
    @Test
    fun testDom() {
        try {
            document
        } catch(_: Throwable) {
            return
        }
        val node = document.createElement("div")
        val svg: SVGElement
        val rect: SVGElement
        node.appendSvg {
            svg = svg {
                viewBox = ViewBox(0, 0, 100, 100)
                rect = rect {
                    width = 100.none
                    height = 100.none
                }
            }
        }

        assertTrue(node.contains(svg))
        assertEquals(expected = "0 0 100 100", actual = svg.attributes.getNamedItem("viewBox")?.value)

        assertTrue(svg.contains(rect))
        assertEquals(expected = "100", actual = rect.attributes.getNamedItem("width")?.value)
        assertEquals(expected = "100", actual = rect.attributes.getNamedItem("height")?.value)
    }
}