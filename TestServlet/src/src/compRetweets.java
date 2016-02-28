package src;

import java.util.Comparator;

import twitter4j.Status;
public class compRetweets implements Comparator<Status> {
	public int compare(Status a, Status b)
	{
	if(a.getRetweetCount() < b.getRetweetCount()) return -1; // highest value first
	if(a.getRetweetCount() == b.getRetweetCount()) return 0;
	return 1;
	 }
}
