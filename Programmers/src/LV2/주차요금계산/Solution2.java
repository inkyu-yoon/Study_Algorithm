package LV2.주차요금계산;

import java.util.*;

// 출차 내역이 없다면 23:59에 출차한 것으로 간주
// 누적 주차 시간이 [기본 시간] 이하인 경우 기본 요금 청구
// 초과한 경우 기본요금 + 초과한 시간*단위시간 (올림 처리)
// [기본 시간(분) 기본 요금(원) 단위 시간(분) 단위 요금(원)]
class Solution2 {
    Map<Integer, Integer> map = new HashMap<>();
    List<Car> cars = new ArrayList<>();

    public int[] solution(int[] fees, String[] records) {
        getTimeEachCar(records);
        getFeeEachCar(fees);
        Collections.sort(cars, (a, b) -> a.num - b.num);

        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            answer[i] = cars.get(i).fee;
        }

        return answer;
    }

    private void getTimeEachCar(String[] records) {
        Map<Integer, Integer> history = new HashMap<>();
        for (String record : records) {
            String[] info = record.split(" ");
            String time = info[0];
            int min = convertToMinutes(time);
            int car = Integer.parseInt(info[1]);

            if (history.containsKey(car)) {
                int parkingTime = min - history.get(car);
                map.put(car, map.getOrDefault(car, 0) + parkingTime);
                history.remove(car);
            } else {
                history.put(car, min);
            }
        }

        for (int car : history.keySet()) {
            int parkingTime = 23 * 60 + 59 - history.get(car);
            map.put(car, map.getOrDefault(car, 0) + parkingTime);
        }
    }

    private int convertToMinutes(String time) {
        String[] info = time.split(":");
        return Integer.parseInt(info[0]) * 60 + Integer.parseInt(info[1]);
    }

    // [기본 시간(분) 기본 요금(원) 단위 시간(분) 단위 요금(원)]
    private void getFeeEachCar(int[] fees) {
        for (int carNum : map.keySet()) {
            int totalTime = map.get(carNum);
            if (totalTime <= fees[0]) {
                cars.add(new Car(carNum, fees[1]));
            } else {
                int fee = fees[1] + (int) Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
                cars.add(new Car(carNum, fee));
            }
        }
    }

    static class Car {
        int num;
        int fee;

        public Car(int num, int fee) {
            this.num = num;
            this.fee = fee;
        }
    }
}