package com.sliceclient.client.property.impl;

import com.sliceclient.client.property.Property;

public final class BooleanProperty<T1> extends Property<T1, Boolean> {

    public BooleanProperty(String name, T1 owner, Boolean value) {
        super(name, owner, value);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getValue() == obj || super.equals(obj);
    }
}
