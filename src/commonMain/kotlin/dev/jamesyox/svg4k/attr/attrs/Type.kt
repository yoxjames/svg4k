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
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.AnimateTransform
import dev.jamesyox.svg4k.tags.FeColorMatrix
import dev.jamesyox.svg4k.tags.FeTurbulence

/**
 * Defines the type of transformation, whose values change over time.
 */
context(
    ac: AttributeConsumer,
    _: AnimateTransform
)
public var type: AnimateTransformType
    get() = noGet()
    set(value) {
        ac["type"] = value
    }

public enum class AnimateTransformType(
    override val svgString: String,
) : SvgAttributeType {
    Translate("translate"),
    Scale("scale"),
    Rotate("rotate"),
    SkewX("skewX"),
    SkewY("skewY"),
}

/**
 * Indicates the type of Matrix operation. The keyword [FeColorMatrixType.Matrix] indicates that a full 5x4 matrix of
 * values will be provided. The other keywords represent convenience shortcuts to allow commonly used color operations
 * to be performed without specifying a complete matrix.
 */
context(
    ac: AttributeConsumer,
    _: FeColorMatrix
)
public var type: FeColorMatrixType
    get() = noGet()
    set(value) {
        ac["type"] = value
    }

public enum class FeColorMatrixType(
    override val svgString: String,
) : SvgAttributeType {
    Matrix("matrix"),
    Saturate("saturate"),
    HueRotate("hueRotate"),
    LuminanceToAlpha("luminanceToAlpha"),
}

/**
 * Indicates the type of component transfer function.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Type.FeFunc
)
public var type: FeFuncType
    get() = noGet()
    set(value) {
        ac["type"] = value
    }

public enum class FeFuncType(
    override val svgString: String,
) : SvgAttributeType {
    Identity("identity"),
    Table("table"),
    Discrete("discrete"),
    Linear("linear"),
    Gamma("gamma"),
}

/**
 * Indicates the type of component transfer function.
 */
context(
    ac: AttributeConsumer,
    _: FeTurbulence
)
public var type: FeTurbulenceType
    get() = noGet()
    set(value) {
        ac["type"] = value
    }

public enum class FeTurbulenceType(
    override val svgString: String,
) : SvgAttributeType {
    FractalNoise("fractalNoise"),
    Turbulence("turbulence"),
}

/**
 * Defines the content type of the element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Type.StyleAndScript
)
public var type: String
    get() = noGet()
    set(value) {
        ac["type"] = value
    }
