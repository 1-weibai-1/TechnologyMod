// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltiger<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "tiger"), "main");
	private final ModelPart hat;
	private final ModelPart arm1;
	private final ModelPart arm2;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart head;
	private final ModelPart weiba;

	public Modeltiger(ModelPart root) {
		this.hat = root.getChild("hat");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.head = root.getChild("head");
		this.weiba = root.getChild("weiba");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 34)
				.addBox(-4.0F, -4.0F, -6.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(42, 58).mirror()
				.addBox(-3.0F, 3.0F, -5.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 15)
				.mirror().addBox(-4.0F, -6.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 17).mirror().addBox(-3.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(2, 17).addBox(2.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 15).addBox(3.0F, -6.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(43, 13)
				.addBox(-2.0F, -1.0F, -9.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
				.addBox(-2.5F, 2.0F, -8.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1).addBox(1.5F,
						2.0F, -8.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 5.0F, -11.0F));

		PartDefinition cube_r1 = hat
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(9, 15).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(5.0F, 3.0F, -4.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = hat.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(9, 15).mirror()
						.addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.0F, 3.0F, -4.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(0, 48).mirror()
				.addBox(-2.0F, 0.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 56)
				.mirror().addBox(-2.0F, 9.0F, -3.5F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-3.5F, 12.5F, -7.6F));

		PartDefinition arm2 = partdefinition.addOrReplaceChild("arm2",
				CubeListBuilder.create().texOffs(0, 48)
						.addBox(-2.0F, 0.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
						.addBox(-2.0F, 9.0F, -3.5F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.5F, 12.5F, -7.6F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 48).mirror()
				.addBox(-2.0F, 0.5F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 56)
				.mirror().addBox(-2.0F, 9.5F, -3.5F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-3.5F, 12.5F, 8.5F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(0, 48)
						.addBox(-2.0F, 0.5F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
						.addBox(-2.0F, 9.5F, -3.5F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.5F, 12.5F, 8.5F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-5.0F, -6.0F, -11.0F, 10.0F, 8.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(12, 8)
				.addBox(5.0F, -2.0F, -9.0F, 1.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(12, 8).mirror()
				.addBox(-6.0F, -2.0F, -9.0F, 1.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(16, 12)
				.mirror().addBox(-6.0F, -5.0F, -7.0F, 1.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 12).addBox(5.0F, -5.0F, -7.0F, 1.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(15, 15).addBox(-5.0F, 2.0F, -3.0F, 10.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(15, 23).addBox(-5.0F, 2.0F, -10.0F, 10.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(30, 23).mirror().addBox(-5.0F, 2.0F, 4.0F, 10.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(5, 5).addBox(-5.0F, -7.0F, -8.0F, 10.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition weiba = partdefinition.addOrReplaceChild("weiba", CubeListBuilder.create(),
				PartPose.offset(0.0F, 4.3F, 11.0F));

		PartDefinition cube_r3 = weiba.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(31, 35).addBox(0.0F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.0F, -1.5708F, -3.1416F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		hat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		weiba.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.weiba.zRot = (Mth.sin(ageInTicks * 0.2F + 2) * 0.1F);
		this.arm1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.hat.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.hat.xRot = headPitch / (180F / (float) Math.PI);
		this.arm2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}