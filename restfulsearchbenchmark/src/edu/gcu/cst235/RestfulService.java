package edu.gcu.cst235;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import edu.gcu.cst235.worker.*;

/**
 * web service searches for and returns the number of times a word appears in a text file (Romans 8)
 * @author Roy Chancellor
 *
 */
@ApplicationPath("/wordsearch")
public class RestfulService extends Application {
	
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(RestfulService.class)); 
	}
		    
	/**
	 * service that searches for and returns a count of the search word from Romans 8
	 * @return Response object that the front end can parse
	 */
	@POST
	@Path("/romans8")
	@Produces("text/html")
	public Response returnWord(@FormParam("searchword") String searchWord) {
		String returnHTML = "<p>Your word " + searchWord + " appeared ";
		returnHTML += BibleWorker.searchTextForWord(searchWord) + " times in Romans 8 (NIV)";
		returnHTML += "<p><a href='/restfulsearchbenchmark/bible.html'>Back to Romans 8 Search</a>";
		return Response.ok(returnHTML).build();
	}
	
	/**
	 * A basic service for practice
	 */
	@GET
	@Path("/hello/name")
	@Produces("text/plain")
	public String displayName() {
		return "Roy";
	}
	@POST
	@Path("/hello/name")
	@Produces("text/plain")
	public String displayNamePost() {
		return "Chancellor";
	}
	
	@GET
	@Path("/hello/address")
	@Produces("text/plain")
	public String displayAddress() {
		return "{\"street\":\"123 E. Main Street\",\"city\":\"Phoenix\",\"state\":\"AZ\",\"zip\":\"85001\"}";
	}
}
