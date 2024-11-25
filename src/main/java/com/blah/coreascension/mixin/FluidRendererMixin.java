package com.blah.coreascension.mixin;

import com.blah.coreascension.fluid.CoreAscensionFluids;
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
public abstract class FluidRendererMixin {
    @Shadow
    public abstract void render(BlockRenderView world, BlockPos pos, VertexConsumer vertexConsumer, BlockState blockState, FluidState fluidState);

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
            float red = (i >> 16 & 0xFF) / 255.0F;
            float green = (i >> 8 & 0xFF) / 255.0F;
            float blue = (i & 0xFF) / 255.0F;
            BlockState blockStateUp = world.getBlockState(pos.offset(Direction.UP));
            FluidState fluidStateUp = blockStateUp.getFluidState();
            BlockState blockStateDown = world.getBlockState(pos.offset(Direction.DOWN));
            FluidState downFS = blockStateDown.getFluidState();
            BlockState northBlockstate = world.getBlockState(pos.offset(Direction.NORTH));
            FluidState northFluidstate = northBlockstate.getFluidState();
            BlockState southBlockstate = world.getBlockState(pos.offset(Direction.SOUTH));
            FluidState southFluidstate = southBlockstate.getFluidState();
            BlockState westBlockstate = world.getBlockState(pos.offset(Direction.WEST));
            FluidState westFluidstate = westBlockstate.getFluidState();
            BlockState eastBlockstate = world.getBlockState(pos.offset(Direction.EAST));
            FluidState eastFluidstate = eastBlockstate.getFluidState();
            boolean isNotTheSameFluidDown = !isSameFluid(fluidState, downFS);
            boolean isTheSameFluidUp = isSameFluid(fluidState, fluidStateUp);
            boolean shouldUpRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.UP, fluidStateUp)
                    && !isSideCovered(world, pos, Direction.UP, 0.8888889F, blockStateUp);

            boolean shouldDownRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.DOWN, downFS)
                    && !isSideCovered(world, pos, Direction.DOWN, 0.8888889F, blockStateDown);

            boolean shouldNorthRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.NORTH, northFluidstate);
            boolean shouldSouthRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.SOUTH, southFluidstate);
            boolean shouldWestRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.WEST, westFluidstate);
            boolean shouldEastRender = shouldRenderSide(world, pos, fluidState, blockState, Direction.EAST, eastFluidstate);
            if (shouldDownRender || shouldWestRender || shouldNorthRender || shouldSouthRender || shouldEastRender)
            {
                float brightnessUp = world.getBrightness(Direction.UP, true);
                float brightnessDown = world.getBrightness(Direction.DOWN, true);
                float brightnessZ = world.getBrightness(Direction.NORTH, true);
                float brightnessX = world.getBrightness(Direction.WEST, true);
                Fluid fluid = fluidState.getFluid();
                float fluidHeight = this.getUpsideDownFluidHeight(world, fluid, pos, blockState, fluidState);
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
                } else
                {
                    float fluidHeightNorth = this.getUpsideDownFluidHeight(world, fluid, pos.north(), northBlockstate, northFluidstate);
                    float fluidHeightSouth = this.getUpsideDownFluidHeight(world, fluid, pos.south(), southBlockstate, southFluidstate);
                    float fluidHeightEast = this.getUpsideDownFluidHeight(world, fluid, pos.east(), eastBlockstate, eastFluidstate);
                    float fluidHeightWest = this.getUpsideDownFluidHeight(world, fluid, pos.west(), westBlockstate, westFluidstate);
                    fluidHeightNE = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightNorth, fluidHeightEast, pos.offset(Direction.NORTH).offset(Direction.EAST));
                    fluidHeightNW = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightNorth, fluidHeightWest, pos.offset(Direction.NORTH).offset(Direction.WEST));
                    fluidHeightSE = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightSouth, fluidHeightEast, pos.offset(Direction.SOUTH).offset(Direction.EAST));
                    fluidHeightSW = this.calculateFluidHeight(world, fluid, fluidHeight, fluidHeightSouth, fluidHeightWest, pos.offset(Direction.SOUTH).offset(Direction.WEST));
                }

                double posX = pos.getX() & 15;
                double posY = pos.getY() & 15;
                double posZ = pos.getZ() & 15;
                float y = shouldDownRender ? 0.001F : 0.0F;
                if (isNotTheSameFluidDown && !isSideCovered(world, pos, Direction.DOWN, Math.max(Math.max(fluidHeightNW, fluidHeightSW), Math.max(fluidHeightSE, fluidHeightNE)), blockStateDown))
                {
                    fluidHeightNW -= 0.001F;
                    fluidHeightSW -= 0.001F;
                    fluidHeightSE -= 0.001F;
                    fluidHeightNE -= 0.001F;
                    Vec3d vec3d = fluidState.getVelocity(world, pos);
                    float u1;
                    float u2;
                    float u3;
                    float u4;
                    float v1;
                    float v2;
                    float v3;
                    float v4;
                    if (vec3d.x == 0.0 && vec3d.z == 0.0)
                    {
                        // still gas
                        Sprite sprite = sprites[0];
                        u1 = sprite.getFrameU(0.0);
                        v1 = sprite.getFrameV(0.0);
                        u2 = u1;
                        v2 = sprite.getFrameV(16.0);
                        u3 = sprite.getFrameU(16.0);
                        v3 = v2;
                        u4 = u3;
                        v4 = v1;
                    } else
                    {
                        // flowing gas
                        Sprite sprite = sprites[1];
                        float atan = (float) (MathHelper.atan2(vec3d.z, vec3d.x) - Math.PI / 2);
                        float sin = MathHelper.sin(atan) * 0.25F;
                        float cos = MathHelper.cos(atan) * 0.25F;
                        float eight = 8.0F;
                        u1 = sprite.getFrameU(eight + (-cos - sin) * 16.0F);
                        v1 = sprite.getFrameV(eight + (-cos + sin) * 16.0F);
                        u2 = sprite.getFrameU(eight + (-cos + sin) * 16.0F);
                        v2 = sprite.getFrameV(eight + (cos + sin) * 16.0F);
                        u3 = sprite.getFrameU(eight + (cos + sin) * 16.0F);
                        v3 = sprite.getFrameV(eight + (cos - sin) * 16.0F);
                        u4 = sprite.getFrameU(eight + (cos - sin) * 16.0F);
                        v4 = sprite.getFrameV(eight + (-cos - sin) * 16.0F);
                    }

                    float al = (u1 + u2 + u3 + u4) / 4.0F;
                    float ah = (v1 + v2 + v3 + v4) / 4.0F;
                    float animation = sprites[0].getAnimationFrameDelta();
                    u1 = MathHelper.lerp(animation, u1, al);
                    u2 = MathHelper.lerp(animation, u2, al);
                    u3 = MathHelper.lerp(animation, u3, al);
                    u4 = MathHelper.lerp(animation, u4, al);
                    v1 = MathHelper.lerp(animation, v1, ah);
                    v2 = MathHelper.lerp(animation, v2, ah);
                    v3 = MathHelper.lerp(animation, v3, ah);
                    v4 = MathHelper.lerp(animation, v4, ah);
                    int light = this.getLight(world, pos);
                    float brightnessDownRed = brightnessDown * red;
                    float brightnessDownGreen = brightnessDown * green;
                    float brightnessDownBlue = brightnessDown * blue;

                    float val = 1;

                    this.vertex(vertexConsumer, posX, posY - fluidHeightNW + val, posZ, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u1, v1, light);
                    this.vertex(vertexConsumer, posX, posY - fluidHeightSW + val, posZ + 1, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u2, v2, light);
                    this.vertex(vertexConsumer, posX + 1, posY - fluidHeightSE + val, posZ + 1, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u3, v3, light);
                    this.vertex(vertexConsumer, posX + 1, posY - fluidHeightNE + val, posZ, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u4, v4, light);
                    if (fluidState.canFlowTo(world, pos.down()))
                    {
                        this.vertex(vertexConsumer, posX, posY - fluidHeightNW + val, posZ, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u1, v1, light);
                        this.vertex(vertexConsumer, posX + 1, posY - fluidHeightNE + val, posZ , brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u4, v4, light);
                        this.vertex(vertexConsumer, posX + 1, posY - fluidHeightSE + val, posZ + 1, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u3, v3, light);
                        this.vertex(vertexConsumer, posX, posY - fluidHeightSW + val, posZ + 1, brightnessDownRed, brightnessDownGreen, brightnessDownBlue, u2, v2, light);
                    }
                }

                if (isTheSameFluidUp)
                {
                    shouldDownRender = false;
                }

                if (shouldUpRender)
                {
                    float minU = sprites[0].getMinU();
                    float maxU = sprites[0].getMaxU();
                    float minV = sprites[0].getMinV();
                    float maxV = sprites[0].getMaxV();
                    int light = this.getLight(world, pos.up());
                    float redBrightnessUp = brightnessUp * red;
                    float greenBrightnessUp = brightnessUp * green;
                    float blueBrightnessUp = brightnessUp * blue;
                    this.vertex(vertexConsumer, posX, posY  + 1, posZ, redBrightnessUp, greenBrightnessUp, blueBrightnessUp, minU, minV, light);
                    this.vertex(vertexConsumer, posX, posY  + 1, posZ + 1, redBrightnessUp, greenBrightnessUp, blueBrightnessUp, minU, maxV, light);
                    this.vertex(vertexConsumer, posX + 1.0, posY  + 1, posZ, redBrightnessUp, greenBrightnessUp, blueBrightnessUp, maxU, minV, light);
                    this.vertex(vertexConsumer, posX + 1.0, posY  + 1, posZ + 1, redBrightnessUp, greenBrightnessUp, blueBrightnessUp, maxU, maxV, light);
                }

                if (shouldDownRender)
                {
                    y = -0.001f;
                    float minU = sprites[1].getMinU();
                    float maxU = sprites[1].getMaxU();
                    float minV = sprites[1].getMinV();
                    float maxV = sprites[1].getMaxV();
                    int light = this.getLight(world, pos.down());
                    float redBrightnessDown = brightnessDown * red;
                    float greenBrightnessDown = brightnessDown * green;
                    float blueBrightnessDown = brightnessDown * blue;
                    this.vertex(vertexConsumer, posX, posY - y + 1, posZ, redBrightnessDown, greenBrightnessDown, blueBrightnessDown, minU, minV, light);
                    this.vertex(vertexConsumer, posX, posY - y + 1, posZ + 1, redBrightnessDown, greenBrightnessDown, blueBrightnessDown, minU, maxV, light);
                    this.vertex(vertexConsumer, posX + 1, posY - y + 1, posZ, redBrightnessDown, greenBrightnessDown, blueBrightnessDown, maxU, minV, light);
                    this.vertex(vertexConsumer, posX + 1, posY - y + 1, posZ + 1, redBrightnessDown, greenBrightnessDown, blueBrightnessDown, maxU, maxV, light);
                }
                y = shouldUpRender ? 0.001F : 0.0F;
                int light = this.getLight(world, pos);

                for (Direction direction : Direction.Type.HORIZONTAL)
                {
                    float fluidCorner;
                    float fluidMirroredCorner;
                    double posMinX;
                    double posMinZ;
                    double posMaxX;
                    double posMaxZ;
                    boolean shouldRender;
                    switch (direction)
                    {
                        case NORTH:
                            fluidCorner = fluidHeightNW;
                            fluidMirroredCorner = fluidHeightNE;
                            posMinX = posX;
                            posMaxX = posX + 1;
                            posMinZ = posZ + 0.001F;
                            posMaxZ = posMinZ;
                            shouldRender = shouldNorthRender;
                            break;
                        case SOUTH:
                            fluidCorner = fluidHeightSE;
                            fluidMirroredCorner = fluidHeightSW;
                            posMinX = posX + 1;
                            posMaxX = posX;
                            posMinZ = posZ + 1 - 0.001F;
                            posMaxZ = posMinZ;
                            shouldRender = shouldSouthRender;
                            break;
                        case WEST:
                            fluidCorner = fluidHeightSW;
                            fluidMirroredCorner = fluidHeightNW;
                            posMinX = posX + 0.001F;
                            posMaxX = posMinX;
                            posMinZ = posZ + 1;
                            posMaxZ = posZ;
                            shouldRender = shouldWestRender;
                            break;
                        default:
                            fluidCorner = fluidHeightNE;
                            fluidMirroredCorner = fluidHeightSE;
                            posMinX = posX + 1 - 0.001F;
                            posMaxX = posMinX;
                            posMinZ = posZ;
                            posMaxZ = posZ + 1;
                            shouldRender = shouldEastRender;
                    }

                    if (shouldRender && !isSideCovered(world, pos, direction, Math.max(fluidCorner, fluidMirroredCorner), world.getBlockState(pos.offset(direction))))
                    {
                        Sprite spriteFlowing = sprites[1];

                        float minU = spriteFlowing.getFrameU(0);
                        float maxU = spriteFlowing.getFrameU(8);
                        float maxVX = spriteFlowing.getFrameV((1 - fluidCorner) * 16.0F / 2);
                        float maxVZ = spriteFlowing.getFrameV((1 - fluidMirroredCorner) * 16.0F / 2);
                        float maxV = spriteFlowing.getFrameV(8);
                        float brightness = direction.getAxis() == Direction.Axis.Z ? brightnessZ : brightnessX;
                        float brightnessRed = brightnessUp * brightness * red;
                        float brightnessGreen = brightnessUp * brightness * green;
                        float brightnessBlue = brightnessUp * brightness * blue;
                        this.vertex(vertexConsumer, posMinX, posY - fluidCorner + 1, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxVX, light);
                        this.vertex(vertexConsumer, posMaxX, posY - fluidMirroredCorner + 1, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxVZ, light);
                        this.vertex(vertexConsumer, posMaxX, posY - y + 1, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxV, light);
                        this.vertex(vertexConsumer, posMinX, posY - y + 1, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxV, light);

                        this.vertex(vertexConsumer, posMinX, posY - y + 1, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxV, light);
                        this.vertex(vertexConsumer, posMaxX, posY - y + 1, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxV, light);
                        this.vertex(vertexConsumer, posMaxX, posY - fluidMirroredCorner + 1, posMaxZ, brightnessRed, brightnessGreen, brightnessBlue, maxU, maxVZ, light);
                        this.vertex(vertexConsumer, posMinX, posY - fluidCorner + 1, posMinZ, brightnessRed, brightnessGreen, brightnessBlue, minU, maxVX, light);
                    }
                }
            }
            ci.cancel();
        }
    }
    private float getUpsideDownFluidHeight(BlockRenderView world, Fluid fluid, BlockPos pos, BlockState blockState, FluidState fluidState)
    {
        if (fluid.matchesType(fluidState.getFluid()))
        {
            BlockState blockStateDown = world.getBlockState(pos.up());
            return fluid.matchesType(blockStateDown.getFluidState().getFluid()) ? fluidState.getHeight() : 1.0F;
        } else
        {
            return !blockState.isSolid() ? -1.0F : 0.0F;
        }
    }
    @Shadow
    private static boolean isSameFluid(FluidState a, FluidState b)
    {
        return b.getFluid().matchesType(a.getFluid()) ||
                (a.getFluid() == CoreAscensionFluids.FLOWING_END_GAS && b.getFluid() == CoreAscensionFluids.STILL_END_GAS) ||
                (b.getFluid() == CoreAscensionFluids.FLOWING_END_GAS && a.getFluid() == CoreAscensionFluids.STILL_END_GAS);
    }

    @Shadow
    public static boolean shouldRenderSide(BlockRenderView world, BlockPos pos, FluidState fluidState, BlockState blockState, Direction direction, FluidState neighborFluidState)
    {
        return !isOppositeSideCovered(world, pos, blockState, direction) && !isSameFluid(fluidState, neighborFluidState);
    }

    @Shadow
    private static boolean isSideCovered(BlockView world, BlockPos pos, Direction direction, float maxDeviation, BlockState state)
    {
        return isSideCovered(world, direction, maxDeviation, pos.offset(direction), state);
    }

    @Shadow
    protected abstract float calculateFluidHeight(BlockRenderView world, Fluid fluid, float originHeight, float northSouthHeight, float eastWestHeight, BlockPos pos);

    @Shadow
    protected abstract int getLight(BlockRenderView world, BlockPos pos);

    @Shadow
    protected abstract void vertex(VertexConsumer vertexConsumer, double x, double y, double z, float red, float green, float blue, float u, float v, int light);

    @Shadow
    private static boolean isOppositeSideCovered(BlockView world, BlockPos pos, BlockState state, Direction direction)
    {
        return isSideCovered(world, direction.getOpposite(), 1.0F, pos, state);
    }

    @Shadow
    private static boolean isSideCovered(BlockView world, Direction direction, float height, BlockPos pos, BlockState state)
    {
        if (state.isOpaque())
        {
            VoxelShape voxelShape = VoxelShapes.cuboid(0.0, 0, 0.0, 1.0, height, 1.0);
            VoxelShape voxelShape2 = state.getCullingShape(world, pos);
            return VoxelShapes.isSideCovered(voxelShape, voxelShape2, direction);
        } else
        {
            return false;
        }
    }
}
