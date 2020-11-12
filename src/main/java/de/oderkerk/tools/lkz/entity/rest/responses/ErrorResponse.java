package de.oderkerk.tools.lkz.entity.rest.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Standard error message of the application",title = "Error Message")
public class ErrorResponse {

	@Schema(description = "Error number identifying the error occured")
	private int errorNo;
	@Schema(description = "Errortext descripbing the error in prosa")
	private String errorText;
	@Schema(description = "Timestamp of the creation of the error")
	private String errorTimestamp;
	@Schema(description = "Request Id for tracing the error in the log files")
	private String uniqueID;
	

}
