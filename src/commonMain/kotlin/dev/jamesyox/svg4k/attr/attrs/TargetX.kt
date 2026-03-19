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
import dev.jamesyox.svg4k.attr.ConstantSvgAttributeType
import dev.jamesyox.svg4k.attr.SvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `target` attribute should be used when there are multiple possible targets for the ending resource, such as
 * when the parent document is embedded within an HTML or XHTML document, or is viewed with a tabbed browser.
 * This attribute specifies the name of the browsing context (e.g., a browser tab or an (X)HTML iframe or object
 * element) into which a document is to be opened when the link is activated.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Target
)
public var target: Target
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["target"] = value
    }

public sealed interface Target : SvgAttributeType {
    /**
     * The current SVG image is replaced by the linked content in the same browsing context as the current SVG image.
     */
    public data object Self : Target, ConstantSvgAttributeType("_self")

    /**
     * The immediate parent browsing context of the SVG image is replaced by the linked content, if it exists and can
     * be securely accessed from this document.
     */
    public data object Parent : Target, ConstantSvgAttributeType("_parent")

    /**
     * The content of the full active window or tab is replaced by the linked content, if it exists and can be securely
     * accessed from this document
     */
    public data object Top : Target, ConstantSvgAttributeType("_top")

    /**
     * A new un-named window or tab is requested for the display of the linked content, if this document can securely do so. If the user agent does not support multiple windows/tabs, the result is the same as _top.
     */
    public data object Blank : Target, ConstantSvgAttributeType("_blank")

    /**
     * Specifies the name of the browsing context (tab, inline frame, object, etc.) for display of the linked content.
     * If a context with this name already exists, and can be securely accessed from this document, it is re-used,
     * replacing the existing content. If it does not exist, it is created (the same as '_blank', except that it now
     * has a name). The name must be a valid XML Name [XML11], and should not start with an underscore
     * (U+005F LOW LINE character), to meet the requirements of a valid browsing context name from HTML.
     */
    public class XmlName(
        public val value: String,
    ) : ConstantSvgAttributeType(value),
        Target
}
