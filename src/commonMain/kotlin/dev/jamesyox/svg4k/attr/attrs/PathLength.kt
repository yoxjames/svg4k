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
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `pathLength` attribute lets authors specify a total length for the path, in user units.
 * This value is then used to calibrate the browser's distance calculations with those of the author,
 * by scaling all distance computations using the ratio `pathLength` / (computed value of path length).
 *
 * This can affect the actual rendered lengths of paths; including text paths, animation paths, and various stroke
 * operations. Basically, all computations that require the length of the path. [strokeDasharray], for example, will
 * assume the start of the path being 0 and the end point the value defined in the pathLength attribute.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PathLength
)
public var pathLength: Number
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["pathLength"] = value.svgString
    }
