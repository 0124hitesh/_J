class Math{

    // 1. 
    // Greatest Common Divisor
    int euclideanGCD(int firstNum, int secondNum) {
        if(firstNum == 0) {
            return secondNum;
        }
        return euclideanGCD(secondNum % firstNum, firstNum);
    }
    int gcd(int firstNum, int secondNum) {
        return euclideanGCD(firstNum, secondNum);
    }

    // 2.
    // a^b in O(log n) 
    // Binary Exponentiation
    // https://cp-algorithms.com/algebra/binary-exp.html
    // https://leetcode.com/problems/super-pow/description/
    int pow(int a, int b){
        int res = 1;

        while(b > 0){
            // if b is odd
            if((b&1) == 1) res = res*a;

            a *= a;
            b >>= 1;
        }
        return res;
    }

    public static void  main(String...args){

        Math o = new Math();
        System.out.println(o.pow(2,5));
    }
}