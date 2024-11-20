package az.lahza.shimmeranimation_compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import az.lahza.shimmer_animation_compose.data.ShimmerEffectConfig
import az.lahza.shimmer_animation_compose.ui.shimmerEffect

/**
 * A reusable composable that displays a shimmer effect inside a box.
 * This effect is typically used to simulate the loading state of a UI element.
 * It uses the `shimmerEffect` modifier to apply the shimmer animation with specific colors and shape.
 *
 * The shimmer effect is intended to be a visual cue that content is loading, improving the user experience
 * by giving them an indication of ongoing activity.
 *
 * @param modifier Modifier to customize the appearance and behavior of the box, including size and padding.
 * @param shape The shape of the box, e.g., `RectangleShape`, `CircleShape`, or custom shapes like `RoundedCornerShape`.
 *
 */
@Composable
fun ShimmerBox(modifier: Modifier = Modifier, shape: Shape = RectangleShape) {
    Box(
        modifier = modifier
            .background(Color.Gray, shape = shape)
            .shimmerEffect(
                config = ShimmerEffectConfig(
                    shape = shape,
                ),
            )
    )
}