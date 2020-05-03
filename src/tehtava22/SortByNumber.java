package tehtava22;

import java.util.Comparator;

public class SortByNumber implements Comparator<TrafficCard>{


	@Override
	public int compare(TrafficCard a, TrafficCard b) {
		if(a.mTravellerNumber > b.mTravellerNumber)
			return 1;
		
		else if(a.mTravellerNumber < b.mTravellerNumber)
			return -1;
		
		return 0;
	}
}