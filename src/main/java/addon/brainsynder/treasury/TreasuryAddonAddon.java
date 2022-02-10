package addon.brainsynder.treasury;

import com.google.common.collect.Lists;
import me.lokka30.treasury.api.economy.EconomyProvider;
import me.lokka30.treasury.api.economy.account.PlayerAccount;
import me.lokka30.treasury.api.economy.currency.Currency;
import me.lokka30.treasury.api.economy.response.EconomyException;
import me.lokka30.treasury.api.economy.response.EconomySubscriber;
import me.lokka30.treasury.api.economy.transaction.EconomyTransactionInitiator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import simplepets.brainsynder.addon.presets.EconomyAddon;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.debug.DebugLevel;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Namespace(namespace = "Treasury")
public class TreasuryAddonAddon extends EconomyAddon {
    private EconomyProvider provider;
    private Currency currency;

    @Override
    public boolean shouldEnable() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Treasury");
        if (plugin == null) {
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Treasury wasn't found!");
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Please download it from: https://www.spigotmc.org/resources/99531/");
            return false;
        }
        return true;
    }

    @Override
    public void init() {
        RegisteredServiceProvider<EconomyProvider> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(EconomyProvider.class);
        if (economyProvider != null) {
            this.provider = economyProvider.getProvider();
        }else{
            setEnabled(false);
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Oh No! We could not find the Economy Provider for Treasury!");
        }
    }

    @Override
    public int getDefaultPrice() {
        return 2000;
    }

    @Override
    public void fetchBalance(UUID uuid, Consumer<Double> balanceConsumer) {
        provider.retrievePlayerAccount(uuid, new EconomySubscriber<PlayerAccount>() {
            @Override
            public void succeed(@NotNull PlayerAccount playerAccount) {
                playerAccount.retrieveBalance(provider.getPrimaryCurrency(), new EconomySubscriber<BigDecimal>() {
                    @Override
                    public void succeed(@NotNull BigDecimal bigDecimal) {
                        balanceConsumer.accept(bigDecimal.doubleValue());
                    }

                    @Override
                    public void fail(@NotNull EconomyException exception) {
                        SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Failed to fetch players balance("+uuid+"): "+exception.getMessage());
                    }
                });
            }

            @Override
            public void fail(@NotNull EconomyException exception) {
                SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Failed to fetch players account("+uuid+"): "+exception.getMessage());
            }
        });
    }

    @Override
    public double getBalance(UUID uuid) {
        return 0;
    }

    @Override
    public void withdraw(UUID uuid, double amount) {
        provider.retrievePlayerAccount(uuid, new EconomySubscriber<PlayerAccount>() {
            @Override
            public void succeed(@NotNull PlayerAccount playerAccount) {
                EconomyTransactionInitiator<?> initiator = EconomyTransactionInitiator.createInitiator(EconomyTransactionInitiator.Type.PLAYER, uuid);

                playerAccount.withdrawBalance(BigDecimal.valueOf(amount), initiator, provider.getPrimaryCurrency(), new EconomySubscriber<BigDecimal>() {
                    @Override
                    public void succeed(@NotNull BigDecimal bigDecimal) {
                        // The EconomyAddon class already sends the success message
                    }

                    @Override
                    public void fail(@NotNull EconomyException exception) {
                        SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Failed to withdrawal from players balance("+uuid+"): "+exception.getMessage());
                    }
                });
            }

            @Override
            public void fail(@NotNull EconomyException exception) {
                SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Failed to fetch players account("+uuid+"): "+exception.getMessage());
            }
        });
    }

    @Override
    public double getVersion() {
        return 0.1;
    }

    @Override
    public String getAuthor() {
        return "brainsynder";
    }

    @Override
    public List<String> getDescription() {
        return Lists.newArrayList(
                "&7This addon links into the Treasury Plugin",
                "&7To make it possible to buy pets with in-game money"
        );
    }
}
