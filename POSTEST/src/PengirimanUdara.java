// Mewarisi LayananPengiriman dan mengimplementasikan KEDUA antarmuka
class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    public PengirimanUdara(String noResi, double beratBarang, double jarakTempuh, String nomorPenerbangan, double nilaiBarang) {
        super(noResi, beratBarang, jarakTempuh);
        this.nomorPenerbangan = nomorPenerbangan;
        this.nilaiBarang = nilaiBarang;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
    }

    // Override dari Abstract Class LayananPengiriman
    @Override
    public double hitungOngkosKirim() {
        return (this.beratBarang * 25000) + (this.jarakTempuh * 5000);
    }

    // Override dari Interface LacakKargo
    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return this.statusSaatIni;
    }

    // Override dari Interface Asuransi
    @Override
    public double hitungPremi(double nilaiBarang) {
        return 0.03 * nilaiBarang; // 3% dari total nilai barang
    }

    // Getter tambahan agar Main class bisa mengambil nilai barang untuk dimasukkan ke argumen hitungPremi
    public double getNilaiBarang() {
        return this.nilaiBarang;
    }
}