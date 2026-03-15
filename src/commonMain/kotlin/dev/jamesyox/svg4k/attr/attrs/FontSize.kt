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
import dev.jamesyox.svg4k.attr.WrappedSvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.attr.types.obj.LengthOrPercentage
import dev.jamesyox.svg4k.meta.noGet

/**
 * The font-size attribute refers to the size of the font from baseline to baseline when multiple lines of text are
 * set solid in a multiline layout environment.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.FontSize
)
public var fontSize: FontSize
    get() = noGet()
    set(value) {
        ac["font-size"] = value
    }

public sealed interface FontSize : SvgAttributeType {
    public class Absolute(
        public val value: AbsoluteSize,
    ) : FontSize, WrappedSvgAttributeType(value)

    public class Relative(
        public val value: RelativeSize,
    ) : FontSize, WrappedSvgAttributeType(value)

    public class Value(
        public val value: LengthOrPercentage,
    ) : FontSize, WrappedSvgAttributeType(value)
}

// TODO: Does this need docs?
public enum class AbsoluteSize(
    override val svgString: String,
) : SvgAttributeType {
    XXSmall("xx-small"),
    XSmall("x-small"),
    Small("small"),
    Medium("medium"),
    Large("large"),
    XLarge("x-large"),
    XXLarge("xx-large"),
    XXXLarge("xxx-large"),
}

public enum class RelativeSize(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * The font will be larger relative to the parent element's font.
     */
    Larger("larger"),

    /**
     * The font will be smaller relative to the parent element's font.
     */
    Smaller("smaller"),
}
