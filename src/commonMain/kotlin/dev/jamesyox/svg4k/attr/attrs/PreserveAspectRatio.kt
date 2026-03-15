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

/**
 * The `preserveAspectRatio` attribute indicates how an element with a viewBox providing a given aspect
 * ratio must fit into a viewport with a different aspect ratio.
 *
 * The aspect ratio of an SVG image is defined by the viewBox attribute. Therefore, if viewBox isn't set,
 * the preserveAspectRatio attribute has no effect on SVG's scaling (except in the case of the
 * [dev.jamesyox.svg4k.tags.Image] element, where preserveAspectRatio behaves differently as described below).
 * [Mozilla Docs](https://developer.mozilla.org/en-US/docs/Web/SVG/Reference/Attribute/preserveAspectRatio)
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.PreserveAspectRatio
)
public var preserveAspectRatio: PreserveAspectRatio
    get() = noGet()
    set(value) {
        ac["preserveAspectRatio"] = value.svgString
    }

/**
 * @param alignment indicates whether to force uniform scaling and, if so, the alignment method to use in
 * case the aspect ratio of the viewBox doesn't match the aspect ratio of the viewport.
 * [AlignmentValue.XMidYMid] is the default value.
 * @param scale How the SVG should be scaled relative to the container's bounds. Specifying the [scale] is optional.
 * [ScaleValue.Meet] is the default value
 */
public class PreserveAspectRatio(
    alignment: AlignmentValue,
    scale: ScaleValue? = null,
) : SvgAttributeType {
    override val svgString: String = "${alignment.svgString} ${scale?.svgString.orEmpty()}"
}

public enum class AlignmentValue(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * Does not force uniform scaling. Scale the graphic content of the given element non-uniformly if
     * necessary such that the element's bounding box exactly matches the viewport rectangle.
     */
    None("none"),

    /**
     * Forces uniform scaling. Align the <min-x> of the element's viewBox with the smallest X value of the viewport.
     * Align the <min-y> of the element's viewBox with the smallest Y value of the viewport.
     */
    XMinYMin("xMinYMin"),

    /**
     * Forces uniform scaling. Align the midpoint X value of the element's viewBox with the midpoint X value of the
     * viewport. Align the <min-y> of the element's viewBox with the smallest Y value of the viewport.
     */
    XMidYMin("xMidYMin"),

    /**
     * Forces uniform scaling. Align the <min-x>+<width> of the element's viewBox with the maximum X
     * value of the viewport. Align the <min-y> of the element's viewBox with the smallest Y value of the viewport.
     */
    XMaxYMin("xMaxYMin"),

    /**
     * Forces uniform scaling. Align the <min-x> of the element's viewBox with the smallest X value of the
     * viewport. Align the midpoint Y value of the element's viewBox with the midpoint Y value of the viewport.
     */
    XMinYMid("xMinYMid"),

    /**
     * Forces uniform scaling. Align the midpoint X value of the element's viewBox with the midpoint X value
     * of the viewport. Align the midpoint Y value of the element's viewBox with the midpoint Y value of the
     * viewport. This is the default value.
     */
    XMidYMid("xMidYMid"),

    /**
     * Forces uniform scaling. Align the <min-x>+<width> of the element's viewBox with the maximum X value of the
     * viewport. Align the midpoint Y value of the element's viewBox with the midpoint Y value of the viewport
     */
    XMaxYMid("xMaxYMid"),

    /**
     * Forces uniform scaling. Align the <min-x> of the element's viewBox with the smallest X value of the viewport.
     * Align the <min-y>+<height> of the element's viewBox with the maximum Y value of the viewport
     */
    XMinYMax("xMinYMax"),

    /**
     * Forces uniform scaling. Align the midpoint X value of the element's viewBox with the midpoint X value
     * of the viewport. Align the <min-y>+<height> of the element's viewBox with the maximum Y value of the viewport.
     *
     */
    XMidYMax("xMidYMax"),

    /**
     * Forces uniform scaling. Align the <min-x>+<width> of the element's viewBox with the maximum X value of
     * the viewport. Align the <min-y>+<height> of the element's viewBox with the maximum Y value of the viewport.
     */
    XMaxYMax("xMaxYMax"),
}

public enum class ScaleValue(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * Scales the graphic such that:
     *
     * The aspect ratio is preserved.
     * The entire viewBox is visible within the viewport.
     * The viewBox is scaled up as much as possible, while still meeting the other criteria.
     *
     * In this case, if the aspect ratio of the graphic does not match the viewport, some of the viewport will
     * extend beyond the bounds of the viewBox (i.e., the area into which the viewBox will draw will be
     * smaller than the viewport).
     */
    Meet("meet"),

    /**
     * Scales the graphic such that:
     *
     * The aspect ratio is preserved.
     * The entire viewport is covered by the viewBox.
     * The viewBox is scaled down as much as possible, while still meeting the other criteria.
     *
     * In this case, if the aspect ratio of the viewBox does not match the viewport, some of the viewBox will
     * extend beyond the bounds of the viewport (i.e., the area into which the viewBox will draw is larger
     * than the viewport).
     */
    Slice("slice"),
}
