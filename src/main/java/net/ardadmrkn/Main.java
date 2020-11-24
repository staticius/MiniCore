package net.ardadmrkn;

import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.PluginBase;
import commands.AnnouncementCommand;
import commands.FlyCommand;
import commands.FoodCommand;
import commands.HealCommand;
import listener.EventListener;

public class Main extends PluginBase {

    public static Main instance;

    public void onLoad(){
        instance = this;
    }

     @Override
    public void onEnable(){
         getServer().getPluginManager().registerEvents(new EventListener(this), this);
         registerCommands();
         getLogger().info("Aktif");
     }
    private void registerCommands() {
        CommandMap commandMap = getServer().getCommandMap();

        commandMap.register("fly", new FlyCommand());
        commandMap.register("food", new FoodCommand());
        commandMap.register("heal", new HealCommand());
        commandMap.register("duyuru", new AnnouncementCommand());
    }

    public static Main getInstance(){
        return instance;
    }

}
