import java.util.*;

class Table {
    synchronized void table(int n) {
        for(int i=1;i<=5;i++){
            System.out.println(i*n);
            try{
                Thread.sleep(200);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
class ageComp implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        int a =o1;
        int b=o2;
        if (a==b)
            return 0;
        else if (a>b) {
            return 1;
        }
        else return -1;
    }
}
class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    @Override
    public void run() {
         t.table(5);
    }
}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    @Override
    public void run() {
        t.table(100);
    }
}
public class MultiThreadProgram {
    public static void main(String[] args) {
//        Table tab = new Table();
//        MyThread1 th = new MyThread1(tab);
//        MyThread2 th2 = new MyThread2(tab);
//        th.start();
//        th2.start();
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(34);
        ar.add(64);
        ar.add(72);
        ar.add(23);
        ar.add(57);
        Collections.sort(ar,new ageComp());
        for (int i:ar){
            System.out.print(i+ " ");
        }
    }
}