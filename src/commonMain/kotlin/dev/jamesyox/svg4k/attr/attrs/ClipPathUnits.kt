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

/*
 * TODO: This only applies to Graphics Elements inside of ClipPath elements. Currently this will be allowed on
 * all GraphicsElements which is more broad than we would like.
 */

/**
 * The `clipPathUnits` attribute indicates which coordinate system to use for the contents of the [ClipPath] element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.ClipPathUnits,
)
public var clipPathUnits: ClipPathUnits
    get() = noGet()
    set(value) {
        ac["clipPathUnits"] = value.svgString
    }

public enum class ClipPathUnits(
    override val svgString: String,
) : SvgAttributeType {
    UserSpaceOnUse("userSpaceOnUse"),
    ObjectBoundingBox("objectBoundingBox"),
}
