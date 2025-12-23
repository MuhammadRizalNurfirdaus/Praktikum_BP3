# Panduan Lengkap Aplikasi Accelerometer Sensor

## Overview
Aplikasi ini menggunakan **sensor Accelerometer** untuk mendeteksi dan menampilkan gerakan perangkat Android secara real-time.

## Komponen Utama

### 1. MainActivity.kt
File utama yang mengimplementasikan logika sensor:

#### Key Features:
- **SensorEventListener**: Interface untuk menerima event dari sensor
- **SensorManager**: Mengelola akses ke sensor perangkat
- **Real-time Update**: Memperbarui UI setiap kali ada perubahan data sensor

#### Lifecycle Methods:
```kotlin
onResume()  → Mendaftarkan sensor listener
onPause()   → Membatalkan registrasi (hemat baterai)
onCreate()  → Inisialisasi UI dan sensor
```

#### Sensor Callbacks:
```kotlin
onSensorChanged()    → Dipanggil saat ada perubahan data sensor
onAccuracyChanged()  → Dipanggil saat akurasi sensor berubah
```

### 2. UI Components

#### CardView 1: Header
- Judul aplikasi: "Accelerometer Sensor"
- Subtitle: "Deteksi Gerakan Perangkat"
- Background: Biru (#2196F3)

#### CardView 2: Data Sensor
Menampilkan 3 nilai akselerasi:
- **Sumbu X**: Horizontal (kiri-kanan) - Biru
- **Sumbu Y**: Vertikal (atas-bawah) - Hijau
- **Sumbu Z**: Depth (depan-belakang) - Orange

Format: `%.2f m/s²`

#### CardView 3: Status Gerakan
Status | Warna | Kondisi
-------|-------|--------
Diam | Hijau | Delta < 5.0
Bergerak | Orange | Delta 5.0-15.0
Bergerak Kuat | Merah | Delta > 15.0

#### Visual Indicator
Kotak berwarna yang berubah sesuai intensitas gerakan

### 3. Algoritma Deteksi Gerakan

```
1. Baca nilai X, Y, Z dari sensor
2. Hitung delta (perubahan) dari nilai sebelumnya
   deltaX = |currentX - lastX|
   deltaY = |currentY - lastY|
   deltaZ = |currentZ - lastZ|
3. Bandingkan dengan threshold
4. Update status dan warna indikator
5. Simpan nilai saat ini untuk iterasi berikutnya
```

## Cara Menggunakan

### Instalasi:
1. Build project: `./gradlew assembleDebug`
2. Install APK ke perangkat
3. Buka aplikasi

### Penggunaan:
1. Aplikasi akan otomatis mulai membaca sensor
2. Lihat nilai real-time pada sumbu X, Y, Z
3. Gerakkan perangkat untuk melihat perubahan
4. Perhatikan perubahan status dan warna indikator

### Tips:
- Goyangkan perangkat untuk trigger "Bergerak Kuat"
- Miringkan perangkat perlahan untuk "Bergerak"
- Letakkan diam di meja untuk "Diam"

## Penjelasan Sensor Accelerometer

### Apa itu Accelerometer?
Sensor yang mengukur akselerasi (percepatan) perangkat dalam m/s².

### Tiga Sumbu:
- **X-axis**: Positif ke kanan, negatif ke kiri
- **Y-axis**: Positif ke atas, negatif ke bawah
- **Z-axis**: Positif ke depan layar, negatif ke belakang

### Nilai Tipikal:
- Perangkat diam di meja: (0, 9.8, 0)
  - Y = 9.8 karena gravitasi bumi
- Perangkat menghadap ke bawah: (0, -9.8, 0)
- Perangkat tegak: (0, 0, 9.8)

### Sensor Delay Options:
1. `SENSOR_DELAY_FASTEST`: Sampling tercepat
2. `SENSOR_DELAY_GAME`: Untuk game (~20ms)
3. `SENSOR_DELAY_UI`: Untuk UI (~60ms)
4. `SENSOR_DELAY_NORMAL`: Default (~200ms) ✓ (digunakan)

## Implementasi Teknis

### Permissions:
Tidak memerlukan permission khusus untuk accelerometer

### Dependencies:
```kotlin
implementation("androidx.cardview:cardview:1.0.0")
implementation("androidx.core:core-ktx")
implementation("androidx.appcompat:appcompat")
implementation("com.google.android.material:material")
```

### Minimum Requirements:
- Android 7.0 (API 24)
- Sensor accelerometer (tersedia di hampir semua smartphone)

## Troubleshooting

### Sensor tidak tersedia?
- Cek dengan: `sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)`
- Aplikasi akan menampilkan Toast jika tidak ada

### Nilai tidak berubah?
- Pastikan menggunakan perangkat fisik (bukan emulator)
- Restart aplikasi
- Cek permission sensor di settings

### Aplikasi lag?
- Ubah delay dari NORMAL ke UI atau GAME
- Optimasi UI update (gunakan Handler/Coroutines)

## Pengembangan Lanjutan

### Ideas:
1. **Shake Detector**: Trigger action saat perangkat digoyangkan
2. **Step Counter**: Hitung langkah berdasarkan pola akselerasi
3. **Tilt Control**: Kontrol game/aplikasi dengan kemiringan
4. **Data Logger**: Simpan data sensor ke file CSV
5. **Graph Visualization**: Tampilkan grafik real-time
6. **Multi-Sensor**: Gabungkan dengan gyroscope, magnetometer

### Code Improvements:
- Tambahkan low-pass filter untuk mengurangi noise
- Implementasi Kotlin Coroutines untuk async processing
- Gunakan ViewModel untuk separation of concerns
- Tambahkan unit tests

## Referensi
- [Android Sensor Overview](https://developer.android.com/guide/topics/sensors/sensors_overview)
- [Motion Sensors](https://developer.android.com/guide/topics/sensors/sensors_motion)
- [SensorManager API](https://developer.android.com/reference/android/hardware/SensorManager)

## FAQ

**Q: Kenapa nilai Z selalu ~9.8 saat perangkat diam?**
A: Karena sensor accelerometer juga mendeteksi gravitasi bumi (9.8 m/s²)

**Q: Apakah sensor ini menguras baterai?**
A: Tidak terlalu, terutama dengan SENSOR_DELAY_NORMAL. Aplikasi sudah unregister sensor saat onPause().

**Q: Bisa digunakan untuk apa saja?**
A: Step counter, shake detection, tilt games, fall detection, dll.

**Q: Apakah akurat?**
A: Cukup akurat untuk aplikasi umum, tapi ada noise yang perlu di-filter untuk aplikasi presisi.

---

**Build Status**: ✅ BUILD SUCCESSFUL
**Last Update**: December 2025
**Version**: 1.0

