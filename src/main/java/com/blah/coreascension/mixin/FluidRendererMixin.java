package com.blah.coreascension.mixin;

import com.blah.coreascension.block.fluid.CoreAscensionFluids;
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
            BlockState blockStateDown = world.getBlockState(pos.down());
            return fluid.matchesType(blockStateDown.getFluidState().getFluid()) ?  fluidState.getHeight(): 1.0F;
        }
        else
        {
            return !blockState.isSolid() ? -1.0F : 0.0F;
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
                (a.getFluid() == CoreAscensionFluids.FLOWING_END_GAS && b.getFluid() == CoreAscensionFluids.STILL_END_GAS) ||
                (b.getFluid() == CoreAscensionFluids.FLOWING_END_GAS && a.getFluid() == CoreAscensionFluids.STILL_END_GAS);
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
        if (fluidState.getFluid() == CoreAscensionFluids.FLOWING_END_GAS ||
            fluidState.getFluid() == CoreAscensionFluids.STILL_END_GAS)
        {
            Sprite[] sprites = new Sprite[2];
            sprites[0] = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(CoreAscensionFluids.STILL_END_GAS.getDefaultState().getBlockState()).getParticleSprite();
            sprites[1] = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(CoreAscensionFluids.FLOWING_END_GAS.getDefaultState().getBlockState()).getParticleSprite();
            int i = 16777215;
            float red = (float)(i >> 16 & 0xFF) / 255.0F;
            float green = (float)(i >> 8 & 0xFF) / 255.0F;
            float blue = (float)(i & 0xFF) / 255.0F;
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
            boolean shouldUpRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.UP, upFS)
                    && !isSideCovered(world, pos, Direction.UP, 0.8888889F, upBS);

            boolean shouldDownRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.DOWN, downFS)
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
                        float atan = (float)( MathHelper.atan2(vec3d.z, vec3d.x) - Math.PI / 2 );
                        float sin = MathHelper.sin(atan) * 0.25F;
                        float cos = MathHelper.cos(atan) * 0.25F;
                        float eight = 8.0F;
                        z = sprite.getFrameU(eight + (-cos - sin) * 16.0F);
                        aa = sprite.getFrameV(eight + (-cos + sin) * 16.0F);
                        ab = sprite.getFrameU(eight + (-cos + sin) * 16.0F);
                        ac = sprite.getFrameV(eight + (cos + sin) * 16.0F);
                        ad = sprite.getFrameU(eight + (cos + sin) * 16.0F);
                        ae = sprite.getFrameV(eight + (cos - sin) * 16.0F);
                        af = sprite.getFrameU(eight + (cos - sin) * 16.0F);
                        ag = sprite.getFrameV(eight + (-cos - sin) * 16.0F);
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
                    int light = this.getLight(world, pos);
                    float brightnessDownRed = brightnessDown * red;
                    float brightnessDownGreen = brightnessDown * green;
                    float brightnessDownBlue = brightnessDown * blue;

                    float val = 1;

//                    if (isSameFluid(fluidState, upFS) && fluidState.getFluid() == CoreAscensionBlocks.STILL_END_GAS)
//                    {
//                        CoreAscension.LOGGER.info("test");
//                        val = 0.86666666666f;
//                    }
                    this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightNW + val, posZ + 0.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, z, aa, light);
                    this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightSW + val, posZ + 1.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, ab, ac, light);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightSE + val, posZ + 1.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, ad, ae, light);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightNE + val, posZ + 0.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, af, ag, light);
                    if (fluidState.canFlowTo(world, pos.down()))
                    {
                        this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightNW + val, posZ + 0.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, z, aa, light);
                        this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightNE + val, posZ + 0.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, af, ag, light);
                        this.vertex(vertexConsumer, posX + 1.0, posY - (double)fluidHeightSE + val, posZ + 1.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, ad, ae, light);
                        this.vertex(vertexConsumer, posX + 0.0, posY - (double)fluidHeightSW + val, posZ + 1.0, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, ab, ac, light);
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
                    float minU = sprites[1].getMinU();
                    float maxU = sprites[1].getMaxU();
                    float minV = sprites[1].getMinV();
                    float maxV = sprites[1].getMaxV();
                    int light = this.getLight(world, pos.down());
                    float brightnessUpRed = brightnessUp * red;
                    float brightnessUpGreen = brightnessUp * green;
                    float brightnessUpBlue = brightnessUp * blue;
                    this.vertex(vertexConsumer, posX, posY - (double)y + 1, posZ + 1.0, brightnessUpRed, brightnessUpGreen, brightnessUpBlue, minU, maxV, light);
                    this.vertex(vertexConsumer, posX, posY - (double)y + 1, posZ, brightnessUpRed, brightnessUpGreen, brightnessUpBlue, minU, minV, light);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)y + 1, posZ, brightnessUpRed, brightnessUpGreen, brightnessUpBlue, maxU, minV, light);
                    this.vertex(vertexConsumer, posX + 1.0, posY - (double)y + 1, posZ + 1.0, brightnessUpRed, brightnessUpGreen, brightnessUpBlue, maxU, maxV, light);
                }
                //y = shouldUpRender ? 0.001F : 0.0F;
                int light = this.getLight(world, pos);

                for (Direction direction : Direction.Type.HORIZONTAL)
                {
                    float fluidCorner;
                    float fluidOppsiteCorner;
                    double posMinX;
                    double posMinZ;
                    double posMaxX;
                    double posMaxZ;
                    boolean shouldRender;
                    switch (direction)
                    {
                        case NORTH:
                            fluidCorner = fluidHeightNW;
                            fluidOppsiteCorner = fluidHeightNE;
                            posMinX = posX;
                            posMaxX = posX + 1.0;
                            posMinZ = posZ + 0.001F;
                            posMaxZ = posZ + 0.001F;
                            shouldRender = shouldNorthRender;
                            break;
                        case SOUTH:
                            fluidCorner = fluidHeightSE;
                            fluidOppsiteCorner = fluidHeightSW;
                            posMinX = posX + 1.0;
                            posMaxX = posX;
                            posMinZ = posZ + 1.0 - 0.001F;
                            posMaxZ = posZ + 1.0 - 0.001F;
                            shouldRender = shouldSouthRender;
                            break;
                        case WEST:
                            fluidCorner = fluidHeightSW;
                            fluidOppsiteCorner = fluidHeightNW;
                            posMinX = posX + 0.001F;
                            posMaxX = posX + 0.001F;
                            posMinZ = posZ + 1.0;
                            posMaxZ = posZ;
                            shouldRender = shouldWestRender;
                            break;
                        default:
                            fluidCorner = fluidHeightNE;
                            fluidOppsiteCorner = fluidHeightSE;
                            posMinX = posX + 1.0 - 0.001F;
                            posMaxX = posX + 1.0 - 0.001F;
                            posMinZ = posZ;
                            posMaxZ = posZ + 1.0;
                            shouldRender = shouldEastRender;
                    }

                    if (shouldRender && !isSideCovered(world, pos, direction, Math.max(fluidCorner, fluidOppsiteCorner), world.getBlockState(pos.offset(direction))))
                    {
                        Sprite spriteFlowing = sprites[1];

                        float minU = spriteFlowing.getFrameU(0.0);
                        float maxU = spriteFlowing.getFrameU(8.0);
                        float maxVX = spriteFlowing.getFrameV((1.0F - fluidCorner) * 16.0F * 0.5F);
                        float maxVZ = spriteFlowing.getFrameV((1.0F - fluidOppsiteCorner) * 16.0F * 0.5F);
                        float maxV = spriteFlowing.getFrameV(8.0);
                        float brightness = direction.getAxis() == Direction.Axis.Z ? brightnessZ : brightnessX;
                        float brightnessRed = brightnessDown * brightness * red;
                        float brightnessGreen = brightnessDown * brightness * green;
                        float brightnessBlue = brightnessDown * brightness * blue;
                        this.vertex(vertexConsumer, posMinX, posY - (double)fluidCorner + 1.1333333f, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxVX, light);
                        this.vertex(vertexConsumer, posMaxX, posY - (double)fluidOppsiteCorner + 1.1333333f, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxVZ, light);
                        this.vertex(vertexConsumer, posMaxX, posY - (double)y + 1.1333333f, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxV, light);
                        this.vertex(vertexConsumer, posMinX, posY - (double)y + 1.1333333f, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxV, light);

                        this.vertex(vertexConsumer, posMinX, posY - (double)y + 1.1333333f, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxV, light);
                        this.vertex(vertexConsumer, posMaxX, posY - (double)y + 1.1333333f, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxV, light);
                        this.vertex(vertexConsumer, posMaxX, posY - (double)fluidOppsiteCorner + 1.1333333f, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxVZ, light);
                        this.vertex(vertexConsumer, posMinX, posY - (double)fluidCorner + 1.1333333f, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxVX, light);
                    }
                }
            }
            ci.cancel();
        }
    }
}
