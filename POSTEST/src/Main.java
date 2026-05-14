public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEM LOGISTIK DAN PENGIRIMAN KARGO (LOGISTIK-PRO)   ");

        // 1. Instansiasi Objek
        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);

        // 2. Update Status Pengiriman
        darat.updateStatus("Sedang di jalan tol Simprug");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        // 3. Array Polymorphism bertipe LayananPengiriman (Upcasting)
        LayananPengiriman[] daftarKargo = { darat, udara };

        // 4. Perulangan untuk menelusuri array
        int urutan = 1;
        for (LayananPengiriman paket : daftarKargo) {
            System.out.println("--- RINCIAN KARGO " + urutan + " ---");
            
            // Panggil cetakResi() bawaan Abstract Class
            paket.cetakResi();

            // Pengecekan Lokasi menggunakan Downcasting secara polimorfik ke Interface LacakKargo
            if (paket instanceof LacakKargo) {
                LacakKargo pelacak = (LacakKargo) paket;
                System.out.println("Status Terkini : " + pelacak.cekLokasiTerakhir());
            }

            // Hitung Ongkos Kirim Dasar (Runtime Polymorphism)
            double totalTagihan = paket.hitungOngkosKirim();
            System.out.println("Ongkir Dasar   : Rp " + totalTagihan);

            // Cek jika layanan memiliki fitur asuransi menggunakan instanceof
            if (paket instanceof Asuransi) {
                // Downcasting ke Interface Asuransi
                Asuransi fiturAsuransi = (Asuransi) paket;
                fiturAsuransi.cetakPolis(); // Memanggil default method
                
                // Downcasting untuk mengambil spesifik nilai barang milik PengirimanUdara
                double nilaiAset = ((PengirimanUdara) paket).getNilaiBarang();
                
                // Hitung premi dan tambahkan ke tagihan
                double premi = fiturAsuransi.hitungPremi(nilaiAset);
                System.out.println("Biaya Premi    : Rp " + premi);
                
                totalTagihan += premi; // Total = Ongkir Dasar + Asuransi
            }

            System.out.println("TOTAL TAGIHAN  : Rp " + totalTagihan);
            System.out.println("---------------------------------------------------------");
            urutan++;
        }
    }
}