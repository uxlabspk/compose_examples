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
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/ProfileScreen.kt`

A complete user profile UI demonstrating:
- Circular profile images with Material 3
- Sectioned settings layout
- List items with icons and navigation
- Material Design theming
- Column layouts with proper spacing

### 2. **Row & Column Demo** 📐
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/RowColumnDemo.kt`

Demonstrates fundamental layout concepts:
- Vertical arrangement with `Column`
- Horizontal arrangement with `Row`
- Main and Cross axis alignment
- Space distribution (SpaceEvenly, SpaceBetween)
- Nested layouts

### 3. **Box Layout Demo** 📦
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/BoxDemo.kt`

Shows overlapping and stacking composables:
- Z-index layering
- Alignment properties (TopStart, TopEnd, CenterEnd, etc.)
- Circular shapes and borders
- Background colors and custom shapes
- Cut corner shapes

### 4. **Flow Layout Demo** 🌊
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/FlowLayoutDemo.kt`

Demonstrates responsive wrapping layouts:
- `FlowRow` for automatic line wrapping
- Tag-based UI patterns
- Spacing between items
- Maximum items per row configuration
- Responsive chip layouts

### 5. **String Styling Demo** ✍️
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/StringDemo.kt`

Advanced text styling techniques:
- **SpanStyle**: Inline text styling with different fonts, sizes, and colors
- **ParagraphStyle**: Line height, text indentation, and alignment
- **Brush/Gradient Text**: Multi-color gradient effects on text
- Annotated strings for complex text formatting

### 6. **Slot API Pattern** 🎯
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/SlotAPI.kt`

Demonstrates composable reusability with slots:
- Higher-order composables
- Content slots for flexible UI
- State hoisting
- Interactive checkboxes
- Toggle between different UI states (Linear/Circular progress, Image/Text)

### 7. **CompositionLocal Demo** 🌍
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/LocalDemoScreen.kt`

Shows how to share data implicitly across composables:
- Creating custom `CompositionLocal`
- Providing values with `CompositionLocalProvider`
- Theme-aware color switching
- Dark/Light mode handling

### 8. **Custom Layout - Modifier** 🔧
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/CustomLayout.kt`

Creating custom layout modifiers:
- Custom `layout` modifier implementation
- Manual positioning of composables
- Understanding the measure-and-place API
- Custom offset implementation

### 9. **Custom Layout - Composable** 🏗️
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/CustomLayoutComposable.kt`

Building custom layout composables from scratch:
- Cascade/Staircase layout pattern
- Using the `Layout` composable
- Measuring and placing children
- Custom spacing logic

### 10. **ConstraintLayout Demo** 🔗
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/ConstraintLayoutDemo.kt`

Advanced constraint-based layouts:
- Basic constraints with `constrainAs`
- Guidelines for proportional positioning
- Barriers for dynamic content alignment
- Chains with different styles (Spread, SpaceBetween, Packed)
- Complex layouts with minimal nesting

### 11. **Intrinsic Size Demo** 📏
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/IntrinsiveMeasureDemo.kt`

Understanding intrinsic measurements:
- `IntrinsicSize.Max` for matching widest child
- `IntrinsicSize.Min` for matching narrowest child
- Solving layout problems without custom layouts
- Automatic width/height synchronization
- Comparing layouts with and without intrinsic sizing

### 12. **Lazy Lists Demo** 📜
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/LazyListDemo.kt`

Efficient scrollable lists with lazy loading:
- `LazyColumn` for vertical scrolling lists
- `LazyRow` for horizontal scrolling lists
- `LazyVerticalGrid` with fixed and adaptive columns
- Programmatic scroll control
- Performance optimization with lazy composition
- Only renders visible items

### 13. **Grid Layouts Demo** 🎯
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/GridDemo.kt`

Advanced grid and scrollable layouts:
- Basic scrollable lists with `Column` + `verticalScroll`
- Programmatic scrolling with buttons
- Efficient `LazyColumn` for large datasets
- Fixed and adaptive grid layouts
- Card-based item layouts
- Scroll state management

### 14. **Swipeable Pager Demo** 📱
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/SwipeablePagerDemo.kt`

Horizontal and vertical paging with gestures:
- `HorizontalPager` for swipeable content
- `VerticalPager` for vertical scrolling pages
- Page indicators (dots)
- Animated page transitions
- Programmatic page navigation
- Multi-page layouts with Material 3

### 15. **Animations & Transitions** ✨
**Files**: 
- `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/AnimationDemo.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/TransitionsDemos.kt`

Comprehensive animation examples:
- `Crossfade` for smooth content transitions
- `animateColorAsState` for color animations
- `updateTransition` for coordinated multi-property animations
- `rememberInfiniteTransition` for continuous animations
- Spring, Tween, and custom animation specs
- Icon morphing and state-based animations

### 16. **Gestures Demo** 👆
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/GesturesDemo.kt`

Touch gesture handling and interactions:
- Tap gestures (single, double, long press)
- Drag gestures with `detectDragGestures`
- Draggable modifier for constrained dragging
- Transformable gestures (pinch, zoom, rotate)
- Multi-touch interactions
- Gesture state management

### 17. **ViewModel Integration** 🏛️
**Files**:
- `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/ViewModelDemo.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/viewmodel/MyViewModel.kt`

Architecture components with Compose:
- ViewModel with StateFlow
- State hoisting with ViewModel
- Collecting flows in Compose
- Separation of UI and business logic
- Counter example with increment/decrement

### 18. **Temperature Converter** 🌡️
**Files**:
- `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/TemperatureConverterDemo.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/viewmodel/TemperatureConverterViewModel.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/data/model/TemperatureUiState.kt`

Practical real-world app example:
- Bidirectional data binding
- Celsius to Fahrenheit conversion
- Fahrenheit to Celsius conversion
- ViewModel with StateFlow
- Real-time input validation
- Material 3 TextField usage

### 19. **Kotlin Flows Demo** 🌊
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/KotlinFlows.kt`

Reactive programming with Kotlin Flows:
- Cold Flow basics
- StateFlow for UI state management
- SharedFlow for events
- Combining multiple flows
- Flow operators (map, filter, debounce)
- Collecting flows in Compose
- Practical examples with ViewModels

### 20. **Coroutines & Side Effects** ⚡
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/CoroutinesDemo.kt`

Asynchronous programming in Compose:
- `rememberCoroutineScope` for manual coroutine launching
- `LaunchedEffect` for automatic side effects
- `DisposableEffect` for cleanup
- `derivedStateOf` for computed state
- Async data loading
- Cancellation handling
- Lifecycle-aware coroutines

### 21. **Room Database Demo** 💾
**Files**:
- `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/ProductDatabaseScreen.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/viewmodel/ProductViewModel.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/data/repository/ProductRepository.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/data/database/ProductRoomDatabase.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/data/dao/ProductDao.kt`
- `app/src/main/java/com/codehuntspk/compose_examples/data/model/Product.kt`

Complete database integration example:
- Room database setup
- DAO (Data Access Object) patterns
- Entity definitions
- Product CRUD operations (Create, Read, Update, Delete)
- LiveData with Compose
- Search functionality
- Real-time database updates
- Material 3 UI for database operations

### 22. **Canvas & Custom Drawing** 🎨
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/CanvasDemo.kt`

Advanced drawing and graphics with Canvas:
- Drawing shapes (lines, rectangles, circles, arcs)
- Custom paths and bezier curves
- Gradient brushes and color effects
- Stroke and fill styles
- Drawing text on canvas
- Transformations (rotate, scale, translate)
- Animated drawings
- Complex custom visualizations

### 23. **Responsive Layouts** 📱💻
**File**: `app/src/main/java/com/codehuntspk/compose_examples/ui/screens/Responsive.kt`

Building adaptive UIs for different screen sizes:
- WindowSizeClass for responsive design
- Compact layout (phone portrait)
- Medium layout (phone landscape/tablet portrait)
- Expanded layout (tablet landscape/desktop)
- Adaptive navigation (bottom bar vs. navigation rail vs. drawer)
- Grid column adaptation based on screen size
- Material 3 adaptive components

## 🛠️ Tech Stack

- **Language**: Kotlin 2.0.21
- **UI Framework**: Jetpack Compose (2024.09.00)
- **Architecture Components**: 
  - ViewModel
  - LiveData
  - Room Database
  - Kotlin Flows & Coroutines
- **Build System**: Gradle (Kotlin DSL)
- **Minimum SDK**: 26 (Android 8.0)
- **Target SDK**: 36
- **Material Design**: Material 3 (Material You)


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
│   │   │   │   ├── data/                        # Data layer
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   └── ProductDao.kt        # Room DAO for Product
│   │   │   │   │   ├── database/
│   │   │   │   │   │   └── ProductRoomDatabase.kt # Room database setup
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── Product.kt           # Product entity
│   │   │   │   │   │   ├── TemperatureUiState.kt # Temperature converter state
│   │   │   │   │   │   └── EditField.kt         # Edit field model
│   │   │   │   │   └── repository/
│   │   │   │   │       └── ProductRepository.kt # Product repository
│   │   │   │   ├── viewmodel/                   # ViewModels
│   │   │   │   │   ├── MyViewModel.kt           # Demo ViewModel
│   │   │   │   │   ├── ProductViewModel.kt      # Product database ViewModel
│   │   │   │   │   └── TemperatureConverterViewModel.kt # Temperature ViewModel
│   │   │   │   └── ui/
│   │   │   │       ├── screens/
│   │   │   │       │   ├── AnimationDemo.kt     # Animations & transitions
│   │   │   │       │   ├── BoxDemo.kt           # Box layout examples
│   │   │   │       │   ├── CanvasDemo.kt        # Canvas & custom drawing
│   │   │   │       │   ├── ConstraintLayoutDemo.kt  # ConstraintLayout examples
│   │   │   │       │   ├── CoroutinesDemo.kt    # Coroutines & side effects
│   │   │   │       │   ├── CustomLayout.kt      # Custom layout modifiers
│   │   │   │       │   ├── CustomLayoutComposable.kt # Custom layout composables
│   │   │   │       │   ├── FlowLayoutDemo.kt    # FlowRow examples
│   │   │   │       │   ├── GesturesDemo.kt      # Gesture handling
│   │   │   │       │   ├── GridDemo.kt          # Grid layouts
│   │   │   │       │   ├── IntrinsiveMeasureDemo.kt # Intrinsic size examples
│   │   │   │       │   ├── KotlinFlows.kt       # Kotlin Flows demo
│   │   │   │       │   ├── LazyListDemo.kt      # Lazy lists (Column, Row, Grid)
│   │   │   │       │   ├── LocalDemoScreen.kt   # CompositionLocal demo
│   │   │   │       │   ├── ProductDatabaseScreen.kt # Room database demo
│   │   │   │       │   ├── ProfileScreen.kt     # Profile UI example
│   │   │   │       │   ├── Responsive.kt        # Responsive layouts
│   │   │   │       │   ├── RowColumnDemo.kt     # Row/Column layouts
│   │   │   │       │   ├── SlotAPI.kt           # Slot pattern demo
│   │   │   │       │   ├── StringDemo.kt        # Text styling
│   │   │   │       │   ├── SwipeablePagerDemo.kt # Horizontal/Vertical pager
│   │   │   │       │   ├── TemperatureConverterDemo.kt # Temperature converter
│   │   │   │       │   ├── TransitionsDemos.kt  # Additional transitions
│   │   │   │       │   └── ViewModelDemo.kt     # ViewModel integration
│   │   │   │       └── theme/
│   │   │   │           ├── Color.kt             # Color definitions
│   │   │   │           ├── Theme.kt             # App theme
│   │   │   │           └── Type.kt              # Typography
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

### Beginner Level
1. **RowColumnDemo** - Learn basic layouts and alignment
2. **BoxDemo** - Understand overlapping and stacking
3. **FlowLayoutDemo** - Explore responsive wrapping layouts
4. **StringDemo** - Master text styling techniques
5. **ProfileScreen** - See a real-world UI example

### Intermediate Level
6. **SlotAPI** - Learn about composable reusability
7. **LocalDemoScreen** - Understand implicit data sharing
8. **LazyListDemo** - Efficient scrolling lists
9. **GridDemo** - Advanced grid layouts
10. **ConstraintLayoutDemo** - Constraint-based layouts
11. **IntrinsiveMeasureDemo** - Master intrinsic size measurements

### Advanced Level
12. **CustomLayout** - Create custom layout modifiers
13. **CustomLayoutComposable** - Build custom layout composables
14. **AnimationDemo & TransitionsDemos** - Animations and transitions
15. **GesturesDemo** - Touch gesture handling
16. **CanvasDemo** - Custom drawing and graphics

### Architecture & State Management
17. **ViewModelDemo** - ViewModel integration
18. **TemperatureConverterDemo** - Real-world app with ViewModel
19. **KotlinFlows** - Reactive programming with Flows
20. **CoroutinesDemo** - Asynchronous programming
21. **ProductDatabaseScreen** - Room database integration

### Advanced UI Patterns
22. **SwipeablePagerDemo** - Paging and gestures
23. **Responsive** - Adaptive layouts for different screen sizes

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

## 📚 Quick Reference

### File Location Finder

| Concept | File Location |
|---------|--------------|
| **UI Screens** | |
| Profile Screen | `ui/screens/ProfileScreen.kt` |
| Row & Column Layouts | `ui/screens/RowColumnDemo.kt` |
| Box Layout | `ui/screens/BoxDemo.kt` |
| Flow Layout | `ui/screens/FlowLayoutDemo.kt` |
| Grid Layouts | `ui/screens/GridDemo.kt` |
| Lazy Lists | `ui/screens/LazyListDemo.kt` |
| Swipeable Pager | `ui/screens/SwipeablePagerDemo.kt` |
| Responsive Layouts | `ui/screens/Responsive.kt` |
| **Text & Styling** | |
| String Styling | `ui/screens/StringDemo.kt` |
| Typography | `ui/theme/Type.kt` |
| Colors | `ui/theme/Color.kt` |
| Theme | `ui/theme/Theme.kt` |
| **Advanced Layouts** | |
| ConstraintLayout | `ui/screens/ConstraintLayoutDemo.kt` |
| Intrinsic Measure | `ui/screens/IntrinsiveMeasureDemo.kt` |
| Custom Layout Modifier | `ui/screens/CustomLayout.kt` |
| Custom Layout Composable | `ui/screens/CustomLayoutComposable.kt` |
| **Compose Patterns** | |
| Slot API | `ui/screens/SlotAPI.kt` |
| CompositionLocal | `ui/screens/LocalDemoScreen.kt` |
| **Animation & Interaction** | |
| Animations | `ui/screens/AnimationDemo.kt` |
| Transitions | `ui/screens/TransitionsDemos.kt` |
| Gestures | `ui/screens/GesturesDemo.kt` |
| Canvas Drawing | `ui/screens/CanvasDemo.kt` |
| **Architecture** | |
| ViewModel Demo | `ui/screens/ViewModelDemo.kt` |
| ViewModel (Class) | `viewmodel/MyViewModel.kt` |
| Temperature Converter | `ui/screens/TemperatureConverterDemo.kt` |
| Temperature ViewModel | `viewmodel/TemperatureConverterViewModel.kt` |
| Temperature State | `data/model/TemperatureUiState.kt` |
| **Async & State** | |
| Kotlin Flows | `ui/screens/KotlinFlows.kt` |
| Coroutines & Side Effects | `ui/screens/CoroutinesDemo.kt` |
| **Database** | |
| Product Database UI | `ui/screens/ProductDatabaseScreen.kt` |
| Product ViewModel | `viewmodel/ProductViewModel.kt` |
| Product Repository | `data/repository/ProductRepository.kt` |
| Product DAO | `data/dao/ProductDao.kt` |
| Product Entity | `data/model/Product.kt` |
| Room Database | `data/database/ProductRoomDatabase.kt` |
| Edit Field Model | `data/model/EditField.kt` |

> **Note**: All file paths are relative to `app/src/main/java/com/codehuntspk/compose_examples/`

## 🗺️ Roadmap

Future examples to be added:
- [ ] Navigation Compose integration
- [ ] Paging 3 with Compose
- [ ] Material 3 components showcase (Tabs, Chips, etc.)
- [ ] Network integration (Retrofit, OkHttp)
- [ ] Image loading (Coil)
- [ ] Dependency Injection (Hilt/Koin)
- [ ] WorkManager integration
- [ ] DataStore preferences
- [ ] Compose testing examples

---

⭐ If you find this project helpful, please consider giving it a star!

**Happy Composing! 🚀**

