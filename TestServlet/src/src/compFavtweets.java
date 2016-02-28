package src;

import java.util.Comparator;

import twitter4j.Status;
public class compFavtweets implements Comparator<Status> {
	public int compare(Status a, Status b)
	{
	if(a.getFavoriteCount() < b.getFavoriteCount()) return -1; // highest value first
	if(a.getFavoriteCount() == b.getFavoriteCount()) return 0;
	return 1;
	 }
}



