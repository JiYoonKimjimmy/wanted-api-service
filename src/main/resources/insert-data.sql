insert into COMPANY (NAME, COUNTRY, LOCALITY, REGION, CREATED)
values ('원티드랩', 'Korea', 'Seoul', 'Songpa', parsedatetime('20221210093010', 'yyyyMMddHHmmss')),
       ('코나아이', 'United States', 'Seoul', 'Yeouido', parsedatetime('20221211103010', 'yyyyMMddHHmmss')),
       ('원티드', 'United Kingdom', 'Seoul', 'Songpa', parsedatetime('20221210093010', 'yyyyMMddHHmmss'));

insert into JOB_POSTS (COMPANY_ID, JOB_TYPE, COUNTRY, LOCALITY, REGION, CREATED)
values (1, '개발', 'Korea', 'Seoul', 'Songpa', parsedatetime('20221210093010', 'yyyyMMddHHmmss')),
       (1, '백엔드개발', 'Korea', 'Seoul', 'Songpa', parsedatetime('20221210093010', 'yyyyMMddHHmmss')),
       (1, '프론트엔드개발', 'Korea', 'Seoul', 'Songpa', parsedatetime('20221210093010', 'yyyyMMddHHmmss'));

insert into JOB_POSTS (COMPANY_ID, JOB_TYPE, COUNTRY, LOCALITY, REGION, CREATED)
values (2, '개발', 'United States', 'Seoul', 'Yeouido', parsedatetime('20221210093010', 'yyyyMMddHHmmss')),
       (2, '백엔드개발', 'United States', 'Seoul', 'Yeouido', parsedatetime('20221210093010', 'yyyyMMddHHmmss'));

insert into JOB_POSTS (COMPANY_ID, JOB_TYPE, COUNTRY, LOCALITY, REGION, CREATED)
values (3, '개발', 'United Kingdom', 'Seoul', 'Songpa', parsedatetime('20221210093010', 'yyyyMMddHHmmss'));
