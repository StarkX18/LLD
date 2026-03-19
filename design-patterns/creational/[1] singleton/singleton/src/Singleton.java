public class Singleton {
    private static Singleton instance;
    // 1. hide the constructor
    private Singleton(){}

    // 2. make a static function to call constructor
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
