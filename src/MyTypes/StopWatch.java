package MyTypes;

import utils.Outputs;

import java.io.OutputStream;
import java.util.ArrayList;

public class StopWatch {
    private long startTime;
    private ArrayList<Long> segmentationTime;
    private long endTime;

    public StopWatch(){
        startTime = 0;
        segmentationTime = new ArrayList<>();
        endTime = 0;
    }

    public void begin(){
        endTime = 0;
        segmentationTime.clear();
        startTime = System.currentTimeMillis();
    }

    public void segment(){
        segmentationTime.add(System.currentTimeMillis() - this.startTime);
    }

    public void stop(){
        endTime = System.currentTimeMillis() - this.startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long l :
                this.segmentationTime) {
            stringBuilder.append(l).append(" ");
        }
        stringBuilder.append(endTime).append("\n");
        return stringBuilder.toString();
    }
}
