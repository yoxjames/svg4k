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

public sealed interface AttributeContainer {
    public interface Accumulate : AttributeContainer

    public interface Additive : AttributeContainer

    public interface AlignmentBaseline : AttributeContainer

    public interface Amplitude : AttributeContainer

    public interface AttributeName : AttributeContainer

    public interface AttributeType : AttributeContainer

    public interface Autofocus : AttributeContainer

    public interface Azimuth : AttributeContainer

    public interface BaseFrequency : AttributeContainer

    public interface BaselineShift : AttributeContainer

    public interface Begin : AttributeContainer

    public interface Bias : AttributeContainer

    public interface By : AttributeContainer

    public interface CalcMode : AttributeContainer

    public interface Class : AttributeContainer

    public interface ClipPath : AttributeContainer

    public interface ClipRule : AttributeContainer

    public interface ClipPathUnits : AttributeContainer

    public interface Color  : AttributeContainer// Not currently supported

    public interface ColorInterpolation : AttributeContainer

    public interface ColorInterpolationFilters : AttributeContainer

    public interface Crossorigin : AttributeContainer

    public interface Cursor : AttributeContainer

    public interface Cx : AttributeContainer

    public interface Cy : AttributeContainer

    public interface D : AttributeContainer

    public interface CustomData : AttributeContainer// Not currently supported

    public interface Decoding : AttributeContainer

    public interface DiffuseConstant : AttributeContainer

    public interface Direction : AttributeContainer

    public interface Display : AttributeContainer // TODO: Not complete

    public interface Divisor : AttributeContainer

    public interface DominantBaseline : AttributeContainer

    public interface Dur : AttributeContainer

    public interface Dx : AttributeContainer // Unused since this is element specific

    public interface Dy : AttributeContainer

    public interface EdgeMode : AttributeContainer

    public interface Elevation : AttributeContainer

    public interface End : AttributeContainer

    public interface Exponent : AttributeContainer

    public interface Fetchpriority : AttributeContainer

    public sealed interface Fill : AttributeContainer {
        public interface Presentational : Fill

        public interface Animation : Fill

        public interface Unsafe : Fill
    }

    public interface FillOpacity : AttributeContainer

    public interface FillRule : AttributeContainer

    public interface Filter : AttributeContainer

    public interface FilterUnits : AttributeContainer

    public interface FloodColor : AttributeContainer

    public interface FloodOpacity : AttributeContainer

    public interface FontFamily : AttributeContainer

    public interface FontSize : AttributeContainer

    public interface FontSizeAdjust : AttributeContainer

    public interface FontStretch : AttributeContainer // Not implemented

    public interface FontStyle : AttributeContainer

    public interface FontVariant : AttributeContainer

    public interface FontWeight : AttributeContainer

    public interface Fr : AttributeContainer

    public interface From : AttributeContainer

    public interface Fx : AttributeContainer

    public interface Fy : AttributeContainer

    public interface GlyphOrientationHorizontal : AttributeContainer // Not implemented

    public interface GlyphOrientationVertical : AttributeContainer // Not implemented

    public interface GradientTransform : AttributeContainer

    public interface GradientUnits : AttributeContainer

    public interface Height : AttributeContainer

    public interface Href : AttributeContainer

    public interface Id : AttributeContainer

    public interface ImageRendering : AttributeContainer

    public interface In : AttributeContainer

    public interface In2 : AttributeContainer

    public interface Intercept : AttributeContainer

    public interface K1 : AttributeContainer

    public interface K2 : AttributeContainer

    public interface K3 : AttributeContainer

    public interface K4 : AttributeContainer

    public interface KernelMatrix : AttributeContainer

    public interface KernelUnitLength : AttributeContainer

    public interface KeyPoints : AttributeContainer

    public interface KeySplines : AttributeContainer

    public interface KeyTimes : AttributeContainer

    public interface Lang : AttributeContainer

    public interface LengthAdjust : AttributeContainer

    public interface LetterSpacing : AttributeContainer

    public interface LightingColor : AttributeContainer

    public interface LimitingConeAngle : AttributeContainer

    public interface MarkerEnd : AttributeContainer

    public interface MarkerMid : AttributeContainer

    public interface MarkerStart : AttributeContainer

    public interface MarkerHeight : AttributeContainer

    public interface MarkerUnits : AttributeContainer

    public interface MarkerWidth : AttributeContainer

    public interface Mask : AttributeContainer

    public interface MaskType : AttributeContainer

    public interface MaskContentUnits : AttributeContainer

    public interface MaskUnits : AttributeContainer

    public interface Max : AttributeContainer

    public interface Media : AttributeContainer

    public interface Method : AttributeContainer

    public interface Min : AttributeContainer

    public interface Mode : AttributeContainer

    public interface NumOctaves : AttributeContainer

    public interface Offset : AttributeContainer

    public interface Opacity : AttributeContainer

    public interface Operator : AttributeContainer // No unsafe impl since all impls use different types

    public interface Order : AttributeContainer

    public interface Orient : AttributeContainer

    public interface Origin : AttributeContainer // Not implemented

    public interface Overflow : AttributeContainer

    public interface PaintOrder : AttributeContainer

    public interface Path : AttributeContainer

    public interface PathLength : AttributeContainer

    public interface PatternContentUnits : AttributeContainer

    public interface PatternTransform : AttributeContainer

    public interface PatternUnits : AttributeContainer

    public interface PointerEvents : AttributeContainer

    public interface Points : AttributeContainer

    public interface PointsAtX : AttributeContainer

    public interface PointsAtY : AttributeContainer

    public interface PointsAtZ : AttributeContainer

    public interface PreserveAlpha : AttributeContainer

    public interface PreserveAspectRatio : AttributeContainer

    public interface PrimitiveUnits : AttributeContainer

    public interface R : AttributeContainer

    public interface Radius : AttributeContainer

    public interface RefX : AttributeContainer

    public interface RefY : AttributeContainer

    public interface RepeatCount : AttributeContainer

    public interface RepeatDur : AttributeContainer

    public interface RequiredExtensions : AttributeContainer

    public interface RequiredFeatures : AttributeContainer // Not implemented

    public interface Restart : AttributeContainer

    public interface Result : AttributeContainer

    public interface Rotate : AttributeContainer

    public interface Rx : AttributeContainer

    public interface Ry : AttributeContainer

    public interface Scale : AttributeContainer

    public interface Seed : AttributeContainer

    public interface ShapeRendering : AttributeContainer

    public interface Side : AttributeContainer

    public interface Slope : AttributeContainer

    public interface Spacing : AttributeContainer

    public interface SpecularConstant : AttributeContainer

    public interface SpecularExponent : AttributeContainer

    public interface SpreadMethod : AttributeContainer

    public interface StartOffset : AttributeContainer

    public interface StdDeviation : AttributeContainer

    public interface StitchTiles : AttributeContainer

    public interface StopColor : AttributeContainer

    public interface StopOpacity : AttributeContainer

    public interface Stroke : AttributeContainer

    public interface StrokeDasharray : AttributeContainer

    public interface StrokeDashoffset : AttributeContainer

    public interface StrokeLinecap : AttributeContainer

    public interface StrokeLinejoin : AttributeContainer

    public interface StrokeMiterlimit : AttributeContainer

    public interface StrokeOpacity : AttributeContainer

    public interface StrokeWidth : AttributeContainer

    public interface Style : AttributeContainer

    public interface SurfaceScale : AttributeContainer

    public interface SystemLanguage : AttributeContainer

    public interface Tabindex : AttributeContainer

    public interface TableValues : AttributeContainer

    public interface Target : AttributeContainer

    public interface TargetX : AttributeContainer

    public interface TargetY : AttributeContainer

    public interface TextAnchor : AttributeContainer

    public interface TextDecoration : AttributeContainer

    public interface TextOverflow : AttributeContainer

    public interface TextRendering : AttributeContainer

    public interface TextLength : AttributeContainer

    public interface To : AttributeContainer

    public interface Transform : AttributeContainer

    public interface TransformOrigin : AttributeContainer // Not implemented

    public sealed interface Type : AttributeContainer {
        public interface FeFunc : Type

        public interface StyleAndScript : Type
    }

    public interface UnicodeBidi : AttributeContainer

    public interface Values : AttributeContainer

    public interface VectorEffect : AttributeContainer

    public interface ViewBox : AttributeContainer

    public interface Visibility : AttributeContainer

    public interface WhiteSpace : AttributeContainer

    public interface Width : AttributeContainer

    public interface WordSpacing : AttributeContainer

    public interface WritingMode : AttributeContainer

    public interface X : AttributeContainer

    public interface X1 : AttributeContainer

    public interface X2 : AttributeContainer

    public interface XChannelSelector : AttributeContainer
    public interface Xmlns : AttributeContainer

    public interface Y : AttributeContainer

    public interface Y1 : AttributeContainer

    public interface Y2 : AttributeContainer

    public interface YChannelSelector : AttributeContainer

    public interface Z : AttributeContainer

    public interface ZoomAndPan : AttributeContainer
}

public interface AllAttributeContainer :
    AttributeContainer.Accumulate,
    AttributeContainer.Additive,
    AttributeContainer.AlignmentBaseline,
    AttributeContainer.Amplitude,
    AttributeContainer.AttributeName,
    AttributeContainer.AttributeType,
    AttributeContainer.Autofocus,
    AttributeContainer.Azimuth,
    AttributeContainer.BaseFrequency,
    AttributeContainer.BaselineShift,
    AttributeContainer.Begin,
    AttributeContainer.Bias,
    AttributeContainer.By,
    AttributeContainer.CalcMode,
    AttributeContainer.Class,
    AttributeContainer.ClipPath,
    AttributeContainer.ClipRule,
    AttributeContainer.ClipPathUnits,
    AttributeContainer.Color,
    AttributeContainer.ColorInterpolation,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.Crossorigin,
    AttributeContainer.Cursor,
    AttributeContainer.Cx,
    AttributeContainer.Cy,
    AttributeContainer.D,
    AttributeContainer.CustomData,
    AttributeContainer.Decoding,
    AttributeContainer.DiffuseConstant,
    AttributeContainer.Direction,
    AttributeContainer.Display,
    AttributeContainer.Divisor,
    AttributeContainer.DominantBaseline,
    AttributeContainer.Dur,
    AttributeContainer.Dx,
    AttributeContainer.Dy,
    AttributeContainer.EdgeMode,
    AttributeContainer.Elevation,
    AttributeContainer.End,
    AttributeContainer.Exponent,
    AttributeContainer.Fetchpriority,
    AttributeContainer.Fill.Unsafe,
    AttributeContainer.FillOpacity,
    AttributeContainer.FillRule,
    AttributeContainer.Filter,
    AttributeContainer.FilterUnits,
    AttributeContainer.FloodColor,
    AttributeContainer.FloodOpacity,
    AttributeContainer.FontFamily,
    AttributeContainer.FontSize,
    AttributeContainer.FontSizeAdjust,
    AttributeContainer.FontStretch,
    AttributeContainer.FontStyle,
    AttributeContainer.FontVariant,
    AttributeContainer.FontWeight,
    AttributeContainer.Fr,
    AttributeContainer.From,
    AttributeContainer.Fx,
    AttributeContainer.Fy,
    AttributeContainer.GlyphOrientationHorizontal,
    AttributeContainer.GlyphOrientationVertical,
    AttributeContainer.GradientTransform,
    AttributeContainer.GradientUnits,
    AttributeContainer.Height,
    AttributeContainer.Href,
    AttributeContainer.Id,
    AttributeContainer.ImageRendering,
    AttributeContainer.In,
    AttributeContainer.In2,
    AttributeContainer.Intercept,
    AttributeContainer.K1,
    AttributeContainer.K2,
    AttributeContainer.K3,
    AttributeContainer.K4,
    AttributeContainer.KernelMatrix,
    AttributeContainer.KernelUnitLength,
    AttributeContainer.KeyPoints,
    AttributeContainer.KeySplines,
    AttributeContainer.KeyTimes,
    AttributeContainer.Lang,
    AttributeContainer.LengthAdjust,
    AttributeContainer.LetterSpacing,
    AttributeContainer.LightingColor,
    AttributeContainer.LimitingConeAngle,
    AttributeContainer.MarkerEnd,
    AttributeContainer.MarkerMid,
    AttributeContainer.MarkerStart,
    AttributeContainer.MarkerHeight,
    AttributeContainer.MarkerUnits,
    AttributeContainer.MarkerWidth,
    AttributeContainer.Mask,
    AttributeContainer.MaskType,
    AttributeContainer.MaskContentUnits,
    AttributeContainer.MaskUnits,
    AttributeContainer.Max,
    AttributeContainer.Media,
    AttributeContainer.Method,
    AttributeContainer.Min,
    AttributeContainer.Mode,
    AttributeContainer.NumOctaves,
    AttributeContainer.Offset,
    AttributeContainer.Opacity,
    AttributeContainer.Operator,
    AttributeContainer.Order,
    AttributeContainer.Orient,
    AttributeContainer.Origin,
    AttributeContainer.Overflow,
    AttributeContainer.PaintOrder,
    AttributeContainer.Path,
    AttributeContainer.PathLength,
    AttributeContainer.PatternContentUnits,
    AttributeContainer.PatternTransform,
    AttributeContainer.PatternUnits,
    AttributeContainer.PointerEvents,
    AttributeContainer.Points,
    AttributeContainer.PointsAtX,
    AttributeContainer.PointsAtY,
    AttributeContainer.PointsAtZ,
    AttributeContainer.PreserveAlpha,
    AttributeContainer.PreserveAspectRatio,
    AttributeContainer.PrimitiveUnits,
    AttributeContainer.R,
    AttributeContainer.Radius,
    AttributeContainer.RefX,
    AttributeContainer.RefY,
    AttributeContainer.RepeatCount,
    AttributeContainer.RepeatDur,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.RequiredFeatures,
    AttributeContainer.Restart,
    AttributeContainer.Result,
    AttributeContainer.Rotate,
    AttributeContainer.Rx,
    AttributeContainer.Ry,
    AttributeContainer.Scale,
    AttributeContainer.Seed,
    AttributeContainer.ShapeRendering,
    AttributeContainer.Side,
    AttributeContainer.Slope,
    AttributeContainer.Spacing,
    AttributeContainer.SpecularConstant,
    AttributeContainer.SpecularExponent,
    AttributeContainer.SpreadMethod,
    AttributeContainer.StartOffset,
    AttributeContainer.StdDeviation,
    AttributeContainer.StitchTiles,
    AttributeContainer.StopColor,
    AttributeContainer.StopOpacity,
    AttributeContainer.Stroke,
    AttributeContainer.StrokeDasharray,
    AttributeContainer.StrokeDashoffset,
    AttributeContainer.StrokeLinecap,
    AttributeContainer.StrokeLinejoin,
    AttributeContainer.StrokeMiterlimit,
    AttributeContainer.StrokeOpacity,
    AttributeContainer.StrokeWidth,
    AttributeContainer.Style,
    AttributeContainer.SurfaceScale,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Tabindex,
    AttributeContainer.TableValues,
    AttributeContainer.Target,
    AttributeContainer.TargetX,
    AttributeContainer.TargetY,
    AttributeContainer.TextAnchor,
    AttributeContainer.TextDecoration,
    AttributeContainer.TextOverflow,
    AttributeContainer.TextRendering,
    AttributeContainer.TextLength,
    AttributeContainer.To,
    AttributeContainer.Transform,
    AttributeContainer.TransformOrigin,
    AttributeContainer.Type.FeFunc,
    AttributeContainer.Type.StyleAndScript,
    AttributeContainer.UnicodeBidi,
    AttributeContainer.Values,
    AttributeContainer.VectorEffect,
    AttributeContainer.ViewBox,
    AttributeContainer.Visibility,
    AttributeContainer.WhiteSpace,
    AttributeContainer.Width,
    AttributeContainer.WordSpacing,
    AttributeContainer.WritingMode,
    AttributeContainer.X,
    AttributeContainer.X1,
    AttributeContainer.X2,
    AttributeContainer.XChannelSelector,
    AttributeContainer.Y,
    AttributeContainer.Y1,
    AttributeContainer.Y2,
    AttributeContainer.YChannelSelector,
    AttributeContainer.Xmlns,
    AttributeContainer.Z,
    AttributeContainer.ZoomAndPan