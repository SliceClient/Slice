package com.sliceclient.client.module.impl.combat;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.event.impl.UpdateEvent;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.util.impl.networking.PacketUtil;

import net.minecraft.network.play.client.C03PacketPlayer;

@ModuleData(name = "Regeneration", category = ModuleCategory.COMBAT)
public class Regen extends Module {

    @Subscribe
    public void onUpdate(UpdateEvent event) {
        if (mc.thePlayer.isCollidedVertically && mc.thePlayer.getHealth() < mc.thePlayer.getHealth() - 3) {
            for (int i = 0; i < 20; ++i) {
                PacketUtil.sendPacketNoEvent(new C03PacketPlayer(true));
            }
        }
    }

}
