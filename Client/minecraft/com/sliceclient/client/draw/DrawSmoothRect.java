package com.sliceclient.client.draw;

import shadersmod.client.Shaders;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.GlStateManager;

public class DrawSmoothRect {
    public static void drawRoundedRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float radius, int color) {
        float f1 = (color >> 24 & 0xFF) / 255.0F;
        float f2 = (color >> 16 & 0xFF) / 255.0F;
        float f3 = (color >> 8 & 0xFF) / 255.0F;
        float f4 = (color & 0xFF) / 255.0F;
        GlStateManager.color(f2, f3, f4, f1);
        drawRoundedRect(paramInt1, paramInt2, paramInt3, paramInt4, radius);
    }

    public static void drawRoundedRect(float paramInt1, float paramInt2, float paramInt3, float paramInt4, float radius, int color) {
        float f1 = (color >> 24 & 0xFF) / 255.0F;
        float f2 = (color >> 16 & 0xFF) / 255.0F;
        float f3 = (color >> 8 & 0xFF) / 255.0F;
        float f4 = (color & 0xFF) / 255.0F;
        GlStateManager.color(f2, f3, f4, f1);
        drawRoundedRect(paramInt1, paramInt2, paramInt3, paramInt4, radius);
    }

    public static void drawRoundedRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float radius) {
        int i = 18;
        float f1 = 90.0F / i;
        //GlStateManager.disableTexture2D();
        //Shaders.disableTexture2D();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GlStateManager.enableBlend();
        GlStateManager.disableCull();
        GlStateManager.enableColorMaterial();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GL11.glBegin(5);
        GL11.glVertex2f(paramFloat1 + radius, paramFloat2);
        GL11.glVertex2f(paramFloat1 + radius, paramFloat4);
        GL11.glVertex2f(paramFloat3 - radius, paramFloat2);
        GL11.glVertex2f(paramFloat3 - radius, paramFloat4);
        GL11.glEnd();
        GL11.glBegin(5);
        GL11.glVertex2f(paramFloat1, paramFloat2 + radius);
        GL11.glVertex2f(paramFloat1 + radius, paramFloat2 + radius);
        GL11.glVertex2f(paramFloat1, paramFloat4 - radius);
        GL11.glVertex2f(paramFloat1 + radius, paramFloat4 - radius);
        GL11.glEnd();
        GL11.glBegin(5);
        GL11.glVertex2f(paramFloat3, paramFloat2 + radius);
        GL11.glVertex2f(paramFloat3 - radius, paramFloat2 + radius);
        GL11.glVertex2f(paramFloat3, paramFloat4 - radius);
        GL11.glVertex2f(paramFloat3 - radius, paramFloat4 - radius);
        GL11.glEnd();
        GL11.glBegin(6);
        float f2 = paramFloat3 - radius;
        float f3 = paramFloat2 + radius;
        GL11.glVertex2f(f2, f3);
        int j;
        for (j = 0; j <= i; j++) {
            float f4 = j * f1;
            GL11.glVertex2f((float)(f2 + radius * Math.cos(Math.toRadians(f4))), (float)(f3 - radius * Math.sin(Math.toRadians(f4))));
        }
        GL11.glEnd();
        GL11.glBegin(6);
        f2 = paramFloat1 + radius;
        f3 = paramFloat2 + radius;
        GL11.glVertex2f(f2, f3);
        for (j = 0; j <= i; j++) {
            float f4 = j * f1;
            GL11.glVertex2f((float)(f2 - radius * Math.cos(Math.toRadians(f4))), (float)(f3 - radius * Math.sin(Math.toRadians(f4))));
        }
        GL11.glEnd();
        GL11.glBegin(6);
        f2 = paramFloat1 + radius;
        f3 = paramFloat4 - radius;
        GL11.glVertex2f(f2, f3);
        for (j = 0; j <= i; j++) {
            float f4 = j * f1;
            GL11.glVertex2f((float)(f2 - radius * Math.cos(Math.toRadians(f4))), (float)(f3 + radius * Math.sin(Math.toRadians(f4))));
        }
        GL11.glEnd();
        GL11.glBegin(6);
        f2 = paramFloat3 - radius;
        f3 = paramFloat4 - radius;
        GL11.glVertex2f(f2, f3);
        for (j = 0; j <= i; j++) {
            float f4 = j * f1;
            GL11.glVertex2f((float)(f2 + radius * Math.cos(Math.toRadians(f4))), (float)(f3 + radius * Math.sin(Math.toRadians(f4))));
        }
        GL11.glEnd();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableColorMaterial();
        //GlStateManager.enableTexture2D();
        //Shaders.enableTexture2D();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
}
