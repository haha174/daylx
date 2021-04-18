package easy.green.average_salary_excluding_the_minimum_and_maximum_salary;

class Solution {
    public double average(int[] salary) {
        double result = 0;
        double sum = 0;
        double max = salary[0], min = salary[0];
        for (int i = 0; i < salary.length; ++i) {
            sum += salary[i];
        }
        for (int i = 0; i < salary.length; ++i) {
            if (max < salary[i]) {
                max = salary[i];
            }
            if (min > salary[i]) {
                min = salary[i];
            }
        }
        result = (sum - (max + min)) / (salary.length - 2);
        return result;
    }

}