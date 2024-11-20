package az.lahza.shimmer_animation_compose.models

/**
 * Sealed class representing the possible durations of the shimmer effect.
 * This determines how long each shimmer cycle lasts before repeating.
 *
 * Available durations:
 * - `SHORT`: A short duration for the shimmer effect, lasting 500 milliseconds.
 * - `MEDIUM`: A medium duration for the shimmer effect, lasting 1000 milliseconds (1 second).
 * - `LONG`: A long duration for the shimmer effect, lasting 1500 milliseconds (1.5 seconds).
 * - `CUSTOM`: A custom duration for the shimmer effect, defined by the user.
 *
 */
sealed class ShimmerDuration {

    /**
     * Represents a short shimmer duration.
     * The default duration for this cycle is 500 milliseconds.
     */
    data object SHORT : ShimmerDuration() {
        /**
         * The duration for the short shimmer cycle in milliseconds.
         */
        const val DURATION: Int = 500
    }

    /**
     * Represents a medium shimmer duration.
     * The default duration for this cycle is 1000 milliseconds (1 second).
     */
    data object MEDIUM : ShimmerDuration() {
        /**
         * The duration for the medium shimmer cycle in milliseconds.
         */
        const val DURATION: Int = 1000
    }

    /**
     * Represents a long shimmer duration.
     * The default duration for this cycle is 1500 milliseconds (1.5 seconds).
     */
    data object LONG : ShimmerDuration() {
        /**
         * The duration for the long shimmer cycle in milliseconds.
         */
        const val DURATION: Int = 1500
    }

    /**
     * Represents a custom shimmer duration, where the user can define the duration in milliseconds.
     *
     * @param duration The custom duration for the shimmer cycle in milliseconds.
     */
    data class CUSTOM(val duration: Int) : ShimmerDuration()
}
