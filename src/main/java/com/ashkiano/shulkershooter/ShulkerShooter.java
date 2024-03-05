package com.ashkiano.shulkershooter;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ShulkerShooter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registrace event listenerů
        getServer().getPluginManager().registerEvents(new ShulkerShooterListener(this), this);

        Metrics metrics = new Metrics(this, 20933);

        this.getLogger().info("Thank you for using the ShulkerShooter plugin! If you enjoy using this plugin, please consider making a donation to support the development. You can donate at: https://donate.ashkiano.com");
    }

    @Override
    public void onDisable() {
        // Plugin je vypnut
    }

    public ItemStack createShulkerShooter() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§6Shulker Shooter");
        List<String> lore = new ArrayList<>();
        lore.add("§7Mystical item with the power of Shulkers");
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("givesshooter") && sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack shulkerShooter = createShulkerShooter(); // Použijte metodu pro vytvoření itemu
            player.getInventory().addItem(shulkerShooter);
            player.sendMessage("§aYou have been given a Shulker Shooter!");
            return true;
        }
        return false;
    }
}
