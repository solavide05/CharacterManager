# Character Manager

Project Java Visual untuk mata kuliah Java Visual (SIH-6406). Project ini dikembangkan secara bertahap menggunakan konsep Object-Oriented Programming (OOP), Java Swing, dan pola arsitektur Model-View-Controller (MVC).

---

## Informasi Mahasiswa

| Keterangan | Informasi |
| :--- | :--- |
| Nama | Sola Vide Br Surbakti |
| NIM | 253303621205 |
| Program Studi | Sistem Informasi |
| Fakultas | Sains dan Teknologi |
| Universitas | Universitas Prima Indonesia |

---

## TP10 — Character Manager Sprint #4

'Theming, Properti Komponen & Analisis MVC'

CPMK 2 · SCPMK 4

### A. Implementasi AppTheme

Pada TP10, aplikasi Character Manager dikembangkan menggunakan class `AppTheme` untuk mengatur tampilan aplikasi secara terpusat.

Class `AppTheme` berada di package `view` dan berisi pengaturan warna, font, border, serta method `colorFor()` untuk menentukan warna berdasarkan role karakter.

Penggunaan `AppTheme` membuat tampilan aplikasi lebih konsisten dan memudahkan perubahan desain. Warna disimpan di `AppTheme`, bukan di class `Character`, karena warna merupakan bagian dari tampilan aplikasi, bukan data utama karakter.

#### Komponen AppTheme

- Warna latar utama dan kartu.
- Warna teks utama dan teks emas.
- Warna berbeda untuk setiap role karakter.
- Logical font `SansSerif` dan `Monospaced`.
- Border untuk panel utama, kartu, dan statistik.
- Method `colorFor()` untuk pemetaan warna role.
- Method `describe()` untuk memberikan deskripsi role.
- Method `cardBorder()` untuk membuat border kartu berdasarkan role.

### B. Mini-Challenge

Mini-Challenge dilakukan dengan memberikan tampilan khusus kepada karakter yang memiliki level 5 atau lebih.

Ketentuan tampilan:

- Level 5 ke atas: teks berwarna emas dan tebal.
- Level di bawah 5: teks berwarna putih dan normal.

Batas level disimpan dalam konstanta bernama `HIGH_LEVEL_THRESHOLD` dengan nilai `5`.

Logika tersebut ditempatkan pada layer View karena perubahan warna dan ketebalan teks hanya memengaruhi tampilan aplikasi, bukan data karakter.

### C. Data Karakter

Aplikasi menampilkan enam karakter dengan variasi level dan role sebagai berikut:

| No. | Nama | Role | Level | Tampilan Nama |
| :--- | :--- | :--- | :---: | :--- |
| 1 | Arjuna | WARRIOR | 5 | Emas dan tebal |
| 2 | Merlin | MAGE | 6 | Emas dan tebal |
| 3 | Athena | ARCHER | 4 | Putih dan normal |
| 4 | Gatotkaca | WARRIOR | 8 | Emas dan tebal |
| 5 | Morgana | MAGE | 5 | Emas dan tebal |
| 6 | Robin | ARCHER | 8 | Emas dan tebal |

**Perhitungan rata-rata level:**

(5 + 6 + 4 + 8 + 5 + 8) / 6 = 6,00

Rata-rata level karakter adalah **6,00**.

### D. Dua Properti Tambahan

Dua properti tambahan yang diterapkan pada aplikasi adalah sebagai berikut.

#### 1. ToolTipText

ToolTipText digunakan untuk menampilkan informasi karakter ketika pengguna mengarahkan kursor ke kartu karakter.

Informasi yang ditampilkan meliputi nama, level, HP, dan ATK. Properti ini membantu pengguna melihat detail karakter tanpa memenuhi tampilan utama aplikasi.

#### 2. Accessible Description

Accessible Description digunakan untuk memberikan deskripsi tambahan pada kartu karakter melalui `AccessibleContext`.

Informasi yang diberikan meliputi nama karakter, role, dan level. Properti ini membantu teknologi bantu yang mendukung aksesibilitas memahami informasi komponen.

### E. Screenshot Aplikasi

#### Tampilan Sebelum — Character Manager v0.3

Screenshot berikut menunjukkan tampilan aplikasi sebelum penerapan tema TP10.

![Screenshot sebelum TP10](screenshot/TP10-sebelum-v03.png)

#### Tampilan Sesudah — Character Manager v0.4

Screenshot berikut menunjukkan tampilan aplikasi setelah penerapan AppTheme dan Mini-Challenge TP10.

![Screenshot sesudah TP10](screenshot/TP10-sesudah-v04.png)

### F. Analisis Properti dan MVC

Dokumen analisis TP10 membahas lima materi berikut:

1. Pola getter dan setter pada komponen Swing (JavaBeans).
2. Penggunaan `setOpaque()` pada komponen Swing.
3. Perbedaan `setSize()`, `setPreferredSize()`, dan `pack()`.
4. Pemisahan tanggung jawab Model dan View dalam MVC.
5. Penggunaan logical font dan fungsi `deriveFont()`.

**Link Google Docs:**

[Dokumen Analisis TP10 — Java Visual](https://docs.google.com/document/d/1eFYjkSi2Yl9ABVy_9HIFtXrytj9jmwWZWrOGL13cIOs/edit?usp=sharing)

---

## Struktur Project

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
├── screenshot/
│   ├── TP10-sebelum-v03.png
│   └── TP10-sesudah-v04.png
│
└── README.md
```

---

## Konsep MVC

Project ini menerapkan prinsip Model-View-Controller (MVC) untuk memisahkan tanggung jawab pengelolaan data dan tampilan aplikasi.

### Model

Model bertanggung jawab menyimpan data dan aturan karakter, seperti nama, role, level, HP, dan ATK.

Class yang digunakan pada bagian ini antara lain `Character`, `CharacterType`, dan `CharacterManager`.

### View

View bertanggung jawab menampilkan data karakter menggunakan Java Swing.

Class `MainWindow` digunakan untuk menampilkan dashboard, kartu karakter, dan statistik. Sementara itu, class `AppTheme` mengatur warna, font, dan border agar desain aplikasi lebih konsisten.

### Alur Program

Class `Main` menjadi titik awal program untuk menyiapkan data karakter, menghitung rata-rata level, dan membuka tampilan `MainWindow`.

Pemisahan tanggung jawab ini membantu menjaga struktur program agar lebih mudah dikembangkan dan dipelihara.

### Alasan Pemisahan Tampilan dan Model

Pengaturan warna dan font tidak dimasukkan ke dalam class `Character` karena keduanya merupakan bagian dari tampilan aplikasi.

Dengan menempatkan pengaturan desain di `AppTheme`, perubahan tampilan dapat dilakukan tanpa mengubah data karakter. Hal ini membantu menjaga penerapan prinsip MVC dan membuat program lebih fleksibel.

---

## Cara Menjalankan Project

Pastikan Java JDK sudah terpasang dan tersedia di terminal.

Buka terminal pada folder project, kemudian jalankan perintah berikut untuk melakukan kompilasi:

```bash
javac -d bin src/Main.java src/com/unpri/charactermanager/model/Character.java src/com/unpri/charactermanager/model/CharacterType.java src/com/unpri/charactermanager/view/AppTheme.java src/com/unpri/charactermanager/view/MainWindow.java
```

Jalankan aplikasi dengan perintah:

```bash
java -cp bin Main
```

---

## Riwayat Pengembangan TP10

Branch pengerjaan:

`tp10-properties-mvc`

Rencana riwayat commit:

1. `feat(theme): add centralized application theme`
2. `feat(view): apply themed character dashboard`
3. `feat(app): display six sample characters`
4. `docs(tp10): add documentation and screenshots`

Riwayat tersebut digunakan untuk menunjukkan tahapan pengembangan aplikasi secara bertahap melalui Git dan GitHub.

---

## Teknologi

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- Model-View-Controller (MVC)
- Visual Studio Code
- Git dan GitHub

---

## Penutup

Melalui TP10, aplikasi Character Manager dikembangkan dengan penerapan tema terpusat, pengaturan properti komponen Swing, dan pemisahan tanggung jawab berdasarkan konsep MVC.

Pengerjaan ini membantu memahami bahwa pengaturan tampilan sebaiknya berada pada layer View, sedangkan Model berfokus pada data dan aturan karakter. Selain itu, penggunaan properti komponen Swing membantu menghasilkan aplikasi yang lebih terstruktur, konsisten, dan mudah dikembangkan.
