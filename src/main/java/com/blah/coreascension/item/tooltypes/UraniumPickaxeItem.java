package com.blah.coreascension.item.tooltypes;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.utils.Tuple;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class UraniumPickaxeItem extends PickaxeItem
{
    public UraniumPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        if (miner instanceof ServerPlayerEntity)
        {
            if (((ServerPlayerEntity) miner).interactionManager.getGameMode() != GameMode.SURVIVAL)
            {
                return false;
            }
            if (miner.isSneaking())
            {
                ServerPlayerEntity player = (ServerPlayerEntity)miner;
                Identifier[] identifiers = new Identifier[]
                {
                    new Identifier("minecraft", "coal_ores"),
                    new Identifier("minecraft","iron_ores"),
                    new Identifier("minecraft","gold_ores"),
                    new Identifier("minecraft","diamond_ores"),
                    new Identifier("minecraft","emerald_ores"),
                    new Identifier("minecraft","ores/amethyst"),
                    new Identifier("fabric","ores/sapphire"),
                    new Identifier("fabric","ores/ruby"),
                    new Identifier("fabric","ores/citrine"),
                    new Identifier("fabric","ores/topaz"),
                    new Identifier("minecraft","obsidian"),
                    new Identifier("fabric","ores/limestone"),
                    new Identifier("fabric","ores/zircon"),
                    new Identifier("fabric","ores/uranium"),
                    new Identifier("fabric","ores/sulfur"),
                    new Identifier("fabric","ores/crystal"),
                    new Identifier("fabric","ores/sunstone"),
                    new Identifier("fabric","ores/quartz"),
                    new Identifier("fabric","ores/copper"),
                    new Identifier("fabric","ores/zinc"),
                    new Identifier("fabric","ores/aluminum"),
                    new Identifier("fabric","ores/cobalt"),
                    new Identifier("fabric","ores/iridium"),
                    new Identifier("fabric","ores/lead"),
                    new Identifier("fabric","ores/nickel"),
                    new Identifier("fabric","ores/peridot"),
                    new Identifier("fabric","ores/platinum"),
                    new Identifier("fabric","ores/silver"),
                    new Identifier("fabric","ores/tin"),
                    new Identifier("fabric","ores/tungsten"),
                    new Identifier("minecraft","redstone_ores"),
                    new Identifier("minecraft","lapis_ores"),
                    new Identifier("fabric","ores/titanium"),
                    new Identifier("fabric","ores/amber_ore"),
                    new Identifier("fabric","ores/ender_ore"),
                    new Identifier("fabric","ores/thallasium_ore"),
                    new Identifier("fabric","ores/biotite")
                };
                for (Identifier identifier : identifiers)
                {
                    if ((world.getBlockState(pos)).isIn(TagKey.of(RegistryKeys.BLOCK, identifier)))
                    {

                        //int exp = net.minecraftforge.common.ForgeHooks.onBlockBreakEvent(world, GameMode.SURVIVAL, player, pos);
                        BlockState source = world.getBlockState(pos);
                        int maxBlocks = 100;
                        int maxDistance = 100;
                        int blocks = 1;
                        Set<BlockPos> visited = Sets.newHashSet(pos);
                        LinkedList<Tuple<BlockPos, Integer>> points = new LinkedList<>();
                        AddValidNeighbors(points, pos, 1);

                        while (!points.isEmpty() && blocks < maxBlocks) {
                            Tuple<BlockPos, Integer> point = points.poll();

                            BlockPos blockPos = point.getA();
                            int blockDistance = point.getB();
                            BlockState blockState = world.getBlockState(blockPos);

                            if (visited.add(blockPos) && IsValidTarget(blockState, source, identifier) && Harvest((ServerPlayerEntity) miner, blockPos, pos)) {
//                                if (exp > 0)
//                                {
//                                    blockState.getBlock().dropXpOnBlockBreak((ServerWorld)world, pos, exp);
//                                }

                                if (blockDistance < maxDistance) {
                                    AddValidNeighbors(points, blockPos, blockDistance + 1);
                                }
                                blocks++;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,"tooltip.uranium_pickaxe"))).formatted(Formatting.GRAY));
    }

    private static void AddValidNeighbors(LinkedList<Tuple<BlockPos, Integer>> points, BlockPos source, int distance)
    {
        BlockPos up = source.up();
        BlockPos down = source.down();
        points.add(new Tuple<>(up, distance));
        points.add(new Tuple<>(down, distance));
        BlockPos[] blockPositions = new BlockPos[] {up, down, source};

        for (BlockPos blockPos : blockPositions)
        {
            points.add(new Tuple<>(blockPos.west(), distance));
            points.add(new Tuple<>(blockPos.east(), distance));
            points.add(new Tuple<>(blockPos.north(), distance));
            points.add(new Tuple<>(blockPos.south(), distance));
            points.add(new Tuple<>(blockPos.north().west(), distance));
            points.add(new Tuple<>(blockPos.north().east(), distance));
            points.add(new Tuple<>(blockPos.south().west(), distance));
            points.add(new Tuple<>(blockPos.south().east(), distance));
        }
    }
    private static boolean IsValidTarget(BlockState state, BlockState state2, Identifier location)
    {
        return state.isIn(TagKey.of(RegistryKeys.BLOCK, location)) && state2.isIn(TagKey.of(RegistryKeys.BLOCK, location));
    }

    private static boolean Harvest(ServerPlayerEntity player, BlockPos pos, BlockPos originPos)
    {
        World world = player.getWorld();
        Block.dropStacks(world.getBlockState(pos), (World) world, originPos); // change pos back to originPos if it breaks somehow
        world.breakBlock(pos, false);


        ItemStack is = player.getMainHandStack();
        if (is.damage(1, player.getRandom(), null))
        {
            is.decrement(1);
            is.setDamage(0);
        }
        return true;
    }
}
