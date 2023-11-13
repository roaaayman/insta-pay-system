class WalletDataBAse {
    private static final List<WalletAccount> accounts = new ArrayList<>();

    static 
    {
        accounts.add(new WalletAccount(" 1123445 "));
        accounts.add(new WalletAccount(" 2345676 "));

    }

    
    public static List<WalletAccount> getAccounts()
    {
        retun accounts;
    }
}