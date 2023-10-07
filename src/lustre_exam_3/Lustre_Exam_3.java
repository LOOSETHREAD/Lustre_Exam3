/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lustre_exam_3;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Lustre_Exam_3 {

    /**
     * @param args the command line arguments
     */
    private class printPriorityQueue{
            
            int priority;
            int data;
            int num;
          
       printPriorityQueue next;           
        }

    private printPriorityQueue front = null;
   static int printCount = 0;
    private void printAdd(int item, int priority, int num){
        printPriorityQueue node = new printPriorityQueue();
            node.data=item;
            node.priority = priority;
            node.next = null;
            node.num = num;
            
            
            if (front == null || priority <= front.priority) {
                node.next = front;
                front = node;
            }
            else{
                printPriorityQueue temporary = front;
                while (temporary.next != null && temporary.next.priority <= priority) {                    
                    temporary = temporary.next;
                }
                   node.next = temporary.next;
                   temporary.next = node;
               printCount++;
               
               }
            
        }
    public int printDelete(){
        
          int temporary = front.data;
          front = front.next;
          
            
          
           return temporary; 
           
        
        }
    public void printDisplay(){
        
            printPriorityQueue temporary = front;
            
            System.out.println("Student \t\t Priority \t\t Pages");
            
            while(temporary != null){
              
                   System.out.println(temporary.num + "\t\t\t " +temporary.priority + "\t\t\t " + temporary.data);
                temporary = temporary.next;

            }
            System.out.println("\n");
        }
    public static void main(String[] args)  {
        // TODO code application logic here
        Lustre_Exam_3 queue = new Lustre_Exam_3();
        Scanner scn = new Scanner(System.in);
        boolean True = true;
        while (True) {            
            System.out.println("Enter Number of Student (e.g, 0-5)");
            int num = scn.nextInt();
            System.out.println("Enter Pages: ");
                    int item = scn.nextInt();
                    System.out.println("Enter Priority: ");
                    int priority = scn.nextInt();
                    
                      
                    queue.printAdd(item, priority, num);
                     if(printCount>4){
                         queue.printDelete();
                         System.out.println("Already full, Highest Priority will be removed.");
                      
                     }
                        
                    
                    queue.printDisplay();
        }
                
    }
    
}