package events;

import java.util.ArrayList;
import java.util.Random;

import me.NitroxMC.Lobby.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import sql.MySQL;

public class SlotTokens implements Listener {
	
	public ArrayList<String> slotmachine = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void slotMachine(PlayerInteractEvent e) {
	    Random r = new Random();
    	int random;
    	random = 1+r.nextInt(30);
    	
	    Random r2 = new Random();
    	int random2;
    	random2 = 1+r2.nextInt(33);
    	
	    Random r3 = new Random();
    	int random3;
    	random3 = 1+r3.nextInt(36);
    	
    	int slotmachineend;
    	slotmachineend = random3 + 60;
    	
		final Location blockloc = e.getClickedBlock().getLocation().add(0, -1, 0);
		final Location blockloc2 = e.getClickedBlock().getLocation().add(-1, -1, 0);
		final Location blockloc3 = e.getClickedBlock().getLocation().add(1, -1, 0);
		final Location blockloc4 = e.getClickedBlock().getLocation().add(0, 0, -1);
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.STONE_BUTTON) {
				if(blockloc4.getBlock().getType() == Material.GOLD_BLOCK) {
					if(slotmachine.contains("lol")) {
						e.getPlayer().sendMessage("§8[§3Lobby§8] §eSomeone's Already Using the Machine!");
						return;
					} else {
			    Integer amount = Integer.valueOf(10);
			    Integer cash = MySQL.getCash(e.getPlayer().getName());
			    Integer cost = Integer.valueOf(amount.intValue());
			    if (cash.intValue() < cost.intValue())
			    {
			      e.getPlayer().sendMessage("§8[§3Lobby§8] §eNot enough tokens, get some by playing minigames with the star symbol next to their name!");
			      return;
			    }
			    MySQL.query("UPDATE `lobby_PLAYERS` SET `TOKENS` = `TOKENS` - " + cost + " WHERE `NAME` = '" + e.getPlayer().getName() + "';");
			    Lobby.scoreboard(e.getPlayer());
				slotmachine.add("lol");
				final int task1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc.getBlock().setType(Material.WOOL);
						blockloc.getBlock().setData((byte) 1);
					}
				}, 0, 5);
				
				final int task2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc.getBlock().setType(Material.WOOL);
						blockloc.getBlock().setData((byte) 4);
					}
				}, 1, 5);
				
				final int task3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc.getBlock().setType(Material.WOOL);
						blockloc.getBlock().setData((byte) 5);
					}
				}, 2, 5);
				
				final int task4 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc.getBlock().setType(Material.WOOL);
						blockloc.getBlock().setData((byte) 8);
					}
				}, 3, 5);
				
				final int task5 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc.getBlock().setType(Material.WOOL);
						blockloc.getBlock().setData((byte) 14);
					}
				}, 4, 5);
				
				//---------------------------------------------------------------------------------------\\
				
				final int task6 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc2.getBlock().setType(Material.WOOL);
						blockloc2.getBlock().setData((byte) 14);
					}
				}, 0, 5);
				
				final int task7 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc2.getBlock().setType(Material.WOOL);
						blockloc2.getBlock().setData((byte) 8);
					}
				}, 1, 5);
				
				final int task8 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc2.getBlock().setType(Material.WOOL);
						blockloc2.getBlock().setData((byte) 4);
					}
				}, 2, 5);
				
				final int task9 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc2.getBlock().setType(Material.WOOL);
						blockloc2.getBlock().setData((byte) 5);
					}
				}, 3, 5);
				
				final int task10 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc2.getBlock().setType(Material.WOOL);
						blockloc2.getBlock().setData((byte) 1);
					}
				}, 4, 5);
				
				//-----------------------------------------------------------------------\\
				
				final int task11 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc3.getBlock().setType(Material.WOOL);
						blockloc3.getBlock().setData((byte) 5);
					}
				}, 0, 5);
				
				final int task12 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc3.getBlock().setType(Material.WOOL);
						blockloc3.getBlock().setData((byte) 14);
					}
				}, 1, 5);
				
				final int task13 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc3.getBlock().setType(Material.WOOL);
						blockloc3.getBlock().setData((byte) 8);
					}
				}, 2, 5);
				
				final int task14 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc3.getBlock().setType(Material.WOOL);
						blockloc3.getBlock().setData((byte) 5);
					}
				}, 3, 5);
				
				final int task15 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.plugin, new Runnable() {
					public void run() {
						blockloc3.getBlock().setType(Material.WOOL);
						blockloc3.getBlock().setData((byte) 4);
					}
				}, 4, 5);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Lobby.plugin, new Runnable() {
					public void run() {
						Bukkit.getScheduler().cancelTask(task1);
						Bukkit.getScheduler().cancelTask(task2);
						Bukkit.getScheduler().cancelTask(task3);
						Bukkit.getScheduler().cancelTask(task4);
						Bukkit.getScheduler().cancelTask(task5);


					}
				}, random);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Lobby.plugin, new Runnable() {
					public void run() {
						Bukkit.getScheduler().cancelTask(task6);
						Bukkit.getScheduler().cancelTask(task7);
						Bukkit.getScheduler().cancelTask(task8);
						Bukkit.getScheduler().cancelTask(task9);
						Bukkit.getScheduler().cancelTask(task10);

					}
				}, random2);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Lobby.plugin, new Runnable() {
					public void run() {
						Bukkit.getScheduler().cancelTask(task11);
						Bukkit.getScheduler().cancelTask(task12);
						Bukkit.getScheduler().cancelTask(task13);
						Bukkit.getScheduler().cancelTask(task14);
						Bukkit.getScheduler().cancelTask(task15);

					}
				}, random3);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Lobby.plugin, new Runnable() {
					public void run() {
						slotmachine.remove("lol");
					}
				}, slotmachineend);
				
				if(blockloc.getBlock().getData() == (byte) 4 && blockloc2.getBlock().getData() == (byte) 4 && blockloc3.getBlock().getData() == (byte) 4) {
				
				}
				
			}
			}
			}
		}
	}

}
