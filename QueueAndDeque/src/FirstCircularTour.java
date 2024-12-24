import java.util.Deque;
import java.util.LinkedList;

public class FirstCircularTour {
    public static void main(String[] args) {
        int [] pet = {2,8,7,4};
        int [] dist = {3,5,3,4};
        System.out.println(firstCircularTourNiveWay(pet,dist));
        System.out.println(firstCircularTourUsingDeque(pet,dist));
        System.out.println(firstCircularTourEfficientSol(pet,dist));
    }
    static int firstCircularTourNiveWay(int [] petrol,int [] dist){ // Nive approach O(n*2) TC and O(1) SC
        int n = petrol.length;

        for (int start = 0; start < n; start++) {
            int curPetrol = 0;
            int end = start;

            while (true){
                curPetrol += petrol[end] - dist[end];
                if (curPetrol < 0) break;
                end = (end+1) % n;
                if (start == end){
                    return start+1;
                }
            }
        }
        return -1;
    }

    static int firstCircularTourUsingDeque(int [] petrol,int [] dist){ // Nive approach O(n) TC and O(n) SC
        int n = petrol.length;
        Deque<Integer> dq = new LinkedList<>();
        int start = 0;
        int end = 0;
        int curPetrol = 0;

        // Initially set current petrol balance to 0
        curPetrol = petrol[start] - dist[start];
        dq.addLast(start);

        while (end != (start + n - 1) % n) {
            if (curPetrol >= 0) {
                end = (end + 1) % n;
                dq.addLast(end);
                curPetrol += petrol[end] - dist[end];
            } else {
                curPetrol -= petrol[start] - dist[start];
                dq.removeFirst();
                start = (start + 1) % n;
                // If deque is empty, move end to start and reset curPetrol
                if (dq.isEmpty()) {
                    end = start;
                    curPetrol = petrol[start] - dist[start];
                    dq.addLast(start);
                }
            }
        }

        // Final check if the accumulated petrol is non-negative
        if (curPetrol >= 0) {
            return dq.getFirst()+1;
        } else {
            return -1;
        }
    }

    static int firstCircularTourEfficientSol(int [] petrol,int [] dist){ // Nive approach O(n) TC and O(n) SC
        int n = petrol.length;
        int start = 0,curPetrol = 0,prevPetrol = 0;

        for (int i = 0; i < n; i++) {
            curPetrol += petrol[i]-dist[i];
            if (curPetrol <= 0){
                start = i+1;
                prevPetrol += curPetrol;
                curPetrol = 0;
            }
        }
        return (curPetrol+prevPetrol >= 0)? start+1 : -1;


    }
}
