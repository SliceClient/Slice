package com.sliceclient.client.module.impl.hidden;

import org.lwjgl.input.Keyboard;

import com.sliceclient.client.gui.click.ModGUI;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;

@ModuleData(name = "ClickGUI", description = "Click UI", category = ModuleCategory.HIDE_ME, defaultKeyBind = Keyboard.KEY_RSHIFT)
public class ClickGUI extends Module {

    @Override
    public void setup() {}

    @Override
    public void onEnable() {
        mc.displayGuiScreen(ModGUI.instance());
        toggle();
        super.onEnable();
    }
}
