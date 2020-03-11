import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        boolean flag=false;
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=new char[s.length()+1];
        //int i=0;
        if(s.length()==0){
            System.out.println("YES");
        }else{
            //for(i=0;i<s.length()/2;i++){
              //  ch[i]=s.charAt(i);//数组只赋值了一半，最后i是下一个空位
            //}
            for(int j=0;j<=s.length();j++){//j也可以是最后一个元素的后面，j是放空位的
                if(bool(ch,s,j)){//有一个地方能添加就行
                    flag=true;
                    System.out.println("YES");
                    break;
                }
            }
            if(!flag){
                System.out.println("NO");
            }
        }

    }
    public  static boolean  bool(char[] ch,String s,int j){//i是数组第一个不为空的,j是想放空格的地方
        boolean flag=false;
        if(j==s.length()){
            int p=0;
            for(p=0;p<s.length();p++){
                ch[p]=s.charAt(p);
            }
            ch[ch.length-1]=' ';
        }else{
            for(int p=0;p<s.length();p++){
                if(j==p){
                    ch[p]=' ';
                    flag=true;
                }
                if(!flag){
                    //空格还没有填加进去
                    ch[p]=s.charAt(p);
                }else{
                    ch[p+1]=s.charAt(p);
                }
            }
        }
        System.out.println(Arrays.toString(ch));
        int left=0;
        int right=ch.length-1;
        while(left<right){
            if(ch[left]==' '||ch[right]==' '){
                left++;
                right--;
            }else{
                if(ch[left]!=ch[right]){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
