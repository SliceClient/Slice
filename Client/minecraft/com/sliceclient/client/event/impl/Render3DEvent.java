package com.sliceclient.client.event.impl;

import com.sliceclient.client.event.Event;

public class Render3DEvent extends Event {
    private final float ticks;

    public Render3DEvent(float ticks) {
        this.ticks = ticks;
    }

    public float getPartialTicks() {
        return ticks;
    }
}
