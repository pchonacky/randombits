package net.chonacky.minecraft.mod.chicken_mod;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityProtoChicken extends EntityChicken 
{

	public EntityProtoChicken(World worldIn) {
		super(worldIn);

		this.setSize(2.5F, 5.0F);
		
		//TODO - Fix this bounding box
//		this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0, 0, 25));
		this.stepHeight = 2.1F;
//		this.jumpPower = 0.0F;
//		this.isJumping = false;
	}
	
	@Override
	public float getEyeHeight() {
	
		return super.getEyeHeight()-0.5F;
	}

	
	@Override
	public void livingTick()
	    {
	        super.livingTick();
	        if (this.world.isRemote && this.dataManager.isDirty())  {
	            this.dataManager.setClean();
	        }
	    }
	
	@Override 
    public boolean processInteract(EntityPlayer player, EnumHand hand)
	    {
		 this.mountTo(player);
		 super.processInteract(player, hand);
		 return true;
	    }
	
	 
	protected void mountTo(EntityPlayer player)
	    {
	        player.rotationYaw = this.rotationYaw;
	        player.rotationPitch = this.rotationPitch;
	        if (!this.world.isRemote)  player.startRiding(this);
	    }

	@Override
	 public void updatePassenger(Entity passenger)
	    {
	        super.updatePassenger(passenger);
	        float f = MathHelper.sin(this.renderYawOffset * 0.017453292F);
	        float f1 = MathHelper.cos(this.renderYawOffset * 0.017453292F);
//unused	float f2 = 0.1F;
//unused	float f3 = 0.0F;
	        passenger.setPosition(
	        		this.posX + (double)(0.1F * f),
	        		this.posY + (double)(this.height * 0.35F) + passenger.getYOffset() + 0.0D,
	        		this.posZ - (double)(0.1F * f1)													);
	        if (passenger instanceof EntityLivingBase)	((EntityLivingBase)passenger).renderYawOffset = this.renderYawOffset;
	    }

	 

	@Override
	public void travel(float strafe, float vertical, float forward)
	    {	
	        if (this.isBeingRidden() && this.canBeSteered() )	{
	        										//&& this.isHorseSaddled()
	            EntityLivingBase controllingPassenger = (EntityLivingBase)this.getControllingPassenger();
	            this.rotationYaw = controllingPassenger.rotationYaw;
	            this.prevRotationYaw = this.rotationYaw;
	            this.rotationPitch = controllingPassenger.rotationPitch * 0.5F;
	            this.setRotation(this.rotationYaw, this.rotationPitch);
	            this.renderYawOffset = this.rotationYaw;
	            this.rotationYawHead = this.renderYawOffset;
	            strafe = controllingPassenger.moveStrafing * 0.5F;
	            forward = controllingPassenger.moveForward;
	            if (forward <= 0.0F) forward *= 0.25F; 
	            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
	            if (this.canPassengerSteer()) {
	                this.setAIMoveSpeed((float)this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
	                super.travel(strafe, vertical, forward);
	            }
	            else if (controllingPassenger instanceof EntityPlayer)  {
	                this.motionX = 0.0D;
	                this.motionY = 0.0D;
	                this.motionZ = 0.0D;
	            }
	            if (this.onGround)	 this.isJumping = false;
	        }
	        else {
	            this.jumpMovementFactor = 0.02F;
	            super.travel(strafe, vertical, forward);
	        }   
	    }

	@Override    
	public boolean canBeSteered()  
		{
	        return this.getControllingPassenger() instanceof EntityLivingBase;
	    }    
	    
	@Override @Nullable
    public Entity getControllingPassenger()
	    {
	        return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
	    }

}
