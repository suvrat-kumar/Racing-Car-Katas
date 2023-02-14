package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private final ConnectionClient telemetryClient;
    private final ConnectionClientTemplate telemetryClientTemplate;
    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls(final ConnectionClient telemetryClient, final ConnectionClientTemplate telemetryClientTemplate)
        {
            this.telemetryClient = telemetryClient;
            this.telemetryClientTemplate = telemetryClientTemplate;
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            telemetryClient.disconnect();
    
            int retryLeft = 3;
            while (telemetryClient.getOnlineStatus() == false && retryLeft > 0)
            {
                telemetryClient.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(telemetryClient.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }

            telemetryClientTemplate.send(telemetryClientTemplate.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = telemetryClientTemplate.receive();
    }
}
