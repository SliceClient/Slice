package com.sliceclient.client.module.impl.misc;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.event.impl.UpdateEvent;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;

import net.minecraft.entity.player.EntityPlayer;

@ModuleData(name = "Anti Bot", category = ModuleCategory.MISC)
public class AntiBot extends Module {

    @Subscribe
    public void onUpdate(UpdateEvent event) {
        for (EntityPlayer entityPlayer : mc.theWorld.playerEntities) {
            if (!Float.isNaN(entityPlayer.getHealth())) {
                entityPlayer.setValid(false);
            }
        }
    }

    @Override
    public void onDisable() {
        for (EntityPlayer entityPlayer : mc.theWorld.playerEntities) {
            entityPlayer.setValid(true);
        }
    }
}
