package az.lahza.shimmer_animation_compose.core.implementations

import androidx.compose.ui.graphics.Color
import az.lahza.shimmer_animation_compose.core.interfaces.ShimmerEffect
import az.lahza.shimmer_animation_compose.models.enums.ShimmerIntensity

/**
 * Implementation of the [ShimmerEffect] interface that adjusts the colors of the shimmer effect
 * based on the provided shimmer intensity.
 *
 * This class modifies the alpha (transparency) of the provided shimmer colors according to the
 * specified shimmer intensity, allowing for varying degrees of shimmer brightness.
 *
 * @see ShimmerEffect
 * @see ShimmerIntensity
 */
class ShimmerEffectImpl : ShimmerEffect {

    /**
     * Adjusts the colors of the shimmer effect based on the provided shimmer intensity.
     * The alpha value of each color is adjusted according to the shimmer intensity.
     *
     * If less than 2 colors are provided, a default color set is created with variations in alpha.
     * If 2 or more colors are provided, their alphas are scaled by the shimmer intensity.
     *
     * @param colors A list of colors to be used in the shimmer effect. Typically, this list
     *                      contains at least two colors for a gradient effect.
     * @param intensity The intensity of the shimmer effect, affecting the alpha values of
     *                         the colors. The alpha will be clamped to the range [0, 1].
     * @return A list of colors with adjusted alpha values, representing the shimmer effect.
     *
     * @see ShimmerIntensity
     *
     */
    override fun adjustColors(
        colors: List<Color>,
        intensity: ShimmerIntensity
    ): List<Color> {
        // Clamps the alpha value of the shimmer intensity to be between 0 and 1.
        val clampedAlpha = intensity.alpha.coerceIn(0.0f, 1.0f)

        return if (colors.size < 2) {
            // If less than 2 colors are provided, create a default shimmer effect with variations in alpha.
            val baseColor = colors.firstOrNull() ?: Color.Gray
            listOf(
                baseColor.copy(alpha = 0.5f * clampedAlpha),  // Light shimmer color
                baseColor.copy(alpha = clampedAlpha),         // Full intensity shimmer color
                baseColor.copy(alpha = 0.5f * clampedAlpha)   // Light shimmer color
            )
        } else {
            // If 2 or more colors are provided, adjust their alpha based on the shimmer intensity.
            colors.map { it.copy(alpha = it.alpha * clampedAlpha) }
        }
    }
}
