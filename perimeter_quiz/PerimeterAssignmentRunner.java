import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        // Start with totalPoints = 0
        int totalPoints = 0;
        // For each point currPt in the shape,
        for (Point currPt: s.getPoints()) {
            // Increment totalPoints for each point 
            totalPoints = totalPoints + 1;
        }
        
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        // Start with averageLength = 0.0
        double averageLength = 0.0;
        // Get perimeter and total points
        double length = getPerimeter(s);
        int totalPoints = getNumPoints(s);
        // Calculate the averageLength
        averageLength = length / totalPoints;
        
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        // Start with largestSide = 0.0
        double largestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if (currDist > largestSide) 
                largestSide = currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        // Start with largestX = 0.0
        double largestX = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currX = currPt.getX();
            // Update totalPerim by currDist
            if (currX > largestX) 
                largestX = currX;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        // Start with the largestPr = 0.0
        double largestPr = 0.0;
        // loop through every files
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            // compare the size of perimeter
            if (length > largestPr)
                largestPr = length;
        }
        return largestPr;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        // Start with the largestPr = 0.0
        double largestPr = 0.0;
        // replace this code
        File temp = null; 
        // loop through every files
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            // compare the size of perimeter
            if (length > largestPr) {
                largestPr = length;
                temp = f;
            }
        }
        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int totalPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("total points = " + totalPoints);
        System.out.println("average length = " + averageLength);
        System.out.println("largest side = " + largestSide);
        System.out.println("largest x value over all the points = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPr = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter over all the shapes = " + largestPr);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestPrFile = getFileWithLargestPerimeter();
        System.out.println("the file with the largest perimeter = " + largestPrFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
