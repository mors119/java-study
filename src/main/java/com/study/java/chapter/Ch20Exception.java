package com.study.java.chapter;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 예외 처리
 */
public class Ch20Exception {
    // 프로그램 오류의 종류
    // 1. 컴파일 에러: 컴파일 시에 발생
    // 2. 런타임 에러: 실행 시 발생하는 에러 (Error, Exception)
    // 3. 논리적 에러: 실행은 되지만 의도와 다르게 동작

    // 에러(Error)와 예외(Exception)
    // 에러: 코드로 수습될 수 없는 심각한 오류
    // 예외: 코드로 수습할 수 있는 미약한 오류 (예외 발생 시 예외 발생 객체가 정보를 전달)

    // 예외의 최상위 클래스는 Exception
    // Exception 클래스 + 자손 : [필수]적으로 처리 - 처리 안하면 컴파일 오류, [사용자]의 실수
    // RuntimeException 클래스 + 자손 : 처리 안해도 컴파일 가능, [개발자]의 실수

    // 예외 처리 방법:
    // 1. (직접 처리) try-catch
    // 2. 예외 선언 (보고 = 상위 클래스로 던짐 (마지막까지 처리하지 않으면 JVM이 처리))
    //      void method() throws Exception

    // 예외 일부러 발생 시키기 (throw new Exception):
    // if(num == null) throw new Exception ("num is null");
    //      try-catch블럭으로 처리하거나 상위로 던져서 예외를 처리할 수 있음.

    public static void main(String[] args) {
        int s = 0;

        if(s == 0) {
            System.out.println(1);
            try {
                System.out.println(2);
                System.out.println(3 / 0);
                System.out.println(4); // 위에서 예외가 발생하므로 실행되지 않음.
                return;  // try가 정상적으로 실행되어서 return 되더라도 그 전에 finally는 실행됨.
            } catch (ArithmeticException ae) {
                System.out.println("ArithmeticException");
            } catch (Exception e) { // Exception은 최고 조상이므로 위 블럭들에 작성된 예외를 제외하고 모두 처리 (가장 위에 두면 아래 의미 없음)
    //            if (e instanceof ArithmeticException) //  catch (ArithmeticException ae) 와 역할 동일
    //                System.out.println("ArithmeticException");
                System.out.println("Exception");
            } finally {
                // try, catch 상관 없이 무조건 실행될 코드를 적음.
                // 주로 자원 반환이 필요한 코드의 경우 사용한다.
                System.out.println(5);
            }
        }
        // Multi catch 블록 - 하나의 catch 블럭으로 여러 예외 처리 (jdk 7)
        // exception들은 상속관계이므로 catch(부모 || 자식)은 허용 되지 않음 (부모에서 전부 걸리므로 사용할 필요 없음.)
        if(s == 1) {
            try {
                System.out.println(3 / 0);
            } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) { // 멀티 캐치 블록
                // if (e instanceof ArithmeticException || e instanceof ArrayIndexOutOfBoundsException)와 동일
                e.printStackTrace();
                System.out.println("ArithmeticException or ArrayIndexOutOfBoundsException");
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }

        if(s == 2) {
//            FileInputStream fis;
//            DataInputStream dis;
//            try {
//                fis = new FileInputStream("score.dat");
//                dis = new DataInputStream(fis);
//            }catch (IOException ie) {
//                ie.printStackTrace();
//            } finally {
//                try {
//                    if(dis !=null ) dis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            // 위 코드와 동일
            // try-with-resource: finally 없이도 자원을 반환 (close()를 자동 호출)
            // interface에 AutoCloseable을 구현한 객체만 try()에 넣을 수 있음.
            try (FileInputStream fis2 = new FileInputStream("score.dat");
                 DataInputStream dis2 = new DataInputStream(fis2)) {
                // ...
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 예외 양쪽에서 처리 (exception re-throwing) - 예외를 양쪽(호출한 쪽 - 당한 쪽 모두)에서 처리, 주로 Spring에서 사용됨.
        try {
            reThrowMethod();
        } catch (Exception e) {
            System.out.println("main에서 예외처리");
        }

    }
    // 예외를 양쪽에서 처리 (exception re-throwing)
    static void reThrowMethod () throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("reThrowMethod에서 예외처리");
            // 메서드가 void가 아닌 경우에 catch블럭에서도 return을 해야한다. 이때 대신 예외를 리턴할 수도 있다.
            // return 1; int인 경우
            // throw new Exception; // 이거나 아래처럼
            throw e; // 다시 예외를 발생
        }
    }

    // 연결된 예외(chained exception) 장점.
    // 1. 여러 예외를 하나로 묶을 수 있음.
    // 2. 필수 예외를 선택 예외로 변경
    void install() throws InstallException {
        try {
            startInstall();
            copyFile();
        } catch (SpaceException se) {
            // 여러 예외를 하나의 예외로 묶기
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(se) ; // SpaceException을 원인 예외로 등록
        } catch (MemoryException me) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(me) ;
            throw ie;
        }
    }

    // 연결 예외 예제
    class InstallException extends Throwable {
        InstallException(String msg) {
            super(msg);
        }
    }

    class SpaceException extends Exception {
        SpaceException(String msg) {
            super(msg);
        }
    }

    class MemoryException extends Exception {
        MemoryException(String msg) {
            super(msg);
        }
    }

    // Dummy methods for compilation
    static void startInstall() throws SpaceException, MemoryException {
//        연결된 예외(chained exception) 예제 - 필수 예외를 선택 예외로 변경
//        아래 주석을 해제하면 윗 줄에 MemoryException은 지워도 된다.
//        if(!enoughSpace()) {
//            throw new SpaceException("설치 공간 부족");
//        }
//        if(!enoughMemory()) {
//            필수 예외인 MemoryException을 선택 예외에 담아서 던지면
//            상위 객체에 SpaceException만 던져도 되고 Space 관련 예외만 처리할 수 있게 된다.
//            throw new RuntimeException(new MemoryException());
//        }
    }
    static void copyFile() {
    }

}

// 사용자 예외 정의
// Exception이나 RuntimeException을 상속받아서 만들면 됨.
class MyException extends Exception {
    private final int ERR_CODE;

    MyException(String msg) {
        this(msg, 100); // ERR_CODE를 100으로 지정
    }

    MyException(String msg, int errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}

