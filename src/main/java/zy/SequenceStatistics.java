package zy;

import java.util.Scanner;

public class SequenceStatistics {

    static int mod=1000003;

    static long[] fac = new long[mod];
    static long[] inv = new long[mod];


    public static void main(String[] args) {
        int t;
        int n,l,r;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        pretreatment();
        while(t-->0){
            n = sc.nextInt();
            l = sc.nextInt();
            r = sc.nextInt();
            int m=r-l+1;
            System.out.println((C(n+m, m)-1+mod)%mod);
        }
    }

    static void pretreatment(){
        int i;
        for(fac[0]=1,i=1;i<mod;i++)
            fac[i]=fac[i-1]*i%mod;
        for(inv[1]=1,i=2;i<mod;i++)
            inv[i]=(mod-mod/i)*inv[mod%i]%mod;
        for(inv[0]=1,i=1;i<mod;i++) {
            inv[i] = (inv[i - 1] * inv[i])%mod;
        }
    }

    static long C(int n,int m){
        if(n<m) return 0;
        if(n<mod && m<mod)
            return fac[n] * inv[m] % mod * inv[n-m] % mod ;
        return C(n/mod,m/mod) * C(n%mod,m%mod) % mod ;
    }
}
