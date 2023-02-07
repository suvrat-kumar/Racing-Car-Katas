package tddmicroexercises.telemetrysystem;

public interface ConnectionClientTemplate {

    static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    String receive();

    void send(String message);
}
