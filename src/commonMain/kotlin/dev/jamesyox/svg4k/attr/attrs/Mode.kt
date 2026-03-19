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
 * The mode attribute defines the blending mode on the [dev.jamesyox.svg4k.tags.FeBlend] filter primitive.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Mode
)
public var mode: Mode
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["mode"] = value.svgString
    }

public enum class Mode(
    public override val svgString: String,
) : SvgAttributeType {
    /**
     * The final color is the top color, regardless of what the bottom color is. The effect is like two opaque pieces
     * of paper overlapping.
     */
    Normal("normal"),

    /**
     * The final color is the result of multiplying the top and bottom colors. A black layer leads to a
     * black final layer, and a white layer leads to no change. The effect is like two images printed on
     * transparent film overlapping.
     */
    Multiply("multiply"),

    /**
     * The final color is the result of inverting the colors, multiplying them, and inverting that value.
     * A black layer leads to no change, and a white layer leads to a white final layer. The effect is like two
     * images shining onto a projection screen.
     */
    Screen("screen"),

    /**
     * The final color is the result of multiply if the bottom color is darker, or screen if the bottom color is
     * lighter. This blend mode is equivalent to hard-light but with the layers swapped.
     */
    Overlay("overlay"),

    /**
     * The final color is composed of the darkest values of each color channel.
     */
    Darken("darken"),

    /**
     * The final color is composed of the lightest values of each color channel.
     */
    Lighten("lighten"),

    /**
     * The final color is the result of dividing the bottom color by the inverse of the top color. A black
     * foreground leads to no change. A foreground with the inverse color of the backdrop leads to a fully lit color.
     * This blend mode is similar to screen, but the foreground only needs to be as light as the inverse of the
     * backdrop to create a fully lit color.
     */
    ColorDodge("color-dodge"),

    /**
     * The final color is the result of inverting the bottom color, dividing the value by the top color, and
     * inverting that value. A white foreground leads to no change. A foreground with the inverse color of the
     * backdrop leads to a black final image. This blend mode is similar to multiply, but the foreground only needs
     * to be as dark as the inverse of the backdrop to make the final image black.
     */
    ColorBurn("color-burn"),

    /**
     * The final color is the result of multiply if the top color is darker, or screen if the top color is lighter.
     * This blend mode is equivalent to overlay but with the layers swapped. The effect is similar to shining a
     * harsh spotlight on the backdrop.
     */
    HardLight("hard-light"),

    /**
     * The final color is similar to hard-light, but softer. This blend mode behaves similar to hard-light.
     * The effect is similar to shining a diffused spotlight on the backdrop.
     */
    SoftLight("soft-light"),

    /**
     * The final color is the result of subtracting the darker of the two colors from the lighter one.
     * A black layer has no effect, while a white layer inverts the other layer's color.
     */
    Difference("difference"),

    /**
     * The final color is similar to difference, but with less contrast. As with difference,
     * a black layer has no effect, while a white layer inverts the other layer's color.
     */
    Exclusion("exclusion"),

    /**
     * The final color has the hue of the top color, while using the saturation and luminosity of the bottom color.
     */
    Hue("hue"),

    /**
     * The final color has the saturation of the top color, while using the hue and luminosity of the bottom color.
     * A pure gray backdrop, having no saturation, will have no effect.
     */
    Saturation("saturation"),

    /**
     * The final color has the hue and saturation of the top color, while using the luminosity of the bottom color.
     * The effect preserves gray levels and can be used to colorize the foreground.
     */
    Color("color"),

    /**
     * The final color has the luminosity of the top color, while using the hue and saturation of the bottom color.
     * This blend mode is equivalent to color, but with the layers swapped.
     */
    Luminosity("luminosity"),
}
