package utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Permissions {
	  public static boolean hasPerm(Player p, String s)
	  {
	    if (p.isOp()) {
	      return true;
	    }
	    return p.hasPermission(s);
	  }
	  
	  public static boolean isUser(Player p)
	  {
	    return hasPerm(p, "lobby.user");
	  }
	  public static boolean isVIP(Player p)
	  {
	    return hasPerm(p, "lobby.vip");
	  }
	  public static boolean isVIPPlus(Player p)
	  {
	    return hasPerm(p, "lobby.vip+");
	  }
	  public static boolean isYouTuber(Player p)
	  {
	    return hasPerm(p, "lobby.youtuber");
	  }
	  public static boolean isBuilder(Player p)
	  {
	    return hasPerm(p, "lobby.builder");
	  }
	  public static boolean isHelper(Player p)
	  {
	    return hasPerm(p, "lobby.helper");
	  }
	  public static boolean isMod(Player p)
	  {
	    return hasPerm(p, "lobby.mod");
	  }
	  public static boolean isAdmin(Player p)
	  {
	    return hasPerm(p, "lobby.admin");
	  }
	  public static boolean isDev(Player p)
	  {
	    return hasPerm(p, "lobby.dev");
	  }
	  public static boolean isOwner(Player p)
	  {
	    return hasPerm(p, "lobby.owner");
	  }
	  
	  
	  public static Player[] getOnlineAdmins()
	  {
	    ArrayList<Player> admins = new ArrayList<Player>();
	    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
	      if (isAdmin(p)) {
	        admins.add(p);
	      }
	    }
	    return (Player[])admins.toArray(new Player[0]);
	  }
	}

