import components.button.Button;
import components.button.MacButton;
import components.dropdown.Dropdown;
import components.dropdown.MacDropdown;
import components.menu.MacMenu;
import components.menu.Menu;

public class MacFactory implements UIFactory{

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new MacDropdown();
    }
}
