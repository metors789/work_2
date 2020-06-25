package Poke;

import java.util.Scanner;

public class Pokec {
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("请按例子中的格式输入Black的手牌(eg:Black:'2H 3H 5H 9H KH')");
		String str1=sc.nextLine();
		System.out.println("请按例子中的格式输入White的手牌(eg:White:'2C 3H 5C 9S KH')");
		String str2=sc.nextLine();
		System.out.println(Pokec(str1,str2));
	}
	public static String Pokec(String str1,String str2)
	{
		int k=0,m=0,i=0,t,r=0,s=0,f1=0,z,u=0,q=0;
		int[] flag1=new int[]{0,0,0,0,0,0,0,0,0};
		int[] flag2=new int[]{0,0,0,0,0,0,0,0,0};
		int[] num1=new int[]{0,0,0,0,0,0,0,0};
		int[] num2=new int[]{0,0,0,0,0,0,0,0};
		int[] num3=new int[]{0,0,0,0};
		int[] num4=new int[]{0,0,0,0};
		char[] s1=str1.toCharArray();
		char[] s2=str2.toCharArray();
		char[] s3=new char[10];
		char[] s4=new char[10];
		//判定同花
		for(z=0;z<str1.length();z++)
		{
			if(s1[z]=='D'|| s1[z]=='S' || s1[z]=='H' || s1[z]=='C')
			{
				s3[u]=s1[z];
				u++;
			}
			if(s2[z]=='D'|| s2[z]=='S' || s2[z]=='H' || s2[z]=='C')
			{
				s4[q]=s2[z];
				q++;
			}
		}
		if(s3[1]==s3[0] && s3[1]==s3[2] && s3[1]==s3[4] && s3[1]==s3[3])
			flag1[0]=1;
		if(s4[1]==s4[0] && s4[1]==s4[2] && s4[1]==s4[4] && s4[1]==s4[3])
			flag2[0]=1;
		
		//提取数字并排序
		for(i=0;i<str1.length();i++)
		{
			if(s1[i]<='9' && s1[i]>='0') 
			{
				num1[k]=s1[i]-'0';
				k++;
			}
			else if(s1[i]=='T')
			{
				num1[k]=10;
				k++;
			}
			else if(s1[i]=='J')
			{
				num1[k]=11;
				k++;
			}
			else if(s1[i]=='Q')
			{
				num1[k]=12;
				k++;
			}
			else if(s1[i]=='K')
			{
				num1[k]=13;
				k++;
			}
			else if(s1[i]=='A')
			{
				num1[k]=14;
				k++;
			}
		}
		for(i=0;i<k;i++)
		{
			for(m=i+1;m<=k;m++)
			{
				if(num1[i]<num1[m])
				{
					t=num1[i];
					num1[i]=num1[m];
					num1[m]=t;
				}
			}
		}
		k=0;
		
		
		for(i=0;i<str2.length();i++)
		{
			if(s2[i]<='9' && s2[i]>='0') 
			{
				num2[k]=s2[i]-'0';
				k++;
			}
			else if(s2[i]=='T')
			{
				num2[k]=10;
				k++;
			}
			else if(s2[i]=='J')
			{
				num2[k]=11;
				k++;
			}
			else if(s2[i]=='Q')
			{
				num2[k]=12;
				k++;
			}
			else if(s2[i]=='K')
			{
				num2[k]=13;
				k++;
			}
			else if(s2[i]=='A')
			{
				num2[k]=14;
				k++;
			}
		}
		for(i=0;i<k;i++)
		{
			for(m=i+1;m<=k;m++)
			{
				if(num2[i]<num2[m])
				{
					t=num2[i];
					num2[i]=num2[m];
					num2[m]=t;
				}
			}
		}
		num1[5]=num1[0];
		num2[5]=num2[0];
		
		//判定顺子
		for(i=0;i<k;i++)
		{
			if(num1[i]!=(num1[i+1]+1))
				break;
			if(i==k-1)
				flag1[1]=1;
		}
		
		
		for(i=0;i<k;i++)
		{
			if(num2[i]!=(num2[i+1]+1))
				break;
			if(i==k-1)
				flag2[1]=1;
		}
		
		//判定三条
		for(i=0;i<=2;i++)
		{
			if(num1[i]==num1[i+1] && num1[i+2]==num1[i+1])
			{
				flag1[2]=1;
				num1[5]=num1[i];
				num1[i]=0;
				num1[i+1]=0;
				num1[i+2]=0;
			}
		}
		for(i=0;i<=2;i++)
		{
			if(num2[i]==num2[i+1] && num2[i+2]==num2[i+1])
			{
				flag2[2]=1;
				num2[5]=num2[i];
				num2[i]=0;
				num2[i+1]=0;
				num2[i+2]=0;
			}
		}
		
		//判定两个对子
		for(i=0;i<=1;i++)
		{
			if(num1[1]==num1[0] && num1[3]==num2[4])
			{
				flag1[3]=1;
				if(num1[1]>num1[3])
					{
						num1[5]=num1[1];
						num1[6]=num1[3];
						num1[0]=0;
						num1[1]=0;
						num1[4]=0;
						num1[3]=0;
					}
				else
					{
						num1[5]=num1[3];
						num1[6]=num1[1];
						num1[0]=0;
						num1[1]=0;
						num1[4]=0;	
						num1[3]=0;
					}
				break;
			}
			if(num1[i]==num1[i+1] && num1[i+2]==num1[i+3] )
			{
				flag1[3]=1;
				if(num1[i]>num1[i+2])
					{
						num1[5]=num1[i];
						num1[6]=num1[i+2];
						num1[i]=0;
						num1[i+1]=0;
						num1[i+2]=0;
						num1[i+3]=0;
					}
				else
					{
						num1[5]=num1[i+2];
						num1[6]=num1[i];
						num1[i]=0;
						num1[i+1]=0;
						num1[i+2]=0;
						num1[i+3]=0;
					}
			}
		}
		for(i=0;i<=1;i++)
		{
			if(num2[1]==num2[0] && num2[3]==num2[4])
			{
				flag2[3]=1;
				if(num2[1]>num2[3])
					{
						num2[5]=num2[1];
						num2[6]=num2[3];
						num2[0]=0;
						num2[1]=0;
						num2[4]=0;
						num2[3]=0;
					}
				else
					{
						num2[5]=num2[3];
						num2[6]=num2[1];
						num2[0]=0;
						num2[1]=0;
						num2[4]=0;	
						num2[3]=0;
					}
				break;
			}
			if(num2[i]==num2[i+1] && num2[i+2]==num2[i+3] )
			{
				flag2[3]=1;
				if(num2[i]>num2[i+2])
					{
						num2[5]=num2[i];
						num2[6]=num2[i+2];
						num2[i]=0;
						num2[i+1]=0;
						num2[i+2]=0;
						num2[i+3]=0;
					}
				else
					{
						num2[5]=num2[i+2];
						num2[6]=num2[i];
						num2[i]=0;
						num2[i+1]=0;
						num2[i+2]=0;
						num2[i+3]=0;
					}
			}

		}
		//判定一个对子
		for(i=0;i<=3;i++)
		{
			if(num1[i]==num1[i+1] && num1[i]!=0)
			{
				flag1[4]=1;
				num1[5]=num1[i];
				num1[i]=0;
				num1[i+1]=0;
			}
		}
		for(i=0;i<=3;i++)
		{
			if(num2[i]==num2[i+1] && num2[i]!=0)
			{
				flag2[4]=1;
				num2[5]=num2[i];
				num2[i]=0;
				num2[i+1]=0;
			}
		}

		//得出胜负
		for(i=0;i<=4;i++)
		{
			if(flag1[i]>flag2[i])
				return("Black wins");
			
			else if(flag1[i]<flag2[i])		
				return("White wins");

			if(i==4 && flag1[0]==1 && flag2[0]==1 && flag1[1]!=1)
			{
				for(int n=0;n<5;n++)
				{
					if(num1[n]>num2[n])
					{
						f1=1;
						break;
					}
					if(num1[n]<num2[n])
					{
						f1=-1;
						break;
					}
				}
				if(f1==1)
					return("Black wins");
		
				else if(f1==-1)
					return("White wins");
					
				else
					return("Tie");
			}	
			if(i==4 && flag1[0]==1 && flag2[0]==1 && flag1[1]==1)
			{
				if(num1[0]>num2[0])
					return("Black wins");
				else if(num1[0]<num2[0])
					return("White wins");
				else
					return("Tie");
			}
			
			if(i==4 && flag1[2]==1 && flag2[2]==1)
			{
				if(num1[5]>num2[5])
					return("Black wins");
								
				else
					return("White wins");
			}
			if(i==4 && flag1[1]==1 && flag2[1]==1 && flag1[0]!=1)
			{
				if(num1[0]>num2[0])				
					return("Black wins");									
				else if(num1[0]<num2[0])
				
					return("White wins");

				else
					return("Tie");
					
			}
			if(i==4 && flag1[3]==1 && flag2[3]==1)
			{
				if(num1[5]>num2[5])
					return("Black wins");
				else if(num1[5]<num2[5])
					return("White wins");
				else
				{
					if(num1[6]>num2[6])
						return("Black wins");
					else if(num1[6]<num2[6])
						return("White wins");
					else
					{
						for(int n=0;n<=4;n++)
						{
							if(num1[n]!=0)
							num1[7]=num1[n];
							if(num2[n]!=0)
							num2[7]=num2[n];
						}
						if(num1[7]>num2[7])
							return("Black wins");
						else if(num1[7]<num2[7])
							return("White wins");
						else
							return("Tie");

					}
				}
			}
			
			if(i==4 && flag1[4]==1 && flag2[4]==1)
			{
				System.out.println(num2[5]);
				if(num1[5]>num2[5])
				
					return("Black wins");
				else if(num1[5]<num2[5])
					return("White wins");
				else
				{
					for(int n=0;n<=4;n++)
					{
						if(num1[n]!=0)
						{
							num3[r]=num1[n];
							r++;
						}
						if(num2[n]!=0)
						{
							num4[s]=num1[n];
							s++;
						}
					}
					for(int n=0;n<4;n++)
					{
						if(num3[n]>num4[n])
						{
							f1=1;
							break;
						}
						if(num3[n]<num4[n])
						{
							f1=-1;
							break;
						}
					}
					if(f1==1)
						return("Black wins");

					else if(f1==-1)
						return("White wins");
					else
						return("Tie");
				}
			}
			for(int n=0;n<5;n++)
			{
				if(num1[n]>num2[n])
				{
					f1=1;
					break;
				}
				if(num1[n]<num2[n])
				{
					f1=-1;
					break;
				}
			}
			if(i==4)
			{
				if(f1==1)
					return("Black wins");
				
				else if(f1==-1)
					return("White wins");

				else
					return("Tie");	
			}
		
	}
		return("判定失败");
	}
}

