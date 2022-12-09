package me.rekuseq.warpmenusreku.Utilities;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Warp {

    private String name;
    private int slot_number;
    private ItemStack item;
    private String display_name;
    private List<String> lore;

    public Warp(String name, int slot_number, ItemStack item, String display_name, List<String> lore){
        this.name = name;
        this.slot_number = slot_number;
        this.item = item;
        this.display_name = display_name;
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSlot_number() {
        return slot_number;
    }

    public void setSlot_number(int slot_number) {
        this.slot_number = slot_number;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public String getDisplay_name() {
        return ChatColor.translateAlternateColorCodes('&', display_name);
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public List<String> getLore() {
        List<String> colored_lore = new ArrayList<>();
        for(String str : lore){
            colored_lore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        return colored_lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }
}
