package day06;

public class MethodQuiz2 {

    static double[] calcArrayTotal(int... nums){
        int total=0;
        for (int n:nums){
            total += n;
        }
        double avg = total/(double)nums.length;
        return new double[]{total, avg};
    }
    public static void main(String[] args) {

        int [] numbers = {57, 89, 78, 91, 93, 47};
        double[] arrToAvg = calcArrayTotal(numbers);
        System.out.printf("총점: %d점, 평균: %.f점\n",(int)arrToAvg[0],arrToAvg[1]);
    }
}
