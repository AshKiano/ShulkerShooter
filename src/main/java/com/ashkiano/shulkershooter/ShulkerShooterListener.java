package com.ashkiano.shulkershooter;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class ShulkerShooterListener implements Listener {

    private ShulkerShooter plugin;

    public ShulkerShooterListener(ShulkerShooter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasLore() && meta.getLore().contains("§7Mystical item with the power of Shulkers")) {
                // Vystřelí Shulkerovu kouli
                ShulkerBullet bullet = player.getWorld().spawn(player.getEyeLocation(), ShulkerBullet.class);
                bullet.setShooter(player);
                Vector direction = player.getLocation().getDirection();
                bullet.setVelocity(direction.multiply(1.5)); // Nastaví rychlost a směr koule
            }
        }
    }
}