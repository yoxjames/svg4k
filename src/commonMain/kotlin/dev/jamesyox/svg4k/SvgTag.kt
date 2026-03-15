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

package dev.jamesyox.svg4k

import dev.jamesyox.svg4k.attr.AttributeContainer

public interface SvgTag :
    // Attributes available on every SVG tag or "global attributes"
    AttributeContainer.Autofocus,
    AttributeContainer.Class,
    AttributeContainer.Id,
    AttributeContainer.Lang,
    AttributeContainer.Style,
    AttributeContainer.Tabindex {
    public val tagName: String
}
