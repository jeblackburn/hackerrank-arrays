package qs;

import java.util.Collection;
import java.util.List;

public class QuickSort {
    private static final Integer UNSET = -1;

    public void sort(List<Integer> l) {
        sort(l, 0, l.size() - 1);
    }

    private void sort(List<Integer> l, int start, int end) {
        if (start >= end) {
            return;
        }
        var p = partition(l, start, end);
        sort(l, start, p - 1);
        sort(l, p + 1, end);
    }

    public int partition(List<Integer> l, int start, int end) {
        var pivot = l.get(end);
        int mightNeedSwitchingIdx = -1;
        var left = start - 1;
        while (left < end) {
            left++;
            Integer mightNeedSwitching = l.get(left);
            if (mightNeedSwitching > pivot) {
                mightNeedSwitchingIdx = left;
                left++;
                while(left <= end) {
                    var candidate = l.get(left);
                    if (candidate < pivot) {
                        l.set(mightNeedSwitchingIdx, candidate);
                        l.set(left, mightNeedSwitching);
                        left = mightNeedSwitchingIdx;
                        break;
                    } else {
                        left++;
                    }
                    l.set(mightNeedSwitchingIdx, pivot);
                    l.set(end, mightNeedSwitching);
                }
            }
        }
        return mightNeedSwitchingIdx == -1 ? end : mightNeedSwitchingIdx;
    }
}
