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

package dev.jamesyox.svg4k.attr

import kotlin.jvm.JvmName
import kotlin.time.Duration

public interface SvgAttributeType {
    public val svgString: String
}

public abstract class ConstantSvgAttributeType(
    override val svgString: String,
) : SvgAttributeType

public abstract class WrappedSvgAttributeType(
    svgAttributeType: SvgAttributeType,
) : SvgAttributeType by svgAttributeType

internal val Number.svgString: String get() = toString()

public abstract class WrappedNumberSvgAttributeType(
    number: Number,
) : SvgAttributeType {
    override val svgString: String = number.svgString
}

internal val Duration.svgString: String get() = toString()

public abstract class WrappedDurationSvgAttributeType(
    duration: Duration,
) : SvgAttributeType {
    override val svgString: String = duration.svgString
}

public abstract class WrappedListSvgAttributeType(
    separator: String,
    list: List<SvgAttributeType>,
) : SvgAttributeType {
    override val svgString: String = list.svgString(separator)
}

internal val Boolean.svgString: String get() = if (this) "1" else "0"

// List Functions
@JvmName("svgObjectListAttribute")
internal fun List<SvgAttributeType>.svgString(separator: String) = joinToString(separator = separator) { it.svgString }

@JvmName("svgIntegerListAttribute")
internal fun List<Number>.svgString(separator: String) = joinToString(separator = separator) { it.svgString }

@JvmName("svgStringListAttribute")
internal fun List<String>.svgString(separator: String) = joinToString(separator = separator)
