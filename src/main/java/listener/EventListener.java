package listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.network.protocol.SetLocalPlayerAsInitializedPacket;
import net.ardadmrkn.Main;

public class EventListener implements Listener {


    private Main plugin;

    public EventListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        e.setJoinMessage("§8[§a+§8] §a" + player.getName());
    }

@EventHandler
public void onData(DataPacketReceiveEvent event){
        if(event.getPacket() instanceof SetLocalPlayerAsInitializedPacket) {
            plugin.getServer().broadcastMessage("Sunucuya hoşgeldin ");
        }
}



    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(player.getName()+ " adlı oyuncu çıkış yaptı");
    }
}
