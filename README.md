# ArtSpace App 🎨

ArtSpace App is an Android application built using **Jetpack Compose** that showcases a simple art gallery experience. Users can browse through artworks using navigation buttons, view artwork details, and interact with a clean, card-based UI inspired by Material Design.

This project focuses on understanding **state-driven UI**, **layout composition**, and **user interaction patterns** in Jetpack Compose.

---

## 📱 Features

- Centered artwork display inside a white “art wall” with elevation
- Navigate between artworks using **Previous** and **Next** buttons
- Display artwork details below the image
- Page number shown on the artwork card
- Responsive layout with proper alignment and spacing
- Vertical scrolling support for smaller screens
- Modular and reusable composable functions

---

## 🛠️ Tech Stack

- **Language:** Kotlin  
- **UI Toolkit:** Jetpack Compose  
- **Design System:** Material 3  
- **Build Tool:** Gradle  
- **IDE:** Android Studio  
- **Version Control:** Git & GitHub  

---

## 🧠 Key Concepts Practiced

- State management using `remember` and `mutableStateOf`
- Derived UI state based on a single source of truth (`pageNo`)
- Composable decomposition for cleaner and maintainable UI
- Layout control using `Column`, `Row`, `Box`, and `Spacer`
- Use of `Surface` for card-style UI with shadow and elevation
- Handling vertical scrolling with `verticalScroll`

---

## 🔄 Navigation Logic

- A `pageNo` state variable controls which artwork is displayed.
- Image and details update automatically when the page number changes.
- Navigation buttons are enabled or disabled based on valid bounds to prevent invalid navigation.

---

## 🖼️ UI Overview

- **Artwork Wall:** A centered white surface with rounded corners and shadow containing the artwork image.
- **Details Section:** Displays artwork title or description below the image.
- **Navigation Controls:** Previous and Next buttons placed at the bottom for easy access.

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest stable version)
- Android SDK 21 or higher

### Run the App
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/ArtSpaceApp.git
   ```
2. Open the project in Android Studio
3. Let Gradle sync complete
4. Run the app on an emulator or physical device
