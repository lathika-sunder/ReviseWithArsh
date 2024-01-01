class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long lcm=lcm(divisor1,divisor2);

        int start=uniqueCnt1+uniqueCnt2;
        int end=Integer.MAX_VALUE;

        while(start<end)
        {
            int mid=start+(end-start)/2;

            boolean c1=(mid-mid/divisor1)>=uniqueCnt1;
            boolean c2 =(mid-mid/divisor2)>=uniqueCnt2;
            boolean c3=(mid-mid/lcm)>=uniqueCnt1+uniqueCnt2;

            if(c1 && c2 && c3)
            {
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
    private long lcm(int a, int b)
    {
        //LCM x GCD= a x b
        return a/gcd(a,b)*b;
    }
    private long gcd(int a,int b)
    {
        if(a==0)
        return b;

        return gcd(b%a,a);
    }
}