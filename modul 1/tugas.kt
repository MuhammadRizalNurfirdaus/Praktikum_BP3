fun main() {
    // Contoh nilai ujian siswa
    val nilaiUjian = 85

    // Memanggil fungsi untuk mendapatkan nilai huruf
    val nilaiHuruf = hitungNilai(nilaiUjian)

    // Menampilkan hasil
    println("Nilai angka siswa: $nilaiUjian")
    println("Nilai huruf yang didapat: $nilaiHuruf")
}

/**
 * Fungsi untuk menghitung nilai huruf berdasarkan rentang nilai angka.
 * Menggunakan ekspresi 'when' (sebagai pengganti switch yang lebih canggih di Kotlin).
 *
 * @param nilai Angka ujian siswa (diasumsikan 0-100).
 * @return Nilai huruf (A, B, C, atau D).
 */
fun hitungNilai(nilai: Int): String {
    // Ekspresi 'when' digunakan untuk mencocokkan nilai dengan rentang
    return when (nilai) {
        // a) Jika nilai siswa 80 - 100 = Nilai A
        in 80..100 -> "Nilai A" 

        // b) Jika nilai siswa 60 - 79 = Nilai B
        in 60..79 -> "Nilai B" 

        // c) Jika nilai siswa 50 - 59 = Nilai C
        in 50..59 -> "Nilai C"

        // d) Jika nilai kurang dari 50 = Nilai D
        in 0..49 -> "Nilai D"

        // Kasus jika nilai di luar rentang 0-100 (opsional)
        else -> "Nilai Tidak Valid" 
    }
}