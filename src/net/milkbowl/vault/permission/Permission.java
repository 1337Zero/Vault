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

import org.bukkit.entity.Player;

public interface Permission {

    /**
     * Gets name of permission method
     * @return Name of Permission Method
     */
    public String getName();
    
    /**
     * Checks if permission method is enabled.
     * @return Success or Failure
     */
    public boolean isEnabled();
    
    /**
     * Checks if player has a permission node.  (Short for playerHas(...)
     * @param player Player instance
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean has(Player player, String permission);
    
    /**
     * Checks if player has a permission node.
     * @param player Player instance
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerHas(Player player, String permission);
    
    /**
     * Add permission to a player.
     * @param worldName Name of World
     * @param playerName Name of Player
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerAdd(String worldName, String playerName, String permission);
    
    /**
     * Remove permission from a player.
     * @param worldName Name of World
     * @param playerName Name of Player
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean playerRemove(String worldName, String playerName, String permission);
    
    /**
     * Checks if group has a permission node.
     * @param worldName Name of World
     * @param groupName Name of Group
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean groupHas(String worldName, String groupName, String permission);
    
    /**
     * Add permission to a group.
     * @param worldName Name of World
     * @param groupName Name of Group
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean groupAdd(String worldName, String groupName, String permission);
    
    /**
     * Remove permission from a group.
     * @param worldName Name of World
     * @param groupName Name of Group
     * @param permission Permission node
     * @return Success or Failure
     */
    public boolean groupRemove(String worldName, String groupName, String permission);
    
    /**
     * Check if player is member of a group.
     * @param worldName Name of World
     * @param playerName Name of Player
     * @param groupName Name of Group
     * @return Success or Failure
     */
    public boolean playerInGroup(String worldName, String playerName, String groupName);
    
    /**
     * Add player to a group.
     * @param worldName Name of World
     * @param playerName Name of Player
     * @param groupName Name of Group
     * @return Success or Failure
     */
    public boolean playerAddGroup(String worldName, String playerName, String groupName);
    
    /**
     * Remove player from a group.
     * @param worldName Name of World
     * @param playerName Name of Player
     * @param groupName Name of Group
     * @return Success or Failure
     */
    public boolean playerRemoveGroup(String worldName, String playerName, String groupName);
    
    /**
     * Get a players informational node (Integer) value
     * @param world Name of World 
     * @param playerName Name of Player
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    public int getPlayerInfoInteger(String world, String playerName, String node, int defaultValue);
    
    /**
     * Set a players informational node (Integer) value
     * @param world Name of World
     * @param playerName Name of Player
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoInteger(String world, String playerName, String node, int value);
    
    /**
     * Get a groups informational node (Integer) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    
    public int getGroupInfoInteger(String world, String groupName, String node, int defaultValue);
    
    /**
     * Set a groups informational node (Integer) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoInteger(String world, String groupName, String node, int value);
    
    /**
     * Get a players informational node (Double) value
     * @param world Name of World
     * @param playerName Name of Group
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    public double getPlayerInfoDouble(String world, String playerName, String node, double defaultValue);
    
    /**
     * Set a players informational node (Double) value
     * @param world Name of World
     * @param playerName Name of Group
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoDouble(String world, String playerName, String node, double value);
    
    /**
     * Get a groups informational node (Double) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    public double getGroupInfoDouble(String world, String groupName, String node, double defaultValue);
    
    /**
     * Set a groups informational node (Double) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoDouble(String world, String groupName, String node, double value);
    
    /**
     * Get a players informational node (Boolean) value
     * @param world Name of World
     * @param playerName Name of Player
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    public boolean getPlayerInfoBoolean(String world, String playerName, String node, boolean defaultValue);
    
    /**
     * Set a players informational node (Boolean) value
     * @param world Name of World
     * @param playerName Name of Player
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoBoolean(String world, String playerName, String node, boolean value);
    
    /**
     * Get a groups informational node (Boolean) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    public boolean getGroupInfoBoolean(String world, String groupName, String node, boolean defaultValue);
    
    /**
     * Set a groups informational node (Boolean) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoBoolean(String world, String groupName, String node, boolean value);
    
    /**
     * Get a players informational node (String) value
     * @param world Name of World
     * @param playerName Name of Player
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    public String getPlayerInfoString(String world, String playerName, String node, String defaultValue);
    
    /**
     * Set a players informational node (String) value
     * @param world Name of World
     * @param playerName Name of Player
     * @param node Permission node
     * @param value Value to set
     */
    public void setPlayerInfoString(String world, String playerName, String node, String value);
    
    /**
     * Get a groups informational node (String) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param defaultValue Default value (if node is not defined)
     * @return Value
     */
    public String getGroupInfoString(String world, String groupName, String node, String defaultValue);
    
    /**
     * Set a groups informational node (String) value
     * @param world Name of World
     * @param groupName Name of Group
     * @param node Permission node
     * @param value Value to set
     */
    public void setGroupInfoString(String world, String groupName, String node, String value);
    
    /**
     * Gets the list of groups that this player has
     * 
     * @param world Name of World
     * @param playerName Name of Player 
     */
    public String[] getPlayerGroups(String world, String playerName);
    
    public String getPrimaryGroup(String world, String playerName);
}
