package customparticle.particle;

import customparticle.main.ParticleMain;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;

public class Cube extends Shape {

    public Cube(ParticleMain main) {
        super(main);
    }

    @Override
    public void create(Particle particle, Location origin, double edgeLength) {
        setOrigin(origin);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(getMain(), new Runnable() {
            @Override
            public void run() {
                for(double x = getOrigin().getX()-(edgeLength/2); x < getOrigin().getX() + (edgeLength/2); x++) {
                    for(double y = getOrigin().getY()-(edgeLength/2); y < getOrigin().getY() + (edgeLength/2); y++) {
                        for (double z = getOrigin().getZ()-(edgeLength/2); z < getOrigin().getZ() + (edgeLength/2); z++) {
                            Location loc = new Location(getOrigin().getWorld(), x, y, z);
                            getOrigin().getWorld().spawnParticle(particle, loc, 1);
                            move(MoveDirection.WEST, 0.1);
                        }
                    }
                }
            }
        }, 5, 10);
    }

}