package array;

/**
 * 获取String数组中各元素的最大公共前缀
 */
public class longestCommonPrefix {
    /**
     * 自己的解答
     * @param strs
     * @return
     */
    public String my(String[] strs){
                String commonPrefix = "";
                if(strs==null||strs.length==0) return "";
                if(strs.length==1) return strs[0];
                if(strs[0].equals("")) return "";
                boolean flag = false;
                for(int i=0;;i++){
                    if(i>strs[0].length()){
                        break;
                    }
                    String prefix = strs[0].substring(0,i);
                    for(String s:strs){
                        if("".equals(s)){
                            return "";
                        }
                        if(i>s.length()||!s.substring(0,i).equals(prefix)){
                            flag=true;
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }else{
                        commonPrefix = prefix;
                    }
                }
                return commonPrefix;
    }

    /**
     * 大佬的解答
     * @param strs
     * @return
     */
    public String dalao(String[] strs){
        int nums = strs.length;
        String prefix = "";

        if(nums !=0){
            prefix = strs[0];
        }

        for(int i=0; i<nums; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() -1);
            }
        }
        return prefix;
    }
}
