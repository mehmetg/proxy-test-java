package Models;

/**
 * Created by mehmetgerceker on 12/1/15.
 */
public class StatusMessage {

    private float wait_time;
    private boolean service_operational;
    private String status_message;

    public StatusMessage() {
    }

    public StatusMessage(float waitTime, boolean serviceOperational, String statusMessage) {
        this.wait_time = waitTime;
        this.service_operational = serviceOperational;
        this.status_message = statusMessage;
    }

    public float getWait_time() {
        return wait_time;
    }

    public boolean isService_operational() {
        return service_operational;
    }

    public String getStatus_message() {
        return status_message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wait Time: ")
                .append(this.wait_time)
                .append("\nService Operational: ")
                .append(this.service_operational)
                .append("\nStatus Message: ")
                .append(this.status_message);
        return sb.toString();
    }

}
