package com.sliceclient.client.module.impl.combat;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.event.impl.PacketEvent;
import com.sliceclient.client.event.impl.enums.PacketDirection;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;

import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;

@ModuleData(name = "Velocity", description = "Cancels all velocity packets", category = ModuleCategory.COMBAT)
public class Velocity extends Module {

    @Override
    public void setup() {

    }

    @Subscribe
    public void onPacket(PacketEvent event) {
        if (event.getPacketDirection() == PacketDirection.INBOUND)
            event.setCancelled(event.getPacket() instanceof S12PacketEntityVelocity || event.getPacket() instanceof S27PacketExplosion);
    }
}