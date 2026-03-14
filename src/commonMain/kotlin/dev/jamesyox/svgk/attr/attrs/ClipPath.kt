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
import dev.jamesyox.svgk.attr.ConstantSvgAttributeType
import dev.jamesyox.svgk.attr.SvgAttributeType
import dev.jamesyox.svgk.attr.WrappedSvgAttributeType
import dev.jamesyox.svgk.meta.noGet
import dev.jamesyox.svgk.attr.types.obj.BasicShape as BasicShapeType
import dev.jamesyox.svgk.attr.types.obj.Url as UrlType

/**
 * The `clip-path` presentation attribute defines or associates a clipping path with the element it is related to.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.ClipPath,
)
public var clipPath: ClipPath
    get() = noGet()
    set(value) {
        ac["clip-path"] = value.svgString
    }

context(
    _: AttributeContainer.ClipPath,
)
public fun url(value: String): ClipPath.Url {
    return ClipPath.Url(UrlType(value))
}

public sealed interface ClipPath : SvgAttributeType {
    public class Url(
        public val value: UrlType,
    ) : WrappedSvgAttributeType(value),
        ClipPath


    // TODO: Incomplete Type
    public class BasicShape(
        public val value: BasicShapeType,
    ) : WrappedSvgAttributeType(value)

    public data object None : ConstantSvgAttributeType("none")
}
