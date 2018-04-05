class Solution {
    public int strStr(String haystack, String needle) {
        int count = 0;
         for(int i = 0; ; i++){
             for(int j =0; ;j++){
                 if(j==needle.length()) return i;
                 if(haystack.length()-i<needle.length()) return -1;
                 if(haystack.charAt(i+j)!= needle.charAt(j)) break;
                 
             }
         }
     }
    }
