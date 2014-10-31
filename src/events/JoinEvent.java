package events;

import me.NitroxMC.Lobby.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sql.MySQL;
import utils.Permissions;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(Permissions.isVIPPlus(p)) {
			Bukkit.broadcastMessage("§8[§aVIP§e+§8] §a" + p.getName() + " §ehas joined the lobby!");
		}
		    if (!MySQL.playerPlayedBefore(p.getName()).booleanValue()) {
		      MySQL.query("INSERT INTO `lobby_PLAYERS` (`NAME`, `PLAYED`, `CASH`, `TOKENS`) VALUES ('" + p.getName() + "', 0, 0, 0, 15)");
		    }
		    p.setScoreboard(Lobby.board);
	}

}
