import java.util.*;

public class VerticalTraversal {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(verticalTraversal(root));
    }
    static class Pair{
        int hd;
        Node node;
        Pair(int hd,Node node){this.hd = hd;this.node = node;}
    }
    public static List<Integer> verticalTraversal(Node root){
        TreeMap<Integer,ArrayList<Integer>> tmp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));

        while (!q.isEmpty()){
            Pair p = q.poll();
            int hd = p.hd;
            Node cur = p.node;

            if (tmp.containsKey(hd)){
                tmp.get(hd).add(cur.data);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(cur.data);
                tmp.put(hd,al);
            }
            if (cur.left != null) q.add(new Pair(hd-1,cur.left));
            if (cur.right != null) q.add(new Pair(hd+1,cur.right));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (ArrayList<Integer> al : tmp.values()){
            res.addAll(al);
        }
        return res;
    }

}

