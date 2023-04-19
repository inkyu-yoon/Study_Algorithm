package LV2.파일명정렬;

import java.util.*;
import java.util.regex.*;
class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files,new Comparator<String>(){
            @Override
            public int compare(String str1,String str2){
                Pattern p = Pattern.compile("\\d+");
                Matcher mc1 = p.matcher(str1);
                Matcher mc2 = p.matcher(str2);
                mc1.find();
                mc2.find();

                String numOfStr1 = mc1.group();
                String numOfStr2 = mc2.group();

                String headerOfStr1 = str1.substring(0,str1.indexOf(numOfStr1)).toLowerCase();
                String headerOfStr2 = str2.substring(0,str2.indexOf(numOfStr2)).toLowerCase();


                int result = headerOfStr1.compareTo(headerOfStr2);

                if(result==0){
                    return Integer.parseInt(numOfStr1)-Integer.parseInt(numOfStr2);
                }else{
                    return result;
                }
            }
        });

        return files;
    }
}