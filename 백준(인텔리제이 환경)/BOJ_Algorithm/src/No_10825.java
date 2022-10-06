import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_10825 {
    public static void main(String[] args) throws IOException {
        //1. 국어 점수가 감소하는 순서로
        //2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
        //3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
        //4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로(대문자는 소문자 보다 앞에)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        //점수 순서 국 영 수
        List<Student> gradeList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int kor = Integer.valueOf(input[1]);
            int eng = Integer.valueOf(input[2]);
            int math = Integer.valueOf(input[3]);
            gradeList.add(new Student(name, kor, eng, math));
        }

        Collections.sort(gradeList,(l1,l2)->{
                    if (l1.kor == l2.kor) {
                        if (l1.eng == l2.eng) {
                            if (l1.math == l2.math) {
                                return l1.name.compareTo(l2.name); //String 정렬
                            }
                            return l2.math - l1.math; //수학은 감소하는 순서
                        }
                        return l1.eng - l2.eng; //영어는 증가하는 순서
                    }
                    return l2.kor - l1.kor;//국어는 감소하는 순서
                }
                );
        for (Student student : gradeList) {
            sb.append(student + "\n");
        }
        System.out.println(sb);



    }
}
class Student{
    String name;
    int kor,eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public String toString() {
        return name;
    }
}