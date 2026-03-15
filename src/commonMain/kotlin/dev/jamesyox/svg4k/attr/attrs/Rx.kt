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
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.tags.Ellipse
import dev.jamesyox.svg4k.tags.Rect

// TODO: Missing auto? Is this inconsistent? I wish we could override setters....

/**
 * For [Ellipse], [rx] defines the x-radius of the shape. With a value lower or equal to zero the ellipse
 * won't be drawn at all.
 */
context(
    ac: AttributeConsumer,
    _: Ellipse
)
public var rx: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["rx"] = value
    }

/**
 * For [dev.jamesyox.svg4k.tags.Rect], [rx] defines the x-axis radius of the ellipse used to round off the
 * corners of the rectangle.
 *
 * The way the value of the [rx] attribute is interpreted depend on both the [ry] attribute and the width of
 * the rectangle:
 *
 *  * If a properly specified value is provided for [rx] but not for [ry] (or the opposite), then the browser
 * will consider the missing value equal to the defined one.
 *  * If neither [rx] nor [ry] has a properly specified value, then the browser will draw a rectangle with
 *  square corners.
 *  * If [rx] is greater than half of the width of the rectangle, then the browser will consider the value for [rx]
 *  as half of the width of the rectangle.
 */
context(
    ac: AttributeConsumer,
    _: Rect
)
public var rx: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["rx"] = value
    }

/**
 * Unsafe version of [rx]. Functionality depends on what [dev.jamesyox.svg4k.SvgTag] is the parent.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Rx
)
public var rx: LengthOrPercentage
    get() = noGet()
    set(value) {
        ac["rx"] = value
    }
