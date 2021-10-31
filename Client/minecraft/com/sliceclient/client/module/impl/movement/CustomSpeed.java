package com.sliceclient.client.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.Client;
import com.sliceclient.client.event.impl.MovementEvent;
import com.sliceclient.client.event.impl.UpdateEvent;
import com.sliceclient.client.manager.impl.PropertyManager;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.property.impl.BooleanProperty;
import com.sliceclient.client.property.impl.DoubleProperty;
import com.sliceclient.client.property.impl.StringProperty;
import com.sliceclient.client.util.impl.movement.MotionUtils;

/**
 * @author Auth
 */

@ModuleData(name = "Custom Speed", description = "A More Customizable Version Of Speed", category = ModuleCategory.MOVEMENT, defaultKeyBind = 0)
public class CustomSpeed extends Module {
	
	private double airSpeed;

    @Override
    public void setup() {
        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
        propertyManager.add(new DoubleProperty<>("MotionY", this, 0.376, 0, 1));
        propertyManager.add(new DoubleProperty<>("Ground Speed", this, 1.61, 0.1, 10));
        propertyManager.add(new DoubleProperty<>("Up Multiplier", this, 1.03, 0, 5));
        propertyManager.add(new DoubleProperty<>("Down Multiplier", this,  1, 0, 5));
        propertyManager.add(new DoubleProperty<>("Friction", this, 0.99, 0.2, 1));
    }

    @Subscribe
    public void onUpdate(MovementEvent event) {
    	PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
    	double y = mc.thePlayer.motionY;
		if (mc.thePlayer.isMovingOnGround()) {
			y = (Double) propertyManager.getProperty(this, "MotionY").getValue();
			airSpeed = (Double) propertyManager.getProperty(this, "Ground Speed").getValue();
		}
		if (y > 0.0) {
			y *= (Double) propertyManager.getProperty(this, "Up Multiplier").getValue();
		} else {
			y *= (Double) propertyManager.getProperty(this, "Down Multiplier").getValue();
		}

		event.setMotionY(mc.thePlayer.motionY = y);
		airSpeed *= (Double) propertyManager.getProperty(this, "Friction").getValue();
		airSpeed = Math.max(airSpeed, MotionUtils.getBaseSpeed());
		MotionUtils.setMotion(event, (float) airSpeed);
	};
    

    @Override
    public void onDisable() {
        super.onDisable();
        mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.getIsKeyPressed());
    }
}
