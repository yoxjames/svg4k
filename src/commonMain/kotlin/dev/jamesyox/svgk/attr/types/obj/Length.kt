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

package dev.jamesyox.svgk.attr.types.obj

import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.svgString
import dev.jamesyox.svgk.attr.types.obj.Length.Cap
import dev.jamesyox.svgk.attr.types.obj.Length.Ch
import dev.jamesyox.svgk.attr.types.obj.Length.Cm
import dev.jamesyox.svgk.attr.types.obj.Length.Cqb
import dev.jamesyox.svgk.attr.types.obj.Length.Cqj
import dev.jamesyox.svgk.attr.types.obj.Length.Cqmax
import dev.jamesyox.svgk.attr.types.obj.Length.Cqmin
import dev.jamesyox.svgk.attr.types.obj.Length.Cqw
import dev.jamesyox.svgk.attr.types.obj.Length.Dvh
import dev.jamesyox.svgk.attr.types.obj.Length.Dvmax
import dev.jamesyox.svgk.attr.types.obj.Length.Dvmin
import dev.jamesyox.svgk.attr.types.obj.Length.Dvw
import dev.jamesyox.svgk.attr.types.obj.Length.Em
import dev.jamesyox.svgk.attr.types.obj.Length.Ex
import dev.jamesyox.svgk.attr.types.obj.Length.Ic
import dev.jamesyox.svgk.attr.types.obj.Length.In
import dev.jamesyox.svgk.attr.types.obj.Length.Lh
import dev.jamesyox.svgk.attr.types.obj.Length.Lvh
import dev.jamesyox.svgk.attr.types.obj.Length.Lvmax
import dev.jamesyox.svgk.attr.types.obj.Length.Lvmin
import dev.jamesyox.svgk.attr.types.obj.Length.Lvw
import dev.jamesyox.svgk.attr.types.obj.Length.Mm
import dev.jamesyox.svgk.attr.types.obj.Length.None
import dev.jamesyox.svgk.attr.types.obj.Length.Pc
import dev.jamesyox.svgk.attr.types.obj.Length.Pt
import dev.jamesyox.svgk.attr.types.obj.Length.Px
import dev.jamesyox.svgk.attr.types.obj.Length.Q
import dev.jamesyox.svgk.attr.types.obj.Length.Rcap
import dev.jamesyox.svgk.attr.types.obj.Length.Rch
import dev.jamesyox.svgk.attr.types.obj.Length.Rem
import dev.jamesyox.svgk.attr.types.obj.Length.Rex
import dev.jamesyox.svgk.attr.types.obj.Length.Ric
import dev.jamesyox.svgk.attr.types.obj.Length.Rlh
import dev.jamesyox.svgk.attr.types.obj.Length.Vb
import dev.jamesyox.svgk.attr.types.obj.Length.Vh
import dev.jamesyox.svgk.attr.types.obj.Length.Vi
import dev.jamesyox.svgk.attr.types.obj.Length.Vmax
import dev.jamesyox.svgk.attr.types.obj.Length.Vmin
import dev.jamesyox.svgk.attr.types.obj.Length.Vw

public sealed interface LengthOrPercentage : SvgAttributeType

public sealed interface MeasurementUnit

public sealed class Length(
    public val unit: String,
) : SvgAttributeType,
    LengthOrPercentage {
    public abstract val value: Number
    override val svgString: String get() = "${value.svgString}$unit"

    public class Cap(
        override val value: Number,
    ) : Length("cap") {
        public companion object : MeasurementUnit
    }

    public class Ch(
        override val value: Number,
    ) : Length("ch") {
        public companion object : MeasurementUnit
    }

    public class Em(
        override val value: Number,
    ) : Length("em") {
        public companion object : MeasurementUnit
    }

    public class Ex(
        override val value: Number,
    ) : Length("ex") {
        public companion object : MeasurementUnit
    }

    public class Ic(
        override val value: Number,
    ) : Length("ic") {
        public companion object : MeasurementUnit
    }

    public class Lh(
        override val value: Number,
    ) : Length("lh") {
        public companion object : MeasurementUnit
    }

    public class Rcap(
        override val value: Number,
    ) : Length("rcap") {
        public companion object : MeasurementUnit
    }

    public class Rch(
        override val value: Number,
    ) : Length("rch") {
        public companion object : MeasurementUnit
    }

    public class Rem(
        override val value: Number,
    ) : Length("rem") {
        public companion object : MeasurementUnit
    }

    public class Rex(
        override val value: Number,
    ) : Length("rex") {
        public companion object : MeasurementUnit
    }

    public class Ric(
        override val value: Number,
    ) : Length("ric") {
        public companion object : MeasurementUnit
    }

    public class Rlh(
        override val value: Number,
    ) : Length("rlh") {
        public companion object : MeasurementUnit
    }

    public class Vh(
        override val value: Number,
    ) : Length("vh") {
        public companion object : MeasurementUnit
    }

    public class Lvh(
        override val value: Number,
    ) : Length("lvh") {
        public companion object : MeasurementUnit
    }

    public class Dvh(
        override val value: Number,
    ) : Length("dvh") {
        public companion object : MeasurementUnit
    }

    public class Vw(
        override val value: Number,
    ) : Length("vw") {
        public companion object : MeasurementUnit
    }

    public class Lvw(
        override val value: Number,
    ) : Length("lvw") {
        public companion object : MeasurementUnit
    }

    public class Dvw(
        override val value: Number,
    ) : Length("dvw") {
        public companion object : MeasurementUnit
    }

    public class Vmax(
        override val value: Number,
    ) : Length("vmax") {
        public companion object : MeasurementUnit
    }

    public class Lvmax(
        override val value: Number,
    ) : Length("lvmax") {
        public companion object : MeasurementUnit
    }

    public class Dvmax(
        override val value: Number,
    ) : Length("dvmax") {
        public companion object : MeasurementUnit
    }

    public class Vmin(
        override val value: Number,
    ) : Length("vmin") {
        public companion object : MeasurementUnit
    }

    public class Lvmin(
        override val value: Number,
    ) : Length("lvmin") {
        public companion object : MeasurementUnit
    }

    public class Dvmin(
        override val value: Number,
    ) : Length("dvmin") {
        public companion object : MeasurementUnit
    }

    public class Vb(
        override val value: Number,
    ) : Length("vb") {
        public companion object : MeasurementUnit
    }

    public class Vi(
        override val value: Number,
    ) : Length("vi") {
        public companion object : MeasurementUnit
    }

    public class Cqw(
        override val value: Number,
    ) : Length("cqw") {
        public companion object : MeasurementUnit
    }

    public class Cqj(
        override val value: Number,
    ) : Length("cqj") {
        public companion object : MeasurementUnit
    }

    public class Cqb(
        override val value: Number,
    ) : Length("cqb") {
        public companion object : MeasurementUnit
    }

    public class Cqmin(
        override val value: Number,
    ) : Length("cqmin") {
        public companion object : MeasurementUnit
    }

    public class Cqmax(
        override val value: Number,
    ) : Length("cqmax") {
        public companion object : MeasurementUnit
    }

    public class Px(
        override val value: Number,
    ) : Length("px") {
        public companion object : MeasurementUnit
    }

    public class Cm(
        override val value: Number,
    ) : Length("cm") {
        public companion object : MeasurementUnit
    }

    public class Mm(
        override val value: Number,
    ) : Length("mm") {
        public companion object : MeasurementUnit
    }

    public class Q(
        override val value: Number,
    ) : Length("Q") {
        public companion object : MeasurementUnit
    }

    public class In(
        override val value: Number,
    ) : Length("in") {
        public companion object : MeasurementUnit
    }

    public class Pc(
        override val value: Number,
    ) : Length("pc") {
        public companion object : MeasurementUnit
    }

    public class Pt(
        override val value: Number,
    ) : Length("pt") {
        public companion object : MeasurementUnit
    }

    public class None(
        override val value: Number,
    ) : Length("") {
        public companion object : MeasurementUnit
    }
}

public class Pct(
    public val value: Number,
) : SvgAttributeType,
    LengthOrPercentage {
    override val svgString: String = "${value.svgString}%"

    public companion object : MeasurementUnit
}

public inline val Number.pct: Pct get() = Pct(this)

public inline val Number.cap: Cap get() = Cap(this)
public inline val Number.ch: Ch get() = Ch(this)
public inline val Number.em: Em get() = Em(this)
public inline val Number.ex: Ex get() = Ex(this)
public inline val Number.ic: Ic get() = Ic(this)
public inline val Number.lh: Lh get() = Lh(this)

public inline val Number.rcap: Rcap get() = Rcap(this)
public inline val Number.rch: Rch get() = Rch(this)
public inline val Number.rem: Rem get() = Rem(this)
public inline val Number.rex: Rex get() = Rex(this)
public inline val Number.ric: Ric get() = Ric(this)
public inline val Number.rlh: Rlh get() = Rlh(this)

public inline val Number.vh: Vh get() = Vh(this)
public inline val Number.lvh: Lvh get() = Lvh(this)
public inline val Number.dvh: Dvh get() = Dvh(this)

public inline val Number.vw: Vw get() = Vw(this)
public inline val Number.lvw: Lvw get() = Lvw(this)
public inline val Number.dvw: Dvw get() = Dvw(this)

public inline val Number.vmax: Vmax get() = Vmax(this)
public inline val Number.lvmax: Lvmax get() = Lvmax(this)
public inline val Number.dvmax: Dvmax get() = Dvmax(this)

public inline val Number.vmin: Vmin get() = Vmin(this)
public inline val Number.lvmin: Lvmin get() = Lvmin(this)
public inline val Number.dvmin: Dvmin get() = Dvmin(this)

public inline val Number.vb: Vb get() = Vb(this)
public inline val Number.vi: Vi get() = Vi(this)

public inline val Number.cqw: Cqw get() = Cqw(this)
public inline val Number.cqj: Cqj get() = Cqj(this)
public inline val Number.cqb: Cqb get() = Cqb(this)
public inline val Number.cqmin: Cqmin get() = Cqmin(this)
public inline val Number.cqmax: Cqmax get() = Cqmax(this)

public inline val Number.px: Px get() = Px(this)
public inline val Number.cm: Cm get() = Cm(this)
public inline val Number.mm: Mm get() = Mm(this)
public inline val Number.q: Q get() = Q(this)
public inline val Number.`in`: In get() = In(this)
public inline val Number.inch: In get() = this.`in`
public inline val Number.pc: Pc get() = Pc(this)
public inline val Number.pt: Pt get() = Pt(this)

public inline val Number.none: None get() = None(this)
