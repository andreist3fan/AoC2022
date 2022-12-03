import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * Where the magic happens
     * @param args args
     * @throws FileNotFoundException if file was not added yet
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fs = new Scanner(new File("input3.txt"));
        Scanner baseTest= new Scanner("");
        System.out.println(solve3_2(fs));
    }


    /**
     * For the first day of AoC 2022
     * INPUT FILE: input.txt
     * @param sc scanner
     * @return correct answers
     */
    public static int solve1(Scanner sc) {
        int mx1 = -1;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int val = 0;
            while (!line.trim().equals("") && sc.hasNext()) {
                val += Integer.parseInt(line);
                line = sc.nextLine();
            }
            if (val > mx1) {
                mx1 = val;
            }
        }
        return mx1;
    }
    public static int solve1_2(Scanner sc) {
        int mx1 = -1, mx2 = -1, mx3 = -1;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int val = 0;
            while (!line.trim().equals("")) {
                val += Integer.parseInt(line);
                if (sc.hasNext())
                    line = sc.nextLine();
                else break;
            }
            if (val > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = val;
            } else if (val > mx2) {
                mx3 = mx2;
                mx2 = val;
            } else if (val > mx3) {
                mx3 = val;
            }
        }
        return mx1 + mx2 + mx3;
    }

    /**
     * For the second day of AoC 2022
     * INPUT FILE: input2.txt
     * @param sc scanner
     * @return correct answers
     */
    public static int solve2_1(Scanner sc) {
        int res = 0;
        int i=0;
        while (sc.hasNextLine()) {
            i++;
            String ln = sc.nextLine();
            String[] rps = ln.split(" ");
            int op =(int) rps[0].charAt(0) - 'A'+1;
            int eu =(int) rps[1].charAt(0) - 'X'+1;
            if(eu==0 || op==0)
            {
                System.out.println(i);
                System.out.println("wtf");
            }
            if(rps(op,eu)>0)
                res+=6;
            else if (rps(op,eu)==0)
                res+=3;
            res += eu;
        }
        return res;
    }
    public static int rps(int a, int b){
        if( a == b)
            return 0;
        if((a==1 && b==3)||(a==2 && b==1)||(a==3 && b==2))
            return -1;
        return 1;
    }
    public static int solve2_2(Scanner sc) {
        int res = 0;
        while (sc.hasNextLine()) {
            String ln = sc.nextLine();
            String[] rps = ln.split(" ");
            int op =(int) rps[0].charAt(0) - 'A'+1;

            switch (rps[1].trim()) {
                case "X":
                    if (op > 1)
                        res += (op - 1);
                    else res += 3;
                    break;
                case "Y":
                    res += (op + 3);
                    break;
                case "Z":
                    if (op < 3)
                        res += (op + 1 + 6);
                    else res += (7);
                    break;
            }
        }
        return res;
    }

    /**
     * For the third day of AoC 2022
     * INPUT FILE: input3.txt
     * @param sc scanner
     * @return correct answers
     */
    public static int solve3_1(Scanner sc){
        int res=0;
        while(sc.hasNextLine()){
            String ln = sc.nextLine();
            String half1 = ln.substring(0,ln.length()/2);
            String half2 = ln.substring(ln.length()/2);
            int i=0;
            char x='0';
            while(i<half1.length()){
                x =half1.charAt(i);
                if(half2.contains(Character.toString(x))){
                   break;
                }
                i++;
            }
            if(Character.isLowerCase(x))
                res=res + (int) x-'a'+1;
            else if(Character.isUpperCase(x))
                res=res + (int) x-'A'+27;
            else System.out.println("wtf");
        }
        return res;
    }
    public static int solve3_2(Scanner sc){
        int res=0;
        while(sc.hasNextLine()){
            String ln1 = sc.nextLine();
            String ln2 = sc.nextLine();
            String ln3=sc.nextLine();
            int i=0;
            char x='0';
            while(i<ln1.length()){
                x =ln1.charAt(i);
                if(ln2.contains(Character.toString(x))&&ln3.contains(Character.toString(x))){
                    break;
                }
                i++;
            }
            if(Character.isLowerCase(x))
                res=res + (int) x-'a'+1;
            else if(Character.isUpperCase(x))
                res=res + (int) x-'A'+27;
            else System.out.println("wtf");
        }
        return res;
    }

    /**
     * For the fourth day of AoC 2022
     * INPUT FILE: input4.txt
     * @param sc scanner
     * @return correct answers
     */
    public static int solve4_1(Scanner sc){
        return -1;
    }
    public static int solve4_2(Scanner sc){
        return 0;
    }
}
