package tddmicroexercises.telemetrysystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class TelemetryDiagnosticControlsTest
{

    private final TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(new TelemetryClient(), new TelemetryClientTemplate());
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        String infoBefore = telemetryDiagnosticControls.getDiagnosticInfo();
        assertTrue(StringUtils.isBlank(infoBefore));
        telemetryDiagnosticControls.checkTransmission();
        String infoAfter = telemetryDiagnosticControls.getDiagnosticInfo();
        assertFalse(StringUtils.isBlank(infoAfter));
    }

}
