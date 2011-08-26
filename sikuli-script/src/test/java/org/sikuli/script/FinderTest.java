/*
 * Copyright 2010-2011, Sikuli.org
 * Released under the MIT License.
 *
 */
package org.sikuli.script;

import org.junit.* ;
import static org.junit.Assert.* ;
import static org.mockito.Mockito.*;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.File;
import java.util.Iterator;
import java.util.ArrayList;

public class FinderTest 
{

   private void testTargetScreenSet(String test_dir) throws Exception{
      FinderTestImage testImgs = FinderTestImage.createFromDirectory(test_dir);
      ArrayList<FinderTestTarget> testTargets =  testImgs.getTestTargets();
      String screenImg = testImgs.getScreenImageFilename();
      Finder f = new Finder(screenImg);
      for(FinderTestTarget target : testTargets){
         String targetFname = target.getFilename();
         f.find(targetFname);
         while(f.hasNext()){
            Match m = f.next();
            boolean matched = target.isMatched(m);
            if(!matched)
               System.err.println("NOT MATCHED: " + m + " " + target);
            assertTrue(matched);
         }
      }
   }

   @Test
   public void testFinderFolders() throws Exception {
      testTargetScreenSet("finderfolders");
   }

   @Test
   public void testMacDesktopDark() throws Exception {
      testTargetScreenSet("macdesktopdark");
   }

   @Test
   public void testMacDesktop() throws Exception {
      testTargetScreenSet("macdesktop");
   }

   @Test
   public void testMacDesktopSikuli() throws Exception {
      testTargetScreenSet("macdesktopsikuli");
   }

   @Test
   public void testFuzzyDesktop() throws Exception {
      testTargetScreenSet("fuzzydesktop");
   }


   @Test
   public void testFuzzyFarmville() throws Exception {
      testTargetScreenSet("fuzzyfarmville");
   }

   @Test
   public void testInbox() throws Exception {
      testTargetScreenSet("sikuliinbox");
   }

   @Test
   public void testSikuliOrg() throws Exception {
      testTargetScreenSet("sikuliorgbanner");
   }

   @Test
   public void testWhereSpace() throws Exception {
      testTargetScreenSet("wherespace");
   }

   @Test
   public void testXpDesktop() throws Exception {
      testTargetScreenSet("xpdesktop");
   }

   @Test
   public void testXpFolders() throws Exception {
      testTargetScreenSet("xpfolders");
   }

   @Test
   public void testXpPricingApp() throws Exception {
      testTargetScreenSet("xppricingapp");
   }
}
