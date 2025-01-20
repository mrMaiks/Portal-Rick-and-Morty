
package net.mcreator.rick_and_morty.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.rick_and_morty.procedures.If9Procedure;
import net.mcreator.rick_and_morty.procedures.If8Procedure;
import net.mcreator.rick_and_morty.procedures.If7Procedure;
import net.mcreator.rick_and_morty.procedures.If6Procedure;
import net.mcreator.rick_and_morty.procedures.If5Procedure;
import net.mcreator.rick_and_morty.procedures.If4Procedure;
import net.mcreator.rick_and_morty.procedures.If3Procedure;
import net.mcreator.rick_and_morty.procedures.If2Procedure;
import net.mcreator.rick_and_morty.procedures.If1Procedure;
import net.mcreator.rick_and_morty.procedures.If10Procedure;
import net.mcreator.rick_and_morty.procedures.GuiProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class EnergyportalgunOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (GuiProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/empty.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If1Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/1.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If2Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/2.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If3Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/3.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If4Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/4.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If5Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/5.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If6Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/6.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If7Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/7.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If8Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/8.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If9Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/9.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
			if (If10Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/10.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -206, posY + 69, 0, 0, 24, 42, 24, 42);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
