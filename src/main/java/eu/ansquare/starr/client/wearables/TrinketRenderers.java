package eu.ansquare.starr.client.wearables;

import com.mojang.blaze3d.platform.GlStateManager;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import eu.ansquare.starr.client.wearables.model.CapeWearableModel;
import eu.ansquare.starr.items.CapeItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class TrinketRenderers {
	public static void registerCapeRenderer(CapeItem item){
		TrinketRendererRegistry.registerRenderer(item, new TrinketRenderer() {
			private Model model = null;
			@Override
			public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
				if (model == null) {
					model = new CapeWearableModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(CapeWearableModel.LAYER_LOCATION));
				} else if (!entity.isInvisible()) {
					matrices.push();
					model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(item.getTexture())), light, OverlayTexture.DEFAULT_UV, 1f, 1f, 1f, 1f);
					matrices.pop();
				}
			}
		});
	}
}
