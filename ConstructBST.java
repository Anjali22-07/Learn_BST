public class ConstructBST{

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

        public void Display(Node root){

            if(root==null){
                return;

            }

            System.out.println(root.val+"->");
            Display(root.left);
            Display(root.right);
        }
        
        

    }

    public static void main(String[] args) {
        BinarySearchTree bst= new BinarySearchTree();
        Node root=null;
       int[] values={50,20,60,17,34,55,89,10,28,70,14};
       for(int val: values){
           
       root= bst.insertion(root, val);

       }
           bst.Display(root);
           
    }
}