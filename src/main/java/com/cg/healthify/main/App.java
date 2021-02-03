package com.cg.healthify.main;

import com.cg.healthify.exceptions.CaloriesLogNotFoundException;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;
import com.cg.healthify.menu.LoginMenu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NegativeIdEntryException, CaloriesLogNotFoundException, NegativeIdException, NoRecordFoundException, PaymentAmountException
    {
       // System.out.println( "Hello World!" );
        LoginMenu mains=new LoginMenu();
        mains.loginMenu();
    }
}
