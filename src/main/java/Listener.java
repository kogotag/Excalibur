import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {
    String prefix = Config.getConfig().get("prefix");

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        TextChannel channel = event.getChannel();
        String author_name = event.getAuthor().getName();
        String text = event.getMessage().getContentRaw();
        if (text.toLowerCase().startsWith(prefix + "hi")) {
            channel.sendMessage(author_name + ", Hi!").queue();
        }
    }
}
