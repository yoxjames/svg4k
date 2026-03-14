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

internal sealed interface TransformFunction : SvgAttributeType {
    class Translate(
        x: Number,
        y: Number? = null
    ) : TransformFunction {
        override val svgString: String = "translate($x${param(y)})"
    }

    class Scale(
        x: Number,
        y: Number? = null
    ) : TransformFunction {
        override val svgString: String = "scale($x${param(y)})"
    }

    class Rotate(
        a: Number,
        x: Number? = null,
        y: Number? = null,
    ) : TransformFunction {
        override val svgString: String = "rotate($a" + param(x) + param(y) + ")"
    }

    class SkewX(
        a: Number,
    ) : TransformFunction {
        override val svgString: String = "skewX($a)"
    }

    class SkewY(
        a: Number,
    ) : TransformFunction {
        override val svgString: String = "skewY($a)"
    }
}

private fun param(param: Number?) = (param?.let { " $param" } ?: "")
