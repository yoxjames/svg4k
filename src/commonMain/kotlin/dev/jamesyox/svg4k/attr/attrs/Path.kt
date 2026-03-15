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

package dev.jamesyox.svg4k.attr.attrs

import dev.jamesyox.svg4k.attr.AttributeConsumer
import dev.jamesyox.svg4k.attr.AttributeContainer
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.tags.AnimateMotion
import dev.jamesyox.svg4k.tags.TextPath
import dev.jamesyox.svg4k.util.PathBuilder
import dev.jamesyox.svg4k.util.pathBuilder
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * For [AnimateMotion], path defines the motion path, expressed in the same format and interpreted the same way as the
 * [d] geometric property for the [dev.jamesyox.svg4k.tags.Path] element. The effect of a motion path animation is a
 * translation along the x- and y-axes of the current user coordinate system by the x and y values computed over time.
 */
context(
    ac: AttributeConsumer,
    _: AnimateMotion
)
public fun path(block: context(PathBuilder) () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    ac["path"] = pathBuilder(block).svgString(" ")
}

/**
 * For [TextPath], `path` defines the path onto which the glyphs of a [dev.jamesyox.svg4k.tags.Text] element will be
 * rendered. An empty string indicates that there is no path data for the element. This means that the text
 * within the [TextPath] element does not render or contribute to the bounding box of the [dev.jamesyox.svg4k.tags.Text]
 * element. If the attribute is not specified, the path specified in href is used instead.
 */
context(
    ac: AttributeConsumer,
    _: TextPath
)
public fun path(block: context(PathBuilder) () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    ac["path"] = pathBuilder(block).svgString(" ")
}

/**
 * Unsafe version of path. Functionality depends on what [dev.jamesyox.svg4k.SvgTag] is the parent.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Path
)
public fun path(block: context(PathBuilder) () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    ac["path"] = pathBuilder(block).svgString(" ")
}