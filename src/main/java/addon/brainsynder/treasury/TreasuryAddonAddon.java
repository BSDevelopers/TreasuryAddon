package addon.brainsynder.treasury;

import me.lokka30.treasury.api.common.service.Service;
import me.lokka30.treasury.api.common.service.ServiceRegistry;
import me.lokka30.treasury.api.economy.EconomyProvider;
import me.lokka30.treasury.api.economy.account.PlayerAccount;
import me.lokka30.treasury.api.economy.response.EconomyException;
import me.lokka30.treasury.api.economy.response.EconomySubscriber;
import me.lokka30.treasury.api.economy.transaction.EconomyTransactionInitiator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import simplepets.brainsynder.addon.presets.EconomyModule;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.debug.DebugLevel;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@Namespace(namespace = "Treasury")
public class TreasuryAddonAddon extends EconomyModule {
    private EconomyProvider provider;

    @Override
    public boolean shouldEnable() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Treasury");
        if (plugin == null) return false;
        if (!plugin.getDescription().getVersion().startsWith("1.1.0")) {
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "You are using an outdated Treasury version, this addon uses v1.1.0");
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Please download it from: https://www.spigotmc.org/resources/99531/");
            return false;
        }
        return true;
    }

    @Override
    public void init() {
        ServiceRegistry serviceRegistry = ServiceRegistry.INSTANCE;
        Optional<Service<EconomyProvider>> serviceOpt = serviceRegistry.serviceFor(EconomyProvider.class);

        if(serviceOpt.isEmpty()) {
            setEnabled(false);
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Oh No! We could not find the Economy Provider for Treasury!");
            return;
        }

        Service<EconomyProvider> service = serviceOpt.get();
        this.provider = service.get();
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
}
