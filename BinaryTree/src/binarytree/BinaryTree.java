
package binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    class node {
        int data;
        node left;
        node right;
        
        node(int data){
            this.data = data;
            
        }
               
    }
    node root;
    
    node getNewNode(int d){
        node newnode  = new node(d);
        newnode.left = null;
        newnode.right = null;
        return newnode;
    }

    
 
    void insert(int d){
        if(root == null)
            root = getNewNode(d);
        else
            insert(root,d);
    }
    void insert(node temp, int d)
    {
        Queue<node> q = new LinkedList<node>();
        q.add(temp);
     
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
      
            if (temp.left == null) {
                temp.left = new node(d);
                break;
            } else
                q.add(temp.left);
      
            if (temp.right == null) {
                temp.right = new node(d);
                break;
            } else
                q.add(temp.right);
        }
    }
    
    void preOrderRecursion(node visit){
            if(visit == null) return;
            
            System.out.print(visit.data+" ");
            preOrderRecursion(visit.left);
            preOrderRecursion(visit.right);
        }
        void preOrderRecursion(){
            //root left right
            if(root == null) return;
            preOrderRecursion(root);       
        }
        
        void postOrderRec(){
            if(root == null) return;
            postOrderRec(root);
        }
        void postOrderRec(node visit){
            if(visit == null) return;
                 
                 postOrderRec(visit.left);
                 postOrderRec(visit.right);
                 System.out.print(visit.data+" ");
        }
        
        void inOrder(){
            if(root == null) return;
            inOrder(root);
        }
        void inOrder(node visit){
            if(visit==null) return;
            inOrder(visit.left);
            System.out.print(visit.data+" ");
            inOrder(visit.right);
        }
        
        void postOrderWithoutRec(){
            node temp = root;
            if(temp == null) return;
            Stack <node> s1 = new Stack<node>();
            Stack <node> s2 = new Stack<node>();
            s1.push(temp);
            while(!s1.isEmpty()){
                temp = s1.pop();
                s2.push(temp);
                if(temp.left!=null) s1.push(temp.left);
                if(temp.right!=null) s1.push(temp.right);
            }
            while(!s2.isEmpty()){
                temp = s2.pop();
                System.out.print(temp.data+" ");
            
            }
        }
        
        void preOrderWithoutRec(){
            node temp = root;
            if(temp == null) return;
            Stack<node> s1 = new Stack<node>();
            Stack<node> s2 = new Stack<node>();
            s1.push(temp);
            while(!s1.isEmpty()){
            temp = s1.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null) s1.push(temp.right);
            if(temp.left!=null) s1.push(temp.left);
                    
            }
           
        }
        
          void inOrderWithoutRec(){
            node temp = root;
            if(temp == null) return;
            Stack<node> s1 = new Stack<node>();
            while(true){
                if(temp!=null){
                    s1.push(temp);
                    temp = temp.left;
                    
                }else{
                    if(s1.isEmpty()){
                        break;
                    }
                    temp=s1.pop();
                    System.out.print(temp.data+" ");
                    temp=temp.right;
                }
            }
                    
            }
          
          void insertWithoutRec(int d){
              node newnode = getNewNode(d);
              if(root == null) {
                  root=getNewNode(d);
              }
              node parent = null;
              node current = root;
              
              while(current!=null){
                  parent = current;
                  if(current.data < d) current = current.right;
                  else current = current.left;
              }
              if(parent.data<d){
                  parent.right = newnode;
              }else
                  parent.left=newnode;
          }
          
    
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printLevel(root, i);
    }
 
    
    int height(node root)
    {
        if (root == null)
           return 0;
        else
        {
          
            int lheight = height(root.left);
            int rheight = height(root.right);
             
       
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
 
    void printLevel(int level){
        printLevel(root,level);
    }
    void printLevel (node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }
    }
   
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        //insertion
        int array[] = {7,3,10,1,6,14,4,7,13};
        for(int i=0;i<array.length;i++)
             tree.insert(array[i]);
        
        
        tree.insert(8);
        tree.insert(21);
        
        
        System.out.println("In Order Recursively");
        tree.inOrder();
        System.out.println("");
        System.out.println("In Order Iterative");
        tree.inOrderWithoutRec();
        System.out.println("");
        System.out.println("Post Order Recursively");
        tree.postOrderRec();
        System.out.println("");
        System.out.println("post Order Iterative");
        tree.postOrderWithoutRec();
        System.out.println("");
        System.out.println("Pre Order Recursively");
        tree.preOrderRecursion();
        System.out.println("");
        System.out.println("pre Order Iterative");
        tree.preOrderWithoutRec();
        System.out.println("\nBreadth First Search");
        System.out.println("Level Order");
        tree.printLevelOrder();
        
        
    }
    
}
