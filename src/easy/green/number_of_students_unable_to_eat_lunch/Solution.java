package easy.green.number_of_students_unable_to_eat_lunch;

import java.util.LinkedList;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> linkedList= new LinkedList<>();
        for(int i=0;i<students.length;i++){
            linkedList.add(students[i]);
        }
        int z=0;
        int temp=0;
        for(int i=0;i<linkedList.size();i++){
            int j=linkedList.getFirst();
            if(sandwiches[z] != j){
                linkedList.removeFirst();
                linkedList.addLast(j);
                i=-1;
                temp++;
                if(temp == linkedList.size()){
                    return temp;
                }
            }else{
                temp=0;
                z++;
                linkedList.removeFirst();
                i=-1;
            }
        }
        return linkedList.size();
    }
}
