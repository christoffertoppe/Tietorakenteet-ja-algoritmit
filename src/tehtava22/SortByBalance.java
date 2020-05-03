package tehtava22;

import java.util.Comparator;

public class SortByBalance implements Comparator<TrafficCard>{


	@Override
	public int compare(TrafficCard a, TrafficCard b) {
		if(a.mBalance > b.mBalance)
			return 1;
		
		else if(a.mBalance < b.mBalance)
			return -1;
		
		return 0;
	}
}
