package com.Zoko061602.MoreSmileyClouds;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

public class CloudDefinitions {

	public static void addClouds() {
		new SmileyCloud("Hypnotized","Hypno").setLeftHand(new ItemStack(Items.CLOCK)).register();
		new SmileyCloud("Zoko").setBlock(new ItemStack(Blocks.CONCRETE, 1, EnumDyeColor.CYAN.ordinal()), 0F).register();

	}

}
