# Aplikasi Accelerometer Sensor - Tugas M10

## Deskripsi
Aplikasi Android yang memanfaatkan sensor **Accelerometer** untuk mendeteksi gerakan perangkat. Aplikasi ini menampilkan data real-time dari sensor accelerometer dan memberikan feedback visual berdasarkan intensitas gerakan.

## Fitur Aplikasi
1. **Pembacaan Data Accelerometer Real-time**
   - Menampilkan nilai akselerasi pada sumbu X, Y, dan Z
   - Data ditampilkan dalam satuan m/s² (meter per detik kuadrat)

2. **Deteksi Status Gerakan**
   - **Diam**: Perangkat tidak bergerak atau bergerak sangat minimal
   - **Bergerak**: Perangkat bergerak dengan kecepatan sedang
   - **Bergerak Kuat**: Perangkat bergerak dengan intensitas tinggi (shake/goyangan)

3. **Indikator Visual**
   - Warna hijau: Status diam
   - Warna orange: Status bergerak
   - Warna merah: Status bergerak kuat

4. **Antarmuka User-Friendly**
   - Menggunakan Material Design dengan CardView
   - Tata letak yang responsif dan mudah dibaca
   - Informasi yang terorganisir dengan baik

## Teknologi yang Digunakan
- **Bahasa**: Kotlin
- **Sensor**: Accelerometer (TYPE_ACCELEROMETER)
- **UI Components**: 
  - ConstraintLayout
  - CardView
  - Material Design Components
- **Android SDK**: Minimum SDK 24 (Android 7.0)

## Cara Kerja Sensor Accelerometer

Accelerometer mengukur akselerasi perangkat pada tiga sumbu:
- **Sumbu X**: Gerakan horizontal (kiri-kanan)
- **Sumbu Y**: Gerakan vertikal (atas-bawah)
- **Sumbu Z**: Gerakan maju-mundur (depan-belakang)

Aplikasi ini:
1. Membaca data sensor secara terus-menerus
2. Menghitung perubahan (delta) dari nilai sebelumnya
3. Menentukan intensitas gerakan berdasarkan threshold yang telah ditentukan
4. Memperbarui UI dengan data dan status terkini

## Threshold Gerakan
- **Diam**: Delta < 5.0 m/s²
- **Bergerak**: Delta 5.0 - 15.0 m/s²
- **Bergerak Kuat**: Delta > 15.0 m/s²

## Instalasi dan Penggunaan
1. Clone atau download project ini
2. Buka project dengan Android Studio
3. Sync Gradle
4. Jalankan aplikasi pada perangkat fisik (disarankan) atau emulator
5. Goyangkan atau gerakkan perangkat untuk melihat perubahan data

## Catatan Penting
- Sensor accelerometer bekerja lebih baik pada perangkat fisik daripada emulator
- Pastikan perangkat memiliki sensor accelerometer (hampir semua smartphone modern memilikinya)
- Aplikasi akan menampilkan toast notification jika sensor tidak tersedia

## Struktur Kode
- `MainActivity.kt`: Logika utama aplikasi, implementasi SensorEventListener
- `activity_main.xml`: Layout antarmuka pengguna
- `strings.xml`: Resource string untuk internationalization
- `circle_indicator.xml`: Drawable untuk indikator visual

## Lifecycle Sensor
- `onResume()`: Mendaftarkan listener sensor
- `onPause()`: Membatalkan registrasi listener untuk menghemat baterai

## Pengembangan Lebih Lanjut
Beberapa ide pengembangan:
- Menambahkan grafik untuk visualisasi data historis
- Implementasi shake detection untuk trigger aksi tertentu
- Menyimpan data sensor ke database
- Menambahkan sensor lain (gyroscope, magnetometer)
- Implementasi gesture detection

## Author
Tugas Praktikum BP3 - Modul 10
Semester 5

## License
Educational Purpose - Tugas Praktikum

