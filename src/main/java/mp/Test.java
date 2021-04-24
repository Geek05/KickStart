package mp;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static void hosepull() {
        String main = "Baby is a Baby in the Baby and";
        String search = "Baby";
        main = main.toLowerCase();
        search = search.toLowerCase();
        char[] mainCharArray = main.toCharArray();
        char[] searchCharArray = search.toCharArray();
        int mainIndex = 0;
        int searchIndex = 0;

        List<Integer> foundIndxes = new ArrayList<>();
        while(mainIndex < main.length()) {
            if(searchIndex < search.length() && mainCharArray[mainIndex] == searchCharArray[searchIndex]) {
                int foundIndex = mainIndex;
                for (int i = 0; i < search.length(); i++) {
                    if(mainIndex < main.length() && mainCharArray[mainIndex] == searchCharArray[searchIndex]) {
                        mainIndex++;
                        searchIndex++;
                    } else {
                        searchIndex =0;
                        break;
                    }
                    if(searchIndex == search.length()){
                        searchIndex = 0;
                        foundIndxes.add(foundIndex);
                    }

                }
            }
            mainIndex++;
        }
        System.out.println(foundIndxes);
    }

    public static void main(String[] args) {
        hosepull();
    }


}
