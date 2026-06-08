# WebView Bottom Sheet Demo

<div align="center">
  <img src="https://github.com/kibotu/WebViewBottomSheet/raw/main/app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp" width="200" alt="WebView Bottom Sheet">
  <br><br>
  <a href="https://play.google.com/store/apps/details?id=net.kibotu.webviewbottomsheet" target="_blank">
    <img src="https://img.shields.io/badge/GET%20IT%20ON-Purple-tdn.svg" alt="Get it on Google Play">
  </a>
  <br><br>
  <a href="https://github.com/kibotu/WebViewBottomSheet/actions" target="_blank">
    <img src="https://github.com/kibotu/WebViewBottomSheet/actions/workflows/build.yml/badge.svg" alt="Build Status">
  </a>
  <a href="https://github.com/kibotu/WebViewBottomSheet" target="_blank">
    <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License">
  </a>
</div>

---

## 🚀 What is WebView Bottom Sheet?

**WebView Bottom Sheet** is a clean, minimal demonstration of Android's powerful `WebView` component housed within a Material Design **Bottom Sheet**. It showcases how to elegantly integrate web content into your native Android app while maintaining a modern, user-friendly interface.

This project serves as a reference implementation for developers exploring the intersection of native Android development and web technologies.

---

## 💡 Why Use WebView in a Bottom Sheet?

### The Problem

Many Android developers struggle with:
- ✅ Seamlessly embedding web views
- ✅ Managing memory and lifecycle correctly
- ✅ Creating intuitive user interactions
- ✅ Maintaining native app feel

### The Solution

A beautifully crafted example demonstrating best practices for:
- 📱 **Native-feeling UI** — Bottom sheets slide smoothly from the bottom
- 🔄 **Proper lifecycle management** — WebView handles pause/resume/destroy correctly
- 🎨 **Material Design 3** — Modern, polished aesthetics
- ⚡ **Performance** — Optimized memory and resource usage
- 🌐 **Full web support** — JavaScript, DOM, media playback enabled

---

## ✨ Key Features

| Feature | Description |
|---------|-------------|
| **Material Design 3** | Modern Material You theming with custom colors |
| **Bottom Sheet Dialog** | Smooth, gesture-driven animations |
| **Full WebView Support** | JavaScript, DOM storage, zoom controls |
| **Edge-to-Edge Display** | Immersive UI experience |
| **Proper Cleanup** | Memory-efficient WebView destruction |
| **Intercept Handling** | Parent scroll intercept logic |
| **Transparent Background** | Clean visual integration |

---

## 🛠️ Tech Stack

<div align="center">
  <img src="https://img.shields.io/badge/Android-3--4--A--2--4--9--C-blue.svg?style=flat-square&logo=android" alt="Android">
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=kotlin" alt="Kotlin">
  <img src="https://img.shields.io/badge/Compose-4285F4?style=flat-square&logo=android" alt="Jetpack Compose">
  <img src="https://img.shields.io/badge/Material%20You-3--4--A--2--4--9--C-blue.svg?style=flat-square&logo=materialdesign" alt="Material You">
</div>

### Core Dependencies

- **AndroidX Core** — Foundation utilities
- **Jetpack Compose** — Modern UI toolkit
- **Material 3 Components** — Beautiful UI elements
- **WebView** — Full web rendering capabilities
- **Fragment** — Bottom sheet dialog support

---

## 📦 Getting Started

### Prerequisites

- **Android Studio** — Arctic Fox 2020.3.1 or later
- **JDK 17** — Required for compilation
- **Android SDK** — API 24+ (minSdk)
- **Git** — For cloning the repository

### Quick Start

```bash
# Clone the repository
git clone https://github.com/kibotu/WebViewBottomSheet.git
cd WebViewBottomSheet

# Install dependencies
./gradlew dependencies

# Build debug APK
./gradlew assembleDebug

# Install on device
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Build Configuration

The project uses:
- **Kotlin DSL** — Modern build scripting
- **Gradle Caching** — Optimized build times
- **Daemon Enabled** — Faster incremental builds
- **Configuration Cache** — Consistent builds across environments

---

## 🚀 Installation

### Debug Build

1. Connect your device or start an emulator
2. Run the app:
   ```bash
   ./gradlew installDebug
   ```

### Release Build

```bash
./gradlew assembleRelease
```

> **Note:** Release builds require signing configuration in `local.properties`

### Deploy to Device

```bash
# Install APK
adb install app/build/outputs/apk/debug/app-debug.apk

# Install and replace
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

---

## 🎯 How It Works

### Architecture Overview

```
MainActivity
├── StartScreen (Compose UI)
└── WebViewBottomSheetFragment (Bottom Sheet Dialog)
    └── WebView (Full web rendering)
```

### Key Implementation Details

#### Bottom Sheet Dialog

```kotlin
class WebViewBottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), R.style.WebViewBottomSheet)
}
```

#### WebView Configuration

```kotlin
web.settings.apply {
    javaScriptEnabled = true
    domStorageEnabled = true
    loadWithOverviewMode = true
    useWideViewPort = true
    mediaPlaybackRequiresUserGesture = false
}
```

#### Lifecycle Management

```kotlin
override fun onDestroyView() {
    webView?.apply {
        stopLoading()
        loadUrl("about:blank")
        (parent as? ViewGroup)?.removeView(this)
        destroy()
    }
    webView = null
}
```

---

## 📁 Project Structure

```
WebViewBottomSheet/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/net/kibotu/webviewbottomsheet/
│   │       │   ├── MainActivity.kt
│   │       │   └── WebViewBottomSheetFragment.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── fragment_webview_bottom_sheet.xml
│   │       │   ├── values/
│   │       │   │   ├── colors.xml
│   │       │   │   ├── strings.xml
│   │       │   │   └── themes.xml
│   │       │   └── xml/
│   │       │       ├── backup_rules.xml
│   │       │       └── data_extraction_rules.xml
│   │       └── keepRules/
│   │           └── rules.keep
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

---

## 🧪 Testing

### Unit Tests

```bash
./gradlew test
```

### Instrumentation Tests

```bash
./gradlew connectedAndroidTest
```

### Linting

```bash
./gradlew lint
```

---

## 🌐 Demo URL

The app loads: **https://trail.kibotu.net**

> This demonstrates a fully functional WebView with JavaScript and interactive content.

---

## 📜 License

```
MIT License

Copyright (c) 2024 kibotu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
```

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork** the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Style

- ✅ Kotlin idiomatic patterns
- ✅ Material Design guidelines
- ✅ Android best practices
- ✅ Clear, concise comments

---

## 📞 Support

Having issues or questions? Open an [issue](https://github.com/kibotu/WebViewBottomSheet/issues) on GitHub.

---

<div align="center">

**Made with ❤️ by kibotu**

<div>
  <a href="https://github.com/kibotu">
    <img src="https://img.shields.io/badge/GitHub-kibotu-181717?style=flat-square&logo=github" alt="GitHub">
  </a>
</div>

</div>
