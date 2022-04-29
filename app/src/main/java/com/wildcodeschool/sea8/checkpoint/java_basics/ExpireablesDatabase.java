package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import javax.lang.model.util.ElementScanner6;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
    
public class ExpireablesDatabase<E extends IExpireable> {
    private List<E> listOfExpireables = new ArrayList<>();
    
    
    public void addItem(E item) {
        // TODO: add a new item to the list
        listOfExpireables.add(item);
    }
    public void removeExpired(E item) {
    // TODO: implement the neccessary function to delete all expired entries from the list
        for (int i = 0; i < listOfExpireables.size(); i++) {
            if (listOfExpireables.get(i).isExpired()==true)
            listOfExpireables.remove(i);
        }
    }

    public void sortByExpirationDate(boolean descending) {
        // TODO: sort the list by the expiration date of it's entries
        // hint: use a comparator and expiryDate()
        Comparator<E> expiryDateComparator = new Comparator<E>(){
            @Override
            public int compare(E a, E b) {
            if (descending == true){
            return b.expiryDate().compareTo(a.expiryDate());}
            return a.expiryDate().compareTo(b.expiryDate());
            Collections.sort(listOfExpireables, expiryDateComparator);
        }

    public E getFirstEntry() {
        // TODO: Return first item in the list
        return listOfExpireables.get(0);
    }

    public E getLastEntry() {
        // TODO: Return last item in the list
        return listOfExpireables.get(listOfExpireables.size()-1);
    }

    public List<E> getList() {
        return listOfExpireables;
    }

}
