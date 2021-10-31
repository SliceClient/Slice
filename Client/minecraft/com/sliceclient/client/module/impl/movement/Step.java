package com.sliceclient.client.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.Client;
import com.sliceclient.client.event.impl.EntityStepEvent;
import com.sliceclient.client.manager.impl.PropertyManager;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.property.impl.DoubleProperty;
import com.sliceclient.client.property.impl.EnumProperty;
import com.sliceclient.client.property.impl.interfaces.INameable;
import com.sliceclient.client.util.impl.networking.PacketUtil;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.C03PacketPlayer;

@ModuleData(name = "Step", description = "Changes your step height", category = ModuleCategory.MOVEMENT)
public class Step extends Module {

    @Override
    public void setup() {
        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
        propertyManager.add(new DoubleProperty<>("Height", this, 1, 1, 5, true));
        propertyManager.add(new EnumProperty<>("Mode", this, EnumMode.values()));
    }

    @Subscribe
    public void onEntityStep(EntityStepEvent event) {
        if (event.getEntity() instanceof EntityPlayerSP) {
            float stepHeight = ((Double) Client.INSTANCE.getPropertyManager().getProperty(this, "Height").getValue()).floatValue();
            EnumMode mode = (EnumMode) Client.INSTANCE.getPropertyManager().getProperty(this, "Mode").getValue();

            switch (mode) {
                case NCP:
                    if (event.isPre()) {
                        event.setHeight(1.0F);
                    }
                    else {
                        float realHeight = event.getHeight();
                        if (realHeight > .87F) {
                            float[] stepValues = new float[]{0.42F, 0.75F};
                            for (float value : stepValues) {
                                PacketUtil.sendPacketNoEvent(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + value, mc.thePlayer.posZ, false));
                            }
                        }
                    }
                    break;
                case VANILLA:
                    event.setHeight(stepHeight);
                    break;
                case GWEN:
                    if (event.isPre()) {
                        event.setHeight(Math.min(stepHeight, 1.5F));
                    }
                    else {
                        float realHeight = event.getHeight();
                        if (realHeight > 1.0F) {
                            float[] stepValues = new float[]{0.42F, 0.75F, 1.09F};
                            for (float value : stepValues) {
                                PacketUtil.sendPacketNoEvent(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + value, mc.thePlayer.posZ, false));
                            }
                        }
                        else if (realHeight > 0.87F) {
                            float[] stepValues = new float[]{0.42F, 0.75F};
                            for (float value : stepValues) {
                                PacketUtil.sendPacketNoEvent(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + value, mc.thePlayer.posZ, false));
                            }
                        }
                    }
                    break;
            }

        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.thePlayer.stepHeight = 0.6F;
    }

    enum EnumMode implements INameable {
        NCP {
            public boolean shouldOverrideName() {
                return false;
            }
        }, VANILLA, GWEN
    }

}
