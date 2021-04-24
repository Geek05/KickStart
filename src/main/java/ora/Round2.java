package ora;

import java.util.Arrays;

public class Round2 {

    /**
     * An array is given of n length, and we need to calculate the next greater element for each element in the given array.
     * If the next greater element is not available in the given array, then we need to fill ‘0’ at that index place
     * Input :  6 3 9 8 10 2 1 15 7
     * Output : 7 6 10 9 15 3 2 0 8
     */
    public static void arrayQuestion(int[] array){
        int[] finalArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            finalArray[i] = computeNextGreatest(array, array[i], i);
        }
        System.out.println(Arrays.toString(finalArray));
    }

    private static int computeNextGreatest(int[] array, int element, int currentIndex) {
        int nextGreatest = Integer.MAX_VALUE;
        int currentGreatest = 0;
        for (int i = 0; i < array.length; i++) {
            if(i!=currentIndex){
               if(array[i] >= element){
                   currentGreatest = array[i];
                   if(currentGreatest < nextGreatest){
                       nextGreatest = currentGreatest;
                   }
               }
            }
        }
        return Integer.MAX_VALUE==nextGreatest ? 0 : nextGreatest;
    }

    /**
     *
     * “aBc deF g12 3h4 i_j $_# 1_2”
     * “AbcDefG12_3h4_Ij_$_#_1_2”
     */
    public static void replaceStrings(String input){
        String modifiedString = replaceAlphabets(input);
        System.out.println(modifiedString);
        modifiedString = replaceSpace(modifiedString);
        System.out.println(modifiedString);
        modifiedString = replaceUnderscore(modifiedString);
        System.out.println(modifiedString);
    }

    /**
     * All words that begin with an alphabet should be replaced such that first character is Uppercase,
     * and remaining characters are all Lowercase
     */
    public static String replaceAlphabets(String input){
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]==' ') { //later
                if (i<charArray.length-1 && isAlphabet(charArray[i+1])) {
                    charArray[i+1] = String.valueOf(charArray[i+1]).toUpperCase().charAt(0);
                }
            }
        }
        return String.valueOf(charArray);
    }

    private static boolean isAlphabet(char ch) {
        if(ch >='a' && ch < 'z' || ch >='A' && ch < 'Z')
            return true;
        return false;
    }

    /**
     * •	Space character is replaced with Underscore,
     * unless it occurs between two Alphabets (on both sides),
     * in which case, it is replaced with Empty String
     */
    public static String replaceSpace(String input){
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(i<charArray.length && charArray[i]==' ' ){
                if((i>0 && !isAlphabet(charArray[i-1])) || (!isAlphabet(charArray[i+1]))){
                    charArray[i] = '_';
                }
            }
        }
        return String.valueOf(charArray).replace(" ", "");
    }

    /**
     * •	Underscore should be retained as it is,
     * unless it occurs between two Alphabets (on both sides), in which case,
     * it is replaced with Empty string
     */
    public static String replaceUnderscore(String input){
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(i<charArray.length && charArray[i]=='_' ){
                if((i>0 && isAlphabet(charArray[i-1])) || (isAlphabet(charArray[i+1]))){
                    charArray[i] = ' ';
                }
            }
        }
        return String.valueOf(charArray).replace(" ", "");
    }


    public static void main(String[] args) {
        int[] array = new int[]{6 ,3 ,9 ,8 ,10, 2 ,1 ,15, 7 };
        replaceStrings("aBc deF g12 3h4 i_j $_# 1_2");
    }
}
