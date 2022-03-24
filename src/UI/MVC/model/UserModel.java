package UI.MVC.model;

import BLL.UserManager;
import java.io.IOException;

public class UserModel {

    private UserManager userManager;

    public UserModel() throws IOException {
        userManager = new UserManager();
    }
}
