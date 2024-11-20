package az.lahza.shimmer_animation_compose.core.implementations

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.IntSize
import az.lahza.shimmer_animation_compose.core.interfaces.ShimmerEffectBrushProvider
import az.lahza.shimmer_animation_compose.models.enums.ShimmerEffectType

/**
 * Implementation of the [ShimmerEffectBrushProvider] interface that provides the appropriate
 * shimmer brush based on the specified effect type.
 * Supports both linear and radial shimmer effects with customizable color transitions.
 *
 * @see ShimmerEffectBrushProvider
 *
 */
class ShimmerEffectBrushProviderImpl : ShimmerEffectBrushProvider {

    /**
     * Provides a shimmer effect brush based on the given effect type and parameters.
     * This function creates a linear gradient or radial gradient brush depending on the [effectType].
     *
     * @param effectType The type of shimmer effect (either [ShimmerEffectType.LINEAR] or [ShimmerEffectType.RADIAL]).
     * @param adjustedColors A list of colors to be used in the gradient, typically a color palette for the shimmer effect.
     * @param startOffsetX The starting X offset (relative to the size) for the linear gradient.
     * @param startOffsetY The starting Y offset (relative to the size) for the linear gradient.
     * @param size The size of the area where the shimmer effect will be applied. This is used to calculate the gradient span.
     * @return A [Brush] representing the desired shimmer effect, either a linear or radial gradient.
     *
     * @see ShimmerEffectType
     * @see Brush
     * @see createLinearGradientBrush
     * @see createRadialGradientBrush
     */
    override fun provideBrush(
        effectType: ShimmerEffectType,
        adjustedColors: List<Color>,
        startOffsetX: Float,
        startOffsetY: Float,
        size: IntSize
    ): Brush = when (effectType) {
        ShimmerEffectType.LINEAR -> createLinearGradientBrush(
            adjustedColors,
            startOffsetX,
            startOffsetY,
            size
        )

        ShimmerEffectType.RADIAL -> createRadialGradientBrush(adjustedColors, size)
    }

    /**
     * Creates a linear gradient brush based on the provided colors and offsets.
     * This function generates a linear gradient that spans from the specified [startOffsetX],
     * [startOffsetY] to the opposite end of the given [size].
     *
     * @param colors A list of colors to be used in the linear gradient.
     * @param startOffsetX The starting X offset (relative to the size) for the linear gradient.
     * @param startOffsetY The starting Y offset (relative to the size) for the linear gradient.
     * @param size The size of the area where the linear gradient should be applied.
     * @return A [Brush] object representing a linear gradient based on the provided parameters.
     */
    private fun createLinearGradientBrush(
        colors: List<Color>,
        startOffsetX: Float,
        startOffsetY: Float,
        size: IntSize
    ): Brush {
        // Start and end points of the gradient, calculated based on the size and offsets.
        val start = Offset(startOffsetX * size.width, startOffsetY)
        val end = Offset((startOffsetX - 1) * size.width, size.height.toFloat())

        // Return a linear gradient brush with the provided colors and offsets.
        return Brush.linearGradient(colors = colors, start = start, end = end)
    }

    /**
     * Creates a radial gradient brush based on the provided colors and size.
     * If the calculated radius is positive, a radial gradient is used.
     * Otherwise, a fallback linear gradient is created.
     *
     * @param colors A list of colors to be used in the radial gradient.
     * @param size The size of the area where the gradient should be applied.
     * @return A [Brush] object representing either a radial or linear gradient.
     */
    private fun createRadialGradientBrush(colors: List<Color>, size: IntSize): Brush {
        val radius = calculateRadius(size)

        // If the radius is positive, create a radial gradient.
        return if (radius > 0) {
            Brush.radialGradient(
                colors = colors,
                center = Offset(size.width / 2f, size.height / 2f),
                radius = radius,
                tileMode = TileMode.Mirror
            )
        } else {
            // Fallback to a linear gradient if the radius is invalid.
            Brush.linearGradient(
                colors = colors,
                start = Offset.Zero,
                end = Offset(size.width.toFloat(), size.height.toFloat())
            )
        }
    }

    /**
     * Calculates the radius for the radial gradient. The radius is determined as half of
     * the larger dimension (either width or height) of the given [size].
     *
     * @param size The size of the area where the radial gradient should be applied.
     * @return The calculated radius for the radial gradient.
     */
    private fun calculateRadius(size: IntSize): Float =
        size.width.coerceAtLeast(size.height).toFloat() / 2f
}