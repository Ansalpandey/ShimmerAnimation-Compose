package az.lahza.shimmer_animation_compose.models.enums

/**
 * Enum class representing the possible directions of the shimmer effect.
 * This determines the movement direction of the shimmer animation.
 * The shimmer can either move vertically (from top to bottom, or bottom to top)
 * or horizontally across the screen.
 */
enum class ShimmerDirection {
    /**
     * Shimmer moves from top to bottom.
     */
    TOP_TO_BOTTOM,

    /**
     * Shimmer moves from bottom to top.
     */
    BOTTOM_TO_TOP,

    /**
     * Shimmer moves horizontally, i.e., from left to right or right to left.
     */
    HORIZONTALLY
}
