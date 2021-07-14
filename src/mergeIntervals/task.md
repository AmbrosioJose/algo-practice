Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return _an array of the non-overlapping intervals that cover all the intervals in the input._



### Example 1:

__Input__ : intervals = [[1,3],[2,6],[8,10],[15,18]]

__Output__ : [[1,6],[8,10],[15,18]]

__Explanation__ : Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

### Example 2:

__Input__ : intervals = [[1,4],[4,5]]

__Output__ : [[1,5]]

__Explanation__ : Intervals [1,4] and [4,5] are considered overlapping.


### Constraints:

- 1 <= intervals.length <= 104
- intervals[i].length == 2
- 0 <= starti <= endi <= 104