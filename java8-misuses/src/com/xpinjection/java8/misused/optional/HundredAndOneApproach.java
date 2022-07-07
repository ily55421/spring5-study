package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Bad;
import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

/**
 * 一百零一法
 * @author link
 */
public class HundredAndOneApproach {
    /**
     * TODO 相同的旧命令式风格
     */
    @Ugly
    class SameOldImperativeStyle {
        /**
         * 获取人车保险名称
         * @param person
         * @return
         */
        public String getPersonCarInsuranceName(Person person) {
            String name = "Unknown";
            if (ofNullable(person).isPresent()) {
                // 在场
                if (person.getCar().isPresent()) {
                    // car在场
                    if (person.getCar().get().getInsurance().isPresent()) {
                        // car的 insurance 在场
                        // 赋值保险名称
                        name = person.getCar().get().getInsurance().get().getName();
                    }
                }
            }
            return name;
        }
    }

    /**
     * TODO ugly 以与 Dirty Hack 相同的命令方式使用 If Present
     */
    @Ugly
    class UsingIfPresentInSameImperativeWayWithDirtyHack {
        public String getPersonCarInsuranceName(Person person) {
            final StringBuilder builder = new StringBuilder();
            // 人在场
            ofNullable(person).ifPresent(
                    // car 在场
                    p -> p.getCar().ifPresent(
                            // 保险在场
                            c -> c.getInsurance().ifPresent(
                                    // 拼接 builder
                                    i -> builder.append(i.getName())
                            )
                    )
            );
            return builder.toString();
        }
    }

    /**
     * TODO bad  使用未选中获取的map
     */
    @Bad
    class UsingMapWithUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            // person 在场
            return ofNullable(person)
                    // 获取car
                    .map(Person::getCar)
                    // 获取 insurance
                    .map(car -> car.get().getInsurance())
                    // 获取 insurance的 name
                    .map(insurance -> insurance.get().getName())
                    // 否则返回 Unknown
                    .orElse("Unknown");
        }
    }

    /**
     * TODO ugly 使用带有或其他空对象的map来修复未选中的获取
     */
    @Ugly
    class UsingMapWithOrElseEmptyObjectToFixUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            return ofNullable(person)
                    .map(Person::getCar)
                    // car.orElseGet(Car::new) 不存在获取一个空car 对象
                    .map(car -> car.orElseGet(Car::new).getInsurance())
                    // insurance.orElseGet(Insurance::new) 不存在获取一个空insurance 对象
                    .map(insurance -> insurance.orElseGet(Insurance::new).getName())
                    .orElse("Unknown");
        }
    }

    /**
     * TODO good 使用平铺map
     */
    @Good
    class UsingFlatMap {
        public String getCarInsuranceNameFromPersonUsingFlatMap(Person person) {
            return ofNullable(person)
                    // 获取car映射流
                    .flatMap(Person::getCar)
                    // 获取insurance映射流
                    .flatMap(Car::getInsurance)
                    // 获取保险名称
                    .map(Insurance::getName)
                    // 或者 Unknown（未知）
                    .orElse("Unknown");
        }
    }

    class Person {
        Optional<Car> getCar() {
            return empty(); //stub
        }
    }

    class Car {
        Optional<Insurance> getInsurance() {
            return empty(); //stub
        }
    }

    class Insurance {
        String getName() {
            return ""; //stub
        }
    }
}
