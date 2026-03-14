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
import dev.jamesyox.svgk.attr.types.obj.Url
import dev.jamesyox.svgk.meta.noGet

/**
 * The `marker-end` attribute defines the arrowhead or polymarker that will be drawn at the final vertex of the given
 * shape.
 *
 * For all shape elements, except `<polyline>` and `<path>`, the last vertex is the same as the first vertex.
 * In this case, if the value of `marker-start` and `marker-end` are both not none, then two markers will be rendered
 * on that final vertex. For `<path>` elements, for each closed subpath, the last vertex is the same as the first
 * vertex. `marker-end` is only rendered on the final vertex of the path data.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.MarkerEnd
)
public var markerEnd: Url
    get() = noGet()
    set(value) {
        ac["marker-end"] = value
    }
