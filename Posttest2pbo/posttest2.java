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

public class posttest2 {
    private static ArrayList<Sembako> daftarsembako = new ArrayList<>(); // Perubahan disini: menggunakan Sembako, bukan sembako
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
                    tambahSembako(); // Perubahan disini: menggunakan tambahSembako(), bukan tambahsembako()
                    break;
                case 2:
                    lihatSembako(); // Perubahan disini: menggunakan lihatSembako(), bukan lihatsembako()
                    break;
                case 3:
                    ubahStokSembako(); // Perubahan disini: menggunakan ubahStokSembako(), bukan ubahStoksembako()
                    break;
                case 4:
                    hapusSembako(); // Perubahan disini: menggunakan hapusSembako(), bukan hapussembako()
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
        System.out.print("Masukkan nama sembako: ");
        String nama = scanner.next();
        System.out.print("Masukkan harga sembako: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan stok sembako: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan jumlah sembako: ");
        int jumlah = scanner.nextInt();

        Sembako sembakoBaru = new Sembako(nama, harga, stok, jumlah);
        daftarsembako.add(sembakoBaru);

        System.out.println("SEMBAKO BERHASIL DITAMBAHKAN KE STOK");
    }

    private static void lihatSembako() {
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

            for (Sembako sembako : daftarsembako) { // Perubahan disini: menggunakan Sembako, bukan sembako
                System.out.printf("| %-20s | %-10d | %-10d | %-10d |\n", sembako.getNama(), sembako.getHarga(), sembako.getStok(), sembako.getJumlah());
            }

            System.out.println("+======================+============+============+============+");
        }
    }

    private static void ubahStokSembako() { // Perubahan disini: menggunakan ubahStokSembako(), bukan ubahStoksembako()
        if (daftarsembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatSembako(); // Perubahan disini: menggunakan lihatSembako(), bukan lihatsembako()
            System.out.print("Masukkan nama sembako yang ingin diubah: ");
            String namasembako = scanner.next();
    
            boolean ditemukan = false;
            for (Sembako sembako : daftarsembako) { // Perubahan disini: menggunakan Sembako, bukan sembako
                if (sembako.getNama().equalsIgnoreCase(namasembako)) {
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.next();
                    System.out.print("Masukkan harga baru: ");
                    int hargaBaru = scanner.nextInt();
                    System.out.print("Masukkan stok baru: ");
                    int stokBaru = scanner.nextInt();
                    System.out.print("Masukkan jumlah baru: ");
                    int jumlahBaru = scanner.nextInt();
    
                    sembako.setNama(namaBaru); // Perubahan disini: menggunakan setNama(), bukan sembako.nama
                    sembako.setHarga(hargaBaru); // Perubahan disini: menggunakan setHarga(), bukan sembako.harga
                    sembako.setStok(stokBaru); // Perubahan disini: menggunakan setStok(), bukan sembako.stok
                    sembako.setJumlah(jumlahBaru); // Perubahan disini: menggunakan setJumlah(), bukan sembako.jumlah
    
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
    

    private static void hapusSembako() { // Perubahan disini: menggunakan hapusSembako(), bukan hapussembako()
        if (daftarsembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatSembako(); // Perubahan disini: menggunakan lihatSembako(), bukan lihatsembako()
            System.out.print("MASUKKAN SEMBAKO YANG TELAH HABIS : ");
            String namasembako = scanner.next();

            boolean ditemukan = false;
            for (int i = 0; i < daftarsembako.size(); i++) {
                if (daftarsembako.get(i).getNama().equalsIgnoreCase(namasembako)) { // Perubahan disini: menggunakan getNama(), bukan sembako.nama
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
