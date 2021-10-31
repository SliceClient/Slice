package com.sliceclient.client.module.impl.render;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.Client;
import com.sliceclient.client.event.impl.RenderHudEvent;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.util.impl.render.ColorUtil;
import com.sliceclient.client.util.impl.render.CustomFontRenderer;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;
import java.io.IOException;

@ModuleData(name = "HUD", description = "Renders the game HUD", defaultKeyBind = 0, category = ModuleCategory.RENDER)
public final class Hud extends Module {

    private CustomFontRenderer mainFont;

    @Override
    public void setup() {
        try {
            mainFont = new CustomFontRenderer(
                    Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Font.ttf"))
                            .deriveFont(Font.TRUETYPE_FONT, 20F));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        PropertyManager propertyManager = Client.INSTANCE.getPropertyManager();
    }
    @Subscribe
    public void renderHUD(RenderHudEvent event) {
        int y = 2;
        Client.INSTANCE.getModuleManager().sort(mc.fontRendererObj);
        GlStateManager.pushMatrix();
        GlStateManager.translate(2,	 2, 200);
        GlStateManager.scale(1.5, 1.5, 1);
        //mc.standardGalacticFontRenderer.drawString("Slice", 3, 3, ColorUtil.getRainbow(6000, y * -24));
        //mc.standardGalacticFontRenderer.drawString("lice", 6, 3, ColorUtil.toInt(new Color(255, 255, 255)));
        mc.fontRendererObj.drawString("Slice", 3, 3, ColorUtil.getRainbow(6000, y * -24));
        mc.fontRendererObj.drawString("  lice", 1, 3, ColorUtil.toInt(new Color(255, 255, 255)));
        //mc.fontRendererObj.drawStringWithShadow("�cS�flice", 3, 3, -1);
        GlStateManager.popMatrix();
        
        ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        for (Module module : Client.INSTANCE.getModuleManager().getList()) {
            if (module.isToggled()) {
                float xPos = scaledResolution.getScaledWidth() - mc.fontRendererObj.getStringWidth(module.getModuleData().name()) - 2;
                mc.fontRendererObj.drawStringWithShadow(module.getModuleData().name(), xPos, y, ColorUtil.getRainbow(6000, y * -24));
                //mc.ingameGUI.drawRect(left, top, right, bottom, color);
                y += 11;
            }
        }
    }

}
