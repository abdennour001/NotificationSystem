package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by AMOKRANE Abdennour on 04/04/2018.
 */
public class Notification {

    private int form=Notification.REMINDER;
    private String title;
    private String details;
    private int duration=Notification.SHORT;
    private NotificationContainer container=new NotificationContainer();
    private int position=Notification.TOP_RIGHT;
    private NotificationEvent notificationEvent;
    public static Stage notificationStage=new Stage();

    public static final int ALERT = 0;
    public static final int ERROR = 0;
    public static final int REMINDER = 0;

    public static final int SHORT = 0;
    public static final int LONG = 0;

    public static final int TOP_RIGHT = 0;
    public static final int TOP_CENTER = 0;
    public static final int TOP_LEFT = 0;
    public static final int BOTTOM_RIGHT = 0;
    public static final int BOTTOM_CENTER = 0;
    public static final int BOTTOM_LEFT = 0;

    public Notification() {
        this.container.Stitle = this.title;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String Sdate=dateFormat.format(this.notificationEvent.getDateOfNotification());
        this.container.Stime = Sdate.split(" ")[1];
        this.container.Sdetails = this.details;
    }

    public Notification(int form, String title, String details, int duration) {
        this.form=form;
        this.title=title;
        this.details=details;
        this.duration=duration;

        this.container.Stitle = this.title;
        this.container.Sdetails = this.details;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public NotificationEvent getEvent() {
        return notificationEvent;
    }

    public void setEvent(NotificationEvent notificationEvent) {
        this.notificationEvent = notificationEvent;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String Sdate=dateFormat.format(this.notificationEvent.getDateOfNotification());
        this.container.Stime = Sdate.split(" ")[1];
    }

    public NotificationContainer getContainer() {
        return container;
    }

    public void show() throws IOException {
        notificationStage=new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("notification_card.fxml"));
        notificationStage.setAlwaysOnTop(true);
        notificationStage.setResizable(false);
        notificationStage.initStyle(StageStyle.DECORATED);
        notificationStage.setScene(new Scene(root));
        notificationStage.show();
    }

    public void hide() {
        notificationStage.hide();
    }

    public boolean isShown() {
        return false;
    }

}
