package hu.kerdei.tempa.service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userName) {
        super("Could not find user : " + userName);
    }

}
