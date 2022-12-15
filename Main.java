import java.util.Scanner;

public class Main {
    public static boolean isPrimeFirstA(int m){
        if (m<=0)
            return false;
        if(m==1)
            return false;
        if(m==2)
            return true;
        for(int i=2 ; i<m ; i++){
            if( m%i == 0 ){
                return false;
            }
        }
        return true;
    }
    public static int firstAlgoA(int n){
        int total= 0;
        for(int i=1 ; i<=n ; i++){
            if(isPrimeFirstA(i)){
                total++;
            }
        }
        return total;
    }
    public static boolean isPrimeSecondA(int m){
        if (m<=0)
            return false;
        if(m==1)
            return false;
        if(m==2)
            return true;
        int s = (int) Math.sqrt(m);
        for(int i=2 ; i<=s ; i++){
            if( m%i == 0 ){
                return false;
            }
        }
        return true;
    }

    public static int secondAlgoA(int n){
        int total= 0;
        for(int i=1 ; i<=n ; i++){
            if(isPrimeSecondA(i)){
                total++;
            }
        }
        return total;
    }

    public static int thirdAlgoA(int n){
        boolean[] numbersList = new boolean[n];
        numbersList[0]=true;
        for (int i=2 ; i<n ; i++){
            for (int j=2*i ; j<=n ; j+=i){
                numbersList[j-1]=true;
            }
        }
        int total=0;
        for (int i=0 ; i<n ; i++){
            if(!numbersList[i])
                total++;
        }
        return total;
    }

    public static int fourthAlgoA(int n){
        boolean[] numbersList = new boolean[n];
        numbersList[0]=true;
        for (int i=2 ; i<n ; i++){
            if(numbersList[i-1])
                continue;
            for (int j = 2 * i; j <= n; j += i) {
                numbersList[j - 1] = true;
            }
        }
        int total=0;
        for (int counter=0 ; counter<n ; counter++){
            if(!numbersList[counter])
                total++;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long startTime1 = System.nanoTime();
        System.out.println(firstAlgoA(n));
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println(duration1);

        long startTime2 = System.nanoTime();
        System.out.println(secondAlgoA(n));
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println(duration2);

        long startTime3 = System.nanoTime();
        System.out.println(thirdAlgoA(n));
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3);
        System.out.println(duration3);

        long startTime4 = System.nanoTime();
        System.out.println(fourthAlgoA(n));
        long endTime4 = System.nanoTime();
        long duration4 = (endTime4 - startTime4);
        System.out.println(duration4);
    }
}
