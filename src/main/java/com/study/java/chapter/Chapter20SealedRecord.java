package com.study.java.chapter;

import java.util.*;
import java.util.stream.Collectors;

// ======================
// 1. enum (상태)
// ======================
enum RecordUserStatus {
    ACTIVE,
    INACTIVE
}

// ======================
// 2. record (DTO)
// ======================
record RecordUserDto(Long id, String name, RecordUserStatus status) {}

// ======================
// 3. sealed + record (결과 타입)
// ======================
sealed interface Result<T> permits Success, Failure {}

record Success<T>(T data) implements Result<T> {}
record Failure<T>(String message) implements Result<T> {}

// ======================
// 4. Entity (도메인)
// ======================
class RecordUser {
    private final Long id;
    private final String name;
    private final RecordUserStatus status;

    public RecordUser(Long id, String name, RecordUserStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public RecordUserStatus getStatus() { return status; }
}

// ======================
// 5. Repository (Map)
// ======================
class RecordUserRepository {

    private final Map<Long, RecordUser> store = new HashMap<>();

    public RecordUserRepository() {
        store.put(1L, new RecordUser(1L, "kim", RecordUserStatus.ACTIVE));
        store.put(2L, new RecordUser(2L, "lee", RecordUserStatus.INACTIVE));
        store.put(3L, new RecordUser(3L, "park", RecordUserStatus.ACTIVE));
    }

    public Optional<RecordUser> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<RecordUser> findAll() {
        return new ArrayList<>(store.values());
    }
}

// ======================
// 6. Service
// ======================
class RecordUserService {

    private final RecordUserRepository repository = new RecordUserRepository();

    /**
     * Optional → sealed Result 변환
     */
    public Result<RecordUserDto> getRecordUser(Long id) {
        return repository.findById(id)
                .map(user -> new RecordUserDto(user.getId(), user.getName(), user.getStatus()))
                .<Result<RecordUserDto>>map(Success::new)
                .orElseGet(() -> new Failure<>("사용자를 찾을 수 없습니다. id=" + id));
    }

    /**
     * Stream + record 변환
     */
    public List<RecordUserDto> getActiveRecordUsers() {
        return repository.findAll().stream()
                .filter(user -> user.getStatus() == RecordUserStatus.ACTIVE)
                .map(user -> new RecordUserDto(user.getId(), user.getName(), user.getStatus()))
                .toList();
    }

    /**
     * Map + grouping (실무 자주 씀)
     */
    public Map<RecordUserStatus, List<RecordUserDto>> groupByStatus() {
        return repository.findAll().stream()
                .map(user -> new RecordUserDto(user.getId(), user.getName(), user.getStatus()))
                .collect(Collectors.groupingBy(RecordUserDto::status));
    }
}

// ======================
// 7. 실행
// ======================
public class Chapter20SealedRecord {

    public static void main(String[] args) {

        RecordUserService service = new RecordUserService();

        // ======================
        // 1️⃣ 단건 조회 (Result)
        // ======================
        Result<RecordUserDto> result1 = service.getRecordUser(1L);
        Result<RecordUserDto> result2 = service.getRecordUser(99L);

        handleResult(result1);
        handleResult(result2);

        System.out.println();

        // ======================
        // 2️⃣ 리스트 조회 (Stream)
        // ======================
        List<RecordUserDto> activeRecordUsers = service.getActiveRecordUsers();
        System.out.println("활성 사용자: " + activeRecordUsers);

        System.out.println();

        // ======================
        // 3️⃣ 그룹핑 (Map + Stream)
        // ======================
        Map<RecordUserStatus, List<RecordUserDto>> grouped = service.groupByStatus();

        grouped.forEach((status, users) -> {
            System.out.println(status + " → " + users);
        });
    }

    // ======================
    // 4️⃣ sealed 처리 (핵심)
    // ======================
    static void handleResult(Result<RecordUserDto> result) {
        if (result instanceof Success<RecordUserDto> success) {
            System.out.println("성공: " + success.data());
        } else if (result instanceof Failure<RecordUserDto> failure) {
            System.out.println("실패: " + failure.message());
        }
    }
}