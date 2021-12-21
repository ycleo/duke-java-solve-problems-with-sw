
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene (String dna) {
        String upperCaseDna = dna.toUpperCase();
        int start = upperCaseDna.indexOf("ATG");
        if (start == -1) { 
            return "";
        }
        int stop = upperCaseDna.indexOf("TAA");
        if (stop == -1) {
            return "";
        }
        if ((stop - start) % 3 != 0) {
            return "";
        } else {
            return upperCaseDna.substring(start, stop+3);
        }
    }
    
    public void testSimpleGene () {
        String s1 = "atggatctataa"; // normal case
        String s2 = ""; 
        String s3 = "ATGag";
        String s4 = "gcataa";
        String s5 = "AAATGCCCTAACTAGATTAAGAAACC";
        
        String gene = findSimpleGene(s5);
        System.out.println("Gene: " + gene);
    }
}
