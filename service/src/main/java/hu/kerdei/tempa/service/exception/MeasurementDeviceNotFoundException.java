package hu.kerdei.tempa.service.exception;

import hu.kerdei.tempa.persistence.model.User;

public class MeasurementDeviceNotFoundException extends RuntimeException {

    public MeasurementDeviceNotFoundException(User user) {
        super("Could not find device by user: " + user.toString());
    }

}
