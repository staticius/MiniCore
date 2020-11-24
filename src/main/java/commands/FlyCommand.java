package commands;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class FlyCommand extends Command {

    public FlyCommand(){
        super("fly", "Fly mode", "/fly", new String[]{"uc"});
        this.setPermission("pn.fly");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("pn.fly")){
                boolean hasFly = player.getAdventureSettings().get(AdventureSettings.Type.ALLOW_FLIGHT);
                if (hasFly){
                    player.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, false);
                    player.getAdventureSettings().update();
                    player.sendMessage("§cFly modu kapalı");
                    return false;
                } else {
                    player.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, true);
                    player.getAdventureSettings().update();
                    player.sendMessage("§aFly modu aktif");

                }
            } else {
                sender.sendMessage("Yetkin yok");
            }
        }else {
            sender.sendMessage("Bu komutu sunucu içinde kullan!");
        }

        return false;

    }
}
