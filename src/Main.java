import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * Where the magic happens
     *
     * @param args args
     * @throws FileNotFoundException if file was not added yet
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fs = new Scanner(new File("input5.txt"));
        Scanner baseTest = new Scanner("""
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8""");
        System.out.println(solve5_2(fs));
    }


    /**
     * For the first day of AoC 2022
     * INPUT FILE: input.txt
     *
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
     *
     * @param sc scanner
     * @return correct answers
     */
    public static int solve2_1(Scanner sc) {
        int res = 0;
        int i = 0;
        while (sc.hasNextLine()) {
            i++;
            String ln = sc.nextLine();
            String[] rps = ln.split(" ");
            int op = (int) rps[0].charAt(0) - 'A' + 1;
            int eu = (int) rps[1].charAt(0) - 'X' + 1;
            if (eu == 0 || op == 0) {
                System.out.println(i);
                System.out.println("wtf");
            }
            if (rps(op, eu) > 0)
                res += 6;
            else if (rps(op, eu) == 0)
                res += 3;
            res += eu;
        }
        return res;
    }

    public static int rps(int a, int b) {
        if (a == b)
            return 0;
        if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2))
            return -1;
        return 1;
    }

    public static int solve2_2(Scanner sc) {
        int res = 0;
        while (sc.hasNextLine()) {
            String ln = sc.nextLine();
            String[] rps = ln.split(" ");
            int op = (int) rps[0].charAt(0) - 'A' + 1;

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
     *
     * @param sc scanner
     * @return correct answers
     */
    public static int solve3_1(Scanner sc) {
        int res = 0;
        while (sc.hasNextLine()) {
            String ln = sc.nextLine();
            String half1 = ln.substring(0, ln.length() / 2);
            String half2 = ln.substring(ln.length() / 2);
            int i = 0;
            char x = '0';
            while (i < half1.length()) {
                x = half1.charAt(i);
                if (half2.contains(Character.toString(x))) {
                    break;
                }
                i++;
            }
            if (Character.isLowerCase(x))
                res = res + (int) x - 'a' + 1;
            else if (Character.isUpperCase(x))
                res = res + (int) x - 'A' + 27;
            else System.out.println("wtf");
        }
        return res;
    }

    public static int solve3_2(Scanner sc) {
        int res = 0;
        while (sc.hasNextLine()) {
            String ln1 = sc.nextLine();
            String ln2 = sc.nextLine();
            String ln3 = sc.nextLine();
            int i = 0;
            char x = '0';
            while (i < ln1.length()) {
                x = ln1.charAt(i);
                if (ln2.contains(Character.toString(x)) && ln3.contains(Character.toString(x))) {
                    break;
                }
                i++;
            }
            if (Character.isLowerCase(x))
                res = res + (int) x - 'a' + 1;
            else if (Character.isUpperCase(x))
                res = res + (int) x - 'A' + 27;
            else System.out.println("wtf");
        }
        return res;
    }

    /**
     * For the fourth day of AoC 2022
     * INPUT FILE: input4.txt
     *
     * @param sc scanner
     * @return correct answers
     */
    public static int solve4_1(Scanner sc) {
        int res = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] params = line.split("[, -]");
            if ((Integer.parseInt(params[0]) <= Integer.parseInt(params[2]) &&
                Integer.parseInt(params[1]) >= Integer.parseInt(params[3])) ||
                Integer.parseInt(params[0]) >= Integer.parseInt(params[2]) &&
                    Integer.parseInt(params[1]) <= Integer.parseInt(params[3]))
                res++;
        }
        return res;
    }

    public static int solve4_2(Scanner sc) {
        int res = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] params = line.split("[, -]");
            // 2 4    6 8
            // 5 7    7 9
            // 2 8    3 7
            // 3 7    2 8
            int a, b, c, d;
            a = Integer.parseInt(params[0]);
            b = Integer.parseInt(params[1]);
            c = Integer.parseInt(params[2]);
            d = Integer.parseInt(params[3]);
            ///surely there's a better way to do this lmao
            if ((c >= a && c <= b) || (d >= a && d <= b) ||
                (a >= c && a <= d) || (b >= c && b <= d))
                res++;

        }
        return res;
    }

    /**
     * For the fifth day of AoC 2022
     * INPUT FILE: input5.txt
     * Very wonky reading; Wish I could've made an array of LinkedLists...
     * @param sc scanner
     * @return correct answers
     */
    public static String solve5_1(Scanner sc) {
        String line = sc.nextLine();
        ArrayList<LinkedList<Character>> group = new ArrayList<>(100);
        for(int i=0;i<100;i++)
            group.add(new LinkedList<>());
        while (!line.trim().equals("")){
            for(int i=0; i<line.length();i++){
                if(line.charAt(i)>='A' && line.charAt(i)<='Z'){
                    LinkedList<Character> temp= group.get(i/4);
                    temp.addFirst(line.charAt(i));
                    group.set(i/4,temp);
                }
            }
            if(sc.hasNextLine())
            line = sc.nextLine();
            else break;
        }
        int alpha;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            String[] spl = line.split(" ");
            int noCrates = Integer.parseInt(spl[1]);
            int from = Integer.parseInt(spl[3]);
            int to = Integer.parseInt(spl[5]);
            from--;
            to--;
            if (from == 6 && to == 4)
                alpha=4;

            LinkedList fro = group.get(from);
            LinkedList t = group.get(to);
            for(int j=0; j<noCrates;j++){
                t.addLast(fro.removeLast());
            }
            group.set(from,fro);
            group.set(to,t);
        }

        StringBuilder sb = new StringBuilder();
        for(LinkedList ll :group){
            if(ll.size()!=0)
                sb.append(ll.getLast());
        }
        return sb.toString();
    }

    public static String solve5_2(Scanner sc) {
        String line = sc.nextLine();
        ArrayList<LinkedList<Character>> group = new ArrayList<>(100);
        for(int i=0;i<100;i++)
            group.add(new LinkedList<>());
        while (!line.trim().equals("")){
            for(int i=0; i<line.length();i++){
                if(line.charAt(i)>='A' && line.charAt(i)<='Z'){
                    LinkedList<Character> temp= group.get(i/4);
                    temp.addFirst(line.charAt(i));
                    group.set(i/4,temp);
                }
            }
            if(sc.hasNextLine())
                line = sc.nextLine();
            else break;
        }
        int alpha;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            String[] spl = line.split(" ");
            int noCrates = Integer.parseInt(spl[1]);
            int from = Integer.parseInt(spl[3]);
            int to = Integer.parseInt(spl[5]);
            from--;
            to--;


            LinkedList fro = group.get(from);
            LinkedList t = group.get(to);
            LinkedList<Character> tempp = new LinkedList<>();
            for(int j=0; j<noCrates;j++){
                tempp.addLast((Character) fro.removeLast());
            }
            for(int j=0; j<noCrates;j++){
                t.addLast(tempp.removeLast());
            }
            group.set(from,fro);
            group.set(to,t);
        }

        StringBuilder sb = new StringBuilder();
        for(LinkedList ll :group){
            if(ll.size()!=0)
                sb.append(ll.getLast());
        }
        return sb.toString();
    }
}
