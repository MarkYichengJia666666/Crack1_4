/**
 * Created by jiayicheng on 17/6/15.
 */
public class Palindrome_check {
    public static void main(String[] args)
    {
        //目的：输入一个字符串，检查该字符串能否通过置换形成一个回文序列
        //注意：输入的是字符串，可能有空格等各种符号,但是他不在回文序列考虑范围内，回文只看字母
       String str="abCBca";
        System.out.print(palindrome(str));
        System.out.print(isPermutationOfPalindrome(str));
        return;
    }

    static boolean palindrome(String str)
    { char[] content=str.toCharArray();
       int i=0;
        int[] odd = new int[128];
        int palin=0;
      for(i=0;i<content.length;i++)    //记下每一个字母的出现个数，再看出现奇数个数的个数
      {
          if(str.charAt(i)<91&&str.charAt(i)>64) {
              odd[str.charAt(i)]++;
              if(odd[str.charAt(i)]%2==1)
                  palin++;
              else
                  palin--;
          }
          if(str.charAt(i)-32<91&&str.charAt(i)-32>64) {
              odd[str.charAt(i) - 32]++;
              if(odd[str.charAt(i)-32]%2==1)
                  palin++;
              else
                  palin--;
          }
      }
//      for(i=0;i<odd.length;i++)
//      {
//          if(odd[i]%2==1)
//             palin++;
//      }
      if(palin>1)
          return false;
        else
            return true;
    }


    static boolean isPermutationOfPalindrome(String phrase)
    {
        int bitVector=createBitVector(phrase);
        return bitVector==0||checkExactlyOneBitSet(bitVector);
    }
    static int createBitVector(String phrase)
    {
        int bitVector=0;
        for(char c: phrase.toCharArray()){
            int x=getCharNumber(c);
            bitVector=toggle(bitVector,x);
        }
        return bitVector;

    }

   static int toggle(int bitVector, int index)
    {
        if(index<0) return bitVector;
        int mask=1<<index;
        if((bitVector&mask)==0){
            bitVector|=mask;
        }
        else
        {
            bitVector&=~mask;
        }
        return bitVector;
    }
   static boolean checkExactlyOneBitSet(int bitVector)
    {
        return (bitVector&(bitVector-1))==0;
    }
    static int getCharNumber(Character c)
    {
        int a=Character.getNumericValue('a');
        int z=Character.getNumericValue('z');
        int val=Character.getNumericValue(c);
        if(a<=val&&val<=z)
          {System.out.print(val-a+" ");
              return val-a;}
        return -1;

    }}
