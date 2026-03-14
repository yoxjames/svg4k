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

import dev.jamesyox.svgk.attr.ConstantSvgAttributeType
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.WrappedListSvgAttributeType
import dev.jamesyox.svgk.attr.WrappedSvgAttributeType

public sealed interface TransformOrigin : SvgAttributeType {
    public sealed interface OneValueSyntax : TransformOrigin {
        public data object Left : OneValueSyntax, ConstantSvgAttributeType("left")

        public data object Center : OneValueSyntax, ConstantSvgAttributeType("center")

        public data object Right : OneValueSyntax, ConstantSvgAttributeType("right")

        public data object Top : OneValueSyntax, ConstantSvgAttributeType("top")

        public class Length(
            public val value: dev.jamesyox.svgk.attr.types.obj.Length,
        ) : WrappedSvgAttributeType(value),
            OneValueSyntax
    }

    public class TwoValueSyntax(
        firstValue: TransformOriginFirstValue,
        secondValue: TransformOriginSecondValue,
    ) : WrappedListSvgAttributeType(separator = " ", list = listOf(firstValue, secondValue)),
        TransformOrigin

    public class ThreeValueSyntax(
        firstValue: TransformOriginFirstValue,
        secondValue: TransformOriginSecondValue,
        thirdValue: Length,
    ) : WrappedListSvgAttributeType(separator = " ", list = listOf(firstValue, secondValue, thirdValue)),
        TransformOrigin
}

public sealed interface TransformOriginFirstValue : SvgAttributeType {
    public data object Left : TransformOriginFirstValue, ConstantSvgAttributeType("left")

    public data object Center : TransformOriginFirstValue, ConstantSvgAttributeType("center")

    public data object Right : TransformOriginFirstValue, ConstantSvgAttributeType("right")

    public class Length(
        public val value: dev.jamesyox.svgk.attr.types.obj.Length,
    ) : WrappedSvgAttributeType(value),
        TransformOriginFirstValue

    public class Percentage(
        public val value: Pct,
    ) : WrappedSvgAttributeType(value),
        TransformOriginFirstValue
}

public sealed interface TransformOriginSecondValue : SvgAttributeType {
    public data object Top : TransformOriginSecondValue, ConstantSvgAttributeType("top")

    public data object Center : TransformOriginSecondValue, ConstantSvgAttributeType("center")

    public data object Bottom : TransformOriginSecondValue, ConstantSvgAttributeType("bottom")

    public class Length(
        public val value: dev.jamesyox.svgk.attr.types.obj.Length,
    ) : WrappedSvgAttributeType(value),
        TransformOriginSecondValue

    public class Percentage(
        public val value: Pct,
    ) : WrappedSvgAttributeType(value),
        TransformOriginSecondValue
}
