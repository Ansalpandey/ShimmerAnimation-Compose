package az.lahza.shimmer_animation_compose.data

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import az.lahza.shimmer_animation_compose.models.ShimmerCycleDuration
import az.lahza.shimmer_animation_compose.models.ShimmerDuration
import az.lahza.shimmer_animation_compose.models.ShimmerRepeatDelay
import az.lahza.shimmer_animation_compose.models.ShimmerRepeatMode
import az.lahza.shimmer_animation_compose.models.ShimmerStartDelay
import az.lahza.shimmer_animation_compose.models.enums.ShimmerDirection
import az.lahza.shimmer_animation_compose.models.enums.ShimmerEffectType
import az.lahza.shimmer_animation_compose.models.enums.ShimmerIntensity

/**
 * Data class representing the configuration for a shimmer effect.
 * This class allows customization of various properties related to the shimmer effect,
 * such as the colors, duration, direction, and intensity.
 *
 * The configuration can be used to create a shimmer effect with specific behavior and visual properties.
 *
 * @see ShimmerDuration
 * @see ShimmerCycleDuration
 * @see ShimmerRepeatMode
 * @see ShimmerRepeatDelay
 * @see ShimmerStartDelay
 * @see ShimmerDirection
 * @see ShimmerEffectType
 * @see ShimmerIntensity
 */
data class ShimmerEffectConfig(
    /**
     * List of colors used in the shimmer effect.
     * These colors are blended to create the shimmering animation.
     *
     * Default value is a list of semi-transparent white colors.
     */
    val colors: List<Color> = listOf(
        Color(0x80FFFFFF),  // Semi-transparent white
        Color(0x99FFFFFF),  // Lighter white
        Color(0xB3FFFFFF),  // Full white
        Color(0x99FFFFFF),  // Lighter white
        Color(0x80FFFFFF)   // Semi-transparent white
    ),

    /**
     * Duration of the shimmer effect.
     * Defines how long the shimmer effect lasts for one cycle.
     *
     * Default value is [ShimmerDuration.LONG], which is a long duration.
     *
     * @see ShimmerDuration
     */
    val duration: ShimmerDuration = ShimmerDuration.LONG,

    /**
     * Duration of the shimmer cycle. Defines how long it takes for the shimmer to repeat.
     * The default value is [ShimmerCycleDuration.INFINITE], meaning the shimmer effect will loop indefinitely.
     *
     * @see ShimmerCycleDuration
     */
    val cycleDuration: ShimmerCycleDuration = ShimmerCycleDuration.INFINITE,

    /**
     * Repeat mode of the shimmer effect.
     * Determines if the shimmer effect should repeat indefinitely, once, or a custom number of times.
     * Default value is [ShimmerRepeatMode.INFINITE], meaning the shimmer effect repeats infinitely.
     *
     * @see ShimmerRepeatMode
     */
    val repeatMode: ShimmerRepeatMode = ShimmerRepeatMode.INFINITE,

    /**
     * Delay before the shimmer effect starts repeating.
     * Default value is [ShimmerRepeatDelay.ZERO], meaning no delay between repeats.
     *
     * @see ShimmerRepeatDelay
     */
    val repeatDelay: ShimmerRepeatDelay = ShimmerRepeatDelay.ZERO,

    /**
     * Delay before the shimmer effect starts after being triggered.
     * Default value is [ShimmerStartDelay.ZERO], meaning no delay before the shimmer starts.
     *
     * @see ShimmerStartDelay
     */
    val startDelay: ShimmerStartDelay = ShimmerStartDelay.ZERO,

    /**
     * Direction of the shimmer effect.
     * Defines whether the shimmer should move horizontally or vertically.
     * Default value is [ShimmerDirection.HORIZONTALLY], meaning the shimmer moves horizontally.
     *
     * @see ShimmerDirection
     */
    val direction: ShimmerDirection = ShimmerDirection.HORIZONTALLY,

    /**
     * Type of the shimmer effect.
     * Determines whether the shimmer effect is a linear gradient or a radial gradient.
     * Default value is [ShimmerEffectType.LINEAR], meaning a linear gradient is used.
     *
     * @see ShimmerEffectType
     */
    val effectType: ShimmerEffectType = ShimmerEffectType.LINEAR,

    /**
     * Intensity of the shimmer effect.
     * Defines how strong the shimmer will appear (affects the alpha of the colors).
     * Default value is [ShimmerIntensity.FULL], meaning the shimmer effect will be at full intensity.
     *
     * @see ShimmerIntensity
     */
    val intensity: ShimmerIntensity = ShimmerIntensity.FULL,

    /**
     * Shape of the shimmer effect.
     * Defines the corner radius of the area the shimmer will be applied to.
     * Default value is a rounded corner shape with a 16dp radius.
     */
    val shape: Shape = RoundedCornerShape(16.dp)
)