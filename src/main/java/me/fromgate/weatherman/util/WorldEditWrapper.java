/*  
 *  WeatherMan, Minecraft bukkit plugin
 *  ©2012-2018, fromgate, fromgate@gmail.com
 *  https://www.spigotmc.org/resources/weatherman.43379/
 *    
 *  This file is part of WeatherMan.
 *  
 *  WeatherMan is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  WeatherMan is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with WeatherMan.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package me.fromgate.weatherman.util;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.SessionManager;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class WorldEditWrapper {
    private static boolean worldeditActive = false;
    private static boolean worldguardActive = false;
    private static JavaPlugin plugin;

    public WorldEditWrapper(JavaPlugin plugin) {

        this.plugin = plugin;

        // check for WorldEdit
        if (Bukkit.getPluginManager().isPluginEnabled("WorldEdit")) {
            this.plugin.getLogger().info("WorldEdit found. Enabling WorldEdit features.");
            this.worldeditActive = true;
        }
        if (Bukkit.getPluginManager().isPluginEnabled("WorldGuard")) {
            this.plugin.getLogger().info("WorldGuard found. Enabling WorldGuard features.");
            this.worldguardActive = true;
        }
    }


    public static boolean hasWorldEdit() {
        return worldeditActive;
    }

    public static boolean hasWorldGuard() {
        return worldguardActive;
    }

    public static Location getMinPoint(org.bukkit.World world, String rg) {
        if (!worldguardActive) return null;
        if (world == null) return null;
        if (rg.isEmpty()) return null;

        World wgWorld = BukkitAdapter.adapt(world);
        ProtectedRegion region = WorldGuard.getInstance().getPlatform().getRegionContainer().get(wgWorld).getRegion(rg);
        if (region == null) return null;
        return BukkitAdapter.adapt(world, region.getMinimumPoint());
    }

    public static Location getMaxPoint(org.bukkit.World world, String rg) {
        if (!worldguardActive) return null;
        if (world == null) return null;
        if (rg.isEmpty()) return null;

        World wgWorld = BukkitAdapter.adapt(world);
        ProtectedRegion region = WorldGuard.getInstance().getPlatform().getRegionContainer().get(wgWorld).getRegion(rg);
        if (region == null) return null;
        return BukkitAdapter.adapt(world, region.getMaximumPoint());
    }

    public static boolean isRegionExists(org.bukkit.World world, String rg) {
        if (!WorldEditWrapper.hasWorldGuard()) return false;
        if (world == null) return false;
        if (rg.isEmpty()) return false;
        World wgWorld = BukkitAdapter.adapt(world);
        ProtectedRegion region = WorldGuard.getInstance().getPlatform().getRegionContainer().get(wgWorld).getRegion(rg);
        return (region != null);
    }

    public static boolean isRegionExists(String region) {
        if (!WorldEditWrapper.hasWorldGuard()) return false;
        for (org.bukkit.World w : plugin.getServer().getWorlds()) {
            World wgWorld = BukkitAdapter.adapt(w);
            ProtectedRegion rg = WorldGuard.getInstance().getPlatform().getRegionContainer().get(wgWorld).getRegion(region);
            if (rg != null) return true;
        }
        return false;
    }

    public static List<String> getRegions(Location loc) {
        List<String> rgList = new ArrayList<>();
        if (!WorldEditWrapper.hasWorldGuard()) return rgList;
        World wgWorld = BukkitAdapter.adapt((loc.getWorld()));
        BlockVector3 bv = BukkitAdapter.asBlockVector(loc);
        ApplicableRegionSet regionSet = WorldGuard.getInstance().getPlatform().getRegionContainer().get(wgWorld).getApplicableRegions(bv);
        if (regionSet.size() == 0) return rgList;
        for (ProtectedRegion rg : regionSet) rgList.add(rg.getId());
        return rgList;
    }

    //WorldEdit
    public static boolean isSelected(Player player) {
        if (!worldeditActive) return false;

        com.sk89q.worldedit.entity.Player actor;
        actor = BukkitAdapter.adapt(player);
        SessionManager manager = WorldEdit.getInstance().getSessionManager();
        LocalSession localSession = manager.get(actor);

        com.sk89q.worldedit.world.World selectionWorld = localSession.getSelectionWorld();
        Region region;
        try {
            if (selectionWorld == null) throw new IncompleteRegionException();
            region = localSession.getSelection(selectionWorld);
        } catch (IncompleteRegionException ex) {
            return false;
        }
        return (region != null);
    }

    public static Location getSelectionMinPoint(Player player) {
        if (!worldeditActive) return null;

        com.sk89q.worldedit.entity.Player actor;
        actor = BukkitAdapter.adapt(player);
        SessionManager manager = WorldEdit.getInstance().getSessionManager();
        LocalSession localSession = manager.get(actor);

        com.sk89q.worldedit.world.World selectionWorld = localSession.getSelectionWorld();
        Region region;

        try {
            if (selectionWorld == null) throw new IncompleteRegionException();
            region = localSession.getSelection();
        } catch (IncompleteRegionException ex) {
            return null;
        }

        if (region == null) return null;
        org.bukkit.World world = BukkitAdapter.adapt(selectionWorld);
        return BukkitAdapter.adapt(world, region.getMinimumPoint());
    }

    public static Location getSelectionMaxPoint(Player player) {
        com.sk89q.worldedit.entity.Player actor;
        actor = BukkitAdapter.adapt(player);
        SessionManager manager = WorldEdit.getInstance().getSessionManager();
        LocalSession localSession = manager.get(actor);

        com.sk89q.worldedit.world.World selectionWorld = localSession.getSelectionWorld();
        Region region;

        try {
            if (selectionWorld == null) throw new IncompleteRegionException();
            region = localSession.getSelection();
        } catch (IncompleteRegionException ex) {
            return null;
        }

        if (region == null) return null;
        org.bukkit.World world = BukkitAdapter.adapt(selectionWorld);
        return BukkitAdapter.adapt(world, region.getMaximumPoint());
    }

    public static boolean isPlayerInRegion(Player player, String region) {
        return region != null && !region.isEmpty() && worldguardActive && getRegions(player.getLocation()).contains(region);
    }
}