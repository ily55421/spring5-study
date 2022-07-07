package com.xpinjection.java8.misused.lambda.collections;

import com.xpinjection.java8.misused.User;
import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author link
 * TODO 列表排序
 */
public class ListSorting {
    /**
     * TODO ugly 使用自定义比较器
     */
    @Ugly
    class UsingCustomComparator {
        public void sortUsersById(List<User> users) {
            users.sort((x, y) -> Long.compare(x.getId(), y.getId()));
        }
    }

    /**
     * TODO good 使用现有的预定义比较器
     */
    @Good
    class UsingExistingPredefinedComparator {
        public void sortUsersById(List<User> users) {
            // comparing 预定义排序方法
            users.sort(comparing(User::getId));
        }
    }
}
