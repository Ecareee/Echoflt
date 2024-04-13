package com.ecaree.echoflt.fabric;

import com.ecaree.echoflt.Echoflt;
import net.fabricmc.api.ModInitializer;

public class EchofltFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Echoflt.init();
    }
}