package menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GadgetShop {
	
	public static Inventory gadgetshop;
	
	public void onEnable() {
		gadgetshop = Bukkit.getServer().createInventory(null, 27, "§lGadget Shop");
		
        
		ItemStack fwgun = new ItemStack(Material.IRON_HOE, 1, (short) 0);
		final ItemMeta fwgunm1 = fwgun.getItemMeta();
		ArrayList<String> pm = new ArrayList<String>();
		fwgunm1.setDisplayName("§aFirework Gun Ammo §7(10 Shots)");
		pm.add("§8Cost: §6100 Tokens");
		pm.add(" ");
		pm.add("§7Right Click to Shoot");
		pm.add("§7Enderpearls which Explode");
		pm.add("§7Into Fireworks!");
		pm.add(" ");
		pm.add("§8Requires: §aVIP");
		fwgunm1.setLore(pm);
		fwgun.setItemMeta(fwgunm1);
	}

}
