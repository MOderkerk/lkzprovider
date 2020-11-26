/**
 * 
 */
package de.oderkerk.tools.lkz.rest.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response with all informations
 * 
 * @author Odin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Alle in der Datenbank gespeicherten Daten zu einem Land", title = "Länderdaten",accessMode = AccessMode.READ_ONLY)
public class LKZResponse {

	@Schema(description = "Ländername in deutscher Sprache")
	private String laendername;

	@Schema(description = " Die Bezeichnung „Destatis BEV-Code“.  Hier das Gebiet.",nullable = true)
	private Integer destatisBEVCodeGebiet;

	@Schema(description = " Die Bezeichnung „Destatis BEV-Code“. Hier die Staatsangehörigkeit.",nullable = true)
	private Integer destatisBEVCodeStaatsang;

	@Schema(description = " Die Bezeichnung „Destatis BEV-Code“. Hier der Staat.",nullable = true)
	private Integer destatisBEVCodeStaat;

	@Schema(description = "2 stell. Länderkennzeichen gem. ISO31661",nullable = true)
	private String iso316612;

	@Schema(description = "3 stell. Länderkennzeichen gem. ISO31661",nullable = true)
	private String iso316613;

	@Schema(description = "Nummerisches Länderkennzeichen gem. ISO31661",nullable = true)
	private Integer iso31661num;

	@Schema(description = "Länderkennzeichem gem. ICAO.int",nullable = true)
	private String icao;

	@Schema(description = "Aussehnhandelscode gem. DESTATIS",nullable = true)
	private String destatisAussenhandelsCode;

	@Schema(description = "KFZ Länderkennzeichen",nullable = true)
	private String kfzKennzeichen;

	@Schema(description = "Länderzusatz für den internationalen Postversand",nullable = true)
	private String laenderzusatzAdressFeldPost;
	
	@Schema(description = "2 stell LKZ gem der Bundesbank", nullable = true)
	private String bankLKZ2;

	@Schema(description = "num  LKZ gem der Bundesbank", nullable = true)
	private Integer bankLKZnum;

	@Schema(description = "Landkürzel gem der Bundesbank", nullable = true)
	private String bankLandkuerzel;

	@Schema(description = "Waehrungscode der Bundesbank", nullable = true)
	private String bankWaehrungcode;
	
	@Schema(description = "Nachweis Datenquelle und Datenstand",defaultValue = "DatenQuelle: https://www.destatis.de Stand 12.11.2020")
	private String datenquelle;


}
