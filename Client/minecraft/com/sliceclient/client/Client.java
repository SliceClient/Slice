package com.sliceclient.client;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.event.impl.KeyboardEvent;
import com.sliceclient.client.file.FileManager;
import com.sliceclient.client.manager.impl.ModuleManager;
import com.sliceclient.client.manager.impl.PropertyManager;
import com.sliceclient.client.module.Module;

public enum Client {
    INSTANCE;

    private final String clientName = "Slice";
    private final String clientVersion = "3";
    private PropertyManager propertyManager;
    private ModuleManager moduleManager;
    private EventBus eventBus;
    private FileManager fileManager;

    /**
     * Initializes this {@code Client}
     */
    public void initialize() {
        eventBus = new EventBus(clientName);
        propertyManager = new PropertyManager();
        moduleManager = new ModuleManager();
        fileManager = new FileManager();
        eventBus.register(this);
    }

    @Subscribe
    public void onKeyboardClick(KeyboardEvent event) {
        for (Module module : moduleManager.getList()) {
            if (module.getKeyBind() != 0 && event.getKey() == module.getKeyBind())
                module.toggle();
        }
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public PropertyManager getPropertyManager() {
        return propertyManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
