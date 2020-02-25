package customparticle.commands;

import customparticle.main.ParticleMain;
import customparticle.particle.Cube;
import customparticle.particle.CustomParticle;
import customparticle.particle.MoveDirection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnParticleCommand implements CommandExecutor {

    private ParticleMain main;
    private double i;

    public SpawnParticleCommand(ParticleMain main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        i = 0;
        if(args.length < 1) {
            return true;
        }

        if(cs instanceof Player) {
            Player player = (Player) cs;
            CustomParticle cp = new CustomParticle();

            if (args[0].equalsIgnoreCase("line")) {
                Bukkit.getScheduler().scheduleSyncRepeatingTask(this.main, new Runnable() {

                    @Override
                    public void run() {
                        cp.createLine(player);
                    }

                }, 5, 10);
            } else if(args[0].equalsIgnoreCase("square")) {
                Bukkit.getScheduler().scheduleSyncRepeatingTask(this.main, new Runnable() {

                    @Override
                    public void run() {
                        cp.createSquare(player);
                    }

                }, 5, 10);
            } else if(args[0].equalsIgnoreCase("cube")) {
                Location eyeLoc = player.getEyeLocation();
                Cube cube = new Cube(main);
                cube.create(Particle.VILLAGER_HAPPY, eyeLoc, 3);
            }
        }

        return true;
    }

}