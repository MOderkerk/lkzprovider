/**
 * 
 */
package de.oderkerk.tools.lkz.rest.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Result for autocomplete requests
 * @author Odin
 *
 */
@Data
@ToString
@AllArgsConstructor
@Schema(description = "Schema for result of autocompletion process", accessMode = AccessMode.READ_ONLY)
public class AutocompleteLaendernameResponse {

	@Schema(description = "Laendername found by autocomplete operation",nullable = true)
	private String laendername;
}
