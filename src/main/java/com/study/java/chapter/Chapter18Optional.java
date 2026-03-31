package com.study.java.chapter;

import java.util.*;

// ======================
// 1. enum (상태 정의)
// ======================
enum DomainUserStatus {
    ACTIVE,
    INACTIVE
}

// ======================
// 2. 도메인 클래스
// ======================
class DomainUser {
    private final Long id;
    private final String name;
    private final DomainUserStatus status;

    public DomainUser(Long id, String name, DomainUserStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public DomainUserStatus getStatus() { return status; }
}

// ======================
// 3. Repository (Map 기반)
// ======================
class DomainUserRepository {

    private final Map<Long, DomainUser> store = new HashMap<>();

    public DomainUserRepository() {
        store.put(1L, new DomainUser(1L, "kim", DomainUserStatus.ACTIVE));
        store.put(2L, new DomainUser(2L, "lee", DomainUserStatus.INACTIVE));
    }

    /**
     * Optional 반환 (핵심)
     */
    public Optional<DomainUser> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<DomainUser> findAll() {
        return new ArrayList<>(store.values());
    }
}

// ======================
// 4. 커스텀 예외
// ======================
class DomainUserNotFoundException extends RuntimeException {
    public DomainUserNotFoundException(Long id) {
        super("사용자를 찾을 수 없습니다. id=" + id);
    }
}

// ======================
// 5. Service (핵심 로직)
// ======================
class DomainUserService {

    private final DomainUserRepository userRepository = new DomainUserRepository();

    /**
     * Optional → map → orElseThrow 패턴 (핵심)
     */
    public String getDomainUserNameUpper(Long id) {
        return userRepository.findById(id)
                .map(DomainUser::getName)              // DomainUser → name
                .map(String::toUpperCase)        // name → 대문자
                .orElseThrow(() -> new DomainUserNotFoundException(id));
    }

    /**
     * Optional + 기본값 처리
     */
    public String getDomainUserNameOrDefault(Long id) {
        return userRepository.findById(id)
                .map(DomainUser::getName)
                .orElse("Unknown");
    }

    /**
     * List + Optional + enum 활용
     */
    public List<String> getActiveDomainUserNames() {
        List<String> result = new ArrayList<>();

        for (DomainUser user : userRepository.findAll()) {
            if (user.getStatus() == DomainUserStatus.ACTIVE) {
                result.add(user.getName());
            }
        }

        return result;
    }
}

// ======================
// 6. 실행 클래스
// ======================
public class Chapter18Optional {

    public static void main(String[] args) {

        DomainUserService userService = new DomainUserService();

        // 1️⃣ 정상 케이스
        String name = userService.getDomainUserNameUpper(1L);
        System.out.println("대문자 이름: " + name);

        // 2️⃣ 기본값 처리
        String defaultName = userService.getDomainUserNameOrDefault(99L);
        System.out.println("기본값 이름: " + defaultName);

        // 3️⃣ 예외 발생 케이스
        try {
            userService.getDomainUserNameUpper(99L);
        } catch (DomainUserNotFoundException e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        // 4️⃣ List + enum 활용
        List<String> activeDomainUsers = userService.getActiveDomainUserNames();
        System.out.println("활성 사용자: " + activeDomainUsers);

        // ======================
        // ❌ Optional 잘못된 사용
        // ======================
        Optional<String> nameOpt = Optional.ofNullable("kim");

        if (nameOpt.isPresent()) { // ❌ 비추천
            System.out.println(nameOpt.get());
        }

        // ======================
        // ✅ Optional 올바른 사용
        // ======================
        Optional.ofNullable("kim")
                .map(String::toUpperCase)
                .ifPresent(value -> System.out.println("올바른 사용: " + value));

        // ======================
        // Optional 생성 방식 정리
        // ======================

        Optional.of("lee");
        // ✔ null 절대 안 들어감 (null이면 NPE 발생)

        Optional.ofNullable("park");
        // ✔ null 가능 (실무에서 기본)

        Optional.empty();
        // ✔ 값이 없는 Optional
    }
}