package com.ecaree.echoflt.forge;

import com.ecaree.echoflt.Echoflt;
import net.minecraftforge.fml.common.Mod;

@Mod(Echoflt.MOD_ID)
public class EchofltForge {
    public EchofltForge() {
        Echoflt.init();
    }
}