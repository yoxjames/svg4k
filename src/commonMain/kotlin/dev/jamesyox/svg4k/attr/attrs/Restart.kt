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
import dev.jamesyox.svg4k.attr.set
import dev.jamesyox.svg4k.meta.noGet
import dev.jamesyox.svg4k.util.SetOnlyPropertyError

/**
 * The `restart` attribute specifies whether or not an animation can restart.
 */
context(
    ac: AttributeConsumer,
    _: AttributeContainer.Restart
)
public var restart: RepeatDur
    @Deprecated(SetOnlyPropertyError, level = DeprecationLevel.ERROR)
    get() = noGet()
    set(value) {
        ac["restart"] = value
    }

public enum class Restart(
    override val svgString: String,
) : SvgAttributeType {
    /**
     * This value indicates that the animation can be restarted at any time.
     */
    Always("always"),

    /**
     * This value indicates that the animation can only be restarted when it is not active (i.e., after the active
     * end). Attempts to restart the animation during its active duration are ignored.
     */
    WhenNotActive("whenNotActive"),

    /**
     * This value indicates that the animation cannot be restarted.
     */
    Never("never"),
}
