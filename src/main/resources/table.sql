create table word (
    word_id int auto_increment not null,
    word varchar(50) not null,
    meaning varchar(50) not null,
    difficulty int not null,
    primary key(word_id)
);


create table member (
    user_id int auto_increment not null,
    email varchar(50) not null,
    password varchar(100) not null,
    nickname varchar(30) not null,
    phone varchar(20),
    create_date timestamp,
    use_yn int,
    primary key(user_id)
);

create table subscription (
    subscription_id int auto_increment not null,
    user_id int not null,
    pass_id int not null,
    difficulty int,
    start_date timestamp,
    end_date timestamp,
    primary key(subscription_id)
);

create table pass (
    pass_id int auto_increment not null,
    name varchar(50) not null,
    price int,
    primary key(pass_id)
);

create table payment (
    tid varchar(100) not null,
    order_id varchar(100) not null,
    user_id int not null,
    pass_id int not null,
    succ_yn int,
    primary key(tid)
);

insert into payment (tid, order_id, user_id, pass_id, succ_yn) values ('adiwadwaj','doijqodo', 1, 1, null);

insert into subscription (user_id, pass_id, difficulty, start_date) values (1, 1, 1, now());

insert into pass (name, price) values ('매일 영어 단어(기본)', 0);
insert into pass (name, price) values ('매일 영어 단어(프로)', 10000);

insert into word (word, meaning, difficulty) values ('apple', '사과', 1);
insert into word (word, meaning, difficulty) values ('book', '책', 1);
insert into word (word, meaning, difficulty) values ('cat', '고양이', 1);
insert into word (word, meaning, difficulty) values ('dog', '개', 1);
insert into word (word, meaning, difficulty) values ('elephant', '코끼리', 1);
insert into word (word, meaning, difficulty) values ('fish', '물고기', 1);
insert into word (word, meaning, difficulty) values ('grape', '포도', 1);
insert into word (word, meaning, difficulty) values ('hat', '모자', 1);
insert into word (word, meaning, difficulty) values ('ice', '얼음', 1);
insert into word (word, meaning, difficulty) values ('juice', '주스', 1);
insert into word (word, meaning, difficulty) values ('kite', '연', 1);
insert into word (word, meaning, difficulty) values ('lion', '사자', 1);
insert into word (word, meaning, difficulty) values ('monkey', '원숭이', 1);
insert into word (word, meaning, difficulty) values ('nose', '코', 1);
insert into word (word, meaning, difficulty) values ('orange', '오렌지', 1);
insert into word (word, meaning, difficulty) values ('pencil', '연필', 1);
insert into word (word, meaning, difficulty) values ('queen', '여왕', 1);
insert into word (word, meaning, difficulty) values ('rabbit', '토끼', 1);
insert into word (word, meaning, difficulty) values ('sun', '태양', 1);
insert into word (word, meaning, difficulty) values ('tree', '나무', 1);
insert into word (word, meaning, difficulty) values ('umbrella', '우산', 1);
insert into word (word, meaning, difficulty) values ('vase', '꽃병', 1);
insert into word (word, meaning, difficulty) values ('water', '물', 1);
insert into word (word, meaning, difficulty) values ('x-ray', '엑스레이', 1);
insert into word (word, meaning, difficulty) values ('yogurt', '요거트', 1);
insert into word (word, meaning, difficulty) values ('zebra', '얼룩말', 1);
insert into word (word, meaning, difficulty) values ('ball', '공', 1);
insert into word (word, meaning, difficulty) values ('car', '자동차', 1);
insert into word (word, meaning, difficulty) values ('door', '문', 1);
insert into word (word, meaning, difficulty) values ('ear', '귀', 1);
insert into word (word, meaning, difficulty) values ('frog', '개구리', 1);
insert into word (word, meaning, difficulty) values ('giraffe', '기린', 1);
insert into word (word, meaning, difficulty) values ('house', '집', 1);
insert into word (word, meaning, difficulty) values ('island', '섬', 1);
insert into word (word, meaning, difficulty) values ('jacket', '재킷', 1);
insert into word (word, meaning, difficulty) values ('king', '왕', 1);
insert into word (word, meaning, difficulty) values ('lamp', '램프', 1);
insert into word (word, meaning, difficulty) values ('mouse', '쥐', 1);
insert into word (word, meaning, difficulty) values ('night', '밤', 1);
insert into word (word, meaning, difficulty) values ('ocean', '바다', 1);
insert into word (word, meaning, difficulty) values ('pig', '돼지', 1);
insert into word (word, meaning, difficulty) values ('question', '질문', 1);
insert into word (word, meaning, difficulty) values ('rose', '장미', 1);
insert into word (word, meaning, difficulty) values ('star', '별', 1);
insert into word (word, meaning, difficulty) values ('tiger', '호랑이', 1);
insert into word (word, meaning, difficulty) values ('umbrella', '우산', 1);
insert into word (word, meaning, difficulty) values ('violin', '바이올린', 1);
insert into word (word, meaning, difficulty) values ('window', '창문', 1);
insert into word (word, meaning, difficulty) values ('xylophone', '실로폰', 1);
insert into word (word, meaning, difficulty) values ('abandon', '버리다', 2);
insert into word (word, meaning, difficulty) values ('bargain', '흥정', 2);
insert into word (word, meaning, difficulty) values ('capacity', '수용력', 2);
insert into word (word, meaning, difficulty) values ('deceive', '속이다', 2);
insert into word (word, meaning, difficulty) values ('economy', '경제', 2);
insert into word (word, meaning, difficulty) values ('fascinate', '매혹하다', 2);
insert into word (word, meaning, difficulty) values ('generous', '관대한', 2);
insert into word (word, meaning, difficulty) values ('hesitate', '망설이다', 2);
insert into word (word, meaning, difficulty) values ('illustrate', '설명하다', 2);
insert into word (word, meaning, difficulty) values ('jeopardy', '위험', 2);
insert into word (word, meaning, difficulty) values ('keen', '열망하는', 2);
insert into word (word, meaning, difficulty) values ('liberate', '해방하다', 2);
insert into word (word, meaning, difficulty) values ('magnitude', '규모', 2);
insert into word (word, meaning, difficulty) values ('narrate', '이야기하다', 2);
insert into word (word, meaning, difficulty) values ('obstacle', '장애물', 2);
insert into word (word, meaning, difficulty) values ('perceive', '인지하다', 2);
insert into word (word, meaning, difficulty) values ('quarantine', '격리', 2);
insert into word (word, meaning, difficulty) values ('reliable', '신뢰할 수 있는', 2);
insert into word (word, meaning, difficulty) values ('sacrifice', '희생', 2);
insert into word (word, meaning, difficulty) values ('tendency', '경향', 2);
insert into word (word, meaning, difficulty) values ('ultimate', '궁극적인', 2);
insert into word (word, meaning, difficulty) values ('vacant', '비어 있는', 2);
insert into word (word, meaning, difficulty) values ('witness', '목격자', 2);
insert into word (word, meaning, difficulty) values ('yawn', '하품하다', 2);
insert into word (word, meaning, difficulty) values ('zealous', '열성적인', 2);
insert into word (word, meaning, difficulty) values ('advocate', '옹호하다', 2);
insert into word (word, meaning, difficulty) values ('barrier', '장벽', 2);
insert into word (word, meaning, difficulty) values ('compromise', '타협하다', 2);
insert into word (word, meaning, difficulty) values ('dedicate', '헌신하다', 2);
insert into word (word, meaning, difficulty) values ('endeavor', '노력하다', 2);
insert into word (word, meaning, difficulty) values ('fluctuate', '변동하다', 2);
insert into word (word, meaning, difficulty) values ('gratitude', '감사', 2);
insert into word (word, meaning, difficulty) values ('hypothesis', '가설', 2);
insert into word (word, meaning, difficulty) values ('innovate', '혁신하다', 2);
insert into word (word, meaning, difficulty) values ('justify', '정당화하다', 2);
insert into word (word, meaning, difficulty) values ('knack', '요령', 2);
insert into word (word, meaning, difficulty) values ('liability', '책임', 2);
insert into word (word, meaning, difficulty) values ('manifest', '명백한', 2);
insert into word (word, meaning, difficulty) values ('notorious', '악명 높은', 2);
insert into word (word, meaning, difficulty) values ('obscure', '모호한', 2);
insert into word (word, meaning, difficulty) values ('prudent', '신중한', 2);
insert into word (word, meaning, difficulty) values ('quench', '갈증을 해소하다', 2);
insert into word (word, meaning, difficulty) values ('resilient', '탄력 있는', 2);
insert into word (word, meaning, difficulty) values ('scrutinize', '면밀히 조사하다', 2);
insert into word (word, meaning, difficulty) values ('transform', '변형하다', 2);
insert into word (word, meaning, difficulty) values ('undermine', '약화시키다', 2);
insert into word (word, meaning, difficulty) values ('venerate', '존경하다', 2);
insert into word (word, meaning, difficulty) values ('withdraw', '철회하다', 2);
insert into word (word, meaning, difficulty) values ('yearn', '갈망하다', 2);
insert into word (word, meaning, difficulty) values ('zenith', '정점', 2);
insert into word (word, meaning, difficulty) values ('aberration', '탈선', 3);
insert into word (word, meaning, difficulty) values ('belligerent', '호전적인', 3);
insert into word (word, meaning, difficulty) values ('camaraderie', '우정', 3);
insert into word (word, meaning, difficulty) values ('deleterious', '해로운', 3);
insert into word (word, meaning, difficulty) values ('ephemeral', '일시적인', 3);
insert into word (word, meaning, difficulty) values ('fortuitous', '우연한', 3);
insert into word (word, meaning, difficulty) values ('gregarious', '사교적인', 3);
insert into word (word, meaning, difficulty) values ('hackneyed', '진부한', 3);
insert into word (word, meaning, difficulty) values ('iconoclast', '우상 파괴자', 3);
insert into word (word, meaning, difficulty) values ('juxtapose', '병렬하다', 3);
insert into word (word, meaning, difficulty) values ('kaleidoscope', '만화경', 3);
insert into word (word, meaning, difficulty) values ('lucid', '명료한', 3);
insert into word (word, meaning, difficulty) values ('mendacious', '거짓의', 3);
insert into word (word, meaning, difficulty) values ('nefarious', '악질의', 3);
insert into word (word, meaning, difficulty) values ('obfuscate', '혼란시키다', 3);
insert into word (word, meaning, difficulty) values ('palpable', '명백한', 3);
insert into word (word, meaning, difficulty) values ('quintessential', '전형적인', 3);
insert into word (word, meaning, difficulty) values ('recalcitrant', '저항하는', 3);
insert into word (word, meaning, difficulty) values ('sagacious', '현명한', 3);
insert into word (word, meaning, difficulty) values ('taciturn', '말없는', 3);
insert into word (word, meaning, difficulty) values ('ubiquitous', '편재하는', 3);
insert into word (word, meaning, difficulty) values ('voracious', '열렬히 탐하는', 3);
insert into word (word, meaning, difficulty) values ('wanton', '무자비한', 3);
insert into word (word, meaning, difficulty) values ('xenophobia', '외국인 혐오', 3);
insert into word (word, meaning, difficulty) values ('yoke', '멍에', 3);
insert into word (word, meaning, difficulty) values ('zealot', '광신자', 3);
insert into word (word, meaning, difficulty) values ('anomaly', '변칙', 3);
insert into word (word, meaning, difficulty) values ('brevity', '간결함', 3);
insert into word (word, meaning, difficulty) values ('circumspect', '신중한', 3);
insert into word (word, meaning, difficulty) values ('dichotomy', '이분법', 3);
insert into word (word, meaning, difficulty) values ('eclectic', '다양한', 3);
insert into word (word, meaning, difficulty) values ('fervent', '열렬한', 3);
insert into word (word, meaning, difficulty) values ('guile', '교활함', 3);
insert into word (word, meaning, difficulty) values ('harbinger', '전조', 3);
insert into word (word, meaning, difficulty) values ('immutable', '변하지 않는', 3);
insert into word (word, meaning, difficulty) values ('juxtaposition', '병치', 3);
insert into word (word, meaning, difficulty) values ('knavery', '부정행위', 3);
insert into word (word, meaning, difficulty) values ('laconic', '간결한', 3);
insert into word (word, meaning, difficulty) values ('munificent', '아낌없이 주는', 3);
insert into word (word, meaning, difficulty) values ('nonchalant', '무관심한', 3);
insert into word (word, meaning, difficulty) values ('ostracize', '배척하다', 3);
insert into word (word, meaning, difficulty) values ('paucity', '부족', 3);
insert into word (word, meaning, difficulty) values ('quandary', '곤경', 3);
insert into word (word, meaning, difficulty) values ('reprobate', '타락한 사람', 3);
insert into word (word, meaning, difficulty) values ('scintillate', '번쩍이다', 3);
insert into word (word, meaning, difficulty) values ('trenchant', '신랄한', 3);
insert into word (word, meaning, difficulty) values ('unscathed', '다치지 않은', 3);
insert into word (word, meaning, difficulty) values ('vex', '짜증나게 하다', 3);
insert into word (word, meaning, difficulty) values ('wry', '비꼬는', 3);
insert into word (word, meaning, difficulty) values ('xenial', '친절한', 3);
insert into word (word, meaning, difficulty) values ('yore', '옛날', 3);
insert into word (word, meaning, difficulty) values ('zephyr', '산들바람', 3);

insert into member(email, password, nickname, phone, create_date, use_yn) values ('disking12@naver.com', '1234', 'disking12', '01030842045', now(), 1);
