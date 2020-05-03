/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehtava20;

import java.util.*;

/**
 *
 * @author kamaj
 */
public class TrafficCard implements Comparable<TrafficCard>{
    int mTravellerNumber;
    String mOwnerName;
    float mBalance;
    
    public TrafficCard(int tNumber, String oName, float balance){
        mTravellerNumber = tNumber;
        mOwnerName = oName;
        mBalance = balance;
    }
    
    @Override
    public String toString(){
        return "owner: "+mOwnerName+" number: "+mTravellerNumber+" balance: "+mBalance;
    }


	@Override
	public int compareTo(TrafficCard o) {
		if(this.mBalance > o.mBalance) {
			return 1;
		} else if(this.mBalance < o.mBalance) {
			return -1;
		}
		return 0;
	}
}
