package az.lahza.shimmer_animation_compose.resolver.implementations

import androidx.compose.ui.unit.IntSize
import az.lahza.shimmer_animation_compose.models.ShimmerCycleDuration
import az.lahza.shimmer_animation_compose.models.ShimmerDuration
import az.lahza.shimmer_animation_compose.models.ShimmerRepeatDelay
import az.lahza.shimmer_animation_compose.models.ShimmerRepeatMode
import az.lahza.shimmer_animation_compose.models.ShimmerStartDelay
import az.lahza.shimmer_animation_compose.models.enums.ShimmerDirection
import az.lahza.shimmer_animation_compose.resolver.interfaces.ShimmerResolver

/**
 * Implementation of the [ShimmerResolver] interface that resolves various shimmer effect properties
 * such as duration, cycle duration, repeat delay, start delay, and direction.
 *
 * The methods in this class calculate the appropriate values for these properties based on the given types
 * and return them to be used in the shimmer animation logic.
 */
class ShimmerResolverImpl : ShimmerResolver {

    /**
     * Resolves the duration of the shimmer effect based on the given [ShimmerDuration] type.
     *
     * @param duration The duration type to resolve (e.g., [ShimmerDuration.SHORT], [ShimmerDuration.MEDIUM]).
     * @return The corresponding duration in milliseconds.
     */
    override fun resolveDuration(duration: ShimmerDuration) = when (duration) {
        ShimmerDuration.SHORT -> ShimmerDuration.SHORT.DURATION
        ShimmerDuration.MEDIUM -> ShimmerDuration.MEDIUM.DURATION
        ShimmerDuration.LONG -> ShimmerDuration.LONG.DURATION
        is ShimmerDuration.CUSTOM -> duration.duration
    }

    /**
     * Resolves the cycle duration based on the given [ShimmerCycleDuration] type.
     * This determines how long the shimmer effect will loop before repeating.
     *
     * @param cycleDuration The cycle duration type to resolve (e.g., [ShimmerCycleDuration.INFINITE], [ShimmerCycleDuration.SHORT]).
     * @return The resolved cycle duration in milliseconds.
     */
    override fun resolveCycleDuration(cycleDuration: ShimmerCycleDuration) =
        when (cycleDuration) {
            ShimmerCycleDuration.INFINITE -> Int.MAX_VALUE  // Infinite cycle duration
            ShimmerCycleDuration.SHORT -> ShimmerCycleDuration.SHORT.DURATION
            ShimmerCycleDuration.MEDIUM -> ShimmerCycleDuration.MEDIUM.DURATION
            ShimmerCycleDuration.LONG -> ShimmerCycleDuration.LONG.DURATION
            is ShimmerCycleDuration.CUSTOM -> cycleDuration.duration
        }

    /**
     * Resolves the repeat mode based on the given [ShimmerRepeatMode] and calculated cycle and effect durations.
     * It calculates the repeat count if the repeat mode is infinite.
     *
     * @param repeatMode The repeat mode type (e.g., [ShimmerRepeatMode.INFINITE], [ShimmerRepeatMode.ONCE]).
     * @param resolvedCycleDuration The resolved cycle duration in milliseconds.
     * @param resolvedDuration The resolved shimmer effect duration in milliseconds.
     * @return The resolved repeat mode, either custom or the original mode.
     */
    override fun resolveRepeatMode(
        repeatMode: ShimmerRepeatMode,
        resolvedCycleDuration: Int,
        resolvedDuration: Int
    ) = if (repeatMode is ShimmerRepeatMode.INFINITE) {
        // Calculate the repeat count for infinite cycle mode
        val repeatCount = (resolvedCycleDuration / resolvedDuration).coerceAtLeast(1)
        ShimmerRepeatMode.CUSTOM(repeatCount)
    } else repeatMode

    /**
     * Resolves the repeat delay based on the given [ShimmerRepeatDelay] type.
     *
     * @param repeatDelay The repeat delay type (e.g., [ShimmerRepeatDelay.ZERO], [ShimmerRepeatDelay.MEDIUM]).
     * @return The resolved repeat delay in milliseconds.
     */
    override fun resolveRepeatDelay(repeatDelay: ShimmerRepeatDelay) =
        repeatDelay.delayMillis

    /**
     * Resolves the start delay based on the given [ShimmerStartDelay] type.
     *
     * @param startDelay The start delay type (e.g., [ShimmerStartDelay.ZERO], [ShimmerStartDelay.LONG]).
     * @return The resolved start delay in milliseconds.
     */
    override fun resolveStartDelay(startDelay: ShimmerStartDelay) =
        startDelay.delayMillis

    /**
     * Resolves the direction for the shimmer effect based on the given [ShimmerDirection] type and size.
     * This determines the starting offset for the shimmer animation.
     *
     * @param direction The direction of the shimmer effect (e.g., [ShimmerDirection.TOP_TO_BOTTOM], [ShimmerDirection.BOTTOM_TO_TOP]).
     * @param size The size of the shimmer area used to calculate the offset (e.g., width and height).
     * @return The calculated offset for the shimmer animation based on the direction.
     */
    override fun resolveDirection(
        direction: ShimmerDirection,
        size: IntSize
    ) = when (direction) {
        ShimmerDirection.TOP_TO_BOTTOM -> -2f * size.height
        ShimmerDirection.BOTTOM_TO_TOP -> 2f * size.height
        else -> 0f  // Default for horizontal direction (no offset needed)
    }
}
