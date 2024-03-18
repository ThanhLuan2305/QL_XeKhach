/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Hao
 */
public class ListQuyen {
    
    public List<String> data=new ArrayList<>();
     public List<String> data1=new ArrayList<>();
    /**
     *
     */
    public  List<String> getData() {
        data.add("CREATE SESSION");
        data.add("CREATE TABLE");
        data.add("CREATE PROCEDURE");
        data.add("CREATE TRIGGER");
        data.add("ALTER USER");
        data.add("DROP USER");
        data.add("SELECT ANY TABLE");
        data.add("INSERT ANY TABLE");
        data.add("UPDATE ANY TABLE");
        data.add("DELETE ANY TABLE");
        return data;
    }
    public  List<String> getData1() {
        data1.add("SELECT");
        data1.add("INSERT");
        data1.add("UPDATE");
        data1.add("DELETE");
        data1.add("CREATE");
        data1.add("ALTER");
        data1.add("DROP");
        data1.add("REFERENCES");
        return data1;
    }
    
}
