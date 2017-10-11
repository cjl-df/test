package com.bookm;

public class GeneratePrimes{
    private static boolean[] f;
    private static int[] primes;

    /**
     * @param maxValue is the generation limit
     */
    public static int[] generatePrimes(int maxValue){
         if(maxValue<2)
             return new int[0];
         else{
             initializeArraryOfIntegers(maxValue);
             siave();
             loadPrimes();
             return primes;
         }
    }

    public static void loadPrimes(){
        int i;
        int j;
        //首先要计算出结果多少个
        int count=0;
        for(i=0;i<f.length;i++){
            if(f[i])
                count++;
        }
        primes = new int[count];
        for(i=0,j=0;i<f.length;i++)
            if(f[i])
                primes[j++]=i;
    }

    public static void siave(){
        int i;
        int j;
        for(i=2;i<Math.sqrt(f.length);i++){
            if(f[i])     //如果不是素数，
                for(j=2*i;j<f.length;j+=i){    //用来去掉所有的非素数
                    f[j]=false;
                }
        }
    }

    public static void initializeArraryOfIntegers(int maxValue){
        /**
         * 为什么是maxValue+1,是因为加入maxValue是25,那么f最大的下标就是25
         */
        f = new boolean[maxValue+1];
        f[0]=f[1]=false;
        for(int i =0;i<f.length;i++)
            f[i]=true;
    }

    public static void main(String[] args) {
        generatePrimes(100);
        for (int i:GeneratePrimes.primes) {
            System.out.println(i);
        }
    }
}
