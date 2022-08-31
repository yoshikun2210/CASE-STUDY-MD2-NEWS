package rikkei.academy.dto.response;

public class ResponseMessenger {
    private String message;

    public ResponseMessenger(String message) {
        this.message = message;
    }

    public ResponseMessenger(){
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
