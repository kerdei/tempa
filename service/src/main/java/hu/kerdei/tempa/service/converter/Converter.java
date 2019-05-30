package hu.kerdei.tempa.service.converter;

import org.modelmapper.ModelMapper;

public class Converter {

    private static final Converter instance = new Converter();

    public ModelMapper modelMapper;

    private Converter() {
        modelMapper = new ModelMapper();
    }

    public static Converter getInstance() {
        return instance;
    }
}
