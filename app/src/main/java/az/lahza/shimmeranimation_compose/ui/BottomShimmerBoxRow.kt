package az.lahza.shimmeranimation_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import az.lahza.shimmeranimation_compose.ui.components.ShimmerBox

/**
 * Displays a bottom row with shimmer boxes placed within a `Box` that has a dark background.
 * This section is designed to simulate a secondary loading area, perhaps for buttons or controls
 * that are meant to be highlighted or emphasized.
 *
 * The dark background helps differentiate this section from others and visually isolates these elements.
 *
 * @see ShimmerBox
 */
@Composable
fun BottomShimmerBoxRow() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(4) {
                ShimmerBox(modifier = Modifier.size(60.dp), shape = RoundedCornerShape(16.dp))
            }
        }
    }
}