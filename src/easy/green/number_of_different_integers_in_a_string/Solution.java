package easy.green.number_of_different_integers_in_a_string;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        char []letter=word.toCharArray();
        Set<String> set=new HashSet<>();
        MyStack mystack=new MyStack(letter.length);
        for(int i=0;i<letter.length;i++){
            if(Character.isDigit(letter[i])){
                
                if(!mystack.isEmpty()  && mystack.getFirst()=='0'){
                    mystack.pop();
                }
                mystack.push(letter[i]);
            }
            if(!Character.isDigit(letter[i]) && !mystack.isEmpty()){
                set.add(mystack.toString());
                mystack.clear();
            }
            
        }
        if(!mystack.isEmpty() && !mystack.toString().equals("")){
            set.add(mystack.toString());
        }

        return set.size();
    }
}
class MyStack{
    int top;
    char []a;
    int size;
    
    public MyStack(int size){
        top=-1;
        this.size=size;
        a=new char[size];
    }
    
    public void clear(){
        a=new char[size];
        top=-1;
    }
    public char getFirst(){
        return a[0];
    }
    
    public boolean isEmpty(){
        return top==-1;
    }
    
    public String toString(){
        return String.valueOf(a).trim();
    }
    
    public char peek(){
        return a[top];
    }
    
    public char pop(){
        return a[top--];
    }
    
    public void push(char c){
        a[++top]=c;
    }
}