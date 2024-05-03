import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Penjualan {
    int hitungTotalPenjualan();
}

abstract class Sembako {
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

    public final void setHarga(int harga) {
        this.harga = harga;
    }

    public final int getHarga() {
        return harga;
    }

    public final void setStok(int stok) {
        this.stok = stok;
    }

    public final int getStok() {
        return stok;
    }

    public final void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public final int getJumlah() {
        return jumlah;
    }

    public final String getNama() {
        return nama;
    }

    public final void setNama(String nama) {
        this.nama = nama;
    }

    public abstract String getDeskripsi();
}

class Makanan extends Sembako {
    private String deskripsi;

    public Makanan(String nama, int harga, int stok, int jumlah, String deskripsi) {
        super(nama, harga, stok, jumlah);
        this.deskripsi = deskripsi;
    }

    @Override
    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public String toString() {
        return "Nama: " + getNama() + ", Harga: " + getHarga() + ", Stok: " + getStok() + ", Jumlah: " + getJumlah() + ", Deskripsi: " + getDeskripsi();
    }
}

class Minuman extends Sembako {
    private String kategori;

    public Minuman(String nama, int harga, int stok, int jumlah, String kategori) {
        super(nama, harga, stok, jumlah);
        this.kategori = kategori;
    }

    @Override
    public String getDeskripsi() {
        return kategori;
    }

    @Override
    public String toString() {
        return "Nama: " + getNama() + ", Harga: " + getHarga() + ", Stok: " + getStok() + ", Jumlah: " + getJumlah() + ", Kategori: " + getDeskripsi();
    }
}

public class posttest6 implements Penjualan {
    private static final ArrayList<Sembako> daftarSembako = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int hitungTotalPenjualan() {
        int totalPenjualan = 0;
        for (Sembako sembako : daftarSembako) {
            totalPenjualan += sembako.getHarga() * sembako.getJumlah();
        }
        return totalPenjualan;
    }

    public static void main(String[] args) {
        tampilkanMenuUtama();
    }

    private static void tampilkanMenuUtama() {
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

            int pilihanUtama = inputangka();

            switch (pilihanUtama) {
                case 1:
                    tampilkanMenuPendataan();
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

    private static void tampilkanMenuPendataan() {
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

            int pilihan = inputangka();

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
        int pilihan = inputangka();

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
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga makanan: ");
        int harga = inputangka();
        System.out.print("Masukkan stok makanan: ");
        int stok = inputangka();
        System.out.print("Masukkan jumlah makanan: ");
        int jumlah = inputangka();
        System.out.print("Masukkan deskripsi makanan: ");
        String deskripsi = scanner.nextLine();

        Makanan makananBaru = new Makanan(nama, harga, stok, jumlah, deskripsi);
        daftarSembako.add(makananBaru);

        System.out.println("MAKANAN BERHASIL DITAMBAHKAN KE STOK");
    }

    private static void tambahSembakoMinuman() {
        System.out.print("Masukkan nama minuman: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga minuman: ");
        int harga = inputangka();
        System.out.print("Masukkan stok minuman: ");
        int stok = inputangka();
        System.out.print("Masukkan jumlah minuman: ");
        int jumlah = inputangka();
        System.out.print("Masukkan kategori minuman: ");
        String kategori = scanner.nextLine();

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

            int pilihan = inputangka();

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
            System.out.printf("| %-20s | %-10s | %-10s | %-10s | %-15s |\n", "Nama makanan", "Harga", "Stok", "Jumlah", "Deskripsi");
            System.out.println("+======================+============+============+============+=================+");

            for (Sembako sembako : daftarSembako) {
                if (sembako instanceof Makanan) {
                    Makanan makanan = (Makanan) sembako;
                    System.out.printf("| %-20s | %-10d | %-10d | %-10d | %-15s |\n", makanan.getNama(), makanan.getHarga(), makanan.getStok(), makanan.getJumlah(), makanan.getDeskripsi());
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
                    System.out.printf("| %-20s | %-10d | %-10d | %-10d | %-15s |\n", minuman.getNama(), minuman.getHarga(), minuman.getStok(), minuman.getJumlah(), minuman.getDeskripsi());
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
            String namaSembako = scanner.nextLine(); 

            ubahStokSembako(namaSembako); 
        }
    }

    private static void ubahStokSembako(String namaSembako) {
        boolean ditemukan = false;
        for (Sembako sembako : daftarSembako) {
            if (sembako.getNama().equalsIgnoreCase(namaSembako)) {
                System.out.print("Masukkan harga baru: ");
                int hargaBaru = inputangka();
                System.out.print("Masukkan stok baru: ");
                int stokBaru = inputangka();
                System.out.print("Masukkan jumlah baru: ");
                int jumlahBaru = inputangka();

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
            String namaSembako = scanner.nextLine();

            boolean ditemukan = false;
            for (int i = 0; i < daftarSembako.size(); i++) {
                if (daftarSembako.get(i).getNama().equalsIgnoreCase(namaSembako)) {
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

    private static int inputangka() {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Masukkan angka !!!");
                scanner.nextLine(); 
                System.out.print("Masukkan kembali: ");
            }
        }

        scanner.nextLine();
        return input;
    }
}
