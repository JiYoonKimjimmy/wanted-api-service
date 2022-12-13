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
- QueryDSL
- H2 Database 2.1.214
- Gradle 7.5.1

### 프로젝트 Build
1. `git repository` clone or download
    - `url` : https://github.com/JiYoonKimjimmy/wanted-api-service.git
2. `gradlew` 을 통한 프로젝트 build
   ```shell
   cd $WORKSPACE/wanted-api-service
   ./gradlew build
   ```
3. 프로젝트 `jar` 실행
   ```shell
   cd $WORKSPACE/wanted-api-service/build/libs
   java -jar wanted-api-service-0.0.1.jar 
   ```

---

## 프로젝트 정보

### Server 정보
|      구분      | 정보       |
|:------------:|----------|
|     Port     | `10010`  |
| Context-Path | `wanted` |

### API 테스트 방법
1. `Swagger-ui` 이용
   - [http://localhost:10010/wanted/swagger-ui/index.html](http://localhost:10010/wanted/swagger-ui/index.html)
2. `IntelliJ .http` 이용
   - `/http/wanted-api-test.http` 파일의 `request` 활용하여 API 테스트 요청

---

## Database 정보
- H2 Database Embedded 환경
- URL : `jdbc:h2:tcp://localhost:9092/~/h2/job-posts`

### DB 테스트 정보 등록 방법
- 테스트 데이터는 Spring SQL 자동 init 설정을 통해 등록

#### `application.yml`
```yaml
spring:
  sql:
  init:
    # DB 스키마 CREATE 문 작성 SQL 파일 등록
    schema-locations: classpath:sql/create-schema.sql
    # DB 테스트 데이터 INSERT 문 작성 SQL 파일 등록
    data-locations: classpath:sql/insert-companies.sql,classpath:sql/insert-job-posts.sql,classpath:sql/insert-job-post-ranking.sql

```
- `insert-companies.sql` : `COMPANIES` DB 테스트 정보
- `insert-job-posts.sql` : `JOB_POSTS` DB 테스트 정보
- `insert-job-post-ranking.sql` : `JOB_POST_RANKING` DB 테스트 정보 

---

### Table 정의
#### `COMPANIES` 기업 정보
|  Column  |   Type   | Nullable | Description |
|:--------:|:--------:|:--------:|-------------|
|    ID    |  NUMBER  |    N     | SEQ ID `PK` |
|   NAME   | VARCHAR2 |    N     | 기업명         |
| COUNTRY  | VARCHAR2 |    N     | 국가          |
| LOCALITY | VARCHAR2 |    Y     | 소재지         |
|  REGION  | VARCHAR2 |    Y     | 지역          |
| CREATED  |   DATE   |    N     | 생성 일자       |
| UPDATED  |   DATE   |    Y     | 수정 일자       |

#### `JOB_POSTS` 채용 공고 정보
|   Column   |   Type   | Nullable | Description                 |
|:----------:|:--------:|:--------:|-----------------------------|
|     ID     |  NUMBER  |    N     | SEQ ID `PK`                 |
| COMPANY_ID | VARCHAR2 |    N     | 기업 ID `FK` - `COMPANIES.ID` |
|  JOB_TYPE  | VARCHAR2 |    N     | 직무                          |
|  COUNTRY   | VARCHAR2 |    N     | 국가                          |
|  LOCALITY  | VARCHAR2 |    Y     | 소재지                         |
|   REGION   | VARCHAR2 |    Y     | 지역                          |
|   POSTED   |   DATE   |    N     | 공고 일자                       |
|  CREATED   |   DATE   |    N     | 생성 일자                       |
|  UPDATED   |   DATE   |    Y     | 수정 일자                       |

#### `JOB_POST_RANKING` 채용 공고 랭킹 정보
| Column  |   Type   | Nullable | Description                         |
|:-------:|:--------:|:--------:|-------------------------------------|
|   ID    |  NUMBER  |    N     | SEQ ID `PK`                         |
|  TYPE   | VARCHAR2 |    N     | 랭킹 구분<br>COMPANY: 기업<br>COUNTRY: 국가 |
| RANKER  | VARCHAR2 |    N     | 랭커 정보 (기업명 or 국가명)                  |
|  COUNT  |  NUMBER  |    N     | 공고 등록 수                             |
| CREATED |   DATE   |    N     | 생성 일자                               |
| UPDATED |   DATE   |    Y     | 수정 일자                               |

---

## API 문서 정의

### 기업 정보 등록 API
| 구분  | 정보                     |
|:---:|------------------------|
| 정의  | 기업 정보 등록 API           |
| URL | `POST /api/v1/company` |

#### Request
|      Field      |  Type  | MOC | Description |
|:---------------:|:------:|:---:|-------------|
|      name       | String |  M  | 기업명         |
|     locale      | Object |  O  | 위치 정보       |
| locale.country  | String |  O  | 국가          |
| locale.locality | String |  O  | 소재지         |
|  locale.region  | String |  O  | 지역          |

#### Response
| Field |  Type  | MOC | Description |
|:-----:|:------:|:---:|-------------|
|  id   | Number |  M  | 기업 ID       |

---

### 기업 목록 조회 API
| 구분  | 정보                       |
|:---:|--------------------------|
| 정의  | 기업 목록 조회 API             |
| URL | `POST /api/v1/companies` |

#### Request
|  Field   |  Type  | MOC | Description                        |
|:--------:|:------:|:---:|------------------------------------|
|  number  | Number |  O  | Page 번호                            | 
|   size   | Number |  O  | Page 크기                            |
| fromDate | String |  O  | 검색 시작 일자 (`yyyyMMdd`)              |
|  toDate  | String |  O  | 검색 종료 일자 (`yyyyMMdd`)              |
|  sortBy  | String |  O  | 정렬 기준 (default: `ID`)<br>ID: 기업 ID |
|  order   | String |  O  | 정렬 방향 (default: `DESC`)            |

#### Response
|          Field          |  Type   | MOC | Description |
|:-----------------------:|:-------:|:---:|-------------|
|         number          | Number  |  M  | Page 번호     | 
|          size           | Number  |  M  | Page 크기     |
|       totalPages        | Number  |  M  | 전체 Page 수   |
|      totalElements      | Number  |  M  | 전체 항목 수     |
|    numberOfElements     | Number  |  M  | Page 당 항목 수 |
|          first          | Boolean |  M  | 첫 Page 여부   |
|          last           | Boolean |  M  | 마지막 Page 여부 |
|         content         |  Array  |  M  | 기업 정보 목록    |
|       content.id        | Number  |  M  | 기업 ID       |
|      content.name       | String  |  M  | 기업명         |
|     content.locale      | Object  |  O  | 위치 정보       |
| content.locale.country  | String  |  O  | 국가          |
| content.locale.locality | String  |  O  | 소재지         |
|  content.locale.region  | String  |  O  | 지역          |

---

### 공고 정보 등록 API
| 구분  | 정보                      |
|:---:|-------------------------|
| 정의  | 채용 공고 등록 API            |
| URL | `POST /api/v1/job-post` |

#### Request
|      Field      |  Type  | MOC | Description |
|:---------------:|:------:|:---:|-------------|
|    companyId    | String |  M  | 기업 ID       |
|     jobType     | String |  M  | 직무          |
|     locale      | Object |  M  | 위치 정보       |
| locale.country  | String |  M  | 국가          |
| locale.locality | String |  O  | 소재지         |
|  locale.region  | String |  O  | 지역          |

#### Response
| Field |  Type  | MOC | Description |
|:-----:|:------:|:---:|-------------|
|  id   | Number |  M  | 공고 ID       |

---

### 공고 목록 검색 API
| 구분  | 정보                       |
|:---:|--------------------------|
| 정의  | 채용 공고 목록 조회 API          |
| URL | `POST /api/v1/job-posts` |

#### Request
|  Field   |  Type  | MOC | Description                                                                      |
|:--------:|:------:|:---:|----------------------------------------------------------------------------------|
|   text   | String |  M  | 검색 문자열                                                                           |
|  number  | Number |  O  | Page 번호                                                                          | 
|   size   | Number |  O  | Page 크기                                                                          |
| fromDate | String |  O  | 검색 시작 일자 (`yyyyMMdd`)                                                            |
|  toDate  | String |  O  | 검색 종료 일자 (`yyyyMMdd`)                                                            |
|  sortBy  | String |  O  | 정렬 기준 (default: `ID`)<br>ID: 공고 ID<br>COMPANY: 기업<br>JOB_TYPE: 직무<br>COUNTRY: 국가 |
|  order   | String |  O  | 정렬 방향 (default: `DESC`)                                                          |

#### Response
|        Field        |  Type   | MOC | Description |
|:-------------------:|:-------:|:---:|-------------|
|       number        | Number  |  M  | Page 번호     | 
|        size         | Number  |  M  | Page 크기     |
|     totalPages      | Number  |  M  | 전체 Page 수   |
|    totalElements    | Number  |  M  | 전체 항목 수     |
|  numberOfElements   | Number  |  M  | Page 당 항목 수 |
|        first        | Boolean |  M  | 첫 Page 여부   |
|        last         | Boolean |  M  | 마지막 Page 여부 |
|       content       |  Array  |  M  | 채용 공고 정보 목록 |
 |     content.id      | Number  |  M  | 공고 ID       |
 | content.companyName | String  |  M  | 기업명         |
 |   content.jobType   | String  |  M  | 직무          |
 |   content.locale    | String  |  M  | 위치          |
 |   content.posted    | String  |  M  | 공고 등록 일자    |

---

### 공고 랭킹 정보 조회 API
| 구분  | 정보                                                                   |
|:---:|----------------------------------------------------------------------|
| 정의  | 채용 공고 관련 랭킹 조회 API<br>- 공고가 가장 많은 회사 TOP 순위<br>- 공고가 가장 많은 국가 TOP 순위 |
| URL | `GET /api/v1/job-post/ranking?type={type}&limit={limit}`             |

#### Request
| Field |  Type  | MOC | Description                                                            |
|:-----:|:------:|:---:|------------------------------------------------------------------------|
| type  | String |  O  | 랭킹 조회 구분 (default- null: 전체)<br>COMPANY: 회사 기준 랭킹<br>COUNTRY: 국가 기준 랭킹 |
| limit | Number |  O  | 랭킹 목록 크기                                                               | 

#### Response
| Field  |  Type  | MOC | Description                                  |
|:------:|:------:|:---:|----------------------------------------------|
|  type  | String |  M  | 랭킹 조회 구분<br>COMPANY: 회사 랭킹<br>COUNTRY: 국가 랭킹 |
|  rank  | Number |  M  | 랭킹 순위                                        |
| ranker | String |  M  | 랭킹 정보                                        |
| count  | Number |  M  | 공고 등록 건수                                     |

---

## API 인증 설정
### CORS 설정
- 해당 프로젝트의 `CORS` 설정을 위해 Global Configuration 클래스 추가

#### SecurityConfig.java
```java
package me.jimmyberg.wanted.config;

@EnableWebSecurity
public class SecurityConfig {
    
    // ...
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // TODO CORS 설정 처리
        CorsConfiguration configuration = new CorsConfiguration();
        // 허용 origin 설정
        configuration.setAllowedOrigins(List.of("*"));
        // 허용 method 설정
        configuration.setAllowedMethods(List.of("*"));
        // 허용 header 설정
        configuration.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
    
}
```

---

### API 인증 
- API 인증 처리를 위해 별도 Filter 클래스 추가 및 `SecurityConfig` 등록
- 만약 API 인증을 위한 구현체를 개발한다면, `Username & Password` 기반 인증 or `JWT` 토큰 기반의 인증 구현체 추가 가능

#### AuthenticationFilter.java - 인증 처리 구현 Filter
```java
package me.jimmyberg.wanted.config.filter;

public class AuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
         * TODO 해당 Filter 에서 API 인증 처리
         * username & password 인증 or JWT 인증
         */
        chain.doFilter(request, response);
    }

}
```

#### SecurityConfig.java - Filter 등록
```java
package me.jimmyberg.wanted.config;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // ...
                // 인증 처리 Filter 등록
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
```
---
