package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static sample.Notification.notificationStage;

public class MainController {

    public static Stage newAppointmentStage=new Stage();
    public static String name="", date="", cause="";

    @FXML
    Label appointmentLabel;

    @FXML
    VBox vBox;


    public MainController() {

    }

    @FXML
    public void makeNewAppointment(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("new_appointment.fxml"));
            newAppointmentStage.setTitle("Add appointment");
            newAppointmentStage.setScene(new Scene(root));
            newAppointmentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showNotification(ActionEvent actionEvent) throws IOException {
        notificationStage=new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("notification_card.fxml"));
        notificationStage.setAlwaysOnTop(true);
        notificationStage.setResizable(false);
        notificationStage.initStyle(StageStyle.DECORATED);
        notificationStage.setScene(new Scene(root));
        notificationStage.show();
    }

    @FXML
    public void clearAppointment(ActionEvent actionEvent) {
        appointmentLabel.setText("No appointment in line");
        name = "";
    }

    @FXML
    public void initialize() throws IOException {
        vBox.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(! (name == "")) {
                    appointmentLabel.setText("Appointment in " + MainController.date + " with " + MainController.name + " Because of " + MainController.cause + ".");
                }
            }
        });
    }

}
