# 원티드 채용 공고 검색 API

## 목적
- 채용 공고 목록 검색하는 API 서비스
- 공고 랭킹 조회 API 서비스 제공

---

## 프로젝트 구성
- Java 11
- Spring Boot 2.7.6
- Spring Security
- Spring Data JPA
- H2 Database

### 프로젝트 Build
1. `git repository` clone or download
    - `url` : https://github.com/JiYoonKimjimmy/wanted-api-service.git
2. `gradlew` 을 통한 프로젝트 build
   ```shell
   cd $PROJECT_HOME
   ./gradlew build
   ```
3. 프로젝트 `jar` 실행
   ```shell
   cd $PROJECT_HOME/build/libs
   java -jar wanted-api-service-0.0.1-SNAPSHOT.jar 
   ```

---
