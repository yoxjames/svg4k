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
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet

/**
 * The `pointer-events` attribute is a presentation attribute that allows defining whether or when an element may
 * be the target of a mouse event.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PointerEvents
)
public var pointerEvents: PointerEvents
    get() = noGet()
    set(value) {
        ac["pointer-events"] = value
    }

public enum class PointerEvents(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * The element can only be the target of a pointer event when the pointer is over the bounding box of the element.
     */
    BoundingBox("bounding-box"),

    /**
     * The element can only be the target of a pointer event when the [visibility] property is set to visible
     * and e.g., when a mouse cursor is over the interior (i.e., [fill]) of the element and the [fill] property
     * is set to a value other than none, or when a mouse cursor is over the perimeter (i.e., 'stroke')
     * of the element and the stroke property is set to a value other than none.
     */
    VisiblePainted("visiblePainted"),

    /**
     * The element can only be the target of a pointer event when the [visibility] property is set to visible and
     * when e.g., a mouse cursor is over the interior (i.e., [fill]) of the element. The value of the [fill] property
     * does not affect event processing.
     */
    VisibleFull("visibleFull"),

    /**
     * SVG only. The element can only be the target of a pointer event when the [visibility] property is set to
     * visible and e.g., when the mouse cursor is over the perimeter (i.e., [stroke]) of the element.
     * The value of the [stroke] property does not affect event processing.
     */
    VisibleStroke("visibleStroke"),

    /**
     * The element can be the target of a pointer event when the [visibility] property is set to visible and e.g.,
     * the mouse cursor is over either the interior (i.e., [fill]) or the perimeter (i.e., [stroke]) of the element.
     * The values of the [fill] and [stroke] do not affect event processing.
     */
    Visible("visible"),

    /**
     * The element can only be the target of a pointer event when e.g., the mouse cursor is over the interior
     * (i.e., [fill]) of the element and the [fill] property is set to a value other than none, or when
     * the mouse cursor is over the perimeter (i.e., [stroke]) of the element and the [stroke] property
     * is set to a value other than none. The value of the [visibility] property does not affect event processing.
     */
    Painted("painted"),

    /**
     * The element can only be the target of a pointer event when the pointer is over the interior
     * (i.e., [fill]) of the element. The values of the [fill] and [visibility] properties do not
     * affect event processing.
     */
    Fill("fill"),

    /**
     * The element can only be the target of a pointer event when the pointer is over the perimeter (i.e., [stroke])
     * of the element. The values of the [stroke] and [visibility] properties do not affect event processing.
     */
    Stroke("stroke"),

    /**
     * The element can only be the target of a pointer event when the pointer is over the interior (i.e., [fill])
     * or the perimeter (i.e., [stroke]) of the element. The values of the [fill], [stroke], and
     * [visibility] properties do not affect event processing.
     */
    All("all"),

    /**
     * The element on its own is never the target of pointer events. However, its subtree could be kept targetable
     * by setting [pointerEvents] to some other value. In these circumstances, pointer events will trigger event
     * listeners on this parent element as appropriate on their way to or from the descendant during the event
     * capture and bubble phases.
     */
    None("none"),
}
