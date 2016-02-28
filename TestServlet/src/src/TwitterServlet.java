package src;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Servlet implementation class TwitterServlet
 */
@WebServlet("/TwitterServlet")
public class TwitterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TwitterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String stype = request.getParameter("type");
		String searchText = request.getParameter("searchtext");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<table align=center>");
		
		/*Properties prop = new Properties();
		try {
			  
		      prop.load(TwitterServlet.class.getClassLoader().getResourceAsStream("twitter4j.properties"));

		     // System.out.println(prop.getProperty("oauth.consumerKey"));	

		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}*/
		ConfigurationBuilder cb = new ConfigurationBuilder();
	       cb.setDebugEnabled(true)
	           .setOAuthConsumerKey("U9uFhfpFG6Oskltd3gT6tdR3F")
	           .setOAuthConsumerSecret("makPlYDWh4LUIRooQo4HZUIuFqctfDPbU2iozxaZzYv9hGVfb9")
	           .setOAuthAccessToken("89654639-y6awTLtGQYjdJH54ckGQpIOXEJr8uEBcGxQZinhga")
	           .setOAuthAccessTokenSecret("13ET4KSRRSsYk9v3kFtx2vMHHFbE20obUZDnoeEtpx3P0");
		
	       TwitterFactory factory = new TwitterFactory(cb.build());
	       Twitter twitter = factory.getInstance();
		
		
		try{
		
			if(stype.equals("bytopic"))
		{
			Query query = new Query(searchText);
			query.setCount(100);
			QueryResult results = twitter.search(query);
			List<Status> cityStatus = results.getTweets();
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			out.println("<tr>");
			out.println("<td>User</td>");
			out.println("<td>Tweet time</td>");
			out.println("<td>Tweet</td>");
			out.println("<td>user location</td>");
			out.println("<td>retweet count</td>");
			out.println("<td>favorite count</td>");
			out.println("<td>no of followers</td>");
			out.println("<td>user time zone</td>");
			out.println("</tr>");
			for(Status city: cityStatus)
			{
				out.println("<tr>");
				out.println("<td>" +city.getUser().getScreenName()+ "</td>");
				out.println("<td>" +df.format(city.getCreatedAt())+ "</td>");
				out.println("<td>" +city.getText()+ "</td>");
				out.println("<td>" +city.getUser().getLocation()+ "</td>");
				out.println("<td>" +city.getRetweetCount()+ "</td>");
				out.println("<td>" +city.getFavoriteCount()+ "</td>");
				out.println("<td>" +Integer.toString(city.getUser().getFollowersCount())+ "</td>");
				out.println("<td>" +city.getUser().getTimeZone()+ "</td>");
				out.println("</tr>");
				//out.println("<td>" + "</td>");// 100 tweet search by query
			}
			
		}
		
		else
		{
			List<Status> cityStatus = twitter.getUserTimeline(searchText);
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			out.println("<tr>");
			out.println("<td>User</td>");
			out.println("<td>Tweet time</td>");
			out.println("<td>Tweet</td>");
			out.println("<td>user location</td>");
			out.println("<td>retweet count</td>");
			out.println("<td>favorite count</td>");
			out.println("<td>no of followers</td>");
			out.println("<td>user time zone</td>");
			out.println("</tr>");
			for(Status city: cityStatus)
			{
				out.println("<tr>");
				out.println("<td>" +city.getUser().getScreenName()+ "</td>");
				out.println("<td>" +df.format(city.getCreatedAt())+ "</td>");
				out.println("<td>" +city.getText()+ "</td>");
				out.println("<td>" +city.getUser().getLocation()+ "</td>");
				out.println("<td>" +city.getRetweetCount()+ "</td>");
				out.println("<td>" +city.getFavoriteCount()+ "</td>");
				out.println("<td>" +Integer.toString(city.getUser().getFollowersCount())+ "</td>");
				out.println("<td>" +city.getUser().getTimeZone()+ "</td>");
				out.println("</tr>");
				//out.println("<td>" + "</td>");// 100 tweet search by query
			}
			//15 search of user by usertimeline
		}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		
		
		out.println("</table>");
		out.println("<h3> 812 </h3>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
