package com.kodehawa.module.classes;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;

public class UtilAdvancedTooltips extends CheatingEssentialsModule {

    public UtilAdvancedTooltips( ) {
        super("Advanced Tooltips", "", "1.6.2", -1, EnumGuiCategory.UTILS, true);
    }

    @Override
    public void onEnableModule() {
        CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips = !CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips;
        CheatingEssentials.getMinecraftInstance().gameSettings.saveOptions();
    }

    @Override
    public void onDisableModule() {
        CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips = !CheatingEssentials.getMinecraftInstance().gameSettings.advancedItemTooltips;
        CheatingEssentials.getMinecraftInstance().gameSettings.saveOptions();
    }

}
