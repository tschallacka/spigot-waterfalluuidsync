package de.tschallacka.spigot.waterfalluuidsync;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.tschallacka.spigot.waterfalluuidsync.event.EventListener;
import de.tschallacka.spigot.waterfalluuidsync.message.MessageListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class WaterfallUuidSync extends JavaPlugin {
    public static WaterfallUuidSync plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new EventListener(),  this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new MessageListener());
    }

    @Override
    public void onDisable() {
        plugin = null;

    }

    public void getPlayerUuidFromWaterfall(Player player)
    {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("UUIDOther");
        out.writeUTF(player.getName());
        player.sendPluginMessage(WaterfallUuidSync.plugin, "BungeeCord", out.toByteArray());
    }
}
