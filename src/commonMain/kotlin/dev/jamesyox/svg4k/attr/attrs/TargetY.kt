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
 * The `targetX` attribute determines the positioning in horizontal direction of the convolution matrix relative to a
 * given target pixel in the input image. The leftmost column of the matrix is column number zero. The value must
 * be such that: `0 <= targetX < x` of order.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.TargetY
)
public var targetY: Int
    get() = noGet()
    set(value) {
        ac["targetY"] = value.svgString
    }
