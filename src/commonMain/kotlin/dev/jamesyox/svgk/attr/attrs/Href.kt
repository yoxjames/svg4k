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
import dev.jamesyox.svgk.tags.A
import dev.jamesyox.svgk.tags.FeImage
import dev.jamesyox.svgk.tags.Image
import dev.jamesyox.svgk.tags.LinearGradient
import dev.jamesyox.svgk.tags.Pattern
import dev.jamesyox.svgk.tags.RadialGradient
import dev.jamesyox.svgk.tags.Script
import dev.jamesyox.svgk.tags.TextPath

/**
 * For `<a>`, href defines the location of the referenced object, expressed as a URL reference.
 */
context(
    ac: AttributeConsumer,
    _: A
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For the `<animate>`, `<animateMotion>`, `<animateTransform>`, and `<set>`, href defines a URL referring to the
 * element which is the target of this animation element and which therefore will be modified over time.
 *
 * The URL must point to exactly one target element which is capable of being the target of the given animation element.
 * If the URL points to multiple target elements, if the given target element is not capable of being a target of the
 * given animation element, or if the given target element is not part of the current document, then the animation
 * element will not affect any target element. However, the animation element will still operate normally with regard
 * to its timing properties. Specifically, TimeEvents are dispatched and the animation element can be used as syncbase
 * in an identical fashion to when the URL refers to a valid target element.
 *
 * If the href attribute or the deprecated xlink:href attribute is not provided, then the target element will be the
 * immediate parent element of the current animation element. If both xlink:href and href are specified, the value of
 * the latter attribute is used.
 *
 * Refer to the descriptions of the individual animation elements for any restrictions on what types of elements can
 * be targets of particular types of animations.
 *
 * Except for any SVG-specific rules explicitly mentioned in this specification, the normative definition for this
 * attribute is the SMIL Animation specification. In particular, see
 * [SMIL Animation: Specifying the animation target](https://www.w3.org/TR/smil-animation/#SpecifyingAnimationTarget).
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Href
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For `<feImage>`, href defines a URL referring to an image resource or to an element. If both, the `xlink:href` and
 * the `href` attribute are specified, the latter overrides the former.
 */
context(
    ac: AttributeConsumer,
    _: FeImage
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For `<image>`, href defines a URL referring to the image to render.
 */
context(
    ac: AttributeConsumer,
    _: Image
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For `<linearGradient>` or `<radialGradient>`, `href` defines URL referring to a template gradient element;
 * to be valid, the reference must be to a different `<linearGradient>` or `<radialGradient>` element.
 */
context(
    ac: AttributeConsumer,
    _: LinearGradient
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For `<linearGradient>` or `<radialGradient>`, `href` defines URL referring to a template gradient element;
 * to be valid, the reference must be to a different `<linearGradient>` or `<radialGradient>` element.
 */
context(
    ac: AttributeConsumer,
    _: RadialGradient
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For `<pattern>`, `href` defines a URL referring to a different `<pattern>` element within the current SVG document.
 * Any attributes which are defined on the referenced element which are not defined on this element are inherited by
 * this element. If this element has no children, and the referenced element does (possibly due to its own `href`
 * attribute), then this element inherits the children from the referenced element. Inheritance can be indirect to an
 * arbitrary level; thus, if the referenced element inherits attributes or children due to its own `href` attribute,
 * then the current element can inherit those attributes or children. On the `<pattern>` element, the `href`
 * attribute is animatable.
 */
context(
    ac: AttributeConsumer,
    _: Pattern
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For `<script>`, `href` defines a URL referring to an external resource containing the `script` code.
 */
context(
    ac: AttributeConsumer,
    _: Script
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }

/**
 * For `<textPath>`, `href` defines a URL referring to the `<path>` element or basic shape onto which the text
 * will be rendered if no `path` attribute is provided. On the `<textPath>` element, the `href` attribute is animatable.
 */
context(
    ac: AttributeConsumer,
    _: TextPath
)
public var href: String
    get() = noGet()
    set(value) {
        ac["href"] = value
    }