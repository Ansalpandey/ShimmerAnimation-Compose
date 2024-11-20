package az.lahza.shimmer_animation_compose.models.enums

/**
 * Enum class representing the types of shimmer effects.
 * This determines the type of gradient used in the shimmer animation.
 * The shimmer can either use a linear gradient or a radial gradient effect.
 */
enum class ShimmerEffectType {
    /**
     * A linear shimmer effect, where the shimmer moves along a straight line,
     * typically from one end to the other in a horizontal or vertical direction.
     */
    LINEAR,

    /**
     * A radial shimmer effect, where the shimmer moves outward from a central point
     * in a circular pattern.
     */
    RADIAL
}
