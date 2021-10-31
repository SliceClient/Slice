package com.sliceclient.client.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.Client;
import com.sliceclient.client.event.impl.UpdateEvent;
import com.sliceclient.client.manager.impl.PropertyManager;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.property.impl.StringProperty;
import com.sliceclient.client.util.impl.networking.PacketUtil;

import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author Auth
 */

@ModuleData(name = "No Slow", description = "Removes the slowdown from items", category = ModuleCategory.MOVEMENT, defaultKeyBind = 0)
public class NoSlow extends Module {

    @Override
    public void setup() {
        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
        propertyManager.add(new StringProperty<>("Mode", this, "Vanilla", "NCP"));
    }

    @Subscribe
    public void onUpdate(UpdateEvent event) {
        switch ((String) Client.INSTANCE.getPropertyManager().getProperty(this, "Mode").getValue()) {
            case "NCP":
                if (mc.thePlayer.isBlocking()) {
                    if (event.isPre()) {
                        PacketUtil.sendPacketNoEvent(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-1, -6, -1), EnumFacing.DOWN));
                    } else {
                        mc.thePlayer.setItemInUse(mc.thePlayer.getCurrentEquippedItem(), RandomUtils.nextInt(1, Integer.MAX_VALUE));
                        mc.playerController.sendUseItem(mc.thePlayer, mc.theWorld, mc.thePlayer.getCurrentEquippedItem());
                    }
                }
                break;
        }
    }
}
