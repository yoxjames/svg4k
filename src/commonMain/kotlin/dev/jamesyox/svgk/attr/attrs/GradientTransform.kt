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

package dev.jamesyox.svgk.attr.attrs

import dev.jamesyox.svgk.attr.AttributeConsumer
import dev.jamesyox.svgk.attr.AttributeContainer
import dev.jamesyox.svgk.attr.svgString
import dev.jamesyox.svgk.util.TransformBuilder
import dev.jamesyox.svgk.util.transformBuilder
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * The gradientTransform attribute contains the definition of an optional additional transformation from the gradient
 * coordinate system onto the target coordinate system (i.e., userSpaceOnUse or objectBoundingBox). This allows for
 * things such as skewing the gradient. This additional transformation matrix is post-multiplied to
 * (i.e., inserted to the right of) any previously defined transformations, including the implicit transformation
 * necessary to convert from object bounding box units to user space.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.GradientTransform
)
public fun gradientTransform(block: context(TransformBuilder) () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    ac["gradientTransform"] = transformBuilder(block).svgString(" ")
}
