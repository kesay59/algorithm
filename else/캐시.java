class Solution {
    private int time = 1;
    private Cache[] caches;
    private class Cache {
        int time;
        String city;
        Cache(int time, String city) {
            this.time = time;
            this.city = city;
        }
    }
    private int checkCache(String city) {
        int minIdx = 0;
        for(int idx = 0; idx < caches.length; idx++) {
            if(caches[idx].city.equals(city)) {
                caches[idx].time = time;
                minIdx = -1;
                break;
            }
            if(caches[idx].time < caches[minIdx].time) {
                minIdx = idx;
            }
        }
        if(minIdx != -1) {
            caches[minIdx].time = time;
            caches[minIdx].city = city;
            return 5;
        }
        return 1;
    }
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        caches = new Cache[cacheSize];
        for(int idx = 0; idx < caches.length; idx++) {
            caches[idx] = new Cache(0, "");
        }
        for(String city : cities) {
            time += checkCache(city.toLowerCase());
        }
        int answer = time - 1;
        return answer;
    }
}