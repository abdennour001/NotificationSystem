package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import static sample.Notification.notificationStage;

/**
 * Created by asus on 04/04/2018.
 */
public class NotificationContainer {

    static String Stime="", Stitle="", Sdetails="";

    @FXML
    Label time, title, details, close;

    @FXML
    AnchorPane anchorPane;

    @FXML
    void close() {
        notificationStage.close();
    }

    public void setTime() {
        this.time.setText(Stime);
    }

    public void setTitle() {
        this.title.setText(Stitle);
    }

    public void setDetails() {
        this.details.setText(Sdetails);
    }

    @FXML
    public void initialize() {
        setTime();
        setDetails();
        setTitle();
    }

}
