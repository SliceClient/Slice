package com.sliceclient.client.event.impl;

import com.sliceclient.client.event.Event;

public class KeyboardEvent extends Event {

    private final int key;

    public KeyboardEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
