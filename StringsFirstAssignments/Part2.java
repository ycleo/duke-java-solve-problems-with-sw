
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public boolean twoOccurrences (String str1, String str2) {
       
        int start = str2.indexOf(str1);
       
        if (start == -1) { 
            return false;
        } else {
            start += str1.length();
        }
        String nextStr2 = str2.substring(start);
        return nextStr2.contains(str1);     
    }
    
    public String lastPart (String str1, String str2) {
        int start = str2.indexOf(str1);
        
        if (start == -1) {
            return str2;
        } else {
            return str2.substring(start + str1.length());
        }
    }
    
    public void testing () { 
     
        System.out.println("Answer: " + twoOccurrences("by", "A story by Abby Long"));
        System.out.println("Answer: " + twoOccurrences("a", "banana"));
        System.out.println("Answer: " + twoOccurrences("atg", "ctgtatgta"));
        
        System.out.println("Answer: " + lastPart("an", "banana"));
        System.out.println("Answer: " + lastPart("zoo", "forest"));
    }
}
