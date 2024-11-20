package az.lahza.shimmer_animation_compose.models.enums

/**
 * Enum class representing the intensity levels of the shimmer effect.
 * Each intensity level corresponds to a specific alpha (transparency) value,
 * which determines how strong or subtle the shimmer effect appears.
 * The alpha value controls the opacity of the shimmer, with higher values resulting in a more intense shimmer effect.
 *
 * The available intensity levels and their corresponding alpha values are as follows:
 *
 * ```
 * ZERO        = 0.0f   // No shimmer, completely transparent.
 * VERY_LOW    = 0.1f   // Very subtle shimmer, with minimal transparency.
 * LOW         = 0.2f   // Slight shimmer, still very subtle.
 * SLIGHT      = 0.3f   // Noticeable shimmer, but still subtle.
 * MEDIUM_LOW  = 0.4f   // Moderate shimmer, noticeable but not overwhelming.
 * MEDIUM      = 0.5f   // Standard shimmer effect, balanced visibility.
 * MEDIUM_HIGH = 0.6f   // Strong shimmer, more pronounced.
 * HIGH        = 0.7f   // Vivid shimmer, with high opacity.
 * VERY_HIGH   = 0.8f   // Very strong shimmer, very prominent.
 * EXTREME     = 0.9f   // Extreme shimmer effect, nearly full opacity.
 * FULL        = 1.0f   // Maximum shimmer intensity, fully visible.
 * ```
 *
 * @param alpha The alpha (transparency) value that represents the shimmer intensity.
 */
enum class ShimmerIntensity(val alpha: Float) {
    /**
     * Zero intensity, making the shimmer effect fully transparent.
     */
    ZERO(0.0f),

    /**
     * Very low intensity, with a slight shimmer effect.
     */
    VERY_LOW(0.1f),

    /**
     * Low intensity, with a subtle shimmer effect.
     */
    LOW(0.2f),

    /**
     * Slight intensity, providing a more noticeable shimmer effect.
     */
    SLIGHT(0.3f),

    /**
     * Medium-low intensity, with a moderate shimmer effect.
     */
    MEDIUM_LOW(0.4f),

    /**
     * Medium intensity, providing a standard shimmer effect.
     */
    MEDIUM(0.5f),

    /**
     * Medium-high intensity, giving a more pronounced shimmer effect.
     */
    MEDIUM_HIGH(0.6f),

    /**
     * High intensity, making the shimmer effect more vivid.
     */
    HIGH(0.7f),

    /**
     * Very high intensity, creating a very strong shimmer effect.
     */
    VERY_HIGH(0.8f),

    /**
     * Extreme intensity, providing the maximum shimmer effect.
     */
    EXTREME(0.9f),

    /**
     * Full intensity, making the shimmer effect fully visible.
     */
    FULL(1.0f);

    companion object {
        /**
         * Returns the corresponding [ShimmerIntensity] based on the given alpha value.
         * If the provided alpha does not exactly match any entry, it defaults to [MEDIUM].
         *
         * @param alpha The alpha value to match.
         * @return The corresponding [ShimmerIntensity] for the given alpha value.
         */
        fun fromAlpha(alpha: Float): ShimmerIntensity {
            return entries.find { it.alpha == alpha.coerceIn(0.1f, 1.0f) }
                ?: MEDIUM // Default to MEDIUM if no exact match
        }
    }
}
