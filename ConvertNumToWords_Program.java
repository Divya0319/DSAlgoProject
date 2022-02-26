public class MyClass {
    
    public static void main(String args[]) {
            numberToWords("1111".toCharArray());  
            numberToWords("673".toCharArray());  
            numberToWords("85".toCharArray());  
            numberToWords("5".toCharArray());  
            numberToWords("0".toCharArray());  
            numberToWords("20".toCharArray());  
            numberToWords("1000".toCharArray());  
            numberToWords("12345".toCharArray());  
            //passing empty string   
            numberToWords("".toCharArray());  
    }

    
    public static void numberToWords(char[] num) {
        int len = num.length;
        if(len == 0) 
        {
            System.out.println("String is empty");
            return;
        }
        
        if(len > 4) {
           System.out.println("Only numbers upto 4 digits allowed");
            return; 
        }
        
        // string type array for one digit numbers
        String[] oneDigit = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        //string type array for two digits numbers    
        //the first index is empty because it makes indexing easy   
        String[] twodigits = new String[] {"", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};  
        //string type array of tens multiples   
        //the first two indexes are empty because it makes indexing easy   
        String[] multipleoftens = new String[] {"",  "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};  
        //string type array of power of tens   
        String[] poweroftens = new String[] {"Hundred", "Thousand"};  
        
        /* Used for debugging purpose only */
        System.out.print(String.valueOf(num) + ":");
        
        /* For single digit number */
        if(len == 1) {
            System.out.println(oneDigit[num[0] - '0']);
            return;
        }
        
        int x = 0;
        
        //executes until num does not become not '\0'  
        while(x < num.length) {
        
        /* Code path for first 2 digits */
        if(len >= 3) {
            if(num[x] - '0' != 0) {
                System.out.print(oneDigit[num[x] - '0'] + " ");
                System.out.print(poweroftens[len-3] + " ");
                
            }
            len--;
            
        } 
        /* Code path for last 2 digits */
        else {
    
            if(num[x] -'0' == 1) {
                int sum = num[x] -'0' + num[x+1] -'0';
                System.out.println(twodigits[sum]);
                
                return;
            } 
            /* Need to explicitly handle 20 */
            else if(num[x] -'0' == 2 && num[x+1] - '0' == 0) {
                System.out.println("Twenty");
                
                return;
            }
            /* Rest of the two digit
                numbers i.e., 21 to 99 */
            else{
                int i = (num[x] - '0');
                if(i > 0) {
                    System.out.print(multipleoftens[i] + " ");
                }
                else 
                    System.out.print("");
                
                ++x;
                
                if(num[x] - '0' != 0) 
                    System.out.println(oneDigit[num[x] - '0']);
                
            }
            
        }
        ++x;
         
            
    }
  }
    
    

}