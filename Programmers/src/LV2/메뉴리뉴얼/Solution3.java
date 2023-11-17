package LV2.메뉴리뉴얼;

import java.util.*;

class Solution3 {
    Map<String, Integer> combinations = new HashMap<>();
    Map<Integer, Integer> maxCountByCourse = new HashMap<>();
    Stack<String> s = new Stack<>();

    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            for (int courseSize : course) {
                getAllCombinations(order, courseSize, 0);
                maxCountByCourse.put(courseSize, 0);
            }
        }
        getMaxCountByCourse();
        return getAnswer();
    }

    private void getAllCombinations(String order, int n, int start) {
        if (s.size() == n) {
            String menu = convertToString(s);
            combinations.put(menu, combinations.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            s.push(String.valueOf(order.charAt(i)));
            getAllCombinations(order, n, i + 1);
            s.pop();
        }
    }

    private String convertToString(Stack<String> s) {
        String[] menus = s.stream().toArray(String[]::new);
        Arrays.sort(menus);
        StringBuilder sb = new StringBuilder();
        for (String menu : menus) {
            sb.append(menu);
        }
        return sb.toString();
    }

    private void getMaxCountByCourse() {
        for (String course : combinations.keySet()) {
            int courseSize = course.length();
            int count = combinations.get(course);
            if (maxCountByCourse.get(courseSize) < count) {
                maxCountByCourse.put(courseSize, count);
            }
        }
    }

    private String[] getAnswer() {
        List<String> answer = new ArrayList<>();
        for (String course : combinations.keySet()) {
            int count = combinations.get(course);
            if (count >= 2 && maxCountByCourse.get(course.length()) == count) {
                answer.add(course);
            }
        }

        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }

}
