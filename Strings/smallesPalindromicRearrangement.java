// isko ham center se partition karke do half me divide kar lenge 
// and fir eak half ko sort kar denge thenn dusra half uski mirror image ho jayega
// try to do it in various funstions like cp kyonki voh bahot impressive and structured lagta hai
// eg -> dcaacd isko agar ham do halfs mein divide kar denge then it'll become dca|acd abb pehle half ko sort kar lenge then it'll become acd|acd abb dusre half ko usko mirror image bana denge acd|dca
// abb with odd length of the string = bacdcab -> agar isko ham do half me divide karenge then it'll become bac|d|cab abb first half sort karenge toh it'll be abc|d|cab then uska reverse mirror image dusri side abcdcba

class Solution {
  public String smallestPalindrome(String s) {
    final int n = s.length();  // The final keyword is used in Java to restrict modification.
    String sortedHalf = getSortedHalf(s);
    return sortedHalf + (n % 2 == 1 ? String.valueOf(s.charAt(n/2)) : "")+ reversed(sortedHalf);
  }
  private String getSortedHalf(String s){
    String half = s.substring(0, s.length()/2);
    char[] chars = half.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  String reversed(String s){
    return new StringBuilder(s).reverse().toString();
  }
}

/*class Solution {
  public String smallestPalindrome(String s) {
    final int n = s.length();
    final String sortedHalf = getSortedHalf(s);
    return sortedHalf + (n % 2 == 1 ? String.valueOf(s.charAt(n / 2)) : "") + reversed(sortedHalf);
  }

  private String getSortedHalf(final String s) {
    final String half = s.substring(0, s.length() / 2);
    char[] chars = half.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  private String reversed(final String s) {
    return new StringBuilder(s).reverse().toString();
  }
}*/