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
import dev.jamesyox.svg4k.attr.types.obj.Url
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `marker-start` attribute defines the arrowhead or polymarker that will be drawn at the first vertex of the
 * given shape.
 *
 * For all shape elements, except `<polyline>` and `<path>`, the last vertex is the same as the first vertex.
 * In this case, if the value of `marker-start` and `marker-end` are both not none, then two markers will be rendered on
 * that final vertex. For `<path>` elements, for each closed subpath, the last vertex is the same as the first
 * vertex. `marker-start` is only rendered on the first vertex of the path data.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.MarkerStart
)
public var markerStart: Url
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["marker-start"] = value
    }
