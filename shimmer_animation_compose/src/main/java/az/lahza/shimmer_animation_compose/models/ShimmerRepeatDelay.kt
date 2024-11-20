package az.lahza.shimmer_animation_compose.models

/**
 * Sealed class representing the possible delay durations before the shimmer effect starts repeating.
 * This controls the time interval between successive shimmer cycles.
 *
 * Available delay levels:
 * - `ZERO`: No delay between shimmer repetitions.
 * - `SHORT`: A short delay of 100 milliseconds between repetitions.
 * - `MEDIUM`: A medium delay of 300 milliseconds between repetitions.
 * - `LONG`: A long delay of 500 milliseconds between repetitions.
 * - `CUSTOM`: A custom delay defined by the user in milliseconds.
 *
 * @param delayMillis The delay value in milliseconds that defines the delay between shimmer cycles.
 */
sealed class ShimmerRepeatDelay(val delayMillis: Int) {

    /**
     * No delay between shimmer repetitions.
     * The delay value for this is 0 milliseconds.
     */
    data object ZERO : ShimmerRepeatDelay(0)

    /**
     * A short delay between shimmer repetitions.
     * The delay value for this is 100 milliseconds.
     */
    data object SHORT : ShimmerRepeatDelay(100)

    /**
     * A medium delay between shimmer repetitions.
     * The delay value for this is 300 milliseconds.
     */
    data object MEDIUM : ShimmerRepeatDelay(300)

    /**
     * A long delay between shimmer repetitions.
     * The delay value for this is 500 milliseconds.
     */
    data object LONG : ShimmerRepeatDelay(500)

    /**
     * A custom delay between shimmer repetitions.
     * The user can define the delay value in milliseconds.
     *
     * @param customDelayMillis The custom delay in milliseconds.
     */
    data class CUSTOM(val customDelayMillis: Int) : ShimmerRepeatDelay(customDelayMillis)
}
