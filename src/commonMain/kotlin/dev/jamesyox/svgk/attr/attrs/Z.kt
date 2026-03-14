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
import dev.jamesyox.svgk.meta.noGet

/**
 * The `z` attribute defines the location along the z-axis for a light source in the coordinate system established by
 * the [primitiveUnits] attribute on the [dev.jamesyox.svgk.tags.Filter] element, assuming that, in the initial
 * coordinate system, the positive z-axis comes out towards the person viewing the content and assuming that one
 * unit along the z-axis equals one unit in x and y.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Z
)
public var z: Number
    get() = noGet()
    set(value) {
        ac["z"] = value.svgString
    }
