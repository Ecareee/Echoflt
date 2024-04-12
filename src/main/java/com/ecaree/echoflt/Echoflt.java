package com.ecaree.echoflt;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Echoflt.MOD_ID)
public class Echoflt {
    public static final String MOD_ID = "echoflt";
    public Echoflt() {
        MinecraftForge.EVENT_BUS.register(new ItemHandler());
    }
}