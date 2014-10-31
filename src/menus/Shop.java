package menus;

import java.util.ArrayList;

import me.NitroxMC.Lobby.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import sql.MySQL;
import utils.Filtre;
import utils.Maths;
import utils.ParticleFX;

public class Shop {
	
    
	private Inventory shapeme;
	private Inventory cirme;
	private Inventory torme;
	private Inventory radme;
	private Inventory spime;
	private Inventory trail;
	private Inventory gadget;
	private Inventory cosm;
    private Inventory inv;
    private Inventory invlh;
    private Inventory invlc;
    private Inventory invll;
    private Inventory invlb;
    private Inventory mp3;
    private Inventory gadget2;
    private Inventory staffgadget;
    
    public static ArrayList<String> cooldown = new ArrayList<String>();
    
	
    public void onEnable() {
	cirme = Bukkit.getServer().createInventory(null, 45, "§lCircular Trails");
	shapeme = Bukkit.getServer().createInventory(null, 45, "§lShaped Trails");
	torme = Bukkit.getServer().createInventory(null, 45, "§lTornado Trails");
	radme = Bukkit.getServer().createInventory(null, 45, "§lRadar Trails");
	spime = Bukkit.getServer().createInventory(null, 45, "§lSpiral Trails");
		trail = Bukkit.getServer().createInventory(null, 45, "§lTrails");
		gadget = Bukkit.getServer().createInventory(null, 54, "§lGadgets");
		gadget2 = Bukkit.getServer().createInventory(null, 54, "§lGadgets §r(Page 2)");
		staffgadget = Bukkit.getServer().createInventory(null, 54, "§lGadgets §r(Staff)");
		cosm = Bukkit.getServer().createInventory(null, 45, "§lCosmetics");
		inv = Bukkit.getServer().createInventory(null, 54, "Wardrobe Builder");
        invlh = Bukkit.getServer().createInventory(null, 36, "Select Helmet Color");
        invlc = Bukkit.getServer().createInventory(null, 36, "Select Chestplate Color");
        invll = Bukkit.getServer().createInventory(null, 36, "Select Leggings Color");
        invlb = Bukkit.getServer().createInventory(null, 36, "Select Boots Color");
        mp3 = Bukkit.getServer().createInventory(null, 27, "MP3 Player");
        
        
        ItemStack lh = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemStack ih = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack gh = new ItemStack(Material.GOLD_HELMET, 1);
        ItemStack dh = new ItemStack(Material.DIAMOND_HELMET, 1);
        
        ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack gc = new ItemStack(Material.GOLD_CHESTPLATE, 1);
        ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        
        ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemStack il = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemStack gl = new ItemStack(Material.GOLD_LEGGINGS, 1);
        ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        
        ItemStack lb = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemStack ib = new ItemStack(Material.IRON_BOOTS, 1);
        ItemStack gb = new ItemStack(Material.GOLD_BOOTS, 1);
        ItemStack db = new ItemStack(Material.DIAMOND_BOOTS, 1);
        
        ItemStack r1 = new ItemStack(Material.RECORD_3);
        ItemStack r2 = new ItemStack(Material.RECORD_4);
        ItemStack r3 = new ItemStack(Material.RECORD_5);
        ItemStack r4 = new ItemStack(Material.RECORD_6);
        ItemStack r5 = new ItemStack(Material.RECORD_7);
        ItemStack r6 = new ItemStack(Material.RECORD_8);
        ItemStack r7 = new ItemStack(Material.RECORD_9);
        ItemStack r8 = new ItemStack(Material.RECORD_10);
        ItemStack r9 = new ItemStack(Material.RECORD_11);
        ItemStack r10 = new ItemStack(Material.RECORD_12);
        ItemStack pumpkin = new ItemStack(Material.PUMPKIN);
        
        
        ItemStack cosmenu = new ItemStack(Material.CHEST, 1, (short)0);
        ItemMeta cosmenum = cosmenu.getItemMeta();
        cosmenu.setAmount(1);
        cosmenum.setDisplayName("§a§lCosmetic Menu");
        cosmenu.setItemMeta(cosmenum);
        
        
        ItemStack mainmenu = new ItemStack(Material.COMPASS, 1, (short)0);
        ItemMeta mainmenum = mainmenu.getItemMeta();
        mainmenu.setAmount(1);
        mainmenum.setDisplayName("§a§lMain Menu");
        mainmenu.setItemMeta(mainmenum);
        
        
        ItemStack sgadget = new ItemStack(Material.NETHER_STAR, 1, (short)0);
        ItemMeta sgadgetm = sgadget.getItemMeta();
        sgadget.setAmount(1);
        sgadgetm.setDisplayName("§b§lSelect a Gadget");
        sgadget.setItemMeta(sgadgetm);
        
        
        ItemStack strail = new ItemStack(Material.EXP_BOTTLE, 1, (short)0);
        ItemMeta strailm = strail.getItemMeta();
        strail.setAmount(1);
        strailm.setDisplayName("§c§lSelect a Trail");
        strail.setItemMeta(strailm);
        
        
        ItemStack swardrobe = new ItemStack(Material.IRON_INGOT, 1, (short)0);
        ItemMeta swardrobem = swardrobe.getItemMeta();
        swardrobe.setAmount(1);
        swardrobem.setDisplayName("§2§lOpen the Wardrobe");
        swardrobe.setItemMeta(swardrobem);
        
        
        ItemStack smusic = new ItemStack(Material.JUKEBOX, 1, (short)0);
        ItemMeta smusicm = smusic.getItemMeta();
        smusic.setAmount(1);
        smusicm.setDisplayName("§e§lSelect a Song");
        smusic.setItemMeta(smusicm);
        

        
        ItemStack BONEMEAL1 = new ItemStack(Material.INK_SACK, 1, (short)15);
        ItemMeta BONEMEAL1meta = BONEMEAL1.getItemMeta();
        BONEMEAL1.setAmount(1);
        BONEMEAL1meta.setDisplayName("§bSelect color");
        BONEMEAL1.setItemMeta(BONEMEAL1meta);
        
        ItemStack BONEMEAL2 = new ItemStack(Material.INK_SACK, 1, (short)15);
        ItemMeta BONEMEAL2meta = BONEMEAL2.getItemMeta();
        BONEMEAL2.setAmount(2);
        BONEMEAL2meta.setDisplayName("§bSelect color");
        BONEMEAL2.setItemMeta(BONEMEAL2meta);
        
        ItemStack BONEMEAL3 = new ItemStack(Material.INK_SACK, 1, (short)15);
        BONEMEAL3.setAmount(3);
        ItemMeta BONEMEAL3meta = BONEMEAL3.getItemMeta();
        BONEMEAL3meta.setDisplayName("§bSelect color");
        BONEMEAL3.setItemMeta(BONEMEAL3meta);
        
        ItemStack BONEMEAL4 = new ItemStack(Material.INK_SACK, 1, (short)15);
        BONEMEAL4.setAmount(4);
        ItemMeta BONEMEAL4meta = BONEMEAL4.getItemMeta();
        BONEMEAL4meta.setDisplayName("§bSelect color");
        BONEMEAL4.setItemMeta(BONEMEAL4meta);
        
        
        ItemStack fwgun = new ItemStack(Material.IRON_BARDING, 1, (short)15);
        fwgun.setAmount(4);
        ItemMeta fwgunm = fwgun.getItemMeta();
        fwgunm.setDisplayName("§aFirework Gun");
        fwgun.setItemMeta(fwgunm);
        
        
        
        ItemStack white = new ItemStack(Material.INK_SACK, 1, (short)15);
        ItemMeta whitemeta = white.getItemMeta();
        whitemeta.setDisplayName("White");
        white.setItemMeta(whitemeta);
        
        ItemStack orange = new ItemStack(Material.INK_SACK, 1, (short)14);
        ItemMeta orangemeta = orange.getItemMeta();
        orangemeta.setDisplayName("Orange");
        orange.setItemMeta(orangemeta);
        
        ItemStack magenta = new ItemStack(Material.INK_SACK, 1, (short)13);
        ItemMeta magentameta = magenta.getItemMeta();
        magentameta.setDisplayName("Magenta");
        magenta.setItemMeta(magentameta);
        
        ItemStack lightblue = new ItemStack(Material.INK_SACK, 1, (short)12);
        ItemMeta lightbluemeta = lightblue.getItemMeta();
        lightbluemeta.setDisplayName("Light Blue");
        lightblue.setItemMeta(lightbluemeta);
        
        ItemStack yellow = new ItemStack(Material.INK_SACK, 1, (short)11);
        ItemMeta yellowmeta = yellow.getItemMeta();
        yellowmeta.setDisplayName("Yellow");
        yellow.setItemMeta(yellowmeta);
        
        ItemStack lime = new ItemStack(Material.INK_SACK, 1, (short)10);
        ItemMeta limemeta = lime.getItemMeta();
        limemeta.setDisplayName("Lime");
        lime.setItemMeta(limemeta);
        
        ItemStack pink = new ItemStack(Material.INK_SACK, 1, (short)9);
        ItemMeta pinkmeta = pink.getItemMeta();
        pinkmeta.setDisplayName("Pink");
        pink.setItemMeta(pinkmeta);
        
        ItemStack gray = new ItemStack(Material.INK_SACK, 1, (short)8);
        ItemMeta graymeta = gray.getItemMeta();
        graymeta.setDisplayName("Gray");
        gray.setItemMeta(graymeta);
        
        ItemStack silver = new ItemStack(Material.INK_SACK, 1, (short)7);
        ItemMeta silvermeta = silver.getItemMeta();
        silvermeta.setDisplayName("Silver");
        silver.setItemMeta(silvermeta);
        
        ItemStack cyan = new ItemStack(Material.INK_SACK, 1, (short)6);
        ItemMeta cyanmeta = cyan.getItemMeta();
        cyanmeta.setDisplayName("Cyan");
        cyan.setItemMeta(cyanmeta);
        
        ItemStack purple = new ItemStack(Material.INK_SACK, 1, (short)5);
        ItemMeta purplemeta = purple.getItemMeta();
        purplemeta.setDisplayName("Purple");
        purple.setItemMeta(purplemeta);
        
        ItemStack blue = new ItemStack(Material.INK_SACK, 1, (short)4);
        ItemMeta bluemeta = blue.getItemMeta();
        bluemeta.setDisplayName("Blue");
        blue.setItemMeta(bluemeta);
        
        ItemStack brown = new ItemStack(Material.INK_SACK, 1, (short)3);
        ItemMeta brownmeta = brown.getItemMeta();
        brownmeta.setDisplayName("Brown");
        brown.setItemMeta(brownmeta);
        
        ItemStack green = new ItemStack(Material.INK_SACK, 1, (short)2);
        ItemMeta greenmeta = green.getItemMeta();
        greenmeta.setDisplayName("Green");
        green.setItemMeta(greenmeta);
        
        ItemStack red = new ItemStack(Material.INK_SACK, 1, (short)1);
        ItemMeta redmeta = red.getItemMeta();
        redmeta.setDisplayName("Red");
        red.setItemMeta(redmeta);
        
        ItemStack black = new ItemStack(Material.INK_SACK, 1, (short)0);
        ItemMeta blackmeta = black.getItemMeta();
        blackmeta.setDisplayName("Black");
        black.setItemMeta(blackmeta);
        
        
        ItemStack glass5 = new ItemStack(Material.GLASS, 1);
        glass5.setAmount(1);
        ItemMeta glassmeta5 = glass5.getItemMeta();
        glassmeta5.setDisplayName("§cNone");
        glass5.setItemMeta(glassmeta5);
        
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        arrow.setAmount(1);
        ItemMeta arrowmeta = arrow.getItemMeta();
        arrowmeta.setDisplayName("§cGo Back");
        arrow.setItemMeta(arrowmeta);
        
        
        ItemStack glass1 = new ItemStack(Material.GLASS);
        ItemMeta glassmeta1 = glass1.getItemMeta();
        glassmeta1.setDisplayName("§cClear Slot");
        glass1.setAmount(1);
        glass1.setItemMeta(glassmeta1);
        
        ItemStack glass2 = new ItemStack(Material.GLASS);
        ItemMeta glassmeta2 = glass2.getItemMeta();
        glassmeta2.setDisplayName("§cClear Slot");
        glass2.setAmount(2);
        glass2.setItemMeta(glassmeta2);
        
        ItemStack glass3 = new ItemStack(Material.GLASS);
        ItemMeta glassmeta3 = glass3.getItemMeta();
        glassmeta3.setDisplayName("§cClear Slot");
        glass3.setAmount(3);
        glass3.setItemMeta(glassmeta3);
        
        ItemStack glass4 = new ItemStack(Material.GLASS);
        ItemMeta glass4meta = glass4.getItemMeta();
        glass4meta.setDisplayName("§cClear Slot");
        glass4.setAmount(4);
        glass4.setItemMeta(glass4meta);
        
        
        ItemStack nxtpage = new ItemStack(Material.ARROW, 1);
        nxtpage.setAmount(1);
        ItemMeta nxtpagem = arrow.getItemMeta();
        nxtpagem.setDisplayName("§cNext Page");
        nxtpage.setItemMeta(nxtpagem);
        
        
        ItemStack prvpage = new ItemStack(Material.ARROW, 1);
        prvpage.setAmount(1);
        ItemMeta prvpagem = prvpage.getItemMeta();
        prvpagem.setDisplayName("§cPrevious Page");
        prvpage.setItemMeta(prvpagem);
        
        
        ItemStack pg1 = new ItemStack(Material.ARROW, 1);
        pg1.setAmount(1);
        ItemMeta pg1m = arrow.getItemMeta();
        pg1m.setDisplayName("§cPage 1");
        pg1.setItemMeta(pg1m);
        
        
        ItemStack pg2 = new ItemStack(Material.ARROW, 1);
        prvpage.setAmount(1);
        ItemMeta pg2m = pg2.getItemMeta();
        pg2m.setDisplayName("§cPage 2");
        pg2.setItemMeta(pg2m);
        
        ItemStack gmenu = new ItemStack(Material.ARROW, 1);
        prvpage.setAmount(1);
        ItemMeta pg2m1 = pg2.getItemMeta();
        pg2m1.setDisplayName("§cGadgets Menu");
        pg2.setItemMeta(pg2m1);
        
        
        ItemStack staffg = new ItemStack(Material.IRON_FENCE, 1);
        prvpage.setAmount(1);
        ItemMeta staffgm = staffg.getItemMeta();
        staffgm.setDisplayName("§cStaff Only Gadgets");
        staffg.setItemMeta(staffgm);
        
        
        ItemStack stafft = new ItemStack(Material.IRON_FENCE, 1);
        prvpage.setAmount(1);
        ItemMeta stafftm = stafft.getItemMeta();
        stafftm.setDisplayName("§cStaff Only Trails");
        stafft.setItemMeta(stafftm);
        
		ItemStack fwgun1 = new ItemStack(Material.IRON_BARDING, 1, (short) 0);
		final ItemMeta fwgunm1 = fwgun1.getItemMeta();
		ArrayList<String> pm = new ArrayList<String>();
		fwgunm1.setDisplayName("§a§lFirework Gun");
		pm.add("§8Cooldown: §65 Seconds");
		pm.add(" ");
		pm.add("§7Right Click to Shoot");
		pm.add("§7Enderpearls which Explode");
		pm.add("§7Into Fireworks!");
		pm.add(" ");
		pm.add("§8Requires: §aVIP");
		fwgunm1.setLore(pm);
		fwgun1.setItemMeta(fwgunm1);
		
        
		ItemStack explp = new ItemStack(Material.MONSTER_EGG, 3, (short) 90);
		final ItemMeta explpm = explp.getItemMeta();
		ArrayList<String> pm1 = new ArrayList<String>();
		explpm.setDisplayName("§a§lExploding Pigs");
		pm1.add("§8Cooldown: §65 Seconds");
		pm1.add(" ");
		pm1.add("§7Right Click to Spawn");
		pm1.add("§7Some Pigs Which Explode");
		pm1.add("§7When you Hit Them!");
		pm1.add(" ");
		pm1.add("§8Requires: §aVIP");
		explpm.setLore(pm1);
		explp.setItemMeta(explpm);
		
					ItemStack plc = new ItemStack(Material.SIGN, 1, (short) 0);
					final ItemMeta plcm = plc.getItemMeta();
					ArrayList<String> pm11 = new ArrayList<String>();
					plcm.setDisplayName("§a§lPlacards");
					pm11.add("§8Cooldown: §61 Second");
					pm11.add(" ");
					pm11.add("§7See Famous Quotes!");
					pm11.add(" ");
					pm11.add("§8Requires: §aVIP");
					plcm.setLore(pm11);
					plc.setItemMeta(plcm);
					
					ItemStack tpbow = new ItemStack(Material.BOW, 1, (short) 0);
					final ItemMeta tpbowm = tpbow.getItemMeta();
					ArrayList<String> pm111 = new ArrayList<String>();
					tpbowm.setDisplayName("§a§lTeleporting Bow");
					pm111.add("§8Cooldown: §610 Seconds");
					pm111.add(" ");
					pm111.add("§7Shoot an Arrow to Teleport");
					pm111.add(" ");
					pm111.add("§8Requires: §aVIP");
					tpbowm.setLore(pm111);
					tpbow.setItemMeta(tpbowm);
					
					ItemStack bb = new ItemStack(Material.COAL);
					final ItemMeta bbm = bb.getItemMeta();
					ArrayList<String> pm2 = new ArrayList<String>();
					bbm.setDisplayName("§a§lBat Blaster");
					pm111.add("§8Cooldown: §615 Seconds");
					pm111.add(" ");
					pm2.add("§7Right Click to Shoot out Bats!");
					pm2.add(" ");
					pm2.add("§8Requires: §aVIP");
					bbm.setLore(pm2);
					bb.setItemMeta(bbm);
					
					ItemStack rod = new ItemStack(Material.NETHER_BRICK_ITEM);
					final ItemMeta rodm = rod.getItemMeta();
					ArrayList<String> pm3 = new ArrayList<String>();
					rodm.setDisplayName("§a§lRing of Death");
					pm3.add("§8Cooldown: §630 Seconds");
					pm3.add(" ");
					pm3.add("§7Right Click to Cause a Ring of Death");
					pm3.add(" ");
					pm3.add("§8Requires: §aVIP");
					rodm.setLore(pm3);
					rod.setItemMeta(rodm);
					
					ItemStack ph = new ItemStack(Material.NOTE_BLOCK, 1, (short) 0);
					final ItemMeta phm = ph.getItemMeta();
					ArrayList<String> pm4 = new ArrayList<String>();
					phm.setDisplayName("§a§lPerfect Harmony");
					pm4.add("§8Cooldown: §65 Seconds");
					pm4.add(" ");
					pm4.add("§7Notes in Perfect Harmony!");
					pm4.add(" ");
					pm4.add("§8Requires: §aVIP");
					phm.setLore(pm4);
					ph.setItemMeta(phm);
					
					ItemStack ml = new ItemStack(Material.BLAZE_ROD);
					final ItemMeta mlm = ml.getItemMeta();
					ArrayList<String> pm5 = new ArrayList<String>();
					mlm.setDisplayName("§a§lMob Launcher");
					pm111.add("§8Cooldown: §630 Seconds");
					pm111.add(" ");
					pm5.add("§7Launches Mobs");
					pm5.add(" ");
					pm5.add("§8Requires: §aVIP§6+");
					mlm.setLore(pm5);
					ml.setItemMeta(mlm);
					
					ItemStack is = new ItemStack(Material.PACKED_ICE);
					final ItemMeta ism = is.getItemMeta();
					ArrayList<String> pm6 = new ArrayList<String>();
					ism.setDisplayName("§a§lIce Smash");
					pm6.add("§8Cooldown: §660 Seconds");
					pm6.add(" ");
					pm6.add("§7Sends you Flying into");
					pm6.add("§7the air, then you come");
					pm6.add("§7Crashing Down in a Super Smash!");
					pm6.add(" ");
					pm6.add("§8Requires: §aVIP§6+");
					ism.setLore(pm6);
					is.setItemMeta(ism);
					
					ItemStack dt = new ItemStack(Material.REDSTONE_LAMP_OFF);
					final ItemMeta dtm = dt.getItemMeta();
					ArrayList<String> pm7 = new ArrayList<String>();
					dtm.setDisplayName("§a§lDancin' Time");
					pm7.add("§8Cooldown: §630 Seconds");
					pm7.add(" ");
					pm7.add("§7Let's have a Rave!");
					pm7.add(" ");
					pm7.add("§8Requires: §aVIP§6+");
					dtm.setLore(pm7);
					dt.setItemMeta(dtm);
					
					
					ItemStack mt = new ItemStack(Material.WATCH);
					final ItemMeta mtm = dt.getItemMeta();
					ArrayList<String> p2m7 = new ArrayList<String>();
					mtm.setDisplayName("§a§lMagic Trick");
					p2m7.add("§8Cooldown: §630 Seconds");
					p2m7.add(" ");
					p2m7.add("§7Hey, Do You Wanna See");
					p2m7.add("§7A Magic Trick?");
					p2m7.add(" ");
					p2m7.add("§8Requires: §aVIP§6+");
					mtm.setLore(pm7);
					mt.setItemMeta(mtm);
					
					ItemStack rof = new ItemStack(Material.MAGMA_CREAM, 1, (short) 0);
					final ItemMeta rofm = rof.getItemMeta();
					ArrayList<String> pm8 = new ArrayList<String>();
					rofm.setDisplayName("§a§lRing of Fire");
					pm8.add("§8Cooldown: §630 Seconds");
					pm8.add(" ");
					pm8.add("§7Right Click to Cause a Ring of Fire");
					pm8.add(" ");
					pm8.add("§8Requires: §aVIP§6+");
					rofm.setLore(pm8);
					rof.setItemMeta(rofm);
					
					ItemStack lf = new ItemStack(Material.BLAZE_POWDER, 1, (short) 0);
					final ItemMeta lfm = rof.getItemMeta();
					ArrayList<String> p2m8 = new ArrayList<String>();
					lfm.setDisplayName("§a§lLava Fountain");
					p2m8.add("§8Cooldown: §660 Seconds");
					p2m8.add(" ");
					p2m8.add("§7Right Click to Cause a Ring of Fire");
					p2m8.add(" ");
					p2m8.add("§8Requires: §5Moderator");
					lfm.setLore(p2m8);
					lf.setItemMeta(lfm);
					
					
					ItemStack gh1 = new ItemStack(Material.FISHING_ROD, 1, (short) 0);
					final ItemMeta ghm = rof.getItemMeta();
					ArrayList<String> p3m8 = new ArrayList<String>();
					ghm.setDisplayName("§a§lGrappling Hook");
					p3m8.add("§8Cooldown: §660 Seconds");
					p3m8.add(" ");
					p3m8.add("§7Be a Secret Agent!");
					p3m8.add(" ");
					p3m8.add("§8Requires: §aVIP§6+");
					ghm.setLore(p3m8);
					gh1.setItemMeta(ghm);
					
					
					ItemStack roc = new ItemStack(Material.FIREWORK, 1, (short) 0);
					final ItemMeta rocm = roc.getItemMeta();
					ArrayList<String> p3m9 = new ArrayList<String>();
					rocm.setDisplayName("§a§lRocket");
					p3m9.add("§8Cooldown: §6120 Seconds");
					p3m9.add(" ");
					p3m9.add("§7Go to the Moon!");
					p3m9.add(" ");
					p3m9.add("§8Requires: §dHelper");
					rocm.setLore(p3m9);
					roc.setItemMeta(rocm);
					
					ItemStack jp = new ItemStack(Material.SLIME_BALL, 1, (short) 0);
					final ItemMeta jpm = jp.getItemMeta();
					ArrayList<String> p2m9 = new ArrayList<String>();
					jpm.setDisplayName("§a§lJump Pad");
					p2m9.add("§8Cooldown: §6120 Seconds");
					p2m9.add(" ");
					p2m9.add("§7Invite Your Friends!");
					p2m9.add(" ");
					p2m9.add("§8Requires: §aVIP§6+");
					jpm.setLore(p2m9);
					jp.setItemMeta(jpm);
					
					ItemStack com = new ItemStack(Material.FIREBALL, 1, (short) 0);
					final ItemMeta comm = com.getItemMeta();
					ArrayList<String> p2m91 = new ArrayList<String>();
					comm.setDisplayName("§a§lComet");
					p2m91.add("§8Cooldown: §660 Seconds");
					p2m91.add(" ");
					p2m91.add("§7Rain Hellfire!");
					p2m91.add(" ");
					p2m91.add("§8Requires: §aVIP");
					comm.setLore(p2m91);
					com.setItemMeta(comm);
					
					ItemStack bt = new ItemStack(Material.SAPLING, 1, (short) 0);
					final ItemMeta btm = bt.getItemMeta();
					ArrayList<String> p2m911 = new ArrayList<String>();
					btm.setDisplayName("§a§lBubby Twee");
					p2m911.add("§8Cooldown: §630 Seconds");
					p2m911.add(" ");
					p2m911.add("§7The Art of Transforming");
					p2m911.add("§7Yourself into a Tree");
					p2m911.add(" ");
					p2m911.add("§8Requires: §aVIP");
					btm.setLore(p2m911);
					bt.setItemMeta(btm);
					
					ItemStack pe = new ItemStack(Material.DIAMOND_BARDING, 1, (short) 0);
					final ItemMeta pem = pe.getItemMeta();
					ArrayList<String> p2m9111 = new ArrayList<String>();
					pem.setDisplayName("§a§lPaint Eggs");
					p2m9111.add("§8Cooldown: §610 Seconds");
					p2m9111.add(" ");
					p2m9111.add("§7Like a Paintball Gun");
					p2m9111.add("§7But this one shoots");
					p2m9111.add("§7Eggs :D");
					p2m9111.add(" ");
					p2m9111.add("§8Requires: §aVIP");
					pem.setLore(p2m9111);
					pe.setItemMeta(pem);
					
					ItemStack la = new ItemStack(Material.LEASH, 1, (short) 0);
					final ItemMeta lam = la.getItemMeta();
					ArrayList<String> p2m91111 = new ArrayList<String>();
					lam.setDisplayName("§a§lLasso");
					p2m91111.add("§8Cooldown: §60 Seconds");
					p2m91111.add(" ");
					p2m91111.add("§7Have Fun Riding Other");
					p2m91111.add("§7Players / Mobs");
					p2m91111.add(" ");
					p2m91111.add("§8Requires: §aVIP§6+");
					lam.setLore(p2m91111);
					la.setItemMeta(lam);
					ItemStack mp = new ItemStack(Material.WOOL, 1, (short) 2);
					final ItemMeta mpm = mp.getItemMeta();
					ArrayList<String> p2m9111111 = new ArrayList<String>();
					mpm.setDisplayName("§a§lMagenta Party");
					p2m9111111.add("§8Cooldown: §60 Seconds");
					p2m9111111.add(" ");
					p2m9111111.add("§7It's so Adorable <3");
					p2m9111111.add("§7Requested by Jade :)");
					p2m9111111.add(" ");
					p2m9111111.add("§8Requires: §aVIP§6+");
					mpm.setLore(p2m9111111);
					mp.setItemMeta(mpm);
					ItemStack ra = new ItemStack(Material.GHAST_TEAR, 1, (short) 0);
					final ItemMeta ram = ra.getItemMeta();
					ArrayList<String> p2m91111111 = new ArrayList<String>();
					ram.setDisplayName("§a§lRave");
					p2m91111111.add("§8Cooldown: §60 Seconds");
					p2m91111111.add(" ");
					p2m91111111.add("§7It's Almost Better");
					p2m91111111.add("§7Than a Dancing Party");
					p2m91111111.add(" ");
					p2m91111111.add("§8Requires: §aVIP§6+");
					ram.setLore(p2m91111111);
					ra.setItemMeta(ram);
					
					ItemStack gr = new ItemStack(Material.REDSTONE_TORCH_ON, 1, (short) 0);
					final ItemMeta grm = gr.getItemMeta();
					ArrayList<String> p2m911111 = new ArrayList<String>();
					grm.setDisplayName("§a§lGlobal Rave");
					p2m911111.add("§8Cooldown: §6120 Seconds");
					p2m911111.add(" ");
					p2m911111.add("§7Awwwww Yeah a Rave!");
					p2m911111.add(" ");
					p2m911111.add("§8Requires: §cAdmin");
					grm.setLore(p2m911111);
					gr.setItemMeta(grm);
					
					ItemStack rstg = new ItemStack(Material.NETHER_STAR, 1, (short) 0);
					final ItemMeta rstgm = rstg.getItemMeta();
					rstgm.setDisplayName("§cReset Gadget");
					rstg.setItemMeta(rstgm);
					
					ItemStack circ = new ItemStack(Material.RED_ROSE, 1, (short) 7);
					final ItemMeta cirm = circ.getItemMeta();
					cirm.setDisplayName("§a§lCircular Trails");
					circ.setItemMeta(cirm);
					
					ItemStack shapec = new ItemStack(Material.RED_ROSE, 1, (short) 1);
					final ItemMeta shapem = shapec.getItemMeta();
					shapem.setDisplayName("§a§lShaped Trails");
					shapec.setItemMeta(shapem);
					
					ItemStack rad = new ItemStack(Material.RED_ROSE, 1, (short) 4);
					final ItemMeta radm = rad.getItemMeta();
					radm.setDisplayName("§a§lRadar Trails");
					rad.setItemMeta(radm);
					
					ItemStack spi = new ItemStack(Material.RED_ROSE, 1, (short) 5);
					final ItemMeta spim = spi.getItemMeta();
					spim.setDisplayName("§a§lSpiral Trails");
					spi.setItemMeta(spim);
					
					ItemStack tor = new ItemStack(Material.RED_ROSE, 1, (short) 6);
					final ItemMeta torm = tor.getItemMeta();
					torm.setDisplayName("§a§lTornado Trails");
					tor.setItemMeta(torm);
					
					
					ItemStack atom = new ItemStack(Material.ENDER_CHEST);
					final ItemMeta atomm = atom.getItemMeta();
					ArrayList<String> pm71 = new ArrayList<String>();
					atomm.setDisplayName("§a§lAtom Trail");
					pm71.add("§8Cooldown: §630 Seconds");
					pm71.add(" ");
					pm71.add("§8Requires: §aVIP§6+");
					atomm.setLore(pm71);
					atom.setItemMeta(atomm);
					
					ItemStack name = new ItemStack(Material.NAME_TAG);
					final ItemMeta namem = name.getItemMeta();
					ArrayList<String> pm711 = new ArrayList<String>();
					namem.setDisplayName("§a§lName Trail");
					pm711.add("§8Cooldown: §630 Seconds");
					pm711.add(" ");
					pm711.add("§8Requires: §aVIP§6+");
					namem.setLore(pm711);
					name.setItemMeta(namem);
					
					ItemStack wave = new ItemStack(Material.WATER_BUCKET);
					final ItemMeta wavem = wave.getItemMeta();
					ArrayList<String> pm7111 = new ArrayList<String>();
					wavem.setDisplayName("§a§lWave Trail");
					pm7111.add("§8Cooldown: §630 Seconds");
					pm7111.add(" ");
					pm7111.add("§8Requires: §aVIP§6+");
					wavem.setLore(pm7111);
					wave.setItemMeta(wavem);
					
					ItemStack dna = new ItemStack(Material.ENCHANTED_BOOK);
					final ItemMeta dnam = dna.getItemMeta();
					ArrayList<String> pm71111 = new ArrayList<String>();
					dnam.setDisplayName("§a§lDNA Trail");
					pm71111.add("§8Cooldown: §630 Seconds");
					pm71111.add(" ");
					pm71111.add("§8Requires: §aVIP§6+");
					dnam.setLore(pm71111);
					dna.setItemMeta(dnam);
					
					ItemStack spiral = new ItemStack(Material.BEACON);
					final ItemMeta spiralm = spiral.getItemMeta();
					ArrayList<String> pm711111 = new ArrayList<String>();
					spiralm.setDisplayName("§a§lSpiral Trail");
					pm711111.add("§8Cooldown: §630 Seconds");
					pm711111.add(" ");
					pm711111.add("§8Requires: §aVIP§6+");
					spiralm.setLore(pm711111);
					spiral.setItemMeta(spiralm);
					
					ItemStack dragon = new ItemStack(Material.DRAGON_EGG);
					final ItemMeta dragonm = dragon.getItemMeta();
					ArrayList<String> pm7111111 = new ArrayList<String>();
					dragonm.setDisplayName("§a§lDragon Breath");
					pm7111111.add("§8Cooldown: §630 Seconds");
					pm7111111.add(" ");
					pm7111111.add("§8Requires: §aVIP§6+");
					dragonm.setLore(pm7111111);
					dragon.setItemMeta(dragonm);
					
					ItemStack arc = new ItemStack(Material.RAW_FISH, 1, (short)2);
					final ItemMeta arcm = arc.getItemMeta();
					ArrayList<String> pm71111111 = new ArrayList<String>();
					arcm.setDisplayName("§a§lArc Trail");
					pm71111111.add("§8Cooldown: §630 Seconds");
					pm71111111.add(" ");
					pm71111111.add("§8Requires: §aVIP§6+");
					arcm.setLore(pm71111111);
					arc.setItemMeta(arcm);
					
					
					ItemStack noten = new ItemStack(Material.NOTE_BLOCK, 1, (short)0);
					final ItemMeta notenm = noten.getItemMeta();
					ArrayList<String> pm711111111 = new ArrayList<String>();
					notenm.setDisplayName("§c§lNote Effect");
					pm711111111.add("§8Requires: §aVIP§6+");
					notenm.setLore(pm711111111);
					noten.setItemMeta(notenm);
					
					ItemStack heart = new ItemStack(Material.GOLDEN_APPLE, 1, (short)0);
					final ItemMeta heartm = heart.getItemMeta();
					ArrayList<String> pm7111111111 = new ArrayList<String>();
					heartm.setDisplayName("§c§lHeart Effect");
					pm7111111111.add("§8Requires: §aVIP§6+");
					heartm.setLore(pm7111111111);
					heart.setItemMeta(heartm);
					
					ItemStack water = new ItemStack(Material.WATER, 1, (short)0);
					final ItemMeta waterm = water.getItemMeta();
					ArrayList<String> pm71111111111 = new ArrayList<String>();
					waterm.setDisplayName("§c§lWater Effect");
					pm71111111111.add("§8Requires: §aVIP§6+");
					waterm.setLore(pm71111111111);
					water.setItemMeta(waterm);
					
					ItemStack spark = new ItemStack(Material.FIREWORK, 1, (short)0);
					final ItemMeta sparkm = spark.getItemMeta();
					ArrayList<String> pm711111111111 = new ArrayList<String>();
					sparkm.setDisplayName("§c§lSpark Effect");
					pm711111111111.add("§8Requires: §aVIP§6+");
					sparkm.setLore(pm711111111111);
					spark.setItemMeta(sparkm);
					
					ItemStack witch = new ItemStack(Material.BOOK, 1, (short)0);
					final ItemMeta witchm = witch.getItemMeta();
					ArrayList<String> pm7111111111111 = new ArrayList<String>();
					witchm.setDisplayName("§c§lWitch Effect");
					pm7111111111111.add("§8Requires: §aVIP§6+");
					witchm.setLore(pm7111111111111);
					witch.setItemMeta(witchm);
					
					ItemStack smoke = new ItemStack(Material.INK_SACK, 1, (short)0);
					final ItemMeta smokem = smoke.getItemMeta();
					ArrayList<String> pm71111111111111 = new ArrayList<String>();
					smokem.setDisplayName("§c§lSmoke Effect");
					pm71111111111111.add("§8Requires: §aVIP§6+");
					smokem.setLore(pm71111111111111);
					smoke.setItemMeta(smokem);
					
					ItemStack flame = new ItemStack(Material.BLAZE_POWDER, 1, (short)0);
					final ItemMeta flamem = flame.getItemMeta();
					ArrayList<String> pm711111111111111 = new ArrayList<String>();
					flamem.setDisplayName("§a§lFlame Effect");
					pm711111111111111.add("§8Requires: §aVIP§6+");
					flamem.setLore(pm711111111111111);
					flame.setItemMeta(smokem);
					
					ItemStack clearall = new ItemStack(Material.GLASS, 5, (short)0);
					final ItemMeta clearallm = clearall.getItemMeta();
					clearallm.setDisplayName("§cClear All");
					clearall.setItemMeta(clearallm);
					
					
					ItemStack dtr = new ItemStack(Material.GLASS, 1, (short)0);
					final ItemMeta dtrm = dtr.getItemMeta();
					dtrm.setDisplayName("§cDisable Trail");
					dtr.setItemMeta(dtrm);
					
					
					
					ItemStack test = new ItemStack(Material.BEDROCK, 1, (short)0);
					final ItemMeta testm = test.getItemMeta();
					testm.setDisplayName("§cTest");
					test.setItemMeta(testm);
					
					
					
					
					
					

        
        mp3.setItem(1, r1);
        mp3.setItem(2, r2);
        mp3.setItem(3, r3);
        mp3.setItem(4, r4);
        mp3.setItem(5, r5);
        mp3.setItem(6, r6);
        mp3.setItem(7, r7);
        mp3.setItem(12, r8);
        mp3.setItem(13, r9);
        mp3.setItem(14, r10);
        mp3.setItem(22, cosmenu);
        
        
        cosm.setItem(40, sgadget);
        cosm.setItem(20, strail);
        cosm.setItem(24, swardrobe);
        cosm.setItem(4, smusic);
        cosm.setItem(22, mainmenu);
        
        gadget.setItem(49, cosmenu);
        gadget.setItem(48, rstg);
        gadget.setItem(50, staffg);
        
        gadget.setItem(10, fwgun1);
        gadget.setItem(11, explp);
        gadget.setItem(12, plc);
        gadget.setItem(13, tpbow);
        gadget.setItem(14, bb);
        gadget.setItem(15, rod);
        gadget.setItem(16, ph);
        gadget.setItem(22, com);
        
        
        gadget.setItem(19, ml);
        gadget.setItem(20, is);
        gadget.setItem(21, dt);
        gadget.setItem(23, rof);
        gadget.setItem(24, mt);
        gadget.setItem(25, gh1);
        gadget.setItem(28, jp);
        gadget.setItem(29, la);
        gadget.setItem(30, bt);
        gadget.setItem(31, mp);
        gadget.setItem(32, pe);
        gadget.setItem(33, ra);
        

        
        staffgadget.setItem(49, cosmenu);
        staffgadget.setItem(48, rstg);
        staffgadget.setItem(50, gmenu);
        staffgadget.setItem(51, test);
        
        staffgadget.setItem(10, roc);
        staffgadget.setItem(11, lf);
        staffgadget.setItem(12, gr);
        
        trail.setItem(40, cosmenu);
        trail.setItem(10, circ);
        trail.setItem(31, shapec);
        trail.setItem(16, tor);
        trail.setItem(21, spi);
        trail.setItem(23, rad);
        
        radme.setItem(44, dtr);
        radme.setItem(40, cosmenu);
        radme.setItem(32, nxtpage);
        radme.setItem(31, stafft);
        radme.setItem(30, prvpage);
        
        radme.setItem(10, heart);
        radme.setItem(11, noten);
        radme.setItem(12, flame);
        radme.setItem(13, water);
        radme.setItem(14, spark);
        radme.setItem(15, witch);
        radme.setItem(16, smoke); 
        
        
        cirme.setItem(44, dtr);
        cirme.setItem(40, cosmenu);
        cirme.setItem(32, nxtpage);
        cirme.setItem(31, stafft);
        cirme.setItem(30, prvpage);
        
        cirme.setItem(10, heart);
        cirme.setItem(11, noten);
        cirme.setItem(12, flame);
        cirme.setItem(13, water);
        cirme.setItem(14, spark);
        cirme.setItem(15, witch);
        cirme.setItem(16, smoke); 
        
        cirme.setItem(10, heart);
        cirme.setItem(11, noten);
        cirme.setItem(12, flame);
        cirme.setItem(13, water);
        cirme.setItem(14, spark);
        cirme.setItem(15, witch);
        cirme.setItem(16, smoke);
        
        torme.setItem(44, dtr);
        torme.setItem(40, cosmenu);
        torme.setItem(32, nxtpage);
        torme.setItem(31, stafft);
        torme.setItem(30, prvpage);
        
        torme.setItem(10, heart);
        torme.setItem(11, noten);
        torme.setItem(12, flame);
        torme.setItem(13, water);
        torme.setItem(14, spark);
        torme.setItem(15, witch);
        torme.setItem(16, smoke); 
        
        spime.setItem(44, dtr);
        spime.setItem(40, cosmenu);
        spime.setItem(32, nxtpage);
        spime.setItem(31, stafft);
        spime.setItem(30, prvpage);
        
        spime.setItem(10, heart);
        spime.setItem(11, noten);
        spime.setItem(12, flame);
        spime.setItem(13, water);
        spime.setItem(14, spark);
        spime.setItem(15, witch);
        spime.setItem(16, smoke); 
        
        shapeme.setItem(40, cosmenu);
        shapeme.setItem(32, nxtpage);
        shapeme.setItem(31, stafft);
        shapeme.setItem(30, prvpage);
        
        shapeme.setItem(10, atom);
        shapeme.setItem(11, name);
        shapeme.setItem(12, wave);
        shapeme.setItem(13, dna);
        shapeme.setItem(14, spiral);
        shapeme.setItem(15, arc);
        shapeme.setItem(16, dragon); 
     
      
        inv.setItem(11, lh);
        inv.setItem(12, ch);
        inv.setItem(13, ih);
        inv.setItem(14, gh);
        inv.setItem(15, dh);
        
        inv.setItem(20, lc);
        inv.setItem(21, cc);
        inv.setItem(22, ic);
        inv.setItem(23, gc);
        inv.setItem(24, dc);
        
        inv.setItem(29, ll);
        inv.setItem(30, cl);
        inv.setItem(31, il);
        inv.setItem(32, gl);
        inv.setItem(33, dl);

        inv.setItem(38, lb);
        inv.setItem(39, cb);
        inv.setItem(40, ib);
        inv.setItem(41, gb);
        inv.setItem(42, db);
        
        
        inv.setItem(9, BONEMEAL1);
        inv.setItem(18, BONEMEAL2);
        inv.setItem(27, BONEMEAL3);
        inv.setItem(36, BONEMEAL4);
        
        
        inv.setItem(17, glass1);
        inv.setItem(26, glass2);
        inv.setItem(35, glass3);
        inv.setItem(44, glass4);
        inv.setItem(4, pumpkin);
        inv.setItem(50, clearall);
        
        
        inv.setItem(49, cosmenu);
        
        
        
        invlh.setItem(0, white);
        invlh.setItem(1, orange);
        invlh.setItem(2, magenta);
        invlh.setItem(3, lightblue);
        invlh.setItem(4, yellow);
        invlh.setItem(5, lime);
        invlh.setItem(6, pink);
        invlh.setItem(7, gray);
        invlh.setItem(8, silver);
        
        invlh.setItem(10, cyan);
        invlh.setItem(11, purple);
        invlh.setItem(12, blue);
        invlh.setItem(13, brown);
        invlh.setItem(14, green);
        invlh.setItem(15, red);
        invlh.setItem(16, black);
        
        invlh.setItem(30, glass5);
        invlh.setItem(32, arrow);
        
        
        invlc.setItem(0, white);
        invlc.setItem(1, orange);
        invlc.setItem(2, magenta);
        invlc.setItem(3, lightblue);
        invlc.setItem(4, yellow);
        invlc.setItem(5, lime);
        invlc.setItem(6, pink);
        invlc.setItem(7, gray);
        invlc.setItem(8, silver);
        
        invlc.setItem(10, cyan);
        invlc.setItem(11, purple);
        invlc.setItem(12, blue);
        invlc.setItem(13, brown);
        invlc.setItem(14, green);
        invlc.setItem(15, red);
        invlc.setItem(16, black);
        
        invlc.setItem(30, glass5);
        invlc.setItem(32, arrow);
        
        
        invll.setItem(0, white);
        invll.setItem(1, orange);
        invll.setItem(2, magenta);
        invll.setItem(3, lightblue);
        invll.setItem(4, yellow);
        invll.setItem(5, lime);
        invll.setItem(6, pink);
        invll.setItem(7, gray);
        invll.setItem(8, silver);
        
        invll.setItem(10, cyan);
        invll.setItem(11, purple);
        invll.setItem(12, blue);
        invll.setItem(13, brown);
        invll.setItem(14, green);
        invll.setItem(15, red);
        invll.setItem(16, black);
        
        invll.setItem(30, glass5);
        invll.setItem(32, arrow);
        
        
        invlb.setItem(0, white);
        invlb.setItem(1, orange);
        invlb.setItem(2, magenta);
        invlb.setItem(3, lightblue);
        invlb.setItem(4, yellow);
        invlb.setItem(5, lime);
        invlb.setItem(6, pink);
        invlb.setItem(7, gray);
        invlb.setItem(8, silver);
        
        invlb.setItem(10, cyan);
        invlb.setItem(11, purple);
        invlb.setItem(12, blue);
        invlb.setItem(13, brown);
        invlb.setItem(14, green);
        invlb.setItem(15, red);
        invlb.setItem(16, black);
        
        invlb.setItem(30, glass5);
        invlb.setItem(32, arrow);

	
    
    
	
	}
//================================================== WARDROBE BEGGINING ==================================================         
    
    public void show(Player p) {
    	if(p.hasPermission("lobby.wardrobe")){
        p.openInventory(inv);
    	} else {
			p.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    	}
}


@EventHandler
public void onInventoryClick(InventoryClickEvent event) {
  Player player = (Player)event.getWhoClicked();
  ItemStack clicked = event.getCurrentItem();
  Inventory inventory = event.getInventory();
  
  ItemStack glass1 = new ItemStack(Material.INK_SACK, 1, (short)0);
  ItemMeta glassmeta1 = glass1.getItemMeta();
  glassmeta1.setDisplayName("§cClear Slot");
  glass1.setItemMeta(glassmeta1);
  
  ItemStack glass2 = new ItemStack(Material.INK_SACK, 1, (short)0);
  ItemMeta glassmeta2 = glass2.getItemMeta();
  glassmeta2.setDisplayName("§cClear Slot");
  glass2.setItemMeta(glassmeta2);
  
  ItemStack glass3 = new ItemStack(Material.INK_SACK, 1, (short)0);
  ItemMeta glassmeta3 = glass3.getItemMeta();
  glassmeta3.setDisplayName("§cClear Slot");
  glass3.setItemMeta(glassmeta3);
  
  ItemStack glass4 = new ItemStack(Material.INK_SACK, 1, (short)0);
  ItemMeta glass4meta = glass4.getItemMeta();
  glass4meta.setDisplayName("§cClear Slot");
  glass4.setItemMeta(glass4meta);
  
  ItemStack lh = new ItemStack(Material.LEATHER_HELMET, 1);
  ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS, 1);
  ItemStack lb = new ItemStack(Material.LEATHER_BOOTS, 1);
  
  ItemStack whiteh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta whitehmeta = (LeatherArmorMeta) whiteh.getItemMeta();
  whitehmeta.setColor(Color.WHITE);
  whiteh.setItemMeta(whitehmeta);
  
  ItemStack whitecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta whitecpmeta = (LeatherArmorMeta) whitecp.getItemMeta();
  whitecpmeta.setColor(Color.WHITE);
  whitecp.setItemMeta(whitecpmeta);
  
  ItemStack whitel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
  LeatherArmorMeta whitelmeta = (LeatherArmorMeta) whitel.getItemMeta();
  whitelmeta.setColor(Color.WHITE);
  whitel.setItemMeta(whitelmeta);
  ItemStack whiteb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta whitebmeta = (LeatherArmorMeta) whiteb.getItemMeta();
  whitebmeta.setColor(Color.WHITE);
  whiteb.setItemMeta(whitebmeta);
  
  
  ItemStack orangeh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta orangehmeta = (LeatherArmorMeta) orangeh.getItemMeta();
  orangehmeta.setColor(Color.ORANGE);
  orangeh.setItemMeta(orangehmeta);
  ItemStack orangecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta orangecpmeta = (LeatherArmorMeta) orangecp.getItemMeta();
  orangecpmeta.setColor(Color.ORANGE);
  orangecp.setItemMeta(orangecpmeta);
  ItemStack orangel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta orangelmeta = (LeatherArmorMeta) orangel.getItemMeta();
  orangelmeta.setColor(Color.ORANGE);
  orangel.setItemMeta(orangelmeta);
  ItemStack orangeb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta orangebmeta = (LeatherArmorMeta) orangeb.getItemMeta();
  orangebmeta.setColor(Color.ORANGE);
  orangeb.setItemMeta(orangebmeta);
  
  ItemStack magentah = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta magentahmeta = (LeatherArmorMeta) magentah.getItemMeta();
  magentahmeta.setColor(Color.fromBGR(216, 76, 178));
  magentah.setItemMeta(magentahmeta);
  ItemStack magentacp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta magentacpmeta = (LeatherArmorMeta) magentacp.getItemMeta();
  magentacpmeta.setColor(Color.fromBGR(216, 76, 178));
  magentacp.setItemMeta(magentacpmeta);
  ItemStack magental = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta magentalmeta = (LeatherArmorMeta) magental.getItemMeta();
  magentalmeta.setColor(Color.fromBGR(216, 76, 178));
  magental.setItemMeta(magentalmeta);
  ItemStack magentab = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta magentabmeta = (LeatherArmorMeta) magentab.getItemMeta();
  magentabmeta.setColor(Color.fromBGR(216, 76, 178));
  magentab.setItemMeta(magentabmeta);
  
  ItemStack lightblueh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta lightbluehmeta = (LeatherArmorMeta) lightblueh.getItemMeta();
  lightbluehmeta.setColor(Color.fromBGR(216, 153, 102));
  lightblueh.setItemMeta(lightbluehmeta);
  ItemStack lightbluecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta lightbluecpmeta = (LeatherArmorMeta) lightbluecp.getItemMeta();
  lightbluecpmeta.setColor(Color.fromBGR(216, 153, 102));
  lightbluecp.setItemMeta(lightbluecpmeta);
  ItemStack lightbluel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta lightbluelmeta = (LeatherArmorMeta) lightbluel.getItemMeta();
  lightbluelmeta.setColor(Color.fromBGR(216, 153, 102));
  lightbluel.setItemMeta(lightbluelmeta);
  ItemStack lightblueb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta lightbluebmeta = (LeatherArmorMeta) lightblueb.getItemMeta();
  lightbluebmeta.setColor(Color.fromBGR(216, 153, 102));
  lightblueb.setItemMeta(lightbluebmeta);
 
  ItemStack yellowh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta yellowhmeta = (LeatherArmorMeta) yellowh.getItemMeta();
  yellowhmeta.setColor(Color.YELLOW);
  yellowh.setItemMeta(yellowhmeta);
  ItemStack yellowcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta yellowcpmeta = (LeatherArmorMeta) yellowcp.getItemMeta();
  yellowcpmeta.setColor(Color.YELLOW);
  yellowcp.setItemMeta(yellowcpmeta);
  ItemStack yellowl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta yellowlmeta = (LeatherArmorMeta) yellowl.getItemMeta();
  yellowlmeta.setColor(Color.YELLOW);
  yellowl.setItemMeta(yellowlmeta);
  ItemStack yellowb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta yellowbmeta = (LeatherArmorMeta) yellowb.getItemMeta();
  yellowbmeta.setColor(Color.YELLOW);
  yellowb.setItemMeta(yellowbmeta);
  
  ItemStack limeh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta limehmeta = (LeatherArmorMeta) limeh.getItemMeta();
  limehmeta.setColor(Color.LIME);
  limeh.setItemMeta(limehmeta);
  ItemStack limecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta limecpmeta = (LeatherArmorMeta) limecp.getItemMeta();
  limecpmeta.setColor(Color.LIME);
  limecp.setItemMeta(limecpmeta);
  ItemStack limel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta limelmeta = (LeatherArmorMeta) limel.getItemMeta();
  limelmeta.setColor(Color.LIME);
  limel.setItemMeta(limelmeta);
  ItemStack limeb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta limebmeta = (LeatherArmorMeta) limeb.getItemMeta();
  limebmeta.setColor(Color.LIME);
  limeb.setItemMeta(limebmeta);
  
  ItemStack pinkh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta pinkhmeta = (LeatherArmorMeta) pinkh.getItemMeta();
  pinkhmeta.setColor(Color.fromBGR(165, 127, 242));
  pinkh.setItemMeta(pinkhmeta);
  ItemStack pinkcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta pinkcpmeta = (LeatherArmorMeta) pinkcp.getItemMeta();
  pinkcpmeta.setColor(Color.fromBGR(165, 127, 242));
  pinkcp.setItemMeta(pinkcpmeta);
  ItemStack pinkl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta pinklmeta = (LeatherArmorMeta) pinkl.getItemMeta();
  pinklmeta.setColor(Color.fromBGR(165, 127, 242));
  pinkl.setItemMeta(pinklmeta);
  ItemStack pinkb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta pinkbmeta = (LeatherArmorMeta) pinkb.getItemMeta();
  pinkbmeta.setColor(Color.fromBGR(165, 127, 242));
  pinkb.setItemMeta(pinkbmeta);
  
  ItemStack grayh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta grayhmeta = (LeatherArmorMeta) grayh.getItemMeta();
  grayhmeta.setColor(Color.GRAY);
  grayh.setItemMeta(grayhmeta);
  ItemStack graycp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta graycpmeta = (LeatherArmorMeta) graycp.getItemMeta();
  graycpmeta.setColor(Color.GRAY);
  graycp.setItemMeta(graycpmeta);
  ItemStack grayl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta graylmeta = (LeatherArmorMeta) grayl.getItemMeta();
  graylmeta.setColor(Color.GRAY);
  grayl.setItemMeta(graylmeta);
  ItemStack grayb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta graybmeta = (LeatherArmorMeta) grayb.getItemMeta();
  graybmeta.setColor(Color.GRAY);
  grayb.setItemMeta(graybmeta);
  
  ItemStack silverh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta silverhmeta = (LeatherArmorMeta) silverh.getItemMeta();
  silverhmeta.setColor(Color.SILVER);
  silverh.setItemMeta(silverhmeta);
  ItemStack silvercp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta silvercpmeta = (LeatherArmorMeta) silvercp.getItemMeta();
  silvercpmeta.setColor(Color.SILVER);
  silvercp.setItemMeta(silvercpmeta);
  ItemStack silverl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta silverlmeta = (LeatherArmorMeta) silverl.getItemMeta();
  silverlmeta.setColor(Color.SILVER);
  silverl.setItemMeta(silverlmeta);
  ItemStack silverb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta silverbmeta = (LeatherArmorMeta) silverb.getItemMeta();
  silverbmeta.setColor(Color.SILVER);
  silverb.setItemMeta(silverbmeta);
  
  ItemStack cyanh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta cyanhmeta = (LeatherArmorMeta) cyanh.getItemMeta();
  cyanhmeta.setColor(Color.fromBGR(153, 127, 76));
  cyanh.setItemMeta(cyanhmeta);
  ItemStack cyancp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta cyancpmeta = (LeatherArmorMeta) cyancp.getItemMeta();
  cyancpmeta.setColor(Color.fromBGR(153, 127, 76));
  cyancp.setItemMeta(cyancpmeta);
  ItemStack cyanl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta cyanlmeta = (LeatherArmorMeta) cyanl.getItemMeta();
  cyanlmeta.setColor(Color.fromBGR(153, 127, 76));
  cyanl.setItemMeta(cyanlmeta);
  ItemStack cyanb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta cyanbmeta = (LeatherArmorMeta) cyanb.getItemMeta();
  cyanbmeta.setColor(Color.fromBGR(153, 127, 76));
  cyanb.setItemMeta(cyanbmeta);
  
  ItemStack purpleh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta purplehmeta = (LeatherArmorMeta) purpleh.getItemMeta();
  purplehmeta.setColor(Color.PURPLE);
  purpleh.setItemMeta(purplehmeta);
  ItemStack purplecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta purplecpmeta = (LeatherArmorMeta) purplecp.getItemMeta();
  purplecpmeta.setColor(Color.PURPLE);
  purplecp.setItemMeta(purplecpmeta);
  ItemStack purplel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta purplelmeta = (LeatherArmorMeta) purplel.getItemMeta();
  purplelmeta.setColor(Color.PURPLE);
  purplel.setItemMeta(purplelmeta);
  ItemStack purpleb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta purplebmeta = (LeatherArmorMeta) purpleb.getItemMeta();
  purplebmeta.setColor(Color.PURPLE);
  purpleb.setItemMeta(purplebmeta);
  
  ItemStack blueh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta bluehmeta = (LeatherArmorMeta) blueh.getItemMeta();
  bluehmeta.setColor(Color.fromBGR(178, 76, 51));
  blueh.setItemMeta(bluehmeta);
  ItemStack bluecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta bluecpmeta = (LeatherArmorMeta) bluecp.getItemMeta();
  bluecpmeta.setColor(Color.fromBGR(178, 76, 51));
  bluecp.setItemMeta(bluecpmeta);
  ItemStack bluel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta bluelmeta = (LeatherArmorMeta) bluel.getItemMeta();
  bluelmeta.setColor(Color.fromBGR(178, 76, 51));
  bluel.setItemMeta(bluelmeta);
  ItemStack blueb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta bluebmeta = (LeatherArmorMeta) blueb.getItemMeta();
  bluebmeta.setColor(Color.fromBGR(178, 76, 51));
  blueb.setItemMeta(bluebmeta);
  
  ItemStack brownh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta brownhmeta = (LeatherArmorMeta) brownh.getItemMeta();
  brownhmeta.setColor(Color.fromBGR(51, 76, 102));
  brownh.setItemMeta(brownhmeta);
  ItemStack browncp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta browncpmeta = (LeatherArmorMeta) browncp.getItemMeta();
  browncpmeta.setColor(Color.fromBGR(51, 76, 102));
  browncp.setItemMeta(browncpmeta);
  ItemStack brownl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta brownlmeta = (LeatherArmorMeta) brownl.getItemMeta();
  brownlmeta.setColor(Color.fromBGR(51, 76, 102));
  brownl.setItemMeta(brownlmeta);
  ItemStack brownb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta brownbmeta = (LeatherArmorMeta) brownb.getItemMeta();
  brownbmeta.setColor(Color.fromBGR(51, 76, 102));
  brownb.setItemMeta(brownbmeta);
  
  ItemStack greenh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta greenhmeta = (LeatherArmorMeta) greenh.getItemMeta();
  greenhmeta.setColor(Color.GREEN);
  greenh.setItemMeta(greenhmeta);
  ItemStack greencp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta greencpmeta = (LeatherArmorMeta) greencp.getItemMeta();
  greencpmeta.setColor(Color.GREEN);
  greencp.setItemMeta(greencpmeta);
  ItemStack greenl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta greenlmeta = (LeatherArmorMeta) greenl.getItemMeta();
  greenlmeta.setColor(Color.GREEN);
  greenl.setItemMeta(greenlmeta);
  ItemStack greenb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta greenbmeta = (LeatherArmorMeta) greenb.getItemMeta();
  greenbmeta.setColor(Color.GREEN);
  greenb.setItemMeta(greenbmeta);
  
  ItemStack redh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta redhmeta = (LeatherArmorMeta) redh.getItemMeta();
  redhmeta.setColor(Color.RED);
  redh.setItemMeta(redhmeta);
  ItemStack redcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta redcpmeta = (LeatherArmorMeta) redcp.getItemMeta();
  redcpmeta.setColor(Color.RED);
  redcp.setItemMeta(redcpmeta);
  ItemStack redl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta redlmeta = (LeatherArmorMeta) redl.getItemMeta();
  redlmeta.setColor(Color.RED);
  redl.setItemMeta(redlmeta);
  ItemStack redb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta redbmeta = (LeatherArmorMeta) redb.getItemMeta();
  redbmeta.setColor(Color.RED);
  redb.setItemMeta(redbmeta);
  
  ItemStack blackh = new ItemStack(Material.LEATHER_HELMET, 1);
  LeatherArmorMeta blackhmeta = (LeatherArmorMeta) blackh.getItemMeta();
  blackhmeta.setColor(Color.BLACK);
  blackh.setItemMeta(blackhmeta);
  ItemStack blackcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta blackcpmeta = (LeatherArmorMeta) blackcp.getItemMeta();
  blackcpmeta.setColor(Color.BLACK);
  blackcp.setItemMeta(blackcpmeta);
  ItemStack blackl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
  LeatherArmorMeta blacklmeta = (LeatherArmorMeta) blackl.getItemMeta();
  blacklmeta.setColor(Color.BLACK);
  blackl.setItemMeta(blacklmeta);
  ItemStack blackb = new ItemStack(Material.LEATHER_BOOTS, 1);
  LeatherArmorMeta blackbmeta = (LeatherArmorMeta) blackb.getItemMeta();
  blackbmeta.setColor(Color.BLACK);
  blackb.setItemMeta(blackbmeta);
  
  Location loc = player.getLocation();
  
  
  
  if ((inventory.getName().equals(mp3.getName())) && 
	        (clicked.getType() == Material.RECORD_3)) {
	        event.setCancelled(true);
	        player.closeInventory();
	        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_3);
	        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cBlocks");
	        
	        
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_4)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_4);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cChirp");
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_5)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_5);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cFar");
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_6)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_6);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cMall");
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_7)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_7);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cMellohi");
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_8)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_8);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cStal");
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_9)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_9);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cStrad");
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_10)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_10);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cWard");
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_11)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_11);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §c11");
        player.playSound(loc, Sound.AMBIENCE_THUNDER, 2004, 2004);
      
  }else if ((inventory.getName().equals(mp3.getName())) && 
          (clicked.getType() == Material.RECORD_12)) {
      event.setCancelled(true);
        player.closeInventory();
        player.playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_12);
        player.sendMessage("§8[§3MP3 Player§8] §eNow Playing: §cWait");
        
          
      }else if ((inventory.getName().equals(cosm.getName())) && 
              (clicked.getType() == Material.JUKEBOX)) {
          event.setCancelled(true);
	        player.openInventory(mp3);
	        
	          
	      }else if ((inventory.getName().equals(cosm.getName())) && 
	              (clicked.getType() == Material.NETHER_STAR)) {
	          event.setCancelled(true);
	          player.openInventory(gadget);
	          
	      }else if ((inventory.getName().equals(cosm.getName())) && 
	              (clicked.getType() == Material.EXP_BOTTLE)) {
	          event.setCancelled(true);
	          player.openInventory(trail);
		        
		          
	      }else if ((inventory.getName().equals(trail.getName())) && 
	              (event.getCurrentItem().getItemMeta().getDisplayName().contains("Circular"))) {
	          event.setCancelled(true);
	          player.openInventory(cirme);
	          
	          
      }else if ((inventory.getName().equals(trail.getName())) && 
              (event.getCurrentItem().getItemMeta().getDisplayName().contains("Spiral"))) {
          event.setCancelled(true);
          player.openInventory(spime);
          
          
  }else if ((inventory.getName().equals(trail.getName())) && 
          (event.getCurrentItem().getItemMeta().getDisplayName().contains("Shaped"))) {
      event.setCancelled(true);
      player.openInventory(shapeme);
      
}else if ((inventory.getName().equals(trail.getName())) && 
      (event.getCurrentItem().getItemMeta().getDisplayName().contains("Tornado"))) {
  event.setCancelled(true);
  player.openInventory(torme);
  
}else if ((inventory.getName().equals(trail.getName())) && 
  (event.getCurrentItem().getItemMeta().getDisplayName().contains("Radar"))) {
event.setCancelled(true);
player.openInventory(radme);

}else if ((inventory.getName().equals(trail.getName())) && 
(event.getCurrentItem().getItemMeta().getDisplayName().contains("Test"))) {
    Integer amount = Integer.valueOf(1000);
    Integer cash = MySQL.getCash(player.getName());
    Integer cost = Integer.valueOf(amount.intValue());
    if (cash.intValue() < cost.intValue())
    {
      player.sendMessage("§8[§3Lobby§8] §eYou don't have enough money!");
      return;
    }
    MySQL.query("UPDATE `lobby_PLAYERS` SET `TOKENS` = `TOKENS` - " + cost + " WHERE `NAME` = '" + player.getName() + "';");
    player.sendMessage(ChatColor.RED + "Check your balance to see if it has worked! :D");
    Lobby.scoreboard(player);
	          
		        
		          
	      }else if ((inventory.getName().equals(cosm.getName())) && 
	              (clicked.getType() == Material.IRON_INGOT)) {
	          event.setCancelled(true);
	          player.openInventory(inv);
	          
	          
      }else if ((inventory.getName().equals(gadget.getName())) && 
              (clicked.getType() == Material.IRON_BARDING)) {
          event.setCancelled(true);
          if(player.hasPermission("lobby.opfwgun")){
				ItemStack fwgun = new ItemStack(Material.DIAMOND_HOE, 1, (short) 0);
				final ItemMeta fwmeta = fwgun.getItemMeta();
				ArrayList<String> fm = new ArrayList<String>();
				fwmeta.setDisplayName("§4§lOP §c§lFirework Gun §7§l- §e§lRIGHT CLICK");
				fm.add("§7Right Click to Shoot Fireworks!");
				fm.add(" ");
				fm.add("§8Requires: §dHelper");
				fwmeta.setLore(fm);
				fwgun.setItemMeta(fwmeta);
				player.getInventory().setItem(4, fwgun);
		          player.closeInventory();
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
				return;
	}else if(player.hasPermission("lobby.fwgun")){
		
		ItemStack fwgun = new ItemStack(Material.IRON_BARDING, 1, (short) 0);
		final ItemMeta fwmeta = fwgun.getItemMeta();
		fwmeta.setDisplayName("§c§lFirework Gun §7§l- §e§lRIGHT CLICK");
		fwgun.setItemMeta(fwmeta);
		player.getInventory().setItem(4, fwgun);
          player.closeInventory();
		player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
		return;
	}else{
		player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
		return;
	}	      }else if ((inventory.getName().equals(gadget.getName())) && 
              (clicked.getType() == Material.MONSTER_EGG)) {
		event.setCancelled(true);
		if(player.hasPermission("lobby.explodingpigs")) {
		}
          player.closeInventory();
		player.sendMessage("§8[§3Gadgets§8] §eHit the §cPigs §eto Make them §cExplode!");
		ItemStack expg = new ItemStack(Material.MONSTER_EGG, 3, (short) 90);
		final ItemMeta expgm = expg.getItemMeta();
		expgm.setDisplayName("§c§lExploding Pigs");
		expg.setItemMeta(expgm);
		player.getInventory().setItem(4, expg);
		player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
		return;
        }else{
	          player.closeInventory();
	player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	return;
      } if ((inventory.getName().equals(gadget.getName())) && 
              (clicked.getType() == Material.BOW)) {
    	  if(player.hasPermission("lobby.tpbow")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.BOW, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lTeleporting Bow §7- §e§lRIGHT CLICK");
			expg.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			expg.setItemMeta(expgm);
			
			player.getInventory().setItem(4, expg);
			ItemStack expg1 = new ItemStack(Material.ARROW, 64, (short) 0);
			final ItemMeta expgm1 = expg1.getItemMeta();
			ArrayList<String> pm1 = new ArrayList<String>();
			expgm1.setLore(pm1);
			expg1.setItemMeta(expgm1);
			player.getInventory().setItem(13, expg1);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  }else{
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }
    	  
      }else if ((inventory.getName().equals(staffgadget.getName())) && 
              (clicked.getType() == Material.FIREWORK)) {
    	  if(player.hasPermission("lobby.rocket")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.FIREWORK, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lRocket §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  }else{
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;  
    	  }
      }else if ((inventory.getName().equals(gadget.getName())) && 
              (clicked.getType() == Material.SLIME_BALL)) {
    	  if(player.hasPermission("lobby.jumppad")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.SLIME_BALL, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lJump Pad §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  }else{
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;  
    	  }
			
			
	    	  
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.NETHER_BRICK_ITEM)) {
	    	  if (player.hasPermission("lobby.ringofdeath")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.NETHER_BRICK_ITEM, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lRing of Death §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.GHAST_TEAR)) {
	    	  if (player.hasPermission("lobby.rave")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.GHAST_TEAR, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lRave §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.LEASH)) {
	    	  if (player.hasPermission("lobby.lasso")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.LEASH, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lLasso §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(staffgadget.getName())) && 
	              (clicked.getType() == Material.REDSTONE_TORCH_ON)) {
	    	  if (player.hasPermission("lobby.globalrave")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.REDSTONE_TORCH_ON, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§4§lGLOBAL §c§lRave §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.MAGMA_CREAM)) {
	    	  if (player.hasPermission("lobby.ringoffire")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.MAGMA_CREAM, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lRing of Fire §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.SIGN)) {
	    	  if (player.hasPermission("lobby.placard")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.SIGN, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lPlacard §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.NOTE_BLOCK)) {
	    	  if (player.hasPermission("lobby.pharmony")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.NOTE_BLOCK, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lPerfect Harmony §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.NETHER_BRICK_ITEM)) {
	    	  if (player.hasPermission("lobby.ringofdeath")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.NETHER_BRICK_ITEM, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lRing of Death §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.BLAZE_ROD)) {
	    	  if (player.hasPermission("lobby.moblauncher")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.BLAZE_ROD, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lMob Lanucher §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.PACKED_ICE)) {
	    	  if (player.hasPermission("lobby.icesmash")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.PACKED_ICE, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lIce Smash §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.REDSTONE_LAMP_OFF)) {
	    	  if (player.hasPermission("lobby.dancingtime")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.REDSTONE_LAMP_OFF, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lDancin' Time §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.MAGMA_CREAM)) {
	    	  if (player.hasPermission("lobby.ringoffire")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.MAGMA_CREAM, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lRing of Fire §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.WATCH)) {
	    	  if (player.hasPermission("lobby.magictrick")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.WATCH, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lMagic Trick §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(staffgadget.getName())) && 
	              (clicked.getType() == Material.BLAZE_POWDER)) {
	    	  if (player.hasPermission("lobby.lavafountain")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.BLAZE_POWDER, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lLava Fountain §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.FISHING_ROD)) {
	    	  if (player.hasPermission("lobby.grapplinghook")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.FISHING_ROD, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lGrappling Hook §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.NETHER_STAR)) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.NETHER_STAR, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§cNo Gadget Selected §7(Right Click)");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	      }else if ((inventory.getName().equals(staffgadget.getName())) && 
	              (clicked.getType() == Material.NETHER_STAR)) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.NETHER_STAR, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§cNo Gadget Selected §7(Right Click)");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.NETHER_STAR)) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.NETHER_STAR, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§cNo Gadget Selected §7(Right Click)");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
				
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.DIAMOND_BARDING)) {
	    	  if (player.hasPermission("lobby.painteggs")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.DIAMOND_BARDING, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lPaint Eggs §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
				
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.FIREBALL)) {
	    	  if (player.hasPermission("lobby.comet")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.FIREBALL, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lComet §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.SAPLING)) {
	    	  if (player.hasPermission("lobby.bubbytwee")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.SAPLING, 1, (short) 0);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§c§lBubby Twee §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.WOOL)) {
	    	  if (player.hasPermission("lobby.magentaparty")) {
	          event.setCancelled(true);
	          player.closeInventory();
				ItemStack expg = new ItemStack(Material.WOOL, 1, (short) 2);
				final ItemMeta expgm = expg.getItemMeta();
				expgm.setDisplayName("§d§lMagenta Party §7- §e§lRIGHT CLICK");
				expg.setItemMeta(expgm);
				player.getInventory().setItem(4, expg);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	    	  } else {
		          player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	            }
    	  
      }else if ((inventory.getName().equals(gadget.getName())) && 
              (clicked.getType() == Material.ARROW)) {
    	  event.setCancelled(true);
    	  player.closeInventory();
    		  player.openInventory(gadget2);
    		  
      }else if ((inventory.getName().equals(gadget2.getName())) && 
              (clicked.getType() == Material.ARROW)) {
    	  event.setCancelled(true);
    	  player.closeInventory();
    		  player.openInventory(gadget);
    		  
      }else if ((inventory.getName().equals(inv.getName())) && 
              (clicked.getType() == Material.CHEST)) {
    	  event.setCancelled(true);
    	  player.closeInventory();
    		  player.openInventory(cosm);
    		  
	    		  
	      }else if ((inventory.getName().equals(staffgadget.getName())) && 
	              (clicked.getType() == Material.ARROW)) {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    		  player.openInventory(gadget);
	    		  
	      }else if ((inventory.getName().equals(shapeme.getName())) && 
	              (event.getCurrentItem().getItemMeta().getDisplayName().contains("Previous"))) {
	          event.setCancelled(true);
	          player.openInventory(cirme);
    		  
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (event.getCurrentItem().getItemMeta().getDisplayName().contains("Next"))) {
          event.setCancelled(true);
          player.openInventory(radme);
          
      }else if ((inventory.getName().equals(trail.getName())) && 
              (event.getCurrentItem().getItemMeta().getDisplayName().contains("Spiral"))) {
          event.setCancelled(true);
          player.openInventory(spime);
		  
  }else if ((inventory.getName().equals(trail.getName())) && 
          (event.getCurrentItem().getItemMeta().getDisplayName().contains("Radar"))) {
      event.setCancelled(true);
      player.openInventory(radme);
  }else if ((inventory.getName().equals(trail.getName())) && 
          (event.getCurrentItem().getItemMeta().getDisplayName().contains("Circular"))) {
      event.setCancelled(true);
      player.openInventory(cirme);
	  
}else if ((inventory.getName().equals(trail.getName())) && 
      (event.getCurrentItem().getItemMeta().getDisplayName().contains("Tornado"))) {
  event.setCancelled(true);
  player.openInventory(torme);
          
          
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (clicked.getType() == Material.ENDER_CHEST)) {
    	  if (player.hasPermission("lobby.atom")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.ENDER_CHEST, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lAtom Trail §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  } else {
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (clicked.getType() == Material.NAME_TAG)) {
    	  if (player.hasPermission("lobby.name")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.NAME_TAG, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lName Trail §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  } else {
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (clicked.getType() == Material.WATER_BUCKET)) {
    	  if (player.hasPermission("lobby.wave")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.WATER_BUCKET, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lWater Wave §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  } else {
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (clicked.getType() == Material.ENCHANTED_BOOK)) {
    	  if (player.hasPermission("lobby.dna")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.ENCHANTED_BOOK, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lDNA Trail §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  } else {
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (clicked.getType() == Material.BEACON)) {
    	  if (player.hasPermission("lobby.spiral")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.BEACON, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lSpiral Trail §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  } else {
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (event.getCurrentItem().getItemMeta().getDisplayName().contains("Arc"))) {
    	  if (player.hasPermission("lobby.arc")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.RAW_FISH, 1, (short) 2);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lArc Trail §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  } else {
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }
      }else if ((inventory.getName().equals(shapeme.getName())) && 
              (event.getCurrentItem().getItemMeta().getDisplayName().contains("Dragon"))) {
    	  if (player.hasPermission("lobby.dragon")) {
          event.setCancelled(true);
          player.closeInventory();
			ItemStack expg = new ItemStack(Material.DRAGON_EGG, 1, (short) 0);
			final ItemMeta expgm = expg.getItemMeta();
			expgm.setDisplayName("§c§lDragon Breath §7- §e§lRIGHT CLICK");
			expg.setItemMeta(expgm);
			player.getInventory().setItem(4, expg);
			player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
    	  } else {
	          player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	            }

      }else if ((inventory.getName().equals(gadget.getName())) && 
              (clicked.getType() == Material.IRON_FENCE)) {
    	  if(player.hasPermission("lobby.sgadgets")) {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
    		  player.openInventory(staffgadget);	    		  
    	  }else{
	    	  player.closeInventory();
    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
    			return;
    	  }
	      }else if ((inventory.getName().equals(gadget2.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(gadget.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(staffgadget.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(shapeme.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(mp3.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(trail.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.CHEST)) { {
	    	  event.setCancelled(true);
	    	  player.closeInventory();
	    	  player.openInventory(cosm);
	              }
	    	  
	      }else if ((inventory.getName().equals(gadget2.getName())) && 
	              (clicked.getType() == Material.IRON_FENCE)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.sgadgets")) {
		    	  player.closeInventory();
	    		  player.openInventory(staffgadget);	    		  
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	    	  
	    	  //------------------------------------------------------------------------------------------\\
	    	  
	      }else if ((inventory.getName().equals(spime.getName())) && 
	              (clicked.getType() == Material.GOLDEN_APPLE)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.heart")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.SPIRAL, "HEART", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cHeart Spiral Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(spime.getName())) && 
	              (clicked.getType() == Material.NOTE_BLOCK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.note")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.SPIRAL, "NOTE", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cNote Spiral Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(spime.getName())) && 
	              (clicked.getType() == Material.BLAZE_POWDER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.flame")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.SPIRAL, "FLAME", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cFlame Spiral Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(spime.getName())) && 
	              (clicked.getType() == Material.WATER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.water")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.SPIRAL, "DRIP_WATER", 3, Boolean.valueOf(false));    
	    			player.sendMessage("§8[§3Trails§8] §cWater Spiral Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(spime.getName())) && 
	              (clicked.getType() == Material.FIREWORK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.spark")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.SPIRAL, "FIREWORKS_SPARK", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cSpark Spiral Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(spime.getName())) && 
	              (clicked.getType() == Material.BOOK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.witch")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.SPIRAL, "WITCH_MAGIC", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cMagic Spiral Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(spime.getName())) && 
	              (clicked.getType() == Material.INK_SACK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.smoke")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.SPIRAL, "RED_DUST", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cSpell Spiral Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	    	  //--------------------------------------------------\\
	      }else if ((inventory.getName().equals(torme.getName())) && 
	              (clicked.getType() == Material.GOLDEN_APPLE)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.heart")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.TORNADO, "HEART", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cHeart Tornado Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(torme.getName())) && 
	              (clicked.getType() == Material.NOTE_BLOCK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.note")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.TORNADO, "NOTE", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cNote Tornado Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(torme.getName())) && 
	              (clicked.getType() == Material.BLAZE_POWDER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.flame")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.TORNADO, "FLAME", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cFlame Tornado Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(torme.getName())) && 
	              (clicked.getType() == Material.WATER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.water")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.TORNADO, "DRIP_WATER", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cWater Tornado Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(torme.getName())) && 
	              (clicked.getType() == Material.FIREWORK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.spark")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.TORNADO, "FIREWORKS_SPARK", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cSpark Tornado Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(torme.getName())) && 
	              (clicked.getType() == Material.BOOK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.witch")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.TORNADO, "WITCH_MAGIC", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cMagic Tornado Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(torme.getName())) && 
	              (clicked.getType() == Material.INK_SACK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.smoke")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.TORNADO, "RED_DUST", 3, Boolean.valueOf(false)); 
	    			player.sendMessage("§8[§3Trails§8] §cSpell Tornado Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	    	  //--------------------------------------------------\\
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.GOLDEN_APPLE)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.heart")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.RADAR, "HEART", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cHeart Radar Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.NOTE_BLOCK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.note")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.RADAR, "NOTE", 3, Boolean.valueOf(false)); 
	    			player.sendMessage("§8[§3Trails§8] §cNote Radar Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.BLAZE_POWDER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.flame")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.RADAR, "FLAME", 3, Boolean.valueOf(false)); 
	    			player.sendMessage("§8[§3Trails§8] §cFlame Radar Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.WATER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.water")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.RADAR, "DRIP_WATER", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cWater Radar Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.FIREWORK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.spark")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.RADAR, "FIREWORKS_SPARK", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cSpark Radar Trail §eEnabled!");   		  
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.BOOK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.witch")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.RADAR, "WITCH_MAGIC", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cMagic Radar Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(radme.getName())) && 
	              (clicked.getType() == Material.INK_SACK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.smoke")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.RADAR, "RED_DUST", 3, Boolean.valueOf(false)); 
	    			player.sendMessage("§8[§3Trails§8] §cSpell Radar Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	    	  } else if ((inventory.getName().equals(radme.getName())) && 
		              (clicked.getType() == Material.GLASS)) {
		    	  event.setCancelled(true);
			    	  player.closeInventory();
			    	  Maths.stopRotation(player);
		    			player.sendMessage("§8[§3Trails§8] §eTrail §cDisabled!");
	    	  } else if ((inventory.getName().equals(spime.getName())) && 
		              (clicked.getType() == Material.GLASS)) {
		    	  event.setCancelled(true);
			    	  player.closeInventory();
			    	  Maths.stopRotation(player);
		    			player.sendMessage("§8[§3Trails§8] §eTrail §cDisabled!");
	    	  } else if ((inventory.getName().equals(cirme.getName())) && 
		              (clicked.getType() == Material.GLASS)) {
		    	  event.setCancelled(true);
			    	  player.closeInventory();
			    	  Maths.stopRotation(player);
		    			player.sendMessage("§8[§3Trails§8] §eTrail §cDisabled!");
	    	  } else if ((inventory.getName().equals(torme.getName())) && 
		              (clicked.getType() == Material.GLASS)) {
		    	  event.setCancelled(true);
			    	  player.closeInventory();
			    	  Maths.stopRotation(player);
		    			player.sendMessage("§8[§3Trails§8] §eTrail §cDisabled!");
	    	  
	    	  //--------------------------------------------------\\
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.GOLDEN_APPLE)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.heart")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.ROTATION, "HEART", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cHeart Radar Trail §eEnabled!");
		          
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.NOTE_BLOCK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.note")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.ROTATION, "NOTE", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cNote Circle Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.BLAZE_POWDER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.flame")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.ROTATION, "FLAME", 3, Boolean.valueOf(false));  
	    			player.sendMessage("§8[§3Trails§8] §cFlame Circle Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.WATER)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.water")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.ROTATION, "DRIP_WATER", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cWater Circle Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.FIREWORK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.spark")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.ROTATION, "FIREWORKS_SPARK", 3, Boolean.valueOf(false)); 
	    			player.sendMessage("§8[§3Trails§8] §cHeart Circle Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");		    			return;
	    	  }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.BOOK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.witch")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.ROTATION, "WITCH_SPELL", 3, Boolean.valueOf(false));
	    			player.sendMessage("§8[§3Trails§8] §cSpell Circle Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	      }else if ((inventory.getName().equals(cirme.getName())) && 
	              (clicked.getType() == Material.INK_SACK)) {
	    	  event.setCancelled(true);
	    	  if(player.hasPermission("lobby.smoke")) {
		    	  player.closeInventory();
		          Filtre.filtre(player, Filtre.RotationType.ROTATION, "RED_DUST", 3, Boolean.valueOf(false));  
	    			player.sendMessage("§8[§3Trails§8] §cMagic Circle Trail §eEnabled!");
	    	  }else{
		    	  player.closeInventory();
	    			player.sendMessage("§8[§3Permissions§8] §eNo Permission!");
	    			return;
	    	  }
	          
	          
	          






  // =============================START WARDROBE==================================== \\
      
      
  }else if ((inventory.getName().equals(inv.getName())) && 
    (clicked.getType() == Material.LEATHER_HELMET)) {
    event.setCancelled(true);
    player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.LEATHER_CHESTPLATE)) {
      event.setCancelled(true);
      player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.LEATHER_LEGGINGS)) {
      event.setCancelled(true);
      player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.LEATHER_BOOTS)) {
      event.setCancelled(true);
      player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.PUMPKIN)) {
      event.setCancelled(true);
      player.getInventory().setHelmet(new ItemStack(Material.PUMPKIN, 1));
      
      
      
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.CHAINMAIL_HELMET)) {
      event.setCancelled(true);
      player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.CHAINMAIL_CHESTPLATE)) {
      event.setCancelled(true);
      player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.CHAINMAIL_LEGGINGS)) {
      event.setCancelled(true);
      player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.CHAINMAIL_BOOTS)) {
      event.setCancelled(true);
      player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));

      
      
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.IRON_HELMET)) {
      event.setCancelled(true);
      player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.IRON_CHESTPLATE)) {
      event.setCancelled(true);
      player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.IRON_LEGGINGS)) {
      player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.IRON_BOOTS)) {
      event.setCancelled(true);
      player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
      
            
      
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GOLD_HELMET)) {
      event.setCancelled(true);
      player.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GOLD_CHESTPLATE)) {
      event.setCancelled(true);
      player.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GOLD_LEGGINGS)) {
      event.setCancelled(true);
      player.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GOLD_BOOTS)) {
      event.setCancelled(true);
      player.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
      
      
               
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.DIAMOND_HELMET)) {
      event.setCancelled(true);
      player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.DIAMOND_CHESTPLATE)) {
      event.setCancelled(true);
      player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.DIAMOND_LEGGINGS)) {
      event.setCancelled(true);
      player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.DIAMOND_BOOTS)) {
      event.setCancelled(true);
      player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
      
      
      
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GLASS) &&
          clicked.getAmount() == 1) {
      event.setCancelled(true);
      player.getInventory().setHelmet(null);
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GLASS) &&
          clicked.getAmount() == 2) {
      event.setCancelled(true);
      player.getInventory().setChestplate(null);
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GLASS) &&
          clicked.getAmount() == 3) {
      event.setCancelled(true);
      player.getInventory().setLeggings(null);
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GLASS) &&
          clicked.getAmount() == 4) {
      event.setCancelled(true);
      player.getInventory().setBoots(null);
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.GLASS) &&
          clicked.getAmount() == 5) {
      event.setCancelled(true);
      player.getInventory().setBoots(null);
      player.getInventory().setLeggings(null);
      player.getInventory().setChestplate(null);
      player.getInventory().setHelmet(null);
      
      
      
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.INK_SACK) &&
          clicked.getAmount() == 1) {
      event.setCancelled(true);
      player.openInventory(invlh);
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.INK_SACK) &&
          clicked.getAmount() == 2) {
      event.setCancelled(true);
      player.openInventory(invlc);
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.INK_SACK) &&
          clicked.getAmount() == 3) {
      event.setCancelled(true);
      player.openInventory(invll);
  }else if ((inventory.getName().equals(inv.getName())) && 
          (clicked.getType() == Material.INK_SACK) &&
          clicked.getAmount() == 4) {
      event.setCancelled(true);
      player.openInventory(invlb);
      
      
      
  }else if ((inventory.getName().equals(invlh.getName())) && 
           (clicked.getType() == Material.ARROW)){
      event.setCancelled(true);
      player.closeInventory();
      player.openInventory(inv);
  }else if ((inventory.getName().equals(invlc.getName())) && 
          (clicked.getType() == Material.ARROW)){
     event.setCancelled(true);
     player.closeInventory();
     player.openInventory(inv);
  }else if ((inventory.getName().equals(invll.getName())) && 
          (clicked.getType() == Material.ARROW)){
     event.setCancelled(true);
     player.closeInventory();
     player.openInventory(inv);
  }else if ((inventory.getName().equals(invlb.getName())) && 
          (clicked.getType() == Material.ARROW)){
     event.setCancelled(true);
     player.closeInventory();
     player.openInventory(inv);
      
      
      
  }else if ((inventory.getName().equals(invlh.getName())) && 
          (clicked.getType() == Material.GLASS)){
      event.setCancelled(true);
      player.getInventory().setHelmet(lh);
  }else if ((inventory.getName().equals(invlc.getName())) && 
          (clicked.getType() == Material.GLASS)){
      event.setCancelled(true);
      player.getInventory().setChestplate(lc);
  }else if ((inventory.getName().equals(invll.getName())) && 
          (clicked.getType() == Material.GLASS)){
      event.setCancelled(true);
      player.getInventory().setLeggings(ll);
  }else if ((inventory.getName().equals(invlb.getName())) && 
          (clicked.getType() == Material.GLASS)){
      event.setCancelled(true);
      player.getInventory().setBoots(lb);
      
      
      
  }else if ((inventory.getName().equals(invlh.getName())) && 
           (clicked.getItemMeta().getDisplayName().contains("White"))){
      event.setCancelled(true);
      player.getInventory().setHelmet(whiteh);
  }else if ((inventory.getName().equals(invlc.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("White"))){
     event.setCancelled(true);
     player.getInventory().setChestplate(whitecp);
  }else if ((inventory.getName().equals(invll.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("White"))){
     event.setCancelled(true);
     player.getInventory().setLeggings(whitel);
  }else if ((inventory.getName().equals(invlb.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("White"))){
     event.setCancelled(true);
     player.getInventory().setBoots(whiteb);
     
     
  }else if ((inventory.getName().equals(invlh.getName())) && 
          (clicked.getItemMeta().getDisplayName().contains("Orange"))){
     event.setCancelled(true);
     player.getInventory().setHelmet(orangeh);
 }else if ((inventory.getName().equals(invlc.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Orange"))){
    event.setCancelled(true);
    player.getInventory().setChestplate(orangecp);
 }else if ((inventory.getName().equals(invll.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Orange"))){
    event.setCancelled(true);
    player.getInventory().setLeggings(orangel);
 }else if ((inventory.getName().equals(invlb.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Orange"))){
    event.setCancelled(true);
    player.getInventory().setBoots(orangeb);
    
    
 }else if ((inventory.getName().equals(invlh.getName())) && 
         (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
    event.setCancelled(true);
    player.getInventory().setHelmet(magentah);
}else if ((inventory.getName().equals(invlc.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
   event.setCancelled(true);
   player.getInventory().setChestplate(magentacp);
}else if ((inventory.getName().equals(invll.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
   event.setCancelled(true);
   player.getInventory().setLeggings(magental);
}else if ((inventory.getName().equals(invlb.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Magenta"))){
   event.setCancelled(true);
   player.getInventory().setBoots(magentab);
   
   
}else if ((inventory.getName().equals(invlh.getName())) && 
        (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
   event.setCancelled(true);
   player.getInventory().setHelmet(lightblueh);
}else if ((inventory.getName().equals(invlc.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
  event.setCancelled(true);
  player.getInventory().setChestplate(lightbluecp);
}else if ((inventory.getName().equals(invll.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
  event.setCancelled(true);
  player.getInventory().setLeggings(lightbluel);
}else if ((inventory.getName().equals(invlb.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Light Blue"))){
  event.setCancelled(true);
  player.getInventory().setBoots(lightblueb);
  
  
}else if ((inventory.getName().equals(invlh.getName())) && 
       (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
  event.setCancelled(true);
  player.getInventory().setHelmet(yellowh);
}else if ((inventory.getName().equals(invlc.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
 event.setCancelled(true);
 player.getInventory().setChestplate(yellowcp);
}else if ((inventory.getName().equals(invll.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
 event.setCancelled(true);
 player.getInventory().setLeggings(yellowl);
}else if ((inventory.getName().equals(invlb.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Yellow"))){
 event.setCancelled(true);
 player.getInventory().setBoots(yellowb);
 
 
}else if ((inventory.getName().equals(invlh.getName())) && 
      (clicked.getItemMeta().getDisplayName().contains("Lime"))){
 event.setCancelled(true);
 player.getInventory().setHelmet(limeh);
}else if ((inventory.getName().equals(invlc.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Lime"))){
event.setCancelled(true);
player.getInventory().setChestplate(limecp);
}else if ((inventory.getName().equals(invll.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Lime"))){
event.setCancelled(true);
player.getInventory().setLeggings(limel);
}else if ((inventory.getName().equals(invlb.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Lime"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(limeb);


}else if ((inventory.getName().equals(invlh.getName())) && 
     (clicked.getItemMeta().getDisplayName().contains("Pink"))){
event.setCancelled(true);
player.getInventory().setHelmet(pinkh);
}else if ((inventory.getName().equals(invlc.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Pink"))){
event.setCancelled(true);
player.getInventory().setChestplate(pinkcp);
}else if ((inventory.getName().equals(invll.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Pink"))){
event.setCancelled(true);
player.getInventory().setLeggings(pinkl);
}else if ((inventory.getName().equals(invlb.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Pink"))){
event.setCancelled(true);
player.closeInventory();
player.getInventory().setBoots(pinkb);


}else if ((inventory.getName().equals(invlh.getName())) && 
    (clicked.getItemMeta().getDisplayName().contains("Gray"))){
event.setCancelled(true);
player.getInventory().setHelmet(grayh);
}else if ((inventory.getName().equals(invlc.getName())) && 
   (clicked.getItemMeta().getDisplayName().contains("Gray"))){
event.setCancelled(true);
player.getInventory().setChestplate(graycp);
}else if ((inventory.getName().equals(invll.getName())) && 
   (clicked.getItemMeta().getDisplayName().contains("Gray"))){
event.setCancelled(true);
player.getInventory().setLeggings(grayl);
}else if ((inventory.getName().equals(invlb.getName())) && 
   (clicked.getItemMeta().getDisplayName().contains("Gray"))){
event.setCancelled(true);
player.getInventory().setBoots(grayb);


}else if ((inventory.getName().equals(invlh.getName())) && 
   (clicked.getItemMeta().getDisplayName().contains("Silver"))){
event.setCancelled(true);
player.getInventory().setHelmet(silverh);
}else if ((inventory.getName().equals(invlc.getName())) && 
  (clicked.getItemMeta().getDisplayName().contains("Silver"))){
event.setCancelled(true);
player.getInventory().setChestplate(silvercp);
}else if ((inventory.getName().equals(invll.getName())) && 
  (clicked.getItemMeta().getDisplayName().contains("Silver"))){
event.setCancelled(true);
player.getInventory().setLeggings(silverl);
}else if ((inventory.getName().equals(invlb.getName())) && 
  (clicked.getItemMeta().getDisplayName().contains("Silver"))){
event.setCancelled(true);
player.getInventory().setBoots(silverb);


}else if ((inventory.getName().equals(invlh.getName())) && 
  (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
event.setCancelled(true);
player.getInventory().setHelmet(cyanh);
}else if ((inventory.getName().equals(invlc.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
event.setCancelled(true);
player.getInventory().setChestplate(cyancp);
}else if ((inventory.getName().equals(invll.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
event.setCancelled(true);
player.getInventory().setLeggings(cyanl);
}else if ((inventory.getName().equals(invlb.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Cyan"))){
event.setCancelled(true);
player.getInventory().setBoots(cyanb);


}else if ((inventory.getName().equals(invlh.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.getInventory().setHelmet(purpleh);
}else if ((inventory.getName().equals(invlc.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.getInventory().setChestplate(purplecp);
}else if ((inventory.getName().equals(invll.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.getInventory().setLeggings(purplel);
}else if ((inventory.getName().equals(invlb.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Purple"))){
event.setCancelled(true);
player.getInventory().setBoots(purpleb);


}else if ((inventory.getName().equals(invlh.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.getInventory().setHelmet(blueh);
}else if ((inventory.getName().equals(invlc.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.getInventory().setChestplate(bluecp);
}else if ((inventory.getName().equals(invll.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.getInventory().setLeggings(bluel);
}else if ((inventory.getName().equals(invlb.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Blue"))){
event.setCancelled(true);
player.getInventory().setBoots(blueb);


}else if ((inventory.getName().equals(invlh.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.getInventory().setHelmet(brownh);
}else if ((inventory.getName().equals(invlc.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.getInventory().setChestplate(browncp);
}else if ((inventory.getName().equals(invll.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.getInventory().setLeggings(brownl);
}else if ((inventory.getName().equals(invlb.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Brown"))){
event.setCancelled(true);
player.getInventory().setBoots(brownb);


}else if ((inventory.getName().equals(invlh.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.getInventory().setHelmet(greenh);
}else if ((inventory.getName().equals(invlc.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.getInventory().setChestplate(greencp);
}else if ((inventory.getName().equals(invll.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.getInventory().setLeggings(greenl);
}else if ((inventory.getName().equals(invlb.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Green"))){
event.setCancelled(true);
player.getInventory().setBoots(greenb);


}else if ((inventory.getName().equals(invlh.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.getInventory().setHelmet(redh);
}else if ((inventory.getName().equals(invlc.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.getInventory().setChestplate(redcp);
}else if ((inventory.getName().equals(invll.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.getInventory().setLeggings(redl);
}else if ((inventory.getName().equals(invlb.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Red"))){
event.setCancelled(true);
player.getInventory().setBoots(redb);


}else if ((inventory.getName().equals(invlh.getName())) && 
 (clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.getInventory().setHelmet(blackh);
}else if ((inventory.getName().equals(invlc.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.getInventory().setChestplate(blackcp);
}else if ((inventory.getName().equals(invll.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.getInventory().setLeggings(blackl);
}else if ((inventory.getName().equals(invlb.getName())) && 
(clicked.getItemMeta().getDisplayName().contains("Black"))){
event.setCancelled(true);
player.getInventory().setBoots(blackb);


     	
} else {
	if (inventory.getName().equals(invlh.getName())
			|| inventory.getName().equals(invlc.getName())
			|| inventory.getName().equals(invll.getName())
			|| inventory.getName().equals(invlb.getName())
			|| inventory.getName().equals(inv.getName())){
		if(clicked != null){
		event.setCancelled(true);
		player.closeInventory();
		}
	}
}
	if (inventory.getName().equals(invlh.getName())
			|| inventory.getName().equals(invlc.getName())
			|| inventory.getName().equals(invll.getName())
			|| inventory.getName().equals(invlb.getName())
			|| inventory.getName().equals(inv.getName())){
		player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
	}
	
} 
    

}
