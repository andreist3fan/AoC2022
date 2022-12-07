import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    /**
     * The first seven days of Advent of Code 2022 below
     *
     * @param args args
     * @throws FileNotFoundException if file was not added yet
     */
    public static void main(String[] args) throws Exception {
        Scanner fs = new Scanner(new File("input7.txt"));
        Scanner baseTest = new Scanner("""
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8""");
        //System.out.println(test(fs));
        System.out.println(solve7_2(fs));

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
     *
     * @param sc scanner
     * @return correct answers
     */
    public static String solve5_1(Scanner sc) {
        String line = sc.nextLine();
        ArrayList<LinkedList<Character>> group = new ArrayList<>(100);
        for (int i = 0; i < 100; i++)
            group.add(new LinkedList<>());
        while (!line.trim().equals("")) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                    LinkedList<Character> temp = group.get(i / 4);
                    temp.addFirst(line.charAt(i));
                    group.set(i / 4, temp);
                }
            }
            if (sc.hasNextLine())
                line = sc.nextLine();
            else break;
        }
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] spl = line.split(" ");
            int noCrates = Integer.parseInt(spl[1]);
            int from = Integer.parseInt(spl[3]);
            int to = Integer.parseInt(spl[5]);
            from--;
            to--;

            LinkedList<Character> fro = group.get(from);
            LinkedList<Character> t = group.get(to);
            for (int j = 0; j < noCrates; j++) {
                t.addLast(fro.removeLast());
            }
            group.set(from, fro);
            group.set(to, t);
        }

        StringBuilder sb = new StringBuilder();
        for (LinkedList<Character> ll : group) {
            if (ll.size() != 0)
                sb.append(ll.getLast());
        }
        return sb.toString();
    }

    public static String solve5_2(Scanner sc) {
        String line = sc.nextLine();
        ArrayList<LinkedList<Character>> group = new ArrayList<>(100);
        for (int i = 0; i < 100; i++)
            group.add(new LinkedList<>());
        while (!line.trim().equals("")) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                    LinkedList<Character> temp = group.get(i / 4);
                    temp.addFirst(line.charAt(i));
                    group.set(i / 4, temp);
                }
            }
            if (sc.hasNextLine())
                line = sc.nextLine();
            else break;
        }
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] spl = line.split(" ");
            int noCrates = Integer.parseInt(spl[1]);
            int from = Integer.parseInt(spl[3]);
            int to = Integer.parseInt(spl[5]);
            from--;
            to--;


            LinkedList<Character> fro = group.get(from);
            LinkedList<Character> t = group.get(to);
            LinkedList<Character> tempp = new LinkedList<>();
            for (int j = 0; j < noCrates; j++) {
                tempp.addLast(fro.removeLast());
            }
            for (int j = 0; j < noCrates; j++) {
                t.addLast(tempp.removeLast());
            }
            group.set(from, fro);
            group.set(to, t);
        }

        StringBuilder sb = new StringBuilder();
        for (LinkedList<Character> ll : group) {
            if (ll.size() != 0)
                sb.append(ll.getLast());
        }
        return sb.toString();
    }
    /**
     * For the sixth day of AoC 2022
     * INPUT FILE: input6.txt
     * Back to normal(ish) stuff
     *
     * @param sc scanner
     * @return correct answers
     */
    public static int solve6_1(Scanner sc) {
        String line = sc.nextLine();
        char[] m = line.toCharArray();
        List<Character> app = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (app.contains(m[i])) {
                app = new ArrayList<>();
            } else
                app.add(m[i]);
        }
        for (int i = 3; i < m.length; i++) {
            if (app.size() == 4)
                return i;
            if (app.contains(m[i])) {
                app = app.subList(app.indexOf(m[i]) + 1, app.size());
            }

            app.add(m[i]);
        }
        return -1;
    }

    public static int solve6_2(Scanner sc) {
        String line = sc.nextLine();
        char[] m = line.toCharArray();
        List<Character> app = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (app.contains(m[i])) {
                app = new ArrayList<>();
            } else
                app.add(m[i]);
        }
        for (int i = 3; i < m.length; i++) {
            if (app.size() == 14)
                return i;
            if (app.contains(m[i])) {
                app = app.subList(app.indexOf(m[i]) + 1, app.size());
            }

            app.add(m[i]);
        }
        return -1;
    }
    /**
     * For the seventh day of AoC 2022
     * <p>INPUT FILE: input7.txt</p>
     * In my defense, I did know it was a tree, but
     * I did not want to use the classic tree formula.
     * @param sc scanner
     * @return correct answers
     */
    /*
     * Scrapped solution below because I'm stupid and did not account for identical name
     * directories
     */
//    public static long solve7_1(Scanner sc){
//        ArrayList<String> id = new ArrayList<>(); // to link directories to ids
//        ArrayList<Long> overall_sums = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> sons= new ArrayList<>();
//        sons.add(new ArrayList<>());
//        id.add("/");
//        overall_sums.add((long)0);
//        Stack<String> currDir = new Stack<>();
//        boolean ok=true;
//        String line="";
//        while(sc.hasNextLine()){
//            if(ok)
//                line = sc.nextLine();
//            ok=true;
//            String[] subL = line.split(" ");
//            if(subL[1].equals("cd")){
//                if(subL[2].equals("djb"))
//                    System.out.println("oke");
//                if(subL[2].equals(".."))
//                    currDir.pop();
//                else if(subL[2].equals("/")){
//                    currDir = new Stack<>();
//                    currDir.push("/");
//                }
//                else {
//                    //String cs = currDir.peek();
//                    //if(sons.get(id.indexOf(cs)).contains(id.indexOf(subL[2])))
//                    currDir.push(subL[2]);
//                    //else
//                        //System.out.println("happens");
//                }
//            }
//            else{
//                line=sc.nextLine();
//                ok=false;
//                while(!line.startsWith("$")){
//                    if(line.startsWith("dir")){
//                        String dir = line.split(" ")[1];
//                        //if(!id.contains(dir)){
//                            id.add(dir);
//                            overall_sums.add((long)0);
//                            sons.add(new ArrayList<>());
//                        //}
//                        String cd = currDir.peek();
//                        ArrayList<Integer> dirr = sons.get(id.indexOf(cd));
//                        if(!dirr.contains(id.indexOf(dir)))
//                            dirr.add(id.indexOf(dir));
//                        sons.set(id.indexOf(cd),dirr);
//                    }
//                    else{
//                        int val = Integer.parseInt(line.split(" ")[0]);
//                        Stack<String> temp = (Stack<String>) currDir.clone();
//                        while(!temp.isEmpty()){
//                            String cd = temp.pop();
//                            long sms = overall_sums.get(id.indexOf(cd));
//                            sms+=val;
//                            overall_sums.set(id.indexOf(cd),sms);
//                        }
//                    }
//                    if(sc.hasNextLine())
//                        line= sc.nextLine();
//                    else line = "$";
//                }
//            }
//
//        }
//        long res=0;
//        for(int i=0;i<id.size();i++){
//            //System.out.print(id.get(i)+" ");
//            long sum = overall_sums.get(i);
//            if(sum<=100000)
//            {
//                //System.out.print(i+" ");
//                System.out.println(sum+" ");
//                res+=sum;
//            }
//        }
//        return res;
//    }
    public static long solve7_1(Scanner sc){
        Node root = new Node(0,null,"/",new ArrayList<>());
        Node current=root;
        Stack<String> currDir = new Stack<>();
        boolean ok=true;
        String line="";
        while(sc.hasNextLine()){
            if(ok)
                line = sc.nextLine();
            ok=true;
            String[] subL = line.split(" ");
            if(subL[1].equals("cd")){
                if(subL[2].equals(".."))
                {
                    currDir.pop();
                    current = current.getParent();
                }
                else if(subL[2].equals("/")){
                    currDir = new Stack<>();
                    currDir.push("/");
                    current=root;
                }
                else {
                    //String cs = currDir.peek();
                    //if(sons.get(id.indexOf(cs)).contains(id.indexOf(subL[2])))
                    for (Node n:
                        current.getChildren()) {
                        if(n.getId().equals(subL[2])){
                            current=n;
                            break;
                        }
                    }
                    currDir.push(subL[2]);
                    //else
                    //System.out.println("happens");
                }
            }
            else{
                line=sc.nextLine();
                ok=false;
                while(!line.startsWith("$")){
                    if(line.startsWith("dir")){
                        String dir = line.split(" ")[1];
                        //if(!id.contains(dir)){
                        Node nuNode = new Node(0,current,dir,new ArrayList<>());
                        current.addAsSon(nuNode);
                    }
                    else{
                        int val = Integer.parseInt(line.split(" ")[0]);
                        current.increment((long)val,current);
                    }
                    if(sc.hasNextLine())
                        line= sc.nextLine();
                    else line = "$";
                }
            }

        }
        long res=0;
        Node start = root;
        LinkedList<Node> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()){
            Node crt = bfs.removeFirst();
            if(crt.getValue()<=100000)
                res+=crt.getValue();
            for (Node nn: crt.getChildren()) {
                bfs.addLast(nn);
            }
        }
        return res;
    }
    public static long solve7_2(Scanner sc){
        Node root = new Node(0,null,"/",new ArrayList<>());
        Node current=root;
        Stack<String> currDir = new Stack<>();
        boolean ok=true;
        String line="";
        while(sc.hasNextLine()){
            if(ok)
                line = sc.nextLine();
            ok=true;
            String[] subL = line.split(" ");
            if(subL[1].equals("cd")){
                if(subL[2].equals(".."))
                {
                    currDir.pop();
                    current = current.getParent();
                }
                else if(subL[2].equals("/")){
                    currDir = new Stack<>();
                    currDir.push("/");
                    current=root;
                }
                else {
                    //String cs = currDir.peek();
                    //if(sons.get(id.indexOf(cs)).contains(id.indexOf(subL[2])))
                    for (Node n:
                        current.getChildren()) {
                        if(n.getId().equals(subL[2])){
                            current=n;
                            break;
                        }
                    }
                    currDir.push(subL[2]);
                    //else
                    //System.out.println("happens");
                }
            }
            else{
                line=sc.nextLine();
                ok=false;
                while(!line.startsWith("$")){
                    if(line.startsWith("dir")){
                        String dir = line.split(" ")[1];
                        //if(!id.contains(dir)){
                        Node nuNode = new Node(0,current,dir,new ArrayList<>());
                        current.addAsSon(nuNode);
                    }
                    else{
                        int val = Integer.parseInt(line.split(" ")[0]);
                        current.increment((long)val,current);
                    }
                    if(sc.hasNextLine())
                        line= sc.nextLine();
                    else line = "$";
                }
            }

        }
        long res=30000001;
        Node start = root;
        long needToRemove = root.getValue()-40000000;
        LinkedList<Node> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()){
            Node crt = bfs.removeFirst();
            if(crt.getValue()>=needToRemove && crt.getValue()<res)
                res=crt.getValue();
            for (Node nn: crt.getChildren()) {
                bfs.addLast(nn);
            }
        }
        return res;
    }
}
