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

package dev.jamesyox.svgk.attr

public interface AttributeConsumer {
    public operator fun set(
        key: String,
        value: String,
    )

    public operator fun get(key: String): String?

    public val attributesMap: Map<String, String>
}

public operator fun AttributeConsumer.set(
    key: String,
    value: SvgAttributeType,
) {
    set(key, value.svgString)
}
