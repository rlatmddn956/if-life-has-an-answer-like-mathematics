import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;

public class Model5 {
    public static void select(int n, int r){
        //함수 select 정의
        ArrayList<Favor> population = new ArrayList();  // 사람의 호감도 리스트
        for(int i=0;i<n;i++){
            double favorable =(double)(Math.random()); //0 ~ 1
            population.add(new Favor(favorable));
        }

        int candidate =

    }
}
