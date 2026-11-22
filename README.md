# Character Manager – TP5

## Character Manager Sprint #2

### CharacterManager, Analytics & Object Reference

---

## Identitas Mahasiswa

| Keterangan | Informasi |
| :--- | :--- |
| Nama | Sola Vide Br Surbakti |
| NIM | 253303621205 |
| Program Studi | Sistem Informasi |
| Universitas | Universitas Prima Indonesia |
| Mata Kuliah | Java Visual |
| Tugas | TP05 – AP6 Belajar Praktik |

---

## 1. Deskripsi Proyek

Character Manager merupakan aplikasi berbasis Java yang digunakan untuk mengelola data karakter. Pada TP5, proyek ini dikembangkan dengan menambahkan fitur pengelolaan karakter, analisis data, serta pengujian konsep *object reference* dan *defensive copy*.

Proyek ini menerapkan konsep Object-Oriented Programming (OOP), seperti class, object, encapsulation, constructor, method, static variable, dan method overriding.

## 2. Fitur yang Dikembangkan

### A. Core Features

- `addCharacter()` – Menambahkan karakter baru.
- `findByName()` – Mencari karakter berdasarkan nama.
- `removeCharacter()` – Menghapus karakter.
- `getTotalCharacters()` – Menghitung jumlah karakter.
- `getAllCharacters()` – Mengambil daftar karakter menggunakan defensive copy.
- `equals()` – Membandingkan karakter berdasarkan nama.
- Validasi untuk mencegah penambahan karakter dengan nama yang sama.

### B. Mini Challenge

- `getAverageLevel()` – Menghitung rata-rata level seluruh karakter.
- `findByType()` – Mencari karakter berdasarkan jenis karakter.
- Mengembalikan nilai `0` apabila daftar karakter kosong saat menghitung rata-rata.

### C. Fitur Analitik Tambahan

#### Method `findStrongest()`

Fitur tambahan yang dibuat adalah `findStrongest()`, yaitu method untuk mencari karakter dengan nilai `attackPower` paling tinggi.

Fitur ini membantu pengguna mengetahui karakter yang memiliki kekuatan serangan terbesar tanpa harus membandingkan seluruh karakter secara manual.

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
│               └── model/
│                   ├── Character.java
│                   ├── CharacterManager.java
│                   └── CharacterType.java
│
├── screenshots/
│   ├── TP5_Bagian_A_Core.png
│   ├── TP5_Bagian_B_C_Analitik.png
│   └── TP5_Bagian_D_Reference.png
│
└── README.md
```

## 4. Hasil Pengujian Program

Program telah diuji dengan beberapa pengujian berikut:

| Pengujian | Hasil |
| :--- | :--- |
| Menambahkan karakter | Berhasil |
| Membandingkan karakter dengan `equals()` | Berhasil |
| Menolak karakter duplikat | Berhasil |
| Mencari karakter | Berhasil |
| Menghapus karakter | Berhasil |
| Menghitung jumlah karakter | Berhasil |
| Menghitung rata-rata level | 6.5 |
| Mencari karakter berdasarkan tipe | Arjuna – WARRIOR |
| Mencari karakter terkuat | Merlin |
| Menguji object reference | Berhasil |
| Menguji defensive copy | Berhasil |
| Menguji static counter | 6 objek |

## 5. Dokumentasi Screenshot

### A. Pengujian Core Features

Screenshot berikut menunjukkan proses penambahan karakter, pengujian `equals()`, penolakan karakter duplikat, pencarian karakter, dan penghapusan karakter.

![Pengujian Core Features](screenshots/TP5_Bagian_A_Core.png)

### B. Pengujian Mini Challenge dan Fitur Analitik

Screenshot berikut menunjukkan hasil perhitungan rata-rata level, pencarian karakter berdasarkan tipe, serta pencarian karakter dengan `attackPower` tertinggi.

![Pengujian Mini Challenge dan Analitik](screenshots/TP5_Bagian_B_C_Analitik.png)

### C. Pengujian Object Reference dan Defensive Copy

Screenshot berikut menunjukkan bahwa variabel `a` dan `b` mengarah ke objek yang sama, serta pengujian defensive copy untuk memastikan perubahan pada daftar salinan tidak mengubah struktur daftar asli.

![Pengujian Object Reference dan Defensive Copy](screenshots/TP5_Bagian_D_Reference.png)

## 6. Kesimpulan

Berdasarkan pengerjaan TP5, saya memahami cara mengelola objek menggunakan class `CharacterManager`, membandingkan objek menggunakan method `equals()`, serta mencegah penambahan data karakter yang memiliki nama sama.

Saya juga mempelajari cara menggunakan method analitik untuk mengolah data karakter. Selain itu, pengujian object reference membantu memahami bahwa dua variabel dapat mengarah ke objek yang sama. Penggunaan defensive copy diperlukan agar struktur daftar karakter asli tidak dapat diubah secara langsung melalui daftar salinan.

Fitur tambahan `findStrongest()` menjadi pengembangan dari proyek sebelumnya karena dapat menemukan karakter dengan `attackPower` tertinggi secara otomatis.

## 7. Google Docs – Analisis TP5

Dokumen analisis TP5 berisi pembahasan mengenai:

- Object reference.
- Perbedaan primitive dan reference.
- Penggunaan static counter.
- Method `equals()`.
- Defensive copy.

**Link Google Docs:**

[Dokumen Analisis TP5 – Character Manager](https://docs.google.com/document/d/1cdo0tnjrpkbUI52BbNE1XgNCcUMHNexPDGNg50KFeNY/edit?usp=sharing)

---

## Repository GitHub

[https://github.com/solavide05/CharacterManager](https://github.com/solavide05/CharacterManager)

**Branch:** `TP5-CharacterManager-Sprint-2`

**Tugas:** TP05 – Character Manager Sprint #2
