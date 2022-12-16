import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.Iterator;

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

    public static boolean isPrimeFirstB(int m){
        double sum=0;
        if (m<=0)
            return false;
        if(m==1)
            return false;
        if(m==2)
            return true;
        for(int i=2 ; i<m ; i++){
            sum++;
            sum*=2;
            if( m%i == 0 ){
                return false;
            }
        }
        return true;
    }
    public static int firstAlgoB(int n){
        int total= 0;
        int[] ar = new int[100];
        for (int i=0 ; i<100 ; i++){
            ar[i]=5000;
        }
        for(int i=1 ; i<=n ; i++){
            if(isPrimeFirstA(i)){
                total++;
            }
        }
        return total;
    }

    public static double isPrimeSecondB(int m){
        if (m<=0)
            return -100;
        if(m==1)
            return -100;
        if(m==2)
            return 100;
        int s = (int) Math.sqrt(m);
        for(int i=2 ; i<=s ; i++){
            if( m%i == 0 ){
                return -100;
            }
        }
        return 100;
    }

    public static int secondAlgoB(int n){
        int total= 0;
        for(int i=1 ; i<=n ; i++){
            int check = (int) isPrimeSecondB(i);
            if(check>0){
                total++;
            }
        }
        return total;
    }


    public static int thirdAlgoB(int n){
        double[] numbersList = new double[n];
        for (int i=0 ; i<n ; i++){
            numbersList[i]=-100;
        }
        numbersList[0]=100;
        for (int i=2 ; i<n ; i++){
            for (int j=2*i ; j<=n ; j+=i){
                numbersList[j-1]=100;
            }
        }
        int total=0;
        for (int i=0 ; i<n ; i++){
            int check = (int) numbersList[i];
            if(check<0)
                total++;
        }
        return total;
    }


    public static int fourthAlgoB(int n){
        int[] numbersList = new int[n];
        for (int i=0 ; i<n ; i++){
            numbersList[i] = 0;
        }
        numbersList[0]=100;
        for (int i=2 ; i<n ; i++){
            if(numbersList[i-1] == 100)
                continue;
            for (int j = 2 * i; j <= n; j += i) {
                numbersList[j - 1] = 100;
            }
        }
        int total=0;
        for (int counter=0 ; counter<n ; counter++){
            if(numbersList[counter]==0)
                total++;
        }
        return total;
    }


    public static void main(String[] args) throws IOException {
       double temp=0;
        int n=0;

        String path = "C:\\Users\\admin\\IdeaProjects\\Count-Primes\\data.xlsx";
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = xssfWorkbook.getSheet("sheet2");

        Iterator<Row> rowIterator = sheet.rowIterator();
        int counter = 0;
        boolean flag = true;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if(flag){
                flag = false;
                continue;
            }
            String m = String.valueOf(row.getCell(0));
            temp = Double.valueOf(m);
            n = (int) temp;

            long startTime = System.nanoTime();
            int numberOfPrimes = firstAlgoA(n);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            Cell cell1=row.createCell(1);
            cell1.setCellValue(duration);
            System.out.println("Algo1-a:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);

            startTime = System.nanoTime();
            numberOfPrimes = firstAlgoB(n);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            Cell cell5=row.createCell(2);
            cell5.setCellValue(duration);
            System.out.println("Algo1-b:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);

            startTime = System.nanoTime();
            numberOfPrimes = secondAlgoA(n);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            Cell cell2=row.createCell(3);
            cell2.setCellValue(duration);
            System.out.println("Algo2-a:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);


            startTime = System.nanoTime();
            numberOfPrimes = secondAlgoB(n);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            Cell cell6=row.createCell(4);
            cell6.setCellValue(duration);
            System.out.println("Algo2-b:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);

            startTime = System.nanoTime();
            numberOfPrimes = thirdAlgoA(n);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            Cell cell3=row.createCell(5);
            cell3.setCellValue(duration);
            System.out.println("Algo3-a:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);

            startTime = System.nanoTime();
            numberOfPrimes = thirdAlgoB(n);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            Cell cell7=row.createCell(6);
            cell7.setCellValue(duration);
            System.out.println("Algo3-b:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);

            startTime = System.nanoTime();
            numberOfPrimes = fourthAlgoA(n);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            Cell cell4=row.createCell(7);
            cell4.setCellValue(duration);
            System.out.println("Algo4-a:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);

            startTime = System.nanoTime();
            numberOfPrimes = fourthAlgoB(n);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            Cell cell8=row.createCell(8);
            cell8.setCellValue(duration);
            System.out.println("Algo4-b:   "+n+"  numOfPrime:  "+numberOfPrimes+"  time:  "+duration);

        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        xssfWorkbook.write(outputStream);
        outputStream.close();
    }
}
