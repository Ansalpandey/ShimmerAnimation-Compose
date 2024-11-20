package az.lahza.shimmer_animation_compose.core.interfaces

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import az.lahza.shimmer_animation_compose.models.enums.ShimmerEffectType

interface ShimmerEffectBrushProvider {

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
     */
    fun provideBrush(
        effectType: ShimmerEffectType,
        adjustedColors: List<Color>,
        startOffsetX: Float,
        startOffsetY: Float,
        size: IntSize
    ): Brush
}
