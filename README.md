# Character Manager – AP16 TP12

## Sprint #5: Layout, UI Responsif & Analisis MVC

**Mata Kuliah:** Java Visual  
**Tugas:** AP16 – TP12  
**Nama:** Sola Vide Br Surbakti  
**NIM:** 253303621205  
**Program Studi:** Sistem Informasi  
**Tahun:** 2026

---

## 1. Deskripsi Proyek

Character Manager merupakan aplikasi desktop berbasis Java Swing yang digunakan untuk menampilkan dan mengelola data karakter berdasarkan nama, jenis karakter, dan level.

Pada Sprint #5, aplikasi dikembangkan dengan menerapkan Layout Manager, tampilan responsif, serta prinsip Model-View-Controller (MVC). Pengembangan ini bertujuan agar tampilan aplikasi lebih terstruktur, mudah dibaca, dan dapat menyesuaikan ukuran jendela.

## 2. Teknologi yang Digunakan

- Java
- Java Swing
- Visual Studio Code
- Git dan GitHub
- Layout Manager
- Konsep Model-View-Controller (MVC)

## 3. Struktur Folder

```text
CharacterManager/
│
├── src/
│   ├── Main.java
│   │
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── model/
│               │   ├── Character.java
│               │   ├── CharacterType.java
│               │   └── CharacterManager.java
│               │
│               └── view/
│                   ├── AppTheme.java
│                   └── MainWindow.java
│
├── screenshots/
│   ├── tampilan-awal.png
│   ├── tampilan-diperlebar.png
│   └── tampilan-diperkecil.png
│
└── README.md
```

## 4. Data Karakter

Aplikasi menggunakan delapan data karakter dengan jenis dan level yang berbeda.

1. **Arjuna**
   - Jenis: WARRIOR
   - Level: 5

2. **Merlin**
   - Jenis: MAGE
   - Level: 3

3. **Athena**
   - Jenis: ARCHER
   - Level: 4

4. **Gatotkaca**
   - Jenis: WARRIOR
   - Level: 7

5. **Morgana**
   - Jenis: MAGE
   - Level: 1

6. **Artemis**
   - Jenis: ARCHER
   - Level: 6

7. **Bima**
   - Jenis: WARRIOR
   - Level: 8

8. **Circe**
   - Jenis: MAGE
   - Level: 2

## 5. Penerapan Layout Manager

Pada pengembangan ini, aplikasi menggunakan beberapa Layout Manager.

### A. BorderLayout

BorderLayout digunakan sebagai layout utama pada MainWindow. Komponen dibagi menjadi lima bagian:

- **NORTH:** Header dan panel statistik.
- **CENTER:** Daftar karakter.
- **EAST:** Legenda jenis karakter.
- **SOUTH:** Status bar dan informasi versi.
- **WEST:** Tidak digunakan.

### B. GridLayout

GridLayout digunakan pada panel statistik untuk menyusun informasi dalam dua baris dan dua kolom agar tampil teratur.

### C. BoxLayout

BoxLayout digunakan pada panel legenda untuk menyusun jenis karakter secara vertikal.

### D. JScrollPane

JScrollPane digunakan untuk membungkus panel daftar karakter sehingga daftar tetap dapat diakses ketika ukuran jendela diperkecil.

Kartu karakter ditambahkan ke panel daftar, bukan langsung ke JScrollPane.

## 6. Panel Tambahan

Panel tambahan yang dibuat adalah **Panel Statistik**.

Panel ini menampilkan empat informasi utama:

1. Total karakter.
2. Rata-rata level karakter.
3. Level tertinggi.
4. Jumlah jenis karakter yang digunakan.

Panel statistik menggunakan GridLayout dengan susunan dua baris dan dua kolom.

GridLayout dipilih karena setiap informasi memiliki ruang yang sama sehingga tampilannya lebih rapi. FlowLayout tidak dipilih karena susunan komponen dapat berubah mengikuti ruang yang tersedia.

## 7. Wireframe Tampilan

Berikut rancangan sederhana susunan tampilan aplikasi:

```text
+------------------------------------------------------+
|                    HEADER (NORTH)                    |
+------------------------------------------------------+
|                   PANEL STATISTIK                    |
|  Total Karakter | Rata-rata Level                    |
|  Level Tertinggi| Jenis Karakter                     |
+------------------------------------------+-----------+
|                                          |           |
|             DAFTAR KARAKTER              |  LEGENDA  |
|                                          |           |
|  [Arjuna]                                |  Warrior  |
|  [Merlin]                                |  Mage     |
|  [Athena]                                |  Archer   |
|  [Gatotkaca]                             |  Healer   |
|  [Morgana]                               |           |
|  [Artemis]                               |           |
|  [Bima]                                  |           |
|  [Circe]                                 |           |
|                                          |           |
+------------------------------------------+-----------+
| STATUS BAR                     |  v0.5               |
+------------------------------------------------------+
```

## 8. Dokumentasi Screenshot

Tambahkan tiga screenshot hasil aplikasi pada bagian berikut.

### A. Tampilan Awal

Screenshot aplikasi ketika pertama kali dijalankan.

![Tampilan Awal](screenshots/tampilan-awal.png)

### B. Bukti Screenshot Jendela Diperlebar

Screenshot aplikasi setelah ukuran jendela diperlebar.

![Tampilan Jendela Diperlebar](screenshots/tampilan-diperlebar.png)

### C. Bukti Screenshot Jendela Diperkecil

Screenshot aplikasi setelah ukuran jendela diperkecil hingga scrollbar terlihat.

![Tampilan Jendela Diperkecil](screenshots/tampilan-diperkecil.png)

## 9. Pengamatan Responsivitas

### A. Hasil Pengamatan Tampilan Awal

- Prediksi: Semua komponen terlihat dengan jelas.
- Hasil pengamatan: Isi sesuai hasil pengujian.

### B. Hasil Pengamatan Jendela Diperlebar

- Prediksi: Ruang komponen menyesuaikan ukuran jendela.
- Hasil pengamatan: Isi sesuai hasil pengujian.

### C. Hasil Pengamatan Jendela Diperkecil

- Prediksi: Komponen menyesuaikan ruang yang tersedia dan scrollbar terlihat jika diperlukan.
- Hasil pengamatan: Isi sesuai hasil pengujian.
- Prediksi: Daftar karakter dapat digulir menggunakan scrollbar.
- Hasil pengamatan: Isi sesuai hasil pengujian.

## 10. Analisis Nested Panels

Nested panels adalah teknik menyusun beberapa panel di dalam panel lain untuk membagi tampilan aplikasi menjadi beberapa bagian.

Pada aplikasi Character Manager, panel utama menggunakan BorderLayout. Di dalamnya terdapat panel header, panel statistik, panel daftar karakter, panel legenda, dan status bar.

Penggunaan nested panels membuat susunan komponen lebih teratur dan memudahkan pengaturan setiap bagian tampilan. Selain itu, setiap panel dapat menggunakan Layout Manager yang berbeda sesuai kebutuhan.

## 11. Analisis Pemilihan Layout

Panel statistik menggunakan GridLayout karena empat informasi perlu ditampilkan dengan ukuran dan susunan yang sama. Layout ini membuat tampilan lebih konsisten.

FlowLayout tidak dipilih untuk panel statistik karena posisi komponen dapat berpindah ketika ukuran jendela berubah. Untuk panel legenda, BoxLayout lebih sesuai karena jenis karakter disusun secara vertikal.

## 12. Penerapan MVC

Aplikasi menggunakan konsep Model-View-Controller (MVC).

- **Model:** Menyimpan dan mengelola data karakter, seperti Character, CharacterType, dan CharacterManager.
- **View:** Menampilkan antarmuka aplikasi menggunakan MainWindow dan AppTheme.
- **Controller:** Mengatur hubungan antara data dan tampilan sesuai kebutuhan aplikasi.

Pemisahan ini membuat kode lebih mudah dipelihara dan dikembangkan. Contohnya, tampilan daftar karakter dapat diganti menggunakan JTable tanpa harus mengubah struktur utama data karakter pada Model.

## 13. Penggunaan revalidate() dan repaint()

`revalidate()` digunakan untuk meminta Swing menghitung ulang tata letak komponen setelah terjadi perubahan.

`repaint()` digunakan untuk meminta Swing menggambar ulang tampilan komponen.

Keduanya diperlukan ketika komponen ditambahkan atau diubah setelah jendela aplikasi ditampilkan agar perubahan dapat terlihat dengan benar.

## 14. Link Dokumentasi Analisis

Dokumentasi analisis TP12 dibuat dalam Google Docs dengan pembahasan mengenai Layout Manager, BorderLayout, GridLayout, BoxLayout, JScrollPane, dan prinsip MVC.

**Link Google Docs:**

[Dokumentasi Analisis AP16 TP12](https://docs.google.com/document/d/10winHpUOzXYAxqMp81Kk-hggBwltiYe4m3MFMS4acfA/edit?usp=sharing)

## 15. Kesimpulan

Melalui Sprint #5, aplikasi Character Manager dikembangkan dengan menerapkan beberapa Layout Manager untuk menghasilkan tampilan yang lebih terstruktur dan responsif.

Penggunaan BorderLayout, GridLayout, BoxLayout, dan JScrollPane membantu mengatur komponen sesuai fungsinya. Penambahan panel statistik juga memberikan informasi tambahan mengenai data karakter.

Selain itu, penerapan konsep MVC membantu memisahkan pengelolaan data dengan tampilan aplikasi sehingga program lebih mudah dikembangkan dan dipelihara.

---

**Character Manager – AP16 TP12**  
Java Visual | 2026
