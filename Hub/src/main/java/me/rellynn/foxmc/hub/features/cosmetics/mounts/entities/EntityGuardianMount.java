package me.rellynn.foxmc.hub.features.cosmetics.mounts.entities;

import me.rellynn.foxmc.bukkitapi.utils.Reflection;
import net.minecraft.server.v1_8_R3.*;

/**
 * Created by gwennaelguich on 20/06/2017.
 * FoxMC Network.
 */
public class EntityGuardianMount extends EntityGuardian {
    private static final Reflection.FieldAccessor<Boolean> JUMP_FIELD = Reflection.getField(EntityLiving.class, "aY", boolean.class);

    public EntityGuardianMount(World world) {
        super(world);
    }

    @Override
    public void g(float sideMot, float forMot) {
        if (!(this.passenger instanceof EntityHuman)) {
            die();
        } else {
            this.lastYaw = this.yaw = this.passenger.yaw;
            this.pitch = this.passenger.pitch * 0.5F;
            this.setYawPitch(this.yaw, this.pitch);
            this.aK = this.aI = this.yaw;
            this.S = 1.0F;
            sideMot = ((EntityLiving) this.passenger).aZ * 0.5F;
            forMot = ((EntityLiving) this.passenger).ba;
            if (forMot <= 0.0F) {
                forMot *= 0.25F;
            }
            sideMot *= 0.75F;
            this.k(0.2F);
            this.onGround = true; // Fake onGround
            super.g(sideMot, forMot);
            // Y (up/down)
            boolean isJumping = JUMP_FIELD.get(this.passenger);
            boolean isSneaking = this.getBukkitEntity().hasMetadata("MOUNT_DOWN");
            if (isSneaking && !isJumping) {
                this.motY = -0.5D;
            } else if (isJumping && !isSneaking) {
                this.motY = 0.5D;
            } else {
                this.motY = 0.0D;
            }
        }
    }

    /*
    Mounts should not be stored to wold save files
     */
    @Override
    public void b(NBTTagCompound nbttagcompound) {}

    @Override
    public boolean c(NBTTagCompound nbttagcompound) { return false; }

    @Override
    public void a(NBTTagCompound nbttagcompound) {}

    @Override
    public boolean d(NBTTagCompound nbttagcompound) { return false; }

    @Override
    public void e(NBTTagCompound nbttagcompound) {}
}
