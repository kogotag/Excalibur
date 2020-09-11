import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Config config;

    public static Config getConfig() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    private static String configPath;
    private static Properties botProps;

    private Config() {
        configPath = new File(Config.class.getProtectionDomain().getCodeSource().getLocation()
                .getPath()).getParent() + "/bot.properties";
        try {
            botProps = new Properties();
            botProps.load(new FileInputStream(configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return botProps.getProperty(key);
    }
}
