package az.lahza.shimmer_animation_compose.resolver.interfaces

import androidx.compose.ui.unit.IntSize
import az.lahza.shimmer_animation_compose.models.ShimmerCycleDuration
import az.lahza.shimmer_animation_compose.models.ShimmerDuration
import az.lahza.shimmer_animation_compose.models.ShimmerRepeatDelay
import az.lahza.shimmer_animation_compose.models.ShimmerRepeatMode
import az.lahza.shimmer_animation_compose.models.ShimmerStartDelay
import az.lahza.shimmer_animation_compose.models.enums.ShimmerDirection

/**
 * Interface defining the necessary methods for resolving the properties of the shimmer effect.
 * Implementing classes should provide the logic to calculate or resolve the shimmer effect's
 * duration, cycle duration, repeat delay, start delay, repeat mode, and direction based on the
 * provided types or configurations.
 */
interface ShimmerResolver {

    /**
     * Resolves the duration of the shimmer effect based on the given [ShimmerDuration] type.
     *
     * @param duration The duration type to resolve (e.g., [ShimmerDuration.SHORT], [ShimmerDuration.MEDIUM]).
     * @return The corresponding duration in milliseconds.
     */
    fun resolveDuration(duration: ShimmerDuration): Int

    /**
     * Resolves the cycle duration based on the given [ShimmerCycleDuration] type.
     * This determines how long the shimmer effect will loop before repeating.
     *
     * @param cycleDuration The cycle duration type to resolve (e.g., [ShimmerCycleDuration.INFINITE], [ShimmerCycleDuration.SHORT]).
     * @return The resolved cycle duration in milliseconds.
     */
    fun resolveCycleDuration(cycleDuration: ShimmerCycleDuration): Int

    /**
     * Resolves the repeat delay based on the given [ShimmerRepeatDelay] type.
     *
     * @param repeatDelay The repeat delay type (e.g., [ShimmerRepeatDelay.ZERO], [ShimmerRepeatDelay.MEDIUM]).
     * @return The resolved repeat delay in milliseconds.
     */
    fun resolveRepeatDelay(repeatDelay: ShimmerRepeatDelay): Int

    /**
     * Resolves the start delay based on the given [ShimmerStartDelay] type.
     *
     * @param startDelay The start delay type (e.g., [ShimmerStartDelay.ZERO], [ShimmerStartDelay.LONG]).
     * @return The resolved start delay in milliseconds.
     */
    fun resolveStartDelay(startDelay: ShimmerStartDelay): Int

    /**
     * Resolves the repeat mode based on the given [ShimmerRepeatMode] and calculated cycle and effect durations.
     * It calculates the repeat count if the repeat mode is infinite.
     *
     * @param repeatMode The repeat mode type (e.g., [ShimmerRepeatMode.INFINITE], [ShimmerRepeatMode.ONCE]).
     * @param resolvedCycleDuration The resolved cycle duration in milliseconds.
     * @param resolvedDuration The resolved shimmer effect duration in milliseconds.
     * @return The resolved repeat mode, either custom or the original mode.
     */
    fun resolveRepeatMode(
        repeatMode: ShimmerRepeatMode,
        resolvedCycleDuration: Int,
        resolvedDuration: Int
    ): ShimmerRepeatMode

    /**
     * Resolves the direction for the shimmer effect based on the given [ShimmerDirection] type and size.
     * This determines the starting offset for the shimmer animation.
     *
     * @param direction The direction of the shimmer effect (e.g., [ShimmerDirection.TOP_TO_BOTTOM], [ShimmerDirection.BOTTOM_TO_TOP]).
     * @param size The size of the shimmer area used to calculate the offset (e.g., width and height).
     * @return The calculated offset for the shimmer animation based on the direction.
     */
    fun resolveDirection(direction: ShimmerDirection, size: IntSize): Float
}
