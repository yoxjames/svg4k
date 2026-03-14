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
import dev.jamesyox.svgk.meta.noGet

/**
 * The `begin` attribute defines when the associated element becomes active. For an animation element, this is the point
 * at which the animation should begin.
 *
 * The attribute value is a semicolon separated list of values. The interpretation of a list of start times is detailed
 * in the SMIL specification in "Evaluation of begin and end time lists". Each individual value can be one of the
 * following: <offset-value>, <syncbase-value>, <event-value>, <repeat-value>, <accessKey-value>, <wallclock-sync-value>
 * or the keyword indefinite.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Begin,
)
public var begin: String // TODO: Weakly typed
    get() = noGet()
    set(value) {
        ac["begin"] = value
    }
