package net.milkbowl.vault.chat.plugins;

import java.util.logging.Logger;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;
import org.bukkit.plugin.Plugin;

import com.palmergames.bukkit.towny.NotRegisteredException;
import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.object.Resident;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

public class Chat_Towny extends Chat {

    private static final Logger log = Logger.getLogger("Minecraft");
    private final String name = "Towny";
    private Towny towny;
    private Vault plugin;
    private PermissionServerListener permissionServerListener;

    public Chat_Towny(Vault plugin, Permission perms) {
        super(perms);
        this.plugin = plugin;
        
        permissionServerListener = new PermissionServerListener(this);

        plugin.getServer().getPluginManager().registerEvent(Type.PLUGIN_ENABLE, permissionServerListener, Priority.Monitor, plugin);
        plugin.getServer().getPluginManager().registerEvent(Type.PLUGIN_DISABLE, permissionServerListener, Priority.Monitor, plugin);

        // Load Plugin in case it was loaded before
        if (towny == null) {
            Plugin p = plugin.getServer().getPluginManager().getPlugin("Towny");
            if (p != null) {
                towny = (Towny) p;
                log.info(String.format("[%s][Chat] %s hooked.", plugin.getDescription().getName(), "Towny"));
            }
        }
    }

    private class PermissionServerListener extends ServerListener {
        Chat_Towny chat = null;

        public PermissionServerListener(Chat_Towny chat) {
            this.chat = chat;
        }

        public void onPluginEnable(PluginEnableEvent event) {
            if (this.chat.towny == null) {
                Plugin towny = plugin.getServer().getPluginManager().getPlugin("Towny");
                if (chat != null) {
                    this.chat.towny = (Towny) towny;
                    log.info(String.format("[%s][Chat] %s hooked.", plugin.getDescription().getName(), "Towny"));
                }
            }
        }

        public void onPluginDisable(PluginDisableEvent event) {
            if (this.chat.towny != null) {
                if (event.getPlugin().getDescription().getName().equals("Towny")) {
                    this.chat.towny = null;
                    log.info(String.format("[%s][Chat] %s un-hooked.", plugin.getDescription().getName(), "Towny"));
                }
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isEnabled() {
        return towny != null;
    }

    @Override
    public String getPlayerPrefix(String world, String player) {
        try {
            Resident r = towny.getTownyUniverse().getResident(player);
            return r.getTitle();
        } catch (NotRegisteredException e) {
        }
        return "";
    }

    @Override
    public void setPlayerPrefix(String world, String player, String prefix) {
        throw new UnsupportedOperationException("Towny does not support altering prefixes");
    }

    @Override
    public String getPlayerSuffix(String world, String player) {
        try {
            Resident r = towny.getTownyUniverse().getResident(player);
            return r.getSurname();
        } catch (NotRegisteredException e) {
        }
        return "";
    }

    @Override
    public void setPlayerSuffix(String world, String player, String suffix) {
        throw new UnsupportedOperationException("Towny does not support altering suffixes");
    }

    @Override
    public String getGroupPrefix(String world, String group) {
        try {
            return towny.getTownyUniverse().getTown(group).getTag();
        } catch (NotRegisteredException e) {
        }
        return "";
    }

    @Override
    public void setGroupPrefix(String world, String group, String prefix) {
        throw new UnsupportedOperationException("Towny does not support altering prefixes");
    }

    @Override
    public String getGroupSuffix(String world, String group) {
        throw new UnsupportedOperationException("Towny does not support group/town suffixes");
    }

    @Override
    public void setGroupSuffix(String world, String group, String suffix) {
        throw new UnsupportedOperationException("Towny does not support altering suffixes");
    }

    @Override
    public int getPlayerInfoInteger(String world, String player, String node, int defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setPlayerInfoInteger(String world, String player, String node, int value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public int getGroupInfoInteger(String world, String group, String node, int defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setGroupInfoInteger(String world, String group, String node, int value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public double getPlayerInfoDouble(String world, String player, String node, double defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setPlayerInfoDouble(String world, String player, String node, double value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public double getGroupInfoDouble(String world, String group, String node, double defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setGroupInfoDouble(String world, String group, String node, double value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public boolean getPlayerInfoBoolean(String world, String player, String node, boolean defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setPlayerInfoBoolean(String world, String player, String node, boolean value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public boolean getGroupInfoBoolean(String world, String group, String node, boolean defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setGroupInfoBoolean(String world, String group, String node, boolean value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public String getPlayerInfoString(String world, String player, String node, String defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setPlayerInfoString(String world, String player, String node, String value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public String getGroupInfoString(String world, String group, String node, String defaultValue) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

    @Override
    public void setGroupInfoString(String world, String group, String node,  String value) {
        throw new UnsupportedOperationException("Towny does not support info nodes");
    }

}
