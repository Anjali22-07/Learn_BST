public class SortedArrayToBST {

     static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
        }
     }

     public static Node balanceBST(int[] arr, int low, int high){
         if(low>high)  return null;
        int mid= low+(high-low)/2;
        Node root=new Node(arr[mid]);
       root.left= balanceBST(arr,low, mid-1);
       root.right=balanceBST(arr, mid+1, high);
        return root;
     }

     public static void Display(Node root){
        if(root==null){
                return;

            }
            Display(root.left);
            System.out.print(root.val+"->");
            Display(root.right);
     }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        Node root=null;
        int low=0;
        int high=arr.length-1;
        root=balanceBST(arr,low,high);
        Display(root);
    }
    
}
