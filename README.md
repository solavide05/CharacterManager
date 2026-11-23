# TP8 - Character Manager Sprint #3

## MainWindow, Data Dinamis & Analisis MVC

**Mata Kuliah:** Java Visual (SIH-6406)  
**Tugas:** TP8 - Tugas  
**Nama:** Sola Vide Br Surbakti  
**NIM:** 253303621205  
**Program Studi:** Sistem Informasi  
**Universitas:** Universitas Prima Indonesia (UNPRI)

---

## A. Implementasi MainWindow

Pada TP8 ini, aplikasi Character Manager dikembangkan dari program berbasis console menjadi aplikasi berbasis Graphical User Interface (GUI) menggunakan Java Swing.

Class `MainWindow` dibuat dengan menggunakan `JFrame` sebagai jendela utama aplikasi. Data karakter ditampilkan secara dinamis menggunakan perulangan `for`, sehingga setiap karakter yang tersimpan di dalam `CharacterManager` dapat ditampilkan tanpa membuat `JLabel` satu per satu secara manual.

Tampilan aplikasi terdiri dari:

- Header Character Manager.
- Daftar karakter dalam bentuk kartu.
- Informasi nama, tipe, level, HP, dan attack power.
- Panel statistik rata-rata level.
- Scroll pane untuk memudahkan pengguna melihat daftar karakter.

## B. Data Karakter dan Mini-Challenge

Pada tugas ini terdapat enam karakter yang digunakan untuk menguji tampilan dinamis dan perhitungan statistik.

**Daftar karakter:**

1. **Arjuna** - WARRIOR, Level 5.
2. **Merlin** - MAGE, Level 3.
3. **Athena** - ARCHER, Level 4.
4. **Bragi** - HEALER, Level 6.
5. **Leonidas** - WARRIOR, Level 8.
6. **Kirana** - MAGE, Level 10.

### Alasan Pemilihan Karakter

1. **Bragi - HEALER, Level 6:** Dipilih sebagai karakter pendukung yang memiliki peran membantu karakter lain.
2. **Leonidas - WARRIOR, Level 8:** Dipilih sebagai karakter petarung dengan level yang lebih tinggi.
3. **Kirana - MAGE, Level 10:** Dipilih untuk menguji perubahan jumlah karakter dan memastikan statistik rata-rata level ikut berubah.

### Hasil Mini-Challenge

Mini-Challenge dilakukan dengan menambahkan `JLabel` yang menampilkan rata-rata level seluruh karakter.

**Sebelum perubahan data:**

- Jumlah karakter: 5.
- Total level: 26.
- Rata-rata level: **5,2**.

**Sesudah perubahan data:**

- Jumlah karakter: 6.
- Total level: 36.
- Rata-rata level: **6,0**.

Perubahan tersebut membuktikan bahwa penambahan data karakter memengaruhi hasil perhitungan rata-rata level secara otomatis.

### Screenshot Aplikasi

#### 1. Sebelum Perubahan Data

![Screenshot Sebelum Perubahan](screenshots/TP8-sebelum.png)

*Keterangan: Tampilan aplikasi dengan lima karakter dan statistik rata-rata level sebesar 5,2.*

#### 2. Sesudah Perubahan Data

![Screenshot Sesudah Perubahan](screenshots/TP8-sesudah.png)

*Keterangan: Tampilan aplikasi dengan enam karakter dan statistik rata-rata level sebesar 6,0.*

## C. Alur Data dan Konsep MVC

Alur data aplikasi dimulai dari `Main.java` yang membuat objek `CharacterManager` dan memasukkan data karakter ke dalamnya. Selanjutnya, `CharacterManager` sebagai bagian dari Model bertugas menyimpan, mengelola, dan menghitung rata-rata level karakter. Data karakter dan hasil perhitungan kemudian diberikan kepada `MainWindow` untuk ditampilkan dalam bentuk GUI menggunakan Java Swing. `MainWindow` berperan sebagai View yang bertanggung jawab menampilkan informasi kepada pengguna tanpa mengambil alih proses pengolahan data. Pemisahan tersebut membuat kode lebih terstruktur dan memudahkan pengembangan aplikasi.

## D. Teknologi yang Digunakan

- Java
- Java Swing
- JFrame
- JPanel
- JLabel
- JScrollPane
- ArrayList
- Object-Oriented Programming (OOP)
- Model-View-Controller (MVC)
- Visual Studio Code
- Git dan GitHub

## E. Analisis GUI dan MVC

Analisis lengkap mengenai program sekuensial, event-driven programming, penggunaan `SwingUtilities.invokeLater()`, hubungan is-a dan has-a, serta penerapan prinsip MVC pada aplikasi Character Manager dapat dilihat melalui dokumen Google Docs berikut.

**Link Google Docs:**

[Dokumen Analisis TP8](https://docs.google.com/document/d/1js4johKPmK9MTUgNVO4QXRLkxV4ZnB-BO_gw-gl5GPw/edit?usp=sharing)

---

**TP8 - Character Manager Sprint #3**  
Universitas Prima Indonesia (UNPRI)  
Program Studi Sistem Informasi
