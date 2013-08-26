package com.kodehawa.ce.forge.common;

import java.util.logging.Level;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import org.apache.commons.lang3.StringUtils;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.ce.forge.packet.PacketHandler;
import com.kodehawa.ce.forge.tick.TickHandler;
import com.kodehawa.core.Strings;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.handlers.ModuleManager;
import com.kodehawa.module.loader.BaseLoader;
import com.kodehawa.playerrelations.Enemy;
import com.kodehawa.playerrelations.Friend;
import com.kodehawa.util.FileManager;
import com.reeszrbteam.ce.util.BlockFilter;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * These little lines of this are enough to init all the mod <3
 * Forge CE version main class, with all of my love for Optifine users. Me included :)
 * @author Kodehawa
 */

@Mod(modid="Cheating-Essentials", name="Cheating Essentials", version="3.2.1", useMetadata=true) //Gets mod data
@NetworkMod(clientSideRequired=true, serverSideRequired=false) 
@SideOnly(Side.CLIENT)
//I don't like this to be loaded in a server envirioment. It works in servers, but it can't be installed in servers.

public class Loader {
	
	public CheatingEssentials ce;
    public static TickHandler tickHandler = new TickHandler();
    private static final int majorVersion = 3;
    private static final int minorVersion = 2;
    private static final int revisionVersion = 1;
	
    @Instance("Cheating-Essentials")
    public static Loader instance;
   
    @SidedProxy(clientSide="com.kodehawa.ce.forge.common.ClientProxy", serverSide="com.kodehawa.ce.forge.common.CommonProxy")
    public static CommonProxy proxyHandler;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	FMLLog.info("Cheating Essentials", "Attempting early Cheating Essentials initialization.");
    	ce = new CheatingEssentials( );
    	FMLLog.log("Cheating Essentials", Level.INFO, "Cheating Essentials Forge Loader: " + StringUtils.defaultString(Loader.class.getName()) + " in Minecraft Forge " + ForgeVersion.getVersion());
    	FMLLog.log("Cheating Essentials", Level.INFO, "Loading instances...");
        initializeSingletons();
    	TickRegistry.registerScheduledTickHandler(tickHandler, Side.CLIENT);
    	FMLLog.log("Cheating Essentials", Level.INFO, "Started Cheating Essentials "+getForgeCEVersion()+" in Minecraft 1.6.2 with Minecraft Forge " + ForgeVersion.getVersion());
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxyHandler.registerRenderers();
        MinecraftForge.EVENT_BUS.register(this);
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

	@ForgeSubscribe
	public void onRenderWorldLastEvent(RenderWorldLastEvent e){
		for(CheatingEssentialsModule m : ModuleManager.getInstance().modules){
			m.onRenderInModule();
		}
	}
	
	void initializeSingletons(){
        ModuleManager.getInstance();
        BaseLoader.getInstance();
        Enemy.getInstance();
        Friend.getInstance();
        FileManager.getInstance();
    }
	
	public static String getForgeCEVersion(){
		return majorVersion+"."+minorVersion+"."+revisionVersion;
	}
}