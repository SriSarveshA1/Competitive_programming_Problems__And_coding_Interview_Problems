#include <bits/stdc++.h> 
using namespace std; 
 
vector<int>prefix(1000001); 
bool prime[1000001]; 

int main() 
{ 
    memset(prime, true, sizeof(prime)); 
	for(int i=3;i<=1000000;i+=2)
	{
		prime[i]=true;
	}
	for (int p = 3; p<= 1000001; p+=2) { 
		if (prime[p] == true) { 
			for (int i = p * p; i <= 1000001; i += p) 
			{	
				prime[i] = false; 
			}
		} 
	} 
    prime[2]=1;
    prime[1]=0;
    prime[0]=0;
	prefix[0] = 0; 
	prefix[1] = 0; 
	for (int p = 2; p <= 1000001; p++) { 
		prefix[p] = prefix[p - 1]; 
		if (prime[p]) 
			prefix[p]++; 
	}
    
    int n, X, Y, ans;
    cin >> n;
    for(int i = 0; i < n; i++){
        scanf("%d%d", &X, &Y);
        if(prefix[X]>Y){
            printf("Divyam\n");
        }
        else{
            printf("Chef\n");
        }
    }

	return 0; 
} 
