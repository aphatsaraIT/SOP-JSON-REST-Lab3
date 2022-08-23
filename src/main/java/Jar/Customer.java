package Jar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class Customer {
    private String ID;
    private String name;
    private boolean sex;
    private int age;

    public Customer(){
        this("", null, "female", 0);
    }
    public Customer(String ID, String name, String sex, int age){
        this.ID = ID;
        this.name = name;
        setSex(sex);
        this.age = age;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID(){
        return  ID;
    }
    public void  setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSex(String sex){
        if(sex.toLowerCase().equals("male")){
            this.sex = true;
        }else{
            this.sex = false;
        }
    }
    public boolean getSex(){
        return sex;
    }
    public void setAge(int age){
       if(age > 0){
           this.age = age;
       }else{
           this.age = 0;
       }
    }
    public int getAge(){
        return age;
    }
}
