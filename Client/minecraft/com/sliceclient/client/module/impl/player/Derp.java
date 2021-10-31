package com.sliceclient.client.module.impl.player;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.Client;
import com.sliceclient.client.event.impl.UpdateEvent;
import com.sliceclient.client.manager.impl.PropertyManager;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.property.impl.BooleanProperty;
import com.sliceclient.client.property.impl.DoubleProperty;

import org.lwjgl.input.Keyboard;

@ModuleData(name = "Derp", description = "Makes you look retarded", defaultKeyBind = Keyboard.KEY_N, category = ModuleCategory.PLAYER)
public class Derp extends Module {

    private float rotationYaw;

    @Override
    public void setup() {
        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
        propertyManager.add(new DoubleProperty<>("Yaw Speed", this, 20, 10, 40));
        propertyManager.add(new BooleanProperty<>("F5 Rotations", this, true));
    }

    @Subscribe
    public void onUpdate(UpdateEvent event) {
        if (mc.objectMouseOver != null && mc.thePlayer.isSwingInProgress)
            return;
        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();

        float speed = ((Number) propertyManager.getProperty(this, "Yaw Speed").getValue()).floatValue();

        rotationYaw -= speed;

        if (rotationYaw < -180) {
            rotationYaw = 180;
        }

        event.setRotationYaw(rotationYaw);
        event.setRotationPitch(180.0F);

        boolean rotations = (Boolean) propertyManager.getProperty(this, "F5 Rotations").getValue();

        if (rotations) {
            mc.thePlayer.renderYawOffset = rotationYaw;
            mc.thePlayer.renderYawHead = rotationYaw;
            mc.thePlayer.renderPitchHead = 180.0F;
        }



    }

}
