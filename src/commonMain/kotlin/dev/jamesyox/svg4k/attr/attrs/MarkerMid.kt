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

/**
 * The `marker-mid` attribute defines the arrowhead or polymarker that will be drawn at all interior vertices of
 * the given shape.
 *
 * The marker is rendered on every vertex other than the first and last vertices of the path data.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.MarkerMid
)
public var markerMid: Url
    get() = noGet()
    set(value) {
        ac["marker-mid"] = value
    }
