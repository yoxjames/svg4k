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

import dev.jamesyox.svg4k.attr.types.obj.PathCommand
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public class PathBuilder {
    private val commands = mutableListOf<PathCommand>()

    internal fun add(command: PathCommand) {
        commands.add(command)
    }

    internal fun build(): List<PathCommand> = commands.toList()
}

internal fun pathBuilder(block: context (PathBuilder) () -> Unit): List<PathCommand> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return PathBuilder().apply(block).build()
}

context(builder: PathBuilder)
public fun A(
    rx: Number,
    ry: Number,
    angle: Number,
    largeArcFlag: Boolean,
    sweepFlag: Boolean,
    x: Number,
    y: Number,
) {
    builder.add(
        PathCommand.A(rx = rx, ry = ry, angle = angle, largeArcFlag = largeArcFlag, sweepFlag = sweepFlag, x = x, y = y)
    )
}
context(_: PathBuilder)
public fun EllipticalArcCurve(
    rx: Number,
    ry: Number,
    angle: Number,
    largeArcFlag: Boolean,
    sweepFlag: Boolean,
    x: Number,
    y: Number,
) {
    A(rx = rx, ry = ry, angle = angle, largeArcFlag = largeArcFlag, sweepFlag = sweepFlag, x = x, y = y)
}

context(builder: PathBuilder)
public fun C(
    x1: Number,
    y1: Number,
    x2: Number,
    y2: Number,
    x: Number,
    y: Number
) {
    builder.add(PathCommand.C(x1 = x1, y1 = y1, x2 = x2, y2 = y2, x = x, y = y))
}
context(_: PathBuilder)
public fun CubicCurve(
    x1: Number,
    y1: Number,
    x2: Number,
    y2: Number,
    x: Number,
    y: Number
) {
    C(x1 = x1, y1 = y1, x2 = x2, y2 = y2, x = x, y = y)
}

context(builder: PathBuilder)
public fun c(
    dx1: Number,
    dy1: Number,
    dx2: Number,
    dy2: Number,
    dx: Number,
    dy: Number
) {
    builder.add(PathCommand.c(dx1 = dx1, dy1 = dy1, dx2 = dx2, dy2 = dy2, dx = dx, dy = dy))
}
context(_: PathBuilder)
public fun CubicCurveRelative(
    dx1: Number,
    dy1: Number,
    dx2: Number,
    dy2: Number,
    dx: Number,
    dy: Number
) {
    c(dx1 = dx1, dy1 = dy1, dx2 = dx2, dy2 = dy2, dx = dx, dy = dy)
}

context(builder: PathBuilder)
public fun H(x: Number) {
    builder.add(PathCommand.H(x = x))
}
context(_: PathBuilder)
public fun HorizontalLineTo(x: Number) {
    H(x = x)
}

context(builder: PathBuilder)
public fun h(dx: Number) {
    builder.add(PathCommand.h(dx = dx))
}
context(_: PathBuilder)
public fun HorizontalLine(dx: Number) {
    h(dx = dx)
}

context(builder: PathBuilder)
public fun V(y: Number) {
    builder.add(PathCommand.V(y = y))
}
context(_: PathBuilder)
public fun VerticalLine(y: Number) {
    V(y = y)
}

context(builder: PathBuilder)
public fun v(dy: Number) {
    builder.add(PathCommand.v(dy = dy))
}
context(_: PathBuilder)
public fun VerticalLineTo(dy: Number) {
    v(dy = dy)
}

context(builder: PathBuilder)
public fun L(x: Number, y: Number) {
    builder.add(PathCommand.L(x = x, y = y))
}
context(_: PathBuilder)
public fun LineTo(x: Number, y: Number) {
    L(x = x, y = y)
}

context(builder: PathBuilder)
public fun M(x: Number, y: Number) {
    builder.add(PathCommand.M(x = x, y = y))
}
context(_: PathBuilder)
public fun MoveTo(x: Number, y: Number) {
    M(x = x, y = y)
}

context(builder: PathBuilder)
public fun m(dx: Number, dy: Number) {
    builder.add(PathCommand.m(dx = dx, dy = dy))
}
context(_: PathBuilder)
public fun Move(x: Number, y: Number) {
    m(dx = x, dy = y)
}

context(builder: PathBuilder)
public fun Q(
    x1: Number,
    x2: Number,
    x: Number,
    y: Number
) {
    builder.add(PathCommand.Q(x1 = x1, x2 = x2, x = x, y = y))
}
context(_: PathBuilder)
public fun QuadraticBezierCurve(
    x1: Number,
    x2: Number,
    x: Number,
    y: Number
) {
    Q(x1 = x1, x2 = x2, x = x, y = y)
}

context(builder: PathBuilder)
public val Z: Unit get() { builder.add(PathCommand.Z) }
context(_: PathBuilder)
public val ClosePath: Unit get() { Z }

