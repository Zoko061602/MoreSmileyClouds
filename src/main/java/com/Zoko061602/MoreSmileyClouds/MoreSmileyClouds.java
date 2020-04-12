package com.Zoko061602.MoreSmileyClouds;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid= MoreSmileyClouds.modID, name= MoreSmileyClouds.modName, version= MoreSmileyClouds.version, dependencies= MoreSmileyClouds.dependencies)
public class MoreSmileyClouds {

	public static final String modID = "moresmileyclouds";
	public static final String modName = "MoreSmileyClouds";
	public static final String version = "1.0";
	public static final String dependencies = "required-after:actuallyadditions;"
	                                        + "after:crafttweaker";

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		CloudDefinitions.addClouds();
		CrafttweakerCompat.postInit(e);
	}

}
