import java.util.LinkedList;
import java.util.Queue;

public class DeleteBST {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
          this.val=val;
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

            System.out.print(root.val+"->");
            Display(root.left);
            Display(root.right);
        }
        
        public void DeleteLeafNode(Node root,int val){

            if(root==null){
                return;
            }
            if(root.val>val){   //go left
                  if(root.left.val==val)  root.left=null;
                  else DeleteLeafNode(root.left,val);
            }else{
                if(root.right.val==val)  root.right=null;
                else DeleteLeafNode(root.right, val);
            }
                
        }

        public void deleteNodeWithOneChild(Node root, int val){
            if(root==null){
                return;
            }
          if(root.val>val){
            if(root.left.val==val){
                //check if it is a node with a single child
                Node l= root.left;
                 if(l.left==null && l.right==null)  root.left=null;
                 else if(l.left==null || l.right==null){  //checking if it's a  node with a single child or not
                     if(l.left!=null)  root.left=l.left;
                     else root.right=l.right;   
                 }
            }else 
                 deleteNodeWithOneChild(root.left, val);
          }
          else if(root.val<val){
            if(root.right.val==val){
                Node r=root.right;
                if(r.left==null && r.right==null)  root.right=null;
                else if(r.left==null || r.right==null){
                     if(r.left!=null)  root.right=r.left;
                     else root.right=r.right;
                }
            }else 
                 deleteNodeWithOneChild(root.right, val);
          }
        } 
        
         public void deleteNodewithTwoChild(Node root, int val){
            if(root==null){
                return;
            }
          if(root.val>val){
            if(root.left.val==val){
                //check if it is a node with a single child
                Node l= root.left;
                 if(l.left==null && l.right==null)  root.left=null;
                 else if(l.left==null || l.right==null){  //checking if it's a  node with a single child or not
                     if(l.left!=null)  root.left=l.left;
                     else root.right=l.right;   
                 } else {   //node has two children
                      Node curr=l;
                      Node pred= curr.left;
                      while(pred.right!=null){
                        pred=pred.right;
                      }
                      deleteNodeWithOneChild(root, pred.val);
                      pred.left=curr.left;
                      pred.right=curr.right;
                      root.left=pred;                    
                 }
            }else 
                 deleteNodeWithOneChild(root.left, val);
          }
          else if(root.val<val){
            if(root.right.val==val){
                Node r=root.right;
                if(r.left==null && r.right==null)  root.right=null;
                else if(r.left==null || r.right==null){
                     if(r.left!=null)  root.right=r.left;
                     else root.right=r.right;
                }else {   //node has two children
                      Node curr=r;
                      Node pred= curr.left;
                      while(pred.right!=null){
                        pred=pred.right;
                      }
                      deleteNodeWithOneChild(root, pred.val);
                      pred.left=curr.left;
                      pred.right=curr.right;
                      root.right=pred;                    
                 }
            }else 
                 deleteNodeWithOneChild(root.right, val);
          }

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
           System.out.println();
           bst.DeleteLeafNode(root, 28);
           bst.Display(root);
           System.out.println();
           bst.deleteNodeWithOneChild(root, 34);
           bst.Display(root);
           System.out.println();
           bst.deleteNodewithTwoChild(root, 20);
           bst.Display(root);
           
    }
    

}
