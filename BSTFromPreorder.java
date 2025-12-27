public class BSTFromPreorder {

    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
        this.val=val;
        }
     }

     public static Node constructBstFromPreorder(Node root, int val){

        if(root==null)  return null;

        if(root.val>val){
            if(root.left==null)  root.left=new Node(val);
            else   constructBstFromPreorder(root.left, val);
        }else if(root.val<val){
            if(root.right==null)  root.right= new Node(val);
            else  constructBstFromPreorder(root.right, val);
        }
        return root;
     }

     public static void Display(Node root){
        if(root==null) return;
       
         
        Display(root.left);
       System.out.print(root.val+" ");
        Display(root.right);
     }

    public static void main(String[] args) {
         int[] preorder= {8,5,1,7,10,12};
         Node root= new Node(preorder[0]);
          for(int val: preorder){
             root= constructBstFromPreorder(root,val);
          }

          Display(root);
    }
   
    
}
