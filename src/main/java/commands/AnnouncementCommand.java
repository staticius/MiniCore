package commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.ardadmrkn.Main;

public class AnnouncementCommand extends Command {

    public AnnouncementCommand(){
        super("duyuru", "Adminler için duyuru komutu", "/duyuru <mesaj>", new String[]{"d"});
        this.setPermission("pn.duyuru");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {

        if(sender.hasPermission("pn.duyuru")){
            if(args.length > 0) {


                String message = String.join(" ", args);
                Main.getInstance().getServer().broadcastMessage("§8[§cDuyuru§8]§r" + message);
            } else {
                sender.sendMessage("Lütfen bir mesaj gir");
            }
        } else {
            sender.sendMessage("Yetkin yok");
        }

        return false;
    }
}
