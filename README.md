# Jetpack Compose Examples

A comprehensive Android application demonstrating various Jetpack Compose concepts and UI patterns. This project serves as a learning resource and reference for developers getting started with or advancing their knowledge of Jetpack Compose.

[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-purple.svg)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.09.00-green.svg)](https://developer.android.com/jetpack/compose)
[![API](https://img.shields.io/badge/API-26%2B-brightgreen.svg)](https://android-arsenal.com/api?level=26)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

## 📱 About

This project showcases practical examples of building modern Android UIs using Jetpack Compose, Google's modern toolkit for building native UI. Each screen demonstrates different Compose concepts, from basic layouts to advanced custom composables.

## ✨ Features

The application includes the following example screens:

### 1. **Profile Screen** 🎨
A complete user profile UI demonstrating:
- Circular profile images with Material 3
- Sectioned settings layout
- List items with icons and navigation
- Material Design theming
- Column layouts with proper spacing

### 2. **Row & Column Demo** 📐
Demonstrates fundamental layout concepts:
- Vertical arrangement with `Column`
- Horizontal arrangement with `Row`
- Main and Cross axis alignment
- Space distribution (SpaceEvenly, SpaceBetween)
- Nested layouts

### 3. **Box Layout Demo** 📦
Shows overlapping and stacking composables:
- Z-index layering
- Alignment properties (TopStart, TopEnd, CenterEnd, etc.)
- Circular shapes and borders
- Background colors and custom shapes
- Cut corner shapes

### 4. **Flow Layout Demo** 🌊
Demonstrates responsive wrapping layouts:
- `FlowRow` for automatic line wrapping
- Tag-based UI patterns
- Spacing between items
- Maximum items per row configuration
- Responsive chip layouts

### 5. **String Styling Demo** ✍️
Advanced text styling techniques:
- **SpanStyle**: Inline text styling with different fonts, sizes, and colors
- **ParagraphStyle**: Line height, text indentation, and alignment
- **Brush/Gradient Text**: Multi-color gradient effects on text
- Annotated strings for complex text formatting

### 6. **Slot API Pattern** 🎯
Demonstrates composable reusability with slots:
- Higher-order composables
- Content slots for flexible UI
- State hoisting
- Interactive checkboxes
- Toggle between different UI states (Linear/Circular progress, Image/Text)

### 7. **CompositionLocal Demo** 🌍
Shows how to share data implicitly across composables:
- Creating custom `CompositionLocal`
- Providing values with `CompositionLocalProvider`
- Theme-aware color switching
- Dark/Light mode handling

### 8. **Custom Layout - Modifier** 🔧
Creating custom layout modifiers:
- Custom `layout` modifier implementation
- Manual positioning of composables
- Understanding the measure-and-place API
- Custom offset implementation

### 9. **Custom Layout - Composable** 🏗️
Building custom layout composables from scratch:
- Cascade/Staircase layout pattern
- Using the `Layout` composable
- Measuring and placing children
- Custom spacing logic

## 🛠️ Tech Stack

- **Language**: Kotlin 2.0.21
- **UI Framework**: Jetpack Compose
- **Architecture**: Single Activity, Composable-based navigation
- **Build System**: Gradle (Kotlin DSL)
- **Minimum SDK**: 26 (Android 8.0)
- **Target SDK**: 36


## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/compose_examples.git
cd compose_examples
```

### Open in Android Studio

1. Launch Android Studio
2. Select "Open an Existing Project"
3. Navigate to the cloned repository
4. Wait for Gradle sync to complete

### Run the App

1. Connect an Android device or start an emulator (API 26+)
2. Click the "Run" button (▶️) in Android Studio
3. Select your target device
4. The app will build and install automatically

## 📂 Project Structure

```
compose_examples/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/codehuntspk/compose_examples/
│   │   │   │   ├── MainActivity.kt              # Main entry point
│   │   │   │   └── ui/
│   │   │   │       ├── screens/
│   │   │   │       │   ├── ProfileScreen.kt     # Profile UI example
│   │   │   │       │   ├── RowColumnDemo.kt     # Row/Column layouts
│   │   │   │       │   ├── BoxDemo.kt           # Box layout examples
│   │   │   │       │   ├── FlowLayoutDemo.kt    # FlowRow examples
│   │   │   │       │   ├── StringDemo.kt        # Text styling
│   │   │   │       │   ├── SlotAPI.kt           # Slot pattern demo
│   │   │   │       │   ├── LocalDemoScreen.kt   # CompositionLocal
│   │   │   │       │   ├── CustomLayout.kt      # Custom modifiers
│   │   │   │       │   └── CustomLayoutComposable.kt # Custom layouts
│   │   │   │       └── theme/
│   │   │   │           ├── Color.kt
│   │   │   │           ├── Theme.kt
│   │   │   │           └── Type.kt
│   │   │   ├── res/                             # Resources (drawables, strings, etc.)
│   │   │   └── AndroidManifest.xml
│   │   ├── test/                                # Unit tests
│   │   └── androidTest/                         # Instrumented tests
│   └── build.gradle.kts                         # App-level build config
├── gradle/
│   └── libs.versions.toml                       # Version catalog
├── build.gradle.kts                             # Project-level build config
└── settings.gradle.kts                          # Project settings
```

## 🎓 Learning Path

If you're new to Jetpack Compose, we recommend exploring the examples in this order:

1. **RowColumnDemo** - Learn basic layouts and alignment
2. **BoxDemo** - Understand overlapping and stacking
3. **FlowLayoutDemo** - Explore responsive wrapping layouts
4. **StringDemo** - Master text styling techniques
5. **ProfileScreen** - See a real-world UI example
6. **SlotAPI** - Learn about composable reusability
7. **LocalDemoScreen** - Understand implicit data sharing
8. **CustomLayout** - Create custom layout modifiers
9. **CustomLayoutComposable** - Build custom layout composables


## 🎨 Material 3 Theming

The app uses Material 3 design principles with:
- Dynamic color scheme support
- Typography scaling
- Consistent spacing and elevation
- Material You components


## 📝 Best Practices Demonstrated

- ✅ State hoisting for better testability
- ✅ Reusable composables with slot API
- ✅ Proper separation of concerns
- ✅ Preview annotations for rapid development
- ✅ Material 3 design system
- ✅ Modifier chains for styling
- ✅ Custom layouts when needed
- ✅ CompositionLocal for implicit data passing

## 🤝 Contributing

Contributions are welcome! If you'd like to add more examples or improve existing ones:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewExample`)
3. Commit your changes (`git commit -m 'Add new example'`)
4. Push to the branch (`git push origin feature/NewExample`)
5. Open a Pull Request

### Contribution Guidelines

- Follow Kotlin coding conventions
- Add preview functions for all composables
- Document complex logic with comments
- Ensure code passes lint checks
- Add your example to this README


## 🔗 Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Compose Pathway](https://developer.android.com/courses/pathways/compose)
- [Material 3 Guidelines](https://m3.material.io/)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)

## 👨‍💻 Author

**Muhammad Naveed**
- Email: naveed@codehuntspk.com

## 🌟 Acknowledgments

- Google Compose team for the amazing framework
- Android developer community for inspiration
- Material Design team for design guidelines


## 🗺️ Roadmap

Future examples to be added:
- [ ] Navigation Compose integration
- [ ] Animations and transitions
- [ ] Lazy lists (LazyColumn, LazyRow, LazyGrid)
- [ ] ViewModel integration
- [ ] Side effects (LaunchedEffect, DisposableEffect)
- [ ] Gesture handling
- [ ] Canvas and custom drawing
- [ ] Paging 3 with Compose
- [ ] Material 3 components showcase

---

⭐ If you find this project helpful, please consider giving it a star!

**Happy Composing! 🚀**

