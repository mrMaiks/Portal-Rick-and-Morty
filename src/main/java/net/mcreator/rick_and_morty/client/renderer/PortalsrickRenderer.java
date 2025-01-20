
package net.mcreator.rick_and_morty.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.rick_and_morty.entity.PortalsrickEntity;
import net.mcreator.rick_and_morty.client.model.Modelportal_rick;

public class PortalsrickRenderer extends MobRenderer<PortalsrickEntity, Modelportal_rick<PortalsrickEntity>> {
	public PortalsrickRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelportal_rick(context.bakeLayer(Modelportal_rick.LAYER_LOCATION)), 0f);
		this.addLayer(new EyesLayer<PortalsrickEntity, Modelportal_rick<PortalsrickEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("rick_and_morty:textures/entities/portal.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PortalsrickEntity entity) {
		return new ResourceLocation("rick_and_morty:textures/entities/portal.png");
	}
}
