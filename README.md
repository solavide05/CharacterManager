# Character Manager — TP14 AP19

## Character Manager Sprint #6

### Form Input, Validasi & Analisis MVC

| Informasi | Keterangan |
| --- | --- |
| Mata Kuliah | Java Visual (SIH-6406) |
| Tugas | TP14 - AP19 |
| Program Studi | Sistem Informasi |
| Fakultas | Sains dan Teknologi |
| Universitas | Universitas Prima Indonesia |
| Dosen Pengampu | Dr. Evta Indra |
| Tahun | 2026 |

---

## 1. Deskripsi Proyek

Character Manager merupakan aplikasi desktop berbasis Java Swing yang digunakan untuk mengelola data karakter. Aplikasi ini dikembangkan dengan menerapkan konsep Model-View-Controller (MVC), form input, validasi data, dan pengelolaan daftar karakter.

Pada Sprint #6, aplikasi dikembangkan dengan menambahkan form untuk memasukkan nama karakter, memilih role, dan menentukan level. Sistem juga menerapkan validasi agar data yang dimasukkan sesuai dengan aturan yang telah ditentukan.

Validasi dilakukan pada View dan Model. View memberikan pesan kesalahan secara langsung kepada pengguna, sedangkan Model memastikan aturan bisnis tetap diterapkan meskipun data berasal dari luar form.

## 2. Tujuan Praktikum

1. Memahami penggunaan komponen input pada Java Swing.
2. Menerapkan validasi input secara berurutan.
3. Memahami perbedaan validasi View dan Model.
4. Menerapkan penanganan kesalahan menggunakan `IllegalArgumentException`.
5. Memperbarui daftar karakter secara dinamis.
6. Memahami pembagian tanggung jawab dalam konsep MVC.

## 3. Teknologi yang Digunakan

- Java
- Java Swing
- Visual Studio Code
- Git
- GitHub

## 4. Struktur Folder

```text
CharacterManager/
│
├── src/
│   ├── Main.java
│   │
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               │
│               ├── model/
│               │   ├── Character.java
│               │   ├── CharacterManager.java
│               │   └── CharacterType.java
│               │
│               └── view/
│                   ├── AppTheme.java
│                   ├── CharacterFormPanel.java
│                   └── MainWindow.java
│
└── README.md
```

## 5. Fitur Aplikasi

### 5.1 Form Input Karakter

Form input memiliki tiga komponen utama:

- `JTextField` untuk memasukkan nama karakter.
- `JComboBox` untuk memilih role karakter.
- `JSpinner` untuk menentukan level karakter dari 1 sampai 99.

### 5.2 Validasi Nama

Nama karakter diperiksa dengan urutan:

1. **Kelengkapan:** nama tidak boleh kosong.
2. **Panjang:** nama harus terdiri dari 2 sampai 20 karakter.
3. **Format:** nama hanya boleh menggunakan huruf dan satu spasi.
4. **Keunikan:** nama tidak boleh sama dengan karakter yang sudah ada.

Input nama juga dibersihkan menggunakan `trim()` sebelum diproses.

### 5.3 Validasi Model

Model menerapkan beberapa aturan bisnis:

- Nama karakter tidak boleh kosong.
- Role karakter tidak boleh `null`.
- Level karakter harus berada pada rentang 1–99.
- Karakter MAGE tidak boleh memiliki level lebih dari 60.
- Nama karakter tidak boleh duplikat.
- Jumlah karakter maksimal adalah 20.

### 5.4 Tampilan Dinamis

Setelah karakter berhasil ditambahkan, kartu karakter langsung muncul pada daftar tanpa perlu menjalankan ulang aplikasi.

Pembaruan tampilan dilakukan menggunakan:

- `refreshList()`
- `revalidate()`
- `repaint()`

### 5.5 Pesan Kesalahan

Ketika terjadi kesalahan, aplikasi menampilkan pesan secara langsung pada bagian form. Komponen yang bermasalah diberi border merah dan fokus dikembalikan ke komponen tersebut.

Border asli dikembalikan setelah validasi diperbaiki.

## 6. Pembagian Tanggung Jawab MVC

| Lapisan | Tanggung Jawab |
| --- | --- |
| Model | Mengelola data karakter dan menerapkan aturan bisnis |
| View | Menampilkan form, kartu karakter, dan pesan validasi |
| Main | Membuat objek CharacterManager, memasukkan data awal, dan menjalankan aplikasi |

### 6.1 Alasan Penempatan Validasi

| Aturan | Lapisan | Alasan |
| --- | --- | --- |
| Nama tidak boleh kosong | View dan Model | Memberikan umpan balik sekaligus menjaga data |
| Panjang nama 2–20 karakter | View | Membatasi input melalui form |
| Format nama | View | Memastikan format masukan sesuai |
| Nama tidak boleh duplikat | View dan Model | Mencegah nama yang sama |
| MAGE maksimal level 60 | Model | Termasuk aturan bisnis karakter |
| Maksimal 20 karakter | Model | Menjaga batas jumlah data dari berbagai sumber |
| Tidak boleh ada spasi ganda | View | Menjaga kualitas input pengguna |

## 7. Tabel Pengujian

Pengujian dilakukan untuk memastikan seluruh aturan validasi berjalan sesuai harapan.

| No. | Input | Hasil Diharapkan | Hasil Nyata | Lapisan yang Menangkap |
| --- | --- | --- | --- | --- |
| 1 | Nama kosong | Ditolak dengan pesan error | Belum diuji | View |
| 2 | Nama duplikat, misalnya Arjuna | Ditolak dengan pesan duplikat | Belum diuji | View dan Model |
| 3 | Nama dengan spasi ganda | Ditolak dengan pesan format | Belum diuji | View |
| 4 | Nama lebih dari 20 karakter | Ditolak dengan pesan panjang | Belum diuji | View |
| 5 | MAGE level 60 | Karakter berhasil dibuat | Belum diuji | Model |
| 6 | MAGE level 61 | Karakter ditolak | Belum diuji | Model |
| 7 | WARRIOR level 80 | Karakter berhasil dibuat | Belum diuji | Model |
| 8 | Karakter ke-21 | Penambahan ditolak | Belum diuji | Model |

**Catatan pengujian:** Kolom hasil nyata harus diperbarui setelah setiap pengujian benar-benar dilakukan. Jika hasil berbeda dari harapan, lakukan pemeriksaan kode, perbaikan, dan pengujian ulang.

## 8. Screenshot Aplikasi

### 8.1 Screenshot Error Nama Kosong

Masukkan nama kosong, kemudian tekan tombol Tambah Karakter.

**Bukti:**

![Error nama kosong](image.png)

### 8.2 Screenshot Error Nama Duplikat

Masukkan nama karakter yang sudah tersedia pada daftar.

**Bukti:**

![Error nama duplikat](image.png)

### 8.3 Screenshot Berhasil Menambahkan Karakter

Masukkan nama karakter baru, pilih role, tentukan level, kemudian tekan tombol Tambah Karakter.

Karakter yang berhasil ditambahkan harus langsung muncul sebagai kartu baru.

**Bukti:**

![Berhasil menambahkan karakter](image.png)

## 9. Kompromi Sementara pada Sprint #6

Pada Sprint #6, aplikasi masih menggunakan `ActionListener` sederhana untuk menangani aksi tombol tambah karakter. Pendekatan ini dipilih agar alur input dan validasi lebih mudah dipahami. Selain itu, `CharacterFormPanel` masih memanggil `CharacterManager` secara langsung untuk menyimpan karakter. Hal tersebut merupakan kompromi sementara karena View masih memiliki ketergantungan langsung terhadap Model. Pada pengembangan berikutnya, struktur ini diharapkan dapat diperbaiki melalui pemisahan tanggung jawab yang lebih terstruktur.

## 10. Dokumentasi Analisis Input dan Validasi

Analisis konseptual Bagian D dibuat dalam Google Docs dengan pembahasan:

1. Pemilihan komponen berdasarkan ruang nilai yang sah.
2. Perbedaan validasi format dan validasi makna.
3. Pentingnya validasi dua lapis pada View dan Model.
4. Prinsip umpan balik kesalahan yang baik.
5. Penggunaan `getSelectedItem()`, `getValue()`, casting, dan kompromi sementara MVC.

**Link Google Docs:**

[Dokumentasi Analisis TP14 AP19](https://docs.google.com/document/d/1VrG2eEV7nB6txxML--DeoIz2HAU7GXx30Wz2aIAj2zo/edit?usp=sharing)

## 11. Kesimpulan

Melalui Character Manager Sprint #6, aplikasi telah dikembangkan dengan form input dan validasi data menggunakan Java Swing. Validasi pada View membantu pengguna mengetahui kesalahan input secara langsung, sedangkan validasi pada Model menjaga aturan bisnis agar tetap berlaku.

Penerapan konsep MVC juga membantu memisahkan pengelolaan data dan tampilan aplikasi. Dengan demikian, aplikasi menjadi lebih terstruktur dan lebih mudah dikembangkan pada tahap selanjutnya.

---

Character Manager Sprint #6 — TP14 AP19

Java Visual (SIH-6406)  
Universitas Prima Indonesia  
2026
