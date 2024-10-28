public class maximumWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(accounts));
    }
    static int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        // person = row
        for(int person = 0; person<accounts.length; person++){
            int sum = 0;
        // accounts = column
        // when we take a new column, take a new sum of that row.
            for (int account = 0; account<accounts[person].length; account++){
                sum = sum + accounts[person][account];
            }
            // now we have sum of each person account
            // check with overall answer
            if (sum>ans){
                ans = sum;
            }
        }
        return ans;
    }
}
