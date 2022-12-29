/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numrical_integration;

import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 *
 * @author Elza Morgan
 */
public class Numrical_Integration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value for A: ");
        double a=input.nextDouble();
        System.out.print("Enter value for B: ");
        double b=input.nextDouble();
        System.out.print("Enter value for H: ");
        double h=input.nextDouble();
        System.out.print("Enter F(x): ");
        String f_x =input.next();
        System.out.print(".........Normal.........\n");
        System.out.print("\n");
//        ...............midpoint normal...............
        double midpoint=(b-a)*sub(f_x,(b+a)/2); 
        midpoint= Math.round(midpoint*10000.0)/10000.0;
        System.out.print("....Normal Midpoint: ");
        System.out.print(midpoint +"\n");

       
        
      
//       ...............trapeziodal normal...............
        double trapeziodal=(b-a)*(sub(f_x,a)+sub(f_x,b))/2;
        trapeziodal= Math.round(trapeziodal*10000.0)/10000.0;
        System.out.print("....Normal trapeziodal: ");
        System.out.print(trapeziodal +" \n");
        
        
        
//        ...............Simpson normal...............
        double Simpson1=(b-a)/6 *(sub(f_x,a)+4*sub(f_x,(a+b)/2)+sub(f_x,b));
        Simpson1= Math.round(Simpson1*10000.0)/10000.0;
        System.out.print("....Normal Simpson: ");
        System.out.print(Simpson1 + "\n");
        System.out.print("\n");
        System.out.print(".........Composit.........\n");
      
       System.out.print("\n");
       
       
       
       //...............midpoint composit...............    
        ArrayList<Double> intervvial= new ArrayList<>();
        ArrayList<Double> x_star= new ArrayList<>();
        ArrayList<Double> x_star_f= new ArrayList<>();
      double sum=0;  
        for(double i=a; i<=b; i=i+h)//to create the intervials 
        { 
            intervvial.add(i);  
        } 
        for(int i=0; i<intervvial.size()-1; i++)// to create midpoint between the intervials
        {
            x_star.add((intervvial.get(i)+intervvial.get(i+1))/2);  
        }
       for(int i=0 ;i <x_star.size() ;i++)//sending each intervial after getting midpoints to the fucntion
       {
           x_star_f.add(sub(f_x,x_star.get(i)));
          
       }
         for(int i=0 ;i <x_star_f.size() ;i++)//summtion of the of the f(x*)
       {
          sum+=x_star_f.get(i);
          
       }
      
      double midpoint_composit=h*sum;// that's the formula that we know for composit midpoint
      midpoint_composit= Math.round(midpoint_composit*10000.0)/10000.0;
      System.out.print("....Composit Midpoint: ");
      System.out.print(midpoint_composit + "\n");
        System.out.print("x: ");
        System.out.print(x_star+ "\n");
        System.out.print("f(x): ");
        System.out.print(x_star_f+ "\n\n");
        
       
       
       
       
       //...............composit trapeziodal...............
        ArrayList<Double> intervvial_trapeziodal= new ArrayList<>();
        ArrayList<Double> x= new ArrayList<>();
        double sum_trapezioda=0.0;
        double f_x_trapeziodal;
       for(double i=a; i<=b; i=i+h)//to create the intervials 
        { 
            intervvial_trapeziodal.add(i);  
        } 
       double FirstIndextrapeziodal= sub(f_x,intervvial_trapeziodal.get(0));
       x.add(FirstIndextrapeziodal);
       // sum of the intervals in between first and last index
       for(int i=1; i<=intervvial_trapeziodal.size()-2; i++)
       {  
           f_x_trapeziodal=sub(f_x,intervvial_trapeziodal.get(i));
           x.add(f_x_trapeziodal);
           sum_trapezioda=sum_trapezioda + 2*f_x_trapeziodal;
           sum_trapezioda= Math.round(sum_trapezioda*10000.0)/10000.0;    
       }     
       
       
       double LastIndextrapeziodal= sub(f_x,intervvial_trapeziodal.get(intervvial_trapeziodal.size()-1));       
       x.add(LastIndextrapeziodal);
//that's the actual formal for trapeziod
       double composit_trapeziodal=(h/2)*(FirstIndextrapeziodal+sum_trapezioda+LastIndextrapeziodal);
       composit_trapeziodal= Math.round(composit_trapeziodal*10000.0)/10000.0;
             System.out.print("....Composit trapeziodal: ");
             System.out.print(composit_trapeziodal +" \n");
             System.out.print("x: ");
             System.out.print(intervvial_trapeziodal+ "\n");
             System.out.print("f(x): ");
             System.out.print(x+ "\n\n");    
               
               
               
       
      //...............composit Simpson............... 
        ArrayList<Double> interval_Simpson= new ArrayList<>();
         ArrayList<Double> y= new ArrayList<>();
        double f_x_Simpson;
        
        double sum2=0.0;
        double sum_Simpson=0.0;
         for(double i=a; i<=b; i=i+h)//to create the intervials 
        { 
            interval_Simpson.add(i);  
        } 
         double FirstIndexSimpson=sub(f_x,interval_Simpson.get(0));
         y.add(FirstIndexSimpson);
         for(int i=1; i<=interval_Simpson.size()-2; i++)// sum btween the first and last index
         {
             
             if(i%2==0)//even index
             { //sends it to the function to sub and then times 2
                 f_x_Simpson=(sub(f_x,interval_Simpson.get(i)));
                 y.add(f_x_Simpson);
                 sum_Simpson=2*f_x_Simpson;
                 
             }
             else{  //odd index  
                 //sends it to the function to sub and then times 4
                 f_x_Simpson=(sub(f_x,interval_Simpson.get(i)));
                 y.add(f_x_Simpson);
                 sum_Simpson=4*f_x_Simpson;
                 }
             //sum for the even and odd index after they are multiplied and sent to the function
            sum2=sum_Simpson+sum2;
         }
         
       
       double LastIndexSimpson=sub(f_x,interval_Simpson.get(interval_Simpson.size()-1));
       y.add(LastIndexSimpson);
       double simpson=(h/3)*(FirstIndexSimpson+sum2+LastIndexSimpson);  
              simpson=Math.round(simpson*10000.0)/10000.0;
                System.out.print("....composite Simpson: ");
                System.out.print(simpson +" \n");
                 System.out.print("x: ");
                 System.out.print(interval_Simpson+ "\n");
                 System.out.print("f(x): ");
                 System.out.print(y+ "\n\n");    
               
                
       
    }
 
    public static double sub(String f_x, double z)
            { 
                net.objecthunter.exp4j.Expression exp = new ExpressionBuilder(f_x).variables("x").build().setVariable("x", z);
                double result = exp.evaluate();
                return result;
            }
    
    
}
