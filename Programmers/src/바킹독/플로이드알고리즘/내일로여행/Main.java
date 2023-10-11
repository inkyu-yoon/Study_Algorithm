package 바킹독.플로이드알고리즘.내일로여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int numOfCities = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        final int MAX = 10000100;

        // 도시 중복 제거
        String[] places = getPlaces(br.readLine().split(" "));

        // 도시 별 번호 부여
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < places.length; i++) {
            map.put(places[i], i);
        }

        // 중복을 제거한 도시의 수
        int N = map.size();

        int M = Integer.parseInt(br.readLine());
        // 여행할 도시 순서
        String[] trip = br.readLine().split(" ");


        int K = Integer.parseInt(br.readLine());
        // 내일로 할인이 적용 안되는 비용
        double[][] costs = new double[N][N];
        // 내일로 할인이 적용되는 비용
        double[][] costsWithTicket = new double[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r != c) {
                    costs[r][c] = MAX;
                    costsWithTicket[r][c] = MAX;
                }
            }
        }

        // 도시에서 도시로 이동하는 비용 입력
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            String type = input[0];
            String start = input[1];
            String end = input[2];
            double cost = Double.parseDouble(input[3]);

            // 교통 수단에 따른 할인가 계산
            double costWithTicket = calculatePrice(type, cost);

            int u = map.get(start);
            int v = map.get(end);
            costs[u][v] = Math.min(costs[u][v], cost);
            costs[v][u] = Math.min(costs[v][u], cost);
            costsWithTicket[u][v] = Math.min(costsWithTicket[u][v], costWithTicket);
            costsWithTicket[v][u] = Math.min(costsWithTicket[v][u], costWithTicket);
        }

        // 플로이드 알고리즘 사용
        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    costs[u][v] = Math.min(costs[u][v], costs[u][m] + costs[m][v]);
                    costsWithTicket[u][v] = Math.min(costsWithTicket[u][v], costsWithTicket[u][m] + costsWithTicket[m][v]);
                }
            }
        }

        // 도시에서 도시로 가는 최소비용이 플로이드를 통해 계산 되었으므로 총 합을 구한다.
        double sum = 0;
        double sumWithTicket = 0;

        for (int i = 0; i < M - 1; i++) {
            int u = map.get(trip[i]);
            int v = map.get(trip[i + 1]);
            sum += costs[u][v];
            sumWithTicket += costsWithTicket[u][v];
        }

        System.out.println(sum <= sumWithTicket + R ? "No" : "Yes");
    }

    private static String[] getPlaces(String[] arr) {
        Set<String> set = new HashSet<>();

        for (String city : arr) {
            set.add(city);
        }

        return set.stream().toArray(String[]::new);
    }

    private static double calculatePrice(String type, double cost) {
        Set<String> free = new HashSet<>(List.of("Mugunghwa", "ITX-Saemaeul", "ITX-Cheongchun"));
        Set<String> discount = new HashSet<>(List.of("S-Train", "V-Train"));
        if (free.contains(type)) {
            return 0;
        } else if (discount.contains(type)) {
            return 0.5 * cost;
        } else {
            return cost;
        }
    }
}
