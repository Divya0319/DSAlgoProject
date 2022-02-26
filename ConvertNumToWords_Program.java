public class MyClass {
    
    public static void main(String args[]) {
            numberToWords("1111".toCharArray());  
            numberToWords("673".toCharArray());  
            numberToWords("85".toCharArray());  
            numberToWords("5".toCharArray());  
            numberToWords("0".toCharArray());  
            numberToWords("20".toCharArray());  
            numberToWords("1000".toCharArray());  // whenever the function sees 0 in the digits other than MSB, then it simply ignores its printing
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
            System.out.println(oneDigit[num[0] - '0']);  // print single digit number and immediately go out of method
            return;
        }
        
        int x = 0;    // this variable handles the index of char array of number one by one
        
        //executes until num does not become not '\0'  
        while(x < num.length) {     // means only run the loop till length of the char array
        
        /* Code path for first 2 digits */
        if(len >= 3) {   // this code block is only executed for 3 or 4 digit numbers, for 2 digit numbers, block below it is considered
            if(num[x] - '0' != 0) {
                System.out.print(oneDigit[num[x] - '0'] + " ");
                System.out.print(poweroftens[len-3] + " ");
                
            }
            len--;    // we are decrement length bcz next time when we come, since we have already printed for first digit, we don't need to consider it next time
            
        } 
        /* Code path for last 2 digits */
        else {
    
            if(num[x] -'0' == 1) {
                int sum = num[x] -'0' + num[x+1] -'0';   // sum is performed for printing bcz, for printing 15, we add 1 and 5, getting 6, so printing 6th index from twodigit
				//array,  which is fifteen
                System.out.println(twodigits[sum]);
                
                return;   // we are simply returning because, we are in block in which length 2 is there for number, and so, its printing is finished.
            } 
            /* Need to explicitly handle 20 */
            else if(num[x] -'0' == 2 && num[x+1] - '0' == 0) {
                System.out.println("Twenty");   //Since 20 is in a seperate array, we have to consider it separately
                
                return;
            }
            /* Rest of the two digit
                numbers i.e., 21 to 99 */
            else{
                int i = (num[x] - '0');
                if(i > 0) {  // this condition ensures that if any 0 is present inside number, not on LSB or MSB, then it should not be considered for printing(bcz in 603, we don't print anything for 0)
                    System.out.print(multipleoftens[i] + " ");
                }
                else 
                    System.out.print("");  // printing nothing if 0 is there
                
                ++x; // we are immediately incrementing x here bcz, if 39 is the sub-number, after printing Thirty, we have to print Nine, and so, we have to consider next digit immediately
                
                if(num[x] - '0' != 0) 
                    System.out.println(oneDigit[num[x] - '0']);  // again, if next digit from left is 0, then we simply ignore it, or else, print the digit's 1 digit word
                
            }
            
        }
        ++x;
         
            
    }
  }
    
    

}