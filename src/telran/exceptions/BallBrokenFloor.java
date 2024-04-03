package telran.exceptions;

import java.util.Random;

public class BallBrokenFloor {
    private int brokenFloor;
    private int nFloors;

    public BallBrokenFloor(int nFloors) {
        this.nFloors = nFloors;
        brokenFloor = new Random().nextInt(1, nFloors + 1);
    }

    public int getBrokenFloor() {
        return brokenFloor;
    }

    public void checkFloor(int floor) throws Exception {
        if (floor >= brokenFloor) {
            throw new Exception();
        }
    }
    
    public int getMinBrokenFloor() {
        int low = 1;
        int high = nFloors;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            try {
                this.checkFloor(mid);
                low = mid + 1;
            } catch (Exception e) {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }
}
