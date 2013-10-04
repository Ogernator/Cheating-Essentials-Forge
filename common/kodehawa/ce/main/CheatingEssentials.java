package common.kodehawa.ce.main;

import java.util.Arrays;
import java.util.logging.Level;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

import common.kodehawa.ce.commands.*;
import common.kodehawa.ce.logger.DynamicLogger;
//import common.kodehawa.ce.mevents.EventManager;
import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.ce.tick.TickHandler;
import common.kodehawa.ce.util.ForgeEvents;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid="Cheating-Essentials", name="Cheating Essentials Reloaded", version="4.0.0")
public class CheatingEssentials {

	@Instance("Cheating-Essentials")
	public static CheatingEssentials main;
	TickHandler tickhandler = new TickHandler();

	
	@EventHandler
	public void preInitialization(FMLPreInitializationEvent e){
		DynamicLogger.instance().writeLog("Loading Cheating Essentials "+modVersion+" in " + MinecraftForge.getBrandingVersion(), Level.INFO);
		/* Cheating Essentials MD START */
		ModMetadata mMetadata = e.getModMetadata();
		mMetadata.credits = "Kodehawa";
		mMetadata.description = "The most complete Forge cheating mod, with a lot of options and configurable cheats!";
		mMetadata.autogenerated = false;
		mMetadata.version = this.modVersion;
		mMetadata.authorList = Arrays.asList(new String[] { "Kodehawa" });
		mMetadata.url = "http://www.minecraftforum.net/topic/1846289-";
		/* Cheating Essentials MD FINISH */
	}
	
	@EventHandler
	public void initialization(FMLInitializationEvent e){
		TickRegistry.registerScheduledTickHandler(tickhandler, Side.CLIENT);
		loadClasses();
	}
	
	@EventHandler
	public void postInitialization(FMLPostInitializationEvent e){
		DynamicLogger.instance().writeLog("Cheating Essentials v4 succefully started in Minecraft 1.6.4", Level.INFO);
	}
	
	@EventHandler
	public void serverStarted(FMLServerStartedEvent ev){
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager icommand = server.getCommandManager();
		ServerCommandManager command = ((ServerCommandManager) icommand);
		command.registerCommand(new CommandModuleList());
		
		MinecraftForge.EVENT_BUS.register(new ForgeEvents());
	}

	
	void loadClasses(){
		ModuleManager.instance();
		//EventManager.instance();
	}
	
	static String majorVersion = "4";
	static String minorVersion = "0";
	static String revision = "0";
	static String status = "Pre-Alpha";
	public final String modVersion = majorVersion+"."+minorVersion+"."+revision+" "+status;
}
