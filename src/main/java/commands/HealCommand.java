package commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class HealCommand extends Command {

        public HealCommand(){
            super("heal", "Canını fuller", "/heal", new String[]{"can", "candoldur"});
            this.setPermission("pn.heal");
        }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
            if (sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission("pn.heal")){
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage("§aCanın fullendi");
                } else {
                    sender.sendMessage("Yetkin yok!");
                }
            } else {
                sender.sendMessage("Bu komutu oyun içinde kullan!");
            }
        return false;
    }
}
