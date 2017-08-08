/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;
import java.util.Scanner;

public class Interface
{
    Scanner scan = new Scanner(System.in);
    
    public void menu(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        boolean emp = list.empty();
        System.out.println(emp == true ? "vazio" : "tem items");
        
        for (int i = 0; i < 10; i++) {
            list.add(new Node(i));
        }
        
        emp = list.empty();
        System.out.println(emp == true ? "vazio" : "tem items");
        
        list.remove(new Node(2));
        
        //boolean cont = list.contains(new Node(4));
        //System.out.println(cont == true ? "Existe" : "Não Existe");
            
        //list.print();
    }
}
