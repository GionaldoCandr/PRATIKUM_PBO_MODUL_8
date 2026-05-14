import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Membuat ArrayList bertipe Superclass (Upcasting secara implisit)
        ArrayList<Pembayaran> daftarTransaksi = new ArrayList<>();

        // Instansiasi objek dengan data acak
        Pembayaran txKartuKredit = new KartuKredit("Gionaldo ", 1000000, "1111-2222-3333-4444");
        Pembayaran txEWallet = new EWallet("Ultraman", 150000, "081298765432");

        // Menyimpan objek ke dalam koleksi
        daftarTransaksi.add(txKartuKredit);
        daftarTransaksi.add(txEWallet);

        // Menelusuri ArrayList menggunakan for-each
        int urutan = 1;
        for (Pembayaran transaksi : daftarTransaksi) {
            System.out.println("--- Transaksi " + urutan + " ---");
            
            // 1. Memanggil concrete method milik superclass
            transaksi.tampilkanDetail();

            // 2. Mengecek apakah objek mengimplementasikan antarmuka Keamanan
            if (transaksi instanceof Keamanan) {
                // Downcasting: Mengubah referensi Pembayaran menjadi referensi Keamanan
                // agar kita bisa memanggil metode autentikasi()
                Keamanan keamananSistem = (Keamanan) transaksi;
                
                // 3. Panggil metode autentikasi
                boolean isLolos = keamananSistem.autentikasi();

                // 4. Jika true, maka lanjutkan ke proses pembayaran
                if (isLolos) {
                    // Karena Runtime Polymorphism, Java akan memanggil logika
                    // milik KartuKredit atau EWallet sesuai wujud asli objeknya
                    transaksi.prosesPembayaran();
                }
            } else {
                System.out.println("[SISTEM] Transaksi ditolak karena tidak memiliki standar keamanan!");
            }
            
            System.out.println();
            urutan++;
        }
    }
}