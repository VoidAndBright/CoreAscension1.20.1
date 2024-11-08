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
        this.titleX = -28;
        this.titleY = -22;
        this.playerInventoryTitleY = 100;
    }
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }
    //protected boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
    //    int x = (width - backgroundWidth) / 2;
    //    int y = (height - backgroundHeight) / 2;
    //    return mouseX < (double)x || mouseX >= (double)x+backgroundWidth || mouseY < (double)y || mouseY >= (double)y+backgroundHeight;
    //}
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
        context.drawText(textRenderer,title, 0, titleY,0xffffff,false);
    }
}
