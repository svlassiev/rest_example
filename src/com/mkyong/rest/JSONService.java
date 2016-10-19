package com.mkyong.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import java.io.IOException;


@Path("/json/metallica")
public class JSONService {
//
//	@GET
//	@Path("/get")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Track getTrackInJSON() {
//
//		Track track = new Track();
//		track.setTitle("Enter Sandman");
//		track.setSinger("Metallica");
//
//		return track;
//
//	}
//
//	@POST
//	@Path("/post")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response createTrackInJSON(Track track) {
//
//		String result = "Track saved : " + track;
//		return Response.status(201).entity(result).build();
//
//	}
//
//	@GET
//	@Path("/print{param}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getAndPrint(@PathParam("param") String param) {
//		return param;
//	}
//
//	@GET
//	@Path("/query")
//	public Response getUsers(
//			@QueryParam("from") int from,
//			@QueryParam("to") int to,
//			@QueryParam("orderBy") List<String> orderBy) {
//
//		return Response
//				.status(200)
//				.entity("getUsers is called, from : " + from + ", to : " + to
//						+ ", orderBy" + orderBy.toString()).build();
//
//	}
//

	private HttpServletResponse response;

	@GET
	@Path("/vulnqueryandheader")
	public String printVulnAndHeader(@QueryParam("vulnparam") String from, @HeaderParam("vulnheader") String header, String param) throws IOException {
		response.getWriter().print(from);
		response.getWriter().print(header);
		response.getWriter().print(param);
		return from;
	}

	@GET
	@Path("/vulnquery")
	public String printVuln(@QueryParam("vuln") String from) throws IOException {
		response.getWriter().print(from);
		return from;
	}

	@GET
	@Path("/vulnheader")
	public String printHeaderVuln(@HeaderParam("vuln") String header) throws IOException {
		response.getWriter().print(header);
		return header;
	}
//
//	@GET
//	@Path("/vulnpath{param}")
//	public String printPathVuln(@PathParam("param") String from) throws IOException {
//		response.getWriter().print(from);
//		return from;
//	}
//
//	public String print(String from) throws IOException {
//		response.getWriter().print(from);
//		return from;
//	}
}