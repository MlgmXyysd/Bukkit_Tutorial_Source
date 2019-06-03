import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("插件加载完成！");
    }
}
