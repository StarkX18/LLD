public class UIFactoryFactory {
    public static UIFactory getUIFactory(SupportedPlatforms supportedPlatform){
        return switch (supportedPlatform){
            case SupportedPlatforms.IOS -> new iOSFactory();
            case SupportedPlatforms.MAC -> new MacFactory();
            case SupportedPlatforms.ANDROID -> new AndroidFactory();
            default -> null;
        };
    }
}
