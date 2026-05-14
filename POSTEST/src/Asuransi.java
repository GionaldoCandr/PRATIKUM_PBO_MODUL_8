interface Asuransi {
    // Abstract method
    double hitungPremi(double nilaiBarang);
    
    // Default method 
    default void cetakPolis() {
        System.out.println("Polis Asuransi aktif: Menanggung kehilangan dan kerusakan fisik sebesar 100% dari nilai barang.");
    }
}