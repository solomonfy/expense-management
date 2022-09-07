//package dev.sol.api;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.POST;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import dev.sol.models.Employee;
//import dev.sol.services.EmployeeService;
//
//public class LogInController {
//	
//	private EmployeeService empService = new EmployeeService();
//	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
////	@Consumes(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	
//	public Response authenticateEmployee(@FormParam("userName") String userName, @FormParam("password") String password) {
//		
//		
//		try {
//
//            // Authenticate the user using the credentials provided
//            authenticate(userName, password);
//
//            // Issue a token for the user
//            String token = issueToken(userName);
//
//            // Return the token on the response
//            return Response.ok(token).build();
//
//        } catch (Exception e) {
//            return Response.status(Response.Status.FORBIDDEN).build();
//        }      
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//    	
//    	Employee employee = empService.findUserByUsernameandPassword(username, password);
//    	
//    	System.out.println(employee);
//    	
//    	if(employee != null) {
//    		
//    	} else {
//    		 Response.status(404).build();
//    	}
//    	
//        // Authenticate against a database, LDAP, file or whatever
//        // Throw an Exception if the credentials are invalid
//    }
//
//    private String issueToken(String userName) {
//        // Issue a token (can be a random String persisted to a database or a JWT token)
//        // The issued token must be associated to a user
//        // Return the issued token
//    	return null;
//    }
//
//}
