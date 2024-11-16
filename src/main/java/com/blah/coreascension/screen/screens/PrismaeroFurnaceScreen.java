package com.blah.coreascension.screen.screens;

import com.blah.coreascension.CoreAscension;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class PrismaeroFurnaceScreen extends HandledScreen<PrismaeroFurnaceScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/prismaerion_furnace_gui.png");

    public PrismaeroFurnaceScreen(PrismaeroFurnaceScreenHandler handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    public void render(DrawContext graphics, int mouseX, int mouseY, float delta)
    {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);
        drawMouseoverTooltip(graphics, mouseX, mouseY);
    }

    protected void drawBackground(DrawContext graphics, float delta, int mouseX, int mouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        graphics.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }
}
