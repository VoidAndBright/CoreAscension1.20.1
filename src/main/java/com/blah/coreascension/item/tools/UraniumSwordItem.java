package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class UraniumSwordItem extends SwordItem {

    public UraniumSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings)
    {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, "tooltip.uranium_sword"))).formatted(Formatting.GRAY));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        Box box = target.getBoundingBox().expand(8, 3, 8);
        List<Entity> entities = target.getWorld().getOtherEntities(target, box);
        for (Entity entity : entities) {
            if (entity instanceof MobEntity && entity != attacker && !(entity instanceof CatEntity || entity instanceof WolfEntity)) {
                entity.damage(entity.getDamageSources().playerAttack((PlayerEntity) attacker), 6);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
