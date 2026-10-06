import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {
    private LocalDateTime timestamp;
    private String action;
    private String username;
    private String details;

    public AuditLog(String action, String username, String details) {
        this.timestamp = LocalDateTime.now();
        this.action = action;
        this.username = username == null ? "" : username;
        this.details = details == null ? "" : details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getAction() {
        return action;
    }

    public String getUsername() {
        return username;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s | %s | user=%s | %s", timestamp.format(fmt), action, username, details);
    }
}