import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
}
class verticleTree{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=call(sc);
        sc.close();
        c(root);
    }
    public static void c(Node root){
        if(root==null) return ;
        Map<Integer,List<Integer>>mp=new HashMap<>();
        int []m=new int[2];
        find(mp,m,root,0);
        for(int i=m[0];i<=m[1];i++){
            if(mp.containsKey(i)){
                for(int j:mp.get(i)){
                    System.out.print(j+" ");
                }
            }
        }
        System.out.println();

    }
    public static void find(Map<Integer,List<Integer>>mp,int []m,Node root,int d) {
        if (root==null) {
            return;
        }
        m[0]=Math.min(m[0], d);
        m[1]=Math.max(m[1], d);
        mp.putIfAbsent(d, new ArrayList<>());
        mp.get(d).add(root.data);
        find(mp, m, root.left, d-1);
        find(mp, m, root.right, d+1);
    }
    public static Node call(Scanner sc){
        int d=sc.nextInt();
        int k=sc.nextInt();
        Queue<Node>q=new LinkedList<>();
        Node rooto=new Node(k);
        q.add(rooto);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                Node p=q.poll();
                int a=sc.nextInt();
                if(a!=-1){
                    p.left=new Node(a);
                    q.add(p.left);
                }
                int b=sc.nextInt();
                if(b!=-1){
                    p.right=new Node(b);
                    q.add(p.right);
                }
            }
        }
        return rooto;
    }
}