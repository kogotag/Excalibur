import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class bot {
    public static void main(String[] args) throws IOException, LoginException {
        String token = Config.getConfig().get("token");
        JDABuilder.createDefault(
                token,
                GatewayIntent.GUILD_MESSAGES
        )
                .addEventListeners(new Listener())
                .build();
    }
}
