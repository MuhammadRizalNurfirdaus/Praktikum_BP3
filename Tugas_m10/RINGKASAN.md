# 📱 RINGKASAN APLIKASI SENSOR ACCELEROMETER

## ✨ Yang Telah Dibuat

### 1. **Aplikasi Android - Sensor Accelerometer**
Sebuah aplikasi lengkap yang menggunakan sensor accelerometer untuk mendeteksi gerakan perangkat.

### 2. **File-file Utama:**

#### Kode Program:
- ✅ `MainActivity.kt` - Logika aplikasi dengan SensorEventListener
- ✅ `activity_main.xml` - UI Layout dengan CardView
- ✅ `strings.xml` - Resource strings
- ✅ `build.gradle.kts` - Configuration & dependencies

#### Dokumentasi:
- ✅ `README.md` - Overview dan fitur aplikasi
- ✅ `DOKUMENTASI.md` - Panduan lengkap penggunaan
- ✅ `PENJELASAN_KODE.md` - Penjelasan detail setiap baris kode

## 🎯 Fitur Aplikasi

### 1. Real-time Data Display
- Menampilkan nilai akselerasi sumbu X, Y, Z
- Format: `0.00 m/s²`
- Update otomatis setiap ada perubahan sensor

### 2. Motion Detection
Status gerakan berdasarkan intensitas:
- 🟢 **Diam** - Delta < 5.0 m/s²
- 🟠 **Bergerak** - Delta 5.0-15.0 m/s²
- 🔴 **Bergerak Kuat** - Delta > 15.0 m/s²

### 3. Visual Feedback
- Indikator warna yang berubah sesuai gerakan
- Status text yang jelas
- UI responsif dan user-friendly

### 4. Battery Optimization
- Auto register sensor saat app aktif (onResume)
- Auto unregister saat app background (onPause)

## 🔧 Teknologi

- **Bahasa**: Kotlin
- **Sensor**: TYPE_ACCELEROMETER
- **UI**: Material Design, CardView, ConstraintLayout
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36

## 📊 Cara Kerja

```
1. App Start → Initialize Sensor Manager
2. Detect Accelerometer Sensor
3. Register Listener (onResume)
4. Read Sensor Data (X, Y, Z)
5. Calculate Delta (change from previous)
6. Classify Movement:
   - Strong: Delta > 15
   - Normal: Delta 5-15
   - Still: Delta < 5
7. Update UI (values, status, color)
8. Store current as last values
9. Repeat from step 4
```

## 🎨 UI Components

### Header Card (Blue)
- Title: "Accelerometer Sensor"
- Subtitle: "Deteksi Gerakan Perangkat"

### Data Card (White)
```
Data Sensor
├─ Sumbu X: 0.00 m/s² (Blue)
├─ Sumbu Y: 0.00 m/s² (Green)
└─ Sumbu Z: 0.00 m/s² (Orange)
```

### Status Card (White)
```
Status Gerakan
└─ [Diam/Bergerak/Bergerak Kuat!]
```

### Visual Indicator
Square colored box (80x80dp) yang berubah warna

### Info Text
"Goyangkan perangkat untuk melihat perubahan"

## 📖 Dokumentasi Lengkap

### README.md
- Deskripsi aplikasi
- Fitur-fitur
- Cara kerja sensor
- Instalasi dan penggunaan

### DOKUMENTASI.md
- Panduan lengkap
- Penjelasan komponen
- Algoritma deteksi
- Troubleshooting
- FAQ
- Referensi

### PENJELASAN_KODE.md
- Penjelasan baris per baris
- Logika algoritma
- Design patterns
- Flow diagram
- Best practices
- Tips improvement

## ✅ Status Build

```
BUILD SUCCESSFUL in 41s
34 actionable tasks: 34 executed
```

APK siap untuk di-install dan dijalankan!

## 🚀 Cara Menjalankan

### Option 1: Android Studio
1. Open project di Android Studio
2. Sync Gradle
3. Run app (Shift + F10)

### Option 2: Command Line
```bash
cd Tugas_m10
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Option 3: Direct Run
```bash
./gradlew installDebug
```

## 📱 Testing

### Di Perangkat Fisik (Recommended):
1. Enable Developer Options
2. Enable USB Debugging
3. Connect via USB
4. Run app dari Android Studio

### Di Emulator:
1. Create AVD dengan sensor support
2. Run emulator
3. Deploy app
4. Use emulator extended controls untuk simulate motion

## 🎓 Learning Outcomes

Dari aplikasi ini, kamu belajar:
- ✅ Cara menggunakan sensor di Android
- ✅ Implementasi SensorEventListener
- ✅ Lifecycle management (onResume/onPause)
- ✅ Real-time data processing
- ✅ UI updates based on sensor data
- ✅ Material Design implementation
- ✅ Kotlin best practices
- ✅ Resource management
- ✅ Battery optimization

## 💡 Sensor Accelerometer

### Keunggulan:
- ✅ Tersedia di hampir semua smartphone
- ✅ Tidak perlu permission khusus
- ✅ Low power consumption
- ✅ Akurat untuk motion detection

### Use Cases:
- Step counter / pedometer
- Shake detection
- Tilt-based games
- Fall detection
- Screen rotation
- Gesture recognition

## 🔄 Perbedaan dengan Proximity Sensor

| Aspect | Accelerometer | Proximity |
|--------|---------------|-----------|
| Fungsi | Deteksi gerakan/akselerasi | Deteksi kedekatan objek |
| Output | 3 nilai (X,Y,Z) float | 1 nilai (jarak) |
| Satuan | m/s² | cm atau binary |
| Use Case | Motion, tilt, shake | Screen off saat telpon |
| Kompleksitas | Medium | Simple |

## 📁 File Structure

```
Tugas_m10/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/tugas_m10/
│   │       │   └── MainActivity.kt ⭐
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml ⭐
│   │       │   └── values/
│   │       │       └── strings.xml ⭐
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts ⭐
├── README.md ⭐
├── DOKUMENTASI.md ⭐
└── PENJELASAN_KODE.md ⭐

⭐ = File penting/dimodifikasi
```

## 🎉 Kesimpulan

Aplikasi **Sensor Accelerometer** berhasil dibuat dengan fitur:
- Real-time sensor data monitoring
- Motion detection & classification
- Visual feedback system
- Battery-optimized implementation
- Material Design UI
- Comprehensive documentation

**Sensor yang digunakan**: ACCELEROMETER (bukan proximity)
**Status**: ✅ Build successful, siap digunakan
**Dokumentasi**: Lengkap dengan 3 file markdown

## 📞 Next Steps

1. Install APK ke perangkat
2. Test semua fitur
3. Baca dokumentasi untuk pemahaman mendalam
4. (Optional) Customize threshold atau tambah fitur

---

**Dibuat untuk**: Tugas Praktikum BP3 - Modul 10
**Tanggal**: Desember 2025
**Status**: ✅ COMPLETE

