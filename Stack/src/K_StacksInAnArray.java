class KStacks{

    private final int [] arr,next,top,size;
    private final int cap, k;
    private int freeTop;

    KStacks(int cap,int k){
        this.cap = cap;
        arr = new int[cap];
        next = new int[cap];
        top = new int[k];
        size = new int[k];
        freeTop = 0;
        this.k = k;
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        for (int i = 0; i < cap-1; i++) {
            next[i] = i+1;
        }
        next[cap-1] = -1;
    }


    public boolean isFull()
    {
        return (freeTop == -1);
    }
    public boolean isEmpty(int sn)
    {
        return (top[sn] == -1);
    }

    public int size(int sn){
        return size[sn];
    }

    public void push(int x, int sn){
        if (isFull())
        {
            System.out.println("Stack Overflow");
            return;
        }

        int ind = freeTop;
        freeTop = next[ind];
        next[ind] = top[sn];
        top[sn] = ind;
        arr[ind] = x;
        size[sn]++;
    }

    public int pop(int sn){

        if (isEmpty(sn))
        {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }

        int ind = top[sn];
        top[sn] = next[ind];
        next[ind] = freeTop;
        freeTop = ind;
        size[sn]--;
        return arr[ind];
    }
    public int peek(int sn){
        if (isEmpty(sn))
        {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }
        return arr[top[sn]];
    }
}

public class K_StacksInAnArray {
    public static void main(String[] args) {
        KStacks kst = new KStacks(40,5);

        kst.push(100,0);
        kst.push(200,0);
        kst.push(300,0);
        kst.push(10,3);
        kst.push(20,3);
        kst.push(1000,1);
        kst.push(99,2);
        kst.push(88,2);

//        System.out.println("Sizes of all stacks");
//
//        System.out.println(kst.size(0));
//        System.out.println(kst.size(1));
//        System.out.println(kst.size(2));
//        System.out.println(kst.size(3));
//        System.out.println(kst.size(4));


        System.out.println("Pop Operations");

        System.out.println(kst.pop(0));
        System.out.println(kst.pop(2));

        System.out.println("Peek Operations");

        System.out.println(kst.peek(0));
        System.out.println(kst.peek(2));


    }
}
