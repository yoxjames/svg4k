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
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.attr.types.obj.NumberOptionalNumber
import dev.jamesyox.svgk.meta.noGet
import dev.jamesyox.svgk.tags.FeConvolveMatrix

/**
 * Indicates the intended distance in current filter units (i.e., units as determined by the value of attribute
 * primitiveUnits) for the x and y coordinate, respectively, in the surface normal calculation formulas.
 *
 * The first number is the x value. The second number is the y value. If the y value is not specified, it defaults to
 * the same value as x. By specifying value(s) for `kernelUnitLength`, the kernel becomes defined in a scalable,
 * abstract coordinate system. If the attribute is not specified, the x and y values represent very small deltas
 * relative to a given position, which might be implemented in some cases as one pixel in the intermediate image
 * offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable.
 *
 * If a negative or zero value is specified the default value will be used instead.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.KernelUnitLength
)
public var kernelUnitLength: NumberOptionalNumber
    get() = noGet()
    set(value) {
        ac["kernelUnitLength"] = value
    }

/**
 * For the `<feConvolveMatrix>`, `kernelUnitLength` indicates the intended distance in current filter units
 * (i.e., units as determined by the value of primitiveUnits attribute) between successive columns and rows,
 * respectively, in the kernelMatrix. By specifying value(s) for kernelUnitLength, the kernel becomes defined in a
 * scalable, abstract coordinate system. If the attribute is not specified, the default value is one pixel in the
 * offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable.
 *
 * If a negative or zero value is specified the default value will be used instead.
 */
context(
    ac: AttributeConsumer,
    _: FeConvolveMatrix
)
public var kernelUnitLength: NumberOptionalNumber
    get() = noGet()
    set(value) {
        ac["kernelUnitLength"] = value
    }
