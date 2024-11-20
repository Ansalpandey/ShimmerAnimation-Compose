package az.lahza.shimmeranimation_compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import az.lahza.shimmeranimation_compose.ui.components.ShimmerBox

/**
 * Displays a profile section, where one shimmer box represents a profile picture
 * (circle-shaped) and two additional shimmer boxes represent text elements like name or description.
 * The layout is arranged in a `Row` with a `Column` for the profile details, ensuring a flexible and adaptive design.
 *
 * Spacing between the components is controlled using `padding` to give the profile a well-structured layout.
 *
 * @see ShimmerBox
 */
@Composable
fun ProfileSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShimmerBox(modifier = Modifier.size(80.dp), shape = CircleShape)

        Column(modifier = Modifier.padding(start = 5.dp)) {
            ShimmerBox(
                modifier = Modifier
                    .width(175.dp)
                    .height(10.dp),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp),
                shape = RoundedCornerShape(8.dp)
            )
        }
    }
}