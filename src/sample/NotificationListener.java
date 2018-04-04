package sample;

/**
 * Created by AMOKRANE Abdennour on 04/04/2018.
 */
public interface NotificationListener {

    boolean onNotificationArrive(NotificationEvent notificationEvent);
    boolean onNotificationShown(NotificationEvent notificationEvent);
    boolean onNotificationFinished(NotificationEvent notificationEvent);
    boolean onNotificationClosed(NotificationEvent notificationEvent);
}
