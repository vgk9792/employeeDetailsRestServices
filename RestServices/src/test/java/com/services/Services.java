package com.services;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Services {
	public static Services services = null;
	Response response = null;

	/**
	 * 
	 */
	private Services() {

	}

	/**
	 *	 * This method indicates get services object
	 * @return object
	 */
	public static Services getInstanceService() {
		if (services == null) {
			services = new Services();
			return services;
		} else {
			return services;
		}
	}

	/**
	 *This method indicates get Request
	 * @param rootUrl
	 * @return object
	 */
	public Response getRequest(String rootUrl) {
		try {
			response = RestAssured.given().contentType(ContentType.JSON).get(rootUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 *  *This method indicates delete Request
	 * @param rootUrl
	 * @return object
	 */
	public Response deleteRequest(String rootUrl) {
		try {
			response = RestAssured.given().contentType(ContentType.JSON).delete(rootUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * This method indicates get post request
	 * @param headers
	 * @param rootUrl
	 * @param body
	 * @return object
	 */
	public Response postRequest(Map<String, String> headers, String rootUrl, Object body) {
		try {
			response = RestAssured.given().contentType(ContentType.JSON).headers(headers).body(body).post(rootUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * This method indicates get Json object
	 * @param headers
	 * @param rootUrl
	 * @param body
	 * @return object
	 */
	public Response UpdateRequest(Map<String, String> headers, String rootUrl, Object body) {
		try {
			response = RestAssured.given().contentType(ContentType.JSON).headers(headers).body(body).put(rootUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * This method indicates get Json object
	 * @param response
	 * @return int
	 */
	public int getReponseCode(Response response) {
		return response.getStatusCode();
	}

	/**
	 * This method indicates get Json object
	 * @param response
	 * @return object
	 */
	public JsonPath getJsonObject(Response response) {
		return response.jsonPath();
	}
}
