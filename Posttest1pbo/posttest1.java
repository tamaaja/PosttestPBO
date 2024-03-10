import java.util.ArrayList;
import java.util.Scanner;

class sembako {
    String nama;
    int harga;
    int stok;
    int jumlah;

    public sembako(String nama, int harga, int stok, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.jumlah = jumlah;
    }
}

public class posttest1 {
    private static ArrayList<sembako> daftarsembako = new ArrayList<>();
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
                    tambahsembako();
                    break;
                case 2:
                    lihatsembako();
                    break;
                case 3:
                    ubahStoksembako();
                    break;
                case 4:
                    hapussembako();
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

    private static void tambahsembako() {
        System.out.print("Masukkan nama sembako: ");
        String nama = scanner.next();
        System.out.print("Masukkan harga sembako: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan stok sembako: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan jumlah sembako: ");
        int jumlah = scanner.nextInt();

        sembako sembakoBaru = new sembako(nama, harga, stok, jumlah);
        daftarsembako.add(sembakoBaru);

        System.out.println("SEMBAKO BERHASIL DITAMBAHKAN KE STOK");
    }

    private static void lihatsembako() {
        if (daftarsembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                       DAFTAR SEMBAKO INDOMARRIED                  |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.printf("| %-20s | %-10s | %-10s | %-10s |\n", "Nama sembako", "Harga", "Stok", "Jumlah");
            System.out.println("+======================+============+============+============+");

            for (sembako sembako : daftarsembako) {
                System.out.printf("| %-20s | %-10d | %-10d | %-10d |\n", sembako.nama, sembako.harga, sembako.stok, sembako.jumlah);
            }

            System.out.println("+======================+============+============+============+");
        }
    }

    private static void ubahStoksembako() {
        if (daftarsembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatsembako();
            System.out.print("Masukkan nama sembako yang ingin diubah: ");
            String namasembako = scanner.next();
    
            boolean ditemukan = false;
            for (sembako sembako : daftarsembako) {
                if (sembako.nama.equalsIgnoreCase(namasembako)) {
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.next();
                    System.out.print("Masukkan harga baru: ");
                    int hargaBaru = scanner.nextInt();
                    System.out.print("Masukkan stok baru: ");
                    int stokBaru = scanner.nextInt();
                    System.out.print("Masukkan jumlah baru: ");
                    int jumlahBaru = scanner.nextInt();
    
                    sembako.nama = namaBaru;
                    sembako.harga = hargaBaru;
                    sembako.stok = stokBaru;
                    sembako.jumlah = jumlahBaru;
    
                    System.out.println("Data sembako berhasil diubah.");
                    ditemukan = true;
                    break;
                }
            }
    
            if (!ditemukan) {
                System.out.println("SEMBAKO TIDAK DITEMUKAN");
            }
        }
    }
    

    private static void hapussembako() {
        if (daftarsembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatsembako();
            System.out.print("MASUKKAN SEMBAKO YANG TELAH HABIS : ");
            String namasembako = scanner.next();

            boolean ditemukan = false;
            for (int i = 0; i < daftarsembako.size(); i++) {
                if (daftarsembako.get(i).nama.equalsIgnoreCase(namasembako)) {
                    daftarsembako.remove(i);
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
