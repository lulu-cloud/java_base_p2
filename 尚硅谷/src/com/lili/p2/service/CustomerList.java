package com.lili.p2.service;


import com.lili.p2.bean.Customer;

//控制层
public class CustomerList {
    private Customer[] customers;
    private int total;

    public CustomerList(int totalCustomer){
        this.customers=new Customer[totalCustomer];
        this.total=0;
    }

    public boolean addCustomer(Customer customer){
        if(total<this.customers.length){
            this.customers[total]=customer;
            this.total+=1;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean replaceCustomer(int index,Customer cust){
        if(index<this.total&&index>=0){
            this.customers[index]=cust;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteCustomer(int index){
        if(index<this.total&&index>=0){
            int i=index;
            while(i++<this.total){
                this.customers[i]=this.customers[i+1];
            }
            //最后元素置空
            this.customers[this.total-1]=null;
            this.total-=1;
            return true;
        }
        else {
            return false;
        }
    }

    public Customer[] getAllCustomers(){
//        return this.customers;
        Customer[] cust=new Customer[total];
        for(int i=0;i<total;i++){
            cust[i]=customers[i];
        }
        return cust;
    }

    public Customer getCustomer(int index){
        return this.customers[index];
    }

    public int getTotal(){
        return this.total;
    }
}
