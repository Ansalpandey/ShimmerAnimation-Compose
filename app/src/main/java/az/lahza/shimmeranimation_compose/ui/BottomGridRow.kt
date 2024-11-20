package az.lahza.shimmeranimation_compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
 * Renders a bottom grid of shimmer boxes. This section represents a generic layout for elements that can
 * be loaded, such as card views, image galleries, or buttons.
 *
 * The layout is divided into two rows: the first row has smaller shimmer boxes, and the second row
 * includes a larger shimmer box. This provides variability in the loading simulation.
 *
 * @see ShimmerBox
 */
@Composable
fun BottomGridRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(50.dp),
                    shape = RoundedCornerShape(8.dp)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp),
                shape = RoundedCornerShape(8.dp)
            )
        }
    }
}