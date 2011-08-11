/**
 * Copyright (C) 2011 Morgan Humes <morgan@lanaddict.com>
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 */

package net.milkbowl.vault.permission;

import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class Permission {

    /**
     * Gets name of permission method
     * @return Name of Permission Method
     */
    abstract public String getName();
    
    /**
     * Checks if permission method is enabled.
     * @return Success or Failure
     */
    abstract public boolean isEnabled();
    
    /**
     * Checks if player has a permission node.  (Short for playerHas(...)
     * @param world World name
     * @param player Player name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean has(String world, String player, String permission) {
        return playerHas(world, player, permission);
    }
    /**
     * Checks if player has a permission node.  (Short for playerHas(...)
     * @param world World Object
     * @param player Player name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean has(World world, String player, String permission) {
        return playerHas(world.getName(), player, permission);
    }
    /**
     * Checks if player has a permission node.  (Short for playerHas(...)
     * @param player Player Object
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean has(Player player, String permission) {
        return playerHas(player.getWorld().getName(), player.getName(), permission);
    }
    
    /**
     * Checks if player has a permission node.
     * @param world World name
     * @param player Player name
     * @param permission Permission node
     * @return Success or Failure
     */
    abstract public boolean playerHas(String world, String player, String permission);
    /**
     * Checks if player has a permission node.
     * @param world World Object
     * @param player Player name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerHas(World world, String player, String permission) {
        return playerHas(world.getName(), player, permission);
    }
    /**
     * Checks if player has a permission node.
     * @param player Player Object
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerHas(Player player, String permission) {
        return playerHas(player.getWorld().getName(), player.getName(), permission);
    }
    
    /**
     * Add permission to a player.
     * @param world World name
     * @param player Player name
     * @param permission Permission node
     * @return Success or Failure
     */
    abstract public boolean playerAdd(String world, String player, String permission);
    /**
     * Add permission to a player.
     * @param world World Object
     * @param player Player name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerAdd(World world, String player, String permission) {
        return playerAdd(world.getName(), player, permission);
    }
    /**
     * Add permission to a player.
     * @param player Player Object
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerAdd(Player player, String permission) {
        return playerAdd(player.getWorld().getName(), player.getName(), permission);
    }
    
    /**
     * Remove permission from a player.
     * @param world World name
     * @param player Name of Player
     * @param permission Permission node
     * @return Success or Failure
     */
    abstract public boolean playerRemove(String world, String player, String permission);
    /**
     * Remove permission from a player.
     * @param world World name
     * @param player Player name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerRemove(World world, String player, String permission) {
        return playerRemove(world.getName(), player, permission);
    }
    /**
     * Remove permission from a player.
     * @param player Player Object
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerRemove(Player player, String permission) {
        return playerRemove(player.getWorld().getName(), player.getName(), permission);
    }
    
    /**
     * Checks if group has a permission node.
     * @param world World name
     * @param group Group name
     * @param permission Permission node
     * @return Success or Failure
     */
    abstract public boolean groupHas(String world, String group, String permission);
    /**
     * Checks if group has a permission node.
     * @param world World Object
     * @param group Group name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean groupHas(World world, String group, String permission) {
        return groupHas(world.getName(), group, permission);
    }
    
    /**
     * Add permission to a group.
     * @param world World name
     * @param group Group name
     * @param permission Permission node
     * @return Success or Failure
     */
    abstract public boolean groupAdd(String world, String group, String permission);
    /**
     * Add permission to a group.
     * @param world World Object
     * @param group Group name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean groupAdd(World world, String group, String permission) {
        return groupAdd(world.getName(), group, permission);
    }
    
    /**
     * Remove permission from a group.
     * @param world World name
     * @param group Group name
     * @param permission Permission node
     * @return Success or Failure
     */
    abstract public boolean groupRemove(String world, String group, String permission);
    /**
     * Remove permission from a group.
     * @param world World Object
     * @param group Group name
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean groupRemove(World world, String group, String permission) {
        return groupRemove(world.getName(), group, permission);
    }
    
    /**
     * Check if player is member of a group.
     * @param world World name
     * @param player Player name
     * @param group Group name
     * @return Success or Failure
     */
    abstract public boolean playerInGroup(String world, String player, String group);
    /**
     * Check if player is member of a group.
     * @param world World Object
     * @param player Player name
     * @param group Group name
     * @return Success or Failure
     */
    public boolean playerInGroup(World world, String player, String group) {
        return playerInGroup(world.getName(), player, group);
    }
    /**
     * Check if player is member of a group.
     * @param player Player Object
     * @param group Group name
     * @return Success or Failure
     */
    public boolean playerInGroup(Player player, String group) {
        return playerInGroup(player.getWorld().getName(), player.getName(), group);
    }
    
    /**
     * Add player to a group.
     * @param world World name
     * @param player Player name
     * @param group Group name
     * @return Success or Failure
     */
    abstract public boolean playerAddGroup(String world, String player, String group);
    /**
     * Add player to a group.
     * @param world World Object
     * @param player Player name
     * @param group Group name
     * @return Success or Failure
     */
    public boolean playerAddGroup(World world, String player, String group) {
        return playerAddGroup(world.getName(), player, group);
    }
    /**
     * Add player to a group.
     * @param player Player Object
     * @param group Group name
     * @return Success or Failure
     */
    public boolean playerAddGroup(Player player, String group) {
        return playerAddGroup(player.getWorld().getName(), player.getName(), group);
    }
    
    /**
     * Remove player from a group.
     * @param world World name
     * @param player Player name
     * @param group Group name
     * @return Success or Failure
     */
    abstract public boolean playerRemoveGroup(String world, String player, String group);
    /**
     * Remove player from a group.
     * @param world World Object
     * @param player Player name
     * @param group Group name
     * @return Success or Failure
     */
    public boolean playerRemoveGroup(World world, String player, String group) {
        return playerRemoveGroup(world.getName(), player, group);
    }
    /**
     * Remove player from a group.
     * @param player Player Object
     * @param group Group name
     * @return Success or Failure
     */
    public boolean playerRemoveGroup(Player player, String group) {
        return playerRemoveGroup(player.getWorld().getName(), player.getName(), group);
    }
    
    /**
     * Get a players informational node (Integer) value
     * @param world World name 
     * @param player Player name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public int getPlayerInfoInteger(String world, String player, String node, int defaultValue);
    /**
     * Get a players informational node (Integer) value
     * @param world World Object
     * @param player Player name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public int getPlayerInfoInteger(World world, String player, String node, int defaultValue) {
        return getPlayerInfoInteger(world.getName(), player, node, defaultValue);
    }
    /**
     * Get a players informational node (Integer) value
     * @param player Player Object
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public int getPlayerInfoInteger(Player player, String node, int defaultValue) {
        return getPlayerInfoInteger(player.getWorld().getName(), player.getName(), node, defaultValue);
    }
    
    /**
     * Set a players informational node (Integer) value
     * @param world World name
     * @param player Player name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setPlayerInfoInteger(String world, String player, String node, int value);
    /**
     * Set a players informational node (Integer) value
     * @param world World Object
     * @param player Player name
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoInteger(World world, String player, String node, int value) {
        setPlayerInfoInteger(world.getName(), player, node, value);
    }
    /**
     * Set a players informational node (Integer) value
     * @param player Player Object
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoInteger(Player player, String node, int value) {
        setPlayerInfoInteger(player.getWorld().getName(), player.getName(), node, value);
    }
    
    /**
     * Get a groups informational node (Integer) value
     * @param world World name
     * @param group Group name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public int getGroupInfoInteger(String world, String group, String node, int defaultValue);
    /**
     * Get a groups informational node (Integer) value
     * @param world World Object
     * @param group Group name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public int getGroupInfoInteger(World world, String group, String node, int defaultValue) {
        return getGroupInfoInteger(world.getName(), group, node, defaultValue);
    }
    
    /**
     * Set a groups informational node (Integer) value
     * @param world World name
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoInteger(String world, String group, String node, int value);
    /**
     * Set a groups informational node (Integer) value
     * @param world World Object
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoInteger(World world, String group, String node, int value) {
        setGroupInfoInteger(world.getName(), group, node, value);
    }
    
    /**
     * Get a players informational node (Double) value
     * @param world World name
     * @param player Group name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public double getPlayerInfoDouble(String world, String player, String node, double defaultValue);
    /**
     * Get a players informational node (Double) value
     * @param world World Object
     * @param player Player name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public double getPlayerInfoDouble(World world, String player, String node, double defaultValue) {
        return getPlayerInfoDouble(world.getName(), player, node, defaultValue);
    }
    /**
     * Get a players informational node (Double) value
     * @param player Player Object
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public double getPlayerInfoDouble(Player player, String node, double defaultValue) {
        return getPlayerInfoDouble(player.getWorld().getName(), player.getName(), node, defaultValue);
    }
    
    /**
     * Set a players informational node (Double) value
     * @param world World name
     * @param player Group name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setPlayerInfoDouble(String world, String player, String node, double value);
    /**
     * Set a players informational node (Double) value
     * @param world World Object
     * @param player Player name
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoDouble(World world, String player, String node, double value) {
        setPlayerInfoDouble(world.getName(), player, node, value);
    }
    /**
     * Set a players informational node (Double) value
     * @param player Player Object
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoDouble(Player player, String node, double value) {
        setPlayerInfoDouble(player.getWorld().getName(), player.getName(), node, value);
    }
    
    /**
     * Get a groups informational node (Double) value
     * @param world World name
     * @param group Group name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public double getGroupInfoDouble(String world, String group, String node, double defaultValue);
    /**
     * Get a groups informational node (Double) value
     * @param world World Object
     * @param group Group name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public double getGroupInfoDouble(World world, String group, String node, double defaultValue) {
        return getGroupInfoDouble(world.getName(), group, node, defaultValue);
    }
    
    /**
     * Set a groups informational node (Double) value
     * @param world World name
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoDouble(String world, String group, String node, double value);
    /**
     * Set a groups informational node (Double) value
     * @param world World Object
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoDouble(World world, String group, String node, double value) {
        setGroupInfoDouble(world.getName(), group, node, value);
    }
    
    /**
     * Get a players informational node (Boolean) value
     * @param world World name
     * @param player Player name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public boolean getPlayerInfoBoolean(String world, String player, String node, boolean defaultValue);
    /**
     * Get a players informational node (Boolean) value
     * @param world World Object
     * @param player Player name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public boolean getPlayerInfoBoolean(World world, String player, String node, boolean defaultValue) {
        return getPlayerInfoBoolean(world.getName(), player, node, defaultValue);
    }
    /**
     * Get a players informational node (Boolean) value
     * @param player Player Object
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public boolean getPlayerInfoBoolean(Player player, String node, boolean defaultValue) {
        return getPlayerInfoBoolean(player.getWorld().getName(), player.getName(), node, defaultValue);
    }
    
    /**
     * Set a players informational node (Boolean) value
     * @param world World name
     * @param player Player name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setPlayerInfoBoolean(String world, String player, String node, boolean value);
    /**
     * Set a players informational node (Boolean) value
     * @param world World Object
     * @param player Player name
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoBoolean(World world, String player, String node, boolean value) {
        setPlayerInfoBoolean(world.getName(), player, node, value);
    }
    /**
     * Set a players informational node (Boolean) value
     * @param player Player Object
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoBoolean(Player player, String node, boolean value) {
        setPlayerInfoBoolean(player.getWorld().getName(), player.getName(), node, value);
    }
    
    /**
     * Get a groups informational node (Boolean) value
     * @param world Name of World
     * @param group Name of Group
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public boolean getGroupInfoBoolean(String world, String group, String node, boolean defaultValue);
    /**
     * Set a players informational node (Boolean) value
     * @param world World Object
     * @param group Group name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public boolean getGroupInfoBoolean(World world, String group, String node, boolean defaultValue) {
        return getGroupInfoBoolean(world.getName(), group, node, defaultValue);
    }
    
    /**
     * Set a groups informational node (Boolean) value
     * @param world World name
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoBoolean(String world, String group, String node, boolean value);
    /**
     * Set a players informational node (Boolean) value
     * @param world World Object
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoBoolean(World world, String group, String node, boolean value) {
        setGroupInfoBoolean(world.getName(), group, node, value);
    }
    
    /**
     * Get a players informational node (String) value
     * @param world World name
     * @param player Player name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public String getPlayerInfoString(String world, String player, String node, String defaultValue);
    /**
     * Get a players informational node (String) value
     * @param world World Object
     * @param player Player name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public String getPlayerInfoString(World world, String player, String node, String defaultValue) {
        return getPlayerInfoString(world.getName(), player, node, defaultValue);
    }
    /**
     * Get a players informational node (String) value
     * @param player Player Object
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public String getPlayerInfoString(Player player, String node, String defaultValue) {
        return getPlayerInfoString(player.getWorld().getName(), player.getName(), node, defaultValue);
    }
    
    /**
     * Set a players informational node (String) value
     * @param world World name
     * @param player Player name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setPlayerInfoString(String world, String player, String node, String value);
    /**
     * Set a players informational node (String) value
     * @param world World name
     * @param player Player name
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoString(World world, String player, String node, String value) {
        setPlayerInfoString(world.getName(), player, node, value);
    }
    /**
     * Set a players informational node (String) value
     * @param player Player Object
     * @param node Permission node
     * @param value Value ot set
     */
    public void setPlayerInfoString(Player player, String node, String value) {
        setPlayerInfoString(player.getWorld().getName(), player.getName(), node, value);
    }
    
    /**
     * Get a groups informational node (String) value
     * @param world Name of World
     * @param group Name of Group
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public String getGroupInfoString(String world, String group, String node, String defaultValue);
    /**
     * Set a players informational node (String) value
     * @param world World Object
     * @param group Group name
     * @param node Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public String getGroupInfoString(World world, String group, String node, String defaultValue) {
        return getGroupInfoString(world.getName(), group, node, defaultValue);
    }
    
    /**
     * Set a groups informational node (String) value
     * @param world World name
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoString(String world, String group, String node, String value);
    /**
     * Set a groups informational node (String) value
     * @param world World name
     * @param group Group name
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoString(World world, String group, String node, String value) {
        setGroupInfoString(world.getName(), group, node, value);
    }
    
    /**
     * Gets the list of groups that this player has
     * @param world World name
     * @param player Player name
     * @return Array of groups 
     */
    abstract public String[] getPlayerGroups(String world, String player);
    /**
     * Gets the list of groups that this player has
     * @param world World Object
     * @param player Player name
     * @return Array of groups
     */
    public String[] getPlayerGroups(World world, String player) {
        return getPlayerGroups(world.getName(), player);
    }
    /**
     * Gets the list of groups that this player has
     * @param player Player Object
     * @return Array of groups
     */
    public String[] getPlayerGroups(Player player) {
        return getPlayerGroups(player.getWorld().getName(), player.getName());
    }
    
    /**
     * Gets players primary group
     * @param world World name
     * @param player Player name
     * @return Players primary group
     */
    abstract public String getPrimaryGroup(String world, String player);
    /**
     * Gets players primary group
     * @param world World Object
     * @param player Player name
     * @return Players primary group
     */
    public String getPrimaryGroup(World world, String player) {
        return getPrimaryGroup(world.getName(), player);
    }
    /**
     * Get players primary group
     * @param player Player Object
     * @return Players primary group
     */
    public String getPrimaryGroup(Player player) {
        return getPrimaryGroup(player.getWorld().getName(), player.getName());
    }
    
    /**
     * Get players prefix
     * @param world World name
     * @param player Player name
     * @return Prefix
     */
    abstract public String getPlayerPrefix(String world, String player);
    /**
     * Get players prefix
     * @param world World Object
     * @param player Player name
     * @return Prefix
     */
    public String getPlayerPrefix(World world, String player) {
        return getPlayerPrefix(world.getName(), player);
    }
    /**
     * Get players prefix
     * @param player Player Object
     * @return Prefix
     */
    public String getPlayerPrefix(Player player) {
        return getPlayerPrefix(player.getWorld().getName(), player.getName());
    }
    
    /**
     * Set players prefix
     * @param world World name
     * @param player Player name
     * @param prefix Prefix
     */
    abstract public void setPlayerPrefix(String world, String player, String prefix);
    /**
     * Set players prefix
     * @param world World Object
     * @param player Player name
     * @param prefix Prefix
     */
    public void setPlayerPrefix(World world, String player, String prefix) {
        setPlayerPrefix(world.getName(), player, prefix);
    }
    /**
     * Set players prefix
     * @param player Player Object
     * @param prefix Prefix
     */
    public void setPlayerPrefix(Player player, String prefix) {
        setPlayerPrefix(player.getWorld().getName(), player.getName(), prefix);
    }
    
    /**
     * Get players suffix
     * @param world World name
     * @param player Player name
     * @return Suffix
     */
    abstract public String getPlayerSuffix(String world, String player);
    /**
     * Get players suffix
     * @param world World Object
     * @param player Player name
     * @return Suffix
     */
    public String getPlayerSuffix(World world, String player) {
        return getPlayerSuffix(world.getName(), player);
    }
    /**
     * Get players suffix
     * @param player Player Object
     * @return Suffix
     */
    public String getPlayerSuffix(Player player) {
        return getPlayerSuffix(player.getWorld().getName(), player.getName());
    }
    
    /**
     * Set players suffix
     * @param world World name
     * @param player Player name
     * @param suffix Suffix
     */
    abstract public void setPlayerSuffix(String world, String player, String suffix);
    /**
     * Set players suffix
     * @param world World Object
     * @param player Player name
     * @param suffix Suffix
     */
    public void setPlayerSuffix(World world, String player, String suffix) {
        setPlayerSuffix(world.getName(), player, suffix);
    }
    /**
     * Set players suffix
     * @param player Player Object
     * @param suffix Suffix
     */
    public void setPlayerSuffix(Player player, String suffix) {
        setPlayerSuffix(player.getWorld().getName(), player.getName(), suffix);
    }
}