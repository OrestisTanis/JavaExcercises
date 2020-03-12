
package javahomeexercises;

public class JavaHomeExercises {

    public static void main(String[] args) {
        // Circle
        float circleRadius = 7.5f;
        System.out.printf("The area of a circle with radius %.1f is %.2f and the perimeter is %.2f%n", circleRadius, calcCircleArea(circleRadius), calcCirclePerimeter(circleRadius));
        
        // Rectangle
        float rectWidth = 5.5f;
        float rectLength = 8.5f;
        float rectHeight = 3.5f;
        System.out.printf("The area of a rectangle with length %.2f, width %.2f and height %.2f is %.2f and the volume is %.2f%n", rectLength, rectWidth, rectHeight, calcRectArea(rectWidth, rectWidth), calcRectVolume(rectLength, rectWidth, rectHeight));

        // Inches to Metres
        System.out.printf("100 inches correspond to %.2fm%n", inchesToMetres(100));
        
        // Discounts
        float productPrice = 150.5f;
        printDiscounts(productPrice);
        
        // Seconds to Hours
        short numberOfSeconds = 3600;
        System.out.printf("%d second(s) is %.2f hour(s)", numberOfSeconds, secToHour(numberOfSeconds));
        
    }
    
    // Circle
    static float calcCircleArea(float radius){
        return (float) (Math.PI * Math.pow(radius, 2));
    }
    
    static float calcCirclePerimeter(float radius){
        return (float) (2 * Math.PI * radius);
    }
    
    // Rectangle
    static float calcRectArea(float length, float width){
        return length * width;
    }
    
    static float calcRectVolume(float length, float width, float height){
        return length * width * height;
    }
    
    // Farenheit to Celcius
    static float farenheitToCelcius(float tempF){
        return (tempF - 32) * 5 / 9;
    }
    
    // Inches to Metres
    static float inchesToMetres(float inch){
        return inch / 39.37f;
    }
    
    // Product Discount
    static void printDiscounts(float price){
        float discount = 0.1f;
        for (int i = 1; i < 7; i++){
            System.out.printf("With %d0%% discount, the price is: %.2f$%n", i, price * (1 - i * discount));
        }
        
    }
    
    // Seconds to Hours
    static float secToHour(short sec){
        return sec / 3600;
    }
    
}
