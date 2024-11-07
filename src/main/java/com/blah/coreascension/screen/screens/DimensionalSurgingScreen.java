package com.blah.coreascension.screen.screens;

import com.blah.coreascension.CoreAscension;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class DimensionalSurgingScreen extends HandledScreen<DimensionalSurgingScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/dimensional_merger_gui.png");
    public DimensionalSurgingScreen(DimensionalSurgingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected void init() {
        super.init();
        titleY = 1500;
        playerInventoryTitleY = 1000;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }
    private void renderProgressArrow(DrawContext graphics, int x, int y) {
        if(handler.isCrafting()) {
			graphics.drawTexture(TEXTURE, x + 41, y + 27, 176, 0,80,handler.getScaledProgress());
        }
    }

    public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);
        drawMouseoverTooltip(graphics, mouseX, mouseY);
    }
}
