package me.hephaestus2023.bed;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.Plugin;

public class BedListener implements Listener {

    Plugin plugin = Bed.getPlugin(Bed.class);

    @EventHandler
    public void bed(PlayerBedLeaveEvent event){
        Player p = event.getPlayer();
        String m = plugin.getConfig().getString("message");
        int h = plugin.getConfig().getInt("health");

        p.sendMessage(m);
        p.setHealth(h);



    }

}
