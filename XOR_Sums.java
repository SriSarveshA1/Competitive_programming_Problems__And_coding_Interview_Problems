public class XOR_Sums
{
    int MaxN=1<<19,M=998244353;

    int mod=998244353;
    
    int[] ws=new int[MaxN];
    
    int[] inverse_factorial=new int[500005];
    
    int[] book_keeping=new int[500005];
    
    int[] factorial=new int[500005];
    
    int[] gpa=new int[1<<19];
    int[] gpb=new int[1<<19];

    int v1=mod-2;
    int v2=mod;
    long binpow(Long  a,Long b,Long m) {
        
        b=b==null?v1:b;
        m=m==null?v2:m;
        a %= m;
    
        long res = 1;
    
        while (b > 0) {
            if ((b & 1)==1)
            {
                res = res * a % m;
            }
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
    int v3=0;
    void fourier(Integer[] a,Integer n,Integer f){
        f=f==null?v3:f;
        int i,j,k,m,u,v,w,wm;
    
        for(i=n>>1,j=1;j<n-1;j++){
    
            if(i>j)
            {  
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
               //swap(a[i],a[j]); 
            }
    
            for(k=n>>1;k<=i;k>>=1)i^=k;i^=k;
    
        }
    
        for(m=2;m<=n;m<<=1)
    
            for(i=0,wm=binpow((long)3,f==1?(long)(M-1)/m:(long)(M-1)/m*(m-1),(long)M);i<n;i+=m)
    
                for(j=i,w=1;j<i+(m>>1);j++){
    
                    u=a[j],v=1ll*w*a[j+(m>>1)]%M;
    
                    if((a[j]=u+v)>=M)a[j]-=M;
    
                    if((a[j+(m>>1)]=u-v)<0)a[j+(m>>1)]+=M;
    
                    w=1ll*w*wm%M;
    
                }
    
        if(f==1)for(w=binpow(n,M-2,M),i=0;i<n;i++)a[i]=1ll*a[i]*w%M;
    
    }
    public static void main(String[] args)
    {

    }
}