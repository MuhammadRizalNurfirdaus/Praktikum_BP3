# Background Styles dan Tema - Aplikasi Data Mahasiswa

## 📋 Daftar Background Styles yang Tersedia

### 1. **Gradient Background Styles**

#### GradientBackgroundStyle
```xml
style="@style/GradientBackgroundStyle"
```
- Background dengan gradien purple-violet (135°)
- Cocok untuk background utama yang bold dan eye-catching
- Warna: #667eea → #764ba2

#### LightGradientBackgroundStyle  
```xml
style="@style/LightGradientBackgroundStyle"
```
- Background dengan gradien soft pastel (45°)
- Warna lembut: Light Indigo → Light Purple → Light Pink
- Cocok untuk background utama aplikasi (sudah diterapkan di activity_tentang.xml)

#### SoftGradientBackgroundStyle
```xml
style="@style/SoftGradientBackgroundStyle"
```
- Background dengan gradien vertikal soft colors (180°)
- Warna: Light Blue → Light Purple → Light Pink
- Sangat lembut untuk mata

#### OverlayBackgroundStyle
```xml
style="@style/OverlayBackgroundStyle"
```
- Background gradien dengan pattern overlay
- Memberikan efek depth dengan layer tambahan
- Cocok untuk header atau hero section

---

### 2. **Card Background Styles**

#### CardStyle (Default)
```xml
style="@style/CardStyle"
```
- Card putih standard dengan shadow
- Elevation: 4dp
- Corner radius: 12dp
- Background: Solid white

#### CardBackgroundStyle
```xml
style="@style/CardBackgroundStyle"
```
- Card dengan subtle gradient background
- Gradien vertikal: White → Light Gray
- Border 1dp abu-abu
- Corner radius: 12dp

#### EnhancedCardStyle
```xml
style="@style/EnhancedCardStyle"
```
- Card dengan shadow lebih tebal
- Elevation: 8dp
- Corner radius: 16dp
- Background: Transparent (bisa dikombinasi dengan container background)

#### ElevatedCardBackgroundStyle
```xml
style="@style/ElevatedCardBackgroundStyle"
```
- Card dengan efek elevated subtle
- Layer ganda untuk depth effect
- Corner radius: 16dp

---

### 3. **Special Background Styles**

#### RoundedBackgroundStyle
```xml
style="@style/RoundedBackgroundStyle"
```
- Background putih dengan top rounded corners
- Corner radius atas: 24dp
- Cocok untuk bottom sheet atau modal

#### ProfileCardContainerStyle
```xml
style="@style/ProfileCardContainerStyle"
```
- Background khusus untuk profile section
- Kombinasi gradien purple dengan white overlay
- Padding: 24dp
- Perfect untuk halaman profil atau about

---

### 4. **Button Styles**

#### GradientButtonStyle
```xml
style="@style/GradientButtonStyle"
```
- Button dengan gradient background purple
- Text: Bold, White
- Padding: 32dp horizontal, 12dp vertical
- Gradient: #6200EE → #B388FF

---

## 🎨 Color Palette yang Tersedia

### Primary Colors
- `primary`: #6200EE (Purple)
- `primary_dark`: #3700B3 (Dark Purple)
- `primary_light`: #BB86FC (Light Purple)
- `accent`: #03DAC5 (Teal)

### Gradient Colors
- `gradient_start`: #667eea (Blue-Purple)
- `gradient_center`: #6E7BE7 (Purple)
- `gradient_end`: #764ba2 (Deep Purple)
- `gradient_light_start`: #f093fb (Pink)
- `gradient_light_end`: #f5576c (Red-Pink)

### Background Colors
- `background`: #FFFFFF (White)
- `background_light`: #F5F5F5 (Light Gray)
- `background_overlay`: #F3F4F6 (Gray Overlay)
- `surface`: #FFFFFF (White Surface)

### Text Colors
- `text_primary`: #212121 (Almost Black)
- `text_secondary`: #757575 (Gray)
- `text_hint`: #9E9E9E (Light Gray)

---

## 📱 Cara Menggunakan

### Di Layout XML:

#### Untuk Background Container:
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    style="@style/LightGradientBackgroundStyle">
    <!-- Content -->
</LinearLayout>
```

#### Untuk Card:
```xml
<com.google.android.material.card.MaterialCardView
    style="@style/EnhancedCardStyle"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    
    <LinearLayout
        style="@style/ProfileCardContainerStyle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <!-- Content -->
    </LinearLayout>
    
</com.google.android.material.card.MaterialCardView>
```

#### Untuk Button:
```xml
<Button
    style="@style/GradientButtonStyle"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Click Me" />
```

#### Direct Background Reference:
```xml
<View
    android:layout_width="match_parent"
    android:layout_height="200dp"
    android:background="@drawable/background_gradient" />
```

---

## 🎯 Background Drawables yang Dibuat

1. `background_gradient.xml` - Purple gradient utama
2. `background_light_gradient.xml` - Soft pastel gradient
3. `background_soft_gradient.xml` - Vertical soft gradient
4. `background_gradient_overlay.xml` - Gradient dengan overlay
5. `card_background_gradient.xml` - Card dengan subtle gradient
6. `card_elevated_background.xml` - Card dengan elevated effect
7. `profile_card_background.xml` - Profile section background
8. `rounded_background.xml` - White rounded top background
9. `button_gradient_background.xml` - Gradient untuk button

---

## ✨ Implementasi di activity_tentang.xml

Background yang diterapkan:
```xml
<androidx.coordinatorlayout.widget.CoordinatorLayout
    android:background="@drawable/background_light_gradient">
```

Ini memberikan tampilan yang soft dan modern dengan gradien pastel yang lembut di mata.

---

## 🔧 Customization Tips

### Mengubah Warna Gradient:
Edit file di `res/drawable/`, contoh `background_gradient.xml`:
```xml
<gradient
    android:angle="135"
    android:startColor="#YOUR_COLOR"
    android:centerColor="#YOUR_COLOR"
    android:endColor="#YOUR_COLOR"
    android:type="linear" />
```

### Mengubah Corner Radius:
```xml
<corners android:radius="24dp" />
```

### Mengubah Angle Gradient:
- 0° = Left to Right
- 45° = Bottom-Left to Top-Right
- 90° = Bottom to Top
- 135° = Bottom-Right to Top-Left
- 180° = Right to Left

---

## 📌 Notes

- Semua styles sudah terintegrasi dengan Material Design 3
- Background gradient menggunakan smooth transitions
- Compatible dengan dark mode (bisa ditambahkan di `values-night`)
- Elevation dan shadow sudah dioptimalkan untuk performa
- Semua colors sudah didefinisikan di `colors.xml` untuk konsistensi

---

Enjoy your beautiful gradient backgrounds! 🎨✨

