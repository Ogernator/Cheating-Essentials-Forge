package net.cheatingessentials.gui.reeszrbteam.element;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.gui.reeszrbteam.YouAlwaysWinClickGui;
import net.cheatingessentials.util.RZUtils;
import net.minecraft.client.Minecraft;

public class YAWButton {
	private YAWWindow window;
	private Module mod;
	private int xPos;
	private int yPos;
	
	public boolean isOverButton;
	
	public YAWButton(YAWWindow window, Module mod, int xPos, int yPos) {
		this.window = window;
		this.mod = mod;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void draw() {
		RZUtils.drawGradientBorderedRect(getX() + 0.5 + window.dragX, getY() + 0.5 + window.dragY, getX() + 85.5 + window.dragX, getY() + 12 + window.dragY, 0.5F, 0xFF444444, !mod.isActive() ? 0xFF777777 : 0xFF555555, !mod.isActive() ? 0xFF555555 : 0xFF666666);
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(mod.getModuleName(), getX() + window.dragX - (getX() + 85 + this.window.dragX) - Minecraft.getMinecraft().fontRenderer.getStringWidth(this.mod.getModuleName()) / 2 + 127 + this.getX() + this.window.dragX, this.getY() + 2 + this.window.dragY, this.mod.isActive() ? 0x55FFFF : 0xBBBBBB);    
	}
	
	public void mouseClicked(int x, int y, int button) {
		if(x >= getX() + window.dragX && y >= getY() + window.dragY && x <= getX() + 85.5 + window.dragX && y <= getY() + 9 + window.dragY && button == 0 && window.isOpen() && window.isExtended()) {
			YouAlwaysWinClickGui.sendPanelToFront(window);
			Minecraft.getMinecraft().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			mod.toggle();
		}
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}
}
