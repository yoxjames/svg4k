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
import dev.jamesyox.svg4k.attr.svgString
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `specularExponent` attribute controls the focus for the light source.
 * The bigger the value the brighter the light.
 *
 *  * For [dev.jamesyox.svg4k.tags.FeSpotLight], [specularExponent] defines the exponent value controlling the focus
 * for the light source.
 *  * For [dev.jamesyox.svg4k.tags.FeSpecularLighting], [specularExponent] defines the exponent value for
 *  the specular term.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.SpecularExponent
)
public var specularExponent: Number
    get() = noGet()
    set(value) {
        ac["specularExponent"] = value.svgString
    }
