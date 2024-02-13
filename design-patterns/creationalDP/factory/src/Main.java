import components.button.Button;
import components.dropdown.Dropdown;
import components.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Flutter flutter = new Flutter(SupportedPlatforms.ANDROID);
        UIFactory factory = flutter.createUIFactory();
        Menu menu = factory.createMenu();
        Button button = factory.createButton();
        Dropdown dropdown = factory.createDropdown();
    }
}