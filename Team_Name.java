import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Team_Name {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int q = 0; q < t; q++)
        {
            int N = in.nextInt();
            int count = 0;
            HashSet<String> hs = new HashSet<>();
            HashMap<String, ArrayList<Character>> hm = new HashMap<String, ArrayList<Character>>();
            HashSet<String> origi = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String value = in.next();
                origi.add(value);
                String body = value.substring(1);
                Character first_c = value.charAt(0);
                if (hm.containsKey(body) == true) {
                    ArrayList<Character> f = hm.get(body);
                    f.add(first_c);
                    hm.put(body, f);
                } 
                else 
                {
                    ArrayList<Character> f = new ArrayList<>();
                    f.add(first_c);
                    hm.put(body, f);
                    
                }

            }
            ArrayList<String> rg=new ArrayList<>();
          
            HashSet<String> ans=new HashSet<>();
            for (String entry : origi)
            {
               
               //System.out.println("origi ="+entry);
                for (Entry<String, ArrayList<Character>> e : hm.entrySet())
                {
                  
                 // System.out.println("e key k= "+e.getKey());
                  String b=entry.charAt(0)+e.getKey();
                  if((origi.contains(b)==false)&&(ans.contains(b)==false))
                  {
                      ans.add(b);
                      rg.add(b);  
                      //System.out.println("ans = "+b);
                  }
                }
                
            } 
            // System.out.println("not_included");
            
             


           // System.out.println("pairs"); 
          
          
           //System.out.println();
           int cc=0;
           for(int i=0;i<rg.size();i++)
           {
               for(int j=i+1;j<rg.size();j++)
               {
                   String k1=rg.get(i).charAt(0)+rg.get(j).substring(1);
                   String k2=rg.get(j).charAt(0)+rg.get(i).substring(1);
                   if(origi.contains(k1)&&origi.contains(k2))
                   {
                       cc+=1;
                   }
               }
           }
           System.out.println(cc*2);
            
            
            
        }
            
        }
    }
