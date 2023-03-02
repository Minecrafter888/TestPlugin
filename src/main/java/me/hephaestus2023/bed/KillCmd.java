package me.hephaestus2023.bed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KillCmd implements CommandExecutor {

    Plugin plugin = Bed.getPlugin(Bed.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {

                p.sendMessage("you've killed yourself");
                p.setHealth(0.0);

            } else if (args.length == 1) {

                String playername = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playername);

                if (target == null) {

                    p.sendMessage("player is offline");

                } else {
                    int h = plugin.getConfig().getInt("murderhealthset");
                    target.setHealth(h);
                    target.sendMessage(p.getDisplayName() + " has killed you. return the favor however you see fit");
                    p.sendMessage("You have killed " + target.getDisplayName() + ". Your actions are sickening");
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 3));
                }
            }
        }


        return true;
    }
}
