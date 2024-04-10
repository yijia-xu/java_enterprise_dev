/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.yijia.bouncer.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing for all methods in Bouncer class using JUnit
 * @author Vy Chau
 */
public class BouncerTest {
    
    public BouncerTest() {
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

    /**
     * Test of getId method, of class Bouncer.
     */
    @Test
   public void testGetId() {
    System.out.println("getId");
    Bouncer instance = new Bouncer();
    Long expectedId = 1L;
    instance.setId(expectedId);
    
    Long result = instance.getId();
    assertEquals(expectedId, result);
    }

    /**
     * Test of setId method, of class Bouncer.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Bouncer instance = new Bouncer();
        instance.setId(id);
        Long result = instance.getId();
        assertEquals(id, result);
       
    }

    /**
     * Test of getxPosition method, of class Bouncer.
     */
    @Test
    public void testGetxPosition() {
        System.out.println("getxPosition");
        Bouncer instance = new Bouncer();
        Integer expResult = 30;
        instance.setxPosition(expResult);
        
        Integer result = instance.getxPosition();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setxPosition method, of class Bouncer.
     */
    @Test
    public void testSetxPosition() {
        System.out.println("setxPosition");
        Integer xPosition = 30;
        Bouncer instance = new Bouncer();
        instance.setxPosition(xPosition);
        Integer xResult = instance.getxPosition();
        assertEquals(xPosition, xResult);
    }

    /**
     * Test of getyPosition method, of class Bouncer.
     */
    @Test
    public void testGetyPosition() {
        System.out.println("getyPosition");
        Bouncer instance = new Bouncer();
        Integer expResult = 60;
        instance.setyPosition(expResult);
        Integer result = instance.getyPosition();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setyPosition method, of class Bouncer.
     */
    @Test
    public void testSetyPosition() {
        System.out.println("setyPosition");
        Integer yPosition = 60;
        Bouncer instance = new Bouncer();
        instance.setyPosition(yPosition);
        Integer yResult = instance.getyPosition();
        assertEquals(yPosition, yResult);
       
    }

    /**
     * Test of getyVelocity method, of class Bouncer.
     */
    @Test
    public void testGetyVelocity() {
        System.out.println("getyVelocity");
        Bouncer instance = new Bouncer();
        Integer expResult = -2;
        instance.setyVelocity(expResult);
        Integer result = instance.getyVelocity();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setyVelocity method, of class Bouncer.
     */
    @Test
    public void testSetyVelocity() {
        System.out.println("setyVelocity");
        Integer yVelocity = -2;
        Bouncer instance = new Bouncer();
        instance.setyVelocity(yVelocity);
        Integer yResult = instance.getyVelocity();
        assertEquals(yVelocity, yResult);
      
    }

    /**
     * Test of hashCode method, of class Bouncer.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Bouncer instance = new Bouncer();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of equals method, of class Bouncer.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Bouncer instance1 = new Bouncer();
        Bouncer instance2 = new Bouncer();
        boolean expResult = true;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Bouncer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bouncer instance = new Bouncer();
        String expResult = "cst8218.yijia.bouncer.Bouncer[ id=null ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of advanceOneFrame method, of class Bouncer.
     */
    @Test
    public void testAdvanceOneFrame() {
        System.out.println("advanceOneFrame");
        Bouncer instance = new Bouncer();
        
        instance.setyPosition(100); 
        instance.setyVelocity(-10); 

    
        instance.advanceOneFrame();

        assertEquals(90, instance.getyPosition().intValue()); 
        assertEquals(-9, instance.getyVelocity().intValue()); 
    }

    /**
     * Test of updateBouncer method, of class Bouncer.
     */
    @Test
    public void testUpdateBouncer() {
        System.out.println("updateBouncer");
        Bouncer existBouncer = new Bouncer();
        existBouncer.setxPosition(10);
        existBouncer.setyPosition(20);
        existBouncer.setyVelocity(5);
        
        Bouncer newBouncer = new Bouncer();
        newBouncer.setxPosition(30);
        newBouncer.setyPosition(50);
        
        existBouncer.updateBouncer(newBouncer);
        assertEquals(existBouncer.getxPosition(), newBouncer.getxPosition());
        assertEquals(existBouncer.getyPosition(), newBouncer.getyPosition());
    }
    
}
