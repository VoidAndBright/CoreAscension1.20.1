package com.blah.coreascension.screen.screens;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Map;

import static com.blah.coreascension.screen.screens.EnchantmentRelocatorScreenHandler.*;


public class EnchantmentRelocatorScreen extends HandledScreen<EnchantmentRelocatorScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/enchantment_transfer_gui.png");

    public ButtonWidget button;

    public EnchantmentRelocatorScreen(EnchantmentRelocatorScreenHandler handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    @Override
    protected void init()
    {
        super.init();
        button = ButtonWidget.builder(Text.literal("Go"), button1 -> {
            if (client != null)
                if (client.interactionManager != null)
                    client.interactionManager.clickButton(this.handler.syncId, 0);
            })
            .dimensions(this.x + 70, this.y + 60, 40, 20).build();
        addDrawableChild(button);
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
