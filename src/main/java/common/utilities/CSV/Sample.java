package common.utilities.CSV;

public class Sample {

    public static void insertData(){
        String[] lines = {"A1dfsd", "A2sfsdf", "A1dfsd", "banana" };

        for (int i = 0; i < lines.length; i++) {
            if(i+1 < lines.length &&
                    (lines[i].toLowerCase().startsWith("a1") && lines[i+1].toLowerCase().startsWith("a2"))){
                System.out.println(lines[i]);
                System.out.println(lines[i+1]);
                i = i+1;
                continue;
            }

            if((lines[i].toLowerCase().startsWith("a1") || lines[i].toLowerCase().startsWith("a2"))){
                continue;
            }

            System.out.println(lines[i]);
        }
    }

    public static void main(String[] args) {
        insertData();
    }
}
