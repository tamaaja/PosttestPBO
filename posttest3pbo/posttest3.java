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
}


public class posttest3 {
    private static ArrayList<Sembako> daftarsembako = new ArrayList<>();
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

            for (Sembako sembako : daftarsembako) { 
                System.out.printf("| %-20s | %-10d | %-10d | %-10d |\n", sembako.getNama(), sembako.getHarga(), sembako.getStok(), sembako.getJumlah());
            }

            System.out.println("+======================+============+============+============+");
        }
    }

    private static void ubahStokSembako() { 
        if (daftarsembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatSembako(); 
            System.out.print("Masukkan nama sembako yang ingin diubah: ");
            String namasembako = scanner.next();
    
            boolean ditemukan = false;
            for (Sembako sembako : daftarsembako) { 
                if (sembako.getNama().equalsIgnoreCase(namasembako)) {
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.next();
                    System.out.print("Masukkan harga baru: ");
                    int hargaBaru = scanner.nextInt();
                    System.out.print("Masukkan stok baru: ");
                    int stokBaru = scanner.nextInt();
                    System.out.print("Masukkan jumlah baru: ");
                    int jumlahBaru = scanner.nextInt();
    
                    sembako.setNama(namaBaru); 
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
    }
    

    private static void hapusSembako() {
        if (daftarsembako.isEmpty()) {
            System.out.println("=========================================================");
            System.out.println("|          Data sembako Indomarried masih kosong        |");
            System.out.println("=========================================================");
        } else {
            lihatSembako();
            System.out.print("MASUKKAN SEMBAKO YANG TELAH HABIS : ");
            String namasembako = scanner.next();

            boolean ditemukan = false;
            for (int i = 0; i < daftarsembako.size(); i++) {
                if (daftarsembako.get(i).getNama().equalsIgnoreCase(namasembako)) { 
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
