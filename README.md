# 원티드 채용 공고 검색 API

## 목적
- 채용 공고 목록 검색하는 API 서비스
- 공고 랭킹 조회 API 서비스 제공

---

## 프로젝트 구성
- Java 11
- Spring Boot 2.7.6
- Spring Data JPA
- QueryDSL
- H2 Database (Embedded)
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

## API Server 정보

### Server 정보
|      구분      | 정보                                                  |
|:------------:|-----------------------------------------------------|
|     Port     | `10010`                                             |
| Context-Path | `wanted`                                            |
| Swagger URL  | http://localhost:10010/wanted/swagger-ui/index.html |

### API 테스트 방법
1. `Swagger-ui` 이용
   - [http://localhost:10010/wanted/swagger-ui/index.html](http://localhost:10010/wanted/swagger-ui/index.html)
2. `IntelliJ .http` 이용
   - `/http/wanted-api-test.http` 파일의 `request` 활용하여 API 테스트 요청  

---

## API 문서 정의

### 공고 등록 API
| 구분  | 정보                  |
|:---:|---------------------|
| 정의  | 채용 공고 등록 API        |
| URL | `POST /api/v1/post` |
#### Request
|      Field      |  Type  | MOC | Description |
|:---------------:|:------:|:---:|-------------|
|     company     | String |  M  | 기업명         |
|     jobType     | String |  M  | 직무          |
|     country     | String |  M  | 국가명         |
|     locale      | Object |  O  | 위치 정보       |
| locale.country  | String |  O  | 국가          |
| locale.locality | String |  O  | 소재지         |
|  locale.region  | String |  O  | 지역          |

---

### 공고 검색 API
| 구분  | 정보                   |
|:---:|----------------------|
| 정의  | 채용 공고 목록 조회 API      |
| URL | `POST /api/v1/posts` |

#### Request
|      Field      |  Type  | MOC | Description                                                 |
|:---------------:|:------:|:---:|-------------------------------------------------------------|
|      text       | String |  M  | 검색 문자열                                                      |
|      type       | String |  O  | 검색 구분<br>companyName: 기업명<br>jobType: 직무<br>country: 국가<br> |
|    fromDate     | String |  O  | 검색 시작 일자                                                    |
|     toDate      | String |  O  | 검색 종료 일자                                                    |
|    pageable     | Object |  O  | Page 정보                                                     |
| pageable.number | Number |  O  | Page 번호                                                     | 
|  pageable.size  | Number |  O  | Page 크기                                                     |

#### Response
|      Field      |  Type  | MOC | Description |
|:---------------:|:------:|:---:|-------------|
|       id        | Number |  M  | 공고 ID       |
|   companyName   | String |  M  | 기업명         |
|     jobType     | String |  M  | 직무          |
|     country     | String |  M  | 국가          |
|   publishDate   |  Date  |  M  | 공고 게재일      |
|    pageable     | Object |  M  | Page 정보     |
| pageable.number | Number |  M  | Page 번호     | 
|  pageable.size  | Number |  M  | Page 크기     |

---

### 공고 랭킹 조회 API
| 구분  | 정보                                                                 |
|:---:|--------------------------------------------------------------------|
| 정의  | 채용 공고 관련 랭킹 조회 API<br>- 공고가 가장 많은 회사 TOP 3<br>- 공고가 가장 많은 국가 TOP 3 |
| URL | `GET /api/v1/posts/ranking/{type}`                                 |

#### Request
| Field |  Type  | MOC | Description                                                |
|:-----:|:------:|:---:|------------------------------------------------------------|
| type  | String |  O  | 랭킹 조회 구분 (default: 전체)<br>COMPANY: 회사 랭킹<br>COUNTRY: 국가 랭킹 | 

#### Response
|  Field  |  Type  | MOC | Description                                  |
|:-------:|:------:|:---:|----------------------------------------------|
|  type   | String |  M  | 랭킹 조회 구분<br>COMPANY: 회사 랭킹<br>COUNTRY: 국가 랭킹 |
| ranking | Number |  M  | 랭킹                                           |
| ranker  | String |  M  | 랭킹 정보                                        |

---
