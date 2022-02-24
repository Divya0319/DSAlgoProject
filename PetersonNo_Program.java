public class MyClass {
    
    public static void main(String args[]) {
            int num = 145;
            System.out.println(num + " is Peterson no.? " + isPeterson(num));
    }
    
    public static boolean isPeterson(int n) {
        int orig = n;
        int sum = 0;
        
        while(n > 0) {
            int dig = n % 10;
            sum = sum + fact(dig);
            
            n = n / 10;
        }
    
        if(orig !=0 && orig == sum) return true;
        
        return false;
    }
    
    public static int fact(int a) {
        int fact = 1;
        for(int i = 2; i <=a; i++) {
            fact = fact * i;
        }
        
        return fact;
    }
}