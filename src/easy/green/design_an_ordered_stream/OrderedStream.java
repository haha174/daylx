package easy.green.design_an_ordered_stream;

import java.util.ArrayList;
import java.util.*;
class OrderedStream {
    String[] a;
    int i=0;

    public OrderedStream(int n) {
        a=new String[n];
        for(int i=0;i<n;i++){
            a[i] = "i";
        }
    }

    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList<>();
        if(i != idKey-1){
            a[idKey-1] = value;
            return new ArrayList<String>();
        }else{
            a[idKey-1]=value;
            for(int j=idKey-1;j<a.length;j++){
                if(a[j].equals("i")){
                    i=j;
                    break;
                }
                list.add(a[j]);
            }
            return list;
        }
    }
}