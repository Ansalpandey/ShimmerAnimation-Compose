package az.lahza.shimmeranimation_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import az.lahza.shimmeranimation_compose.ui.CustomGridUI
import az.lahza.shimmeranimation_compose.ui.theme.ShimmerAnimationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShimmerAnimationComposeTheme {
                CustomGridUI()
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewCustomGridUI() {
    ShimmerAnimationComposeTheme {
        CustomGridUI()
    }
}