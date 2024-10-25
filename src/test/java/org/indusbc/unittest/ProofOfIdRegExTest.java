/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.indusbc.unittest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author singh
 */
public class ProofOfIdRegExTest {
    
    public ProofOfIdRegExTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testRegEx() {
        
        Pattern pattern = Pattern.compile("^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$");
        Matcher matcher=pattern.matcher("3977 8800 0234");
        boolean matchFound=matcher.find();
        if (matchFound){
            System.out.println("Match found!!");
        }else{
            System.err.println("Match NOT found");
        }
    
    
    }
}
