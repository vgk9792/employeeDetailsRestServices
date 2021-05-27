package com.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.services.Services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RESTAssuredJSONTests {

	final static String ROOT_URI = "http://dummy.restapiexample.com/api/v1";

	/*
	 * This method indicates the 
	 * GET services or all employees
	 */
	@Test(priority = 1)
	public void get_all_employees_test() {
		Services services=Services.getInstanceService();
		Response response = services.getRequest(ROOT_URI + "/employees");		
		Assert.assertEquals(200, services.getReponseCode(response));
	}

	/*
	 * This method indicates the 
	 * GET services for particular employee
	 */
	@Test(dependsOnMethods = "get_all_employees_test", alwaysRun = true)
	public void get_all_employe_by_id_test() {
		Services services=Services.getInstanceService();
		Response response = services.getRequest(ROOT_URI + "/employee/719");		
		Assert.assertEquals(200, services.getReponseCode(response));
		// Creation of JsonPath object
		JsonPath jsonPathValidator = services.getJsonObject(response);
		Assert.assertEquals(jsonPathValidator.get("status"),"success");
		Assert.assertEquals(jsonPathValidator.get("data.id"),"1");
		Assert.assertEquals( jsonPathValidator.get("data.employee_name"),"Tiger Nixon");
		Assert.assertEquals(jsonPathValidator.get("data.employee_salary"),"320800");
		Assert.assertEquals(jsonPathValidator.get("data.employee_age"),"61");

	}

	/*
	 * This method indicates the 
	 * DELETE services for particular employee
	 */
	@Test(dependsOnMethods = "get_all_employees_test", alwaysRun = true)
	public void delete_employe_by_id_test() {
		Services services=Services.getInstanceService();
		Response response = services.deleteRequest(ROOT_URI + "/delete/2");			
		Assert.assertEquals(200, services.getReponseCode(response));
		// Creation of JsonPath object
		JsonPath jsonPathValidator = services.getJsonObject(response);		
		Assert.assertEquals("success", jsonPathValidator.get("status"));
		Assert.assertEquals( jsonPathValidator.get("message"),"successfully! deleted Records");

	}
}