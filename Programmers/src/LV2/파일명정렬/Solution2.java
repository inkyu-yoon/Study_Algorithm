package LV2.파일명정렬;

import java.util.*;

class Solution2 {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for (String file : files) {
            list.add(convertToFile(file));
        }

        Collections.sort(list, (a, b) -> {
            int headCon = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if (headCon == 0) {
                int numCon = Integer.parseInt(a.number) - Integer.parseInt(b.number);
                return numCon;
            } else {
                return headCon;
            }
        });

        List<String> answers = new ArrayList<>();
        for (File file : list) {
            answers.add(file.toString());
        }
        return answers.stream().toArray(String[]::new);
    }

    public File convertToFile(String str) {
        String head = str;
        int idx = 0;
        String number;
        String tail = null;
        for (int i = 0; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                head = str.substring(0, i);
                idx = i;
                break;
            }
        }
        number = str.substring(idx);
        for (int i = idx; i < str.length(); i++) {
            if (!isDigit(str.charAt(i))) {
                number = str.substring(idx, i);
                tail = str.substring(i);
                break;
            }
        }
        return new File(head, number, tail);
    }

    public boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    static class File {

        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return tail == null ? head + number : head + number + tail;
        }
    }
}