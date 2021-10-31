package com.sliceclient.client.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.sliceclient.client.manager.Manager;
import com.sliceclient.client.property.Property;

public class PropertyManager extends Manager<Property<?, ?>> {

    public PropertyManager() {
        super(new ArrayList<>());
    }

    @Override
    public void onCreated() {

    }

    public Property<?, ?> getProperty(Object object, String name) {
        for (Property<?, ?> property : getList()) {
            if (property.getOwner() == object && property.getName().equalsIgnoreCase(name)) {
                return property;
            }
        }
        return null;
    }


    public List<Property<?, ?>> getSettingsByMod(Object owner) {
        List<Property<?, ?>> list = new ArrayList<>();
        for (Property<?, ?> property : getList()) {
            if (property.getOwner() == owner) {
                list.add(property);
            }
        }
        return list;
    }

}
