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
 * The `numOctaves` attribute defines the number of octaves for the noise function of the
 * [dev.jamesyox.svgk.tags.FeTurbulence] primitive.
 *
 * An octave is a noise function defined by its frequency and amplitude. A turbulence is built by accumulating
 * several octaves with increasing frequencies and decreasing amplitudes. The higher the number of octaves,
 * the more natural the noise looks. Though more octaves also require more calculations, resulting in a
 * negative impact on performance.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.NumOctaves
)
public var numOctaves: Int
    get() = noGet()
    set(value) {
        ac["numOctaves"] = value.svgString
    }
