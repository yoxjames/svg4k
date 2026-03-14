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
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.set
import dev.jamesyox.svgk.meta.noGet

/**
 * The `visibility` attribute lets you control the visibility of graphical elements.
 * With a value of hidden or collapse the current graphics element is invisible.
 *
 * Depending on the value of attribute [pointerEvents], graphics elements which have their visibility attribute set
 * to hidden still might receive events.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Visibility
)
public var visibility: Visibility
    get() = noGet()
    set(value) {
        ac["visibility"] = value
    }

public enum class Visibility(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the element will be painted.
     */
    Visible("visible"),

    /**
     * This value indicates that the element will not be painted. Though it is still part of the rendering tree,
     * i.e., it may receive pointer events depending on the [pointerEvents] attribute, may receive focus depending on
     * the [tabindex] attribute, contributes to bounding box calculations and clipping paths, and does affect text
     * layout.
     */
    Hidden("hidden"),

    /**
     * This value is equal to hidden.
     */
    Collapse("collapse"),
}
