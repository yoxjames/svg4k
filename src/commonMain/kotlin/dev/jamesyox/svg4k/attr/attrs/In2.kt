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
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.FeBlend
import dev.jamesyox.svg4k.tags.FeComposite
import dev.jamesyox.svg4k.tags.FeDisplacementMap

/**
 * For `<feBlend>`, `in2` defines the second input image to the blending operation.
 */
context(
    ac: AttributeConsumer,
    _: FeBlend
)
public var in2: In
    get() = noGet()
    set(value) {
        ac["in2"] = value
    }

/**
 * For `<feComposite>`, `in2` defines the second input image to the compositing operation.
 */
context(
    ac: AttributeConsumer,
    _: FeComposite
)
public var in2: In
    get() = noGet()
    set(value) {
        ac["in2"] = value
    }

/**
 * For `<feDisplacementMap>`, `in2` defines the second input image, which is used to displace the pixels in the image
 * defined in the in attribute.
 */
context(
    ac: AttributeConsumer,
    _: FeDisplacementMap
)
public var in2: In
    get() = noGet()
    set(value) {
        ac["in2"] = value
    }

// Exists for unsafe and therefore has unspecified behavior:

context(
    ac: AttributeConsumer,
    _: AttributeContainer.In2
)
public var in2: In
    get() = noGet()
    set(value) {
        ac["in2"] = value
    }
