
/**
 * Write a description of FindWebLink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class FindWebLink {
    
    public void isYouTubeLink (URLResource url) {
         String target = "youtube.com";
         
         for (String s : url.lines()) {
             
             // transform each line into lowercase to prevent case sensitive issue
             String sLower = s.toLowerCase();
             
             // find the index after the target link
             int targetIndex = sLower.indexOf(target);
             
             // if the target link exists
             if (targetIndex != -1) {
                 
                 int linkStart = s.lastIndexOf("\"", targetIndex) + 1;
                 int linkEnd = s.indexOf("\"", targetIndex);
                 //System.out.println(s);
                 //System.out.println("linkStart: " + linkStart);
                 //System.out.println("targetIndex: " + targetIndex);
                 //System.out.println("linkEnd: " + linkEnd);
                 String link = s.substring(linkStart, linkEnd);
                 System.out.println(link);
             }
         }  
    }
    
    public void testing () {
        URLResource url = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        //for (String s : url.lines()) {
        //    System.out.println(s);
        //}
        isYouTubeLink(url);
    }
}
