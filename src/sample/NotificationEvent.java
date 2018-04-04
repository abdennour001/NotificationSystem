package sample;

import javafx.beans.binding.When;

import java.util.Date;

/**
 * Created by AMOKRANE Abdennour on 04/04/2018.
 */
public class NotificationEvent implements Runnable{

    private Date dateOfNotification;
    private Double timeToNotification;
    private boolean notificationTimeOut=false;
    private long renderDelay=1000;
    private NotificationListener notificationListener;
    private Thread mainThread;


    @Override
    public void run() {
        int i=0;
        while (true) {
            try {
                i++;
                Thread.sleep(renderDelay);
                if(i==10) sendNotification(); // simulation to the day of the appointment for example
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public NotificationEvent() {
    }

    public boolean sendNotification() {
        notificationListener.onNotificationArrive(this);
        mainThread.stop();
        return true;
    }

    public boolean stopNotification() {
        return false;
    }

    public boolean notificationStatus() {
        return false;
    }

    public Date getDateOfNotification() {
        return dateOfNotification;
    }

    public void setDateOfNotification(Date dateOfNotification) {
        this.dateOfNotification = dateOfNotification;
    }

    public Double getTimeToNotification() {
        return timeToNotification;
    }

    public void setTimeToNotification(Double timeToNotification) {
        this.timeToNotification = timeToNotification;
    }

    public boolean isNotificationTimeOut() {
        return notificationTimeOut;
    }

    public void setNotificationTimeOut(boolean notificationTimeOut) {
        this.notificationTimeOut = notificationTimeOut;
    }

    public long getRenderDelay() {
        return renderDelay;
    }

    public void setRenderDelay(long renderDelay) {
        this.renderDelay = renderDelay;
    }

    NotificationListener getNotificationListener() {
        return notificationListener;
    }

    void setNotificationListener(NotificationListener notificationListener) {
        mainThread = new Thread(this);
        mainThread.start();
        this.notificationListener = notificationListener;
    }
}
