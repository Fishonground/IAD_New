 package pip.course.repository;

public interface EmailService {
    public void sendSimpleMessage(
            String to, String subject, String text);
}
