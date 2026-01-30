# instagram-clone-android

A fully functional Instagram clone built with Kotlin and Android Jetpack components, featuring a modern UI with Instagram-like design.

## 📸 Features

- **Home Feed** - Instagram-style feed with posts, likes, comments, and stories
- **Profile Page** - Complete user profile with posts grid, highlights, and stats
- **Reels Section** - Video/content reel interface with interactions
- **Search Page** - Simple search functionality
- **Bottom Navigation** - Instagram-like navigation between sections
- **Dark Theme** - Instagram-inspired dark theme UI
- **Interactive Elements** - Like, save, comment, share functionalities

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI**: XML with Material Design Components
- **Image Loading**: Glide
- **Architecture**: Fragments with RecyclerView
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 36 (Android 12)

## 📱 Screens

| Home Screen | Profile Screen | Reels Screen |
|------------|---------------|--------------|
| Stories + Feed | Profile Info + Posts Grid | Video Reels + Interactions |

## 🚀 Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/instagram-clone-android.git
Open in Android Studio

Build and run on emulator or device

📦 Dependencies
androidx.core:core-ktx

androidx.appcompat:appcompat

com.google.android.material:material

androidx.recyclerview:recyclerview

androidx.fragment:fragment-ktx

com.github.bumptech.glide:glide

de.hdodenhof:circleimageview

📁 Project Structure
text
app/
├── MainActivity.kt
├── adapters/
│   ├── FeedAdapter.kt
│   ├── StoryAdapter.kt
│   └── ReelsAdapter.kt
├── fragments/
│   ├── HomeFragment.kt
│   ├── ProfileFragment.kt
│   └── ReelsFragment.kt
└── res/
    ├── layout/ (all XML files)
    └── drawable/ (all images)
🎯 Key Components
RecyclerViews - For feed, stories, reels, and profile posts

Fragments - Separate UI components for each section

ViewBinding - Type-safe view access

Glide - Efficient image loading

Material Components - Modern UI elements

📝 Notes
This is a student project for educational purposes

Uses sample data for demonstration

All Instagram UI/UX patterns implemented

Responsive design for different screen sizes

👨‍💻 Developer
Ariba Shuaib
Mobile App Development Assignment - University Project

⚠️ Disclaimer
This project is created for educational purposes only. Instagram is a trademark of Meta Platforms, Inc. This project is not affiliated with or endorsed by Instagram.
