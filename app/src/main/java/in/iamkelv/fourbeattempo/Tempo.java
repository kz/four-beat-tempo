package in.iamkelv.fourbeattempo;

import java.util.ArrayList;

public class Tempo {
    // Member variables
    public double mTempo;
    private ArrayList<Long> mTimeAtPressArray = new ArrayList<Long>();
    private ArrayList<Long> mTimeBetweenPressArray = new ArrayList<Long>();

    // Methods
    public void setTimeAtPress() {
        mTimeAtPressArray.add(System.currentTimeMillis());
    }

    public void setTimeBetweenPress() {
        for (int i = 0; i < mTimeAtPressArray.size() - 1; i++) {
            long startTime = mTimeAtPressArray.get(i);
            long endTime = mTimeAtPressArray.get(i + 1);
            long timeBetweenPress = endTime - startTime;
            mTimeBetweenPressArray.add(timeBetweenPress);
        }
    }

    public int returnTempo() {
        // Create an array of time between presses.
        setTimeBetweenPress();
        // Calculate the total time accumulated between presses.
        int sumOfTime = 0;
        for (long timeBetweenPress : mTimeBetweenPressArray) {
            sumOfTime += (int) timeBetweenPress;
        }
        // Calculate the average time between presses.
        double avgTimeBetweenPress = (double) sumOfTime / 2000;
        // Calculate the tempo.
        mTempo = (double) 60 / avgTimeBetweenPress;

        return (int) Math.round(mTempo);
    }

    public void resetVariables() {
        mTimeAtPressArray.clear();
        mTimeBetweenPressArray.clear();
    }

}
