package az.lahza.shimmer_animation_compose.core.interfaces

import androidx.compose.ui.graphics.Color
import az.lahza.shimmer_animation_compose.models.enums.ShimmerIntensity

/**
 * Interface that defines the necessary behavior for adjusting the colors of a shimmer effect.
 * The class implementing this interface is responsible for adjusting the shimmer colors based
 * on a given intensity value.
 *
 * This interface can be used to modify the shimmer effect's appearance by altering the alpha
 * (transparency) of the colors based on the desired intensity, allowing for flexible shimmer effects.
 *
 * @see ShimmerIntensity
 */
interface ShimmerEffect {

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
     */
    fun adjustColors(
        colors: List<Color>,
        intensity: ShimmerIntensity
    ): List<Color>
}