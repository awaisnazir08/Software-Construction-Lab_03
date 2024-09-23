/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        
     // New test case 1: Cited, publicly available code but written as course work
        assertFalse("Expected false: cited, publicly-available course work",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
        
        // New test case 2: Cited, publicly available code with no required implementation
        assertTrue("Expected true: cited, publicly-available non-course work, no implementation required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
        
        // New test case 3: Code written by yourself, even though implementation is required
        assertTrue("Expected true: self-written code with required implementation",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, true, true));
    }
}
