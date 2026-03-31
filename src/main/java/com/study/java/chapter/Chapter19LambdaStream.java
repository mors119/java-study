package com.study.java.chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

// ======================
// 1. enum
// ======================
enum LamUserStatus {
    ACTIVE,
    INACTIVE
}

// ======================
// 2. 도메인 클래스
// ======================
class LamUser {
    private final Long id;
    private final String name;
    private final int age;
    private final LamUserStatus status;

    public LamUser(Long id, String name, int age, LamUserStatus status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LamUserStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "LamUser{id=" + id + ", name='" + name + "', age=" + age + ", status=" + status + "}";
    }
}

// ======================
// 3. Functional Interface
// ======================
@FunctionalInterface
interface LamUserPrinter {
    void print(LamUser user);

    // default 메서드는 추가 가능
    default void printHeader() {
        System.out.println("=== 사용자 출력 시작 ===");
    }
}

// ======================
// 4. Repository
// ======================
class LamUserRepository {

    private final List<LamUser> users = new ArrayList<>();

    public LamUserRepository() {
        users.add(new LamUser(1L, "kim", 20, LamUserStatus.ACTIVE));
        users.add(new LamUser(2L, "lee", 17, LamUserStatus.INACTIVE));
        users.add(new LamUser(3L, "park", 30, LamUserStatus.ACTIVE));
        users.add(new LamUser(4L, "choi", 25, LamUserStatus.ACTIVE));
    }

    public List<LamUser> findAll() {
        return users;
    }

    public Optional<LamUser> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}

// ======================
// 5. Service
// ======================
class LamUserService {

    private final LamUserRepository userRepository = new LamUserRepository();

    public List<LamUser> getAllLamUsers() {
        return userRepository.findAll();
    }

    public Optional<LamUser> findLamUser(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Functional Interface + Lambda 사용
     */
    public void printLamUsers(LamUserPrinter printer) {
        printer.printHeader();

        for (LamUser user : userRepository.findAll()) {
            printer.print(user);
        }
    }

    /**
     * Predicate는 자바 기본 Functional Interface
     * - 입력 하나 받고 boolean 반환
     */
    public List<LamUser> findLamUsersByCondition(Predicate<LamUser> condition) {
        List<LamUser> result = new ArrayList<>();

        for (LamUser user : userRepository.findAll()) {
            if (condition.test(user)) {
                result.add(user);
            }
        }

        return result;
    }

    /**
     * Stream 사용
     */
    public List<String> getActiveAdultLamUserNames() {
        return userRepository.findAll().stream()
                .filter(user -> user.getStatus() == LamUserStatus.ACTIVE) // 조건 필터링
                .filter(user -> user.getAge() >= 20)                   // 조건 추가
                .map(LamUser::getName)                                    // LamUser -> name
                .map(String::toUpperCase)                              // 소문자 -> 대문자
                .toList();                                             // 결과 수집
    }

    /**
     * Stream + Optional
     */
    public String getUpperLamUserName(Long id) {
        return userRepository.findById(id)
                .map(LamUser::getName)
                .map(String::toUpperCase)
                .orElse("UNKNOWN");
    }
}

// ======================
// 6. 실행 클래스
// ======================
public class Chapter19LambdaStream {

    public static void main(String[] args) {

        LamUserService userService = new LamUserService();

        // ==================================================
        // 1. Lambda 기본
        // ==================================================
        LamUserPrinter printer = user -> System.out.println("사용자: " + user.getName());

        printer.printHeader();
        printer.print(new LamUser(99L, "temp", 10, LamUserStatus.ACTIVE));

        System.out.println();

        // ==================================================
        // 2. Functional Interface + Lambda를 서비스에 전달
        // ==================================================
        userService.printLamUsers(user ->
                System.out.println(
                        "id=" + user.getId()
                                + ", name=" + user.getName()
                                + ", age=" + user.getAge()
                                + ", status=" + user.getStatus()
                )
        );

        System.out.println();

        // ==================================================
        // 3. 조건을 Lambda로 전달 (Predicate)
        // ==================================================
        List<LamUser> adults = userService.findLamUsersByCondition(user -> user.getAge() >= 20);
        System.out.println("성인 사용자: " + adults);

        List<LamUser> activeLamUsers = userService.findLamUsersByCondition(
                user -> user.getStatus() == LamUserStatus.ACTIVE
        );
        System.out.println("활성 사용자: " + activeLamUsers);

        System.out.println();

        // ==================================================
        // 4. Stream 사용
        // ==================================================
        List<String> names = userService.getActiveAdultLamUserNames();
        System.out.println("활성 성인 사용자 이름: " + names);

        System.out.println();

        // ==================================================
        // 5. Optional + Stream 느낌
        // ==================================================
        String upperName1 = userService.getUpperLamUserName(1L);
        String upperName2 = userService.getUpperLamUserName(999L);

        System.out.println("ID 1 이름: " + upperName1);
        System.out.println("ID 999 이름: " + upperName2);

        System.out.println();

        // ==================================================
        // 6. forEach + method reference
        // ==================================================
        userService.getAllLamUsers().stream()
                .map(LamUser::getName)
                .forEach(System.out::println);
    }
}