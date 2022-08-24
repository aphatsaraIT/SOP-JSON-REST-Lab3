package Jar;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        customers = new ArrayList<Customer>();
        Customer customer1 = new Customer("1010", "John", "Male", 25);
        Customer customer2 = new Customer("1018", "Peter", "Male", 24);
        Customer customer3 = new Customer("1019", "Sara", "Female", 23);
        Customer customer4 = new Customer("1110", "Rose", "Female", 23);
        Customer customer5 = new Customer("1001", "Emma", "Female", 30);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customers;
    }

    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID){
        for(int i = 0; i < this.customers.size() ; i++){
            if(this.customers.get(i).getID().equals(ID)){
                return this.customers.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("n") String n){
        for(int i = 0; i < this.customers.size() ; i++){
            if(this.customers.get(i).getName().equals(n)){
                return this.customers.get(i);
            }
        }

        return null;
    }

    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        for(int i = 0; i < this.customers.size() ; i++){
            if(this.customers.get(i).getID().equals(ID)){
                this.customers.remove(this.customers.get(i));
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String n){
        for(int i = 0; i < this.customers.size() ; i++){
            if(this.customers.get(i).getName().equals(n)){
                this.customers.remove(this.customers.get(i));
                return true;
            }
        }
        return false;
    }

    @GetMapping ("/addCustomer")
    public boolean addCustomer(@RequestParam("ID") String ID, @RequestParam("n") String n, @RequestParam("s") String s, @RequestParam("a") int a){
        customers.add(new Customer(ID, n, s, a));
        return true;
    }

    @PostMapping ("/addCustomer2")
    public boolean addCustomer2(@RequestParam("ID") String ID, @RequestParam("n") String n, @RequestParam("s") String s, @RequestParam("a") int a){
        customers.add(new Customer(ID, n, s, a));
        return true;
    }
}
