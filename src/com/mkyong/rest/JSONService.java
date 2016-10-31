package com.mkyong.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URLDecoder;
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

	@GET
	@Path("/query")
	public Response getUsers(
			@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("orderBy") List<String> orderBy,
            @Context HttpServletResponse response) {

        final String entity = "getUsers is called, from : " + from + ", to : " + to + ", orderBy" + orderBy.toString();
		try { response.getWriter().print(entity); } catch (Throwable t) {} // Cross-site Scripting
		System.out.println(entity);
		return Response.status(200).entity(entity).build();
	}

	@GET
	@Path("/vulnqueryandheader")
	public String printVulnAndHeader(@QueryParam("vulnparam") String from, @HeaderParam("vulnheader") String header, String param,
                                     @Context HttpServletResponse response) {
        try { response.getWriter().print(from); } catch (Throwable t) {} // Cross-site Scripting
		System.out.println(from);
		try { response.getWriter().print(header); } catch (Throwable t) {} // Cross-site Scripting
		System.out.println(header);
		try { response.getWriter().print(param); } catch (Throwable t) {} // Cross-site Scripting
		System.out.println(param);
		return from;
	}

	@GET
	@Path("/printPath{param}")
	public String getAndPrint(@PathParam("param") String param,
                              @Context HttpServletResponse response) {
        try { response.getWriter().print(param); } catch (Throwable t) {} // Cross-site Scripting
		return param;
	}

	@GET
	@Path("/vulnquery")
	public String printVuln(@QueryParam("vuln") String from,
                                         @Context HttpServletResponse response) {
		try { response.getWriter().print(from); } catch (Throwable t) {} // Cross-site Scripting
		return from;
	}

    @GET
    @Encoded
    @Path("/vulnencodedquery")
    public String printVulnEncoded(@QueryParam("vuln") String from,
                                   @Context HttpServletResponse response) {
        try { response.getWriter().print(URLDecoder.decode(from)); } catch (Throwable t) {} // Cross-site Scripting
        return URLDecoder.decode(from);
    }

    @GET
    @Path("/notvulnencodedquery")
    public String printNotVulnEncoded(@Encoded @QueryParam("vuln") String from,
                                      @Context HttpServletResponse response) {
        try { response.getWriter().print(from); } catch (Throwable t) {}
        return from;
    }

    @GET
	@Path("/vulnheader")
	public String printHeaderVuln(@HeaderParam("vuln") String header,
                                  @Context HttpServletResponse response) {
        try { response.getWriter().print(header); } catch (Throwable t) {} // Cross-site Scripting
		return header;
	}

    @GET
    @Path("/vulncookie")
    public String printCookieVuln(@CookieParam("vuln") String cookie,
                                  @Context HttpServletResponse response) {
        try { response.getWriter().print(cookie); } catch (Throwable t) {} // Cross-site Scripting
        return cookie;
    }

    @POST
    @Path("/add")
    public String addUser(
            @FormParam("name") String name,
            @FormParam("age") int age,
            @Context HttpServletResponse response) {
        try { response.getWriter().print(name); } catch (Throwable t) {} // Cross-site Scripting
        return age + name;
    }
}