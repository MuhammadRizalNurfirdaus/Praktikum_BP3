# Praktikum Bahasa Pemrograman 3

## Identitas Mahasiswa
- **Nama**: Muhammad Rizal Nurfirdaus
- **NIM**: 20230810088
- **Mata Kuliah**: Praktikum Bahasa Pemrograman 3
- **Dosen Pengampu**: Dede Husen, M.Kom.

---

## Deskripsi Repository
Repository ini berisi kumpulan project dan tugas praktikum Bahasa Pemrograman 3 yang mencakup pembelajaran **Kotlin** dan **Android Development** menggunakan **Jetpack Compose** dan **XML Layout**. Setiap modul dirancang untuk memahami konsep-konsep penting dalam pengembangan aplikasi mobile Android.

---

## 📋 Daftar Isi
- [Cara Clone Repository](#-cara-clone-repository)
- [Struktur Folder](#-struktur-folder)
- [Modul 1: Dasar-Dasar Kotlin](#modul-1-dasar-dasar-kotlin)
- [Modul 2: Android Development Basics](#modul-2-android-development-basics)
- [Modul 3: Activity & Layout](#modul-3-activity--layout)
- [Modul 4: Intent & Data Passing](#modul-4-intent--data-passing)
- [Modul 5-6: Advanced Topics](#modul-5-6-advanced-topics)
- [Modul 7: RecyclerView](#modul-7-recyclerview)
- [Modul 8: Navigation & AppBar](#modul-8-navigation--appbar)
- [Modul 9: Advanced UI](#modul-9-advanced-ui)
- [Modul 10: Sensors](#modul-10-sensors)
- [Cara Menjalankan Project](#-cara-menjalankan-project)
- [Teknologi yang Digunakan](#-teknologi-yang-digunakan)

---

## 🔄 Cara Clone Repository

### 1. Menggunakan HTTPS
```bash
git clone https://github.com/MuhammadRizalNurfirdaus/Praktikum_BP3.git
```

### 2. Menggunakan SSH (jika sudah setup SSH key)
```bash
git clone git@github.com:MuhammadRizalNurfirdaus/Praktikum_BP3.git
```

### 3. Masuk ke Folder Repository
```bash
cd Praktikum_BP3
```

### 4. Update Repository (untuk mendapatkan perubahan terbaru)
```bash
git pull origin main
```

---

## 📁 Struktur Folder

```
Praktikum_BP3/
│
├── modul 1/                          # Dasar-Dasar Kotlin
├── modul 2/                          # Android Development Basics
├── modul 3/                          # Activity & Layout
├── modul3_activity2/                 # Latihan Activity 2
├── modul3_kalkulator/                # Aplikasi Kalkulator
├── Modul4_Intent_Eksplisit/          # Intent Eksplisit
├── Modul4_Intent_implisit/           # Intent Implisit
├── Modul4_intent_parcelable/         # Parcelable Data Passing
├── modul5_laprak/                    # Laporan Praktikum Modul 5
├── modul6_laprak/                    # Laporan Praktikum Modul 6
├── Modul7_recycle_view/              # RecyclerView Implementation
├── modul7_laprak/                    # Laporan Praktikum Modul 7
├── Modul8_appbar/                    # AppBar & Toolbar
├── modul8_navigation_drawer/         # Navigation Drawer
├── modul8_laprak/                    # Laporan Praktikum Modul 8
├── modul9_laprak/                    # Laporan Praktikum Modul 9
├── Modul10_Sensor/                   # Sensor Implementation
├── modul10_laprak/                   # Laporan Praktikum Modul 10
├── Aplikasi_Data_Mahasiswa/          # Project Aplikasi Data Mahasiswa
├── halaman_login/                    # Halaman Login
├── Tugas_m2/                         # Tugas Modul 2
├── tugasm4/                          # Tugas Modul 4
├── Tugas_m10/                        # Tugas Modul 10
└── README.md                         # File ini
```

---

## Modul 1: Dasar-Dasar Kotlin

### 📚 Materi yang Dipelajari
1. **Syntax Dasar Kotlin**
   - Hello World
   - Variabel dan Tipe Data
   - Function dan Parameter
   - Control Flow (if-else, when)
   
2. **Konsep Object-Oriented Programming**
   - Class dan Object
   - Constructor
   - Inheritance
   - Data Class

### 📝 File-File Praktikum
- `praktikum1.kt` - Hello World & Output Dasar
- `praktikum2.kt` - Variabel dan Tipe Data
- `praktikum3.kt` - Function dan Parameter
- `praktikum4.kt` - Control Flow
- `praktikum5.kt` - Class dan Object
- `praktikum6.kt` - OOP Lanjutan
- `tugas.kt` - Tugas Modul 1

### 💻 Cara Menjalankan Kode Kotlin
```bash
# Masuk ke folder modul 1
cd "modul 1"

# Compile file Kotlin
kotlinc praktikum1.kt -include-runtime -d praktikum1.jar

# Jalankan file JAR
java -jar praktikum1.jar
```

### 📖 Contoh Kode
```kotlin
// praktikum1.kt - Hello World
fun main() { 
    println("Hello, Kotlin") 
    println("Hello Manajemen D3 Informatika") 
}
```

---

## Modul 2: Android Development Basics

### 📚 Materi yang Dipelajari
1. **Setup Android Studio**
   - Instalasi dan Konfigurasi
   - Membuat Project Baru
   - Struktur Project Android

2. **XML Layout Basics**
   - LinearLayout
   - RelativeLayout
   - ConstraintLayout

3. **Basic UI Components**
   - TextView
   - Button
   - EditText
   - ImageView

### 📂 Folder
- `modul 2/Praktikum_PAB/` - Project Praktikum
- `modul 2/keystorepab1` - Keystore untuk signing APK
- `Tugas_m2/` - Tugas Modul 2

### 💻 Cara Build Project
```bash
# Masuk ke folder project
cd "modul 2/Praktikum_PAB"

# Build menggunakan Gradle
./gradlew build

# Atau build APK debug
./gradlew assembleDebug
```

---

## Modul 3: Activity & Layout

### 📚 Materi yang Dipelajari
1. **Activity Lifecycle**
   - onCreate, onStart, onResume
   - onPause, onStop, onDestroy
   
2. **View Binding**
   - Setup View Binding
   - Akses View tanpa findViewById

3. **Event Handling**
   - OnClickListener
   - Event pada berbagai komponen

### 📱 Project-Project
1. **modul 3/** - Project Dasar Activity
2. **modul3_activity2/** - Latihan Activity Lanjutan
3. **modul3_kalkulator/** - Aplikasi Kalkulator Sederhana

### 🧮 Aplikasi Kalkulator
Aplikasi kalkulator sederhana dengan fitur:
- Penjumlahan
- Pengurangan
- Perkalian
- Pembagian
- UI yang user-friendly

### 💻 Cara Menjalankan
```bash
# Buka project dengan Android Studio
# File > Open > Pilih folder modul3_kalkulator

# Atau menggunakan terminal
cd modul3_kalkulator
./gradlew installDebug  # Install langsung ke device/emulator
```

---

## Modul 4: Intent & Data Passing

### 📚 Materi yang Dipelajari
1. **Intent Eksplisit**
   - Navigasi antar Activity
   - Passing data sederhana (String, Int, Boolean)
   
2. **Intent Implisit**
   - Membuka aplikasi eksternal
   - Share data
   - Dial phone, Send email
   
3. **Parcelable**
   - Passing object kompleks
   - Implementasi Parcelable
   - @Parcelize annotation

### 📱 Project-Project

#### 1. Modul4_Intent_Eksplisit
```kotlin
// Contoh Intent Eksplisit
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("NAMA", "Muhammad Rizal")
intent.putExtra("NIM", "20230810088")
startActivity(intent)
```

#### 2. Modul4_Intent_implisit
```kotlin
// Contoh Intent Implisit - Dial Phone
val intent = Intent(Intent.ACTION_DIAL)
intent.data = Uri.parse("tel:08123456789")
startActivity(intent)

// Share Text
val shareIntent = Intent(Intent.ACTION_SEND)
shareIntent.type = "text/plain"
shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello from my app!")
startActivity(Intent.createChooser(shareIntent, "Share via"))
```

#### 3. Modul4_intent_parcelable
```kotlin
// Data Class dengan Parcelable
@Parcelize
data class Mahasiswa(
    val nama: String,
    val nim: String,
    val jurusan: String
) : Parcelable

// Mengirim data
val mahasiswa = Mahasiswa("Muhammad Rizal", "20230810088", "Informatika")
val intent = Intent(this, DetailActivity::class.java)
intent.putExtra("DATA_MAHASISWA", mahasiswa)
startActivity(intent)

// Menerima data
val mahasiswa = intent.getParcelableExtra<Mahasiswa>("DATA_MAHASISWA")
```

### 🎯 Tugas Modul 4 (tugasm4/)
Aplikasi yang mengimplementasikan semua jenis Intent dengan UI yang menarik.

---

## Modul 5-6: Advanced Topics

### 📚 Materi yang Dipelajari
1. **Data Persistence**
   - SharedPreferences
   - Internal Storage
   - External Storage

2. **SQLite Database**
   - Create Database
   - CRUD Operations
   - Database Helper

3. **Material Design**
   - Material Components
   - Theming
   - Colors & Typography

### 📂 Folder
- `modul5_laprak/` - Laporan dan project modul 5
- `modul6_laprak/` - Laporan dan project modul 6

---

## Modul 7: RecyclerView

### 📚 Materi yang Dipelajari
1. **RecyclerView Basics**
   - Adapter Pattern
   - ViewHolder
   - LayoutManager (Linear, Grid, Staggered)

2. **Advanced RecyclerView**
   - Item Click Listener
   - Multiple View Types
   - DiffUtil untuk performance

3. **CardView**
   - Material CardView
   - Elevation & Shadow
   - Styling

### 📱 Project: Modul7_recycle_view

#### Fitur
- Menampilkan list data dalam RecyclerView
- CardView untuk setiap item
- Click listener pada item
- Update untuk API 36 (Android 14)

#### Struktur Kode
```kotlin
// Data Class
data class Item(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
)

// ViewHolder
class ItemViewHolder(val binding: ItemLayoutBinding) : 
    RecyclerView.ViewHolder(binding.root)

// Adapter
class ItemAdapter(private val items: List<Item>) : 
    RecyclerView.Adapter<ItemViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            tvTitle.text = item.title
            tvDescription.text = item.description
            // Load image with Glide/Coil
        }
    }
    
    override fun getItemCount() = items.size
}

// MainActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val items = getItems() // Get data
        val adapter = ItemAdapter(items)
        
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }
}
```

#### 📄 Dokumentasi Tambahan
- [PERBAIKAN_ERROR.md](Modul7_recycle_view/PERBAIKAN_ERROR.md) - Cara memperbaiki error umum
- [README_CARA_PERBAIKI_ERROR.md](Modul7_recycle_view/README_CARA_PERBAIKI_ERROR.md) - Panduan troubleshooting
- [UPDATE_API36.md](Modul7_recycle_view/UPDATE_API36.md) - Update untuk Android 14

---

## Modul 8: Navigation & AppBar

### 📚 Materi yang Dipelajari
1. **AppBar & Toolbar**
   - Custom Toolbar
   - Menu Items
   - Action Icons
   - Overflow Menu

2. **Navigation Drawer**
   - Drawer Layout
   - Navigation View
   - Menu Navigation
   - Header Layout

3. **Bottom Navigation**
   - Bottom Navigation View
   - Fragment Management
   - Navigation Component

### 📱 Project-Project

#### 1. Modul8_appbar
```kotlin
// Setup Toolbar
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "My App"
            setDisplayHomeAsUpEnabled(true)
        }
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Handle settings
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
```

#### 2. modul8_navigation_drawer
```kotlin
// Setup Navigation Drawer
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        drawerLayout = binding.drawerLayout
        val navView = binding.navView
        
        setSupportActionBar(binding.toolbar)
        
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Navigate to Home
                }
                R.id.nav_profile -> {
                    // Navigate to Profile
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}
```

---

## Modul 9: Advanced UI

### 📚 Materi yang Dipelajari
1. **Custom Views**
   - Canvas Drawing
   - Custom Attributes
   - Touch Events

2. **Animations**
   - View Animations
   - Property Animations
   - Transition Animations

3. **Material Motion**
   - Shared Element Transitions
   - Container Transform
   - Fade Through

### 📂 Folder
- `modul9_laprak/` - Laporan dan project modul 9

---

## Modul 10: Sensors

### 📚 Materi yang Dipelajari
1. **Sensor Framework**
   - SensorManager
   - Sensor Types
   - SensorEventListener

2. **Common Sensors**
   - Accelerometer
   - Gyroscope
   - Proximity
   - Light Sensor

3. **Sensor Data Processing**
   - Reading sensor data
   - Filtering noise
   - Implementing gestures

### 📱 Project: Modul10_Sensor & Tugas_m10

#### Accelerometer App
Aplikasi yang menggunakan sensor Accelerometer untuk mendeteksi gerakan perangkat.

```kotlin
class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }
    
    override fun onResume() {
        super.onResume()
        accelerometer?.also { acc ->
            sensorManager.registerListener(
                this, acc, SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }
    
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
    
    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            
            // Calculate movement
            val delta = abs(x + y + z - lastX - lastY - lastZ)
            
            // Update UI based on movement
            when {
                delta < 5.0f -> {
                    // Device is still
                    statusText.text = "Diam"
                    cardView.setCardBackgroundColor(Color.GREEN)
                }
                delta < 15.0f -> {
                    // Device is moving
                    statusText.text = "Bergerak"
                    cardView.setCardBackgroundColor(Color.parseColor("#FFA500"))
                }
                else -> {
                    // Device is shaking
                    statusText.text = "Bergerak Kuat"
                    cardView.setCardBackgroundColor(Color.RED)
                }
            }
            
            lastX = x
            lastY = y
            lastZ = z
        }
    }
    
    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Handle accuracy changes
    }
}
```

#### Fitur Aplikasi
- Real-time sensor data display
- Movement detection (Diam, Bergerak, Bergerak Kuat)
- Visual feedback dengan perubahan warna
- Material Design UI

#### 📄 Dokumentasi Lengkap
Lihat folder [Tugas_m10/](Tugas_m10/) untuk dokumentasi lengkap:
- [README.md](Tugas_m10/README.md) - Overview dan cara kerja
- [PENJELASAN_KODE.md](Tugas_m10/PENJELASAN_KODE.md) - Penjelasan detail kode
- [DOKUMENTASI.md](Tugas_m10/DOKUMENTASI.md) - Screenshot dan testing
- [RINGKASAN.md](Tugas_m10/RINGKASAN.md) - Ringkasan project

---

## 🎓 Project Utama

### Aplikasi Data Mahasiswa
**Folder**: `Aplikasi_Data_Mahasiswa/`

#### Fitur
- CRUD Data Mahasiswa (Create, Read, Update, Delete)
- SQLite Database
- Form input dengan validasi
- RecyclerView untuk menampilkan list
- Material Design UI
- Custom background styles

#### Teknologi
- Kotlin
- SQLite Database
- View Binding
- RecyclerView dengan CardView
- Material Design Components

#### 📄 Dokumentasi
- [BACKGROUND_STYLES_GUIDE.md](Aplikasi_Data_Mahasiswa/BACKGROUND_STYLES_GUIDE.md) - Panduan styling background

---

### Halaman Login
**Folder**: `halaman_login/`

#### Fitur
- Form login dengan validasi
- SharedPreferences untuk remember me
- Password visibility toggle
- Material Design
- Error handling

#### Teknologi
- Kotlin
- SharedPreferences
- Material Design Components
- Input validation

---

## 🚀 Cara Menjalankan Project

### Prasyarat
1. **Android Studio** (versi terbaru)
   - Download: https://developer.android.com/studio
   
2. **JDK 11 atau lebih tinggi**
   
3. **Android SDK**
   - Minimum SDK: 24 (Android 7.0)
   - Target SDK: 34 (Android 14)

### Langkah-Langkah

#### 1. Clone Repository
```bash
git clone https://github.com/MuhammadRizalNurfirdaus/Praktikum_BP3.git
cd Praktikum_BP3
```

#### 2. Buka Project di Android Studio
- Buka Android Studio
- File → Open
- Pilih folder project yang ingin dibuka (misal: `modul3_kalkulator`)
- Tunggu Gradle sync selesai

#### 3. Setup Emulator atau Device
**Opsi A: Menggunakan Emulator**
- Tools → AVD Manager
- Create Virtual Device
- Pilih device dan system image
- Finish

**Opsi B: Menggunakan Physical Device**
- Enable Developer Options di HP
- Enable USB Debugging
- Sambungkan HP ke komputer via USB

#### 4. Run Project
- Klik tombol Run (▶️) di Android Studio
- Atau tekan Shift + F10
- Pilih device/emulator target
- Tunggu build dan install selesai

#### 5. Build APK
```bash
# Debug APK
./gradlew assembleDebug

# Release APK
./gradlew assembleRelease

# APK akan tersimpan di:
# app/build/outputs/apk/debug/app-debug.apk
# app/build/outputs/apk/release/app-release.apk
```

---

## 🛠 Teknologi yang Digunakan

### Programming Language
- **Kotlin** - Bahasa pemrograman utama untuk Android

### Android Components
- **Activity** - Komponen UI utama
- **Fragment** - Modular UI components
- **Intent** - Komunikasi antar komponen
- **Service** - Background processing
- **Broadcast Receiver** - Event handling
- **Content Provider** - Data sharing

### UI/UX
- **XML Layouts** - Declarative UI
- **View Binding** - Type-safe view access
- **Material Design Components**
  - CardView
  - RecyclerView
  - AppBarLayout
  - NavigationView
  - BottomNavigationView
  - FloatingActionButton
  - Snackbar
  - Dialog

### Layouts
- **ConstraintLayout** - Flexible positioning
- **LinearLayout** - Linear arrangement
- **RelativeLayout** - Relative positioning
- **FrameLayout** - Single child container
- **CoordinatorLayout** - Advanced behavior coordination

### Data Storage
- **SharedPreferences** - Key-value storage
- **SQLite** - Relational database
- **File Storage** - Internal/External files

### Hardware Access
- **SensorManager** - Sensor access
- **Camera API** - Camera access
- **Location Services** - GPS/Location

### Build Tools
- **Gradle** - Build automation
- **Android Gradle Plugin** - Android-specific build
- **Kotlin Gradle Plugin** - Kotlin compilation

### Libraries (jika digunakan)
- **Glide/Picasso** - Image loading
- **Retrofit** - Networking
- **Room** - Database ORM
- **Coroutines** - Asynchronous programming
- **LiveData & ViewModel** - Architecture components

---

## 📖 Konsep Penting yang Dipelajari

### 1. Android Activity Lifecycle
```
Created → Started → Resumed → Running
                ↓
Paused → Stopped → Destroyed
```

### 2. MVVM Architecture
```
View ← ViewModel ← Model
     (Observer)   (Data)
```

### 3. RecyclerView Pattern
```
Data → Adapter → ViewHolder → RecyclerView
```

### 4. Intent Types
- **Explicit Intent**: Navigasi antar activity dalam app
- **Implicit Intent**: Membuka activity di app lain

### 5. Data Persistence
- SharedPreferences: Simple key-value
- SQLite: Relational database
- File Storage: Binary/Text files

---

## 🐛 Troubleshooting

### Problem: Gradle Sync Failed
```bash
# Solution:
./gradlew clean
File → Invalidate Caches → Invalidate and Restart
```

### Problem: APK tidak bisa diinstall
```bash
# Solution:
# 1. Uninstall aplikasi yang lama
# 2. Clean project
./gradlew clean
# 3. Rebuild
./gradlew assembleDebug
```

### Problem: Sensor tidak bekerja di Emulator
```
Solution:
- Gunakan physical device untuk testing sensor
- Atau gunakan emulator dengan Extended controls untuk simulate sensor
```

### Problem: Build terlalu lama
```bash
# Solution:
# 1. Enable Gradle daemon
# gradle.properties
org.gradle.daemon=true
org.gradle.parallel=true
org.gradle.caching=true

# 2. Increase heap size
org.gradle.jvmargs=-Xmx2048m
```

---

## 📚 Resources & References

### Official Documentation
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Android Developers](https://developer.android.com/)
- [Material Design](https://material.io/design)

### Tutorials
- [Android Basics in Kotlin](https://developer.android.com/courses/android-basics-kotlin/course)
- [Kotlin Bootcamp](https://developer.android.com/courses/kotlin-bootcamp/overview)

### Tools
- [Android Studio](https://developer.android.com/studio)
- [Kotlin Playground](https://play.kotlinlang.org/)
- [Material Theme Builder](https://material-foundation.github.io/material-theme-builder/)

---

## 📝 Catatan Tambahan

### Modul 1-2: Foundation
- Fokus pada syntax Kotlin dan setup environment
- Memahami struktur project Android
- UI dasar dengan XML

### Modul 3-4: Core Concepts
- Activity lifecycle dan management
- Intent untuk navigasi dan komunikasi
- Data passing antar komponen

### Modul 5-6: Data Management
- Persistent storage
- Database operations
- Material Design implementation

### Modul 7-9: Advanced UI
- Complex layouts dengan RecyclerView
- Navigation patterns
- Custom views dan animations

### Modul 10: Hardware Integration
- Sensor integration
- Real-time data processing
- Event-driven programming

---

## 🎯 Learning Outcomes

Setelah menyelesaikan praktikum ini, mahasiswa diharapkan dapat:

1. ✅ Memahami dan menulis kode Kotlin dengan baik
2. ✅ Membuat aplikasi Android dengan berbagai komponen
3. ✅ Mengimplementasikan berbagai jenis layout
4. ✅ Mengelola navigasi antar screen
5. ✅ Menyimpan dan mengelola data
6. ✅ Membuat UI yang menarik dengan Material Design
7. ✅ Menggunakan RecyclerView untuk list data
8. ✅ Implementasi navigation patterns
9. ✅ Mengakses hardware sensors
10. ✅ Build dan deploy aplikasi Android

---

## 📞 Kontak

Jika ada pertanyaan atau kendala, silakan hubungi:

- **Email**: [muhammad.rizal@student.ac.id]
- **GitHub**: [@MuhammadRizalNurfirdaus](https://github.com/MuhammadRizalNurfirdaus)

---

## 📄 License

Project ini dibuat untuk keperluan pembelajaran Praktikum Bahasa Pemrograman 3.

---

**© 2024 Muhammad Rizal Nurfirdaus - 20230810088**

*Praktikum Bahasa Pemrograman 3 - Dede Husen, M.Kom.*
