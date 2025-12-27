public class InorderMorrisTraversal {
    
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
    
    public static void inorderMorrisTraversal(Node root){
     
        Node curr=root;
         
          while(curr!=null){
             
             if(curr.left!=null){  //find pred

                Node pred=curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }

                if(pred.right==null){   //connect pred with curr
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right==curr){   //unlink pred with curr
                    pred.right=null;
                    System.out.print(curr.val+" ");
                    curr=curr.right;
                }

             }
             else{
                 System.out.print(curr.val+" ");
                 curr=curr.right; 
             }
          }
    }

   

    public static void main(String[] args) {
         int[] preorder= {8,5,1,7,10,12};
         Node root= new Node(preorder[0]);
          for(int val: preorder){
             root= constructBstFromPreorder(root,val);
          }
         // Display(root);
          inorderMorrisTraversal(root);
    }
   
}
