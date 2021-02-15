package de.tschallacka.spigot.waterfalluuidsync.message;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.tschallacka.spigot.waterfalluuidsync.WaterfallUuidSync;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.UUID;

public class MessageListener implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message)
    {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("UUIDOther")) {
            String playerName = in.readUTF();
            String uuid = in.readUTF();


            if(player.getName().equals(playerName)) {

                UUID uuidReal = new UUID(Long.parseLong(uuid.substring(0, uuid.length() / 2), 16),
                                         Long.parseLong(uuid.substring(uuid.length() / 2, uuid.length()-1), 16));
                WaterfallUuidSync.plugin.getLogger().info("Player: "+player.getName()+"; Local UUID: "+player.getUniqueId() + " - WaterFall UUID " + uuidReal);
            }
        }
    }


}
