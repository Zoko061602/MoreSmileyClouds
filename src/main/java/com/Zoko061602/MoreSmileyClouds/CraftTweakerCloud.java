package com.Zoko061602.MoreSmileyClouds;

import java.util.HashMap;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.moresmileyclouds.SmileyCloud")
@ZenRegister
public class CraftTweakerCloud {

	private static HashMap<String,SmileyCloud> clouds = new HashMap<>();

	@ZenMethod
	public static void addCloud(String key) {
		clouds.put(key, new SmileyCloud(key));
	}

	@ZenMethod
	public static void addLeftItem(String key, IItemStack stack) {
		if(clouds.containsKey(key)) {
			clouds.get(key).setLeftHand(toStack(stack));
		}
	}

	@ZenMethod
	public static void addRightItem(String key, IItemStack stack) {
		if(clouds.containsKey(key)) {
			clouds.get(key).setRightHand(toStack(stack));
		}
	}


	@ZenMethod
	public static void addTopBlock(String key, IItemStack stack) {
		if(clouds.containsKey(key)) {
			clouds.get(key).setBlock(toStack(stack),0);
		}
	}

	@ZenMethod
	public static void registerCloud(String key) {
		if(clouds.containsKey(key)) {
			CrafttweakerCompat.lateAdditions.add(new Add(clouds.get(key)));
		 }


	}

    public static ItemStack toStack(IItemStack iStack) {
      if(iStack == null)return ItemStack.EMPTY;
        Object internal = iStack.getInternal();
        return (ItemStack)internal;
    }

   private static class Add implements IAction {

	   SmileyCloud cloud;

	   public Add(SmileyCloud c){
		   this.cloud = c;
	   }

	   @Override
	   public void apply(){
		 cloud.register();
	   }

	   @Override
	   public String describe() {
		   if(cloud.getTriggerNames().length > 0)
			   return "Added Cloud"+ cloud.getTriggerNames()[0];
		   else return "Added Useless Cloud :(";
	   }

  }

}
