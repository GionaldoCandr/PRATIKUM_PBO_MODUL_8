package com.rpg.entitas;
import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter {
    // Atribut tambahan terenkapsulasi
    private int mana;
    private int level;

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage); // Memanggil constructor induk
        this.mana = mana;
        this.level = level;
    }

    // OVERRIDING
    @Override
    public int serang() {
        return this.baseDamage * this.level;
    }

    @Override
    public void bertahan() {
        this.isDefending = true;
        System.out.println("\n" + this.nama + " bersiaga untuk menahan serangan!");
    }

    @Override
    public void gunakanItem() {
        this.hp += 30;
        System.out.println(this.nama + " meminum Potion! HP bertambah 30.");
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("=== STATUS PAHLAWAN ===");
        System.out.println("Nama  : " + this.nama + " (Lv. " + this.level + ")");
        System.out.println("HP    : " + this.hp);
        System.out.println("Mana  : " + this.mana);
    }

    // OVERLOADING
    public int serang(String namaSkill, int manaCost) {
        if (this.mana >= manaCost) {
            this.mana -= manaCost;
            System.out.println("\n" + this.nama + " mengeluarkan skill spesial: " + namaSkill + "!");
            return this.baseDamage * this.level * 2;
        } else {
            System.out.println("\nMana tidak cukup untuk menggunakan " + namaSkill + "! Serangan gagal.");
            return 0;
        }
    }
}