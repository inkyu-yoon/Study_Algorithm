package LV2.스킬트리;

class Solution2 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skillTree : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(String s : skillTree.split("")){
                if(skill.contains(s)){
                    sb.append(s);
                }
            }
            if(skill.indexOf(sb.toString())==0){
                answer++;
            }
        }
        return answer;
    }
}
