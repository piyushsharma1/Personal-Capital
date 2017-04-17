/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import personalcapital.PersonalCapital;

/**
 *
 * @author Asus1
 */
public class PersonalCapitalJUnitTest {
    
    public PersonalCapitalJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /* Testing the scenario if the returns% (mean) and standard deviation are zero. 
       As the inflation is fixed at 3.5% the return rate will be -3.5% */
     @Test
     public void meanStdZero() {
         PersonalCapital pc = new PersonalCapital();
         double[] result = pc.generateAvgReturnMinMax(100000,0,0);
         assertEquals(result[0],100000.0,0.10);
         assertEquals(result[1],100000.0,0.10);
         assertEquals(result[2],100000.0,0.10);
     }
     
     // Testing the scenario if priciple amount is zero
     @Test
     public void principleZero() {
         PersonalCapital pc = new PersonalCapital();
         double[] result = pc.generateAvgReturnMinMax(0,10,5);
         assertEquals(result[0],0.0,0.01);
         assertEquals(result[1],0.0,0.01);
         assertEquals(result[2],0.0,0.01);
     }
     
     // Testing if all input values are zero
     @Test
     public void allZero() {
         PersonalCapital pc = new PersonalCapital();
         double[] result = pc.generateAvgReturnMinMax(0.0,0.0,0.0);
         assertEquals(result[0],0.0,0.1);
         assertEquals(result[1],0.0,0.1);
         assertEquals(result[2],0.0,0.1);
     }
     
     // Testing the scenario if priciple amount is negative
     @Test
     public void principleNegative() {
         PersonalCapital pc = new PersonalCapital();
         double[] result = pc.generateAvgReturnMinMax(-10000.0,10,5);
         assertEquals(result[0],0.0,0.01);
         assertEquals(result[1],0.0,0.01);
         assertEquals(result[2],0.0,0.01);
     }
     
     
     // Testing if only risk is zero
     @Test
     public void riskZero() {
         PersonalCapital pc = new PersonalCapital();
         double[] result = pc.generateAvgReturnMinMax(100000,9.0,0.0);
         assertEquals(result[0],560441.08,0.0);
         assertEquals(result[1],560441.08,0.0);
         assertEquals(result[2],560441.08,0.0);
     }

}
