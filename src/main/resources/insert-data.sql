INSERT INTO COMPANY (NAME, COUNTRY, LOCALITY, REGION, CREATED)
VALUES ('원티드랩', 'Korea', 'Seoul', 'Songpa', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss')),
       ('원티드 US', 'United States', 'New York', null, PARSEDATETIME('20221211103010', 'yyyyMMddHHmmss')),
       ('원티드 UK', 'United Kingdom', 'London', 'London', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss')),
       ('코나아이', 'Korea', 'Seoul', 'Yeouido', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'));

INSERT INTO JOB_POSTS (COMPANY_ID, JOB_TYPE, COUNTRY, LOCALITY, REGION, POSTED, CREATED)
VALUES (1, '개발', 'Korea', 'Seoul', 'Songpa', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW()),
       (1, '백엔드개발', 'Korea', 'Seoul', 'Songpa', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW()),
       (1, '백엔드개발', 'Korea', null, 'Songpa', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW()),
       (1, '백엔드개발', null, null, 'Songpa', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW()),
       (1, '프론트엔드개발', 'Korea', 'Seoul', 'Songpa', PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW());

INSERT INTO JOB_POSTS (COMPANY_ID, JOB_TYPE, COUNTRY, LOCALITY, REGION, POSTED, CREATED)
VALUES (2, '개발', 'United States', 'New York', null, PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW()),
       (2, '백엔드개발', 'United States', 'New York', null, PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW()),
       (2, '프론트엔드개발', 'United States', 'New York', null, PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW());

INSERT INTO JOB_POSTS (COMPANY_ID, JOB_TYPE, COUNTRY, LOCALITY, REGION, POSTED, CREATED)
VALUES (3, '개발', 'United Kingdom', 'London', null, PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW()),
       (3, '개발', 'United Kingdom', 'London', null, PARSEDATETIME('20221210093010', 'yyyyMMddHHmmss'), NOW());
