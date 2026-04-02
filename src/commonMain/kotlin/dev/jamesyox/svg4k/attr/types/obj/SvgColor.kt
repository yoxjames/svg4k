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

package dev.jamesyox.svg4k.attr.types.obj

import dev.jamesyox.svg4k.attr.ConstantSvgAttributeType
import dev.jamesyox.svg4k.attr.SvgAttributeType

public interface SvgColor : SvgAttributeType {
    public class RGB(red: Int, green: Int, blue: Int): SvgColor {
        public override val svgString: String = "rgb($red,$green,$blue)"
    }
    public class Hex(value: Int): SvgColor {
        public override val svgString: String = value.toHexString(
            HexFormat {
                upperCase = false
                number {
                    prefix = "#"
                    removeLeadingZeros = true
                }
            }
        )
    }
    public data object AliceBlue : SvgColor, ConstantSvgAttributeType("aliceblue")
    public data object AntiqueWhite	: SvgColor, ConstantSvgAttributeType("antiquewhite")
    public data object Aqua	: SvgColor, ConstantSvgAttributeType("aqua")
    public data object Aquamarine : SvgColor, ConstantSvgAttributeType("aquamarine")
    public data object Azure : SvgColor, ConstantSvgAttributeType("azure")
    public data object Beige : SvgColor, ConstantSvgAttributeType("beige")
    public data object Bisque : SvgColor, ConstantSvgAttributeType("bisque")
    public data object Black : SvgColor, ConstantSvgAttributeType("black")
    public data object BlanchedAlmond : SvgColor, ConstantSvgAttributeType("blanchedalmond")
    public data object Blue : SvgColor, ConstantSvgAttributeType("blue")
    public data object BlueViolet : SvgColor, ConstantSvgAttributeType("blueviolet")
    public data object Brown : SvgColor, ConstantSvgAttributeType("brown")
    public data object Burlywood : SvgColor, ConstantSvgAttributeType("burlywood")
    public data object CadetBlue : SvgColor, ConstantSvgAttributeType("cadetblue")
    public data object Chartreuse : SvgColor, ConstantSvgAttributeType("chartreuse")
    public data object Chocolate : SvgColor, ConstantSvgAttributeType("chocolate")
    public data object Coral : SvgColor, ConstantSvgAttributeType("coral")
    public data object CornflowerBlue : SvgColor, ConstantSvgAttributeType("cornflowerblue")
    public data object Cornsilk	: SvgColor, ConstantSvgAttributeType("cornsilk")
    public data object Crimson : SvgColor, ConstantSvgAttributeType("crimson")
    public data object Cyan	: SvgColor, ConstantSvgAttributeType("cyan")
    public data object DarkBlue	: SvgColor, ConstantSvgAttributeType("darkblue")
    public data object DarkCyan	: SvgColor, ConstantSvgAttributeType("darkcyan")
    public data object DarkGoldenrod : SvgColor, ConstantSvgAttributeType("darkgoldenrod")
    public data object DarkGray	: SvgColor, ConstantSvgAttributeType("darkgray")
    public data object DarkGreen : SvgColor, ConstantSvgAttributeType("darkgreen")
    public data object DarkGrey : SvgColor, ConstantSvgAttributeType("darkgrey")
    public data object DarkKhaki : SvgColor, ConstantSvgAttributeType("darkkhaki")
    public data object DarkMagenta : SvgColor, ConstantSvgAttributeType("darkmagenta")
    public data object DarkOlivegreen : SvgColor, ConstantSvgAttributeType("darkolivegreen")
    public data object DarkOrange : SvgColor, ConstantSvgAttributeType("darkorange")
    public data object DarkOrchid : SvgColor, ConstantSvgAttributeType("darkorchid")
    public data object DarkRed : SvgColor, ConstantSvgAttributeType("darkred")
    public data object DarkSalmon : SvgColor, ConstantSvgAttributeType("darksalmon")
    public data object DarkSeagreen : SvgColor, ConstantSvgAttributeType("darkseagreen")
    public data object DarkSlateBlue : SvgColor, ConstantSvgAttributeType("darkslateblue")
    public data object DarkSlateGray : SvgColor, ConstantSvgAttributeType("darkslategray")
    public data object DarkSlateGrey : SvgColor, ConstantSvgAttributeType("darkslategrey")
    public data object DarkTurquoise : SvgColor, ConstantSvgAttributeType("darkturquoise")
    public data object DarkViolet : SvgColor, ConstantSvgAttributeType("darkviolet")
    public data object DeepPink : SvgColor, ConstantSvgAttributeType("deeppink")
    public data object DeepSkyBlue : SvgColor, ConstantSvgAttributeType("deepskyblue")
    public data object DimGray : SvgColor, ConstantSvgAttributeType("dimgray")
    public data object DimGrey : SvgColor, ConstantSvgAttributeType("dimgrey")
    public data object DodgerBlue : SvgColor, ConstantSvgAttributeType("dodgerblue")
    public data object Firebrick : SvgColor, ConstantSvgAttributeType("firebrick")
    public data object FloralWhite : SvgColor, ConstantSvgAttributeType("floralwhite")
    public data object ForestGreen : SvgColor, ConstantSvgAttributeType("forestgreen")
    public data object Fuchsia : SvgColor, ConstantSvgAttributeType("fuchsia")
    public data object Gainsboro : SvgColor, ConstantSvgAttributeType("gainsboro")
    public data object GhostWhite : SvgColor, ConstantSvgAttributeType("ghostwhite")
    public data object Gold : SvgColor, ConstantSvgAttributeType("gold")
    public data object Goldenrod : SvgColor, ConstantSvgAttributeType("goldenrod")
    public data object Gray	: SvgColor, ConstantSvgAttributeType("gray")
    public data object Grey : SvgColor, ConstantSvgAttributeType("grey")
    public data object Green : SvgColor, ConstantSvgAttributeType("green")
    public data object GreenYellow : SvgColor, ConstantSvgAttributeType("greenyellow")
    public data object Honeydew : SvgColor, ConstantSvgAttributeType("honeydew")
    public data object HotPink : SvgColor, ConstantSvgAttributeType("hotpink")
    public data object IndianRed : SvgColor, ConstantSvgAttributeType("indianred")
    public data object Indigo : SvgColor, ConstantSvgAttributeType("indigo")
    public data object Ivory : SvgColor, ConstantSvgAttributeType("ivory")
    public data object Khaki : SvgColor, ConstantSvgAttributeType("khaki")
    public data object Lavender : SvgColor, ConstantSvgAttributeType("lavender")
    public data object LavenderBlush : SvgColor, ConstantSvgAttributeType("lavenderblush")
    public data object LawnGreen : SvgColor, ConstantSvgAttributeType("lawngreen")
    public data object LemonChiffon : SvgColor, ConstantSvgAttributeType("lemonchiffon")
    public data object LightBlue : SvgColor, ConstantSvgAttributeType("lightblue")
    public data object LightCoral : SvgColor, ConstantSvgAttributeType("lightcoral")
    public data object LightCyan : SvgColor, ConstantSvgAttributeType("lightcyan")
    public data object LightGoldenrodYellow : SvgColor, ConstantSvgAttributeType("lightgoldenrodyellow")
    public data object LightGray : SvgColor, ConstantSvgAttributeType("lightgray")
    public data object LightGreen : SvgColor, ConstantSvgAttributeType("lightgreen")
    public data object LightGrey : SvgColor, ConstantSvgAttributeType("lightgrey")
    public data object LightPink : SvgColor, ConstantSvgAttributeType("lightpink")
    public data object LightSalmon : SvgColor, ConstantSvgAttributeType("lightsalmon")
    public data object LightSeagreen : SvgColor, ConstantSvgAttributeType("lightseagreen")
    public data object LightSkyBlue : SvgColor, ConstantSvgAttributeType("lightskyblue")
    public data object LightSlateGray : SvgColor, ConstantSvgAttributeType("lightslategray")
    public data object LightSlateGrey : SvgColor, ConstantSvgAttributeType("lightslategrey")
    public data object LightSteelBlue : SvgColor, ConstantSvgAttributeType("lightsteelblue")
    public data object LightYellow : SvgColor, ConstantSvgAttributeType("lightyellow")
    public data object Lime : SvgColor, ConstantSvgAttributeType("lime")
    public data object Limegreen : SvgColor, ConstantSvgAttributeType("limegreen")
    public data object Linen : SvgColor, ConstantSvgAttributeType("linen")
    public data object Magenta : SvgColor, ConstantSvgAttributeType("magenta")
    public data object Maroon : SvgColor, ConstantSvgAttributeType("maroon")
    public data object MediumAquamarine : SvgColor, ConstantSvgAttributeType("mediumaquamarine")
    public data object MediumBlue : SvgColor, ConstantSvgAttributeType("mediumblue")
    public data object MediumOrchid	: SvgColor, ConstantSvgAttributeType("mediumorchid")
    public data object MediumPurple	: SvgColor, ConstantSvgAttributeType("mediumpurple")
    public data object MediumSeagreen : SvgColor, ConstantSvgAttributeType("mediumseagreen")
    public data object MediumSlateBlue : SvgColor, ConstantSvgAttributeType("mediumslateblue")
    public data object MediumSpringGreen : SvgColor, ConstantSvgAttributeType("mediumspringgreen")
    public data object MediumTurquoise : SvgColor, ConstantSvgAttributeType("mediumturquoise")
    public data object MediumVioletRed : SvgColor, ConstantSvgAttributeType("mediumvioletred")
    public data object MidnightBlue : SvgColor, ConstantSvgAttributeType("midnightblue")
    public data object MintCream : SvgColor, ConstantSvgAttributeType("mintcream")
    public data object MistyRose : SvgColor, ConstantSvgAttributeType("mistyrose")
    public data object Moccasin : SvgColor, ConstantSvgAttributeType("moccasin")
    public data object NavajoWhite : SvgColor, ConstantSvgAttributeType("navajowhite")
    public data object Navy : SvgColor, ConstantSvgAttributeType("navy")
    public data object OldLace : SvgColor, ConstantSvgAttributeType("oldlace")
    public data object Olive : SvgColor, ConstantSvgAttributeType("olive")
    public data object OliveDrab : SvgColor, ConstantSvgAttributeType("olivedrab")
    public data object Orange : SvgColor, ConstantSvgAttributeType("orange")
    public data object OrangeRed : SvgColor, ConstantSvgAttributeType("orangered")
    public data object Orchid : SvgColor, ConstantSvgAttributeType("orchid")
    public data object PaleGoldenrod : SvgColor, ConstantSvgAttributeType("palegoldenrod")
    public data object PaleGreen : SvgColor, ConstantSvgAttributeType("palegreen")
    public data object PaleTurquoise : SvgColor, ConstantSvgAttributeType("paleturquoise")
    public data object PaleVioletRed : SvgColor, ConstantSvgAttributeType("palevioletred")
    public data object PapayaWhip : SvgColor, ConstantSvgAttributeType("papayawhip")
    public data object PeachPuff : SvgColor, ConstantSvgAttributeType("peachpuff")
    public data object Peru : SvgColor, ConstantSvgAttributeType("peru")
    public data object Pink : SvgColor, ConstantSvgAttributeType("pink")
    public data object Plum : SvgColor, ConstantSvgAttributeType("plum")
    public data object PowderBlue : SvgColor, ConstantSvgAttributeType("powderblue")
    public data object Purple : SvgColor, ConstantSvgAttributeType("purple")
    public data object Red : SvgColor, ConstantSvgAttributeType("red")
    public data object RosyBrown : SvgColor, ConstantSvgAttributeType("rosybrown")
    public data object RoyalBlue : SvgColor, ConstantSvgAttributeType("royalblue")
    public data object SaddleBrown : SvgColor, ConstantSvgAttributeType("saddlebrown")
    public data object Salmon : SvgColor, ConstantSvgAttributeType("salmon")
    public data object SandyBrown : SvgColor, ConstantSvgAttributeType("sandybrown")
    public data object Seagreen : SvgColor, ConstantSvgAttributeType("seagreen")
    public data object Seashell : SvgColor, ConstantSvgAttributeType("seashell")
    public data object Sienna : SvgColor, ConstantSvgAttributeType("sienna")
    public data object Silver : SvgColor, ConstantSvgAttributeType("silver")
    public data object SkyBlue : SvgColor, ConstantSvgAttributeType("skyblue")
    public data object SlateBlue : SvgColor, ConstantSvgAttributeType("slateblue")
    public data object SlateGray : SvgColor, ConstantSvgAttributeType("slategray")
    public data object SlateGrey : SvgColor, ConstantSvgAttributeType("slategrey")
    public data object Snow : SvgColor, ConstantSvgAttributeType("snow")
    public data object SpringGreen : SvgColor, ConstantSvgAttributeType("springgreen")
    public data object SteelBlue : SvgColor, ConstantSvgAttributeType("steelblue")
    public data object Tan : SvgColor, ConstantSvgAttributeType("tan")
    public data object Teal : SvgColor, ConstantSvgAttributeType("teal")
    public data object Thistle : SvgColor, ConstantSvgAttributeType("thistle")
    public data object Tomato : SvgColor, ConstantSvgAttributeType("tomato")
    public data object Turquoise : SvgColor, ConstantSvgAttributeType("turquoise")
    public data object Violet : SvgColor, ConstantSvgAttributeType("violet")
    public data object Wheat : SvgColor, ConstantSvgAttributeType("wheat")
    public data object White : SvgColor, ConstantSvgAttributeType("white")
    public data object WhiteSmoke : SvgColor, ConstantSvgAttributeType("whitesmoke")
    public data object Yellow : SvgColor, ConstantSvgAttributeType("yellow")
    public data object YellowGreen : SvgColor, ConstantSvgAttributeType("yellowgreen")
}