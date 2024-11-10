package com.blah.coreascension.screen.screens;

import com.blah.coreascension.CoreAscension;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ReinforcedChestScreen extends HandledScreen<ReinforcedChestScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/reinforced_chest_gui.png");
    public ReinforcedChestScreen(ReinforcedChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    protected void init() {
        super.init();
        this.backgroundHeight=222;
        this.backgroundWidth=248;

        this.x=(width-backgroundWidth)/2;
        this.y=(height-backgroundHeight)/2;

        this.playerInventoryTitleX = playerInventoryTitleX + 36;
        this.playerInventoryTitleY = backgroundHeight - 94;
    }
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
