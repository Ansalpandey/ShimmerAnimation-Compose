package az.lahza.shimmeranimation_compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import az.lahza.shimmeranimation_compose.ui.components.ShimmerBox

/**
 * Renders the top-most row of the UI, which contains a single shimmer effect box.
 * This row is padded at the top to provide appropriate spacing from the screen's edge, ensuring a
 * balanced visual hierarchy.
 *
 * This is a basic usage of the `ShimmerBox` composable, providing a simple yet visually appealing effect
 * for loading items.
 *
 * @see ShimmerBox
 */
@Composable
fun TopRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ShimmerBox(
            modifier = Modifier
                .width(120.dp)
                .size(25.dp), shape = RoundedCornerShape(8.dp)
        )
    }
}
