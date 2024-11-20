package az.lahza.shimmer_animation_compose.animation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import az.lahza.shimmer_animation_compose.models.ShimmerRepeatMode

/**
 * Helper class for creating shimmer animations with different repeat modes.
 * Provides functionality to create animations based on different repetition patterns:
 * - Once
 * - Infinite
 * - Custom (with a specified number of repeats).
 *
 */
class ShimmerAnimationHelper {

    /**
     * Delays the start of the animation if the [startDelayMillis] is greater than 0.
     *
     * @param startDelayMillis The delay in milliseconds before the animation starts.
     * If it's greater than 0, the function will suspend and wait for that duration.
     */
    suspend fun applyStartDelayIfNeeded(startDelayMillis: Int) {
        if (startDelayMillis > 0) {
            kotlinx.coroutines.delay(startDelayMillis.toLong())
        }
    }

    /**
     * Resolves the animation specification based on the given repeat mode.
     * The function returns an animation spec that is either infinite, runs once,
     * or runs a custom number of times based on [repeatMode].
     *
     * @param repeatMode The repeat mode specifying whether the animation should repeat infinitely, once, or custom times.
     * @param durationMillis The total duration of one loop of the shimmer animation in milliseconds.
     * @param repeatDelayMillis The delay between repeats in milliseconds.
     * @return The animation specification for the given repeat mode.
     */
    fun resolveAnimationSpec(
        repeatMode: ShimmerRepeatMode,
        durationMillis: Int,
        repeatDelayMillis: Int
    ) = when (repeatMode) {
        // For a single execution (one time).
        is ShimmerRepeatMode.ONCE -> createOnceAnimation(durationMillis)

        // For infinite repetitions.
        is ShimmerRepeatMode.INFINITE -> createInfiniteRepeatableAnimation(
            durationMillis,
            repeatDelayMillis
        )

        // For a custom number of repetitions.
        is ShimmerRepeatMode.CUSTOM -> createCustomRepeatableAnimation(
            repeatMode.count,
            durationMillis,
            repeatDelayMillis
        )
    }

    /**
     * Creates an infinite repeatable animation that continuously repeats.
     *
     * @param durationMillis The duration of one loop in milliseconds.
     * @param repeatDelayMillis The delay between each repeat in milliseconds.
     * @return An [infiniteRepeatable] animation spec.
     */
    private fun createInfiniteRepeatableAnimation(durationMillis: Int, repeatDelayMillis: Int) =
        infiniteRepeatable(
            animation = createShimmerKeyframes(durationMillis, repeatDelayMillis),
            repeatMode = RepeatMode.Restart
        )

    /**
     * Creates a one-time animation that runs only once without repetition.
     *
     * @param durationMillis The duration of the animation in milliseconds.
     * @return A [tween] animation spec for a single run.
     */
    private fun createOnceAnimation(durationMillis: Int) = tween<Float>(durationMillis)

    /**
     * Creates a custom repeatable animation that repeats a specified number of times.
     *
     * @param count The number of times the animation should repeat.
     * @param durationMillis The duration of one loop of the animation in milliseconds.
     * @param repeatDelayMillis The delay between each repeat in milliseconds.
     * @return A [repeatable] animation spec with the specified number of repetitions.
     */
    private fun createCustomRepeatableAnimation(
        count: Int,
        durationMillis: Int,
        repeatDelayMillis: Int
    ) = repeatable(
        iterations = count,
        animation = createShimmerKeyframes(durationMillis, repeatDelayMillis),
        repeatMode = RepeatMode.Restart
    )

    /**
     * Creates the keyframes for a shimmer animation.
     * This defines the start and end values and the timing for the animation.
     *
     * @param durationMillis The duration of one loop of the animation in milliseconds.
     * @param repeatDelayMillis The delay between repeats in milliseconds.
     * @return A [keyframes] animation spec that defines the shimmer effect.
     */
    private fun createShimmerKeyframes(durationMillis: Int, repeatDelayMillis: Int) = keyframes {
        // Total duration including the repeat delay
        this.durationMillis = durationMillis + repeatDelayMillis

        // Define the keyframe values and their respective timings
        0f at 0 using LinearOutSlowInEasing
        2f at durationMillis using LinearOutSlowInEasing
    }
}
