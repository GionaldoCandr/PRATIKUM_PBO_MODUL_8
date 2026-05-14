abstract class LayananPengiriman {
    // Atribut dengan modifier protected
    protected String noResi;
    protected double beratBarang; // kg
    protected double jarakTempuh; // km

    // Constructor untuk inisialisasi
    public LayananPengiriman(String noResi, double beratBarang, double jarakTempuh) {
        this.noResi = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
    }

    // Concrete method
    public void cetakResi() {
        System.out.println("Nomor Resi   : " + this.noResi);
        System.out.println("Berat Barang : " + this.beratBarang + " kg");
        System.out.println("Jarak Tempuh : " + this.jarakTempuh + " km");
    }

    // Abstract method tanpa body
    public abstract double hitungOngkosKirim();
}
