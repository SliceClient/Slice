package com.sliceclient.client.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.Client;
import com.sliceclient.client.event.impl.UpdateEvent;
import com.sliceclient.client.manager.impl.PropertyManager;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.property.impl.BooleanProperty;

/**
 * @author Auth
 */

@ModuleData(name = "Sprint", description = "Makes you automatically sprint", category = ModuleCategory.MOVEMENT, defaultKeyBind = 0)
public class Sprint extends Module {

    @Override
    public void setup() {
        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
        propertyManager.add(new BooleanProperty<>("Omnidirectional", this, false));
    }

    @Subscribe
    public void onUpdate(UpdateEvent event) {
        mc.thePlayer.setSprinting((Boolean) Client.INSTANCE.getPropertyManager().getProperty(this, "Omnidirectional").getValue() ? mc.thePlayer.isMoving() : mc.gameSettings.keyBindForward.getIsKeyPressed() && !mc.thePlayer.isCollidedHorizontally);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.getIsKeyPressed());
    }
}
