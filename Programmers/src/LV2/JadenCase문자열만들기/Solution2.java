package LV2.JadenCase문자열만들기;

class Solution2 {
    public String solution(String s) {

        s = s.toLowerCase();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == 0) {
                if (isAlpha(ch)) {
                    ans.append((char) (ch - 32));
                } else {
                    ans.append(ch);
                }
            } else {
                char prev = s.charAt(i - 1);
                if (ch != ' ' && prev == ' ') {
                    if (isAlpha(ch)) {
                        ans.append((char) (ch - 32));
                    } else {
                        ans.append(ch);
                    }
                } else {
                    ans.append(ch);
                }
            }
        }


        return ans.toString();
    }

    private boolean isAlpha(char ch) {
        return 'a' <= ch && ch <= 'z';
    }
}