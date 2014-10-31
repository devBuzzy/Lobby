package utils;

import java.util.HashMap;

import me.NitroxMC.Lobby.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Maths {
	
	final public static HashMap<Player, Integer> countdown_id = new HashMap<Player, Integer>();

	// final public static HashMap<Player, Integer> id = new HashMap<Player,
	// Integer>();

	public static void rotationEffect(final Player p, final String particle,
			final float radius, final Boolean randomColor) {

		if (!countdown_id.containsKey(p)) {
			final float radius1 = 0.4F;

			final double radialsPerStep = Math.PI
					/ 4;
			// if (!HypixelEffect.config.HypixelMode) {
			int i = Bukkit.getScheduler()
					.runTaskTimer(
							Lobby.plugin, new Runnable() {
								float step = 0;

								public void run() {

									Location loc = p.getLocation();
									loc.add(0, 2F, 0);
									loc.add(Math.cos(radialsPerStep * step)
											* radius1, 0,
											Math.sin(radialsPerStep * step)
													* radius1);
									if (randomColor) {
										ParticleFX.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F,1.0F, 1);
									} else {
										ParticleFX.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F, 0.0F, 1);
									}
									step++;

								}
							}, 1L,
							1L).getTaskId();
			countdown_id.put(p, i);
			// }
			// else {
			// int i = Bukkit.getScheduler().runTaskTimer(HypixelEffect.plugin,
			// new Runnable() {
			//
			// public void run() {
			//
			// Location loc = p.getLocation().add(0.0f , 1.9f , 0.0f);
			// if (id.containsKey(p)) {
			// Bukkit.getServer().getScheduler().cancelTask(id.get(p));
			// id.remove(p);
			// }
			// functionRotation(p , loc, particle, radius, randomColor);
			//
			// }
			// }, 10L, 10L).getTaskId();
			// countdown_id.put(p, i);
			// }
		} else {
			stopRotation(p);
		}

	}

	// Not Working :(

	// public static void functionRotation(Player p, final Location loc, final
	// String particle, final float radius, final Boolean randomColor) {
	// final double radialsPerStep = Math.PI / 6;
	// int i2 = Bukkit.getScheduler().runTaskTimer(HypixelEffect.plugin, new
	// Runnable() {
	// float step = 0;
	// public void run() {
	//
	// loc.add(Math.cos(radialsPerStep * step) * radius, 0,
	// Math.sin(radialsPerStep * step) * radius);
	//
	// if (randomColor) {
	// ParticleEffects.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F, 1.0F,
	// 1);
	// } else {
	// ParticleEffects.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F, 0.0F,
	// 1);
	// }
	// step++;
	//
	// }
	// }, 1L, 1L).getTaskId();
	// id.put(p, i2);
	//
	// }

	public static void radarEffect(final Player p, final String particle,
			final Boolean randomColor) {

		final float radius = 0.2f;
		final double radialsPerStep = Math.PI / 18;

		if (!countdown_id.containsKey(p)) {

			int i = Bukkit.getServer().getScheduler()
					.runTaskTimer(Lobby.plugin, new Runnable() {
						float j = 0.0F;

						public void run() {
							Location loc = p.getLocation();
							loc.setY(loc.getY() + 2.0D);
							for (int k = 0; k < 5F; k++) {
								loc.setX(loc.getX()
										+ Math.sin(this.j * radialsPerStep)
										* radius);
								loc.setY(loc.getY());

								loc.setZ(loc.getZ()
										+ Math.cos(this.j * radialsPerStep)
										* radius);

								if (randomColor) {
									ParticleFX.valueOf(particle).display(loc,
										0.0F, 0.0F, 0.0F, 1.0F, 1);
								} else {
									ParticleFX.valueOf(particle).display(loc,
											0.0F, 0.0F, 0.0F, 0.0F, 1);
								}

								this.j += 0.3F;
							}
							if (this.j >= 360.0F) {
								this.j = 0.0F;
							}
						}
					}, 1L, 1L).getTaskId();
			countdown_id.put(p, i);
		} else {
			stopRotation(p);
		}
	}

	public static void spiraleEffect(final Player p, final String particle,
			final Boolean randomColor) {

		final float radius = 3.7f;
		final int lineNumber = 1;
		final float heightEcart = 0.4f;
		final float MaximumHeight = 5.0f;

		if (!countdown_id.containsKey(p)) {

			int i = Bukkit.getServer().getScheduler()
					.runTaskTimer(Lobby.plugin, new Runnable() {

						float i = 0f;

						public void run() {
							for (int k = 0; k < lineNumber; k++) {

								Location l = p.getLocation();
								double x = Math.sin(i * radius);
								double y = Math.cos(i * radius);
								double z = i * heightEcart;
								Vector v = new Vector(x, z, y);
								l.add(v);
								if (randomColor) {
									ParticleFX.valueOf(particle).display(
											l, 0, 0, 0, 1, 1);
								} else {
									ParticleFX.valueOf(particle).display(
											l, 0, 0, 0, 0, 1);
								}

							}

							i += 0.1f;
							if (i > MaximumHeight) {

								i = 0;
							}
						}

					}, 1L, 1L).getTaskId();
			countdown_id.put(p, i);
		} else {
			stopRotation(p);
		}
	}

	public static void tornadoEffect(final Player p, final String particle,
			final Boolean randomColor) {

		if (!countdown_id.containsKey(p)) {
			int i = Bukkit.getServer().getScheduler()
					.runTaskTimer(Lobby.plugin, new Runnable() {

						final float LineNumber = 3f;
						float j = 0.0f;
						final float radius = 0.3f;
						final float heightEcart = 0.01f;

						public void run() {

							Location loc = p.getLocation();
							loc.setY(loc.getY() + 2);

							for (int k = 0; k < LineNumber; k++) {

								loc.add(Math.cos(j) * radius, j * heightEcart,
										Math.sin(j) * radius);
								if (randomColor) {
									ParticleFX.valueOf(particle).display(
											loc, 0.0F, 0.0F, 0.0F, 1.0F, 1);
								} else {
									ParticleFX.valueOf(particle).display(
											loc, 0.0F, 0.0F, 0.0F, 0.0F, 1);
								}

							}

							j += 0.2f;
							if (j > 50) {

								j = 0;
							}

						}

					}, 1L, 1L).getTaskId();
			countdown_id.put(p, i);

		} else {
			stopRotation(p);
		}

	}

	public static void stopRotation(Player p) {
		if (countdown_id.containsKey(p)) {
			Bukkit.getServer().getScheduler().cancelTask(countdown_id.get(p));
			countdown_id.remove(p);
			// if (id.containsKey(p)) {
			// Bukkit.getServer().getScheduler().cancelTask(id.get(p));
			// id.remove(p);
			// }
		} else {
				p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);

		}
	}
}
