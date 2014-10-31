package events;

import menus.GadgetShop;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class GadgetShopVillager implements Listener {
	
	@EventHandler
	public void gadgetshop(PlayerInteractEntityEvent e) {
		Entity entity = e.getRightClicked();
		if (entity instanceof Villager) {
			if (((Villager) entity).getAgeLock() == true && (((Villager) entity).getProfession() == Profession.LIBRARIAN)) {
				final Player p = e.getPlayer();
				p.openInventory(GadgetShop.gadgetshop);
				p.sendMessage("§8[§3Gary§8] §eHow can I help you?");
				p.playSound(p.getLocation(), Sound.CHEST_OPEN, 2000, 2000);

			}
		}
	}

}
