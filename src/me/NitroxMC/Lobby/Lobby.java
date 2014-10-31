package me.NitroxMC.Lobby;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import sql.MySQL;
import utils.Permissions;
import cmds.AddCoins;
import cmds.AddTokens;
import events.GadgetShopVillager;
import events.JoinEvent;
import events.SlotTokens;

//---------------------------------------------------\\

public class Lobby extends JavaPlugin implements Listener {
	
	  public static Lobby instance = new Lobby();
	  public static Logger log;
	  public static Scoreboard board;
	  public static Lobby plugin;
	  
	  //---------------------------------------------------------\\
	  
	  public static Lobby getInstance()
	  {
	    return instance;
	  }
	  public void onEnable() {
	      new MySQL();
	      if (MySQL.firstconnect.booleanValue())
	      {
	        registerEvents();
	        registerCommands();
	        
	        getConfig().options().copyDefaults(true);
	        saveConfig();
	        
	      log.info("[Lobby] Plugin Enabled!");
	      }
	  }
	  public void onDisable() {
	    Bukkit.getServer().getScheduler().cancelAllTasks();
	    if (MySQL.firstconnect.booleanValue()) {
	      MySQL.disconnect();
	    }
	  }
	  

private void registerEvents() {
  PluginManager pm = getServer().getPluginManager();
  pm.registerEvents(this, this);
  pm.registerEvents(new JoinEvent(), this);
  pm.registerEvents(new GadgetShopVillager(), this);
  pm.registerEvents(new JoinEvent(), this);
  pm.registerEvents(new SlotTokens(), this);
}

private void registerCommands() {
  getCommand("addtokens").setExecutor(new AddTokens());
  getCommand("addcoins").setExecutor(new AddCoins());
}
@SuppressWarnings("deprecation")
public static void scoreboard(Player p) {
    board = Bukkit.getScoreboardManager().getNewScoreboard();
    board.registerNewObjective("lobby", "dummy2");
    final Objective o = board.getObjective("lobby");
    o.setDisplayName(ChatColor.AQUA + "SkyHub");
    o.setDisplaySlot(DisplaySlot.SIDEBAR);
    o.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Coins")).setScore(15);
    o.getScore(Bukkit.getOfflinePlayer("§e " + MySQL.getCash(p.getName()))).setScore(14);
    o.getScore(Bukkit.getOfflinePlayer("§f ")).setScore(13);
    o.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Tokens")).setScore(12);
    o.getScore(Bukkit.getOfflinePlayer("§e " + MySQL.getTokens(p.getName()))).setScore(11);
    o.getScore(Bukkit.getOfflinePlayer("§f ")).setScore(10);
    o.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Rank")).setScore(9);
    if (Permissions.isUser(p)) {
    o.getScore(Bukkit.getOfflinePlayer("§7[USER]")).setScore(8);
    } else if (Permissions.isVIP(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§a[VIP]")).setScore(8);
    } else if (Permissions.isVIPPlus(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§a[VIP§e+§a]")).setScore(8);
    } else if (Permissions.isHelper(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§d[HELPER]")).setScore(8);
    } else if (Permissions.isBuilder(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§3[BUILDER]")).setScore(8);
    } else if (Permissions.isMod(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§5[MOD]")).setScore(8);
    }
    else if (Permissions.isAdmin(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§c[ADMIN]")).setScore(8);
    }
    else if (Permissions.isDev(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§c[DEV]")).setScore(8);
    }else if (Permissions.isOwner(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§4[OWNER]")).setScore(8);
    }else if (Permissions.isYouTuber(p)) {
    	o.getScore(Bukkit.getOfflinePlayer("§f[YOU§cTUBER]")).setScore(8);
    }
    o.getScore(Bukkit.getOfflinePlayer("§f ")).setScore(7);
    o.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Server IP")).setScore(6);
    o.getScore(Bukkit.getOfflinePlayer("§emc.mchub.co")).setScore(5);
    
    p.setScoreboard(board);
}

}

