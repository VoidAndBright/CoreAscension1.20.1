package com.blah.coreascension.mixin;

import com.blah.coreascension.damage.CoreAscensionDamageTypes;
import com.blah.coreascension.utils.CoreAscensionTags;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class BreathingMixin
{
    @WrapMethod(method = "getNextAirOnLand")
    private int getNextAirOnLand(int air, Operation<Integer> original)
    {
        LivingEntity living = (LivingEntity)(Object)this;
        if (living.isAlive() && living.isSubmergedIn(CoreAscensionTags.END_GAS))
        {
            return living.getAir();
        }
        return original.call(air);
    }

    @Shadow protected abstract int getNextAirUnderwater(int air);

    @Inject(method = "baseTick", at = @At(value = "TAIL"))
    private void endGasBreathMeter(CallbackInfo ci)
    {
        LivingEntity living = (LivingEntity)(Object)this;
        if (living.isAlive())
        {
            boolean bl = living instanceof PlayerEntity;
            if (living.isSubmergedIn(CoreAscensionTags.END_GAS))
            {
                boolean bl2 = !living.canBreatheInWater() && !StatusEffectUtil.hasWaterBreathing(living) && (!bl || !((PlayerEntity)living).getAbilities().invulnerable);
                if (bl2)
                {
                    living.setAir(getNextAirUnderwater(living.getAir()));
                    if (living.getAir() == -20)
                    {
                        living.setAir(0);
                        Vec3d vec3d = living.getVelocity();

                        for(int i = 0; i < 8; ++i)
                        {
                            double f = living.getRandom().nextDouble() - living.getRandom().nextDouble();
                            double g = living.getRandom().nextDouble() - living.getRandom().nextDouble();
                            double h = living.getRandom().nextDouble() - living.getRandom().nextDouble();
                            living.getWorld().addParticle(ParticleTypes.BUBBLE, living.getX() + f, living.getY() + g, living.getZ() + h, vec3d.x, vec3d.y, vec3d.z);
                        }

                        living.damage(CoreAscensionDamageTypes.of(living.getWorld(), CoreAscensionDamageTypes.END_GAS_SUFFOCATION), 2.0F);
                    }
                }

                if (!living.getWorld().isClient && living.hasVehicle() && living.getVehicle() != null && living.getVehicle().shouldDismountUnderwater()) {
                    living.stopRiding();
                }
            }
        }
    }
}
