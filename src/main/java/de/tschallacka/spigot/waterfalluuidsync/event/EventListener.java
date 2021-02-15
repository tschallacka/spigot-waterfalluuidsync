package de.tschallacka.spigot.waterfalluuidsync.event;

import de.tschallacka.spigot.waterfalluuidsync.WaterfallUuidSync;
import org.bukkit.event.EventHandler;
// EventHandler import needed for the event.
import org.bukkit.event.Listener;
// Listener import needed for the event.
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {

    @EventHandler
    // EventHandler to recognize the event.
    public void onPlayerJoin(PlayerJoinEvent event){
        WaterfallUuidSync.plugin.getPlayerUuidFromWaterfall(event.getPlayer());
    }

}
