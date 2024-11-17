package com.blah.coreascension.item.items;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.entity.entities.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public class GemStaffItem extends Item
{
    public enum GemType
    {
        RUBY, CITRINE, TOPAZ, EMERALD, DIAMOND, SAPPHIRE, AMETHYST
    }
    private final GemType toShoot;
    private final String tooltip;
    public GemStaffItem(Settings settings, GemType toShoot, String tooltip)
    {
        super(settings);
        this.toShoot = toShoot;
        this.tooltip = tooltip;
    }

    @Override
    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.BOW;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, this.tooltip))).formatted(Formatting.GRAY));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if (!world.isClient())
        {
            ThrownItemEntity proj;
            switch (this.toShoot)
            {
                case RUBY -> proj = new RubyBoltEntity(user, world);
                case CITRINE -> proj = new CitrineBoltEntity(user, world);
                case TOPAZ -> proj = new TopazBoltEntity(user, world);
                case EMERALD -> proj = new EmeraldBoltEntity(user, world);
                case DIAMOND -> proj = new DiamondBoltEntity(user, world);
                case SAPPHIRE -> proj = new SapphireBoltEntity(user, world);
                default -> proj = new AmethystBoltEntity(user, world);
            }
            proj.setVelocity(user, user.getPitch(), user.getYaw(), 0, 2.5f, 1.0f);
            world.spawnEntity(proj);
        }
        world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 0.4f, 1f);
        user.getItemCooldownManager().set(this, 10);
        return TypedActionResult.success(new ItemStack(this));
    }
}
