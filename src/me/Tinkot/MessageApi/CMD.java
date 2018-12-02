package me.Tinkot.MessageApi;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.command.ConsoleCommandSender;

public class CMD extends Command {
	TextComponent unknownCommand = new TextComponent("Unknown command. Type \"/help\" for help");
	public CMD() {
		super("proxiedmessage");
	}

	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			if (ProxyServer.getInstance().getPlayer(args[0]) instanceof ProxiedPlayer) {
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
				int arrayLength = args.length;
				String text = "";
				for (int i = 0; i < arrayLength; i++) {
					if (i != 0) {
						text += args[i].replaceAll("(&([a-r0-9]))", "\u00A7$2") + " ";
					}
				}
				String[] message = text.split("\\|");;
				TextComponent finalMSG;
				for (int i = 0; message.length > i; i++) {
					finalMSG = new TextComponent(ChatColor.WHITE + message[i]);
					target.sendMessage(finalMSG);
				}
			}
		} else {
			sender.sendMessage(unknownCommand);
		}
	}
}
