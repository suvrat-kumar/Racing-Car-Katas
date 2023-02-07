package tddmicroexercises.telemetrysystem;

public interface ConnectionClient {
    boolean getOnlineStatus();

    void connect(String telemetryServerConnectionString);

    void disconnect();
}
