package de.oderkerk.tools.lkz.entity.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import de.oderkerk.tools.lkz.entity.LKZEntity;
import de.oderkerk.tools.lkz.entity.rest.responses.LKZResponse;
import de.oderkerk.tools.lkz.exception.NoDataFoundException;

@SpringBootTest
class LKZRestControllerTest {

	@Autowired
	public LKZRestController controllerToTest;

	@BeforeEach
	protected void setUp() throws Exception {
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	void readWithISO2Ok() {
		try {
			ResponseEntity<LKZResponse> result = controllerToTest.readWithIso2("DE");
			assertEquals("Deutschland", result.getBody().getLaendername());
		} catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
	@Test
	void readWithISO2NOk() {
		try {
			ResponseEntity<LKZResponse> result = controllerToTest.readWithIso2("DEX");
			
		}
		catch (NoDataFoundException nex)
		{
			assertNotNull(nex);
		} catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
	@Test
	void readWithISO3Ok() {
		try {
			ResponseEntity<LKZResponse> result = controllerToTest.readWithIso3("DEU");
			assertEquals("Deutschland", result.getBody().getLaendername());
		} catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
	@Test
	void readWithISO3NOk() {
		try {
			ResponseEntity<LKZResponse> result = controllerToTest.readWithIso3("DE");
			
		}
		catch (NoDataFoundException nex)
		{
			assertNotNull(nex);
		} catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
	@Test
	void readWithLaenderNameOk() {
		try {
			ResponseEntity<LKZResponse> result = controllerToTest.readWithLaenderName("Deutschland");
			assertEquals("Deutschland", result.getBody().getLaendername());
			assertEquals("DE", result.getBody().getIso316612());
		}
		catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
	@Test
	void readWithLaenderNameNOk() {
		try {
			ResponseEntity<LKZResponse> result = controllerToTest.readWithLaenderName("DeutschlandX");
			
		}
		catch (NoDataFoundException nex)
		{
			assertNotNull(nex);
		} catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
	@Test
	void readWithKfzNameOk() {
		try {
			ResponseEntity<List<LKZResponse>> result = controllerToTest.readwithKFZLKZ("D");
			assertEquals("Deutschland", result.getBody().get(0).getLaendername());
			assertEquals("DE", result.getBody().get(0).getIso316612());
		}
		catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
	@Test
	void readWithKfzNameNOk() {
		try {
			ResponseEntity<List<LKZResponse>> result = controllerToTest.readwithKFZLKZ("DD");
			
		}
		catch (NoDataFoundException nex)
		{
			assertNotNull(nex);
		} catch (Exception ex) {
			fail("Exception occured but not exspected");
		}
	}
}
