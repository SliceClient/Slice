package com.sliceclient.client.module.impl.render;

import com.google.common.collect.Lists;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.util.impl.render.helper.BlockEntry;

import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

@ModuleData(name = "OreESP", category = ModuleCategory.RENDER)
public class OreESP extends Module {

    public List<BlockEntry> ores = Arrays.asList(
            createBlockEntry("minecraft:diamond_ore", 0x03f8fc),
            createBlockEntry("minecraft:gold_ore", 0xfcad03),
            createBlockEntry("minecraft:iron_ore", 0xb0b0b0)
    );

    @Override
    public void setup() {

    }

    public static int getID(String name) {
        return Item.getIdFromItem(Item.getByNameOrId(name));
    }

    public static BlockEntry createBlockEntry(String name, int color) {
        return new BlockEntry(getID(name), color);
    }

}
