package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/4/3 21:44
 * @version: v1.0.0
 */
import java.util.Scanner;

public class Main13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        char[][] now = new char[n][m];
        String s = in.nextLine();
        for(int i = 0; i < n; i++) {
            s = in.nextLine();
//			System.out.println("s:"+s);
            now[i] = s.toCharArray();
//			System.out.println("now:"+new String(now[i]));
        }
        for(int k = 0; k < q; k++) {
            String word = in.nextLine();
            if(exist(now, word)) {
                System.out.println("Has");
            }else {
                System.out.println("Not Has ");
            }
        }


    }

    public static boolean exist(char[][] now, String word) {
        for(int i=0; i<now.length; i++){
            for(int j=0; j<now[0].length; j++){
                if(dfs(now, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean dfs(char[][] now, String word, int index, int x, int y){
        if(index == word.length()-1 && word.charAt(index)==now[x][y]){
            return true;
        }

        if(word.charAt(index) != now[x][y]){
            return false;
        }

        char tmp = now[x][y];
        now[x][y] = '.';
        boolean b1 = false, b2 = false, b3 = false, b4 = false;
        if(x-1>=0 && now[x-1][y] != '.'){
            b1 = dfs(now, word, index+1, x-1, y);
        }
        if(!b1 && y-1>=0 && now[x][y-1] != '.'){
            b2 = dfs(now, word, index+1, x, y-1);
        }
        if(!b1 && !b2 && x+1<now.length && now[x+1][y] != '.'){
            b3 = dfs(now, word, index+1, x+1, y);
        }
        if(!b1 && !b2 && !b3 && y+1<now[0].length && now[x][y+1] != '.'){
            b4 = dfs(now, word, index+1, x, y+1);
        }

        now[x][y] = tmp;
        return b1 || b2 || b3 || b4;
    }

}

