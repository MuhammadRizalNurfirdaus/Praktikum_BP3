# Penjelasan Kode - Aplikasi Sensor Accelerometer

## 🎯 Tujuan Aplikasi
Membuat aplikasi Android yang memanfaatkan sensor accelerometer untuk mendeteksi gerakan perangkat dan menampilkan data real-time.

## 📱 Sensor yang Digunakan: ACCELEROMETER

### Kenapa Accelerometer?
- ✅ Tersedia di hampir semua smartphone
- ✅ Tidak memerlukan permission khusus
- ✅ Mudah diimplementasikan
- ✅ Banyak use case praktis (game, fitness, gesture detection)

Sensor accelerometer mengukur akselerasi/percepatan perangkat dalam 3 dimensi (X, Y, Z).

## 🔧 Struktur Kode

### 1. MainActivity.kt - Penjelasan Detail

#### Import yang Diperlukan:
```kotlin
import android.hardware.Sensor              // Representasi sensor
import android.hardware.SensorEvent         // Event data sensor
import android.hardware.SensorEventListener // Interface listener
import android.hardware.SensorManager       // Manager untuk akses sensor
```

#### Deklarasi Class:
```kotlin
class MainActivity : AppCompatActivity(), SensorEventListener
```
- Inherit dari `AppCompatActivity` untuk activity Android
- Implement `SensorEventListener` untuk menerima event dari sensor

#### Variable Declarations:
```kotlin
private lateinit var sensorManager: SensorManager
```
- `lateinit`: Variabel akan diinisialisasi nanti (tidak saat deklarasi)
- `SensorManager`: Service system untuk mengakses sensor

```kotlin
private var accelerometer: Sensor? = null
```
- Nullable (`?`) karena sensor mungkin tidak tersedia di perangkat

```kotlin
private var lastX = 0f
private var lastY = 0f
private var lastZ = 0f
```
- Menyimpan nilai terakhir untuk menghitung perubahan (delta)

```kotlin
private val SHAKE_THRESHOLD = 15.0f
```
- Konstanta untuk menentukan kapan dianggap "gerakan kuat"

#### onCreate() Method:
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    
    // Initialize views
    tvXValue = findViewById(R.id.tvXValue)
    // ... dll
    
    // Initialize sensor
    sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
    accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    
    // Check availability
    if (accelerometer == null) {
        Toast.makeText(this, "Accelerometer tidak tersedia!", Toast.LENGTH_LONG).show()
    }
}
```

**Penjelasan:**
1. `setContentView()` - Load layout XML
2. `findViewById()` - Hubungkan variabel dengan view di XML
3. `getSystemService()` - Dapatkan SensorManager dari system service
4. `getDefaultSensor()` - Dapatkan sensor accelerometer default
5. Cek null untuk validasi ketersediaan sensor

#### onResume() & onPause():
```kotlin
override fun onResume() {
    super.onResume()
    accelerometer?.also { acc ->
        sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL)
    }
}

override fun onPause() {
    super.onPause()
    sensorManager.unregisterListener(this)
}
```

**Kenapa penting?**
- `onResume()`: Daftarkan listener saat app aktif
- `onPause()`: Unregister saat app tidak aktif = **HEMAT BATERAI**
- `SENSOR_DELAY_NORMAL`: Sampling rate ~200ms (cukup untuk UI)

#### onSensorChanged() - CORE LOGIC:
```kotlin
override fun onSensorChanged(event: SensorEvent?) {
    if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
        // 1. Baca nilai sensor
        val x = event.values[0]  // Sumbu X
        val y = event.values[1]  // Sumbu Y
        val z = event.values[2]  // Sumbu Z
        
        // 2. Update UI
        tvXValue.text = String.format(Locale.getDefault(), "%.2f m/s²", x)
        tvYValue.text = String.format(Locale.getDefault(), "%.2f m/s²", y)
        tvZValue.text = String.format(Locale.getDefault(), "%.2f m/s²", z)
        
        // 3. Hitung delta (perubahan)
        val deltaX = abs(x - lastX)
        val deltaY = abs(y - lastY)
        val deltaZ = abs(z - lastZ)
        
        // 4. Deteksi gerakan
        if (deltaX > SHAKE_THRESHOLD || deltaY > SHAKE_THRESHOLD || deltaZ > SHAKE_THRESHOLD) {
            updateStatus("Bergerak Kuat!", "#F44336") // Merah
        } else if (deltaX > 5 || deltaY > 5 || deltaZ > 5) {
            updateStatus("Bergerak", "#FF9800") // Orange
        } else {
            updateStatus("Diam", "#4CAF50") // Hijau
        }
        
        // 5. Simpan nilai untuk iterasi berikutnya
        lastX = x
        lastY = y
        lastZ = z
        
        // 6. Update indikator visual
        val movementIntensity = (deltaX + deltaY + deltaZ) / 3
        updateIndicatorColor(movementIntensity)
    }
}
```

**Logika Algoritma:**
1. **Baca data**: `event.values[]` berisi array [x, y, z]
2. **Format & Display**: Tampilkan dengan 2 desimal
3. **Hitung perubahan**: `abs(current - last)` = nilai mutlak perbedaan
4. **Klasifikasi gerakan**:
   - Delta > 15: Gerakan kuat (shake)
   - Delta 5-15: Gerakan normal
   - Delta < 5: Diam
5. **Update state**: Simpan nilai saat ini jadi "last" untuk iterasi berikutnya
6. **Visual feedback**: Ubah warna berdasarkan intensitas

### 2. activity_main.xml - Layout

#### Struktur Hierarki:
```
ConstraintLayout (root)
├── CardView (Header)
│   └── LinearLayout
│       ├── TextView (Judul)
│       └── TextView (Subtitle)
├── CardView (Data Sensor)
│   └── LinearLayout
│       ├── TextView (Label)
│       ├── LinearLayout (X)
│       ├── LinearLayout (Y)
│       └── LinearLayout (Z)
├── CardView (Status)
│   └── LinearLayout
│       ├── TextView (Label)
│       └── TextView (Status)
├── View (Indikator)
└── TextView (Info)
```

#### CardView Properties:
```xml
app:cardCornerRadius="12dp"    <!-- Sudut melengkung -->
app:cardElevation="4dp"        <!-- Bayangan -->
```

#### Color Scheme:
- Primary Blue: `#2196F3` (Header)
- Green: `#4CAF50` (Diam / Y-axis)
- Orange: `#FF9800` (Bergerak / Z-axis)
- Red: `#F44336` (Bergerak Kuat)
- Blue: `#2196F3` (X-axis)

### 3. strings.xml - Resources

```xml
<string name="title_accelerometer">Accelerometer Sensor</string>
<string name="label_axis_x">Sumbu X:</string>
<!-- dll -->
```

**Kenapa pakai strings.xml?**
- ✅ Mudah untuk internationalization (multi-bahasa)
- ✅ Reusable
- ✅ Best practice Android
- ✅ Mudah maintenance

## 🎨 Design Patterns

### 1. Observer Pattern
```
Sensor (Observable) → SensorEventListener (Observer) → UI Update
```

### 2. Lifecycle Awareness
```
onCreate → Inisialisasi
onResume → Register listener
onPause → Unregister listener
```

### 3. MVC (Implicit)
- Model: Sensor data (X, Y, Z, delta)
- View: XML layout
- Controller: MainActivity

## 📊 Flow Diagram

```
[App Start]
    ↓
[onCreate] → Initialize UI & Sensor Manager
    ↓
[onResume] → Register Sensor Listener
    ↓
[Sensor Active] → Continuously fire events
    ↓
[onSensorChanged] → Process data
    ↓
[Calculate Delta] → Compare with threshold
    ↓
[Update UI] → TextView + Indicator color
    ↓
[Store Last Values]
    ↓
[Loop back to onSensorChanged]
    ↓
[onPause] → Unregister Listener (Save battery)
```

## 💡 Tips & Best Practices

### 1. Battery Optimization
```kotlin
// ✅ GOOD - Unregister saat tidak perlu
override fun onPause() {
    sensorManager.unregisterListener(this)
}

// ❌ BAD - Listener tetap aktif
// (tidak ada unregister)
```

### 2. Null Safety (Kotlin)
```kotlin
// ✅ GOOD - Safe call dengan ?. dan also
accelerometer?.also { acc ->
    sensorManager.registerListener(this, acc, delay)
}

// ❌ BAD - Bisa crash jika null
sensorManager.registerListener(this, accelerometer, delay)
```

### 3. Resource Management
```kotlin
// ✅ GOOD - Pakai string resources
android:text="@string/title_accelerometer"

// ❌ BAD - Hardcoded
android:text="Accelerometer Sensor"
```

## 🧪 Testing

### Manual Testing:
1. **Diam**: Taruh perangkat di meja → Status: "Diam" (Hijau)
2. **Gerak normal**: Miringkan perlahan → Status: "Bergerak" (Orange)
3. **Shake**: Goyangkan kuat → Status: "Bergerak Kuat!" (Merah)

### Expected Values:
- Diam di meja: X≈0, Y≈9.8, Z≈0
- Tegak: X≈0, Y≈0, Z≈9.8
- Terbalik: X≈0, Y≈-9.8, Z≈0

## 🚀 Possible Improvements

1. **Tambah Filter**: Low-pass filter untuk kurangi noise
2. **Logging**: Save data ke file/database
3. **Graph**: Visualisasi data dengan chart
4. **Gestures**: Deteksi gesture spesifik (shake, tilt, flip)
5. **Settings**: User bisa adjust threshold
6. **Multiple Sensors**: Gabungkan dengan gyroscope, magnetometer

## 📝 Kesimpulan

Aplikasi ini mendemonstrasikan:
- ✅ Cara menggunakan sensor di Android
- ✅ Lifecycle management
- ✅ Real-time data processing
- ✅ UI updates berdasarkan sensor data
- ✅ Best practices (battery optimization, null safety)

Sensor yang digunakan: **ACCELEROMETER**
Kelebihan: Universal, tidak perlu permission, banyak use case
Output: Data real-time sumbu X, Y, Z dan deteksi gerakan

---
**Status**: ✅ Berhasil di-build dan siap digunakan
**Tanggal**: Desember 2025

