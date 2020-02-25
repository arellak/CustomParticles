package customparticle.particle;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class CustomParticle {

	public void createLine(Player player) {
		Location loc = player.getEyeLocation();
		float yaw = loc.getYaw();

		for(int i = 0; i < 10; i++) {
			if (yaw > 135 && yaw < 225) {
				// negative z
				Location newLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()-i, loc.getYaw(), loc.getPitch());
				player.spawnParticle(Particle.VILLAGER_HAPPY, newLoc, 1);
			} else if ((yaw > 0 && yaw < 45) || (yaw > 315 && yaw < 360)) {
				// positive z
				Location newLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()+i, loc.getYaw(), loc.getPitch());
				player.spawnParticle(Particle.VILLAGER_HAPPY, newLoc, 1);
			} else if (yaw > 45 && yaw < 135) {
				// negative x
				Location newLoc = new Location(loc.getWorld(), loc.getX()-i, loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
				player.spawnParticle(Particle.VILLAGER_HAPPY, newLoc, 1);
			} else if (yaw > 225 && yaw < 315) {
				// positive x
				Location newLoc = new Location(loc.getWorld(), loc.getX()+i, loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
				player.spawnParticle(Particle.VILLAGER_HAPPY, newLoc, 1);
			}
		}
	}

	public void createSquare(Player player) {
		Location loc = player.getEyeLocation();
		float yaw = loc.getYaw();
		float distance = 3f;
		if (yaw > 135 && yaw < 225) {
			// negative z
			for(float x = -1; x <= 1; x+=0.5) {
				for(float y = -1; y <= 1; y+=0.5) {
					spawnParticle(player, loc, x, y, -distance);
				}
			}
		} else if ((yaw > 0 && yaw < 45) || (yaw > 315 && yaw < 360)) {
			// positive z
			for(float x = -1; x <= 1; x+=0.5) {
				for(float y = -1; y <= 1; y+=0.5) {
					spawnParticle(player, loc, x, y, distance);
				}
			}
		} else if (yaw > 45 && yaw < 135) {
			// negative x
			for(float z = -1; z <= 1; z+=0.5) {
				for(float y = -1; y <= 1; y+=0.5) {
					spawnParticle(player, loc, -distance, y, z);
				}
			}
		} else if (yaw > 225 && yaw < 315) {
			// positive x
			for(float z = -1; z <= 1; z+=0.5) {
				for(float y = -1; y <= 1; y+=0.5) {
					spawnParticle(player, loc, distance, y, z);
				}
			}
		}

	}

	public void createCube(Player player) {
		Location loc = player.getEyeLocation();

		float yaw = loc.getYaw();
		float distance = 3f;

		if (yaw > 135 && yaw < 225) {
			// negative z
			for(float x = -1; x <= 1; x+=0.5) {
				for(float y = -1; y <= 1; y+=0.5) {
					for(float z = -distance; z > distance*2; z-=0.5) {
						spawnParticle(player, loc, x, y, z);
					}
				}
			}
		} else if ((yaw > 0 && yaw < 45) || (yaw > 315 && yaw < 360)) {
			// positive z
			for(float x = -1; x <= 1; x+=0.5) {
				for(float y = -1; y <= 1; y+=0.5) {
					for(float z = distance; z < distance*2; z+=0.5) {
						spawnParticle(player, loc, x, y, z);
					}
				}
			}
		} else if (yaw > 45 && yaw < 135) {
			// negative x
			for (float x = -distance; x > distance * 2; x -= 0.5) {
				for (float y = -1; y <= 1; y += 0.5) {
					for (float z = -1; z <= 1; z += 0.5) {
						spawnParticle(player, loc, x, y, z);
					}
				}
			}
		} else if (yaw > 225 && yaw < 315) {
			// positive x
			for(float x = distance; x < distance*2; x+=0.5) {
				for (float y = -1; y <= 1; y += 0.5) {
					for (float z = -1; z <= 1; z += 0.5) {
						spawnParticle(player, loc, x, y, z);
					}
				}
			}
		}
	}

	private void spawnParticle(Player player, Location loc, float offsetX, float offsetY, float offsetZ) {
		Location newLoc = new Location(loc.getWorld(), loc.getX() + offsetX, loc.getY() + offsetY, loc.getZ() + offsetZ, loc.getYaw(), loc.getPitch());

		player.spawnParticle(Particle.VILLAGER_HAPPY, newLoc, 1);
	}

	public void drawCube(Location origin, double edgeLength, Particle particle) {
        for(double x = origin.getX()-(edgeLength/2); x < origin.getX() + (edgeLength/2); x++) {
            for(double y = origin.getY()-(edgeLength/2); y < origin.getY() + (edgeLength/2); y++) {
                for (double z = origin.getZ()-(edgeLength/2); z < origin.getZ() + (edgeLength/2); z++) {
                    Location loc = new Location(origin.getWorld(), x, y, z);
                    origin.getWorld().spawnParticle(particle, loc, 1);
                }
            }
        }
    }
	
}