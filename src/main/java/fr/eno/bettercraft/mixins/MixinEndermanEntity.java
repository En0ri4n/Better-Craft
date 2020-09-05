package fr.eno.bettercraft.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import fr.eno.bettercraft.entity.ai.goal.HeadPanicGoal;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.item.Items;

@Mixin(EndermanEntity.class)
public class MixinEndermanEntity
{
	@Inject(at = @At("HEAD"), method = "registerGoals", remap = true, cancellable = false)
	public void registerEndermanGoals(CallbackInfo info)
	{
		EndermanEntity entity = (EndermanEntity) (Object) this;
		
		entity.goalSelector.addGoal(0, new HeadPanicGoal(entity, 1D, Items.DRAGON_HEAD));
	}
}