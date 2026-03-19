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
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The attributeType attribute specifies the namespace in which the target attribute and its associated
 * values are defined.
 */
@Deprecated("Deprecated web standard")
context(
    ac: AttributeConsumer,
    _: AttributeContainer.AttributeType
)
public var attributeType: AttributeType
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["attributeType"] = value.svgString
    }

@Deprecated("Deprecated web standard")
public enum class AttributeType(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * The attributeName attribute indicates the name of the CSS property or attribute of the target element that is
     * going to be changed during an animation.
     */
    CSS("CSS"),

    /**
     * This value specifies that the value of attributeName is the name of an XML attribute defined
     * as animatable in the default XML namespace for the target element.
     */
    XML("XML"),

    /**
     * This value specifies that the implementation should match the attributeName to an attribute for the target
     * element. User agents first search through the list of CSS properties for a matching property name, and if none
     * is found, search the default XML namespace for the element.
     */
    Auto("auto"),
}
