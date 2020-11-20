package de.oderkerk.tools.lkz.rest;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.oderkerk.tools.lkz.entity.LKZEntity;
import de.oderkerk.tools.lkz.entity.rest.responses.AutocompleteLaendernameResponse;
import de.oderkerk.tools.lkz.entity.rest.responses.LKZResponse;
import de.oderkerk.tools.lkz.exception.NoDataFoundException;
import de.oderkerk.tools.lkz.repository.LKZRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Restcontroller for all request regarding the lkz
 * 
 * @author Odin
 * @version 11-2020
 */
@RestController
@RequestMapping(path = "api/lkz")
@Slf4j
public class LKZRestController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5342310651305768232L;
	@Autowired
	private LKZRepository lkzRepository;
	
	@GetMapping("/landname/{laendername}")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "404", description = "No data found with laendername"),
	@ApiResponse(responseCode = "200", description = "Data found and LKZResponse send to caller") })	
	@Parameter(name = "laendername",description = "Name of country to look for in german language",in = ParameterIn.PATH,required = true)
	@Operation(summary = "Read with laendername", description = "Function to read additional data from the Database with the countryname. Database only supports german names of countries")
	public ResponseEntity<LKZResponse> readWithLaenderName(@PathVariable String laendername) throws NoDataFoundException
	{
		log.debug("Read With Laendername = {} started",laendername);
		Optional<LKZEntity> result = lkzRepository.findById(laendername);
		if (result.isPresent())
		{
			return new ResponseEntity<>(DataStructureConverter.convertFromLKZEntityToLKZResponse(result.get()),HttpStatus.OK);
		}
		else
		{
			throw new NoDataFoundException(laendername);
		}
	}
	
	@GetMapping("/iso2/{isokz}")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "404", description = "No data found with Iso2 lkz"),
	@ApiResponse(responseCode = "200", description = "Data found and LKZResponse send to caller") })	
	@Parameter(name = "isokz",description = "ISO316612 of country to look for in german language",in = ParameterIn.PATH,required = true)
	@Operation(summary = "Read with Iso316612", description = "Function to read additional data from the Database with the countryname. Database only supports german names of countries")
	public ResponseEntity<LKZResponse> readWithIso2(@PathVariable String isokz) throws NoDataFoundException
	{
		log.debug("Read With Iso2 = {} started",isokz);
		Optional<LKZEntity> result = lkzRepository.findByIso316612(isokz.toUpperCase());
		if (result.isPresent())
		{
			return new ResponseEntity<>(DataStructureConverter.convertFromLKZEntityToLKZResponse(result.get()),HttpStatus.OK);
		}
		else
		{
			throw new NoDataFoundException(isokz);
		}
	}
	@GetMapping("/iso3/{isokz}")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "404", description = "No data found with Iso3 lkz"),
	@ApiResponse(responseCode = "200", description = "Data found and LKZResponse send to caller") })	
	@Parameter(name = "isokz",description = "Iso316613 of country to look for in german language",in = ParameterIn.PATH,required = true)
	@Operation(summary = "Read with Iso316613", description = "Function to read additional data from the Database with the countryname. Database only supports german names of countries")
	public ResponseEntity<LKZResponse> readWithIso3(@PathVariable String isokz) throws NoDataFoundException
	{
		log.debug("Read With Iso3 = {} started",isokz);
		Optional<LKZEntity> result = lkzRepository.findByIso316613(isokz.toUpperCase());
		if (result.isPresent())
		{
			return new ResponseEntity<>(DataStructureConverter.convertFromLKZEntityToLKZResponse(result.get()),HttpStatus.OK);
		}
		else
		{
			throw new NoDataFoundException(isokz);
		}
	}
	@GetMapping("/kfz/{kfz}")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "404", description = "No data found with kfz countrycode"),
	@ApiResponse(responseCode = "200", description = "Data found and list of LKZResponses  send to caller") })	
	@Parameter(name = "kfz",description = "KFZ(car plate) countrycode of country to look for in german language",in = ParameterIn.PATH,required = true)
	@Operation(summary = "Read with kfz countrycode", description = "Function to read additional data from the Database with the countryname. Database only supports german names of countries")
	public ResponseEntity<List<LKZResponse>> readwithKFZLKZ(@PathVariable String kfz) throws NoDataFoundException
	{
		log.debug("Read With Iso3 = {} started",kfz);
		List<LKZEntity> result = lkzRepository.findByKfzKennzeichen(kfz.toUpperCase());
		if (!result.isEmpty())
		{
			List<LKZResponse> response = new ArrayList<>();
			for (LKZEntity entity:result)
			{
				response.add(DataStructureConverter.convertFromLKZEntityToLKZResponse(entity));
			}
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else
		{
			throw new NoDataFoundException(kfz);
		}
	}
	
	@GetMapping("/autocomplete/{laendernameInput}")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "404", description = "No data found with part of laendername countrycode"),
	@ApiResponse(responseCode = "200", description = "Data found and list of LKZResponses  send to caller") })	
	@Parameter(name = "laendernameInput",description = "partitial laendername for autocomplete of name",in = ParameterIn.PATH,required = true)
	@Operation(summary = "Read laendername for autocompletion", description = "Function to autocomplete country name.")
	public ResponseEntity<List<AutocompleteLaendernameResponse>> autocompleteLaendername(@PathVariable String laendernameInput) throws NoDataFoundException
	{
		log.debug("Try autocomplete with  = {} started",laendernameInput);
		List<LKZEntity> result = lkzRepository.findByLaendernameContainingIgnoreCase(laendernameInput);
		if (!result.isEmpty())
		{
			List<AutocompleteLaendernameResponse> response = new ArrayList<>();
			for (LKZEntity entity:result)
			{
				response.add(new AutocompleteLaendernameResponse(entity.getLaendername()));
			}
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else
		{
			throw new NoDataFoundException(laendernameInput);
		}
	}

}
