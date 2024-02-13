import components.button.Button;
import components.button.iOSButton;
import components.dropdown.Dropdown;
import components.dropdown.iOSDropdown;
import components.menu.Menu;
import components.menu.iOSMenu;

public class iOSFactory implements UIFactory{

    @Override
    public Menu createMenu() {
        return new iOSMenu();
    }

    @Override
    public Button createButton() {
        return new iOSButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new iOSDropdown();
    }
}
