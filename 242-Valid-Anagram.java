class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> sMap = new HashMap<>();

        for (char ch : s.toCharArray()) {

            if (sMap.containsKey(ch)) {
                sMap.put(ch, sMap.get(ch) + 1);
            } else {
                sMap.put(ch, 1);
            }
        }

        for (char ch : t.toCharArray()) {

            if (!sMap.containsKey(ch) || sMap.get(ch) == 0) {
                return false;
            }

            sMap.put(ch, sMap.get(ch) - 1);

        }
        System.out.println(sMap);
        return true;
    }

}