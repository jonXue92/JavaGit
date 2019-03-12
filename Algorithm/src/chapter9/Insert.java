package chapter9;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Insert {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> answer = new ArrayList<>();
        int index = 0;
        while (index < intervals.size() && intervals.get(index).start < newInterval.start) {
            index++;
        }
        intervals.add(index, newInterval);
        Interval last = null;
        for (Interval item: intervals) {
            if (last == null || last.end < item.start) {
                answer.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); //Modify the element already in list
            }
        }
        return answer;
    }
}
