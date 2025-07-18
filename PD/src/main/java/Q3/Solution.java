class Solution {

    public int longestValidParentheses(String s) {
        
        if (s == null || s.length() < 2) 
            return 0;
        

        int maxLength = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (s.charAt(i - 1) == ')') {

                    int prevOpenIndex = i - dp[i - 1] - 1;
                    
                    if (prevOpenIndex >= 0 && s.charAt(prevOpenIndex) == '(') {
                        int lengthOfInnerPart = dp[i - 1];
                        
                        int lengthOfPrefixPart = (prevOpenIndex > 0) ? dp[prevOpenIndex - 1] : 0;
                        
                        dp[i] = lengthOfInnerPart + 2 + lengthOfPrefixPart;
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}