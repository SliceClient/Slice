package com.sliceclient.client.event.impl;

import com.sliceclient.client.event.Event;

public class BlockRenderEvent extends Event {

    private double x, y, z;

    public BlockRenderEvent(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
