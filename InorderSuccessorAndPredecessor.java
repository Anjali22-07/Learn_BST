public class InorderSuccessorAndPredecessor{
     static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val= val;
        }
    }

   static Node temp=null;
      static int pred=-1;
      static int succ=-1;
       static boolean flag=false;

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
            Display(root.left);
            System.out.println(root.val+"->");
            Display(root.right);
        }
         
        public void predecessorAndSuccessor(Node root,int target){
               
             if(root==null)  return;
             predecessorAndSuccessor(root.left, target);
             if(temp==null) temp=root;
           else { 
             if(root.val==target){
                pred=temp.val;
                flag=true;
             }else if(root.val>target && flag==true){
                succ=root.val;
                flag=false;
             }
            else{
                temp=root;
            }
        }
             predecessorAndSuccessor(root.right, target);
            
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
           bst.predecessorAndSuccessor(root, 55);
           System.out.println("Predecessor"+pred);
           System.out.println("Successor"+succ);
           
    }
}