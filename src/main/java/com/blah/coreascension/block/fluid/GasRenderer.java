package com.blah.coreascension.block.fluid;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.WorldRenderer;
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

@Environment(EnvType.CLIENT)
public class GasRenderer extends FluidRenderer
{
    private final Sprite[] gasSprites = new Sprite[2];

    protected void onResourceReload() {
        this.gasSprites[0] = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(Blocks.LAVA.getDefaultState()).getParticleSprite();
        this.gasSprites[1] = MinecraftClient.getInstance().getBakedModelManager().getBlockModels().getModel(CoreAscensionBlocks.FLOWING_END_GAS.getDefaultState().getBlockState()).getParticleSprite();
    }

    @Override
    public void render(BlockRenderView world, BlockPos pos, VertexConsumer vertexConsumer, BlockState blockState, FluidState fluidState) {
        Sprite[] sprites = this.gasSprites;
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
        boolean bl2 = !isSameFluid(fluidState, downFS);
        boolean bl3 = shouldRenderSide(world, pos, fluidState, blockState, Direction.UP, upFS)
                && !isSideCovered(world, pos, Direction.UP, 0.8888889F, upBS);
        boolean bl4 = shouldRenderSide(world, pos, fluidState, blockState, Direction.NORTH, northFS);
        boolean bl5 = shouldRenderSide(world, pos, fluidState, blockState, Direction.SOUTH, southFS);
        boolean bl6 = shouldRenderSide(world, pos, fluidState, blockState, Direction.WEST, westFS);
        boolean bl7 = shouldRenderSide(world, pos, fluidState, blockState, Direction.EAST, eastFS);
        if (bl2 || bl3 || bl7 || bl6 || bl4 || bl5) {
            float j = world.getBrightness(Direction.DOWN, true);
            float k = world.getBrightness(Direction.UP, true);
            float l = world.getBrightness(Direction.NORTH, true);
            float m = world.getBrightness(Direction.WEST, true);
            Fluid fluid = fluidState.getFluid();
            float n = this.getFluidHeight(world, fluid, pos, blockState, fluidState);
            float o;
            float p;
            float q;
            float r;
            if (n >= 1.0F) {
                o = 1.0F;
                p = 1.0F;
                q = 1.0F;
                r = 1.0F;
            } else {
                float s = this.getFluidHeight(world, fluid, pos.north(), northBS, northFS);
                float t = this.getFluidHeight(world, fluid, pos.south(), southBS, southFS);
                float u = this.getFluidHeight(world, fluid, pos.east(), eastBS, eastFS);
                float v = this.getFluidHeight(world, fluid, pos.west(), westBS, westFS);
                o = this.calculateFluidHeight(world, fluid, n, s, u, pos.offset(Direction.NORTH).offset(Direction.EAST));
                p = this.calculateFluidHeight(world, fluid, n, s, v, pos.offset(Direction.NORTH).offset(Direction.WEST));
                q = this.calculateFluidHeight(world, fluid, n, t, u, pos.offset(Direction.SOUTH).offset(Direction.EAST));
                r = this.calculateFluidHeight(world, fluid, n, t, v, pos.offset(Direction.SOUTH).offset(Direction.WEST));
            }

            double d = (double)(pos.getX() & 15);
            double e = (double)(pos.getY() & 15);
            double w = (double)(pos.getZ() & 15);
            float x = 0.001F;
            float y = bl3 ? 0.001F : 0.0F;
            if (bl2 && !isSideCovered(world, pos, Direction.DOWN, Math.min(Math.min(p, r), Math.min(q, o)), downBS)) {
                p -= 0.001F;
                r -= 0.001F;
                q -= 0.001F;
                o -= 0.001F;
                Vec3d vec3d = fluidState.getVelocity(world, pos);
                float z;
                float ab;
                float ad;
                float af;
                float aa;
                float ac;
                float ae;
                float ag;
                if (vec3d.x == 0.0 && vec3d.z == 0.0) {
                    Sprite sprite = sprites[0];
                    z = sprite.getFrameU(0.0);
                    aa = sprite.getFrameV(0.0);
                    ab = z;
                    ac = sprite.getFrameV(16.0);
                    ad = sprite.getFrameU(16.0);
                    ae = ac;
                    af = ad;
                    ag = aa;
                } else {
                    Sprite sprite = sprites[1];
                    float ah = (float) MathHelper.atan2(vec3d.z, vec3d.x) - (float) (Math.PI / 2);
                    float ai = MathHelper.sin(ah) * 0.25F;
                    float aj = MathHelper.cos(ah) * 0.25F;
                    float ak = 8.0F;
                    z = sprite.getFrameU((double)(8.0F + (-aj - ai) * 16.0F));
                    aa = sprite.getFrameV((double)(8.0F + (-aj + ai) * 16.0F));
                    ab = sprite.getFrameU((double)(8.0F + (-aj + ai) * 16.0F));
                    ac = sprite.getFrameV((double)(8.0F + (aj + ai) * 16.0F));
                    ad = sprite.getFrameU((double)(8.0F + (aj + ai) * 16.0F));
                    ae = sprite.getFrameV((double)(8.0F + (aj - ai) * 16.0F));
                    af = sprite.getFrameU((double)(8.0F + (aj - ai) * 16.0F));
                    ag = sprite.getFrameV((double)(8.0F + (-aj - ai) * 16.0F));
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
                float ak = k * f;
                float an = k * g;
                float ao = k * h;
                this.vertex(vertexConsumer, d + 0.0, e + (double)p, w + 0.0, ak, an, ao, z, aa, am);
                this.vertex(vertexConsumer, d + 0.0, e + (double)r, w + 1.0, ak, an, ao, ab, ac, am);
                this.vertex(vertexConsumer, d + 1.0, e + (double)q, w + 1.0, ak, an, ao, ad, ae, am);
                this.vertex(vertexConsumer, d + 1.0, e + (double)o, w + 0.0, ak, an, ao, af, ag, am);
                if (fluidState.canFlowTo(world, pos.down())) {
                    this.vertex(vertexConsumer, d + 0.0, e + (double)p, w + 0.0, ak, an, ao, z, aa, am);
                    this.vertex(vertexConsumer, d + 1.0, e + (double)o, w + 0.0, ak, an, ao, af, ag, am);
                    this.vertex(vertexConsumer, d + 1.0, e + (double)q, w + 1.0, ak, an, ao, ad, ae, am);
                    this.vertex(vertexConsumer, d + 0.0, e + (double)r, w + 1.0, ak, an, ao, ab, ac, am);
                }
            }

            if (bl3) {
                float zx = sprites[0].getMinU();
                float abx = sprites[0].getMaxU();
                float adx = sprites[0].getMinV();
                float afx = sprites[0].getMaxV();
                int ap = this.getLight(world, pos.up());
                float acx = j * f;
                float aex = j * g;
                float agx = j * h;
                this.vertex(vertexConsumer, d, e + (double)y, w + 1.0, acx, aex, agx, zx, afx, ap);
                this.vertex(vertexConsumer, d, e + (double)y, w, acx, aex, agx, zx, adx, ap);
                this.vertex(vertexConsumer, d + 1.0, e + (double)y, w, acx, aex, agx, abx, adx, ap);
                this.vertex(vertexConsumer, d + 1.0, e + (double)y, w + 1.0, acx, aex, agx, abx, afx, ap);
            }

            int aq = this.getLight(world, pos);

            for (Direction direction : Direction.Type.HORIZONTAL) {
                float afx;
                float aax;
                double ar;
                double at;
                double as;
                double au;
                boolean bl8;
                switch (direction) {
                    case NORTH:
                        afx = p;
                        aax = o;
                        ar = d;
                        as = d + 1.0;
                        at = w + 0.001F;
                        au = w + 0.001F;
                        bl8 = bl4;
                        break;
                    case SOUTH:
                        afx = q;
                        aax = r;
                        ar = d + 1.0;
                        as = d;
                        at = w + 1.0 - 0.001F;
                        au = w + 1.0 - 0.001F;
                        bl8 = bl5;
                        break;
                    case WEST:
                        afx = r;
                        aax = p;
                        ar = d + 0.001F;
                        as = d + 0.001F;
                        at = w + 1.0;
                        au = w;
                        bl8 = bl6;
                        break;
                    default:
                        afx = o;
                        aax = q;
                        ar = d + 1.0 - 0.001F;
                        as = d + 1.0 - 0.001F;
                        at = w;
                        au = w + 1.0;
                        bl8 = bl7;
                }

                if (bl8 && !isSideCovered(world, pos, direction, Math.max(afx, aax), world.getBlockState(pos.offset(direction)))) {
                    BlockPos blockPos = pos.offset(direction);
                    Sprite sprite2 = sprites[1];

                    float av = sprite2.getFrameU(0.0);
                    float aw = sprite2.getFrameU(8.0);
                    float ax = sprite2.getFrameV((double)((1.0F - afx) * 16.0F * 0.5F));
                    float ay = sprite2.getFrameV((double)((1.0F - aax) * 16.0F * 0.5F));
                    float az = sprite2.getFrameV(8.0);
                    float ba = direction.getAxis() == Direction.Axis.Z ? l : m;
                    float bb = k * ba * f;
                    float bc = k * ba * g;
                    float bd = k * ba * h;
                    this.vertex(vertexConsumer, ar, e + (double)afx, at, bb, bc, bd, av, ax, aq);
                    this.vertex(vertexConsumer, as, e + (double)aax, au, bb, bc, bd, aw, ay, aq);
                    this.vertex(vertexConsumer, as, e + (double)y, au, bb, bc, bd, aw, az, aq);
                    this.vertex(vertexConsumer, ar, e + (double)y, at, bb, bc, bd, av, az, aq);

                        this.vertex(vertexConsumer, ar, e + (double)y, at, bb, bc, bd, av, az, aq);
                        this.vertex(vertexConsumer, as, e + (double)y, au, bb, bc, bd, aw, az, aq);
                        this.vertex(vertexConsumer, as, e + (double)aax, au, bb, bc, bd, aw, ay, aq);
                        this.vertex(vertexConsumer, ar, e + (double)afx, at, bb, bc, bd, av, ax, aq);
                }
            }
        }
    }
    private static boolean isSameFluid(FluidState a, FluidState b) {
        return b.getFluid().matchesType(a.getFluid());
    }

    private static boolean isSideCovered(BlockView world, Direction direction, float height, BlockPos pos, BlockState state) {
        if (state.isOpaque()) {
            VoxelShape voxelShape = VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, (double)height, 1.0);
            VoxelShape voxelShape2 = state.getCullingShape(world, pos);
            return VoxelShapes.isSideCovered(voxelShape, voxelShape2, direction);
        } else {
            return false;
        }
    }

    private static boolean isSideCovered(BlockView world, BlockPos pos, Direction direction, float maxDeviation, BlockState state) {
        return isSideCovered(world, direction, maxDeviation, pos.offset(direction), state);
    }

    private static boolean isOppositeSideCovered(BlockView world, BlockPos pos, BlockState state, Direction direction) {
        return isSideCovered(world, direction.getOpposite(), 1.0F, pos, state);
    }

    public static boolean shouldRenderSide(
            BlockRenderView world, BlockPos pos, FluidState fluidState, BlockState blockState, Direction direction, FluidState neighborFluidState
    ) {
        return !isOppositeSideCovered(world, pos, blockState, direction) && !isSameFluid(fluidState, neighborFluidState);
    }

    private float getFluidHeight(BlockRenderView world, Fluid fluid, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return this.getFluidHeight(world, fluid, pos, blockState, blockState.getFluidState());
    }

    private float getFluidHeight(BlockRenderView world, Fluid fluid, BlockPos pos, BlockState blockState, FluidState fluidState) {
        if (fluid.matchesType(fluidState.getFluid())) {
            BlockState blockState2 = world.getBlockState(pos.down());
            return fluid.matchesType(blockState2.getFluidState().getFluid()) ? 1.0F : fluidState.getHeight();
        } else {
            return !blockState.isSolid() ? 0.0F : -1.0F;
        }
    }
    private void vertex(VertexConsumer vertexConsumer, double x, double y, double z, float red, float green, float blue, float u, float v, int light) {
        vertexConsumer.vertex(x, y, z).color(red, green, blue, 1.0F).texture(u, v).light(light).normal(0.0F, -1.0F, 0.0F).next();
    }

    private int getLight(BlockRenderView world, BlockPos pos) {
        int i = WorldRenderer.getLightmapCoordinates(world, pos);
        int j = WorldRenderer.getLightmapCoordinates(world, pos.up());
        int k = i & (LightmapTextureManager.MAX_BLOCK_LIGHT_COORDINATE | 15);
        int l = j & (LightmapTextureManager.MAX_BLOCK_LIGHT_COORDINATE | 15);
        int m = i >> 16 & (LightmapTextureManager.MAX_BLOCK_LIGHT_COORDINATE | 15);
        int n = j >> 16 & (LightmapTextureManager.MAX_BLOCK_LIGHT_COORDINATE | 15);
        return (Math.max(k, l)) | (Math.max(m, n)) << 16;
    }

    private float calculateFluidHeight(BlockRenderView world, Fluid fluid, float originHeight, float northSouthHeight, float eastWestHeight, BlockPos pos) {
        if (!(eastWestHeight >= 1.0F) && !(northSouthHeight >= 1.0F)) {
            float[] fs = new float[2];
            if (eastWestHeight > 0.0F || northSouthHeight > 0.0F) {
                float f = this.getFluidHeight(world, fluid, pos);
                if (f >= 1.0F) {
                    return 1.0F;
                }

                this.addHeight(fs, f);
            }

            this.addHeight(fs, originHeight);
            this.addHeight(fs, eastWestHeight);
            this.addHeight(fs, northSouthHeight);
            return fs[0] / fs[1];
        } else {
            return 1.0F;
        }
    }
    private void addHeight(float[] weightedAverageHeight, float height) {
        if (height >= 0.8F) {
            weightedAverageHeight[0] += height * 10.0F;
            weightedAverageHeight[1] += 10.0F;
        } else if (height >= 0.0F) {
            weightedAverageHeight[0] += height;
            weightedAverageHeight[1]++;
        }
    }
}
