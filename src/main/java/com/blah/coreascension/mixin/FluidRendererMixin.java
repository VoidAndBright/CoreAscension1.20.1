package com.blah.coreascension.mixin;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FluidRenderer.class)
public abstract class FluidRendererMixin
{
    @Shadow public abstract void render(BlockRenderView world, BlockPos pos, VertexConsumer vertexConsumer, BlockState blockState, FluidState fluidState);
    @Shadow protected abstract void vertex(VertexConsumer vertexConsumer, double x, double y, double z, float red, float green, float blue, float u, float v, int light);
    @Shadow protected abstract int getLight(BlockRenderView world, BlockPos pos);
    @Shadow
    private static boolean isSideCovered(BlockView world, Direction direction, float height, BlockPos pos, BlockState state)
    {
        if (state.isOpaque())
        {
            VoxelShape voxelShape = VoxelShapes.cuboid(0.0, 0, 0.0, 1.0, height, 1.0);
            VoxelShape voxelShape2 = state.getCullingShape(world, pos);
            return VoxelShapes.isSideCovered(voxelShape, voxelShape2, direction);
        }
        else
        {
            return false;
        }
    }

    @Shadow private float getFluidHeight(BlockRenderView world, Fluid fluid, BlockPos pos, BlockState blockState, FluidState fluidState)
    {
        if (fluid.matchesType(fluidState.getFluid()))
        {
            BlockState blockState2 = world.getBlockState(pos.down());
            return fluid.matchesType(blockState2.getFluidState().getFluid()) ? 1.0F : fluidState.getHeight();
        }
        else
        {
            return !blockState.isSolid() ? 0.0F : -1.0F;
        }
    }
    @Shadow protected abstract float calculateFluidHeight(BlockRenderView world, Fluid fluid, float originHeight, float northSouthHeight, float eastWestHeight, BlockPos pos);

    @Shadow
    public static boolean shouldRenderSide(BlockRenderView world, BlockPos pos, FluidState fluidState, BlockState blockState, Direction direction, FluidState neighborFluidState)
    {
        return !isOppositeSideCovered(world, pos, blockState, direction) && !isSameFluid(fluidState, neighborFluidState);
    }

    @Shadow
    private static boolean isSameFluid(FluidState a, FluidState b)
    {
        return b.getFluid().matchesType(a.getFluid()) ||
                (a.getFluid() == CoreAscensionBlocks.FLOWING_END_GAS && b.getFluid() == CoreAscensionBlocks.STILL_END_GAS) ||
                (b.getFluid() == CoreAscensionBlocks.FLOWING_END_GAS && a.getFluid() == CoreAscensionBlocks.STILL_END_GAS);
    }

    @Shadow
    private static boolean isSideCovered(BlockView world, BlockPos pos, Direction direction, float maxDeviation, BlockState state)
    {
        return isSideCovered(world, direction, maxDeviation, pos.offset(direction), state);
    }

    @Shadow
    private static boolean isOppositeSideCovered(BlockView world, BlockPos pos, BlockState state, Direction direction)
    {
        return isSideCovered(world, direction.getOpposite(), 1.0F, pos, state);
    }

    @Inject(at = @At(value = "HEAD"), method = "render", cancellable = true)
    private void onRenderFluid(BlockRenderView world, BlockPos pos, VertexConsumer vertexConsumer, BlockState blockState, FluidState fluidState, CallbackInfo ci)
    {
        if (fluidState.getFluid() == CoreAscensionBlocks.FLOWING_END_GAS ||
            fluidState.getFluid() == CoreAscensionBlocks.STILL_END_GAS)
        {
            Sprite[] sprites = new Sprite[2];
            sprites[0] = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(CoreAscensionBlocks.STILL_END_GAS.getDefaultState().getBlockState()).getParticleSprite();
            sprites[1] = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(CoreAscensionBlocks.FLOWING_END_GAS.getDefaultState().getBlockState()).getParticleSprite();
            int i = 16777215;
            float f = (float)(i >> 16 & 0xFF) / 255.0F;
            float g = (float)(i >> 8 & 0xFF) / 255.0F;
            float h = (float)(i & 0xFF) / 255.0F;
            BlockState upBS = world.getBlockState(pos.offset(Direction.UP));
            FluidState upFS = upBS.getFluidState();
            BlockState downBS = world.getBlockState(pos.offset(Direction.DOWN));
            FluidState downFS = downBS.getFluidState();
            BlockState northBS = world.getBlockState(pos.offset(Direction.NORTH));
            FluidState northFS = northBS.getFluidState();
            BlockState southBS = world.getBlockState(pos.offset(Direction.SOUTH));
            FluidState southFS = southBS.getFluidState();
            BlockState westBS = world.getBlockState(pos.offset(Direction.WEST));
            FluidState westFS = westBS.getFluidState();
            BlockState eastBS = world.getBlockState(pos.offset(Direction.EAST));
            FluidState eastFS = eastBS.getFluidState();
            boolean isNotTheSameFluidDown = !isSameFluid(fluidState, downFS);
            boolean isTheSameFluidUp = isSameFluid(fluidState, upFS);
            boolean shouldDownRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.UP, upFS)
                    && !isSideCovered(world, pos, Direction.UP, 0.8888889F, upBS);

            boolean shouldUpRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.DOWN, downFS)
                    && !isSideCovered(world, pos, Direction.DOWN, 0.8888889F, downBS);

            boolean shouldNorthRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.NORTH, northFS);
            boolean shouldSouthRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.SOUTH, southFS);
            boolean shouldWestRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.WEST, westFS);
            boolean shouldEastRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.EAST, eastFS);
            if (shouldDownRender || shouldWestRender || shouldNorthRender || shouldSouthRender || shouldEastRender)
            {
                float brightnessUp = world.getBrightness(Direction.UP, true);
                float brightnessDown = world.getBrightness(Direction.DOWN, true);
                float brightnessZ = world.getBrightness(Direction.NORTH, true);
                float brightnessX = world.getBrightness(Direction.WEST, true);
                Fluid fluid = fluidState.getFluid();
                float fluidHeight = this.getFluidHeight(world, fluid, pos, blockState, fluidState);
                float fluidHeightNE;
                float fluidHeightNW;
                float fluidHeightSE;
                float fluidHeightSW;
                if (fluidHeight >= 1.0F)
                {
                    fluidHeightNE = 1.0F;
                    fluidHeightNW = 1.0F;
                    fluidHeightSE = 1.0F;
                    fluidHeightSW = 1.0F;
                }
                else
                {
                    float fluidHeightNorth = this.getFluidHeight(world, fluid, pos.north(), northBS, northFS);
                    float fluidHeightSouth = this.getFluidHeight(world, fluid, pos.south(), southBS, southFS);
                    float fluidHeightEast = this.getFluidHeight(world, fluid, pos.east(), eastBS, eastFS);
                    float fluidHeightWest = this.getFluidHeight(world, fluid, pos.west(), westBS, westFS);
                    fluidHeightNE = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightNorth, fluidHeightEast, pos.offset(Direction.NORTH).offset(Direction.EAST));
                    fluidHeightNW = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightNorth, fluidHeightWest, pos.offset(Direction.NORTH).offset(Direction.WEST));
                    fluidHeightSE = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightSouth, fluidHeightEast, pos.offset(Direction.SOUTH).offset(Direction.EAST));
                    fluidHeightSW = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightSouth, fluidHeightWest, pos.offset(Direction.SOUTH).offset(Direction.WEST));
                }

                double posX = (pos.getX() & 15);
                double posY = pos.getY() & 15;
                double posZ = (pos.getZ() & 15);
                float x = 0.001F;
                float y = 0f; //shouldUpRender ? 0.001F : 0.0F;
                if (isNotTheSameFluidDown && !isSideCovered(world, pos, Direction.DOWN, Math.max(Math.max(fluidHeightNW, fluidHeightSW), Math.max(fluidHeightSE, fluidHeightNE)), downBS))
                {
                    fluidHeightNW -= 0.001F;
                    fluidHeightSW -= 0.001F;
                    fluidHeightSE -= 0.001F;
                    fluidHeightNE -= 0.001F;
                    Vec3d vec3d = fluidState.getVelocity(world, pos);
                    float z;
                    float ab;
                    float ad;
                    float af;
                    float aa;
                    float ac;
                    float ae;
                    float ag;
                    if (vec3d.x == 0.0 && vec3d.z == 0.0)
                    {
                        // still gas
                        Sprite sprite = sprites[0];
                        z = sprite.getFrameU(0.0);
                        aa = sprite.getFrameV(0.0);
                        ab = z;
                        ac = sprite.getFrameV(16.0);
                        ad = sprite.getFrameU(16.0);
                        ae = ac;
                        af = ad;
                        ag = aa;
                    }
                    else
                    {
                        // flowing gas
                        Sprite sprite = sprites[1];
                        float ah = (float) MathHelper.atan2(vec3d.z, vec3d.x) - (float) (Math.PI / 2);
                        float ai = MathHelper.sin(ah) * 0.25F;
                        float aj = MathHelper.cos(ah) * 0.25F;
                        float ak = 8.0F;
                        z = sprite.getFrameU(ak + (-aj - ai) * 16.0F);
                        aa = sprite.getFrameV(ak + (-aj + ai) * 16.0F);
                        ab = sprite.getFrameU(ak + (-aj + ai) * 16.0F);
                        ac = sprite.getFrameV(ak + (aj + ai) * 16.0F);
                        ad = sprite.getFrameU(ak + (aj + ai) * 16.0F);
                        ae = sprite.getFrameV(ak + (aj - ai) * 16.0F);
                        af = sprite.getFrameU(ak + (aj - ai) * 16.0F);
                        ag = sprite.getFrameV(ak + (-aj - ai) * 16.0F);
                    }

                    float al = (z + ab + ad + af) / 4.0F;
                    float ah = (aa + ac + ae + ag) / 4.0F;
                    float ai = sprites[0].getAnimationFrameDelta();
                    z = MathHelper.lerp(ai, z, al);
                    ab = MathHelper.lerp(ai, ab, al);
                    ad = MathHelper.lerp(ai, ad, al);
                    af = MathHelper.lerp(ai, af, al);
                    aa = MathHelper.lerp(ai, aa, ah);
                    ac = MathHelper.lerp(ai, ac, ah);
                    ae = MathHelper.lerp(ai, ae, ah);
                    ag = MathHelper.lerp(ai, ag, ah);
                    int am = this.getLight(world, pos);
                    float ak = brightnessDown * f;
                    float an = brightnessDown * g;
                    float ao = brightnessDown * h;

                    float val = 1;

//                    if (isSameFluid(fluidState, upFS) && fluidState.getFluid() == CoreAscensionBlocks.STILL_END_GAS)
//                    {
//                        CoreAscension.LOGGER.info("test");
//                        val = 0.86666666666f;
//                    }
                    this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightNW + val, posZ + 0.0, ak, an, ao, z, aa, am);
                    this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightSW + val, posZ + 1.0, ak, an, ao, ab, ac, am);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightSE + val, posZ + 1.0, ak, an, ao, ad, ae, am);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightNE + val, posZ + 0.0, ak, an, ao, af, ag, am);
                    if (fluidState.canFlowTo(world, pos.down()))
                    {
                        this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightNW + val, posZ + 0.0, ak, an, ao, z, aa, am);
                        this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightNE + val, posZ + 0.0, ak, an, ao, af, ag, am);
                        this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightSE + val, posZ + 1.0, ak, an, ao, ad, ae, am);
                        this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightSW + val, posZ + 1.0, ak, an, ao, ab, ac, am);
                    }
                }

                if (isTheSameFluidUp)
                {
                    shouldDownRender = false;
                }

                // ignore this - leaving it here in case I need it in the future
//                if (shouldUpRender)
//                {
//                    float zx = sprites[0].getMinU();
//                    float abx = sprites[0].getMaxU();
//                    float adx = sprites[0].getMinV();
//                    float afx = sprites[0].getMaxV();
//                    int ap = this.getLight(world, pos.up());
//                    float acx = j * f;
//                    float aex = j * g;
//                    float agx = j * h;
//                    this.vertex(vertexConsumer, posX, posY - (double)y + 1, posZ + 1.0, acx, aex, agx, zx, afx, ap);
//                    this.vertex(vertexConsumer, posX, posY - (double)y + 1, posZ, acx, aex, agx, zx, adx, ap);
//                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)y + 1, posZ, acx, aex, agx, abx, adx, ap);
//                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)y + 1, posZ + 1.0, acx, aex, agx, abx, afx, ap);
//                }

                if (shouldDownRender)
                {
                    y = -0.001f;
                    float zx = sprites[1].getMinU();
                    float abx = sprites[1].getMaxU();
                    float adx = sprites[1].getMinV();
                    float afx = sprites[1].getMaxV();
                    int ap = this.getLight(world, pos.down());
                    float acx = brightnessUp * f;
                    float aex = brightnessUp * g;
                    float agx = brightnessUp * h;
                    this.vertex(vertexConsumer, posX, posY - (double)y + 1, posZ + 1.0, acx, aex, agx, zx, afx, ap);
                    this.vertex(vertexConsumer, posX, posY - (double)y + 1, posZ, acx, aex, agx, zx, adx, ap);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)y + 1, posZ, acx, aex, agx, abx, adx, ap);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)y + 1, posZ + 1.0, acx, aex, agx, abx, afx, ap);
                }
                //y = shouldUpRender ? 0.001F : 0.0F;
                int light = this.getLight(world, pos);

                for (Direction direction : Direction.Type.HORIZONTAL)
                {
                    float afx;
                    float aax;
                    double ar;
                    double at;
                    double as;
                    double au;
                    boolean bl8;
                    switch (direction)
                    {
                        case NORTH:
                            afx = fluidHeightNW;
                            aax = fluidHeightNE;
                            ar = posX;
                            as = posX + 1.0;
                            at = posZ + 0.001F;
                            au = posZ + 0.001F;
                            bl8 = shouldNorthRender;
                            break;
                        case SOUTH:
                            afx = fluidHeightSE;
                            aax = fluidHeightSW;
                            ar = posX + 1.0;
                            as = posX;
                            at = posZ + 1.0 - 0.001F;
                            au = posZ + 1.0 - 0.001F;
                            bl8 = shouldSouthRender;
                            break;
                        case WEST:
                            afx = fluidHeightSW;
                            aax = fluidHeightNW;
                            ar = posX + 0.001F;
                            as = posX + 0.001F;
                            at = posZ + 1.0;
                            au = posZ;
                            bl8 = shouldWestRender;
                            break;
                        default:
                            afx = fluidHeightNE;
                            aax = fluidHeightSE;
                            ar = posX + 1.0 - 0.001F;
                            as = posX + 1.0 - 0.001F;
                            at = posZ;
                            au = posZ + 1.0;
                            bl8 = shouldEastRender;
                    }

                    if (bl8 && !isSideCovered(world, pos, direction, Math.max(afx, aax), world.getBlockState(pos.offset(direction))))
                    {
                        BlockPos blockPos = pos.offset(direction);
                        Sprite sprite2 = sprites[1];

                        float av = sprite2.getFrameU(0.0);
                        float aw = sprite2.getFrameU(8.0);
                        float ax = sprite2.getFrameV((1.0F - afx) * 16.0F * 0.5F);
                        float ay = sprite2.getFrameV((1.0F - aax) * 16.0F * 0.5F);
                        float az = sprite2.getFrameV(8.0);
                        float ba = direction.getAxis() == Direction.Axis.Z ? brightnessZ : brightnessX;
                        float bb = brightnessDown * ba * f;
                        float bc = brightnessDown * ba * g;
                        float bd = brightnessDown * ba * h;
                        this.vertex(vertexConsumer, ar, posY - (double)afx + 1.1333333f, at, bb, bc, bd, av, ax, light);
                        this.vertex(vertexConsumer, as, posY - (double)aax + 1.1333333f, au, bb, bc, bd, aw, ay, light);
                        this.vertex(vertexConsumer, as, posY - (double)y + 1.1333333f, au, bb, bc, bd, aw, az, light);
                        this.vertex(vertexConsumer, ar, posY - (double)y + 1.1333333f, at, bb, bc, bd, av, az, light);

                        this.vertex(vertexConsumer, ar, posY - (double)y + 1.1333333f, at, bb, bc, bd, av, az, light);
                        this.vertex(vertexConsumer, as, posY - (double)y + 1.1333333f, au, bb, bc, bd, aw, az, light);
                        this.vertex(vertexConsumer, as, posY - (double)aax + 1.1333333f, au, bb, bc, bd, aw, ay, light);
                        this.vertex(vertexConsumer, ar, posY - (double)afx + 1.1333333f, at, bb, bc, bd, av, ax, light);
                    }
                }
            }
            ci.cancel();
        }
    }
}
