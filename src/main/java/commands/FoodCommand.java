package commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

public class FoodCommand extends Command {

    public FoodCommand(){
        super("food", "Doyurur", "/food", new String[]{"doyur", "yemek"});
        this.setPermission("pn.food");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;
            if (player.hasPermission("pn.food")){

                player.getFoodData().setLevel(player.getFoodData().getMaxLevel());
                player.sendMessage("§aAçlığın giderildi");

            } else {
                sender.sendMessage("Yetkin yok!");
            }

        } else{
            sender.sendMessage("Bu komutu oyun içinde kullan!");
        }
        return false;
    }
}
