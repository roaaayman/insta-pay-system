package WalletUserData;

public class WalletProviderFactory {

    public static List<WalletProvider> createWalletProviders() {
        List<WalletProvider> walletProviders = new ArrayList<>();

        // Wallet Provider 1
        ConcreteWalletProvider provider1 = new ConcreteWalletProvider("Provider One");
        provider1.addWalletUser(new ConcreteWalletUser("User7", "1234123412"));
        provider1.addWalletUser(new ConcreteWalletUser("User8", "5678567856"));
        walletProviders.add(provider1);

        // Wallet Provider 2
        ConcreteWalletProvider provider2 = new ConcreteWalletProvider("Provider Two");
        provider2.addWalletUser(new ConcreteWalletUser("User9", "9876987698"));
        provider2.addWalletUser(new ConcreteWalletUser("User10", "1111222233"));
        walletProviders.add(provider2);

        // Wallet Provider 3
        ConcreteWalletProvider provider3 = new ConcreteWalletProvider("Provider Three");
        provider3.addWalletUser(new ConcreteWalletUser("User11", "4444555566"));
        provider3.addWalletUser(new ConcreteWalletUser("User12", "7777888899"));
        walletProviders.add(provider3);

        return walletProviders;
}
