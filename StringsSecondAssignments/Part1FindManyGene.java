
/**
 * Write a description of Part1FindManyGene here.
 * 
 * @author ycleo
 * @date 2021-12-22
 */
public class Part1FindManyGene {
    
    // returns the index of the first occurrence of stopCodon that 
    // appears past startIndex and is a multiple of 3 away from startIndex.
    // if there is no such stopCodon, returns the length of the dna
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        
        while (stopIndex != -1) {
   
            if ((stopIndex - startIndex) % 3 == 0) {
                return stopIndex;
            } else {
                stopIndex = dna.indexOf(stopCodon, stopIndex + 1);
            }
    
        }
        return -1;
    }
    
    public String findGene(String dna, int startIndex) {
        int atgIndex = dna.indexOf("ATG", startIndex);
        if (atgIndex == -1) 
            return "";
        
        int taaIndex = findStopCodon(dna, atgIndex, "TAA");
        int tgaIndex = findStopCodon(dna, atgIndex, "TGA");
        int tagIndex = findStopCodon(dna, atgIndex, "TAG");
        //int minIndex = Math.min(taaIndex, Math.min(tgaIndex, tagIndex));
        int minIndex = 0;
        if (taaIndex == -1 || (taaIndex > tgaIndex && tgaIndex != -1)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || (minIndex > tagIndex && tagIndex != -1)) {
            minIndex = tagIndex;
        } 
        
        if (minIndex == -1) return "";
        
        return dna.substring(atgIndex, minIndex + 3);
    }
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        String gene = "";
        
        while (true) {
            // find gene
            gene = findGene(dna, startIndex);
            // if no gene found, break
            if (gene.isEmpty()) break;
            // print gene
            System.out.println(gene);
            // update startIndex 
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
    }   
    
    public void testFindStopCodon() {
        //                  0123456789012
        String testCase1 = "ATGCAGTAA"; // normal case
        String testCase2 = "CGATGGA"; // without stop codon
        String testCase3 = "ATGCGTGACTGA"; // not follow the multiple 3 rule 
        String testCase4 = ""; // empty string
        
        System.out.println("Test begins:");
        if (findStopCodon(testCase1, 0, "TAA") != 6)
            System.out.println("test case 1 failed");
        if (findStopCodon(testCase2, 1, "TAG") != -1)
            System.out.println("test case 2 failed");
        if (findStopCodon(testCase3, 0, "TGA") != 9)
            System.out.println("test case 3 failed");
        if (findStopCodon(testCase4, 0, "TAA") != -1)
            System.out.println("test case 4 failed");
        System.out.println("Test finished!");
    }
    
    public void testFindGene() {
        //                  0123456789012345678
        String testCase1 = "ATGCAGTAAC"; // normal case
        String testCase2 = "AACCTTAA"; // without start codon ATG
        String testCase3 = "CGATGGA"; // without stop codon
        String testCase4 = "ATGCGTGAC"; // not follow the multiple 3 rule
        String testCase5 = "CATGGCTAACTGAAAATAG"; // multiple stop codons
                                 // #       # #          #
        String testCase6 = "AACCTTAAATGCAGTAACATGCGTGACTAACTGAATAGCGATGGA"; 
        
        System.out.println("Test begins:");
   
        System.out.println("test case 1: " + findGene(testCase1, 0));
        System.out.println("test case 2: " + findGene(testCase2, 0));
        System.out.println("test case 3: " + findGene(testCase3, 0));
        System.out.println("test case 4: " + findGene(testCase4, 0));
        System.out.println("test case 5: " + findGene(testCase5, 0));
        System.out.println("test case 6: ");
        printAllGenes(testCase6);
        
        System.out.println("Test finished!");
    }
}
