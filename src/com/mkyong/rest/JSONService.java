package com.mkyong.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/json/metallica")
public class JSONService {

//	@GET
//	@Path("/getJson")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Track getTrackInJSON() {
//		Track track = new Track();
//		track.setTitle("Enter Sandman");
//		track.setSinger("Metallica");
//		return track;
//	}
//
//	@GET
//	@Path("/getXML")
//	@Produces(MediaType.APPLICATION_XML)
//	public Track getTrackInXML() {
//		Track track = new Track();
//		track.setTitle("Enter Sandman");
//		track.setSinger("Metallica");
//		return track;
//	}
//
//	@POST
//	@Path("/post")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response createTrackInJSON(Track track) {
//		String result = "Track saved : " + track;
//		return Response.status(201).entity(result).build();
//	}

	private HttpServletResponse response;

	@GET
	@Path("/query")
	public Response getUsers(
			@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("orderBy") List<String> orderBy) {
		final String entity = "getUsers is called, from : " + from + ", to : " + to + ", orderBy" + orderBy.toString();
		try { response.getWriter().print(entity); } catch (Throwable t) {} // Cross-site Scripting
		return Response.status(200).entity(entity).build(); // Cross-site Scripting
	}

	@GET
	@Path("/vulnqueryandheader")
	public String printVulnAndHeader(@QueryParam("vulnparam") String from, @HeaderParam("vulnheader") String header, String param) {
		try { response.getWriter().print(from); } catch (Throwable t) {} // Cross-site Scripting
		try { response.getWriter().print(header); } catch (Throwable t) {} // Cross-site Scripting
		try { response.getWriter().print(param); } catch (Throwable t) {} // Cross-site Scripting
		return from;
	}

	@GET
	@Path("/printPath{param}")
	public String getAndPrint(@PathParam("param") String param) {
		try { response.getWriter().print(param); } catch (Throwable t) {} // Cross-site Scripting
		return param; // Cross-site Scripting
	}

	@GET
	@Path("/vulnquery")
	public String printVuln(@QueryParam("vuln") String from) {
		try { response.getWriter().print(from); } catch (Throwable t) {} // Cross-site Scripting
		return from; // Cross-site Scripting
	}
//
//    @GET
//    @Encoded
//    @Path("/vulnencodedquery")
//    public String printVulnEncoded(@QueryParam("vuln") String from) {
//        try { response.getWriter().print(from); } catch (Throwable t) {} // Cross-site Scripting
//        return from; // Cross-site Scripting
//    }

	@GET
	@Path("/vulnheader")
	public String printHeaderVuln(@HeaderParam("vuln") String header) {
		try { response.getWriter().print(header); } catch (Throwable t) {} // Cross-site Scripting
		return header; // Cross-site Scripting
	}

    @GET
    @Path("/vulncookie")
    public String printCookieVuln(@CookieParam("vuln") String cookie) {
        try { response.getWriter().print(cookie); } catch (Throwable t) {} // Cross-site Scripting
        return cookie; // Cross-site Scripting
    }
}