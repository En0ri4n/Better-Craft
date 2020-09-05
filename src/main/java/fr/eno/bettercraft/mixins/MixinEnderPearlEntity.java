package fr.eno.bettercraft.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;

@Mixin(EnderPearlEntity.class)
public class MixinEnderPearlEntity
{
	@Inject(at = @At("HEAD"), method = "onImpact", remap = true, cancellable = false)
	public void onEnderPearlImpact(RayTraceResult result, CallbackInfo info)
	{
		EnderPearlEntity pearl = (EnderPearlEntity) (Object) this;

		LivingEntity thrower = pearl.getThrower();
		
		if (result.getType() == RayTraceResult.Type.ENTITY)
		{
			Entity entity = ((EntityRayTraceResult) result).getEntity();
			
			if (entity instanceof AbstractArrowEntity)
			{
				AbstractArrowEntity arrow = (AbstractArrowEntity) entity;
				thrower.attackEntityFrom(DamageSource.causeArrowDamage(arrow, arrow.getShooter()), 2F);
				pearl.remove();
				arrow.remove();
				return;
			}
		}
	}
}
