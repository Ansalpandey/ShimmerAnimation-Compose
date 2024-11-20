package az.lahza.shimmeranimation_compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 *
 * Composable function responsible for displaying the primary user interface.
 * It organizes multiple UI sections within a `Column` layout, which is aligned and arranged vertically.
 * The sections include top row, profile details, a grid, and a bottom shimmer effect row.
 *
 * This composable is structured to follow best practices for scalability and maintainability.
 * It makes use of reusable components, minimizing code duplication while maintaining clear separation of concerns.
 *
 *
 * @see TopRow
 * @see TwoShimmerBoxRow
 * @see ProfileSection
 * @see BottomGridRow
 * @see BottomShimmerBoxRow
 *
 */
@Composable
fun CustomGridUI() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            // Display the top row with a single shimmer box
            TopRow()

            // Display two shimmer boxes in a row
            TwoShimmerBoxRow()

            // Display the profile section with a shimmer effect
            ProfileSection()

            // Display a grid of shimmer boxes in the bottom section
            BottomGridRow()

            // Display a row of shimmer boxes in a darker background
            BottomShimmerBoxRow()
        }
    }
}