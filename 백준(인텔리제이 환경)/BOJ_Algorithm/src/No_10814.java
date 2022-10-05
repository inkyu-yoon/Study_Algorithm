import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_10814 {
    public static void main(String[] args) throws IOException {
        //회원들의 나이가 증가하는 순으로
        // 나이가 같다면 먼저 가입한 사람이 앞에 오는 순으로

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        List<Member> memberList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            memberList.add(new Member(Integer.valueOf(input[0]), input[1],i));
        }

//        for (Member member : memberList) {
//            System.out.println("member = " + member);
//        }
        Collections.sort(memberList);

        for (Member member : memberList) {
            System.out.println(member);
        }


    }
}

class Member implements Comparable<Member> {

    private int age,memberId;
    private String name;


    Member(int age, String name,int memberId) {
        this.age = age;
        this.name = name;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    @Override
    public int compareTo(Member m1) {
        if (this.age == m1.age) {
            return this.memberId - m1.memberId;
        }else if(this.age!= m1.age){
            return this.age - m1.age;
        }
        return -1;
    }

}