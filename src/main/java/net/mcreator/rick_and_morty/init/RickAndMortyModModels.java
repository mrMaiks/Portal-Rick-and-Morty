
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rick_and_morty.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.rick_and_morty.client.model.Modelportal_rick;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class RickAndMortyModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelportal_rick.LAYER_LOCATION, Modelportal_rick::createBodyLayer);
	}
}
