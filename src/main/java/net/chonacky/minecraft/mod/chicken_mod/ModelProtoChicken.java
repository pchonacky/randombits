package net.chonacky.minecraft.mod.chicken_mod;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelProtoChicken extends ModelBase
{
    
	public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
    public ModelRenderer rightShin;
    public ModelRenderer leftShin;
    public ModelRenderer leftFoot;
    public ModelRenderer rightFoot;


    public ModelProtoChicken()
    {
    	
       this.textureWidth = 132;
       this.textureHeight = 64;
       
    	
    	this.head = new ModelRenderer(this, 0, 16);
        this.head.addBox(-8.0F, -8.0F, -8.0F, 16, 8, 16, 5.0F); 
        this.head.setRotationPoint(0.0F, -42.0F, 0.0F);

        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-16.0F, -16.0F, -16.0F, 32, 32, 32, 5.0F); 
        this.body.setRotationPoint(0.0F, -23.0F, 0.0F);

       this.leftLeg = new ModelRenderer(this, 128,32);
       this.leftLeg.addBox(0.0F, 0.5F, 0.0F, 1, 13, 1 , 3.0F); 
       this.leftLeg.setRotationPoint(20.0F, 0.0F, -24.0F);
       this.body.addChild(this.leftLeg);

       this.leftShin = new ModelRenderer(this, 128,32);
       this.leftShin.addBox(0.0F, -0.5F, 0.0F, 1, 13, 1, 3.0F); 
       this.leftShin.setRotationPoint(0.0F, 12.0F, 0.0F);
       this.leftLeg.addChild(this.leftShin);
       
       this.leftFoot = new ModelRenderer(this,128,32);
       this.leftFoot.addBox(0.0F, 1.0F, -0.0F, 1, 4, 1, 3.0F);
       this.leftFoot.setRotationPoint(0.0F, 14.0F, 0.0F);
       this.leftShin.addChild(this.leftFoot);
       

       this.rightLeg = new ModelRenderer(this, 128,32);
       this.rightLeg.addBox(0.0F, 0.5F, 0.0F, 1, 13, 1 , 3.0F); 
       this.rightLeg.setRotationPoint(-20.0F, 0.0F, -24.0F);
       this.body.addChild(this.rightLeg);

       this.rightShin = new ModelRenderer(this, 128,32);
       this.rightShin.addBox(0.0F, -0.5F, 0.0F, 1, 13, 1, 3.0F); 
       this.rightShin.setRotationPoint(0.0F, 12.0F, 0.0F);
       this.rightLeg.addChild(this.rightShin);
      
       this.rightFoot = new ModelRenderer(this,128,32);
       this.rightFoot.addBox(0.0F, 1.0F, -0.0F, 1, 4, 1, 3.0F);
       this.rightFoot.setRotationPoint(0.0F, 14.0F, 0.0F);
       this.rightShin.addChild(this.rightFoot);
      
//        

    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.head.render(scale);
        this.body.render(scale);   
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leftLeg.rotateAngleX =  (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/4);
        this.leftShin.rotateAngleX = -(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/2);
        this.leftFoot.rotateAngleX = -((float)Math.PI/4) ;
        this.rightLeg.rotateAngleX =  -(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/4);
        this.rightShin.rotateAngleX = +(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) -((float)Math.PI/2);
        this.rightFoot.rotateAngleX = -((float)Math.PI/4) ;
//        this.rightWing.rotateAngleZ = ageInTicks;
//        this.leftWing.rotateAngleZ = -ageInTicks;
    }
}