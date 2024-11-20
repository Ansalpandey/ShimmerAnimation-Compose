package az.lahza.shimmeranimation_compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import az.lahza.shimmeranimation_compose.ui.components.ShimmerBox

/**
 * Creates a row with two shimmer boxes side by side.
 * This row is padded on all sides, creating visual separation from other sections of the UI.
 * The shimmer boxes are made larger to simulate more complex UI elements like cards or buttons.
 *
 * The layout utilizes `repeat` for reducing code duplication and enhancing readability.
 *
 * @see ShimmerBox
 */
@Composable
fun TwoShimmerBoxRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        repeat(2) {
            ShimmerBox(modifier = Modifier.size(160.dp), shape = RoundedCornerShape(16.dp))
        }
    }
}