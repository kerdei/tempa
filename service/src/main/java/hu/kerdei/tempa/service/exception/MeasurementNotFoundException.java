package hu.kerdei.tempa.service.exception;

import hu.kerdei.tempa.persistence.model.MeasurementDevice;

public class MeasurementNotFoundException extends RuntimeException {

    public MeasurementNotFoundException(Integer year) {
        super("Could not find measurement in year: " + year);
    }

    public MeasurementNotFoundException(Integer year, String clientName) {
        super("Could not find measurement for the client: " + clientName + " in year:" + year);
    }

    public MeasurementNotFoundException(String clientName) {
        super("Could not find measurement for yesterday");
    }

    public MeasurementNotFoundException(Integer year, Integer month, String clientName) {
        super("Could not find measurement for the client: " + clientName + " in year:" + year + " in month:" + month);
    }

    public MeasurementNotFoundException(Long deviceId) {
        super("Could not find measurement for the device id: " + deviceId);
    }

    public MeasurementNotFoundException(MeasurementDevice device) {
        super("Could not find measurement for the device: " + device.toString());
    }
}
