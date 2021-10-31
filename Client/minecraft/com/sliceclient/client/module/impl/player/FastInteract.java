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

import net.minecraft.network.Packet;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

@ModuleData(name = "Fast Interact", category = ModuleCategory.PLAYER)
public class FastInteract extends Module {

    @Override
    public void setup() {
        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
        propertyManager.add(new BooleanProperty<>("Fast Place", this, true));
        propertyManager.add(new DoubleProperty<>("Haste Level", this, 1, -1, 3, true));
    }

    @Subscribe
    public void handlePlayerUpdate(UpdateEvent event) {
        if (event.isPre()) {
            PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
            Double hasteLevel = (Double) propertyManager.getProperty(this, "Haste Level").getValue();
            Boolean fastPlace = (Boolean) propertyManager.getProperty(this, "Fast Place").getValue();

            if (fastPlace) {
                mc.rightClickDelayTimer = 0;
            }

            if (hasteLevel > 0) {
                mc.thePlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 0, hasteLevel.intValue()));
            }
        }
    }

}
