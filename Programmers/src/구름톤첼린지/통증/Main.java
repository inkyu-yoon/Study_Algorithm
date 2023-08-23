package 구름톤첼린지.통증;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    int N;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        int medicine = N / 7;
        int bandage = N % 7;

        int painkiller = medicine / 2;
        medicine = medicine % 2;

        System.out.println(medicine + bandage + painkiller);

    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}
