DROP TABLE JOB_POSTINGS;

CREATE TABLE JOB_POSTINGS
(
    ID                     VARCHAR(64),
    URL                    VARCHAR(255),
    CREATED                VARCHAR(27),
    TITLE                  VARCHAR(255),
    DATE_POSTED            VARCHAR(27),
    EMPLOYMENT_TYPE        VARCHAR(50),
    ADDRESS_COUNTRY        VARCHAR(255),
    ADDRESS_LOCALITY       VARCHAR(255),
    ADDRESS_REGION         VARCHAR(255),
    ADDRESS                VARCHAR(255),
    NAME                   VARCHAR(255),
    SAME_AS                VARCHAR(255),
    LOGO                   VARCHAR(255),
    EDUCATION_REQUIREMENTS VARCHAR(255),
    CURRENCY               VARCHAR(5),
    COUNTRY_CODE           VARCHAR(5),
    COMPETENCY_REQUIRED    VARCHAR(255),
    PRIMARY KEY (ID)
);