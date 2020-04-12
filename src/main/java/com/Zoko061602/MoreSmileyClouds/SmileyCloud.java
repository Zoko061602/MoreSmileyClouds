package com.Zoko061602.MoreSmileyClouds;

import java.lang.reflect.Method;

import de.ellpeck.actuallyadditions.mod.misc.cloud.ISmileyCloudEasterEgg;
import de.ellpeck.actuallyadditions.mod.misc.cloud.SmileyCloudEasterEggs;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class SmileyCloud implements ISmileyCloudEasterEgg {

	String[] triggers;
	ItemStack left,right,block = null;
	float rotation = 0;

	public SmileyCloud(String... strings) {
		this.triggers = strings;
	}

	@Override
	public String[] getTriggerNames() {
		return triggers;
	}

	@Override
	public void renderExtra(float arg0) {
		if(left != null && left.getItem() !=null) renderHoldingItem(true, left);
		if(right != null && right.getItem() !=null) renderHoldingItem(false, left);
		if(block != null && block.getItem() !=null) renderHeadBlock(Block.getBlockFromItem(block.getItem()), block.getItemDamage(), rotation);

	}

	public SmileyCloud setLeftHand(ItemStack stack) {
		if(stack.getItem() == null)
			return this;
		this.left = stack;
		return this;
	}

	public SmileyCloud setRightHand(ItemStack stack) {
		if(stack.getItem() == null)
			return this;
		this.right = stack;
		return this;
	}

	public SmileyCloud setBlock(ItemStack stack, float rotation) {
		if(stack.getItem()==null || !(stack.getItem() instanceof ItemBlock))
			return this;
		this.block = stack;
		this.rotation = rotation;
		return this;
	}

	public void register() {
		SmileyCloudEasterEggs.CLOUD_STUFF.add(this);
	}

	private static void renderHoldingItem(boolean leftHand, ItemStack stack) {
		try {
		Method md1 = SmileyCloudEasterEggs.class.getDeclaredMethod("renderHoldingItem", boolean.class, ItemStack.class);
		md1.setAccessible(true);
		md1.invoke(null, leftHand, stack);
		}

		catch(Exception ex) {}

	}

	private static void renderHeadBlock(Block block, int meta, float rotation) {
		try {
		Method md2 = SmileyCloudEasterEggs.class.getDeclaredMethod("renderHeadBlock", Block.class, int.class, float.class);
		md2.setAccessible(true);
		md2.invoke(null, block, meta, rotation);
		}

		catch(Exception ex) {}

	}

}
