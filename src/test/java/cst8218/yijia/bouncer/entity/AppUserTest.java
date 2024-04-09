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
 *
 * @author Vy Chau
 */
public class AppUserTest {
    
    public AppUserTest() {
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
     * Test of getId method, of class AppUser.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        AppUser instance = new AppUser();
        Long expectedId = 1L;
        instance.setId(expectedId);
        
        Long result = instance.getId();
        assertEquals(expectedId, result);
       
    }

    /**
     * Test of setId method, of class AppUser.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        AppUser instance = new AppUser();
        instance.setId(id);
        Long result = instance.getId();
        assertEquals(id, result);
    }

    /**
     * Test of getPassword method, of class AppUser.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        AppUser instance = new AppUser();
        String expResult = "";
        instance.setPassword(expResult);
        
        String result = instance.getPassword();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setPassword method, of class AppUser.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        AppUser instance = new AppUser();
        instance.setPassword(password);
        
        String result = instance.getPassword();
        assertEquals(password, result);
    }

    /**
     * Test of getGroupname method, of class AppUser.
     */
    @Test
    public void testGetGroupname() {
        System.out.println("getGroupname");
        AppUser instance = new AppUser();
        String expResult = "";
        instance.setGroupname(expResult);
        String result = instance.getGroupname();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setGroupname method, of class AppUser.
     */
    @Test
    public void testSetGroupname() {
        System.out.println("setGroupname");
        String groupname = "";
        AppUser instance = new AppUser();
        instance.setGroupname(groupname);
        
        String result = instance.getGroupname();
        assertEquals(groupname, result);
    }

    /**
     * Test of getUsername method, of class AppUser.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        AppUser instance = new AppUser();
        String expResult = "";
        instance.setUsername(expResult);
        
        String result = instance.getUsername();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setUsername method, of class AppUser.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        AppUser instance = new AppUser();
        instance.setUsername(username);
        
        String result = instance.getUsername();
        assertEquals(username, result);
    }

    /**
     * Test of hashCode method, of class AppUser.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        AppUser instance = new AppUser();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class AppUser.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        AppUser object = new AppUser();
        AppUser instance = new AppUser();
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class AppUser.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AppUser instance = new AppUser();
        String expResult = "cst8218.yijia.bouncer.entity.AppUser[ id=null ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
