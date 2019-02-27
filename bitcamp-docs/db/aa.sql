-- 게시물
DROP TABLE IF EXISTS post RESTRICT;

-- 사용자
DROP TABLE IF EXISTS user RESTRICT;

-- 프로젝트
DROP TABLE IF EXISTS prjt RESTRICT;

-- 주소
DROP TABLE IF EXISTS addr RESTRICT;

-- 기술
DROP TABLE IF EXISTS tech RESTRICT;

-- 성별
DROP TABLE IF EXISTS gender RESTRICT;

-- 학력
DROP TABLE IF EXISTS grade RESTRICT;

-- 프로젝트팀
DROP TABLE IF EXISTS prjt_tm RESTRICT;

-- 사용자프로젝트팀
DROP TABLE IF EXISTS usr_prjt_tm RESTRICT;

-- 게시판사진
DROP TABLE IF EXISTS bod_phot RESTRICT;

-- 첨부파일
DROP TABLE IF EXISTS file RESTRICT;

-- 프로젝트게시판
DROP TABLE IF EXISTS prjt_bod RESTRICT;

-- 직위
DROP TABLE IF EXISTS pos RESTRICT;

-- 사용자기술
DROP TABLE IF EXISTS usr_tech RESTRICT;

-- 진행
DROP TABLE IF EXISTS prog RESTRICT;

-- 댓글
DROP TABLE IF EXISTS cmts RESTRICT;

-- 게시물
CREATE TABLE post (
  post_id     INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
  user_id     INTEGER      NOT NULL COMMENT '작성자번호', -- 작성자번호
  prjt_bod_id INTEGER      NULL     COMMENT '프로젝트게시판번호', -- 프로젝트게시판번호
  cdt         DATETIME     NOT NULL COMMENT '생성일', -- 생성일
  vw_cnt      INTEGER      NOT NULL COMMENT '조회수', -- 조회수
  titl        VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  cont        TEXT         NOT NULL COMMENT '내용' -- 내용
)
COMMENT '게시물';

-- 게시물
ALTER TABLE post
  ADD CONSTRAINT PK_post -- 게시물 기본키
    PRIMARY KEY (
      post_id -- 게시물번호
    );

-- 게시물 인덱스
CREATE INDEX IX_post
  ON post( -- 게시물
    titl ASC -- 제목
  );

ALTER TABLE post
  MODIFY COLUMN post_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시물번호';

-- 사용자
CREATE TABLE user (
  user_id   INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  gender_id INTEGER      NOT NULL COMMENT '성별번호', -- 성별번호
  grade_id  INTEGER      NOT NULL COMMENT '최종학력번호', -- 최종학력번호
  addr_id   INTEGER      NULL     COMMENT '주소번호', -- 주소번호
  nm        VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  email     VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  tel       VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
  pwd       VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  phot      VARCHAR(255) NULL     COMMENT '사진', -- 사진
  mjr       VARCHAR(50)  NULL     COMMENT '전공', -- 전공
  det_addr  VARCHAR(255) NULL     COMMENT '상세주소' -- 상세주소
)
COMMENT '사용자';

-- 사용자
ALTER TABLE user
  ADD CONSTRAINT PK_user -- 사용자 기본키
    PRIMARY KEY (
      user_id -- 사용자번호
    );

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX UIX_user
  ON user ( -- 사용자
    email ASC -- 이메일
  );

-- 사용자 인덱스
CREATE INDEX IX_user
  ON user( -- 사용자
    nm ASC -- 이름
  );

ALTER TABLE user
  MODIFY COLUMN user_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용자번호';

-- 프로젝트
CREATE TABLE prjt (
  prjt_id    INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  prjt_tm_id INTEGER      NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  cdt        DATETIME     NOT NULL COMMENT '생성일', -- 생성일
  prjt_nm    VARCHAR(255) NOT NULL COMMENT '프로젝트명', -- 프로젝트명
  cont       TEXT         NOT NULL COMMENT '설명', -- 설명
  edt        DATETIME     NULL     COMMENT '종료일', -- 종료일
  prog_id    INTEGER      NULL     COMMENT '진행번호' -- 진행번호
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE prjt
  ADD CONSTRAINT PK_prjt -- 프로젝트 기본키
    PRIMARY KEY (
      prjt_id -- 프로젝트번호
    );

-- 프로젝트 유니크 인덱스
CREATE UNIQUE INDEX UIX_prjt
  ON prjt ( -- 프로젝트
    prjt_nm ASC -- 프로젝트명
  );

-- 프로젝트 인덱스
CREATE INDEX IX_prjt
  ON prjt( -- 프로젝트
    prjt_nm ASC -- 프로젝트명
  );

ALTER TABLE prjt
  MODIFY COLUMN prjt_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 주소
CREATE TABLE addr (
  addr_id  INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  pst_no   CHAR(5)      NOT NULL COMMENT '우편번호', -- 우편번호
  bas_addr VARCHAR(255) NOT NULL COMMENT '주소' -- 주소
)
COMMENT '주소';

-- 주소
ALTER TABLE addr
  ADD CONSTRAINT PK_addr -- 주소 기본키
    PRIMARY KEY (
      addr_id -- 주소번호
    );

ALTER TABLE addr
  MODIFY COLUMN addr_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 기술
CREATE TABLE tech (
  tech_id INTEGER     NOT NULL COMMENT '기술번호', -- 기술번호
  lang    VARCHAR(50) NOT NULL COMMENT '언어' -- 언어
)
COMMENT '기술';

-- 기술
ALTER TABLE tech
  ADD CONSTRAINT PK_tech -- 기술 기본키
    PRIMARY KEY (
      tech_id -- 기술번호
    );

-- 기술 유니크 인덱스
CREATE UNIQUE INDEX UIX_tech
  ON tech ( -- 기술
    lang ASC -- 언어
  );

-- 성별
CREATE TABLE gender (
  gender_id INTEGER NOT NULL COMMENT '성별번호', -- 성별번호
  gender    CHAR(1) NOT NULL COMMENT '성별' -- 성별
)
COMMENT '성별';

-- 성별
ALTER TABLE gender
  ADD CONSTRAINT PK_gender -- 성별 기본키
    PRIMARY KEY (
      gender_id -- 성별번호
    );

-- 성별 유니크 인덱스
CREATE UNIQUE INDEX UIX_gender
  ON gender ( -- 성별
    gender ASC -- 성별
  );

ALTER TABLE gender
  MODIFY COLUMN gender_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '성별번호';

-- 학력
CREATE TABLE grade (
  grade_id INTEGER     NOT NULL COMMENT '학력번호', -- 학력번호
  nm       VARCHAR(50) NOT NULL COMMENT '학력명' -- 학력명
)
COMMENT '학력';

-- 학력
ALTER TABLE grade
  ADD CONSTRAINT PK_grade -- 학력 기본키
    PRIMARY KEY (
      grade_id -- 학력번호
    );

-- 학력 유니크 인덱스
CREATE UNIQUE INDEX UIX_grade
  ON grade ( -- 학력
    nm ASC -- 학력명
  );

ALTER TABLE grade
  MODIFY COLUMN grade_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '학력번호';

-- 프로젝트팀
CREATE TABLE prjt_tm (
  prjt_tm_id INTEGER     NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  tm_nm      VARCHAR(50) NOT NULL COMMENT '팀명' -- 팀명
)
COMMENT '프로젝트팀';

-- 프로젝트팀
ALTER TABLE prjt_tm
  ADD CONSTRAINT PK_prjt_tm -- 프로젝트팀 기본키
    PRIMARY KEY (
      prjt_tm_id -- 프로젝트팀번호
    );

-- 프로젝트팀 유니크 인덱스
CREATE UNIQUE INDEX UIX_prjt_tm
  ON prjt_tm ( -- 프로젝트팀
    tm_nm ASC -- 팀명
  );

ALTER TABLE prjt_tm
  MODIFY COLUMN prjt_tm_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트팀번호';

-- 사용자프로젝트팀
CREATE TABLE usr_prjt_tm (
  prjt_tm_id INTEGER NOT NULL COMMENT '프로젝트팀번호', -- 프로젝트팀번호
  user_id    INTEGER NOT NULL COMMENT '사용자번호', -- 사용자번호
  pos_id     INTEGER NOT NULL COMMENT '직위번호' -- 직위번호
)
COMMENT '사용자프로젝트팀';

-- 사용자프로젝트팀
ALTER TABLE usr_prjt_tm
  ADD CONSTRAINT PK_usr_prjt_tm -- 사용자프로젝트팀 기본키
    PRIMARY KEY (
      prjt_tm_id, -- 프로젝트팀번호
      user_id     -- 사용자번호
    );

-- 게시판사진
CREATE TABLE bod_phot (
  bod_phot_id INTEGER      NOT NULL COMMENT '게시판사진번호', -- 게시판사진번호
  post_id     INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
  phot        VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '게시판사진';

-- 게시판사진
ALTER TABLE bod_phot
  ADD CONSTRAINT PK_bod_phot -- 게시판사진 기본키
    PRIMARY KEY (
      bod_phot_id -- 게시판사진번호
    );

ALTER TABLE bod_phot
  MODIFY COLUMN bod_phot_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시판사진번호';

-- 첨부파일
CREATE TABLE file (
  file_id INTEGER      NOT NULL COMMENT '첨부파일번호', -- 첨부파일번호
  post_id INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
  file    VARCHAR(255) NOT NULL COMMENT '첨부파일' -- 첨부파일
)
COMMENT '첨부파일';

-- 첨부파일
ALTER TABLE file
  ADD CONSTRAINT PK_file -- 첨부파일 기본키
    PRIMARY KEY (
      file_id -- 첨부파일번호
    );

ALTER TABLE file
  MODIFY COLUMN file_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '첨부파일번호';

-- 프로젝트게시판
CREATE TABLE prjt_bod (
  prjt_bod_id INTEGER     NOT NULL COMMENT '프로젝트게시판번호', -- 프로젝트게시판번호
  prjt_id     INTEGER     NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  bod_nm      VARCHAR(50) NOT NULL COMMENT '게시판명' -- 게시판명
)
COMMENT '프로젝트게시판';

-- 프로젝트게시판
ALTER TABLE prjt_bod
  ADD CONSTRAINT PK_prjt_bod -- 프로젝트게시판 기본키
    PRIMARY KEY (
      prjt_bod_id -- 프로젝트게시판번호
    );

ALTER TABLE prjt_bod
  MODIFY COLUMN prjt_bod_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트게시판번호';

-- 직위
CREATE TABLE pos (
  pos_id INTEGER     NOT NULL COMMENT '직위번호', -- 직위번호
  pos    VARCHAR(50) NOT NULL COMMENT '직위' -- 직위
)
COMMENT '직위';

-- 직위
ALTER TABLE pos
  ADD CONSTRAINT PK_pos -- 직위 기본키
    PRIMARY KEY (
      pos_id -- 직위번호
    );

-- 직위 유니크 인덱스
CREATE UNIQUE INDEX UIX_pos
  ON pos ( -- 직위
    pos ASC -- 직위
  );

ALTER TABLE pos
  MODIFY COLUMN pos_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '직위번호';

-- 사용자기술
CREATE TABLE usr_tech (
  user_id INTEGER NOT NULL COMMENT '사용자번호', -- 사용자번호
  tech_id INTEGER NOT NULL COMMENT '기술번호' -- 기술번호
)
COMMENT '사용자기술';

-- 사용자기술
ALTER TABLE usr_tech
  ADD CONSTRAINT PK_usr_tech -- 사용자기술 기본키
    PRIMARY KEY (
      user_id, -- 사용자번호
      tech_id  -- 기술번호
    );

-- 진행
CREATE TABLE prog (
  prog_id INTEGER     NOT NULL COMMENT '진행번호', -- 진행번호
  prog    VARCHAR(50) NULL     COMMENT '진행여부' -- 진행여부
)
COMMENT '진행';

-- 진행
ALTER TABLE prog
  ADD CONSTRAINT PK_prog -- 진행 기본키
    PRIMARY KEY (
      prog_id -- 진행번호
    );

ALTER TABLE prog
  MODIFY COLUMN prog_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '진행번호';

-- 댓글
CREATE TABLE cmts (
  cmts_id INTEGER NOT NULL COMMENT '댓글번호', -- 댓글번호
  post_id INTEGER NULL     COMMENT '게시물번호', -- 게시물번호
  cmts    TEXT    NULL     COMMENT '댓글' -- 댓글
)
COMMENT '댓글';

-- 댓글
ALTER TABLE cmts
  ADD CONSTRAINT PK_cmts -- 댓글 기본키
    PRIMARY KEY (
      cmts_id -- 댓글번호
    );

-- 게시물
ALTER TABLE post
  ADD CONSTRAINT FK_user_TO_post -- 사용자 -> 게시물
    FOREIGN KEY (
      user_id -- 작성자번호
    )
    REFERENCES user ( -- 사용자
      user_id -- 사용자번호
    );

-- 게시물
ALTER TABLE post
  ADD CONSTRAINT FK_prjt_bod_TO_post -- 프로젝트게시판 -> 게시물
    FOREIGN KEY (
      prjt_bod_id -- 프로젝트게시판번호
    )
    REFERENCES prjt_bod ( -- 프로젝트게시판
      prjt_bod_id -- 프로젝트게시판번호
    );

-- 사용자
ALTER TABLE user
  ADD CONSTRAINT FK_addr_TO_user -- 주소 -> 사용자
    FOREIGN KEY (
      addr_id -- 주소번호
    )
    REFERENCES addr ( -- 주소
      addr_id -- 주소번호
    );

-- 사용자
ALTER TABLE user
  ADD CONSTRAINT FK_gender_TO_user -- 성별 -> 사용자
    FOREIGN KEY (
      gender_id -- 성별번호
    )
    REFERENCES gender ( -- 성별
      gender_id -- 성별번호
    );

-- 사용자
ALTER TABLE user
  ADD CONSTRAINT FK_grade_TO_user -- 학력 -> 사용자
    FOREIGN KEY (
      grade_id -- 최종학력번호
    )
    REFERENCES grade ( -- 학력
      grade_id -- 학력번호
    );

-- 프로젝트
ALTER TABLE prjt
  ADD CONSTRAINT FK_prjt_tm_TO_prjt -- 프로젝트팀 -> 프로젝트
    FOREIGN KEY (
      prjt_tm_id -- 프로젝트팀번호
    )
    REFERENCES prjt_tm ( -- 프로젝트팀
      prjt_tm_id -- 프로젝트팀번호
    );

-- 프로젝트
ALTER TABLE prjt
  ADD CONSTRAINT FK_prog_TO_prjt -- 진행 -> 프로젝트
    FOREIGN KEY (
      prog_id -- 진행번호
    )
    REFERENCES prog ( -- 진행
      prog_id -- 진행번호
    );

-- 사용자프로젝트팀
ALTER TABLE usr_prjt_tm
  ADD CONSTRAINT FK_prjt_tm_TO_usr_prjt_tm -- 프로젝트팀 -> 사용자프로젝트팀
    FOREIGN KEY (
      prjt_tm_id -- 프로젝트팀번호
    )
    REFERENCES prjt_tm ( -- 프로젝트팀
      prjt_tm_id -- 프로젝트팀번호
    );

-- 사용자프로젝트팀
ALTER TABLE usr_prjt_tm
  ADD CONSTRAINT FK_user_TO_usr_prjt_tm -- 사용자 -> 사용자프로젝트팀
    FOREIGN KEY (
      user_id -- 사용자번호
    )
    REFERENCES user ( -- 사용자
      user_id -- 사용자번호
    );

-- 사용자프로젝트팀
ALTER TABLE usr_prjt_tm
  ADD CONSTRAINT FK_pos_TO_usr_prjt_tm -- 직위 -> 사용자프로젝트팀
    FOREIGN KEY (
      pos_id -- 직위번호
    )
    REFERENCES pos ( -- 직위
      pos_id -- 직위번호
    );

-- 게시판사진
ALTER TABLE bod_phot
  ADD CONSTRAINT FK_post_TO_bod_phot -- 게시물 -> 게시판사진
    FOREIGN KEY (
      post_id -- 게시물번호
    )
    REFERENCES post ( -- 게시물
      post_id -- 게시물번호
    );

-- 첨부파일
ALTER TABLE file
  ADD CONSTRAINT FK_post_TO_file -- 게시물 -> 첨부파일
    FOREIGN KEY (
      post_id -- 게시물번호
    )
    REFERENCES post ( -- 게시물
      post_id -- 게시물번호
    );

-- 프로젝트게시판
ALTER TABLE prjt_bod
  ADD CONSTRAINT FK_prjt_TO_prjt_bod -- 프로젝트 -> 프로젝트게시판
    FOREIGN KEY (
      prjt_id -- 프로젝트번호
    )
    REFERENCES prjt ( -- 프로젝트
      prjt_id -- 프로젝트번호
    );

-- 사용자기술
ALTER TABLE usr_tech
  ADD CONSTRAINT FK_user_TO_usr_tech -- 사용자 -> 사용자기술
    FOREIGN KEY (
      user_id -- 사용자번호
    )
    REFERENCES user ( -- 사용자
      user_id -- 사용자번호
    );

-- 사용자기술
ALTER TABLE usr_tech
  ADD CONSTRAINT FK_tech_TO_usr_tech -- 기술 -> 사용자기술
    FOREIGN KEY (
      tech_id -- 기술번호
    )
    REFERENCES tech ( -- 기술
      tech_id -- 기술번호
    );

-- 댓글
ALTER TABLE cmts
  ADD CONSTRAINT FK_post_TO_cmts -- 게시물 -> 댓글
    FOREIGN KEY (
      post_id -- 게시물번호
    )
    REFERENCES post ( -- 게시물
      post_id -- 게시물번호
    );