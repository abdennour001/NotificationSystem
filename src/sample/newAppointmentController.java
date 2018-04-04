package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AMOKRANE Abdennour on 04/04/2018.
 */
public class newAppointmentController {

    @FXML
    TextField clientName, date, cause;

    @FXML
    public void signUp() throws ParseException {
        if(!clientName.getText().equals("")) {
            MainController.name=clientName.getText();
        } else {
            clientName.setPromptText("You have to enter the client name");
            return;
        }
        if(!date.getText().equals("")) {
            MainController.date=date.getText();
        } else {
            date.setPromptText("You have to enter the date");
            return;
        }
        if(!cause.getText().equals("")) {
            MainController.cause=cause.getText();
        } else {
            cause.setPromptText("You have to enter the cause");
            return;
        }

        /* create a new appointment.*/
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(MainController.date);
        Appointment appointment=new Appointment(MainController.name, date, MainController.cause);
        final Notification notification=new Notification(Notification.REMINDER, "Appointment reminder", MainController.cause, Notification.LONG);
        appointment.setNotification(notification);
        NotificationEvent notificationEvent=new NotificationEvent();
        notificationEvent.setDateOfNotification(date);
        notification.setEvent(notificationEvent);
        appointment.addNotificationListener(new NotificationListener() {
            @Override
            public boolean onNotificationArrive(NotificationEvent notificationEvent) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            notification.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return false;
            }

            @Override
            public boolean onNotificationShown(NotificationEvent notificationEvent) {
                return false;
            }

            @Override
            public boolean onNotificationFinished(NotificationEvent notificationEvent) {
                return false;
            }

            @Override
            public boolean onNotificationClosed(NotificationEvent notificationEvent) {
                return false;
            }
        });

        MainController.newAppointmentStage.close();
    }
}
