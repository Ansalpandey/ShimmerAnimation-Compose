
 
# Jetpack Compose Shimmer Animation Library 
![kotlin](https://img.shields.io/badge/Platforms-Kotlin_Compatible-lightblue?style=for-the-badge&logo=kotlin) 

![kotlin](https://img.shields.io/badge/Language-Kotlin-0095D9?style=for-the-badge&logo=kotlin)  

![Jetpack Compose](https://img.shields.io/badge/Framework-Jetpack_Compose-FF8C00?style=for-the-badge&logo=android) 

![android_7](https://img.shields.io/badge/Android-7.0_Nougat-green?style=for-the-badge)  

![min_sdk](https://img.shields.io/badge/minSdk-24-orange?style=for-the-badge) 

![license](https://img.shields.io/badge/License-MIT-brightgreen?style=for-the-badge)

<p align="center">
<strong>A Shimmer Animation Library for Kotlin, built with Jetpack Compose.</strong>
</p>

<p align="center">
<img width=30% src="./examples/demo.gif">
</p>


## ✨ Features
- 🎨 **Customizable Colors**  
  Define the colors used in the shimmer effect. The colors blend together to create the shimmering animation. By default, it uses semi-transparent white colors, but you can modify this list to fit your design needs.
  
- ⏱️ **Customizable Duration**  
  Control the duration of the shimmer effect. You can specify how long the shimmer effect lasts for one cycle. The default duration is long, but you can adjust it to be shorter or longer based on your preference.
  - `SHORT`: A short duration for the shimmer effect, lasting 500 milliseconds.  
  - `MEDIUM`: A medium duration for the shimmer effect, lasting 1000 milliseconds (1 second).  
  - `LONG`: A long duration for the shimmer effect, lasting 1500 milliseconds (1.5 seconds).  
  - `CUSTOM`: A custom duration for the shimmer effect, defined by the user.
  

- 🔁 **Shimmer Cycle Duration**  
  Control how long it takes for the shimmer to repeat. The shimmer effect can loop indefinitely or you can specify a custom duration. By default, the shimmer repeats infinitely.
  - `INFINITE`: The shimmer cycle repeats indefinitely.  
  - `SHORT`: A short shimmer cycle with a duration of 3000 milliseconds (3 seconds).  
  - `MEDIUM`: A medium shimmer cycle with a duration of 5000 milliseconds (5 seconds).  
  - `LONG`: A long shimmer cycle with a duration of 8000 milliseconds (8 seconds).  
  - `CUSTOM`: A custom shimmer cycle duration defined by the user.

- 🔂 **Repeat Mode**  
  Customize the repeat behavior of the shimmer effect. Choose whether the shimmer should repeat indefinitely, once, or a specific number of times.
  - `INFINITE`: The shimmer effect will repeat indefinitely.  
  - `ONCE`: The shimmer effect will repeat only once.  
  - `CUSTOM`: The shimmer effect will repeat a specified number of times.
  
- ⏳ **Repeat Delay**  
  Add a delay before the shimmer effect starts repeating. By default, there is no delay, but you can configure it to introduce pauses between cycles.
  - `ZERO`: No delay between shimmer repetitions.  
  - `SHORT`: A short delay of 100 milliseconds between repetitions.  
  - `MEDIUM`: A medium delay of 300 milliseconds between repetitions.  
  - `LONG`: A long delay of 500 milliseconds between repetitions.  
  - `CUSTOM`: A custom delay defined by the user in milliseconds.
  
- ⏰ **Start Delay**  
  Set a delay before the shimmer effect starts after being triggered. The default is no delay, but you can add a delay if necessary.
  - `ZERO`: No delay before the shimmer effect starts.  
  - `SHORT`: A short delay of 1000 milliseconds (1 second) before the shimmer effect starts.  
  - `MEDIUM`: A medium delay of 3000 milliseconds (3 seconds) before the shimmer effect starts.  
  - `LONG`: A long delay of 5000 milliseconds (5 seconds) before the shimmer effect starts.  
  - `CUSTOM`: A custom delay defined by the user, in milliseconds.

- ↔️ **Direction Control**  
  Choose the direction of the shimmer effect. It can move horizontally or vertically. The default direction is horizontal.
  - `TOP_TO_BOTTOM`: Shimmer moves from top to bottom.
  - `BOTTOM_TO_TOP`: Shimmer moves from bottom to top.
  - `HORIZONTALLY`: Shimmer moves horizontally, i.e., from left to right or right to left.

- 🎭 **Effect Type**  
  Select the type of shimmer effect—either a linear or radial gradient. The default effect is a linear gradient.
  - `LINEAR`: A linear shimmer effect, where the shimmer moves along a straight line, typically from one end to the other in a horizontal or vertical direction.
  - `RADIAL`: A radial shimmer effect, where the shimmer moves outward from a central point in a circular pattern.

- 💥 **Intensity Control**  
  Adjust the intensity of the shimmer effect. The intensity determines how strong the shimmer appears, affecting the alpha of the colors. The default is full intensity, but you can decrease it for a more subtle effect.
```kotlin
	ZERO        = 0.0f   // No shimmer, completely transparent.  
	VERY_LOW    = 0.1f   // Very subtle shimmer, with minimal transparency.  
	LOW         = 0.2f   // Slight shimmer, still very subtle.  
	SLIGHT      = 0.3f   // Noticeable shimmer, but still subtle.  
	MEDIUM_LOW  = 0.4f   // Moderate shimmer, noticeable but not overwhelming.  
	MEDIUM      = 0.5f   // Standard shimmer effect, balanced visibility.  
	MEDIUM_HIGH = 0.6f   // Strong shimmer, more pronounced.  
	HIGH        = 0.7f   // Vivid shimmer, with high opacity.  
	VERY_HIGH   = 0.8f   // Very strong shimmer, very prominent.  
	EXTREME     = 0.9f   // Extreme shimmer effect, nearly full opacity.  
	FULL        = 1.0f   // Maximum shimmer intensity, fully visible.  
```

- 🔲 **Customizable Shape**  
  Apply the shimmer effect to different shapes. By default, it uses a rounded corner shape with a 16dp radius, but you can customize it to fit any shape, from square to circular.

These features allow you to fully customize the shimmer effect to match your app's design and behavior requirements.


## 🛠 Installation
**Step 1.**  Add it in your root setting.gradle at the end of repositories: 
```groovy
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()

                        // Include JitPack, a repository that allows you to fetch dependencies from GitHub projects.
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2.**  Add the dependency

```groovy
// This dependencies block is for the build.gradle
dependencies {
    implementation 'com.github.zaminalirustamov:ShimmerAnimation-Compose:1.0.0'
}
```
## 🚀 Usage
<p align="center">
	<i>
Custom Modifier extension to apply a shimmer effect to a Composable. The shimmer effect is applied based on the given ShimmerEffectConfig configuration. This modifier handles the shimmer animation, color adjustments, duration, cycle, repeat mode, and direction. This parameter is used to customize the shimmer effect. The default value is ShimmerEffectConfig. This modifier applies the shimmer effect to the composable.
	</i>
</p>

### Example:
**1. Applying Default Shimmer Effect to a `Box`:**  
```kotlin
Box(
    modifier = Modifier
        .fillMaxSize()
        // Default shimmer effect with default configuration
        .shimmerEffect()
) {
    // Content inside this Box will have a shimmer effect applied
} 
```
**2. Applying Custom Shimmer Effect to `Text` with Specific Colors and Duration:**  
```kotlin  
Text(
    text = "Shimmering Text",
    modifier = Modifier
        .shimmerEffect(
            config = ShimmerEffectConfig(
                // Blue to Red shimmer
                colors = listOf(Color(0xFF0000FF), Color(0xFFFF0000)),
                // 1 second duration
                duration = ShimmerDuration.MEDIUM,
                // HIGH = 0.7f
                intensity = ShimmerIntensity.HIGH
            )
        )
)
```
**3. Applying Shimmer Effect to a `Column` with Vertical Layout:**  
```kotlin  
Column(
    modifier = Modifier
        .fillMaxSize()
        .shimmerEffect(
             ShimmerEffectConfig(
                 direction = ShimmerDirection.TOP_TO_BOTTOM
             )
        )
) {
    // Content in this Column will shimmer with vertical movement
}
```
**4. Adding Shimmer Effect to a `Button` with Custom `cycleDuration`, `repeatMode`, `repeatDelay`, and `startDelay`:**  
```kotlin  
Button(
    onClick = { /* Do something */ },
    modifier = Modifier
        .padding(16.dp)
        .shimmerEffect(
            config = ShimmerEffectConfig(
                // 8 seconds duration
                cycleDuration = ShimmerCycleDuration.LONG,
                // Repeat only once
                repeatMode = ShimmerRepeatMode.ONCE,
                // 300 milliseconds delay
                repeatDelay = ShimmerRepeatDelay.MEDIUM,
                // 1 second delay
                startDelay = ShimmerStartDelay.SHORT
            )
        )
) {
    Text("Click Me")
}
```
**5. Applying Shimmer Effect to a `Card` with Custom Shape:**  
```kotlin  
Card(
    modifier = Modifier
        .fillMaxSize()
        // Custom rounded corners
        .shimmerEffect(
             config = ShimmerEffectConfig(
                         shape = RoundedCornerShape(12.dp)
                      )
        )
) {
    Text("Shimmering Card Content")
}
```

<p align="end">
  <u>For more examples, check out the code.</u>
</p>


## 🤝 Contribution
We highly appreciate and welcome any contributions to this project, whether it's reporting issues, suggesting new features, submitting pull requests, or even starring the repository! Your contributions help make this project better.

- **Report Issues**: If you find any bugs or have suggestions, feel free to open an issue.
- **Feature Requests**: If you have ideas for new features, don't hesitate to let us know.
- **Pull Requests**: We welcome pull requests for improvements and bug fixes.
- **GitHub Stars**: If you like this project, a star goes a long way in supporting it.



## ☕ Support

<p align="center"> 
<strong>
<em>✨ If you enjoy this project and want to support me, consider buying me a coffee! ☕
</em>
</strong>
</p>
<p align="center"> 
 Your support helps me continue working on improving this project and bringing new features to life. Every cup counts! 
</p>

<p align="center">
  <a href="https://www.buymeacoffee.com/zaminalirustamov" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" style="height: 120px !important;width: 434px !important;">
  </a>
</p>

## 📝 License
This project is licensed under the **[MIT License](https://opensource.org/licenses/MIT)**
By using this project, you agree to the terms outlined in the license.
