package customparticle.main;

import customparticle.commands.SpawnParticleCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleMain extends JavaPlugin {

    public void onEnable() {
        loadCommands();
    }

    public void onDisable() {

    }

    private void loadCommands() {
        getCommand("spawnParticle").setExecutor(new SpawnParticleCommand(this));
    }

}