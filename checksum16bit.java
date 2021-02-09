import java.util.Scanner;

public class checksum16bit 
{
    public static void main(String args[]) {

        final int max_int = 65535;// The maximum size for the input
        int count;                // The number of integers to read from stdin
        int sum = 0;              // Note that the "sum" might exceed max_int
        int checksum = 0;         // The value of the 6th input integer
        int quotient;             // The result of evaluating the assignment:  quotient   = sum / (max_int + 1);
        int remainder;            // The result of evaluating the assignment:  remainder  = sum % (max_int + 1 );
        int complement;           // The result of evaluationg the assignment: complement = max_int - sum;
        int number;               // Number is a temp place holder
        int input;                // Tempoary Placeholder for the value of the input
    
        Scanner stdin = new Scanner(System.in);
        System.out.println("How many numbers will you be inputting?");
        number = stdin.nextInt();
        input = number;
        count = number;
        //count = ((number >> 8) & 0x0F)*2;
        number = number/2 +1; // The place of the n/2 +1

        try{
            while(count > 0){
                input = stdin.nextInt();
                if(input < 0 || input > 65535){
                    throw new Exception("Out of bound value, Termination program");
                }  
                if(count == number){
                    checksum = input;
                }else{
                    sum += input;
                }
                count--;
            }
            quotient = sum / (max_int + 1);
            remainder = sum % (max_int + 1);
            sum = quotient + remainder;
            complement = max_int - sum;
        
            System.out.printf("Stored Checksum: %d, Computed Checksum: %d\n", checksum, complement);
            if (checksum != complement ) {
            System.err.printf("Error Detected!\n");  
            }
        }catch (Exception except){
            System.out.println(except.getMessage());
        } 
    }//end of main
}//end of checksum class
