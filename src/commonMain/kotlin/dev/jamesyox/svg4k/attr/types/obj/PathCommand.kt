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

package dev.jamesyox.svg4k.attr.types.obj

import dev.jamesyox.svg4k.attr.ConstantSvgAttributeType
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.svgString

internal sealed interface PathCommand : SvgAttributeType {
    class A(
        rx: Number,
        ry: Number,
        angle: Number,
        largeArcFlag: Boolean,
        sweepFlag: Boolean,
        x: Number,
        y: Number,
    ) : PathCommand {
        override val svgString: String = "A $rx $ry $angle ${largeArcFlag.svgString} ${sweepFlag.svgString} $x $y"
    }

    class C(
        x1: Number,
        y1: Number,
        x2: Number,
        y2: Number,
        x: Number,
        y: Number,
    ) : PathCommand {
        override val svgString: String = "C $x1 $y1 $x2 $y2 $x $y"
    }

    @Suppress("ktlint:standard:class-naming")
    class c(
        dx1: Number,
        dy1: Number,
        dx2: Number,
        dy2: Number,
        dx: Number,
        dy: Number,
    ) : PathCommand {
        override val svgString: String = "C $dx1 $dy1 $dx2 $dy2 $dx $dy"
    }

    class H(
        x: Number,
    ) : PathCommand {
        override val svgString: String = "H $x"
    }

    @Suppress("ktlint:standard:class-naming")
    class h(
        dx: Number,
    ) : PathCommand {
        override val svgString: String = "h $dx"
    }

    class V(
        y: Number,
    ) : PathCommand {
        override val svgString: String = "V $y"
    }

    @Suppress("ktlint:standard:class-naming")
    class v(
        dy: Number,
    ) : PathCommand {
        override val svgString: String = "v $dy"
    }

    class L(
        x: Number,
        y: Number,
    ) : PathCommand {
        override val svgString: String = "L $x $y"
    }

    class M(
        x: Number,
        y: Number,
    ) : PathCommand {
        override val svgString: String = "M $x $y"
    }

    @Suppress("ktlint:standard:class-naming")
    class m(
        dx: Number,
        dy: Number,
    ) : PathCommand {
        override val svgString: String = "m $dx $dy"
    }

    class Q(
        x1: Number,
        x2: Number,
        x: Number,
        y: Number,
    ) : PathCommand {
        override val svgString: String = "Q $x1 $x2 $x $y"
    }

    data object Z : PathCommand, ConstantSvgAttributeType("Z")
}