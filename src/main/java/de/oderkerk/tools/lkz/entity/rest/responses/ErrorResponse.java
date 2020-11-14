package de.oderkerk.tools.lkz.entity.rest.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Standard error message of the application",title = "Error Message")
public class ErrorResponse {

	@Schema(description = "Fehlernummer")
	private int errorNo;
	@Schema(description = "Fehlertext in prosa")
	private String errorText;
	@Schema(description = "Zeitstempel zu dem der Fehler auftrat")
	private String errorTimestamp;
	@Schema(description = "Eindeutiger Schlüssel für die Analyse von Fehlern")
	private String uniqueID;
	

}
