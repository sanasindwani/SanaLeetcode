class rotateString{
    public boolean RotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        s = s+s;
        if(s.contains(goal)) return true;
        else                 return false;
    }
}m