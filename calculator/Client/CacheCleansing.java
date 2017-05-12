package calculator.Client;

import calculator.Client.cache.DoubleCache;

/**
 * Created by boecn on 13.05.2017.
 */
public class CacheCleansing implements Runnable {
    @Override
    public void run() {
        DoubleCache.cacheOperation2.clear();
    }
}
