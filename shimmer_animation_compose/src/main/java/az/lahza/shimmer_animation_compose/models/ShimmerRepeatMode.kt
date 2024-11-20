package az.lahza.shimmer_animation_compose.models

/**
 * Sealed class representing the possible repeat modes for the shimmer effect.
 * This defines how many times the shimmer animation should repeat before stopping.
 *
 * Available repeat modes:
 * - `INFINITE`: The shimmer effect will repeat indefinitely.
 * - `ONCE`: The shimmer effect will repeat only once.
 * - `CUSTOM`: The shimmer effect will repeat a specified number of times.
 *
 */
sealed class ShimmerRepeatMode {

    /**
     * Represents an infinite repeat mode.
     * The shimmer effect will repeat indefinitely.
     */
    data object INFINITE : ShimmerRepeatMode()

    /**
     * Represents a single repeat of the shimmer effect.
     * The shimmer effect will repeat only once.
     */
    data object ONCE : ShimmerRepeatMode()

    /**
     * Represents a custom repeat mode.
     * The shimmer effect will repeat a specified number of times.
     *
     * @param count The number of times the shimmer effect should repeat.
     */
    data class CUSTOM(val count: Int) : ShimmerRepeatMode()
}
