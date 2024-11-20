package az.lahza.shimmer_animation_compose.models

/**
 * Sealed class representing the possible durations of the shimmer cycle.
 * This determines how long the shimmer effect lasts before it repeats.
 * Each duration level corresponds to a specific time interval or a custom duration value.
 *
 * Available durations:
 * - `INFINITE`: The shimmer cycle repeats indefinitely.
 * - `SHORT`: A short shimmer cycle with a duration of 3000 milliseconds (3 seconds).
 * - `MEDIUM`: A medium shimmer cycle with a duration of 5000 milliseconds (5 seconds).
 * - `LONG`: A long shimmer cycle with a duration of 8000 milliseconds (8 seconds).
 * - `CUSTOM`: A custom shimmer cycle duration defined by the user.
 *
 */
sealed class ShimmerCycleDuration {

    /**
     * Represents an infinite shimmer cycle that repeats indefinitely.
     */
    data object INFINITE : ShimmerCycleDuration()

    /**
     * Represents a short shimmer cycle.
     * The default duration for this cycle is 3000 milliseconds (3 seconds).
     */
    data object SHORT : ShimmerCycleDuration() {
        /**
         * The duration for the short shimmer cycle in milliseconds.
         */
        const val DURATION: Int = 3000
    }

    /**
     * Represents a medium shimmer cycle.
     * The default duration for this cycle is 5000 milliseconds (5 seconds).
     */
    data object MEDIUM : ShimmerCycleDuration() {
        /**
         * The duration for the medium shimmer cycle in milliseconds.
         */
        const val DURATION: Int = 5000
    }

    /**
     * Represents a long shimmer cycle.
     * The default duration for this cycle is 8000 milliseconds (8 seconds).
     */
    data object LONG : ShimmerCycleDuration() {
        /**
         * The duration for the long shimmer cycle in milliseconds.
         */
        const val DURATION: Int = 8000
    }

    /**
     * Represents a custom shimmer cycle with a user-defined duration.
     *
     * @param duration The custom duration for the shimmer cycle in milliseconds.
     */
    data class CUSTOM(val duration: Int) : ShimmerCycleDuration()
}
