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

package dev.jamesyox.svg4k.tags.categories.container

// https://developer.mozilla.org/en-US/docs/Web/SVG/Reference/Element

public object ElementContainer {
    public interface A

    public interface Animate

    public interface AnimateMotion

    public interface AnimateTransform

    public interface Circle

    public interface ClipPath

    public interface Defs

    public interface Desc

    public interface Ellipse

    public interface FeBlend

    public interface FeColorMatrix

    public interface FeComponentTransfer

    public interface FeComposite

    public interface FeConvolveMatrix

    public interface FeDiffuseLighting

    public interface FeDisplacementMap

    public interface FeDistantLight

    public interface FeDropShadow

    public interface FeFlood

    public interface FeFuncA

    public interface FeFuncB

    public interface FeFuncG

    public interface FeFuncR

    public interface FeGaussianBlur

    public interface FeImage

    public interface FeMerge

    public interface FeMergeNode

    public interface FeMorphology

    public interface FeOffset

    public interface FePointLight

    public interface FeSpecularLighting

    public interface FeSpotLight

    public interface FeTile

    public interface FeTurbulence

    public interface Filter

    public interface ForeignObject

    public interface G

    public interface Image

    public interface Line

    public interface LinearGradient

    public interface Marker

    public interface Mask

    public interface Metadata

    public interface Mpath

    public interface Path

    public interface Pattern

    public interface Polygon

    public interface Polyline

    public interface RadialGradient

    public interface Rect

    public interface Script

    public interface Set

    public interface Stop

    public interface Style

    public interface Svg

    public interface Switch

    public interface Symbol

    public interface Text

    public interface TextPath

    public interface Title

    public interface Tspan

    public interface Use

    public interface View
}

public interface AllElementContainer :
    ElementContainer.A,
    ElementContainer.Animate,
    ElementContainer.AnimateMotion,
    ElementContainer.AnimateTransform,
    ElementContainer.Circle,
    ElementContainer.ClipPath,
    ElementContainer.Defs,
    ElementContainer.Desc,
    ElementContainer.Ellipse,
    ElementContainer.FeBlend,
    ElementContainer.FeColorMatrix,
    ElementContainer.FeComponentTransfer,
    ElementContainer.FeComposite,
    ElementContainer.FeConvolveMatrix,
    ElementContainer.FeDiffuseLighting,
    ElementContainer.FeDisplacementMap,
    ElementContainer.FeDistantLight,
    ElementContainer.FeDropShadow,
    ElementContainer.FeFlood,
    ElementContainer.FeFuncA,
    ElementContainer.FeFuncB,
    ElementContainer.FeFuncG,
    ElementContainer.FeFuncR,
    ElementContainer.FeGaussianBlur,
    ElementContainer.FeImage,
    ElementContainer.FeMerge,
    ElementContainer.FeMergeNode,
    ElementContainer.FeMorphology,
    ElementContainer.FeOffset,
    ElementContainer.FePointLight,
    ElementContainer.FeSpecularLighting,
    ElementContainer.FeSpotLight,
    ElementContainer.FeTile,
    ElementContainer.FeTurbulence,
    ElementContainer.Filter,
    ElementContainer.ForeignObject,
    ElementContainer.G,
    ElementContainer.Image,
    ElementContainer.Line,
    ElementContainer.LinearGradient,
    ElementContainer.Marker,
    ElementContainer.Mask,
    ElementContainer.Metadata,
    ElementContainer.Mpath,
    ElementContainer.Path,
    ElementContainer.Pattern,
    ElementContainer.Polygon,
    ElementContainer.Polyline,
    ElementContainer.RadialGradient,
    ElementContainer.Rect,
    ElementContainer.Script,
    ElementContainer.Set,
    ElementContainer.Stop,
    ElementContainer.Style,
    ElementContainer.Svg,
    ElementContainer.Switch,
    ElementContainer.Symbol,
    ElementContainer.Text,
    ElementContainer.TextPath,
    ElementContainer.Title,
    ElementContainer.Tspan,
    ElementContainer.Use,
    ElementContainer.View

public interface AnimationElementContainer :
    ElementContainer.Animate,
    ElementContainer.AnimateMotion,
    ElementContainer.AnimateTransform,
    ElementContainer.Mpath,
    ElementContainer.Set

public interface BasicShapeElementContainer :
    ElementContainer.Circle,
    ElementContainer.Ellipse,
    ElementContainer.Line,
    ElementContainer.Polygon,
    ElementContainer.Polyline,
    ElementContainer.Rect

public interface ContainerElementContainer :
    ElementContainer.A,
    ElementContainer.Defs,
    ElementContainer.G,
    ElementContainer.Marker,
    ElementContainer.Mask,
    ElementContainer.Pattern,
    ElementContainer.Svg,
    ElementContainer.Switch,
    ElementContainer.Symbol

public interface DescriptiveElementContainer :
    ElementContainer.Desc,
    ElementContainer.Metadata,
    ElementContainer.Title

public interface FilterPrimitiveElementContainer :
    ElementContainer.FeBlend,
    ElementContainer.FeColorMatrix,
    ElementContainer.FeComponentTransfer,
    ElementContainer.FeComposite,
    ElementContainer.FeConvolveMatrix,
    ElementContainer.FeDiffuseLighting,
    ElementContainer.FeDisplacementMap,
    ElementContainer.FeDropShadow,
    ElementContainer.FeFlood,
    ElementContainer.FeFuncA,
    ElementContainer.FeFuncB,
    ElementContainer.FeFuncG,
    ElementContainer.FeFuncR,
    ElementContainer.FeGaussianBlur,
    ElementContainer.FeImage,
    ElementContainer.FeMerge,
    ElementContainer.FeMergeNode,
    ElementContainer.FeMorphology,
    ElementContainer.FeOffset,
    ElementContainer.FeSpecularLighting,
    ElementContainer.FeTile,
    ElementContainer.FeTurbulence

public interface GradientElementContainer :
    ElementContainer.LinearGradient,
    ElementContainer.RadialGradient,
    ElementContainer.Stop

public interface GraphicsElementContainer :
    ElementContainer.Circle,
    ElementContainer.Ellipse,
    ElementContainer.Image,
    ElementContainer.Line,
    ElementContainer.Path,
    ElementContainer.Polygon,
    ElementContainer.Polyline,
    ElementContainer.Rect,
    ElementContainer.Text,
    ElementContainer.Use

public interface GraphicsReferencingElementContainer : ElementContainer.Use

public interface LightSourceElementContainer :
    ElementContainer.FeDistantLight,
    ElementContainer.FePointLight,
    ElementContainer.FeSpotLight

public interface NeverRenderedElementContainer :
    ElementContainer.ClipPath,
    ElementContainer.Defs,
    ElementContainer.LinearGradient,
    ElementContainer.Marker,
    ElementContainer.Mask,
    ElementContainer.Metadata,
    ElementContainer.Pattern,
    ElementContainer.RadialGradient,
    ElementContainer.Script,
    ElementContainer.Style,
    ElementContainer.Symbol,
    ElementContainer.Title

public interface PaintServerElementContainer :
    ElementContainer.LinearGradient,
    ElementContainer.Pattern,
    ElementContainer.RadialGradient

public interface RenderableElementContainer :
    ElementContainer.A,
    ElementContainer.Circle,
    ElementContainer.Ellipse,
    ElementContainer.ForeignObject,
    ElementContainer.G,
    ElementContainer.Image,
    ElementContainer.Line,
    ElementContainer.Path,
    ElementContainer.Polygon,
    ElementContainer.Polyline,
    ElementContainer.Rect,
    ElementContainer.Svg,
    ElementContainer.Switch,
    ElementContainer.Symbol,
    ElementContainer.Text,
    ElementContainer.TextPath,
    ElementContainer.Tspan,
    ElementContainer.Use

public interface ShapeElementContainer :
    ElementContainer.Circle,
    ElementContainer.Ellipse,
    ElementContainer.Line,
    ElementContainer.Path,
    ElementContainer.Polygon,
    ElementContainer.Polyline,
    ElementContainer.Rect

public interface StructuralElementContainer :
    ElementContainer.Defs,
    ElementContainer.G,
    ElementContainer.Svg,
    ElementContainer.Symbol,
    ElementContainer.Use

public interface TextContentElementContainer :
    ElementContainer.TextPath,
    ElementContainer.Text,
    ElementContainer.Tspan

public interface TextContentChildElementContainer :
    ElementContainer.TextPath,
    ElementContainer.Tspan
