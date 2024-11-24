package az.lahza.shimmer_animation_compose.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import az.lahza.shimmer_animation_compose.animation.ShimmerAnimationHelper
import az.lahza.shimmer_animation_compose.core.implementations.ShimmerEffectBrushProviderImpl
import az.lahza.shimmer_animation_compose.core.implementations.ShimmerEffectImpl
import az.lahza.shimmer_animation_compose.core.interfaces.ShimmerEffect
import az.lahza.shimmer_animation_compose.core.interfaces.ShimmerEffectBrushProvider
import az.lahza.shimmer_animation_compose.data.ShimmerEffectConfig
import az.lahza.shimmer_animation_compose.resolver.implementations.ShimmerResolverImpl
import az.lahza.shimmer_animation_compose.resolver.interfaces.ShimmerResolver

/**
 * Custom [Modifier] extension to apply a shimmer effect to a Composable.
 * The shimmer effect is applied based on the given [ShimmerEffectConfig] configuration.
 * This modifier handles the shimmer animation, color adjustments, duration, cycle, repeat mode, and direction.
 *
 * @param config The configuration to customize the shimmer effect (default is [ShimmerEffectConfig]).
 * @return A [Modifier] that applies the shimmer effect to the composable.
 *
 *
 * **Usage Examples**:
 *
 * **1. Applying Default Shimmer Effect to a `Box`:**
 * ```
 * Box(
 *     modifier = Modifier
 *         .fillMaxSize()
 *         // Default shimmer effect with default configuration
 *         .shimmerEffect()
 * ) {
 *     // Content inside this Box will have a shimmer effect applied
 * }
 * ```
 *
 * **2. Applying Custom Shimmer Effect to `Text` with Specific Colors and Duration:**
 * ```
 * Text(
 *     text = "Shimmering Text",
 *     modifier = Modifier
 *         .shimmerEffect(
 *             config = ShimmerEffectConfig(
 *                 // Blue to Red shimmer
 *                 colors = listOf(Color(0xFF0000FF), Color(0xFFFF0000)),
 *                 // 1 second duration
 *                 duration = ShimmerDuration.MEDIUM,
 *                 // HIGH = 0.7f
 *                 intensity = ShimmerIntensity.HIGH
 *             )
 *         )
 * )
 * ```
 *
 * **3. Applying Shimmer Effect to a `Column` with Vertical Layout:**
 * ```
 * Column(
 *     modifier = Modifier
 *         .fillMaxSize()
 *         .shimmerEffect(
 *              ShimmerEffectConfig(
 *                  direction = ShimmerDirection.TOP_TO_BOTTOM
 *              )
 *         )
 * ) {
 *     // Content in this Column will shimmer with vertical movement
 * }
 * ```
 *
 * **4. Adding Shimmer Effect to a `Button` with Custom `cycleDuration`, `repeatMode`, `repeatDelay`, and `startDelay`:**
 * ```
 * Button(
 *     onClick = { /* Do something */ },
 *     modifier = Modifier
 *         .padding(16.dp)
 *         .shimmerEffect(
 *             config = ShimmerEffectConfig(
 *                 // 8 seconds duration
 *                 cycleDuration = ShimmerCycleDuration.LONG,
 *                 // Repeat only once
 *                 repeatMode = ShimmerRepeatMode.ONCE,
 *                 // 300 milliseconds delay
 *                 repeatDelay = ShimmerRepeatDelay.MEDIUM,
 *                 // 1 second delay
 *                 startDelay = ShimmerStartDelay.SHORT
 *             )
 *         )
 * ) {
 *     Text("Click Me")
 * }
 * ```
 *
 * **5. Applying Shimmer Effect to a `Card` with Custom Shape:**
 * ```
 * Card(
 *     modifier = Modifier
 *         .fillMaxSize()
 *         // Custom rounded corners
 *         .shimmerEffect(
 *              config = ShimmerEffectConfig(
 *                          shape = RoundedCornerShape(12.dp)
 *                       )
 *         )
 * ) {
 *     Text("Shimmering Card Content")
 * }
 * ```
 *
 * ------------------------------
 *
 * **Author**: Zaminali Rustamov
 *
 * **Date**: 20.11.2024
 *
 * **Connect with me:**
 * - **LinkedIn**: [Zaminali Rustamov](https://www.linkedin.com/in/zaminali-rustamov)
 * - **GitHub**: [Zaminali Rustamov](https://github.com/zaminalirustemov)
 *
 * ------------------------------
 */
fun Modifier.shimmerEffect(config: ShimmerEffectConfig = ShimmerEffectConfig()) = composed {
    // Initialize required classes for shimmer effect
    val effect: ShimmerEffect = ShimmerEffectImpl()
    val effectBrushProvider: ShimmerEffectBrushProvider = ShimmerEffectBrushProviderImpl()
    val resolver: ShimmerResolver = ShimmerResolverImpl()
    val animationHelper = ShimmerAnimationHelper()

    // Adjust the colors based on the intensity configuration
    val adjustedColors = effect.adjustColors(config.colors, config.intensity)

    // Resolve the shimmer effect properties like duration, cycle duration, etc.
    val resolvedDuration = resolver.resolveDuration(config.duration)
    val resolvedCycleDuration = resolver.resolveCycleDuration(config.cycleDuration)
    val resolvedRepeatDelay = resolver.resolveRepeatDelay(config.repeatDelay)
    val resolvedStartDelay = resolver.resolveStartDelay(config.startDelay)

    // Resolve the repeat mode based on the cycle duration and effect duration
    val finalRepeatMode = resolver.resolveRepeatMode(
        config.repeatMode, resolvedCycleDuration, resolvedDuration
    )

    // Manage the size of the composable
    var size by remember { mutableStateOf(IntSize.Zero) }

    // Set up the shimmer animation using Animatable for smooth transitions
    val animatedOffsetX = remember { Animatable(initialValue = -2f) }

    LaunchedEffect(finalRepeatMode, resolvedRepeatDelay, resolvedStartDelay) {
        // Apply start delay if needed before starting the animation
        animationHelper.applyStartDelayIfNeeded(resolvedStartDelay)

        // Resolve the animation specification based on the repeat mode, duration, and delay
        val animationSpec = animationHelper.resolveAnimationSpec(
            finalRepeatMode, resolvedDuration, resolvedRepeatDelay
        )

        // Animate the shimmer offset on the X-axis (for horizontal shimmer movement)
        animatedOffsetX.animateTo(
            targetValue = 2f, // Target position for the shimmer animation
            animationSpec = animationSpec
        )
    }

    // Get the starting offset for the X and Y axes based on the animation and direction
    val startOffsetX = animatedOffsetX.value
    val startOffsetY = resolver.resolveDirection(config.direction, size)

    // Generate the shimmer brush based on the direction, colors, and size
    val brush = effectBrushProvider.provideBrush(
        effectType = config.effectType,
        adjustedColors = adjustedColors,
        startOffsetX = startOffsetX,
        startOffsetY = startOffsetY,
        size = size
    )

    // Apply the shimmer effect to the composable, adjusting its size and background
    Modifier
        .onGloballyPositioned { size = it.size } // Capture the size of the composable
        .background(
            brush = brush, // Apply the shimmer brush as the background
            shape = config.shape // Set the shape for the shimmer effect
        )
}