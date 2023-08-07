import java.io.*;

import javax.xml.transform.Source; // XML 변환 클래스
import javax.xml.transform.stream.StreamSource; // XML 문서 읽기
import javax.xml.validation.*; // XML 유효성 검사

import org.xml.sax.SAXException; // XML 파싱 예외 처리

public class XSDCheck { // XML 유효성 검사 클래스

    public static void main(String[] args) {

        SchemaFactory factory = SchemaFactory // 스키마 생성을 위한 팩토리 객체 생성
                .newInstance("http://www.w3.org/2001/XMLSchema"); // XML 스키마의 기본 정의

        String xsd = "C:\\Users\\kwon5\\Desktop\\XSDCheck\\src\\xsd1.xsd"; // xsd 파일위치
        String xml = "C:\\Users\\kwon5\\Desktop\\XSDCheck\\src\\xml1.xml"; // 유효성을 검사할 xml 파일위치

        File schemaLocation; // 스키마 파일
        Schema schema; // 스키마 객체
        Validator validator; // 유효성 검사 객체

        try {
            schemaLocation = new File(xsd); // xsd 변수에 저장된 경로로부터 스키마 파일(File 객체)을 생성
            schema = factory.newSchema(schemaLocation); // 생성된 스키마 파일을 사용하여 새로운 스키마(Schema) 객체를 생성
            validator = schema.newValidator(); // 생성된 스키마를 사용하여 유효성 검사 도구(Validator) 객체를 생성

            Source source = new StreamSource(xml); // 유효성을 검사할 xml 파일을 StreamSource 객체로 읽음
            validator.validate(source); // xml 유효성을 검사

            System.out.println(xml + " 유효성 검사 성공");

        } catch (IOException e) {
            System.out.println(xml + " 파일을 찾을 수 없음");
            System.out.println(e.getMessage());

        } catch (SAXException e) {
            System.out.println(xml + " 유효성 검사 실패"); //
            System.out.println(e.getMessage());
        }
    }
}