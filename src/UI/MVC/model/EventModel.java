package UI.MVC.model;

import BLL.EventManager;
import java.io.IOException;

public class EventModel {

    private EventManager eventManager;

    public EventModel() throws IOException {
        eventManager = new EventManager();
    }

}
