package com.lypgod;

import java.util.Optional;

/**
 * @author lypgo
 */
public class OptionalTest {
    class User {
        private String name;
        private Address address;

        Address getAddress() {
            return address;
        }

        String getName() {
            return name;
        }
    }

    class Address {
        private String city;

        String getCity() {
            return city;
        }
    }

    private void errorNullStyle(User user) {
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String city = address.getCity();
                if (city != null && !"".equals(city)) {
                    //do something...
                }
            }
        }
    }

    private void optionalNullStyle(User user) {
        Optional.ofNullable(user).map(User::getAddress).map(Address::getCity).filter(e -> !"".equals(e)).ifPresent(city -> {
            //do something...
        });
    }

    private void optionalIfPresent(User user) {
        Optional.ofNullable(user).ifPresent(System.out::println);
    }

    private void optionalFilter(User user) {
        Optional.ofNullable(user).filter(e -> !"".equals(e.getName()));
    }

    private void optionalMap(User user) {
        Optional.ofNullable(user).map(User::getAddress);
        Optional.ofNullable(user).flatMap(u -> Optional.ofNullable(u.getAddress()));
    }

    private void  optionalOrElse(User user) throws Exception {
        User user1 = Optional.ofNullable(user).orElse(new User());
        Optional.ofNullable(user).orElseGet(this::display);
        Optional.ofNullable(user).orElseThrow(() -> new Exception("display"));
    }
    private User display() {
        System.out.println("display");
        return new User();
    }

    private void execute() {
        Optional<String> maybeString = Optional.of("foo");
        String newString = maybeString.map(this::runIfExist).orElseGet(this::runIfEmpty);
        System.out.println(newString);
    }

    private String runIfEmpty() {
        System.out.println("only run if empty");
        return "empty";
    }

    private String runIfExist(String s) {
        System.out.println("only run if optional is filled");
        return s;
    }

    public static void main(String[] args) {
        OptionalTest test = new OptionalTest();
        test.execute();
    }
}
