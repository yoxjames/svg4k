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
import dev.jamesyox.svg4k.attr.WrappedListSvgAttributeType
import dev.jamesyox.svg4k.attr.WrappedSvgAttributeType
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError
import dev.jamesyox.svg4k.attr.types.obj.Url as UrlType

/**
 * The `cursor` attribute specifies the mouse cursor displayed when the mouse pointer is over an element.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Cursor
)
public var cursor: Cursor
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["cursor"] = value
    }

// TODO: Poor Docs
public sealed interface Cursor : SvgAttributeType {
    public data object Inherit : Cursor, ConstantSvgAttributeType("inherit")

    public class Specify(
        cursors: List<CursorType>,
    ) : WrappedListSvgAttributeType(separator = " ", cursors),
        Cursor

    public fun Specify(cursor: CursorType): Specify = Specify(listOf(cursor))
}

// TODO: Poor Docs
// TODO: Possibly incomplete typing?
public sealed interface CursorType : SvgAttributeType {
    public class Url(
        public val value: UrlType,
    ) : WrappedSvgAttributeType(value),
        CursorType

    public data object Auto : CursorType, ConstantSvgAttributeType("auto")

    public data object Crosshair : CursorType, ConstantSvgAttributeType("crosshair")

    public data object Default : CursorType, ConstantSvgAttributeType("default")

    public data object Pointer : CursorType, ConstantSvgAttributeType("pointer")

    public data object Move : CursorType, ConstantSvgAttributeType("move")

    public data object EResize : CursorType, ConstantSvgAttributeType("e-resize")

    public data object NeResize : CursorType, ConstantSvgAttributeType("ne-resize")

    public data object NwResize : CursorType, ConstantSvgAttributeType("nw-resize")

    public data object NResize : CursorType, ConstantSvgAttributeType("n-resize")

    public data object SeResize : CursorType, ConstantSvgAttributeType("se-resize")

    public data object SwResize : CursorType, ConstantSvgAttributeType("sw-resize")

    public data object SResize : CursorType, ConstantSvgAttributeType("s-resize")

    public data object WResize : CursorType, ConstantSvgAttributeType("w-resize")

    public data object Text : CursorType, ConstantSvgAttributeType("text")

    public data object Wait : CursorType, ConstantSvgAttributeType("wait")

    public data object Help : CursorType, ConstantSvgAttributeType("help")
}
