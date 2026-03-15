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
import dev.jamesyox.svg4k.attr.types.obj.PathCommand
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.PathBuilder
import dev.jamesyox.svg4k.util.pathBuilder
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

context(
    ac: AttributeConsumer,
    _: AttributeContainer.D
)
internal var d: List<PathCommand>
    get() = noGet()
    set(value) {
        ac["d"] = value.svgString(" ")
    }

/**
 * The `d` attribute defines a path to be drawn.
 *
 * A path definition is a list of path commands where each command is composed of a command letter and numbers
 * that represent the command parameters.
 *
 * This function takes a lambda which leverages the [PathBuilder] DSL which includes extension functions for the
 * various path commands
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.D
)
public fun d(block: context (PathBuilder) () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    d = pathBuilder(block)
}
