package net.mcreator.rick_and_morty.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import net.mcreator.rick_and_morty.world.inventory.PortalguiMenu;
import net.mcreator.rick_and_morty.network.PortalguiButtonMessage;
import net.mcreator.rick_and_morty.RickAndMortyMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PortalguiScreen extends AbstractContainerScreen<PortalguiMenu> {
	private final static HashMap<String, Object> guistate = PortalguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox dimension;
	EditBox XYZ;
	ImageButton imagebutton_portal_gui_button;

	public PortalguiScreen(PortalguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 188;
		this.imageHeight = 166;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		dimension.render(ms, mouseX, mouseY, partialTicks);
		XYZ.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("rick_and_morty:textures/screens/portal_gui.png"));
		this.blit(ms, this.leftPos + -119, this.topPos + -47, 0, 0, 426, 250, 426, 250);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (dimension.isFocused())
			return dimension.keyPressed(key, b, c);
		if (XYZ.isFocused())
			return XYZ.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		dimension.tick();
		XYZ.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		dimension = new EditBox(this.font, this.leftPos + 33, this.topPos + 97, 120, 20, Component.translatable("gui.rick_and_morty.portalgui.dimension")) {
			{
				setSuggestion(Component.translatable("gui.rick_and_morty.portalgui.dimension").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.rick_and_morty.portalgui.dimension").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.rick_and_morty.portalgui.dimension").getString());
				else
					setSuggestion(null);
			}
		};
		dimension.setMaxLength(32767);
		guistate.put("text:dimension", dimension);
		this.addWidget(this.dimension);
		XYZ = new EditBox(this.font, this.leftPos + 33, this.topPos + 120, 120, 20, Component.translatable("gui.rick_and_morty.portalgui.XYZ")) {
			{
				setSuggestion(Component.translatable("gui.rick_and_morty.portalgui.XYZ").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.rick_and_morty.portalgui.XYZ").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.rick_and_morty.portalgui.XYZ").getString());
				else
					setSuggestion(null);
			}
		};
		XYZ.setMaxLength(32767);
		guistate.put("text:XYZ", XYZ);
		this.addWidget(this.XYZ);
		imagebutton_portal_gui_button = new ImageButton(this.leftPos + 67, this.topPos + 148, 50, 50, 0, 0, 50, new ResourceLocation("rick_and_morty:textures/screens/atlas/imagebutton_portal_gui_button.png"), 50, 100, e -> {
			if (true) {
				RickAndMortyMod.PACKET_HANDLER.sendToServer(new PortalguiButtonMessage(0, x, y, z));
				PortalguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_portal_gui_button", imagebutton_portal_gui_button);
		this.addRenderableWidget(imagebutton_portal_gui_button);
	}
}
