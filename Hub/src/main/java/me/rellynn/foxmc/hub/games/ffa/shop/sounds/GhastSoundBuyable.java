package me.rellynn.foxmc.hub.games.ffa.shop.sounds;

import me.rellynn.foxmc.hub.shops.LevelInfoBuyable;
import me.rellynn.foxmc.hub.shops.items.ItemBuyableOnceEquippable;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.SpawnEgg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static me.rellynn.foxmc.hub.shops.Currency.COINS;

/**
 * Created by gwennaelguich on 19/08/2017.
 * FoxMC Network.
 */
public class GhastSoundBuyable extends ItemBuyableOnceEquippable {

    GhastSoundBuyable() {
        super("ffa.sounds", Sound.GHAST_MOAN.name());
    }

    @Override
    protected Map<Integer, LevelInfoBuyable> buildBuyableLevels() {
        Map<Integer, LevelInfoBuyable> levels = new HashMap<>();
        int price = 800;
        ItemStack icon = new SpawnEgg(EntityType.GHAST).toItemStack(1);
        levels.put(0, new LevelInfoBuyable(COINS, 0, "§c* §lNEW §c* §rGhast", Arrays.asList("§7§oGhast moan", "§6Price: §e" + price + " FC"), icon));
        levels.put(1, new LevelInfoBuyable(COINS, price, "§rGhast", Arrays.asList("§aYou own this sound"), icon));
        return levels;
    }
}
