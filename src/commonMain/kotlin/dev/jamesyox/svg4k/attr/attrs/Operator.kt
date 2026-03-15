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
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.FeComposite
import dev.jamesyox.svg4k.tags.FeMorphology

/**
 * Defines the compositing operation to be performed
 */
context(
    ac: AttributeConsumer,
    _: FeComposite
)
public var operator: CompositeOperator
    get() = noGet()
    set(value) {
        ac["operator"] = value.svgString
    }

public enum class CompositeOperator(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the source graphic defined in the [in] attribute is placed over the destination graphic
     * defined in the [in2] attribute.
     */
    Over("over"),

    /**
     * This value indicates that the parts of the source graphic defined in the [in] attribute that overlap the
     * destination graphic defined in the [in2] attribute, replace the destination graphic.
     */
    In("in"),

    /**
     * This value indicates that the parts of the source graphic defined in the [in] attribute that fall outside the
     * destination graphic defined in the [in2] attribute, are displayed.
     */
    Out("out"),

    /**
     * This value indicates that the parts of the source graphic defined in the [in] attribute, which overlap the
     * destination graphic defined in the [in2] attribute, replace the destination graphic.
     * The parts of the destination graphic that do not overlap with the source graphic stay untouched.
     */
    Atop("atop"),

    /**
     * This value indicates that the non-overlapping regions of the source graphic defined in the [in] attribute and the
     * destination graphic defined in the [in2] attribute are combined.
     */
    Xor("xor"),

    /**
     * This value indicates that the sum of the source graphic defined in the [in] attribute and the destination
     * graphic defined in the [in2] attribute is displayed.
     */
    Lighter("lighter"),

    /**
     *
     * This value indicates that the source graphic defined in the [in] attribute and the destination graphic defined
     * in the [in2] attribute are combined using the following formula:
     *
     * `result = k1*i1*i2 + k2*i1 + k3*i2 + k4`
     *
     * where: `i1` and `i2` indicate the corresponding pixel channel values of the input image,
     * which map to [in] and [in2] respectively, and `k1`, `k2`, `k3`, and `k4` indicate the values of the attributes
     * with the same name.
     */
    Arithmetic("arithmetic"),
}

/**
 * Defines the morphing operation to be performed
 */
context(
    ac: AttributeConsumer,
    _: FeMorphology
)
public var operator: MorphOperator
    get() = noGet()
    set(value) {
        ac["operator"] = value.svgString
    }

public enum class MorphOperator(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * This value thins the source graphic defined in the [in] attribute.
     */
    Erode("erode"),

    /**
     * This value fattens the source graphic defined in the [in] attribute.
     */
    Dilate("dilate"),
}
