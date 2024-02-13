import components.button.Button;
import components.dropdown.Dropdown;
import components.menu.Menu;

public interface UIFactory {
    Menu createMenu();
    Button createButton();
    Dropdown createDropdown();
}
