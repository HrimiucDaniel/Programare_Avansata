public class Homework1 {
    public static boolean vecini(StringBuilder s1, StringBuilder s2) {
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) return true;
            }
        }
        return  false;
    }
    public static void main(String args[]){
     int n = 0, p = 0, m;
     char c[];
     StringBuilder words[];

     if (args.length < 3) {
         System.out.println("Usage: number, number, one or more characters(alfabet)");
         System.exit(-1);
     }

     try {
         n = Integer.parseInt(args[0]);
     }catch(NumberFormatException e){
         System.out.println("NUMBER PLEASE!!");
         System.exit(-1);
     }

     try {
            p = Integer.parseInt(args[1]);
     }catch(NumberFormatException e){
            System.out.println("NUMBER PLEASE!!");
            System.exit(-1);
     }

     m = args.length - 2;
     c = new char[m];
     for (int i = 0; i < m; i++){
         c[i] = args[i+2].charAt(0);
     }
     words = new StringBuilder[n];

     for (int i = 0; i < n; i++) {
         words[i] = new StringBuilder("");
         for (int j = 0; j < p; j++) {
             int q = i + j;
             while (q >= m) q -= m;
            words[i].append(c[q]);
         }
     }
     //stringurile vor fi create automat incepand cu pozitia i de lungime p

     for (int i = 0; i < n; i++) {
         System.out.println(words[i]);
     }
     boolean matrix[][];
     matrix = new boolean[n][n];

     for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
             matrix[i][j] = vecini(words[i],words[j]);
         }
     }

     StringBuilder matrice[][];
     matrice = new StringBuilder[n+1][n+1];

     for (int i = 0; i < n; i++) {
         matrice[i][0] = new StringBuilder(words[i] + ":");
     }//pe prima pozitia vom aveam stringul original iar pe urmatoarele vom avea vecinii

     for (int  i = 0; i < n; i++) {
         int j = 0;
         int k = 1;
         while (j < n) {
             if ( matrix[i][j] == true) {
                 matrice[i][k] = new StringBuilder(words[j]);
                 k++;
             }
             j++;
         }
     }

     for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
             if (matrice[i][j] != null) {
                 System.out.print(matrice[i][j] + " ");
             }else{
                 break;
             }
         }
         System.out.println();
     }
    }


}
