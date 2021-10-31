package com.sliceclient.client.manager.impl;

import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;
import java.util.List;

import com.sliceclient.client.manager.Manager;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.module.impl.combat.AutoPot;
import com.sliceclient.client.module.impl.combat.KillAura;
import com.sliceclient.client.module.impl.combat.Regen;
import com.sliceclient.client.module.impl.combat.Velocity;
import com.sliceclient.client.module.impl.exploit.Disabler;
import com.sliceclient.client.module.impl.exploit.InfiniteDurability;
import com.sliceclient.client.module.impl.exploit.PlayerLagger;
import com.sliceclient.client.module.impl.hidden.ClickGUI;
import com.sliceclient.client.module.impl.misc.AntiBot;
import com.sliceclient.client.module.impl.misc.NameProtect;
import com.sliceclient.client.module.impl.misc.NoFall;
import com.sliceclient.client.module.impl.movement.*;
import com.sliceclient.client.module.impl.player.Breaker;
import com.sliceclient.client.module.impl.player.Derp;
import com.sliceclient.client.module.impl.player.FastInteract;
import com.sliceclient.client.module.impl.player.Zoot;
import com.sliceclient.client.module.impl.render.Hud;
import com.sliceclient.client.module.impl.render.Tags;
import com.sliceclient.client.util.impl.render.CustomFontRenderer;

public class ModuleManager extends Manager<Module> {

    public ModuleManager() {
        super(new ArrayList<>());
    }

    /**
     * Sorts this manager by it's list's objects name string length
     * @param fontRenderer - The {@code FontRenderer} used for obtaining the length
     */
    public void sort(FontRenderer fontRenderer) {
        getList().sort((a, b) -> {
            int first = fontRenderer.getStringWidth(a.getModuleData().name());
            int second = fontRenderer.getStringWidth(b.getModuleData().name());
            return second - first;
        });
    }
    /**
     * Sorts this manager by it's list's objects name string length
     * @param customFontRenderer - The {@code CustomFontRenderer} used for obtaining the length
     */
    public void sort(CustomFontRenderer customFontRenderer) {
        getList().sort((a, b) -> {
            int first = (int) customFontRenderer.getWidth(a.getModuleData().name());
            int second = (int) customFontRenderer.getWidth(b.getModuleData().name());
            return second - first;
        });
    }

    @Override
    public void onCreated() {
        // COMBAT
        add(new AutoPot());
        add(new Regen());
        add(new KillAura());
        add(new Velocity());


        // MOVEMENT
        add(new NoSlow());
        add(new Flight());
        add(new LongJump());
        add(new Speed());
        add(new Sprint());
        add(new InvMove());
        add(new Step());
        add(new Jesus());
        add(new CustomSpeed());

        // PLAYER
        add(new Derp());
        add(new Breaker());
        add(new Zoot());


        // MISC
        add(new NoFall());
        add(new FastInteract());
        add(new AntiBot());
        add(new NameProtect());

        // RENDER
        add(new Hud());
        add(new Tags());

        // EXPLOIT
        add(new PlayerLagger());
        add(new InfiniteDurability());
        add(new Disabler());


        // HIDDEN
        add(new ClickGUI());
    }

    public List<Module> getAllInCategory(ModuleCategory category) {
        List<Module> list = new ArrayList<>();
        for (Module module : getList()) {
            if (module.getModuleData().category() == category) {
                list.add(module);
            }
        }
        return list;
    }

}
