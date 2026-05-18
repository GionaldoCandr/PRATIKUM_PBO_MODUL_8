package com.rpg.arena;

public abstract class Karakter implements AksiBertarung {
    // Encapsulation menggunakan access modifier protected
    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;

    // Constructor untuk inisialisasi awal
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; // Default false
    }

    // Getter dan Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    
    public int getBaseDamage() { return baseDamage; }
    public void setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; }
    
    public boolean getIsDefending() { return isDefending; }
    public void setIsDefending(boolean isDefending) { this.isDefending = isDefending; }

    // Metode menerima damage dengan logika pertahanan
    public void terimaDamage(int damage) {
        if (this.isDefending) {
            damage = damage / 2; // Damage berkurang setengah jika bertahan
            this.isDefending = false; // Kembalikan status
        }
        
        this.hp -= damage;
        
        // Pastikan HP mentok di angka 0 (tidak minus)
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    // Abstract method
    public abstract void tampilkanStatus();
}