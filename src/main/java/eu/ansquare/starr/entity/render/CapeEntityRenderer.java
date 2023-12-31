package eu.ansquare.starr.entity.render;

import eu.ansquare.starr.StarR;
import eu.ansquare.starr.client.StarRClient;
import eu.ansquare.starr.entity.CapeEntity;
import eu.ansquare.starr.entity.model.CapeEntityModel;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class CapeEntityRenderer extends EntityRenderer<CapeEntity> {
	public CapeEntityRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	public Identifier getTexture(CapeEntity entity) {
		return new Identifier(StarR.MODID, "textures/entity/cape/cape.png");
	}
}
