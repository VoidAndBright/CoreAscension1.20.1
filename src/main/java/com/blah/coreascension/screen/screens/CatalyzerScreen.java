package com.blah.coreascension.screen.screens;

import com.blah.coreascension.CoreAscension;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class CatalyzerScreen extends HandledScreen<CatalyzerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/catalyzing_gui.png");
    public CatalyzerScreen(CatalyzerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected void init() {
        super.init();
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        context.drawTexture(TEXTURE, x-50, y-50, 0, 0, backgroundWidth, backgroundHeight);
    }

    public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);
        drawMouseoverTooltip(graphics, mouseX, mouseY);
    }
}
