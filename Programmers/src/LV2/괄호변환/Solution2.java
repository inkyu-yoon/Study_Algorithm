package LV2.괄호변환;

class Solution2 {
    public String solution(String p) {
        String answer = "";

        if (p.equals(answer)) {
            return answer;
        } else if (isAlreadyRight(p)) {
            return p;
        }

        return getAns(p);
    }

    private String getAns(String p) {
        if (p.equals("")) {
            return "";
        }

        String u = getU(p);
        String v = getV(p, u);
        if (isAlreadyRight(u)) {
            return u + getAns(v);
        } else {
            return "" + '(' + getAns(v) + ')' + trans(u);
        }

    }

    private String getU(String str) {
        StringBuilder sb = new StringBuilder();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                count1++;
                sb.append('(');
            } else {
                count2++;
                sb.append(')');
            }
            if (count1 != 0 && count1 == count2) {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private String getV(String p, String u) {
        int idx = p.indexOf(u);
        return p.substring(idx + u.length());
    }

    private String trans(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    private boolean isAlreadyRight(String p) {
        int n = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '(') {
                n++;
            } else {
                if (n == 0) {
                    return false;
                } else {
                    n--;
                }
            }
        }

        return n == 0 ? true : false;
    }
}
