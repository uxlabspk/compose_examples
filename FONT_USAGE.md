# Custom Font Family Usage Guide

## Overview
Your app now uses **Poppins** as the default font family throughout the entire application. This is configured in `Type.kt` and applied via the MaterialTheme.

## How It Works

### 1. Font Family Definition
The `PoppinsFontFamily` in `Type.kt` includes all Poppins font weights:
- Thin (100)
- ExtraLight (200)
- Light (300)
- Regular (400)
- Medium (500)
- SemiBold (600)
- Bold (700)
- ExtraBold (800)
- Black (900)
- All italic variants

### 2. Material 3 Typography
All Material 3 typography styles automatically use the Poppins font:
- Display (Large, Medium, Small)
- Headline (Large, Medium, Small)
- Title (Large, Medium, Small)
- Body (Large, Medium, Small)
- Label (Large, Medium, Small)

## Usage in Composables

### Using Material Typography Styles (Recommended)
```kotlin
@Composable
fun MyScreen() {
    Column {
        // Display text
        Text(
            text = "Welcome",
            style = MaterialTheme.typography.displayLarge
        )
        
        // Headline text
        Text(
            text = "Section Title",
            style = MaterialTheme.typography.headlineMedium
        )
        
        // Body text
        Text(
            text = "This is regular body text",
            style = MaterialTheme.typography.bodyLarge
        )
        
        // Label text
        Text(
            text = "Button",
            style = MaterialTheme.typography.labelLarge
        )
    }
}
```

### Direct Font Family Usage
If you need to use the font family directly with custom sizes:
```kotlin
@Composable
fun CustomText() {
    Text(
        text = "Custom styled text",
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}
```

### Changing Font Weight
```kotlin
Text(
    text = "Bold Text",
    style = MaterialTheme.typography.bodyLarge.copy(
        fontWeight = FontWeight.Bold
    )
)

Text(
    text = "Light Text",
    style = MaterialTheme.typography.bodyLarge.copy(
        fontWeight = FontWeight.Light
    )
)
```

## Benefits

✅ **Consistent Design**: All text throughout your app uses Poppins
✅ **Easy to Maintain**: Change once in Type.kt, applies everywhere
✅ **Material 3 Compatible**: Works seamlessly with Material Design 3
✅ **Full Weight Support**: All Poppins font weights available
✅ **Type Safety**: Compile-time checking for font resources

## Files Modified

1. **Type.kt**: Defines PoppinsFontFamily and applies it to all Typography styles
2. **Font files**: Renamed to follow Android naming conventions (lowercase with underscores)
   - Original: `Poppins-Bold.ttf`
   - New: `poppins_bold.ttf`

## Example Composable

```kotlin
@Composable
fun ExampleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Poppins Font",
            style = MaterialTheme.typography.displayLarge
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "All font weights",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        listOf(
            FontWeight.Thin to "Thin",
            FontWeight.Light to "Light",
            FontWeight.Normal to "Regular",
            FontWeight.Medium to "Medium",
            FontWeight.SemiBold to "SemiBold",
            FontWeight.Bold to "Bold",
            FontWeight.Black to "Black"
        ).forEach { (weight, name) ->
            Text(
                text = "Poppins $name",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = weight
                )
            )
        }
    }
}
```

## Notes

- The Theme.kt file already references `Typography`, so no changes needed there
- All existing Text composables in your app will automatically use Poppins
- You can still override font family on individual Text composables if needed

