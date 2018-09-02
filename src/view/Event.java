package view;

/*
 * not a participant, but is used to send info
 *      from Subject to Observer
 */

public class Event {
    
    private final String message;
    private final Subject subject;
    private final int value;
    
    public Event(String message, int value, Subject subject) {
        this.message = message;
        this.value = value;
        this.subject = subject;
    }
    
    public String getMessage() {
        return message;
    }
    
    public int getValue() {
        return value;
    }
    
    public Subject getSubject() {
        return subject;
    }
    
}
