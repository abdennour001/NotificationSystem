package sample;

import java.util.Date;

/**
 * Created by AMOKRANE Abdennour on 04/04/2018.
 */
public class Appointment {

    private String clientFullName;
    private Date date;
    private String cause;
    private Notification notification;

    public Appointment() {

    }

    public Appointment(String name, Date date, String cause) {
        this.clientFullName = name;
        this.date = date;
        this.cause = cause;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public void addNotificationListener(NotificationListener notification) {
        this.notification.getEvent().setNotificationListener(notification);
    }

    public NotificationListener getNotificationListener() {
        return this.notification.getEvent().getNotificationListener();
    }
}
