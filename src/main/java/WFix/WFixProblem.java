package WFix;

public class WFixProblem {


    /**
     * unsorted array, +ve, -ve, duplicates
     * largest and the 2nd largest number from the array
     */
    public static void findLargestAndSmallest(int[] array){
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > firstLargest){
                secondLargest = firstLargest;
                firstLargest = array[i];
            } else if(array[i] > secondLargest){
                secondLargest = array[i];
            }
        }
        System.out.println(firstLargest + " : "+secondLargest);
    }

    /**
     * H@LL@ W@RLD = D@LR@ W@LLH
     * HELLO WORLD = DLROW OLLEH = D@RO@ O@LEH
     * Vowels = @
     * Reverse string and retain position of @
     */
    public static void escapeAndShift(String input){
        String tempString = input.replace("@","");
        String reversedString = "";
        int index = tempString.length()-1;
        for (char ch : input.toCharArray()) {
            if(ch!='@' || ch!=' '){
                reversedString += tempString.charAt(index--);
            } else {
                reversedString += ch;
            }
        }
        System.out.println(reversedString);
    }


    public static void main(String[] args) {
        //findLargestAndSmallest(new int[] {11,9,-1,2,0,15,-40,2,2,3,3,-9,10});
        escapeAndShift("H@LL@ W@RLD");
    }
}
