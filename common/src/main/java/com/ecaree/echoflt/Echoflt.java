package com.ecaree.echoflt;

import dev.architectury.event.events.common.TickEvent;

public class Echoflt {
    public static final String MOD_ID = "echoflt";
    public static void init() {
        TickEvent.SERVER_LEVEL_POST.register(ItemHandler::setCustomName);
    }
}