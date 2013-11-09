package common.kodehawa.ce.commands;

import java.io.File;

import common.kodehawa.ce.config.AGCEConfigurationSList;
import common.kodehawa.ce.config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandAddEnemy extends CommandBase {

	@Override
	public String getCommandName() {
		return "ceenemy";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/ceenemy add <enemy name> or delete <enemy name>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if(astring[0].equalsIgnoreCase("add")){
			for(String s : ConfigManager.instance().enemies){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added enemy: "+astring[1]));
				ConfigManager.instance().enemies.add(astring[1]); 
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt"), ConfigManager.instance().enemies); break;
			}
		}
		if(astring[0].equalsIgnoreCase("delete")){
			for(String s : ConfigManager.instance().enemies){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Remove enemy: "+astring[1]));
				ConfigManager.instance().enemies.remove(astring[1]);
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt"), ConfigManager.instance().enemies); break;
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) 
	{
		return true;
	}
}
