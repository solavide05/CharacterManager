# Character Manager — TP03

## Deskripsi

Character Manager merupakan program sederhana berbasis Java yang dibuat untuk mengelola data karakter dalam sebuah aplikasi. Program ini menerapkan konsep Object-Oriented Programming (OOP), seperti class, object, constructor, encapsulation, enum, getter, setter, dan method.

Pada tugas TP3 ini, program dikembangkan dengan menambahkan atribut `mana`, validasi nilai mana, serta method `isAlive()` untuk memeriksa apakah karakter masih hidup berdasarkan jumlah Hit Points (HP).

## Fitur Program

1. Membuat karakter dengan nama, jenis, dan level.
2. Menggunakan dua constructor untuk membuat karakter baru dan memuat data karakter.
3. Menggunakan enum `CharacterType` dengan empat jenis karakter:

   - WARRIOR
   - MAGE
   - ARCHER
   - HEALER

4. Menggunakan getter dan setter untuk mengakses serta mengubah atribut.
5. Menghitung HP dan attack power berdasarkan level karakter.
6. Menambahkan atribut `mana` dengan tipe data `int`.
7. Memvalidasi mana agar tidak boleh bernilai negatif.
8. Menggunakan method `isAlive()` untuk memeriksa status hidup karakter.
9. Menggunakan `toString()` untuk menampilkan informasi lengkap karakter.

## Screenshot Output Program

Berikut merupakan hasil program Character Manager yang dijalankan melalui Visual Studio Code.

![Screenshot Output Character Manager](docs/screenshot-output.png)

Screenshot menampilkan:

- Tiga karakter awal: Arjuna, Merlin, dan Athena.
- Demonstrasi kenaikan level karakter Arjuna.
- Pembuatan karakter baru bernama Leon.
- Pengujian atribut mana.
- Pengujian method `isAlive()`.
- Pengujian validasi mana negatif.

## Struktur Folder Project

```text
CharacterManager/
│
├── README.md
│
├── docs/
│   └── screenshot-output.png
│
└── src/
    ├── Main.java
    │
    └── com/
        └── unpri/
            └── charactermanager/
                └── model/
                    ├── Character.java
                    └── CharacterType.java
```

## Informasi Mahasiswa

| Keterangan | Informasi |
| :--- | :--- |
| Nama | Sola Vide Br Surbakti |
| NIM | 253303621205 |
| Program Studi | Sistem Informasi |
| Fakultas | Sains dan Teknologi |
| Mata Kuliah | Java Visual (SIH-6406) |
| Dosen Pengampu | Dr. Evta Indra |

## Dokumentasi Analisis Desain

Dokumentasi analisis desain dan ekosistem Java untuk Bagian D dapat diakses melalui Google Docs berikut.

**Google Docs:** [Analisis Desain dan Ekosistem Java](https://docs.google.com/document/d/1G16Nov6ZS7DgwrGPFyh-AEzNSL7Q5eRn_-2MYuIa0mM/edit?usp=sharing)

## Teknologi yang Digunakan

- Java Development Kit (JDK) 17
- Visual Studio Code
- Git
- GitHub

## Informasi Tugas

**Nama Tugas:** Character Manager Sprint #1 — Build, Extend & Analyze Class Skeleton

**Kode Tugas:** TP3 — AP3 Belajar Praktik

**CPMK:** CPMK 1 — SCPMK 1

**Universitas:** Universitas Prima Indonesia (UNPRI)
