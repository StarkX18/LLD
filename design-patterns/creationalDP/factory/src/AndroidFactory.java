import components.button.AndroidButton;
import components.button.Button;
import components.dropdown.AndroidDropdown;
import components.dropdown.Dropdown;
import components.menu.AndroidMenu;
import components.menu.Menu;

public class AndroidFactory implements UIFactory{
    public Menu createMenu(){
        return new AndroidMenu();
    }

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }
}
