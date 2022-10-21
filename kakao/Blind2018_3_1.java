import java.util.*;

class Solution {

    private String convert(String line) {
        return line
                .replaceAll("C#", "V")
                .replaceAll("D#", "W")
                .replaceAll("F#", "X")
                .replaceAll("G#", "Y")
                .replaceAll("A#", "Z");
    }
    public String solution(String m, String[] musicinfos) {
        m = convert(m);
        String[] arr = new String[3601];
        arr[0] = "(None)";
        for(String musicinfo : musicinfos) {
            StringTokenizer st = new StringTokenizer(musicinfo, ",");
            StringTokenizer timeSt = new StringTokenizer(st.nextToken(), ":");
            int startMin = Integer.parseInt(timeSt.nextToken()) * 60 + Integer.parseInt(timeSt.nextToken());
            timeSt = new StringTokenizer(st.nextToken(), ":");
            int endMin = Integer.parseInt(timeSt.nextToken()) * 60 + Integer.parseInt(timeSt.nextToken());
            int cnt = endMin - startMin;
            String name = st.nextToken();
            String music = convert(st.nextToken());
            StringBuilder stb = new StringBuilder();
            while(stb.length() < cnt) {
                stb.append(music);
            }
            music = stb.toString().substring(0, cnt);
            if(music.contains(m)) {
                if(arr[cnt] == null) arr[cnt] = name;
            }
        }
        for(int i = arr.length-1; i >= 0; i--) {
            if(arr[i] != null) return arr[i];
        }
        return "(None)";
    }
}