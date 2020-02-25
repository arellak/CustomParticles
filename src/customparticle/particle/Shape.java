package customparticle.particle;

import customparticle.main.ParticleMain;
import org.bukkit.Location;
import org.bukkit.Particle;

public abstract class Shape {

    private Location origin;
    private Particle type;

    private ParticleMain main;

    public Shape(ParticleMain main) {
        this.main = main;
    }

    public abstract void create(Particle particle, Location origin, double edgeLength);

    public void move(MoveDirection md, double offset) {
        switch(md) {
            case EAST:
                setOrigin(new Location(origin.getWorld(), origin.getX() + offset, origin.getY(), origin.getZ()));
                break;
            case WEST:
                setOrigin(new Location(origin.getWorld(), origin.getX() - offset, origin.getY(), origin.getZ()));
                break;
            case NORTH:
                setOrigin(new Location(origin.getWorld(), origin.getX(), origin.getY(), origin.getZ() - offset));
                break;
            case SOUTH:
                setOrigin(new Location(origin.getWorld(), origin.getX(), origin.getY(), origin.getZ() + offset));
                break;
        }
    }

    public void rotate() {

    }

    public void setOrigin(Location loc) {
        this.origin = loc;
    }

    public Location getOrigin() {
        return this.origin;
    }

    public void setType(Particle type) {
        this.type = type;
    }

    public Particle getType() {
        return this.type;
    }

    public ParticleMain getMain() {
        return this.main;
    }

}