package com.kodehawa.ce.module.classes;

import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet18Animation;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.util.Vector3D;

/**
 * Test class, mostly used when I need to test something for add it or create a new module
 * The content of onEnableModule, onDisableModule or tick gets deleted before push a new
 * commit on GitHub. As obvious it extends {@link CheatingEssentialsModule}, due to it means
 * to be taked for the GUI's as a module.
 */
public class Test extends CheatingEssentialsModule {
	
	float timePassed = 0;
	
	public Test() {
		super("Test Class", "", EnumGuiCategory.UTILS, true);
		super.setTick(true);
		super.setRender(true);
	}
 
	int tick = 0;
	
	@Override
	public void onEnableModule(){}
	
	@Override
    public void onDisableModule(){}
    
	@Override
    public void tick(){}


	@Override
    public void onRenderInModule(){}
}