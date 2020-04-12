package com.Zoko061602.MoreSmileyClouds;

import java.util.LinkedList;
import java.util.List;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CrafttweakerCompat {

    public static final List<IAction> lateAdditions = new LinkedList<>();

    public static void postInit(FMLPostInitializationEvent e){

      try{
    	  for(IAction action:lateAdditions)
          CraftTweakerAPI.apply(action);
        }

        catch(Exception ex) {
            ex.printStackTrace();
            CraftTweakerAPI.logError("Error while applying actions", ex);
        }
    }
}
