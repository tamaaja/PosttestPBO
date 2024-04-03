import java.util.ArrayList;
import java.util.Scanner;

class Sembako {
    private int harga;
    private int stok;
    private int jumlah;
    private String nama;

    public Sembako(String nama, int harga, int stok, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.jumlah = jumlah;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

class Makanan extends Sembako {
    private String kategoriMakanan;

    public Makanan(String nama, int harga, int stok, int jumlah, String kategoriMakanan) {
        super(nama, harga, stok, jumlah);
        this.kategoriMakanan = kategoriMakanan;
    }

    public String getKategoriMakanan() {
        return kategoriMakanan;
    }

    public void setKategoriMakanan(String kategoriMakanan) {
        this.kategoriMakanan = kategoriMakanan;
    }

    // Override method toString() untuk mencetak informasi makanan
    @Override
    public String toString() {
        return "Nama: " + getNama() + ", Harga: " + getHarga() + ", Stok: " + getStok() + ", Jumlah: " + getJumlah() + ", Kategori: " + getKategoriMakanan();
    }
}

class Minuman extends Sembako {
    private String kategoriMinuman;

    public Minuman(String nama, int harga, int stok, int jumlah, String kategoriMinuman) {
        super(nama, harga, stok, jumlah);
        this.kategoriMinuman = kategoriMinuman;
    }

    public String getKategoriMinuman() {
        return kategoriMinuman;
    }

    public void setKategoriMinuman(String kategoriMinuman) {
        this.kategoriMinuman = kategoriMinuman;
    }

    // Override method toString() untuk mencetak informasi minuman
    @Override
    public String toString() {
        return "Nama: " + getNama() + ", Harga: " + getHarga() + ", Stok: " + getStok() + ", Jumlah: " + getJumlah() + ", Kategori: " + getKategoriMinuman();
    }
}


public class posttest4 {
    private static ArrayList<Sembako> daftarSembako = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|      APLIKASI PENDATAAN TOKO SEMBAKO INDOMARRIED      |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("=========================================================");
            System.out.println("|                   1. Menu Pendataan                   |");
            System.out.println("=========================================================");
            System.out.println("|                   2. Keluar Program                   |");
            System.out.println("=========================================================");
            System.out.print("PILIH MENU : ");

            int pilihanUtama = scanner.nextInt();

            switch (pilihanUtama) {
                case 1:
                    menuPendataan();
                    break;
                case 2:
                    System.out.println("=========================================================");
                    System.out.println("|                T E R I M A   K A S I H                |");
                    System.out.println("=========================================================");
                    System.exit(0);
                default:
                    System.out.println("=========================================================");
                    System.out.println("|               MASUKKAN DENGAN BENAR !!!!              |");
                    System.out.println("=========================================================");
            }
        }
    }

    private static void menuPendataan() {
        while (true) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|          SISTEM PENDATAAN SEMBAKO INDOMARRIED         |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("=========================================================");
            System.out.println("|                  1. Tambah sembako                    |");
            System.out.println("=========================================================");
            System.out.println("|                  2. Lihat sembako                     |");
            System.out.println("=========================================================");
            System.out.println("|                  3. Ubah Stok sembako                 |");
            System.out.println("=========================================================");
            System.out.println("|                  4. Hapus sembako                     |");
            System.out.println("=========================================================");
            System.out.println("|               0. Kembali ke Menu Utama                |");
            System.out.println("=========================================================");
            System.out.print("PILIH MENU : ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahSembako(); 
                    break;
                case 2:
                    lihatSembako(); 
                    break;
                case 3:
                    ubahStokSembako();
                    break;
                case 4:
                    hapusSembako(); 
                    break;
                case 0:
                    return;
                default:
                    System.out.println("=========================================================");
                    System.out.println("|               MASUKKAN DENGAN BENAR !!!!              |");
                    System.out.println("=========================================================");
            }
        }
    }

    private static void tambahSembako() {
        System.out.println("Pilih jenis sembako:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
    
        switch (pilihan) {
            case 1:
                tambahSembakoMakanan();
                break;
            case 2:
                tambahSembakoMinuman();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }
    
    private static void tambahSembakoMakanan() {
        System.out.print("Masukkan nama makanan: ");
        String nama = scanner.next();
        System.out.print("Masukkan harga makanan: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan stok makanan: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan jumlah makanan: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan kategori makanan: ");
        String kategori = scanner.next();
    
        Makanan makananBaru = new Makanan(nama, harga, stok, jumlah, kategori);
        daftarSembako.add(makananBaru);
    
        System.out.println("MAKANAN BERHASIL DITAMBAHKAN KE STOK");
    }
    
    private static void tambahSembakoMinuman() {
        System.out.print("Masukkan nama minuman: ");
        String nama = scanner.next();
        System.out.print("Masukkan harga minuman: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan stok minuman: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan jumlah minuman: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan kategori minuman: ");
        String kategori = scanner.next();
    
        Minuman minumanBaru = new Minuman(nama, harga, stok, jumlah, kategori);
        daftarSembako.add(minumanBaru);
    
        System.out.println("MINUMAN BERHASIL DITAMBAHKAN KE STOK");
    }
    
    private static void lihatSembako() {
        while (true) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|             LIHAT SEMBAKO - SEMBAKO INDOMARRIED        |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("=========================================================");
            System.out.println("|                   1. Lihat semua sembako              |");
            System.out.println("=========================================================");
            System.out.println("|                   2. Lihat data makanan               |");
            System.out.println("=========================================================");
            System.out.println("|                   3. Lihat data minuman               |");
            System.out.println("=========================================================");
            System.out.println("|                   0. Kembali ke Menu Utama            |");
            System.out.println("=========================================================");
            System.out.print("PILIH MENU : ");
    
            int pilihan = scanner.nextInt();
    
            if (pilihan == 1) {
                lihatSemuaSembako();
            } else if (pilihan == 2) {
                lihatDataMakanan();
            } else if (pilihan == 3) {
                lihatDataMinuman();
            } else if (pilihan == 0) {
                return;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void lihatSemuaSembako() {
        if (daftarSembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                       DAFTAR SEMBAKO INDOMARRIED                  |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.printf("| %-20s | %-10s | %-10s | %-10s |\n", "Nama sembako", "Harga", "Stok", "Jumlah");
            System.out.println("+======================+============+============+============+");
    
            for (Sembako sembako : daftarSembako) { 
                System.out.printf("| %-20s | %-10d | %-10d | %-10d |\n", sembako.getNama(), sembako.getHarga(), sembako.getStok(), sembako.getJumlah());
            }
    
            System.out.println("+======================+============+============+============+");
        }
    }
    
    private static void lihatDataMakanan() {
        if (daftarSembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                  DAFTAR MAKANAN INDOMARRIED                      |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.printf("| %-20s | %-10s | %-10s | %-10s | %-15s |\n", "Nama makanan", "Harga", "Stok", "Jumlah", "Kategori");
            System.out.println("+======================+============+============+============+=================+");
    
            for (Sembako sembako : daftarSembako) {
                if (sembako instanceof Makanan) {
                    Makanan makanan = (Makanan) sembako;
                    System.out.printf("| %-20s | %-10d | %-10d | %-10d | %-15s |\n", makanan.getNama(), makanan.getHarga(), makanan.getStok(), makanan.getJumlah(), makanan.getKategoriMakanan());
                }
            }
    
            System.out.println("+======================+============+============+============+=================+");
        }
    }
    
    private static void lihatDataMinuman() {
        if (daftarSembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                  DAFTAR MINUMAN INDOMARRIED                      |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.printf("| %-20s | %-10s | %-10s | %-10s | %-15s |\n", "Nama minuman", "Harga", "Stok", "Jumlah", "Kategori");
            System.out.println("+======================+============+============+============+=================+");
    
            for (Sembako sembako : daftarSembako) {
                if (sembako instanceof Minuman) {
                    Minuman minuman = (Minuman) sembako;
                    System.out.printf("| %-20s | %-10d | %-10d | %-10d | %-15s |\n", minuman.getNama(), minuman.getHarga(), minuman.getStok(), minuman.getJumlah(), minuman.getKategoriMinuman());
                }
            }
    
            System.out.println("+======================+============+============+============+=================+");
        }
    }
    
    private static void ubahStokSembako() {
        if (daftarSembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatSemuaSembako();
            System.out.print("Masukkan nama sembako yang ingin diubah: ");
            String namasembako = scanner.next();

            ubahStokSembako(namasembako); // Panggil metode overloading dengan satu parameter
        }
    }

    // Overloading ubahStokSembako dengan satu parameter (nama sembako)
    private static void ubahStokSembako(String namasembako) {
        boolean ditemukan = false;
        for (Sembako sembako : daftarSembako) {
            if (sembako.getNama().equalsIgnoreCase(namasembako)) {
                System.out.print("Masukkan harga baru: ");
                int hargaBaru = scanner.nextInt();
                System.out.print("Masukkan stok baru: ");
                int stokBaru = scanner.nextInt();
                System.out.print("Masukkan jumlah baru: ");
                int jumlahBaru = scanner.nextInt();

                sembako.setHarga(hargaBaru);
                sembako.setStok(stokBaru);
                sembako.setJumlah(jumlahBaru);

                System.out.println("Data sembako berhasil diubah.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("SEMBAKO TIDAK DITEMUKAN");
        }
    }
    
    private static void hapusSembako() {
        if (daftarSembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatSemuaSembako();
            System.out.print("MASUKKAN SEMBAKO YANG TELAH HABIS : ");
            String namasembako = scanner.next();
    
            boolean ditemukan = false;
            for (int i = 0; i < daftarSembako.size(); i++) {
                if (daftarSembako.get(i).getNama().equalsIgnoreCase(namasembako)) {
                    daftarSembako.remove(i);
                    System.out.println("=========================================================");
                    System.out.println("|                SEMBAKO BERHASIL DIHAPUS               |");
                    System.out.println("=========================================================");
                    ditemukan = true;
                    break;
                }
            }
    
            if (!ditemukan) {
                System.out.println("SEMBAKO TIDAK DITEMUKAN");
            }
        }
    }
}
