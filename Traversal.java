public class Traversal {
    
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val= val;
        }
    }

    static class BinarySearchTree{

       
       public Node insertion(Node root,int val){

            Node newNode= new Node(val);
            if(root==null){
                 root=newNode;
                 return root;
            }

            if(val<root.val){

                if(root.left==null){
                    root.left=newNode;
                }else insertion(root.left, val);

            }else  if(root.val<val){
                if(root.right==null){
                    root.right=newNode;
                }else insertion(root.right, val);
            }
            return root;
        }

      public void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
      }
        
      public void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
        

    //Inorder traversal of a Binary Search Tree is always sorted
     public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
     }
    }

    public static void main(String[] args) {
        BinarySearchTree bst= new BinarySearchTree();
        Node root=null;
       int[] values={10,5,15,2,8,12,17};
       for(int val: values){
           
       root= bst.insertion(root, val);

       }
          bst.preOrder(root);
          System.out.println();
          bst.postOrder(root);
          System.out.println();
          bst.inOrder(root);
    }

}
