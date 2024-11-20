package az.lahza.shimmer_animation_compose.models

/**
 * Sealed class representing the possible start delays before the shimmer effect begins.
 * This controls the time interval before the shimmer effect starts after being triggered.
 *
 * Available start delays:
 * - `ZERO`: No delay before the shimmer effect starts.
 * - `SHORT`: A short delay of 1000 milliseconds (1 second) before the shimmer effect starts.
 * - `MEDIUM`: A medium delay of 3000 milliseconds (3 seconds) before the shimmer effect starts.
 * - `LONG`: A long delay of 5000 milliseconds (5 seconds) before the shimmer effect starts.
 * - `CUSTOM`: A custom delay defined by the user, in milliseconds.
 *
 * @param delayMillis The delay value in milliseconds that determines when the shimmer effect starts.
 */
sealed class ShimmerStartDelay(val delayMillis: Int) {

    /**
     * No delay before the shimmer effect starts.
     * The delay value for this is 0 milliseconds.
     */
    data object ZERO : ShimmerStartDelay(0)

    /**
     * A short delay before the shimmer effect starts.
     * The delay value for this is 1000 milliseconds (1 second).
     */
    data object SHORT : ShimmerStartDelay(1000)

    /**
     * A medium delay before the shimmer effect starts.
     * The delay value for this is 3000 milliseconds (3 seconds).
     */
    data object MEDIUM : ShimmerStartDelay(3000)

    /**
     * A long delay before the shimmer effect starts.
     * The delay value for this is 5000 milliseconds (5 seconds).
     */
    data object LONG : ShimmerStartDelay(5000)

    /**
     * A custom delay before the shimmer effect starts.
     * The user can define the delay value in milliseconds.
     *
     * @param customDelayMillis The custom delay in milliseconds before the shimmer effect starts.
     */
    data class CUSTOM(val customDelayMillis: Int) : ShimmerStartDelay(customDelayMillis)
}
