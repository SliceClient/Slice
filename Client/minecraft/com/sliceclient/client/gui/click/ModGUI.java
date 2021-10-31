package com.sliceclient.client.gui.click;

import com.google.common.collect.Lists;
import com.sliceclient.client.Client;
import com.sliceclient.client.draw.DrawSmoothRect;
import com.sliceclient.client.gui.click.element.DGUICategoryElement;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.enums.ModuleCategory;
import com.sliceclient.client.util.impl.render.ColorUtil;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;
import java.util.Collection;

public class ModGUI extends GuiScreen {

	private static final ModGUI INSTANCE = new ModGUI();
	public Module selMod;
	private final Collection<DGUICategoryElement> elements = Lists.newArrayList();

	private int index;
	public ModuleCategory selCat;
	public static final Color BACKGROUND_COLOR = new Color(29, 29, 29);

	public ModGUI() {
		for (ModuleCategory cat : ModuleCategory.values()) {
			this.elements.add(new DGUICategoryElement(cat, cat.getName()));
		}
	}

	public static ModGUI instance() {
		return INSTANCE;
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		this.elements.forEach(s -> {
			s.kt(keyCode);
		});
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution scl = new ScaledResolution(mc, width, height);
		GlStateManager.pushMatrix();
		float x = width / 7f;
		float y = height / 24f;
		float x2 = width / 7 + 360;
		float y2 = height / 24 + (75 - 11) + (31 * ModuleCategory.values().length);
		//DrawSmoothRect.drawRoundedRect(x, y, x2, y2, 100, BACKGROUND_COLOR.brighter().getRGB());
		//DrawSmoothRect.drawRoundedRect(x, y, x2, y2, 100);
		DrawSmoothRect.drawRoundedRect(x, y, x2, y2 + 15, 10, BACKGROUND_COLOR.getRGB());
		//ModGUI.drawRect(new Rect(x, y, x2, y2), BACKGROUND_COLOR.getRGB());
		//ModGUI.drawRect(new Rect(x2 - 2, y, x2, y2), BACKGROUND_COLOR.brighter().getRGB());
		//ModGUI.drawRect(new Rect(x + 73, y, x + 75, y2), BACKGROUND_COLOR.brighter().getRGB());
		//ModGUI.drawRect(new Rect(x, y, x2, y + 2), BACKGROUND_COLOR.brighter().getRGB());
		//ModGUI.drawRect(new Rect(x, y, x + 2, y2), BACKGROUND_COLOR.brighter().getRGB());
		//ModGUI.drawRect(new Rect(x2 - 2, y, x2, y2), BACKGROUND_COLOR.getRGB());
		//ModGUI.drawRect(new Rect(x + 73, y, x + 75, y2), BACKGROUND_COLOR.brighter().getRGB());
		//ModGUI.drawRect(new Rect(x, y, x2, y + 2), BACKGROUND_COLOR.getRGB());
		//ModGUI.drawRect(new Rect(x, y, x + 2, y2), BACKGROUND_COLOR.getRGB());
		
		GlStateManager.pushMatrix();
		//mc.getTextureManager().bindTexture(new ResourceLocation("slice/slice.png"));
		//ModGUI.drawModalRectWithCustomSizedTexture(/*(int) x + 4*/105, 15/*(int) y + 4*/, 56, 56, 56, 56, 56, 56);
        //GlStateManager.translate(2, 2, 200);
        GlStateManager.scale(2, 2, 0);
        mc.fontRendererObj.drawString("Slice", x - 45, y-4, ColorUtil.getRainbow(6000, 2 * -24));
        mc.fontRendererObj.drawString("  lice", x - 47, y-4, ColorUtil.toInt(new Color(255, 255, 255)));
		GlStateManager.popMatrix();
//		mc.fontRendererObj.drawString("Slice", x + 39, y + 15, -1);
//		mc.fontRendererObj.drawString(Client.INSTANCE.getClientVersion(), x + (39 / 1.8F), y + 32 + 15, -1);
		this.elements.forEach(s -> {
			s.drawElement(this.width, this.height, scl, x + 5, y, index, mouseX, mouseY);
			index += 31;
		});
		ScaledResolution scaled = new ScaledResolution(mc, (int) x, (int) y);
		int xx = scaled.getScaledWidth();
		int xy = scaled.getScaledHeight();
		//ModGUI.drawRect(xx, xy + index - 13, x2, xy + index - 11, BACKGROUND_COLOR.brighter().getRGB());
		index = 75;
		GlStateManager.popMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public static Rect drawRect(Rect rect, int color) {
		Gui.drawRect(rect.x, rect.y, rect.w, rect.h, color);
		return rect;
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
	}

}
