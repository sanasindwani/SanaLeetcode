// Right known sum + 4.5(right ques marks)
// Left known sum + 4.5(left ques marks)
// yeah eqn derive hogi iss ques se and inki value equal honi chahiyae for bob to win

// thus we need left known sum, left ques marks, right known sum and right ues marks
// agar total ques marks(left + right) agar odd hua then alice always win


// TC -> O(N)
// SC -> O(1)
class Solution {
    public boolean sumGame(String num) {
        int len = num.length();

        int qCountLeft = 0;
        int qCountRight = 0;
        int leftSum = 0;
        int rightSum = 0;

        for(int i = 0; i < len/2; i++){
            if(num.charAt(i) == '?') qCountLeft += 1;
            else                     leftSum += num.charAt(i) - '0';
        }

        for(int i = len/2; i < len; i++){
            if(num.charAt(i) == '?') qCountRight += 1;
            else                     rightSum += num.charAt(i) - '0';
        }

        int total = qCountLeft + qCountRight;
        if(total % 2 != 0) return true; //odd alice always wins

        int LEFT = 2*leftSum + 9*qCountLeft;
        int RIGHT = 2*rightSum + 9*qCountRight;

        if(LEFT == RIGHT) return false; //bob wins
        return true;
    }
}

/*class Solution {
    public boolean sumGame(String num) {
        int length = num.length();

        int leftQuestionMarks = 0;
        int leftSum = 0;
        for (int i = 0; i < length / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQuestionMarks++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        int rightQuestionMarks = 0;
        int rightSum = 0;
        for (int i = length / 2; i < length; i++) {
            if (num.charAt(i) == '?') {
                rightQuestionMarks++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int totalQuestionMarks = leftQuestionMarks + rightQuestionMarks;
        int sumDifference = leftSum - rightSum;
        int questionMarkDifference = rightQuestionMarks - leftQuestionMarks;

        return totalQuestionMarks % 2 == 1 || sumDifference != 9 * questionMarkDifference / 2;
    }
}*/