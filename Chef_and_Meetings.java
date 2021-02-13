import java.util.ArrayList;
import java.util.Scanner;

public class Chef_and_Meetings
{  
    static int rv(String  val)
    { 
        String s="";
        for(int i=0;i<val.length();i++)
        {
            s+=val.charAt(i);
        }
      int h=Integer.parseInt(s.substring(0, 2));
      int m=Integer.parseInt(s.substring(3, 5));
      String t=s.substring(6, 8);
      int vr;
      if(t=="AM")
      {
          if(h==12)
          {
              vr=0;
          }
          else{
              vr=h*100;
          }
          vr+=m;
      }
      else{
          if(h==12)
          {
              vr=1200;
          }
          else{
              vr=(h+12)*100;
          }
          vr+=m;
      }
      return vr;
    }
    static boolean func(String Li,String P,String Ri)
    {
      if(((rv(Li)<=rv(P))&&(rv(P)<=rv(Ri))))
      {
          return true;
      }
      return false;
    }
    public static void main(String[] args)
    {
      
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int er=0;er<T;er++)
        {
            String P="";
            char c;
            for(int i=0;i<7;i++)
            {
                c=in.next().charAt(0);
                P+=c;
            }
            //String P2=in.next();    
            int N=in.nextInt();
            ArrayList<String[]> ran=new ArrayList<>();
            for(int i=0;i<N;i++)
            {
               String Li=new String();
                for(int yy=0;yy<7;yy++)
                {
                    c=in.next().charAt(0);
                    Li+=c;
                }

                String Ri=new String();
                for(int yy=0;yy<7;yy++)
                {
                    c=in.next().charAt(0);
                    Ri+=c;
                }

                String[] kk=new String[2]; 
                kk[0]=Li;
                kk[1]=Ri;
                ran.add(kk);
            }
            String ans="";
            for(int i=0;i<N;i++)
            {
                if(func(ran.get(i)[0], P,ran.get(i)[1])==true)
                {
                    ans+="1";
                }
                ans+="0";
            }
            System.out.println(ans);

        }
    }
}