package net.cheatingessentials.gui.reeszrbteam.window;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.gui.reeszrbteam.element.YAWWindow;

public class WindowRender extends YAWWindow
{
	public WindowRender()
	{
		super("Render", 278, 14);
	}

	public YAWWindow init()
	{
		for(Module mod: APIModule.instance().modules)
		{
			if(mod.getCategory() == Category.RENDER)
			{
				addButton(mod);
			}
		}
		return this;
	}
}
