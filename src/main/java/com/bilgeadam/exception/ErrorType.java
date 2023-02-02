package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.security.KeyStoreUtil;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR(1000,"Sunucuda beklenmeyen hata oluştu",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001, "Parametre eksik yada hatalı", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(1002,"Eposta yada şifre hatalı",HttpStatus.BAD_REQUEST),
    REGISTER_REPASSWORD_ERROR(1003,"Girilen şifreler uyuşmuyor",HttpStatus.BAD_REQUEST),
    JWT_TOKEN_CREATE_ERROR(1004,"Token Oluşturma Hatası",HttpStatus.BAD_REQUEST),
    REGISTER_EMAIL_KAYITLI(1005,"Email zaten kayıtlı",HttpStatus.BAD_REQUEST),

    GECERSIZ_GIRIS_DENEMESI(1006, "YETKISIZ GIRIS", HttpStatus.UNAUTHORIZED),

    KULLANICI_BULUNAMADI(1007, "KULLANICI BULUNAMADI", HttpStatus.NOT_FOUND);





    int code;
    String message;
    HttpStatus httpStatus;
}
