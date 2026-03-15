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

package dev.jamesyox.svg4k.util

import dev.jamesyox.svg4k.attr.types.obj.TransformFunction
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public class TransformBuilder {
    private val commands = mutableListOf<TransformFunction>()

    internal fun add(transformFunction: TransformFunction) {
        commands.add(transformFunction)
    }

    internal fun build(): List<TransformFunction> = commands.toList()
}

internal fun transformBuilder(block: context(TransformBuilder) () -> Unit): List<TransformFunction> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return TransformBuilder().apply(block).build()
}

/**
 * The [translate] transform function moves the object by [x] and [y]. If [y] is not provided,
 * it is assumed to be 0.
 */
context(builder: TransformBuilder)
public fun translate(x: Number, y: Number) {
    builder.add(TransformFunction.Translate(x = x, y = y))
}

/**
 * The [scale] transform function specifies a scale operation by [x] and [y]. If [y] is not provided,
 * it is assumed to be equal to [x].
 */
context(builder: TransformBuilder)
public fun scale(x: Number, y: Number? = null) {
    builder.add(TransformFunction.Scale(x = x, y = y))
}

/**
 * The [rotate] transform function specifies a rotation by a degrees about a given point.
 * If optional parameters [x] and [y] are not supplied, the rotation is about the origin of the current user
 * coordinate system. If optional parameters [x] and [y] are supplied, the rotation is about the point `(x, y)`.
 */
context(builder: TransformBuilder)
public fun rotate(a: Number, x: Number? = null, y: Number? = null) {
    builder.add(TransformFunction.Rotate(a = a, x = x, y = y))
}

/**
 * The [skewX] transform function specifies a skew transformation along the x-axis
 * @param a degrees to skew
 */
context(builder: TransformBuilder)
public fun skewX(a: Number) {
    builder.add(TransformFunction.SkewX(a = a))
}


/**
 * The [skewY] transform function specifies a skew transformation along the y-axis
 * @param a degrees to skew
 */
context(builder: TransformBuilder)
public fun skewY(a: Number) {
    builder.add(TransformFunction.SkewY(a = a))
}
