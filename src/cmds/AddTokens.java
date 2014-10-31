package cmds;

import me.NitroxMC.Lobby.Lobby;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sql.MySQL;
import utils.Permissions;

public class AddTokens implements CommandExecutor {
	
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage(ChatColor.RED + "You can't use this command!");
	      return true;
	    }
	    if(cmd.getName().equalsIgnoreCase("addtokens")) {
	    	Player p = (Player) sender;
	    	if (Permissions.isAdmin(p)) {
	    	      {
	    	          if (args.length != 3)
	    	          {
	    	            p.sendMessage("§8[§3Lobby§8] §eUsage: §c/addtokens <player> <amount>");
	    	            return true;
	    	          }
	    	          if (!MySQL.playerPlayedBefore(args[1]).booleanValue())
	    	          {
	    	            p.sendMessage("§8[§3Error§8] §eUnknown player!");
	    	            return true;
	    	          }
	    	          args[1] = args[1].replace("'", "");
	    	          args[2] = args[2].replace("'", "");
	    	          args[1] = args[1].replace("`", "");
	    	          args[2] = args[2].replace("`", "");
	    	          MySQL.query("UPDATE `lobby_PLAYERS` SET `TOKENS` = `TOKENS` + " + args[2] + " WHERE `NAME` = '" + args[1] + "';");
	    	          p.sendMessage("§8[§3Lobby§8] §eAdded §c" + args[2] + " tokens §eto player §c" + args[1]);
	    	          return true;
	    	        }
	    	} else {
	    		p.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    		return true;
	    	}
	    }
		return false;


}
	  }


