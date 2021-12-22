
/**
 * Write a description of Part2FindMultiOccur here.
 * 
 * @author ycleo
 * @date 2021-12-22
 */
public class Part2FindMultiOccur {
    public int findTargetStr(String targetStr, String originStr, int startIndex) {
        int stopIndex = originStr.indexOf(targetStr, startIndex);
        
        if (stopIndex != -1) {
            return stopIndex + targetStr.length();
        } else {
            return -1;
        }
    }
    // This method returns an integer indicating how many times str1 appears in str2
    public int howMany(String str1, String str2) {
        int startIndex = 0;
        int count = 0;
        
        while (true) {
            startIndex = findTargetStr(str1, str2, startIndex);
            if (startIndex == -1) break;
            count += 1;
        }
        return count;
    }    
    
    public void test() {
        if (howMany("GAA", "ATGAACGAATTGAATC") == 3)
            System.out.println("test case 1 passed");
        if (howMany("AA", "ATAAAA") == 2)
            System.out.println("test case 2 passed");
        if (howMany("C", "") == 0)
            System.out.println("test case 3 passed");
    }
}
