import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(topView(root));
    }
    static class Pair{
        int hd;
        Node node;
        Pair(int hd,Node node){this.hd = hd;this.node = node;}
    }
    public static List<Integer> topView(Node root){
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> tmp = new TreeMap<>();

        q.add(new Pair(0,root));

        while (!q.isEmpty()){
            Pair pair = q.poll();
            Node cur = pair.node;
            int hd = pair.hd;
            if (!tmp.containsKey(hd)){
                tmp.put(hd,cur.data);
            }
            if (cur.left != null) q.add(new Pair(hd-1,cur.left));
            if (cur.right != null) q.add(new Pair(hd+1,cur.right));
        }
        return tmp.values().stream().toList();
    }
}