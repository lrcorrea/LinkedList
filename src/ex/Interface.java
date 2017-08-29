/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;

public class Interface
{
    public void menu(){
        /*
        a.compareTo(b)
        0 - igual
        0< - a menor q b
        0> - a maior q b
        */
        Conjunto<Integer> lista = new Conjunto<Integer>();
        Conjunto<Integer> listb = new Conjunto<Integer>();
        
        //boolean emp = lista.empty();
        //System.out.println(emp == true ? "vazio" : "tem items");
        
        /*for (int i = 0; i < 10; i++) {
            lista.add(i);
        }*/
        
        lista.add(41);
        lista.add(20);
        lista.add(10);
        lista.add(14);
        lista.add(63);
        lista.add(98);
        lista.add(12);
        lista.add(77);
        
        //listb.add(4);
        //listb.add(7);
        
        //Conjunto<Integer> listc = lista.intersection(listb);
        
        //emp = lista.empty();
        //System.out.println(emp == true ? "vazio" : "tem items");
        
        //lista.remove(2);
        
        //Node cont = list.contains(14);
        //System.out.println(cont == null ? "Não Existe" : "Existe");
        
        lista.insertionSort();
            
        lista.print();
    }
}
