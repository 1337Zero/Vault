package net.milkbowl.vault.economy.plugins;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import me.mjolnir.mineconomy.Accounting;
import me.mjolnir.mineconomy.MineConomy;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

public class Economy_MineConomy implements Economy {
    private static final Logger log = Logger.getLogger("Minecraft");

    private final String name = "MineConomy";
    private Plugin plugin = null;
    private MineConomy econ = null;

    public Economy_MineConomy(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(new EconomyServerListener(this), plugin);

        // Load Plugin in case it was loaded before
        if (econ == null) {
            Plugin econ = plugin.getServer().getPluginManager().getPlugin("MineConomy");
            if (econ != null && econ.isEnabled()) {
                this.econ = (MineConomy) econ;
                log.info(String.format("[%s][Economy] %s hooked.", plugin.getDescription().getName(), name));
            }
        }
    }

    public class EconomyServerListener implements Listener {
        Economy_MineConomy economy = null;

        public EconomyServerListener(Economy_MineConomy economy) {
            this.economy = economy;
        }

        @EventHandler(priority = EventPriority.MONITOR)
        public void onPluginEnable(PluginEnableEvent event) {
            if (economy.econ == null) {
                Plugin eco = plugin.getServer().getPluginManager().getPlugin("MineConomy");

                if (eco != null && eco.isEnabled()) {
                    economy.econ = (MineConomy) eco;
                    log.info(String.format("[%s][Economy] %s hooked.", plugin.getDescription().getName(), economy.name));
                }
            }
        }

        @EventHandler(priority = EventPriority.MONITOR)
        public void onPluginDisable(PluginDisableEvent event) {
            if (economy.econ != null) {
                if (event.getPlugin().getDescription().getName().equals("MineConomy")) {
                    economy.econ = null;
                    log.info(String.format("[%s][Economy] %s unhooked.", plugin.getDescription().getName(), economy.name));
                }
            }
        }
    }

    @Override
    public boolean isEnabled() {
        return this.econ != null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String format(double amount) {
        return String.valueOf(amount);
    }

    @Override
    public double getBalance(String playerName) {
        return Accounting.getBalance(playerName, MineConomy.accounts);
    }

    @Override
    public boolean has(String playerName, double amount) {
        return getBalance(playerName) >= amount;
    }

    @Override
    public EconomyResponse withdrawPlayer(String playerName, double amount) {
        double balance = getBalance(playerName);
        if (amount < 0) {
            return new EconomyResponse(0, balance, ResponseType.FAILURE, "Cannot withdraw negative funds");
        } else if (balance >= amount) {
            double finalBalance = balance - amount;
            Accounting.setBalance(playerName, finalBalance, MineConomy.accounts);
            return new EconomyResponse(amount, finalBalance, ResponseType.SUCCESS, null);
        } else {
            return new EconomyResponse(0, balance, ResponseType.FAILURE, "Insufficient funds");
        }
    }

    @Override
    public EconomyResponse depositPlayer(String playerName, double amount) {
        double balance = getBalance(playerName);
        if (amount < 0) {
            return new EconomyResponse(0, balance, ResponseType.FAILURE, "Cannot deposit negative funds");
        } else {
            balance += amount;
            Accounting.setBalance(playerName, balance, MineConomy.accounts);
            return new EconomyResponse(amount, balance, ResponseType.SUCCESS, null);
        }
    }

    @Override
    public EconomyResponse createBank(String name, String player) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse deleteBank(String name) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse bankHas(String name, double amount) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse bankWithdraw(String name, double amount) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse bankDeposit(String name, double amount) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse isBankOwner(String name, String playerName) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse isBankMember(String name, String playerName) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse bankBalance(String name) {
        return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "MineConomy does not support bank accounts!");
    }

    @Override
    public List<String> getBanks() {
        return new ArrayList<String>();
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public boolean hasAccount(String playerName) {
        return Accounting.containsKey(playerName, MineConomy.accounts);
    }

    @Override
    public boolean createPlayerAccount(String playerName) {
        if (hasAccount(playerName)) {
            return false;
        }
        Accounting.setBalance(playerName, 0, MineConomy.accounts);
        return true;
    }
}
